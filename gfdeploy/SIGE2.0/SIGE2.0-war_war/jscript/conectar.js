/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var http_request = false;
var respServlet='';


function conectarX(url,funcion){
    // Obtener la instancia del objeto XMLHttpRequest
    http_request = false;
    if (window.XMLHttpRequest) { // Mozilla, Safari,...
        http_request = new XMLHttpRequest();
        if (http_request.overrideMimeType) {
            http_request.overrideMimeType('text/xml');
        }
    } else if (window.ActiveXObject) { // IE
        try {
            http_request = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                http_request = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {}
        }
    }
    if (!http_request) {
        alert('No se Instanciado el Objeto XMLHttpRequest');
        return false;
    }

    //Preparar funcion de respuesta
    http_request.onreadystatechange = funcion;

    //Enviar Peticion
    http_request.open('POST', url, true);
    http_request.send(null);
    return false;
}

function conectarMethod(url, funcion, met){
    // Obtener la instancia del objeto XMLHttpRequest
    http_request = false;
    if (window.XMLHttpRequest) { // Mozilla, Safari,...
        http_request = new XMLHttpRequest();
    } else if (window.ActiveXObject) { // IE
        try {
            http_request = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                http_request = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e){}
        }
    }

    if (!http_request) {
        alert('No se Instanciado el Objeto XMLHttpRequest');
        return false;
    }
    
    if (http_request.overrideMimeType) {
        http_request.overrideMimeType('text/xml');
    }

    //Preparar funcion de respuesta
    http_request.onreadystatechange = funcion;

    //Enviar Peticion
    
    http_request.open(met, url, true);
    http_request.send(null);
    return false;
}

function conectarSendParam(url, funcion, met, paramRequest){
    // Obtener la instancia del objeto XMLHttpRequest
    http_request = false;
    if (window.XMLHttpRequest) {// IE7+, Firefox, Chrome, Opera, Safari
        http_request = new XMLHttpRequest();
    } else {// IE6, IE5
        try { http_request = new ActiveXObject('Microsoft.XMLHTTP');
        } catch (err) { try { http_request = new ActiveXObject('Msxml2.XMLHTTP');
                        } catch (err) {
                            alert('No se ha instanciado el objeto XMLHttpRequest');
                            return false;
                        }
        }
    }
    http_request.onreadystatechange=funcion;

    //Enviar Peticion
    http_request.open(met, url, true);
    http_request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
    http_request.send(paramRequest);
    return false;
}

function muestraAprSolDec() {
    var url;
    if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
             var idsolicitud=respuesta.getElementsByTagName("dato")[0].firstChild.nodeValue;
                   url='ActualizarEstMov?'+"idsolicitud=" + idsolicitud + "&clave=b";
                    conectarMethod(url, muestraResultadoreload, 'POST')
                  // response.sendRedirect("EstMov" );
            //if(respuesta.getElementsByTagName("dato")[0]!=null){//if(resul=="Operación Exitosa"){
              //  eval(respServlet+"("+");");
            //}
        }
    }
}

function muestraResultado() {
    if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
                  alert(resul);
                  // response.sendRedirect("EstMov" );
            
        }
    }
}
function muestraResultadoFecha() {
    if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
                  alert(resul);
                  window.close();
                  // response.sendRedirect("EstMov" );
            
        }
    }
}
function muestraResultadoEntre() {
    var url;
    if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
             var idsolicitud=respuesta.getElementsByTagName("dato")[0].firstChild.nodeValue;
                   url = 'ActualizarEstMov?'+"idsolicitud=" + idsolicitud + "&clave=i";
                       conectarMethod(url, muestraResultadoreload, 'POST');
                  // response.sendRedirect("EstMov" );
           
        }
    }
}
function muestraResultadoCambiPlan() {
    var url;
    if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
             var idsolicitud=respuesta.getElementsByTagName("dato")[0].firstChild.nodeValue;
                   url = 'ActualizarEstMov?'+"idsolicitud=" + idsolicitud + "&clave=i";
                        conectarMethod(url, muestracontrato, 'POST');
                  // response.sendRedirect("EstMov" );
           
        }
    }
}

function muestraRechazovice() {
    var url;
    if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
            var idsolicitud=respuesta.getElementsByTagName("dato")[0].firstChild.nodeValue;
                   url = 'ActualizarEstMov?'+"idsolicitud=" + idsolicitud + "&clave=r";
                       conectarMethod(url, muestraResultadoreload, 'POST');
                  
        }
    }
}
function muestraResultadoreload() {
    if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
                  alert(resul);
                  location.reload(true);
                  // response.sendRedirect("EstMov" );
            //if(respuesta.getElementsByTagName("dato")[0]!=null){//if(resul=="Operación Exitosa"){
              //  eval(respServlet+"("+");");
            //}
        }
    }
}
function muestraResultadoclose() {
    if(http_request.readyState != 4) return;
    if(http_request.status != 200) return;
    
    var xmldoc = http_request.responseXML;
    var respuesta=xmldoc.getElementsByTagName("resultado")[0];
    var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
    alert(resul);
    window.location = 'http://www.escuelaing.edu.co/es/';
}
function muestraInicioAdmin() {
    if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
                  alert(resul);
                  //window.close();
                  window.location='loginAdmin';
                  
                   //response.sendRedirect("loginAdmin" );
            if(respuesta.getElementsByTagName("dato")[0]!=null){//if(resul=="Operación Exitosa"){
                eval(respServlet+"("+");");
            }
        }
    }
}
function muestraInicioGrad() {
    if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
                  alert(resul);
                  window.location='logingraduado';
            if(respuesta.getElementsByTagName("dato")[0]!=null){//if(resul=="Operación Exitosa"){
                eval(respServlet+"("+");");
            }
        }
    }
}

function muestraInicioEmp() {
    if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
                  alert(resul);
                  //window.close();
                  window.location='loingempresa';
                  
                   //response.sendRedirect("loginAdmin" );
            if(respuesta.getElementsByTagName("dato")[0]!=null){//if(resul=="Operación Exitosa"){
                eval(respServlet+"("+");");
            }
        }
    }
}
function muestraInicioEst() {
    if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
                  alert(resul);
                  window.location='loginestMov';                  

            if(respuesta.getElementsByTagName("dato")[0]!=null){//if(resul=="Operación Exitosa"){
                eval(respServlet+"("+");");
            }
        }
    }
}
function muestraInicioVice() {
    if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
                  alert(resul);
                  //window.close();
                  window.location='loginVice';                  
                   //response.sendRedirect("loginAdmin" );
            if(respuesta.getElementsByTagName("dato")[0]!=null){//if(resul=="Operación Exitosa"){
                eval(respServlet+"("+");");
            }
        }
    }
}
function muestraInicioDec() {
    if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
                  alert(resul);
                  //window.close();
                  window.location='loginDec';                  
                   //response.sendRedirect("loginAdmin" );
            if(respuesta.getElementsByTagName("dato")[0]!=null){//if(resul=="Operación Exitosa"){
                eval(respServlet+"("+");");
            }
        }
    }
}

function muestraregistraremp() {
    if(http_request.readyState == 4) {
        var btn = document.getElementById('BtnRegEmp');
        btn.value = 'Registrar';
        btn.disabled = 'false';
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
                  alert(resul);
                  window.location= "loingempresa"
                  // response.sendRedirect("EstMov" );
            if(respuesta.getElementsByTagName("dato")[0]!=null){//if(resul=="Operación Exitosa"){
                eval(respServlet+"("+");");
            }
        }
    }
}
function muestranadareload() {
    if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            //var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
                 // alert(resul);
                  location.reload();
                  // response.sendRedirect("EstMov" );
            if(respuesta.getElementsByTagName("dato")[0]!=null){//if(resul=="Operación Exitosa"){
                eval(respServlet+"("+");");
            }
        }
    }
}
function tramitadocumentomov() {
    var url;
    if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
            var idsolicitud=respuesta.getElementsByTagName("dato")[0].firstChild.nodeValue;
                 // alert(resul);
                  url = 'ActualizarEstMov?'+"idsolicitud=" + idsolicitud;
                       conectarMethod(url, muestranadareload, 'POST');
                  // response.sendRedirect("EstMov" );
            
        }
    }
}

function enviaCreacontrato() {
  var url;
    if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
            var idsolicitud=respuesta.getElementsByTagName("dato")[0].firstChild.nodeValue;
                 // alert(resul);
                  url = 'CrearContrato?'+"idsolicitud=" + idsolicitud;
                       conectarMethod(url, tramitacontrato, 'POST');
                  // response.sendRedirect("EstMov" );
            
        }
    }
}
function tramitacontrato() {
    var url;
    if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
            var idsolicitud=respuesta.getElementsByTagName("dato")[0].firstChild.nodeValue;
                 // alert(resul);
                  url = 'ActualizarEstMov?'+"idsolicitud=" + idsolicitud + "&clave=h";
                       conectarMethod(url, muestracontrato, 'POST');
                  // response.sendRedirect("EstMov" );
            
        }
    }
}
function muestracontrato() {
      if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
            var idsolicitud=respuesta.getElementsByTagName("dato")[0].firstChild.nodeValue;
                  alert(resul);
                  window.location='contratoMov?i='+idsolicitud;
                  // response.sendRedirect("EstMov" );
            
        }
    }
}

function muestranada() {
    //if(http_request.readyState == 4) {
        //if(http_request.status == 200) {
            //actualizarTabEstEgre(doc_grad);
        //}
    //}
}
function muestraantGeneral (){
   if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
                  alert(resul);
                  history.back()
                  // response.sendRedirect("EstMov" );
            if(respuesta.getElementsByTagName("dato")[0]!=null){//if(resul=="Operación Exitosa"){
                eval(respServlet+"("+");");
            }
        }
    }
}

function muestraant (){
   if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            //var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
             alert("su plan de estudio a sido enviado");
             location.reload();
            if(respuesta.getElementsByTagName("dato")[0]!=null){//if(resul=="Operación Exitosa"){
                eval(respServlet+"("+");");
            }
        }
    }
}

function muestraResultadoGs() {
    if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
                  alert(resul);

                  // response.sendRedirect("EstMov" );
            if(respuesta.getElementsByTagName("dato")[0]!=null){//if(resul=="Operación Exitosa"){
                eval(respServlet+"("+");");
            }
        }
    }
}

function muestraResultadoSP() {
    if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
            alert(resul);
            if(resul=='Operación Exitosa'){
                eval(respServlet+";");
            }
        }
    }
}










function inputToText(Datos){
    var datos=new Array(),j=0;
    for(var i=0;i<Datos.length;i++){
        var textInput =Datos[i].split("=");
        document.getElementById(textInput[0]).innerHTML=document.getElementById(textInput[1]).value;
        datos[j]=textInput[1]+'=none';
        datos[j+1]=textInput[0]+'=inline';
        j=j+2;
    }
    setVisibilidad(datos);
}

function textToInput(Datos){
    var datos=new Array(),j=0;
    for(var i=0;i<Datos.length;i++){
        var inputText =Datos[i].split("=");
        document.getElementById(inputText[0]).value=document.getElementById(inputText[1]).innerHTML;
        datos[j]=inputText[1]+'=none';
        datos[j+1]=inputText[0]+'=inline';
        j=j+2;
    }
    setVisibilidad(datos);
}

function setValorInput(Datos){
    for(var i=0;i<Datos.length;i++){
        var idXValor =Datos[i].split("=");
        document.getElementById(idXValor[0]).value=idXValor[1];
    }
}

function setValorText(Datos){
    for(var i=0;i<Datos.length;i++){
        var idXValor =Datos[i].split("=");
        document.getElementById(idXValor[0]).innerHTML=document.getElementById(idXValor[1]).value;
    }
}

function setEditar(Datos){
    for(var i=0;i<Datos.length;i++){
        var idXValor =Datos[i].split("=");
        document.getElementById(idXValor[0]).disabled=Boolean(idXValor[1]);
    }
}

function setReadOnly(Datos){
    for(var i=0;i<Datos.length;i++){
        var idXValor =Datos[i].split("=");
        document.getElementById(idXValor[0]).readOnly=Boolean(idXValor[1]);
    }
}

function setVisibilidad(Datos){
    for(var i = 0; i < Datos.length; i++) {
        var idXValor = Datos[i].split("=");
        var elem = document.getElementById(idXValor[0]);
        if (elem != null) elem.style.display=idXValor[1];
    }
}

function isDiligenciado(Campos,Mensajes){
    var respuesta="Campos obligatorios: \n";
    for(var i=0;i<Campos.length;i++){
        if(document.getElementById(Campos[i]).value==""){
            respuesta=respuesta+"   - "+Mensajes[i]+"\n";
        }
    }
    if(respuesta.length==22){
        return true
    }else{
        alert(respuesta);
        return false
    }
}

function isNumero(Campos,Mensajes){
    var respuesta="Campos numéricos: \n", num;
    for(var i=0;i<Campos.length;i++){
        num=document.getElementById(Campos[i]).value;
        if(/[^\d]/g.test(num)){
            respuesta=respuesta+"   - "+Mensajes[i]+"\n";
        }
    }
    if(respuesta.length==19){
        return true
    }else{
        alert(respuesta);
        return false
    }
}

function isTextoObligatorio(Campos,Mensajes){
    var respuesta="Esta vacio o ingreso un numero en: \n", num;
    var ban= respuesta.length;
    var valid1 = /\D/;
    for(var i=0;i<Campos.length;i++)
    {
       num=document.getElementById(Campos[i]).value.replace(/[,']/g, "");
        if (!valid1.test(num)) 
        {    
            respuesta=respuesta+"   - "+Mensajes[i]+"\n";
        }
    }
    if(respuesta.length==36){
        return true
    }else{
        alert(respuesta);
        return false
    }
}
function isTextoOpcional(Campos,Mensajes){
    var respuesta="Ingreso un numero en: \n", num;
    var ban= respuesta.length;
    var valid1 = /\D/;
    for(var i=0;i<Campos.length;i++)
    {
       num=document.getElementById(Campos[i]).value.replace(/[,']/g, "");
       if (num==""){
           num=/s/;
       }
        if (!valid1.test(num))
        {
            respuesta=respuesta+"   - "+Mensajes[i]+"\n";
        }
    }
    if(respuesta.length==23){
        return true
    }else{
        alert(respuesta);
        return false
    }
}
function isemail (Campos,Mensajes)
{
var respuesta="dirreccion de correo no es valida \n", num;
    var ban= respuesta.length;
    var valid1 = /[\w-\.]{3,}@([\w-]{2,}\.)*([\w-]{2,}\.)[\w-]{2,4}/;
    for(var i=0;i<Campos.length;i++)
    {
       num=document.getElementById(Campos[i]).value.replace(/[,']/g, "");
        if (!valid1.test(num)) 
        {    
            respuesta=respuesta+"   - "+Mensajes[i]+"\n";
        }
    }
    if(respuesta.length==35){
        return true
    }else{
        alert(respuesta);
        return false
    }
}

function getCheckboxprogramas(){

     var s=document.fromprogramas.programas;
     var resul="&";
     var numdatos=0;
    
    for(var i=0; i<s.length;i++){
        if(s[i].checked){
            numdatos++;
            resul=resul+"programa"+numdatos+"="+s[i].value+"&";
            //alert("&programa"+numdatos+"="+s[i].value);
        }
    }
     if(numdatos==0){
         alert("Por favor seleccione el/los programas a los que va dirigida la oferta.");
         return false;
     }
    resul=resul+"&numprog="+numdatos;
    resul=resul.replace(/[%]/g, "_");
    resul=resul.replace(/[\n]/g, "'<mas>char(10)<mas>'");
    return resul;

}


function getCheckboxestudios(){

     var s=document.fromprogramas.estudiosreq;
     var resul="&";
     var numdatos=0;
    
    for(var i=0; i<s.length;i++){
        if(s[i].checked){
            numdatos++;
            resul=resul+"estreq"+numdatos+"="+s[i].value+"&";
            //alert("&programa"+numdatos+"="+s[i].value);
        }
    }
     if(numdatos==0){
         alert("Por favor seleccione el/los nivel(es) de estudio.");
         return false;
     }
    resul=resul+"&numest="+numdatos;
    return resul;

}

function getCheckboxprogramaspre(){

     var s=document.fromprogramaspre.programaspre;
     var resul="&";
     var numdatos=0;
     
    for(var i=0; i<s.length;i++){
        if (s[i].checked) {
            numdatos++;
            resul=resul+"programa"+numdatos+"="+s[i].value+"&";
            //alert("&programa"+numdatos+"="+s[i].value);
        }
    }
    if (numdatos == 0) {
         alert("Por favor seleccione el/los programas a los que va dirigida la oferta.");
         return false;
    }
    
    resul=resul+"numprog=" + numdatos;
    resul=resul.replace(/[%]/g, "_");
    resul=resul.replace(/[\n]/g, "'<mas>char(10)<mas>'");
    return resul;

}

function getCheckboxReporteGrad(){
 var s=document.fromReporteGrad.BoxReporteGrad;
 var resul="&";
 var numdatos=0;
    for(var i=0; i<s.length;i++){
        if(s[i].checked){
            numdatos++;
            resul=resul+"dato"+numdatos+"="+s[i].value+"&";
            //alert("&dato"+numdatos+"="+s[i].value);
        }
    }
    resul=resul+"numdatos="+numdatos;
    resul=resul.replace(/[%]/g, "_");
    resul=resul.replace(/[\n]/g, "'<mas>char(10)<mas>'");
    return resul;
}

function getCheckboxReporteDisG(){
 var s=document.fromReporteDisG.BoxReporteDisG;
 var resul="&";
 var numdatos=0;
    for(var i=0; i<s.length;i++){
        if(s[i].checked){
            numdatos++;
            resul=resul+"dato"+numdatos+"="+s[i].value+"&";
            //alert("&dato"+numdatos+"="+s[i].value);
        }
    }
    resul=resul+"numdatos="+numdatos;
    resul=resul.replace(/[%]/g, "_");
    resul=resul.replace(/[\n]/g, "'<mas>char(10)<mas>'");
    return resul;
}
function getCheckboxReporteAfiG(){
   var s=document.fromReporteAfiG.BoxReporteAfiG;
 var resul="&";
 var numdatos=0;
    for(var i=0; i<s.length;i++){
        if(s[i].checked){
            numdatos++;
            resul=resul+"dato"+numdatos+"="+s[i].value+"&";
            //alert("&dato"+numdatos+"="+s[i].value);
        }
    }
    resul=resul+"numdatos="+numdatos;
    resul=resul.replace(/[%]/g, "_");
    resul=resul.replace(/[\n]/g, "'<mas>char(10)<mas>'");
    return resul;
}
function getCheckboxReporteIdioG(){
 var s=document.fromReporteIdioG.BoxReporteIdioG;
 var resul="&";
 var numdatos=0;
    for(var i=0; i<s.length;i++){
        if(s[i].checked){
            numdatos++;
            resul=resul+"dato"+numdatos+"="+s[i].value+"&";
            //alert("&dato"+numdatos+"="+s[i].value);
        }
    }
    resul=resul+"numdatos="+numdatos;
    resul=resul.replace(/[%]/g, "_");
    resul=resul.replace(/[\n]/g, "'<mas>char(10)<mas>'");
    return resul;
}
function getCheckboxReporteEstG(){
    var s=document.fromReporteEstG.BoxReporteEstG;
 var resul="&";
 var numdatos=0;
    for(var i=0; i<s.length;i++){
        if(s[i].checked){
            numdatos++;
            resul=resul+"dato"+numdatos+"="+s[i].value+"&";
            //alert("&dato"+numdatos+"="+s[i].value);
        }
    }
    resul=resul+"numdatos="+numdatos;
    resul=resul.replace(/[%]/g, "_");
    resul=resul.replace(/[\n]/g, "'<mas>char(10)<mas>'");
    return resul;
}
function getCheckboxReporteExpG(){
  var s=document.fromReporteExpG.BoxReporteExpG;
 var resul="&";
 var numdatos=0;
    for(var i=0; i<s.length;i++){
        if(s[i].checked){
            numdatos++;
            resul=resul+"dato"+numdatos+"="+s[i].value+"&";
            //alert("&dato"+numdatos+"="+s[i].value);
        }
    }
    resul=resul+"numdatos="+numdatos;
    resul=resul.replace(/[%]/g, "_");
    resul=resul.replace(/[\n]/g, "'<mas>char(10)<mas>'");
    return resul;
}
function getCheckboxReporteEmpG(){
 var s=document.fromReporteEmpG.BoxReporteEmpG;
 var resul="&";
 var numdatos=0;
    for(var i=0; i<s.length;i++){
        if(s[i].checked){
            numdatos++;
            resul=resul+"dato"+numdatos+"="+s[i].value+"&";
            //alert("&dato"+numdatos+"="+s[i].value);
        }
    }
    resul=resul+"numdatos="+numdatos;
    resul=resul.replace(/[%]/g, "_");
    resul=resul.replace(/[\n]/g, "'<mas>char(10)<mas>'");
    return resul;
}
function getCheckboxReporteOferG(){
 var s=document.fromReporteOferG.BoxReporteOferG;
 var resul="&";
 var numdatos=0;
    for(var i=0; i<s.length;i++){
        if(s[i].checked){
            numdatos++;
            resul=resul+"dato"+numdatos+"="+s[i].value+"&";
            //alert("&dato"+numdatos+"="+s[i].value);
        }
    }
    resul=resul+"numdatos="+numdatos;
    resul=resul.replace(/[%]/g, "_");
    resul=resul.replace("Ã±", "ñ");
    resul=resul.replace(/[\n]/g, "'<mas>char(10)<mas>'");
    return resul;
}

function getValores(Datos){
    var resul=Datos[0]+"="+document.getElementById(Datos[0]).value,val;
    for(var i=1;i<Datos.length;i++){
        val=document.getElementById(Datos[i]).value;
        var ban=isNaN(val.replace(/[,'#]/g, ""));
        if(isNaN(val)){
            val=val.replace(/#|[Nn]°/g, 'No');
            val=val.replace(/['#]/g, "");
        }
        resul=resul + "&" + Datos[i] + "=" + val;
    }
    resul=resul.replace(/[%]/g, "_");
    resul=resul.replace(/[\n]/g, "'<mas>char(10)<mas>'");
    return resul;
}

function validaFecha(valor){
    var patron=/^([1-9]|([0][1-9])|([1][0-2]))[/](\d{2,4})$/;
    if(!(valor.search(patron)==-1)){
        return true;
    }else{
        alert("Fecha incorrecta (mm/aaaa)");
        return false;
    }
}
function validaFechaCompleta(valor){
    var patron=/^([1-9]|([0][1-9])|([1-2][0-9])|([3][0-1]))[/]([1-9]|([0][1-9])|([1][0-2]))[/](\d{4})$/;
    if(!(valor.search(patron)==-1)){
        return true;
    }else{
        alert("Fecha incorrecta (dd/mm/aaaa)");
        return false;
    }
}
function validaperdiodo(valor){
    //var dias=[31,28,31,30,31,30,31,31,30,31,30,31];
    var patron=/^[12I]-\d{2,4}$/;
    if(!(valor.search(patron)==-1)){
        return true;
    }else{
        alert("Periodo Incorrecto. Ejemplo: 1-2012, 2-2012, o , I-2012");
        return false;
    }
}

function difFecha(fechaMenor,fechaMayor){
    var dmaMenor=fechaMenor.split("/");
    var dmaMayor=fechaMayor.split("/");
    if(parseInt(dmaMenor[2],10)<=parseInt(dmaMayor[2],10)){
        if(parseInt(dmaMenor[2],10)==parseInt(dmaMayor[2],10)){
            if(parseInt(dmaMenor[1],10)<=parseInt(dmaMayor[1],10)){
                if(parseInt(dmaMenor[1],10)==parseInt(dmaMayor[1],10)){
                    if(parseInt(dmaMenor[0],10)<=parseInt(dmaMayor[0],10)){
                        return true;
                    }
                }else{
                    return true;
                }
            }
        }else{
            return true;
        }
    }
    alert("Diferencia de fechas incorrecta.");
    return false;
}

function difEnMeses(fechaMenor,fechaMayor){
    var dmaMenor=fechaMenor.split("/");
    var dmaMayor=fechaMayor.split("/");
    return ((parseInt(dmaMayor[2],10)-parseInt(dmaMenor[2],10))*12)+parseInt(dmaMayor[1],10)-parseInt(dmaMenor[1],10);
}

function devuelveValorxSigla(sigla,opciones){
    var valorSigla;
    for(var i=0;i<opciones.length;i++){
        valorSigla=opciones[i].split("=");
        if(valorSigla[1]==sigla)return valorSigla[0];
    }
    return '_';
}

function defineColorXEdicion(){
    var tipos=['input','textarea'];
    var entradas;
    var entrada;
    for(var i=0;i<tipos.length;i++){
        entradas=document.getElementsByTagName(tipos[i]);
        for(var j=0;j<entradas.length;j++){
            entrada=entradas[j];
            if(entrada.type=='text' || entrada.type=='textarea'){
                if(entrada.readOnly){
                    entrada.style.background='#DDDDDD';
                }else{
                    entrada.style.background='#FFFFFF';
                }
            }
        }
    }
}
function cerrarsesion(){        

        url = 'cerrarsesion';
        conectarMethod(url, muestraResultadoclose, 'POST');
       // window.close();
               
   }
   function cerrarsesionAdminGrad(){        

        url = 'cerrarsesion';
        conectarMethod(url, muestraInicioAdmin, 'POST');
       // window.close();
               
   }
    function cerrarsesionGrad(){    
        url = 'cerrarsesion';
        conectarMethod(url, muestraInicioGrad, 'POST'); // window.close();
               
   }
  function cerrarsesionEmp(){    
        url = 'cerrarsesion';
        conectarMethod(url, muestraInicioEmp, 'POST'); // window.close();
               
   }
    function cerrarsesionEst(){    
        url = 'cerrarsesion';
        conectarMethod(url, muestraInicioEst, 'POST'); // window.close();
               
   }
   function cerrarsesionVice(){    
        url = 'cerrarsesion';
        conectarMethod(url, muestraInicioVice, 'POST'); // window.close();
               
   }
    function cerrarsesionDec(){    
        url = 'cerrarsesion';
        conectarMethod(url, muestraInicioDec, 'POST'); // window.close();
               
   }
