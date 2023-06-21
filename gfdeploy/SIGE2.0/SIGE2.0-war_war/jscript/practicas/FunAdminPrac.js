/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function verconsultapracAdmin()
{
    setVisibilidad(['ConsultaPracAdmin=inline', 'tablaConsultaPracAdmin=inline', 'ConsultaEmpAdminP=none', 'tablaConsultaEmpAdminP=none',
        'consultaoferpracAdmin=none', 'botonconsultaoferpracAdmin=none', 'tablaofertaspracAdmin=none', 'emailAdminG=none', 'ActFechasPrac=none'
        ,'botontramitaoferpracAdmin=none','tramitarofertaspracAdmin=none','botonenviocampus=none','EnvioCampusAdmin=none']);
}
function verconsultaEmpAdminP()
{
    setVisibilidad(['ConsultaPracAdmin=none', 'tablaConsultaPracAdmin=none', 'ConsultaEmpAdminP=inline', 'tablaConsultaEmpAdminP=inline',
        'consultaoferpracAdmin=none', 'botonconsultaoferpracAdmin=none', 'tablaofertaspracAdmin=none', 'emailAdminG=none', 'ActFechasPrac=none'
        ,'botontramitaoferpracAdmin=none','tramitarofertaspracAdmin=none','botonenviocampus=none','EnvioCampusAdmin=none']);
}
function verconsultaOferAdminP()
{
    setVisibilidad(['ConsultaPracAdmin=none', 'tablaConsultaPracAdmin=none', 'ConsultaEmpAdminP=none', 'tablaConsultaEmpAdminP=none',
        'consultaoferpracAdmin=inline', 'botonconsultaoferpracAdmin=inline', 'tablaofertaspracAdmin=inline', 'emailAdminG=none', 'ActFechasPrac=none'
        ,'botontramitaoferpracAdmin=none','tramitarofertaspracAdmin=none','botonenviocampus=none','EnvioCampusAdmin=none']);
}
function veremailmasivoAdminP()
{
    setVisibilidad(['ConsultaPracAdmin=none', 'tablaConsultaPracAdmin=none', 'ConsultaEmpAdminP=none', 'tablaConsultaEmpAdminP=none',
        'consultaoferpracAdmin=none', 'botonconsultaoferpracAdmin=none', 'tablaofertaspracAdmin=none', 'emailAdminG=inline', 'ActFechasPrac=none'
    ,'botontramitaoferpracAdmin=none','tramitarofertaspracAdmin=none']);
}
function veractFecPracAdmin() {
    setVisibilidad(['ConsultaPracAdmin=none', 'tablaConsultaPracAdmin=none', 'ConsultaEmpAdminP=none', 'tablaConsultaEmpAdminP=none',
        'consultaoferpracAdmin=none', 'botonconsultaoferpracAdmin=none', 'tablaofertaspracAdmin=none', 'emailAdminG=none', 'ActFechasPrac=inline'
        ,'botontramitaoferpracAdmin=none','tramitarofertaspracAdmin=none','botonenviocampus=none','EnvioCampusAdmin=none']);
}
function verTramitaOferpracAdmin()
{
    setVisibilidad(['ConsultaPracAdmin=none', 'tablaConsultaPracAdmin=none', 'ConsultaEmpAdminP=none', 'tablaConsultaEmpAdminP=none',
        'consultaoferpracAdmin=none', 'botonconsultaoferpracAdmin=none', 'tablaofertaspracAdmin=none', 'emailAdminG=none', 'ActFechasPrac=none'
        ,'botontramitaoferpracAdmin=inline','tramitarofertaspracAdmin=inline','botonenviocampus=none','EnvioCampusAdmin=none']);
}

function verEnvioCampusAdmin()
{
    setVisibilidad(['ConsultaPracAdmin=none', 'tablaConsultaPracAdmin=none', 'ConsultaEmpAdminP=none', 'tablaConsultaEmpAdminP=none',
        'consultaoferpracAdmin=none', 'botonconsultaoferpracAdmin=none', 'tablaofertaspracAdmin=none', 'emailAdminG=none', 'ActFechasPrac=none'
        ,'botontramitaoferpracAdmin=none','tramitarofertaspracAdmin=none','botonenviocampus=inline','EnvioCampusAdmin=inline']);
}

function AprobarofertapracUge(id) {
    var formobj = document.fromprogramaspre;
    if (!isDiligenciado(['nomcargonop', 'descripcionnop', 'Requisitosnop', 'paisnop', 'ciudadnop', 'areanop', 'salarionop', 'fechaoutnop', 'fechainprac', 'fechaoutprac'
                , 'horarionop', 'contratonop', 'seguros_arp', 'nom_jefe', 'cargo_jefe', 'tel_jefe', 'email_jefe'],
            ['Nombre del Cargo', 'Descripción del cargo', 'Requisitos', 'Pais', 'Ciudad', 'Area de actividad', 'Apoyo Económico', 'Fecha de vencimiento', 'Fecha inicio de la práctica', 'Fecha finalización de la práctica'
                        , 'Jornada Laboral', 'Tipo de Contrato', 'Sistema de seguro y riesgos profesionales', 'Reporta a(nombre)', 'Reporta a(cargo)', 'Reporta a (Telefono)', 'Reporta a(email)']))
    {
        return false;
    }
    else
    {
        if (!validaFechaCompleta(document.getElementById("fechaoutnop").value) || !validaFechaCompleta(document.getElementById("fechainprac").value)
                || !validaFechaCompleta(document.getElementById("fechaoutprac").value)) {
            return false;
        }
        else {
            var answer = confirm("Está seguro de querer aprobar esta Oferta.");
            if (answer)
            {
                formobj.action = 'AprobarOfertaPracUge?idofer=' + id;
                return true;
            } else {
                return false;
            }

        }
    }
}
function RechazarofertapracUge(id) {
    var formobj = document.fromprogramaspre;
    var answer = confirm("Está seguro de querer rechazar esta Oferta.");
    if (answer)
    {
        formobj.action = 'RechazarOfertaPracUge?idofer=' + id;
        return true;
    }
    else {
        return false;
    }
}

function ObservacionOfer(id) {
    var formobj = document.fromprogramaspre;
    var obs_uge = document.getElementById('uge_obs').value;
    var url = 'ObservacionOferPracUge?idofer=' + id + '&obsv=' + obs_uge;
    formobj.action = url;
    return true;
}

function consultarEmpAdminP() {

    var tabla = document.getElementById('tablaEmpAdminP');
    var filas = tabla.rows;
    var tam = filas.length;
    for (var i = 1; i < tam; i++) {
        tabla.deleteRow(1);
    }
    //Realizar Peticion
    //alert('esto es bueno');
    //setVisibilidad(['RequerimientosConMov=inline']);
    var url = 'lisNomEmpAdminP?' + getValores(['nombreEmpAdminP', 'nitEmpAdminP']);
    conectarX(url, muestraEmpAdminP);
}
function consultaroferpracAdmin() {
    var tabla = document.getElementById('tablaoferpracAdmin');
    var filas = tabla.rows;
    var tam = filas.length;
    for (var i = 1; i < tam; i++) {
        tabla.deleteRow(1);
    }
    document.getElementById('consultarOfPracAdmin').disabled=true;
    document.getElementById('consultarOfPracAdmin').value='Consultando...';
    
    var url = 'lisOfertaPracAdmin?programapracAdmin=' + encodeURIComponent(document.getElementById('programapracAdmin').value); //getValores(['programapracAdmin']);
    conectarMethod(url, muestraOfertaspracAdmin, 'POST');
}
function consuloferTrapracAdmin() {
    var tabla = document.getElementById('tablaTraoferpracAdmin');
    var filas = tabla.rows;
    var tam = filas.length;
    for (var i = 1; i < tam; i++) {
        tabla.deleteRow(1);
    }
    var url = 'lisTramitarOferPrac';
    conectarMethod(url, muestraTramitarOfertasprac, 'POST');
}
function consultarpracticante() {

    var tabla = document.getElementById('tablaPracAdmin');
    var filas = tabla.rows;
    var tam = filas.length;
    for (var i = 1; i < tam; i++) {
        tabla.deleteRow(1);
    }
    
    document.getElementById('consultarpracticantes').value = 'Cargando...';
    document.getElementById('consultarpracticantes').disabled = true;
    
    var url = 'lisPracAdmin?' + "iddpto=" + document.getElementById("ProgramaAcademicoPrac").value + '&estado=' + document.getElementById("EstadoSolicitud").value;
    conectarX(url, muestraRegistrosAdmin);
}
function muestraEmpAdminP() {
    //alert('esto es bueno');
    if (http_request.readyState == 4) {
        if (http_request.status == 200) {

            var xmldoc = http_request.responseXML;
            var lista = xmldoc.getElementsByTagName("Nombres")[0];
            var reg = lista.getElementsByTagName("Nombre");
            var elementos = ["id_empresa", "razon_social", "nit", "estado_empresa"];
            var cuerpotablaEmpAdminP = document.getElementById('cuerpotablaEmpAdminP'), fila, est, nodo, nt, link, columna, div;
            var id = 0;

            for (var i = 0; i < reg.length; i++) {

                fila = cuerpotablaEmpAdminP.insertRow(0);
                id = reg[i].getElementsByTagName(elementos[2])[0].firstChild.nodeValue;
                //n = reg[i].getElementsByTagName(elementos[4])[0].firstChild.nodeValue;
                for (var j = 1; j <= 2; j++) {
                    columna = fila.insertCell(j - 1);
                    if (j <= 1) {
                        nodo = reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;

                        columna.innerHTML = " <a target='_blank' href='ActualizarInfoEmpAdmin?id_emp=" +
                                id + "'onclick='window.open(this.href,'ventana_','toolbar=no,scrollbars=yes,location=yes,directories=yes,status=no,menubar=no,resizable=yes'); return false;'>" + nodo + "</a>";

                    }
                    else {
                        est = reg[i].getElementsByTagName(elementos[3])[0].firstChild.nodeValue;

                        if (est.toString() == "grad_prac" || est.toString() == "prac")
                        {
                            columna.innerHTML = "activa";
                        }
                        else {
                            columna.innerHTML = "<a>eliminada</a>";
                        }

                    }
                }

                //document.getElementById('buscar').style.visibility='visible'
            }
        }
    }
}
function muestraNomPrac() {
    //alert('esto es bueno');
    if (http_request.readyState == 4) {
        if (http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var lista = xmldoc.getElementsByTagName("Nombres")[0];
            var reg = lista.getElementsByTagName("Nombre");
            var elementos = ["id_est", "nom_est"];
            var cuerpotablaGradAdmin = document.getElementById('cuerpotablaGradAdmin'), fila, texto, nodo, nt, link, columna, div;
            var id = 0;
            var docgrad = 0;
            for (var i = 0; i < reg.length; i++) {

                fila = cuerpotablaGradAdmin.insertRow(0);
                id = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                //n = reg[i].getElementsByTagName(elementos[4])[0].firstChild.nodeValue;
                for (var j = 1; j <= 1; j++) {
                    if (j <= 1) {
                        nodo = reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                    }
                    columna = fila.insertCell(j - 1);
                    columna.innerHTML = " <a target='_blank' href='ActualizarInfoGradAdmin?id_est=" + id + "' onclick='window.open(this.href,'ventana_','toolbar=no,scrollbars=yes,location=yes,directories=yes,status=no,menubar=no,resizable=yes'); return false;'>" + nodo + "</a>";                   //}
                }
                //document.getElementById('buscar').style.visibility='visible'
            }
        }
    }

}
function  muestraOfertaspracAdmin() {

    if (http_request.readyState != 4) return;
    document.getElementById('consultarOfPracAdmin').disabled=false;
    document.getElementById('consultarOfPracAdmin').value='Consultar';
    if (http_request.status != 200) return;
    
    var xmldoc = http_request.responseXML;
    var lista = xmldoc.getElementsByTagName("listaofertas")[0];
    var reg = lista.getElementsByTagName("oferta");
    var elementos = ["id_oferta","cargo", "razon_social","fecha_limite"];
    var cuerpotablaofertaspracAdmin = document.getElementById('cuerpotablaofertaspracAdmin'), fila, texto, nodo, nt, estado, columna, div, link;
    var idofer = 0;
    for (var i = 0; i < reg.length; i++) {
        fila = cuerpotablaofertaspracAdmin.insertRow(i);
        idofer = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;

        for (var j = 1; j <= 3; j++) {
            nodo = reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
            columna = fila.insertCell(j - 1);
            div = document.createElement("div");
            
            if (j > 1) {
                div.setAttribute("align", "center");
            } else {
                div.setAttribute("align", "left");
            }
            
            if (j == 1) {
                columna.innerHTML = " <a target='_blank' href='VerOfertaEmpAdminP?idofer=" +
                    idofer + "'onclick='window.open(this.href,'ventana_','toolbar=no,scrollbars=yes,location=yes,directories=yes,status=no,menubar=no,resizable=yes'); return false;'>" + nodo + "</a>";
            } else {
                texto = document.createTextNode(nodo);
                div.appendChild(texto);
                columna.appendChild(div);
            }
        }
                
        columna = fila.insertCell(3);
        columna.innerHTML = " <a target='_blank' href='VerAplicantesOferPracAdmin?idofer=" +
            idofer + "'onclick='window.open(this.href,'ventana_','toolbar=no,scrollbars=yes,location=yes,directories=yes,status=no,menubar=no,resizable=yes'); return false;'>Ver Postulantes</a>";
    }
                //document.getElementById('buscar').style.visibility='visible'
}
function  muestraTramitarOfertasprac() {

    if (http_request.readyState == 4) {
        if (http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var lista = xmldoc.getElementsByTagName("listaofertas")[0];
            var reg = lista.getElementsByTagName("oferta");
            var elementos = ["id_oferta", "nit", "cargo", "razon_social", "fecha_limite", "uge_obs"];
            var cuerpotablaTraoferpracAdmin = document.getElementById('cuerpotablaTraoferpracAdmin'), fila, texto, nodo, nt, estado, columna, div, link;
            var idofer = 0;
            for (var i = 0; i < reg.length; i++) {
                fila = cuerpotablaTraoferpracAdmin.insertRow(i);
                idofer = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;

                for (var j = 1; j <= 4; j++) {
                    nodo = reg[i].getElementsByTagName(elementos[j + 1])[0].firstChild.nodeValue;
                    columna = fila.insertCell(j - 1);
                    div = document.createElement("div");
                    if (j > 1 && j < 4) {
                        div.setAttribute("align", "center");
                    } else {
                        div.setAttribute("align", "left");
                    }
                    if (j == 1) {
                        columna.innerHTML = " <a target='_blank' href='TramitarOfertaAdminPrac?idofer=" +
                                idofer + "'onclick='window.open(this.href,'ventana_','toolbar=no,scrollbars=yes,location=yes,directories=yes,status=no,menubar=no,resizable=yes'); return false;'>" + nodo + "</a>";
                    }
                    else {
                        texto = document.createTextNode(nodo);
                        div.appendChild(texto);
                        columna.appendChild(div);

                    }//}


                }
                //document.getElementById('buscar').style.visibility='visible'
            }
        }
    }
}

//Se inutiliza porque no se encuentra dónde se utiliza, y contiene el vínculo de VerCartaPracDec utilizado para la formalización de prácticas.
//se va a cambiar el contenido de VerCartaPracAdmin

/*function muestraPracticantesAdmin() {
    if (http_request.readyState == 4) {
        if (http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var lista = xmldoc.getElementsByTagName("lisAplicaciones")[0];
            var reg = lista.getElementsByTagName("Aplicacion");
            var elementos = ["id_aplicacion", "nom_est", "razon_social", "cargo", "id_empresa"];
            var cuerpotablaPracAdmin = document.getElementById('cuerpotablaPracAdmin'), fila, texto, nodo, nt, estado, columna, div, link;
            var id_sol = 0;
            var idreq = 0;
            var idemp = 0;
            for (var i = 0; i < reg.length; i++) {
                fila = cuerpotablaPracAdmin.insertRow(0);
                id_sol = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                //idreq= reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                //idemp=reg[i].getElementsByTagName(elementos[5])[0].firstChild.nodeValue;
                for (var j = 1; j <= 3; j++) {
                    nodo = reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                    columna = fila.insertCell(j - 1);
                    div = document.createElement("div");
                    if (j > 1) {
                        div.setAttribute("align", "center");
                    } else {
                        div.setAttribute("align", "left");
                    }
                    if (j == 1) {
                        columna.innerHTML = " <a target='_blank' href='VerCartaPracDec?ida=" +
                                id_sol + "'onclick='window.open(this.href,'ventana_','toolbar=no,scrollbars=yes,location=yes,directories=yes,status=no,menubar=no,resizable=yes'); return false;'>" + nodo + "</a>";
                    }
                    else {
                        if (j == 2) {
                            columna.innerHTML = nodo;
                        }
                        else {
                            texto = document.createTextNode(nodo);
                            div.appendChild(texto);
                            columna.appendChild(div);
                        }
                    }//}
                }
                //document.getElementById('buscar').style.visibility='visible'
            }
        }
    }
}*/

function muestraRegistrosAdmin() {
    if (http_request.readyState == 4) {
        document.getElementById('consultarpracticantes').value = 'Consultar';
        document.getElementById('consultarpracticantes').disabled = false;
        if (http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var lista = xmldoc.getElementsByTagName("lisRegistros")[0];
            var reg = lista.getElementsByTagName("Registro");
            var elementos = ["id_documento", "nom_est", "estado"];
            var cuerpotablaPracAdmin = document.getElementById('cuerpotablaPracAdmin'), fila, texto, nodo, nt, estado, columna, div, link;
            var id_doc = 0;
            var idreq = 0;
            var idemp = 0;
            for (var i = 0; i < reg.length; i++) {
                fila = cuerpotablaPracAdmin.insertRow(0);
                id_doc = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                //idreq= reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                //idemp=reg[i].getElementsByTagName(elementos[5])[0].firstChild.nodeValue;
                for (var j = 1; j < 3; j++) {
                    nodo = reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                    columna = fila.insertCell(j - 1);
                    div = document.createElement("div");
                    if (j > 1) {
                        div.setAttribute("align", "center");
                    } else {
                        div.setAttribute("align", "left");
                    }
                    if (j == 1) {
                        columna.innerHTML = " <a target='_blank' href='infoPracAdmin?ca=" +
                                id_doc + "'onclick='window.open(this.href,'ventana_','toolbar=no,scrollbars=yes,location=yes,directories=yes,status=no,menubar=no,resizable=yes'); return false;'>" + nodo + "</a>";
                    }
                    else {
                        if (j == 2) {
                            columna.innerHTML = nodo;
                        }
                        else {
                            texto = document.createTextNode(nodo);
                            div.appendChild(texto);
                            columna.appendChild(div);
                        }
                    }//}
                }
                //document.getElementById('buscar').style.visibility='visible'
            }
        }
    }
}
function registrarFecPrac() {
    if (!validaFechaCompleta(document.getElementById("fechainEst").value) || !validaFechaCompleta(document.getElementById("fechaouteEst").value)
            || !validaFechaCompleta(document.getElementById("fechainEmp").value) || !validaFechaCompleta(document.getElementById("fechaoutEmp").value)
||!validaFechaCompleta(document.getElementById("fechainSolEst").value)||!validaFechaCompleta(document.getElementById("fechaoutSolEst").value)
||!validaFechaCompleta(document.getElementById("fechainDec").value)||!validaFechaCompleta(document.getElementById("fechaoutDec").value)
||!validaFechaCompleta(document.getElementById("fechainPracE").value)||!validaFechaCompleta(document.getElementById("fechaoutPracE").value)) {
        return false;
    } else {
        var url = 'registararFechasPrac?' + "fechainEst=" + document.getElementById("fechainEst").value + '&fechaouteEst=' + document.getElementById("fechaouteEst").value
                + '&fechainEmp=' + document.getElementById("fechainEmp").value + '&fechaoutEmp=' + document.getElementById("fechaoutEmp").value
            + '&fechainSolEst=' + document.getElementById("fechainSolEst").value+ '&fechaoutSolEst=' + document.getElementById("fechaoutSolEst").value
      + '&fechainDec=' + document.getElementById("fechainDec").value+ '&fechaoutDec=' + document.getElementById("fechaoutDec").value
+ '&fechainPracE=' + document.getElementById("fechainPracE").value+ '&fechaoutPracE=' + document.getElementById("fechaoutPracE").value;
        conectarX(url, muestraResultadoreload);
    }

}