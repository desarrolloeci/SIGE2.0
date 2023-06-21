// Copyright (c) Microsoft Corporation.
// All rights reserved.
//
// This code is licensed under the MIT License.
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files(the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and / or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions :
//
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.
package com.microsoft.aad.adal4jsample;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.microsoft.aad.adal4j.*;
import static com.microsoft.aad.adal4jsample.BasicFilter.FAILED_TO_VALIDATE_MESSAGE;
import static com.microsoft.aad.adal4jsample.BasicFilter.STATE;
import static com.microsoft.aad.adal4jsample.BasicFilter.STATES;
import static com.microsoft.aad.adal4jsample.BasicFilter.STATE_TTL;
import com.nimbusds.oauth2.sdk.AuthorizationCode;
import com.nimbusds.openid.connect.sdk.AuthenticationResponse;
import com.nimbusds.openid.connect.sdk.AuthenticationResponseParser;
import com.nimbusds.openid.connect.sdk.AuthenticationSuccessResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.ServiceUnavailableException;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AadController {

    private String clientId = "af94a9ef-fef5-4abb-b06c-427971ec749e";
    private String clientSecret = "YFK8Q~Vmx~VcPEwojoXJwQDsy08i1ZlyY4YGYdf4";
    private String tenant = "pruebacorreoescuelaingeduco.onmicrosoft.com";
    private String authority = "https://login.microsoftonline.com/";

    @Autowired
    ServletContext servletContext;

    private void setUserInfoAndTenant(ModelMap model, AuthenticationResult authenticationResult, HttpSession session) {
        String tenant = session.getServletContext().getInitParameter("tenant");
        model.addAttribute("tenant", tenant);
        model.addAttribute("userInfo", authenticationResult.getUserInfo());
    }

    @RequestMapping("/loginDec")
    public String getDirectoryObjects(ModelMap model, HttpServletRequest httpRequest, HttpServletResponse response) throws IOException {
        String currentUri = httpRequest.getRequestURL().toString();
// use state parameter to validate response from Authorization server
        String state = UUID.randomUUID().toString();

        // use nonce parameter to validate idToken
        String nonce = UUID.randomUUID().toString();
        if (!AuthHelper.containsAuthenticationData(httpRequest)) {
            String url = "https://login.microsoftonline.com/pruebacorreoescuelaingeduco.onmicrosoft.com/oauth2/authorize?response_type=code&response_mode=form_post&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2FSIGE2.0-war%2FloginDec&client_id=af94a9ef-fef5-4abb-b06c-427971ec749e&resource=https%3a%2f%2fgraph.windows.net&state=d36be985-02a5-48ea-8bb2-7aa01f070f45&nonce=84648f19-f26c-492e-84d1-14298e2d4dc5\"";

            String redirectUrl = authority + this.tenant + "/oauth2/authorize?"
                    + "response_type=code&"
                    + "response_mode=form_post&"
                    + "redirect_uri=" + URLEncoder.encode(currentUri, "UTF-8")
                    + "&client_id=" + clientId
                    + "&resource=https%3a%2f%2fgraph.windows.net"
                    + (StringUtils.isEmpty(httpRequest.getParameter("claims")) ? "" : "&claims=" + httpRequest.getParameter("claims"))
                    + "&state=" + state
                    + "&nonce=" + nonce;

            response.sendRedirect(redirectUrl);
        } else {

            String queryStr = httpRequest.getQueryString();
            String fullUrl = currentUri + (queryStr != null ? "?" + queryStr : "");
            HttpSession session = httpRequest.getSession();
            HashMap<String, String> params = new HashMap<>();
            for (String key : httpRequest.getParameterMap().keySet()) {
                params.put(key, httpRequest.getParameterMap().get(key)[0]);
            }

            try {
                //StateData stateData = validateState(httpRequest.getSession(), params.get(STATE));
                AuthenticationResponse authResponse = AuthenticationResponseParser.parse(new URI(fullUrl), params);
                if (AuthHelper.isAuthenticationSuccessful(authResponse)) {

                    AuthenticationSuccessResponse oidcResponse = (AuthenticationSuccessResponse) authResponse;
                    AuthenticationResult authData
                            = getAccessToken(oidcResponse.getAuthorizationCode(), currentUri);
                    setSessionPrincipal(httpRequest, authData);

                    setUserInfoAndTenant(model, authData, session);

                    String data;
                    try {
                        String tenant = session.getServletContext().getInitParameter("tenant");
                        data = getUserNamesFromGraph(authData.getAccessToken(), tenant);
                        model.addAttribute("users", data);
                    } catch (Exception e) {
                        model.addAttribute("error", e);
                        return "/error";
                    }
                } else {
                    return "/error";
                }

            } catch (Exception ex) {
                Logger.getLogger(AadController.class.getName()).log(Level.SEVERE, null, ex);
                return "/error";
            } catch (Throwable ex) {
                Logger.getLogger(AadController.class.getName()).log(Level.SEVERE, null, ex);
                return "/error";
            }
        }

        return "loginauthDA/loginDecanatura";
    }

    public StateData validateState(HttpSession session, String state) throws Exception {
        if (StringUtils.isNotEmpty(state)) {
            StateData stateDataInSession = removeStateFromSession(session, state);
            if (stateDataInSession != null) {
                return stateDataInSession;
            }
        }
        throw new Exception(FAILED_TO_VALIDATE_MESSAGE + "could not validate state");
    }

    @RequestMapping("/loginestMov")
    public String getDirectoryObjects3(ModelMap model, HttpServletRequest httpRequest, HttpServletResponse response) throws IOException {
        String currentUri = httpRequest.getRequestURL().toString();
// use state parameter to validate response from Authorization server
        String state = UUID.randomUUID().toString();

        // use nonce parameter to validate idToken
        String nonce = UUID.randomUUID().toString();
        if (!AuthHelper.containsAuthenticationData(httpRequest)) {
            String url = "https://login.microsoftonline.com/pruebacorreoescuelaingeduco.onmicrosoft.com/oauth2/authorize?response_type=code&response_mode=form_post&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2FSIGE2.0-war%2FloginDec&client_id=af94a9ef-fef5-4abb-b06c-427971ec749e&resource=https%3a%2f%2fgraph.windows.net&state=d36be985-02a5-48ea-8bb2-7aa01f070f45&nonce=84648f19-f26c-492e-84d1-14298e2d4dc5\"";

            String redirectUrl = authority + this.tenant + "/oauth2/authorize?"
                    + "response_type=code&"
                    + "response_mode=form_post&"
                    + "redirect_uri=" + URLEncoder.encode(currentUri, "UTF-8")
                    + "&client_id=" + clientId
                    + "&resource=https%3a%2f%2fgraph.windows.net"
                    + (StringUtils.isEmpty(httpRequest.getParameter("claims")) ? "" : "&claims=" + httpRequest.getParameter("claims"))
                    + "&state=" + state
                    + "&nonce=" + nonce;

            response.sendRedirect(redirectUrl);
        } else {

            String queryStr = httpRequest.getQueryString();
            String fullUrl = currentUri + (queryStr != null ? "?" + queryStr : "");
            HttpSession session = httpRequest.getSession();
            HashMap<String, String> params = new HashMap<>();
            for (String key : httpRequest.getParameterMap().keySet()) {
                params.put(key, httpRequest.getParameterMap().get(key)[0]);
            }

            try {
                //StateData stateData = validateState(httpRequest.getSession(), params.get(STATE));
                AuthenticationResponse authResponse = AuthenticationResponseParser.parse(new URI(fullUrl), params);
                if (AuthHelper.isAuthenticationSuccessful(authResponse)) {

                    AuthenticationSuccessResponse oidcResponse = (AuthenticationSuccessResponse) authResponse;
                    AuthenticationResult authData
                            = getAccessToken(oidcResponse.getAuthorizationCode(), currentUri);
                    setSessionPrincipal(httpRequest, authData);

                    setUserInfoAndTenant(model, authData, session);

                    String data;
                    try {
                        String tenant = session.getServletContext().getInitParameter("tenant");
                        data = getUserNamesFromGraph(authData.getAccessToken(), tenant);
                        model.addAttribute("users", data);
                    } catch (Exception e) {
                        model.addAttribute("error", e);
                        return "/error";
                    }
                } else {
                    return "/error";
                }

            } catch (Exception ex) {
                Logger.getLogger(AadController.class.getName()).log(Level.SEVERE, null, ex);
                return "/error";
            } catch (Throwable ex) {
                Logger.getLogger(AadController.class.getName()).log(Level.SEVERE, null, ex);
                return "/error";
            }
        }
        return "loginauthDA/loingestMov";
    }

    @RequestMapping("/")
    public String getDirectoryObjects2(ModelMap model, HttpServletRequest httpRequest) {
        HttpSession session = httpRequest.getSession();
        AuthenticationResult result = (AuthenticationResult) session.getAttribute(AuthHelper.PRINCIPAL_SESSION_NAME);
        if (result == null) {
            model.addAttribute("error", new Exception("AuthenticationResult not found in session."));
            return "/error";
        } else {
            setUserInfoAndTenant(model, result, session);

            String data;
            try {
                String tenant = session.getServletContext().getInitParameter("tenant");
                data = getUserNamesFromGraph(result.getAccessToken(), tenant);
                model.addAttribute("users", data);
            } catch (Exception e) {
                model.addAttribute("error", e);
                return "/error";
            }
        }
        return "/loginDec";
    }

    @RequestMapping("/salirDec")
    public void signOut(HttpServletRequest httpRequest, HttpServletResponse response) throws IOException {

        httpRequest.getSession().invalidate();

        String endSessionEndpoint = "https://login.microsoftonline.com/common/oauth2/v2.0/logout";

        String currentUri = httpRequest.getRequestURL().toString();
        String replacedString = currentUri.replace("salirDec", "loginDec");
        response.sendRedirect(endSessionEndpoint + "?post_logout_redirect_uri="
                + URLEncoder.encode(replacedString, "UTF-8"));
    }

    @RequestMapping("/salirEst")
    public void signOutEst(HttpServletRequest httpRequest, HttpServletResponse response) throws IOException {

        httpRequest.getSession().invalidate();

        String endSessionEndpoint = "https://login.microsoftonline.com/common/oauth2/v2.0/logout";

        String currentUri = httpRequest.getRequestURL().toString();
        String replacedString = currentUri.replace("salirEst", "loginestMov");
        response.sendRedirect(endSessionEndpoint + "?post_logout_redirect_uri="
                + URLEncoder.encode(replacedString, "UTF-8"));
    }

    private String getUserNamesFromGraph(String accessToken, String tenant) throws Exception {
        URL url = new URL(String.format("https://graph.windows.net/%s/users?api-version=2013-04-05", tenant));

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // Set the appropriate header fields in the request header.
        conn.setRequestProperty("api-version", "2013-04-05");
        conn.setRequestProperty("Authorization", accessToken);
        conn.setRequestProperty("Accept", "application/json;");
        String goodRespStr = HttpClientHelper.getResponseStringFromConn(conn, true);

        int responseCode = conn.getResponseCode();
        JSONObject response = HttpClientHelper.processGoodRespStr(responseCode, goodRespStr);
        JSONArray users;

        users = JSONHelper.fetchDirectoryObjectJSONArray(response);

        StringBuilder builder = new StringBuilder();
        User user;
        for (int i = 0; i < users.length(); i++) {
            JSONObject thisUserJSONObject = users.optJSONObject(i);
            user = new User();
            JSONHelper.convertJSONObjectToDirectoryObject(thisUserJSONObject, user);
            builder.append(user.getUserPrincipalName() + "<br/>");
        }
        return builder.toString();
    }

    @RequestMapping(value = "/secure/GetAtForCaApiByRT", method = RequestMethod.GET)
    public String getATForCaProtectedApiUsingRT(ModelMap model, HttpServletRequest httpRequest) throws MalformedURLException, InterruptedException {
        HttpSession session = httpRequest.getSession();
        AuthenticationResult result = (AuthenticationResult) session.getAttribute(AuthHelper.PRINCIPAL_SESSION_NAME);
        if (result == null) {
            model.addAttribute("error", new Exception("AuthenticationResult not found in session."));
            return "/error";
        } else {

            setUserInfoAndTenant(model, result, session);

            AuthenticationContext context;
            ExecutorService service = null;

            String clientId = servletContext.getInitParameter("client_id");
            String authority = servletContext.getInitParameter("authority");
            String tenant = servletContext.getInitParameter("tenant");
            String clientSecret = servletContext.getInitParameter("secret_key");
            String caProtectedApiIdUri = servletContext.getInitParameter("ca_protected_api_id_uri");

            try {
                ClientCredential credential = new ClientCredential(clientId, clientSecret);
                service = Executors.newFixedThreadPool(1);

                context = new AuthenticationContext(authority + tenant + "/", true,
                        service);
                Future<AuthenticationResult> future = context.acquireTokenByRefreshToken(result.getRefreshToken(), credential,
                        caProtectedApiIdUri, null);

                result = future.get();

                model.addAttribute("acquiredToken", result.getAccessToken());

            } catch (ExecutionException e) {
                if (e.getCause() instanceof AdalClaimsChallengeException) {

                    AdalClaimsChallengeException interReqExc = (AdalClaimsChallengeException) e.getCause();
                    AuthHelper.invalidateAuth(httpRequest);

                    return "redirect:/secure/aad" + "?claims=" + interReqExc.getClaims();
                }
            } finally {
                service.shutdown();
            }
        }
        return "secure/aad";
    }

    @RequestMapping(value = "/secure/GetAtForCaApiUsingOboService", method = RequestMethod.GET)
    public String getATForCaProtectedApiUsingOboService(ModelMap model, HttpServletRequest httpRequest) throws MalformedURLException, InterruptedException {
        HttpSession session = httpRequest.getSession();
        AuthenticationResult result = (AuthenticationResult) session.getAttribute(AuthHelper.PRINCIPAL_SESSION_NAME);
        if (result == null) {
            model.addAttribute("error", new Exception("AuthenticationResult not found in session."));
            return "/error";
        } else {

            setUserInfoAndTenant(model, result, session);

            AuthenticationContext context;
            ExecutorService service = null;

            // web app config
            String clientId = servletContext.getInitParameter("client_id");
            String authority = servletContext.getInitParameter("authority");
            String tenant = servletContext.getInitParameter("tenant");
            String clientSecret = servletContext.getInitParameter("secret_key");
            String oboApplicationIdUri = servletContext.getInitParameter("obo_application_id_uri");
            String caProtectedApiIdUri = servletContext.getInitParameter("ca_protected_api_id_uri");

            try {
                ClientCredential credential = new ClientCredential(clientId, clientSecret);
                service = Executors.newFixedThreadPool(1);

                context = new AuthenticationContext(authority + tenant + "/", true,
                        service);

                // get AT for OBO service
                Future<AuthenticationResult> future = context.acquireTokenByRefreshToken(result.getRefreshToken(), credential,
                        oboApplicationIdUri, null);
                result = future.get();

                // get AT for Mfa protected Api using Obo client
                // obo config
                String oboClientId = servletContext.getInitParameter("obo_client_id");
                String oboClientSecret = servletContext.getInitParameter("obo_secret_key");

                ClientCredential oboCredential = new ClientCredential(oboClientId, oboClientSecret);

                future = context.acquireToken(caProtectedApiIdUri,
                        new UserAssertion(result.getAccessToken()), oboCredential, null);

                result = future.get();

                model.addAttribute("acquiredToken", result.getAccessToken());
            } catch (ExecutionException e) {
                if (e.getCause() instanceof AdalClaimsChallengeException) {

                    AdalClaimsChallengeException interReqExc = (AdalClaimsChallengeException) e.getCause();
                    AuthHelper.invalidateAuth(httpRequest);

                    return "redirect:/secure/aad" + "?claims=" + interReqExc.getClaims();
                }
            } finally {
                service.shutdown();
            }
        }
        return "secure/aad";
    }

    public StateData removeStateFromSession(HttpSession session, String state) {
        Map<String, StateData> states = (Map<String, StateData>) session.getAttribute(STATES);
        if (states != null) {
            eliminateExpiredStates(states);
            StateData stateData = states.get(state);
            if (stateData != null) {
                states.remove(state);
                return stateData;
            }
        }
        return null;
    }

    public void eliminateExpiredStates(Map<String, StateData> map) {
        Iterator<Map.Entry<String, StateData>> it = map.entrySet().iterator();

        Date currTime = new Date();
        while (it.hasNext()) {
            Map.Entry<String, StateData> entry = it.next();
            long diffInSeconds = TimeUnit.MILLISECONDS.
                    toSeconds(currTime.getTime() - entry.getValue().getExpirationDate().getTime());

            if (diffInSeconds > STATE_TTL) {
                it.remove();
            }
        }
    }

    public class StateData {

        private String nonce;
        private Date expirationDate;

        public StateData(String nonce, Date expirationDate) {
            this.nonce = nonce;
            this.expirationDate = expirationDate;
        }

        public String getNonce() {
            return nonce;
        }

        public Date getExpirationDate() {
            return expirationDate;
        }
    }

    public AuthenticationResult getAccessToken(
            AuthorizationCode authorizationCode, String currentUri)
            throws Throwable {
        String authCode = authorizationCode.getValue();
        ClientCredential credential = new ClientCredential("af94a9ef-fef5-4abb-b06c-427971ec749e",
                "YFK8Q~Vmx~VcPEwojoXJwQDsy08i1ZlyY4YGYdf4");
        AuthenticationContext context;
        AuthenticationResult result = null;
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(1);
            context = new AuthenticationContext("https://login.microsoftonline.com/" + "pruebacorreoescuelaingeduco.onmicrosoft.com" + "/", true,
                    service);
            Future<AuthenticationResult> future = context
                    .acquireTokenByAuthorizationCode(authCode, new URI(
                            currentUri), credential, null);
            result = future.get();
        } catch (ExecutionException e) {
            throw e.getCause();
        } finally {
            service.shutdown();
        }

        if (result == null) {
            throw new ServiceUnavailableException("authentication result was null");
        }
        return result;
    }

    private void setSessionPrincipal(HttpServletRequest httpRequest,
            AuthenticationResult result) {
        httpRequest.getSession().setAttribute(AuthHelper.PRINCIPAL_SESSION_NAME, result);
    }
}
