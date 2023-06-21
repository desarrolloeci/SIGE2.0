/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function verconsultagradAdmin()
{
    setVisibilidad(['ConsultaGradAdmin=inline', 'tablaConsultaGradAdmin=inline', 'ConsultaEmpAdminG=none', 'tablaConsultaEmpAdminG=none',
        'consultaofergradAdmin=none', 'botonconsultaofergradAdmin=none', 'tablaofertasgradAdmin=none', 'emailAdminG=none',
        'editaofergradAdmin=none', 'botonconsultarEliminarofer=none', 'tablaEditarofertasgrad=none', 'ConsultaTramOferGrad=none']);
}

function verconsultaTramOferAdminG()
{
    setVisibilidad(['ConsultaGradAdmin=inline', 'tablaConsultaGradAdmin=inline', 'ConsultaEmpAdminG=none', 'tablaConsultaEmpAdminG=none',
        'consultaofergradAdmin=none', 'botonconsultaofergradAdmin=none', 'tablaofertasgradAdmin=none', 'emailAdminG=none',
        'editaofergradAdmin=none', 'botonconsultarEliminarofer=none', 'tablaEditarofertasgrad=none', 'ConsultaTramOferGrad=none']);
}

function verconsultaEmpAdminG()
{
    setVisibilidad(['ConsultaGradAdmin=none', 'tablaConsultaGradAdmin=none', 'ConsultaEmpAdminG=inline', 'tablaConsultaEmpAdminG=inline',
        'consultaofergradAdmin=none', 'botonconsultaofergradAdmin=none', 'tablaofertasgradAdmin=none', 'emailAdminG=none',
        'editaofergradAdmin=none', 'botonconsultarEliminarofer=none', 'tablaEditarofertasgrad=none', 'ConsultaTramOferGrad=none']);
}
function verconsultaOferAdminG()
{
    setVisibilidad(['ConsultaGradAdmin=none', 'tablaConsultaGradAdmin=none', 'ConsultaEmpAdminG=none', 'tablaConsultaEmpAdminG=none',
        'consultaofergradAdmin=inline', 'botonconsultaofergradAdmin=inline', 'tablaofertasgradAdmin=inline', 'emailAdminG=none',
        'editaofergradAdmin=none', 'botonconsultarEliminarofer=none', 'tablaEditarofertasgrad=none', 'ConsultaTramOferGrad=none']);
}
function vereliminarOferAdminG() {
    setVisibilidad(['ConsultaGradAdmin=none', 'tablaConsultaGradAdmin=none', 'ConsultaEmpAdminG=none', 'tablaConsultaEmpAdminG=none',
        'consultaofergradAdmin=none', 'botonconsultaofergradAdmin=none', 'tablaofertasgradAdmin=none', 'emailAdminG=none',
        'editaofergradAdmin=inline', 'botonconsultarEliminarofer=inline', 'tablaEditarofertasgrad=inline', 'ConsultaTramOferGrad=none']);
}
function veremailmasivoAdminG()
{
    setVisibilidad(['ConsultaGradAdmin=none', 'tablaConsultaGradAdmin=none', 'ConsultaEmpAdminG=none', 'tablaConsultaEmpAdminG=none',
        'consultaofergradAdmin=none', 'botonconsultaofergradAdmin=none', 'tablaofertasgradAdmin=none', 'emailAdminG=inline',
        'editaofergradAdmin=none', 'botonconsultarEliminarofer=none', 'tablaEditarofertasgrad=none', 'ConsultaTramOferGrad=none']);
}
function verconsultaTramOferAdminG()
{
    setVisibilidad(['ConsultaGradAdmin=none', 'tablaConsultaGradAdmin=none', 'ConsultaEmpAdminG=none', 'tablaConsultaEmpAdminG=none',
        'consultaofergradAdmin=none', 'botonconsultaofergradAdmin=none', 'tablaofertasgradAdmin=none', 'emailAdminG=none',
        'editaofergradAdmin=none', 'botonconsultarEliminarofer=none', 'tablaEditarofertasgrad=none', 'ConsultaTramOferGrad=inline']);
    var tabla = document.getElementById('tablaTramOferGrad');
    var filas = tabla.rows;
    var tam = filas.length;
    for (var i = 1; i < tam; i++) {
        tabla.deleteRow(1);
    }
    var url = 'lisOfertaTramAdminG?' + getValores(['programagradAdmin']);
    conectarMethod(url, muestraTramOfertasAdminG, 'POST');
}
function verReporteGrad() {
    setVisibilidad(['tituloReporteGrad=inline', 'tituloReporteDisG=none', 'tituloReporteAfiG=none', 'tituloReporteIdioG=none',
        'tituloReporteEstG=none', 'tituloReporteExpG=none', 'tituloReporteEmpG=none', 'tituloReporteOferG=none',
        'tituloReporteApliG=none', 'ProgramaReporteG=inline', 'FechasReporteG=inline', 'botonReporteGrad=inline', 'botonReporteDisG=none',
        'botonReporteAfiG=none', 'botonReporteIdioG=none', 'botonReporteEstG=none', 'botonReporteExpG=none', 'botonReporteEmpG=none',
        'botonReporteOferG=none', 'botonReporteApliG=none', 'checkReporteGrad=inline', 'checkReporteDisG=none', 'checkReporteAfiG=none',
        'checkReporteIdioG=none', 'checkReporteEstG=none', 'checkReporteExpG=none', 'checkReporteEmpG=none', 'checkReporteOferG=none',
        'checkReporteApliG=none']);
}
function verReporteGradMon() {
    setVisibilidad(['tituloReporteGrad=inline', 'tituloReporteDisG=none', 'tituloReporteAfiG=none', 'tituloReporteIdioG=none',
        'tituloReporteEstG=none', 'tituloReporteExpG=none', 'tituloReporteEmpG=none', 'tituloReporteOferG=none',
        'tituloReporteApliG=none', 'ProgramaReporteG=inline', 'FechasReporteG=inline', 'botonReporteGrad=inline', 'botonReporteDisG=none',
        'botonReporteAfiG=none', 'botonReporteIdioG=none', 'botonReporteEstG=none', 'botonReporteExpG=none', 'botonReporteEmpG=none',
        'botonReporteOferG=none', 'botonReporteApliG=none', 'checkReporteGrad=none', 'checkReporteDisG=none', 'checkReporteAfiG=none',
        'checkReporteIdioG=none', 'checkReporteEstG=none', 'checkReporteExpG=none', 'checkReporteEmpG=none', 'checkReporteOferG=none',
        'checkReporteApliG=none']);
}
function verReporteDisG() {
    setVisibilidad(['tituloReporteGrad=none', 'tituloReporteDisG=inline', 'tituloReporteAfiG=none', 'tituloReporteIdioG=none',
        'tituloReporteEstG=none', 'tituloReporteExpG=none', 'tituloReporteEmpG=none', 'tituloReporteOferG=none',
        'tituloReporteApliG=none', 'ProgramaReporteG=inline', 'FechasReporteG=inline', 'botonReporteGrad=none', 'botonReporteDisG=inline',
        'botonReporteAfiG=none', 'botonReporteIdioG=none', 'botonReporteEstG=none', 'botonReporteExpG=none', 'botonReporteEmpG=none',
        'botonReporteOferG=none', 'botonReporteApliG=none', 'checkReporteGrad=none', 'checkReporteDisG=inline', 'checkReporteAfiG=none',
        'checkReporteIdioG=none', 'checkReporteEstG=none', 'checkReporteExpG=none', 'checkReporteEmpG=none', 'checkReporteOferG=none']);
}
function verReporteAfiG() {
    setVisibilidad(['tituloReporteGrad=none', 'tituloReporteDisG=none', 'tituloReporteAfiG=inline', 'tituloReporteIdioG=none',
        'tituloReporteEstG=none', 'tituloReporteExpG=none', 'tituloReporteEmpG=none', 'tituloReporteOferG=none',
        'tituloReporteApliG=none', 'ProgramaReporteG=inline', 'FechasReporteG=inline', 'botonReporteGrad=none', 'botonReporteDisG=none',
        'botonReporteAfiG=inline', 'botonReporteIdioG=none', 'botonReporteEstG=none', 'botonReporteExpG=none', 'botonReporteEmpG=none',
        'botonReporteOferG=none', 'botonReporteApliG=none', 'checkReporteGrad=none', 'checkReporteDisG=none', 'checkReporteAfiG=inline',
        'checkReporteIdioG=none', 'checkReporteEstG=none', 'checkReporteExpG=none', 'checkReporteEmpG=none', 'checkReporteOferG=none']);

}
function verReporteIdioG() {
    setVisibilidad(['tituloReporteGrad=none', 'tituloReporteDisG=none', 'tituloReporteAfiG=none', 'tituloReporteIdioG=inline',
        'tituloReporteEstG=none', 'tituloReporteExpG=none', 'tituloReporteEmpG=none', 'tituloReporteOferG=none',
        'tituloReporteApliG=none', 'ProgramaReporteG=inline', 'FechasReporteG=none', 'botonReporteGrad=none', 'botonReporteDisG=none',
        'botonReporteAfiG=none', 'botonReporteIdioG=inline', 'botonReporteEstG=none', 'botonReporteExpG=none', 'botonReporteEmpG=none',
        'botonReporteOferG=none', 'botonReporteApliG=none', 'checkReporteGrad=none', 'checkReporteDisG=none', 'checkReporteAfiG=none',
        'checkReporteIdioG=inline', 'checkReporteEstG=none', 'checkReporteExpG=none', 'checkReporteEmpG=none', 'checkReporteOferG=none']);
}
function verReporteEstG() {
    setVisibilidad(['tituloReporteGrad=none', 'tituloReporteDisG=none', 'tituloReporteAfiG=none', 'tituloReporteIdioG=none',
        'tituloReporteEstG=inline', 'tituloReporteExpG=none', 'tituloReporteEmpG=none', 'tituloReporteOferG=none',
        'tituloReporteApliG=none', 'ProgramaReporteG=inline', 'FechasReporteG=inline', 'botonReporteGrad=none', 'botonReporteDisG=none',
        'botonReporteAfiG=none', 'botonReporteIdioG=none', 'botonReporteEstG=inline', 'botonReporteExpG=none', 'botonReporteEmpG=none',
        'botonReporteOferG=none', 'botonReporteApliG=none', 'checkReporteGrad=none', 'checkReporteDisG=none', 'checkReporteAfiG=none',
        'checkReporteIdioG=none', 'checkReporteEstG=inline', 'checkReporteExpG=none', 'checkReporteEmpG=none', 'checkReporteOferG=none']);
}
function verReporteExpG() {
    setVisibilidad(['tituloReporteGrad=none', 'tituloReporteDisG=none', 'tituloReporteAfiG=none', 'tituloReporteIdioG=none',
        'tituloReporteEstG=none', 'tituloReporteExpG=inline', 'tituloReporteEmpG=none', 'tituloReporteOferG=none',
        'tituloReporteApliG=none', 'ProgramaReporteG=inline', 'FechasReporteG=inline', 'botonReporteGrad=none', 'botonReporteDisG=none',
        'botonReporteAfiG=none', 'botonReporteIdioG=none', 'botonReporteEstG=none', 'botonReporteExpG=inline', 'botonReporteEmpG=none',
        'botonReporteOferG=none', 'botonReporteApliG=none', 'checkReporteGrad=none', 'checkReporteDisG=none', 'checkReporteAfiG=none',
        'checkReporteIdioG=none', 'checkReporteEstG=none', 'checkReporteExpG=inline', 'checkReporteEmpG=none', 'checkReporteOferG=none']);
}
function verReporteEmpG() {
    setVisibilidad(['tituloReporteGrad=none', 'tituloReporteDisG=none', 'tituloReporteAfiG=none', 'tituloReporteIdioG=none',
        'tituloReporteEstG=none', 'tituloReporteExpG=none', 'tituloReporteEmpG=inline', 'tituloReporteOferG=none',
        'tituloReporteApliG=none', 'ProgramaReporteG=none', 'FechasReporteG=inline', 'botonReporteGrad=none', 'botonReporteDisG=none',
        'botonReporteAfiG=none', 'botonReporteIdioG=none', 'botonReporteEstG=none', 'botonReporteExpG=none', 'botonReporteEmpG=inline',
        'botonReporteOferG=none', 'botonReporteApliG=none', 'checkReporteGrad=none', 'checkReporteDisG=none', 'checkReporteAfiG=none',
        'checkReporteIdioG=none', 'checkReporteEstG=none', 'checkReporteExpG=none', 'checkReporteEmpG=inline', 'checkReporteOferG=none']);
}
function verReporteOferG() {
    setVisibilidad(['tituloReporteGrad=none', 'tituloReporteDisG=none', 'tituloReporteAfiG=none', 'tituloReporteIdioG=none',
        'tituloReporteEstG=none', 'tituloReporteExpG=none', 'tituloReporteEmpG=none', 'tituloReporteOferG=inline',
        'tituloReporteApliG=none', 'ProgramaReporteG=none', 'FechasReporteG=inline', 'botonReporteGrad=none', 'botonReporteDisG=none',
        'botonReporteAfiG=none', 'botonReporteIdioG=none', 'botonReporteEstG=none', 'botonReporteExpG=none', 'botonReporteEmpG=none',
        'botonReporteOferG=inline', 'botonReporteApliG=none', 'checkReporteGrad=none', 'checkReporteDisG=none', 'checkReporteAfiG=none',
        'checkReporteIdioG=none', 'checkReporteEstG=none', 'checkReporteExpG=none', 'checkReporteEmpG=none', 'checkReporteOferG=inline']);
}
function verReporteApliG() {
    setVisibilidad(['tituloReporteGrad=none', 'tituloReporteDisG=none', 'tituloReporteAfiG=none', 'tituloReporteIdioG=none',
        'tituloReporteEstG=none', 'tituloReporteExpG=none', 'tituloReporteEmpG=none', 'tituloReporteOferG=none',
        'tituloReporteApliG=inline', 'ProgramaReporteG=none', 'FechasReporteG=inline', 'botonReporteGrad=none', 'botonReporteDisG=none',
        'botonReporteAfiG=none', 'botonReporteIdioG=none', 'botonReporteEstG=none', 'botonReporteExpG=none', 'botonReporteEmpG=none',
        'botonReporteOferG=none', 'botonReporteApliG=inline', 'checkReporteGrad=none', 'checkReporteDisG=none', 'checkReporteAfiG=none',
        'checkReporteIdioG=none', 'checkReporteEstG=none', 'checkReporteExpG=none', 'checkReporteEmpG=none', 'checkReporteOferG=none']);
}

function actuaizardatosempAdmin() {
    var paisSel = document.getElementById("paisemp").options[document.getElementById("paisemp").selectedIndex].value;
    var ciudadSel = document.getElementById("ciudademp").options[document.getElementById("ciudademp").selectedIndex].value;
    if(paisSel=="" || ciudadSel==""){
        alert("Diligencie el país y ciudad");
        return;
    }else{
        var url = 'ActDatEmpresa?' + getValores(['nit', 'rasocial', 'paisemp', 'ciudademp', 'diremp', 'webemp', 'emailemp', 'telemp', 'nomconte', 'cargoconte', 'areaconte', 'porfconte', 'telconte', 'faxconte', 'emailconte', 'celconte']);
        conectarMethod(url, muestraResultadoclose, 'POST');
    }
}
function reiniciarpassEmp(nit) {
    var answer = confirm("Está seguro de querer Reiniciar la contraseña de esta empresa.");
    if (answer)
    {
        var url = 'reiniciarpassEmp?nit=' + nit;
        conectarMethod(url, muestraResultado, 'POST');
    }
}
function EliminarempAdminG(nit) {
    var answer = confirm("Está seguro de querer Eliminar esta empresa.");
    if (answer)
    {
        var url = 'ElminarEmpAdminGrad?nit=' + nit;
        conectarMethod(url, muestraResultadoclose, 'POST');
    }
}
function consultargraduado() {
    var documento=document.getElementById('DocGrad').value;
    if(false){
        alert("Por favor diligencie el campo Documento");
    }else{
        var tabla = document.getElementById('tablaGradAdmin');
        var filas = tabla.rows;
        var tam = filas.length;
        for (var i = 1; i < tam; i++) {
            tabla.deleteRow(1);
        }
        //Realizar Peticion
        //alert('esto es bueno');
        //setVisibilidad(['RequerimientosConMov=inline']);
        var url = 'lisNomgradAdmin?' + getValores(['nombregrad', 'apellidograd', 'DocGrad', 'usuario']);
        conectarX(url, muestraNomgrad);
    }
    
}


function consultargraduado2() {

    var tabla = document.getElementById('tablaGradAdmin');
    var filas = tabla.rows;
    var tam = filas.length;
    for (var i = 1; i < tam; i++) {
        tabla.deleteRow(1);
    }
  
    var url = 'lisNomgradAdmin2?'+getValores(['usuario']);
    conectarX(url, muestraNomgrad);
}

function consultarEmpAdminG() {

    var tabla = document.getElementById('tablaEmpAdminG');
    var filas = tabla.rows;
    var tam = filas.length;
    for (var i = 1; i < tam; i++) {
        tabla.deleteRow(1);
    }
    //Realizar Peticion
    //alert('esto es bueno');
    //setVisibilidad(['RequerimientosConMov=inline']);
    var url = 'lisNomEmpAdminG?' + getValores(['nombreEmpAdminG', 'nitEmpAdminG']);
    conectarX(url, muestraEmpAdminG);
}
function consultarofergradAdmin() {
    var tabla = document.getElementById('tablaofergradAdmin');
    var filas = tabla.rows;
    var tam = filas.length;
    for (var i = 1; i < tam; i++) {
        tabla.deleteRow(1);
    }
    var url = 'lisOfertaGradAdmin?' + getValores(['programagradAdmin']);
    conectarMethod(url, muestraOfertasgradAdmin, 'POST');
}
function consultarEliminarofer() {
    var tabla = document.getElementById('tablaEditarofergrad');
    var filas = tabla.rows;
    var tam = filas.length;
    for (var i = 1; i < tam; i++) {
        tabla.deleteRow(1);
    }
    var url = 'lisEliminarOfertaGrad?' + getValores(['nit_elm']);
    conectarMethod(url, muestraEliminarOfertaGrad, 'POST');
}
function EnviaremailgradAdmin() {
    var mensajeAdminG = nicEditors.findEditor('mensajeAdminG').getContent();
    ;
    var url = 'EmailMasivoGrad?' + getValores(['programaEmailAdmin', 'fechainemailG', 'fechaoutemailG', 'asuntoemailmas']) + "&mensajeAdminG=" + mensajeAdminG;
    conectarX(url, muestraResultadoreload);
}
function EliminarOfertaGrad(IdOfer, usr) {
    var answer2 = confirm("Al eliminar la oferta laboral, también eliminara las Postulaciones asociadas a ella.");
    var answer = confirm("Está seguro de querer ELIMINAR esta oferta laboral.");
    if (answer)
    {
        var url = 'EliminarOfertaGrad?' + "IdOfer=" + IdOfer + "&usr=" + usr;
        conectarMethod(url, muestraResultadoreload, 'POST');
    }
}
function  muestraEliminarOfertaGrad() {

    if (http_request.readyState == 4) {
        if (http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var lista = xmldoc.getElementsByTagName("listaofertas")[0];
            var reg = lista.getElementsByTagName("oferta");
            var elementos = ["id_oferta", "cargo", "razon_social", "fecha_limite", "nit"];
            var cuerpotablaEditarofertasgrad = document.getElementById('cuerpotablaEditarofertasgrad'), fila, texto, nodo, nt, estado, columna, div, link;
            var idofer = 0;
            for (var i = 0; i < reg.length; i++) {
                fila = cuerpotablaEditarofertasgrad.insertRow(0);
                idofer = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;

                for (var j = 1; j <= 4; j++) {
                    nodo = reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                    columna = fila.insertCell(j - 1);
                    div = document.createElement("div");
                    if (j > 1) {
                        div.setAttribute("align", "center");
                    } else {
                        div.setAttribute("align", "left");
                    }
                    if (j == 1) {
                        columna.innerHTML = " <a target='_blank' href='EliminarOfertaAdminG?idofer=" +
                                idofer + "'onclick='window.open(this.href,'ventana_','toolbar=no,scrollbars=yes,location=yes,directories=yes,status=no,menubar=no,resizable=yes'); return false;'>" + nodo + "</a>";
                    }
                    else {
                        if (j == 4) {
                            columna.innerHTML = " <a target='_blank' href=' VerAplicantesOferGradAdmin?idofer=" +
                                    idofer + "'onclick='window.open(this.href,'ventana_','toolbar=no,scrollbars=yes,location=yes,directories=yes,status=no,menubar=no,resizable=yes'); return false;'>Ver Postulantes</a>";
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
function  muestraOfertasgradAdmin() {

    if (http_request.readyState == 4) {
        if (http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var lista = xmldoc.getElementsByTagName("listaofertas")[0];
            var reg = lista.getElementsByTagName("oferta");
            var elementos = ["id_oferta", "cargo", "razon_social", "fecha_limite", "nit"];
            var cuerpotablaofertasgradAdmin = document.getElementById('cuerpotablaofertasgradAdmin'), fila, texto, nodo, nt, estado, columna, div, link;
            var idofer = 0;
            for (var i = 0; i < reg.length; i++) {
                fila = cuerpotablaofertasgradAdmin.insertRow(0);
                idofer = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;

                for (var j = 1; j <= 4; j++) {
                    nodo = reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                    columna = fila.insertCell(j - 1);
                    div = document.createElement("div");
                    if (j > 1) {
                        div.setAttribute("align", "center");
                    } else {
                        div.setAttribute("align", "left");
                    }
                    if (j == 1) {
                        columna.innerHTML = " <a target='_blank' href='VerOfertaEmpAdminG?idofer=" +
                                idofer + "'onclick='window.open(this.href,'ventana_','toolbar=no,scrollbars=yes,location=yes,directories=yes,status=no,menubar=no,resizable=yes'); return false;'>" + nodo + "</a>";
                    }
                    else {
                        if (j == 4) {
                            columna.innerHTML = " <a target='_blank' href=' VerAplicantesOferGradAdmin?idofer=" +
                                    idofer + "'onclick='window.open(this.href,'ventana_','toolbar=no,scrollbars=yes,location=yes,directories=yes,status=no,menubar=no,resizable=yes'); return false;'>Ver Postulantes</a>";
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
function  muestraTramOfertasAdminG() {

    if (http_request.readyState == 4) {
        if (http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var lista = xmldoc.getElementsByTagName("listaofertas")[0];
            var reg = lista.getElementsByTagName("oferta");
            var elementos = ["id_oferta", "cargo", "razon_social", "nit", "fecha_limite"];
            var cuerpotablaTramOferGrad = document.getElementById('cuerpotablaTramOferGrad'), fila, texto, nodo, nt, estado, columna, div, link;
            var idofer = 0;
            for (var i = 0; i < reg.length; i++) {
                fila = cuerpotablaTramOferGrad.insertRow(0);
                idofer = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;

                for (var j = 1; j <= 4; j++) {
                    nodo = reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                    columna = fila.insertCell(j - 1);
                    div = document.createElement("div");
                    if (j > 1) {
                        div.setAttribute("align", "center");
                    } else {
                        div.setAttribute("align", "left");
                    }
                    if (j == 1) {
                        columna.innerHTML = " <a target='_blank' href='TramitarOfertaAdminGrad?idofer=" +
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
function muestraEmpAdminG() {
    //alert('esto es bueno');
    if (http_request.readyState == 4) {
        if (http_request.status == 200) {

            var xmldoc = http_request.responseXML;
            var lista = xmldoc.getElementsByTagName("Nombres")[0];
            var reg = lista.getElementsByTagName("Nombre");
            var elementos = ["id_empresa", "razon_social", "nit", "estado_empresa"];
            var cuerpotablaEmpAdminG = document.getElementById('cuerpotablaEmpAdminG'), fila, est, nodo, nt, link, columna, div;
            var id = 0;

            for (var i = 0; i < reg.length; i++) {

                fila = cuerpotablaEmpAdminG.insertRow(0);
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

                        if (est == "grad_prac" || est == "grad")
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
function muestraNomgrad() {
    //alert('esto es bueno');
    if (http_request.readyState == 4) {
        if (http_request.status == 200) {

            var xmldoc = http_request.responseXML;
            var lista = xmldoc.getElementsByTagName("Nombres")[0];
            var reg = lista.getElementsByTagName("Nombre");
            var elementos = ["id_est", "nom_est", "nom_prog"];
            var cuerpotablaGradAdmin = document.getElementById('cuerpotablaGradAdmin'), fila, texto, nodo, nt, link, columna, div;
            var id = 0;
            var docgrad = 0;
            for (var i = 0; i < reg.length; i++) {
                id = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                if(id==="0"){
                    alert("Los criterios de la búsqueda deben ser más específicos");
                    break;
                }
                fila = cuerpotablaGradAdmin.insertRow(0);
                
                
                //n = reg[i].getElementsByTagName(elementos[4])[0].firstChild.nodeValue;
                for (var j = 1; j <= 2; j++) {
                   
                        nodo = reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                    
                    columna = fila.insertCell(j - 1);
                    if (j == 1){
                    columna.innerHTML = " <a target='_blank' href='ActualizarInfoGradAdmin?id_est=" + id + "' onclick='window.open(this.href,'ventana_','toolbar=no,scrollbars=yes,location=yes,directories=yes,status=no,menubar=no,resizable=yes'); return false;'>" + nodo + "</a>";                   //}
                    } if (j == 2){
                    columna.innerHTML = " <a target='_blank' href='ActualizarInfoGradAdmin?id_est=" + id + "' onclick='window.open(this.href,'ventana_','toolbar=no,scrollbars=yes,location=yes,directories=yes,status=no,menubar=no,resizable=yes'); return false;'>" + nodo + "</a>";                   //}
                    }
                }
                //document.getElementById('buscar').style.visibility='visible'
            }
        }
    }

}
function generarReporteGrad() {
    var fechain = document.getElementById("fechainG").value;
    var fechaout = document.getElementById("fechaoutG").value;
    var url;
    if (fechain == "" && fechaout == "") {
        url = 'reporteGrad?programagradAdmin=' + document.getElementById("programagradAdmin").value + "&" + getValores(['fechainG', 'fechaoutG']) + getCheckboxReporteGrad();
        //conectarMethod(url, muestraResultadoreload, 'POST');
        window.location = url
    }
    else {
        if (!validaFechaCompleta(document.getElementById("fechainG").value) || !validaFechaCompleta(document.getElementById("fechaoutG").value)) {
            return;
        }
        else {
            url = 'reporteGrad?' + getValores(['programagradAdmin', 'fechainG', 'fechaoutG']) + getCheckboxReporteGrad();
            //conectarMethod(url, muestraResultadoreload, 'POST');
            window.location = url
        }
    }
}
function generarReporteGradMon() {
    var fechain = document.getElementById("fechainG").value;
    var fechaout = document.getElementById("fechaoutG").value;
    var url;
    if (fechain == "" && fechaout == "") {
        url = 'reporteGradMon?programagradAdmin=' + document.getElementById("programagradAdmin").value + "&" + getValores(['fechainG', 'fechaoutG']) + getCheckboxReporteGrad();
        window.location = url
    } else {
        if (!validaFechaCompleta(document.getElementById("fechainG").value) || !validaFechaCompleta(document.getElementById("fechaoutG").value)) {
            return;
        }
        else {
            url = 'reporteGradMon?' + getValores(['programagradAdmin', 'fechainG', 'fechaoutG']) + getCheckboxReporteGrad();
            //conectarMethod(url, muestraResultadoreload, 'POST');
            window.location = url
        }
    }
}
function generarReporteDisG() {
    var fechain = document.getElementById("fechainG").value;
    var fechaout = document.getElementById("fechaoutG").value;
    var url;
    if (fechain == "" && fechaout == "") {
        url = 'reporteDisG?' + getValores(['programagradAdmin', 'fechainG', 'fechaoutG']) + getCheckboxReporteDisG();
        //conectarMethod(url, muestraResultadoreload, 'POST');
        window.location = url
    }
    else {
        if (!validaFechaCompleta(document.getElementById("fechainG").value) || !validaFechaCompleta(document.getElementById("fechaoutG").value)) {
            return;
        }
        else {
            url = 'reporteDisG?' + getValores(['programagradAdmin', 'fechainG', 'fechaoutG']) + getCheckboxReporteDisG();
            //conectarMethod(url, muestraResultadoreload, 'POST');
            window.location = url
        }
    }
}
function generarReporteAfiG() {
    var fechain = document.getElementById("fechainG").value;
    var fechaout = document.getElementById("fechaoutG").value;
    var url;
    if (fechain == "" && fechaout == "") {
        url = 'reporteAfiG?' + getValores(['programagradAdmin', 'fechainG', 'fechaoutG']) + getCheckboxReporteAfiG();
        //conectarMethod(url, muestraResultadoreload, 'POST');
        window.location = url
    }
    else {
        if (!validaFechaCompleta(document.getElementById("fechainG").value) || !validaFechaCompleta(document.getElementById("fechaoutG").value)) {
            return;
        }
        else {
            url = 'reporteAfiG?' + getValores(['programagradAdmin', 'fechainG', 'fechaoutG']) + getCheckboxReporteAfiG();
            //conectarMethod(url, muestraResultadoreload, 'POST');
            window.location = url
        }
    }
}
function generarReporteIdioG() {
    var url = 'reporteIdioG?' + getValores(['programagradAdmin', 'fechainG', 'fechaoutG']) + getCheckboxReporteIdioG();
    //conectarMethod(url, muestraResultadoreload, 'POST');
    window.location = url
}
function generarReporteEstG() {

    var fechain = document.getElementById("fechainG").value;
    var fechaout = document.getElementById("fechaoutG").value;
    var url;
    if (fechain == "" && fechaout == "") {
        url = 'reporteEstG?' + getValores(['programagradAdmin', 'fechainG', 'fechaoutG']) + getCheckboxReporteEstG();
        //conectarMethod(url, muestraResultadoreload, 'POST');
        window.location = url
    }
    else {
        if (!validaFechaCompleta(document.getElementById("fechainG").value) || !validaFechaCompleta(document.getElementById("fechaoutG").value)) {
            return;
        }
        else {
            url = 'reporteEstG?' + getValores(['programagradAdmin', 'fechainG', 'fechaoutG']) + getCheckboxReporteEstG();
            //conectarMethod(url, muestraResultadoreload, 'POST');
            window.location = url
        }
    }
}
function generarReporteExpG() {
    var fechain = document.getElementById("fechainG").value;
    var fechaout = document.getElementById("fechaoutG").value;
    var url;
    if (fechain == "" && fechaout == "") {
        url = 'reporteExpG?' + getValores(['programagradAdmin', 'fechainG', 'fechaoutG']) + getCheckboxReporteExpG();
        //conectarMethod(url, muestraResultadoreload, 'POST');
        window.location = url
    }
    else {
        if (!validaFechaCompleta(document.getElementById("fechainG").value) || !validaFechaCompleta(document.getElementById("fechaoutG").value)) {
            return;
        }
        else {
            url = 'reporteExpG?' + getValores(['programagradAdmin', 'fechainG', 'fechaoutG']) + getCheckboxReporteExpG();
            //conectarMethod(url, muestraResultadoreload, 'POST');
            window.location = url
        }
    }
}
function generarReporteEmpG() {
    var fechain = document.getElementById("fechainG").value;
    var fechaout = document.getElementById("fechaoutG").value;
    var url;
    if (fechain == "" && fechaout == "") {
        url = 'reporteEmpG?' + getValores(['programagradAdmin', 'fechainG', 'fechaoutG']) + getCheckboxReporteEmpG();
        //conectarMethod(url, muestraResultadoreload, 'POST');
        window.location = url
    }
    else {
        if (!validaFechaCompleta(document.getElementById("fechainG").value) || !validaFechaCompleta(document.getElementById("fechaoutG").value)) {
            return;
        }
        else {
            url = 'reporteEmpG?' + getValores(['programagradAdmin', 'fechainG', 'fechaoutG']) + getCheckboxReporteEmpG();
            //conectarMethod(url, muestraResultadoreload, 'POST');
            window.location = url
        }
    }
}
function generarReporteOferG() {
    var fechain = document.getElementById("fechainG").value;
    var fechaout = document.getElementById("fechaoutG").value;
    var url;
    if (fechain == "" && fechaout == "") {
        url = 'reporteOferG?' + getValores(['programagradAdmin', 'fechainG', 'fechaoutG']) + getCheckboxReporteOferG();
        //conectarMethod(url, muestraResultadoreload, 'POST');
        window.location = url
    }
    else {
        if (!validaFechaCompleta(document.getElementById("fechainG").value) || !validaFechaCompleta(document.getElementById("fechaoutG").value)) {
            return;
        }
        else {
            url = 'reporteOferG?' + getValores(['programagradAdmin', 'fechainG', 'fechaoutG']) + getCheckboxReporteOferG();
            //conectarMethod(url, muestraResultadoreload, 'POST');
            window.location = url
        }
    }
}
function generarReporteApliG() {
    var fechain = document.getElementById("fechainG").value;
    var fechaout = document.getElementById("fechaoutG").value;
    var url;
    if (fechain == "" && fechaout == "") {
        url = 'reporteApliG?' + getValores(['programagradAdmin', 'fechainG', 'fechaoutG']);
        //conectarMethod(url, muestraResultadoreload, 'POST');
        window.location = url
    }
    else {
        if (!validaFechaCompleta(document.getElementById("fechainG").value) || !validaFechaCompleta(document.getElementById("fechaoutG").value)) {
            return;
        }
        else {
            url = 'reporteApliG?' + getValores(['programagradAdmin', 'fechainG', 'fechaoutG']);
            //conectarMethod(url, muestraResultadoreload, 'POST');
            window.location = url
        }
    }
}
 function TramitarOfertaGrad(IdOfer, usr,tipo) {
    
    var answer = confirm('Está seguro de querer ' + (tipo == 'aprobar'?'APROBAR':'RECHAZAR') + ' esta oferta laboral.');
    
    if (answer) {
        var url = 'TramitarOfertaAdminG?' + "IdOfer=" + IdOfer + "&usr=" + usr + "&tip=" + tipo;
        conectarMethod(url, muestraResultadoreload, 'POST');
    }
}

function confirmEnviarMasivoGrad() {
    var getSelect = document.getElementById('programaEmailAdmin');
    var getOption = getSelect.options.item(getSelect.selectedIndex);
    if (getOption.value != 'AdminSige') {
        if (!confirm('¿Está seguro que desea iniciar el proceso de envío de correos a ' + getOption.innerHTML + '?\nRecuerde verificar que toda la información esté correcta.'))
            return false;
    }
}