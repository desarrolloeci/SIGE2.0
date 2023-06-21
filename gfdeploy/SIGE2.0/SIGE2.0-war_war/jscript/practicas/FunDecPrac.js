/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function verconsultaOfertaPracDec() {
    setVisibilidad(['consultaPracDec=inline',
                    'consultaPracDec2=none',
                    'consultaSolPracDec=none',
                    'consultaEstPracDec=none',
                    'botonconsultaOfertaPrac=inline',
                    'botonconsultaSolPracDec=none',
                    'botonconsultaEstPracDec=none',
                    'tablaconsultaOfertaPrac=inline',
                    'tablaconsultaSolPracDec=none',
                    'tablaconsultaEstPracDec=none',
                    'consultaPracFor=none',
                    'botonconsultaForPracDec=none',
                    'tablaconsultaForPracDec=none']);
}

function verconsultaSolPracDec() {
    setVisibilidad(['consultaPracDec=none',
                    'consultaPracDec2=none',
                    'consultaSolPracDec=inline',
                    'consultaEstPracDec=none',
                    'botonconsultaOfertaPrac=none',
                    'botonconsultaSolPracDec=inline',
                    'botonconsultaEstPracDec=none',
                    'tablaconsultaOfertaPrac=none',
                    'tablaconsultaSolPracDec=inline',
                    'tablaconsultaEstPracDec=none',
                    'consultaPracFor=none',
                    'botonconsultaForPracDec=none',
                    'tablaconsultaForPracDec=none']);
}

function verconsultaEstPracDec() {
    setVisibilidad(['consultaPracDec=none',
                    'consultaPracDec2=none',
                    'consultaSolPracDec=none',
                    'consultaEstPracDec=inline',
                    'botonconsultaOfertaPrac=none',
                    'botonconsultaSolPracDec=none',
                    'botonconsultaEstPracDec=inline',
                    'tablaconsultaOfertaPrac=none',
                    'tablaconsultaSolPracDec=none',
                    'tablaconsultaEstPracDec=inline',
                    'consultaPracFor=none',
                    'botonconsultaForPracDec=none',
                    'tablaconsultaForPracDec=none']);
}

function verconsultaForPracDec() {
    setVisibilidad(['consultaPracDec=none',
                    'consultaPracDec2=none',
                    'consultaSolPracDec=none',
                    'consultaEstPracDec=none',
                    'botonconsultaOfertaPrac=none',
                    'botonconsultaSolPracDec=none',
                    'botonconsultaEstPracDec=none',
                    'tablaconsultaOfertaPrac=none',
                    'tablaconsultaSolPracDec=none',
                    'tablaconsultaEstPracDec=none',
                    'consultaPracFor=inline',
                    'botonconsultaForPracDec=inline',
                    'tablaconsultaForPracDec=inline']);
}

function consultaForPracDec(rol) {
    var tabla = document.getElementById('TablaForPracDec');
    var filas = tabla.rows;
    var tam = filas.length;
    for (var i = 1; i < tam; i++) {
        tabla.deleteRow(1);
    }
    var url = 'lisForPracDec?' + "iddpto=" + rol + '&' + getValores(['TipoConsultaPracFor']);
    conectarX(url, muestraForPracDec);
}
function consultaOferPracDec(rol, tipo) {
    //Limpiar Tabla
    //document.getElementById('buscar').style.visibility='hidden';
    //var ProgramaAcademic= ProgramaAcademico.value;
    var tabla = document.getElementById('TablaOferPracDec');
    var filas = tabla.rows;
    var tam = filas.length;
    for (var i = 1; i < tam; i++) {
        tabla.deleteRow(1);
    }
    var url = 'lisOferPracDec?' + "iddpto=" + rol + '&TipoConsultaPracDec=' + tipo;
    conectarX(url, muestraOferPracDec);
}

function consultaSolPracDec(rol, tipo) {
    var tabla = document.getElementById('TablaSolPracDec');
    var filas = tabla.rows;
    var tam = filas.length;
    for (var i = 1; i < tam; i++) {
        tabla.deleteRow(1);
    }
    var url = 'lisSolPracDec?' + "iddpto=" + rol + '&TipoSolPracDec=' + tipo;
    conectarX(url, muestraSolPracDec);

}

function consultaEstPracDec(rol) {
    var tabla = document.getElementById('TablaEstPracDec');
    var filas = tabla.rows;
    var tam = filas.length;
    for (var i = 1; i < tam; i++) {
        tabla.deleteRow(1);
    }
    var url = 'lisEstPracDec?' + "iddpto=" + rol;
    conectarX(url, muestraEstPracDec);

}

function formalizartutor(id_prof, id_apli) {
    var answer = confirm("Está seguro de formalizar esta aplicacion.");
    if (answer)
    {
        var url2 = 'FormalizarPrac?id_apli=' + id_apli + '&clave=j&id_prof=' + id_prof;
        conectarMethod(url2, muestraResultadoreload, 'POST');
    }

}
function muestraForPracDec() {
    if (http_request.readyState == 4) {
        if (http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var lista = xmldoc.getElementsByTagName("lisAplicaciones")[0];
            var reg = lista.getElementsByTagName("Aplicacion");
            var elementos = ["id_aplicacion", "nom_est", "razon_social", "cargo", "nom_tutor"];
            var cuerpoTablaForPracDec = document.getElementById('cuerpoTablaForPracDec'), fila, texto, nodo, nt, estado, columna, div, link;
            var id_sol = 0;
            var idreq = 0;
            var idemp = 0;
            for (var i = 0; i < reg.length; i++) {
                fila = cuerpoTablaForPracDec.insertRow(i);
                id_sol = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                //idreq= reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                //idemp=reg[i].getElementsByTagName(elementos[5])[0].firstChild.nodeValue;
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
                        columna.innerHTML = " <a target='_blank' href='VerCartaPracDec?ida=" +
                                id_sol + "'onclick='window.open(this.href,'ventana_','toolbar=no,scrollbars=yes,location=yes,directories=yes,status=no,menubar=no,resizable=yes'); return false;'>" + nodo + "</a>";
                    } else if (j == 2) {
                        columna.innerHTML = nodo;
                    } else {
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
function muestraNombresTutor() {
    if (http_request.readyState == 4) {
        if (http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var lista = xmldoc.getElementsByTagName("lisTutores")[0];
            var reg = lista.getElementsByTagName("tutor");
            var elementos = ["id_prof", "nom_prof", "id_apli"];
            var cuerpotablatutores = document.getElementById('cuerpotablatutores'), fila, texto, nodo, nt, estado, columna, div, link;
            var id_sol = 0;
            var idreq = 0;
            var idemp = 0;
            for (var i = 0; i < reg.length; i++) {
                fila = cuerpotablatutores.insertRow(0);
                id_sol = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                idreq = reg[i].getElementsByTagName(elementos[2])[0].firstChild.nodeValue;
                //idemp=reg[i].getElementsByTagName(elementos[5])[0].firstChild.nodeValue;
                for (var j = 1; j <= 1; j++) {
                    nodo = reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                    columna = fila.insertCell(j - 1);
                    div = document.createElement("div");
                    if (j > 1) {
                        div.setAttribute("align", "center");
                    } else {
                        div.setAttribute("align", "left");
                    }

                    columna.innerHTML = " <input type='submit' class='inputlargo' value='" + nodo + "' name='consultartutor' onclick= 'mostraprofselec(" + id_sol + "," + idreq + ");'/>";

                    //}
                }
                //document.getElementById('buscar').style.visibility='visible'
            }
        }
    }
}
function muestraOferPracDec() {
    if (http_request.readyState == 4) {
        if (http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var lista = xmldoc.getElementsByTagName("lisOfertas")[0];
            var reg = lista.getElementsByTagName("oferta");
            var elementos = ["id_req", "id_oferta", "cargo", "razon_social", "fecha_limite", "id_empresa", "nit"];
            var cuerpotablaOfertaPrac = document.getElementById('cuerpotablaOfertaPrac'), fila, texto, nodo, nt, estado, columna, div, link;
            var idofer = 0;
            var idreq = 0;
            var idemp = 0;
            for (var i = 0; i < reg.length; i++) {
                fila = cuerpotablaOfertaPrac.insertRow(i);
                idofer = reg[i].getElementsByTagName(elementos[1])[0].firstChild.nodeValue;
                idreq = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                idemp = reg[i].getElementsByTagName(elementos[5])[0].firstChild.nodeValue;
                for (var j = 1; j <= 3; j++) {
                    nodo = reg[i].getElementsByTagName(elementos[j + 1])[0].firstChild.nodeValue;
                    columna = fila.insertCell(j - 1);
                    div = document.createElement("div");
                    if (j > 1) {
                        div.setAttribute("align", "center");
                    } else {
                        div.setAttribute("align", "left");
                    }
                    if (j == 1) {
                        columna.innerHTML = " <a target='_blank' href='VerOfertaPracDec?idofer=" +
                                idofer + "&idreq=" + idreq + "&idemp=" + idemp + "'onclick='window.open(this.href,'ventana_','toolbar=no,scrollbars=yes,location=yes,directories=yes,status=no,menubar=no,resizable=yes'); return false;'>" + nodo + "</a>";
                    }
                    else {
                        if (j == 2) {
                            columna.innerHTML = " <a >" + nodo + "</a>";
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
function muestraProfSelec() {
    if (http_request.readyState == 4) {
        if (http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var lista = xmldoc.getElementsByTagName("lisTutor")[0];
            var reg = lista.getElementsByTagName("tutor");
            var elementos = ["id_prof", "nom_prof", "id_apli"];
            var cuerpotablatutorSelec = document.getElementById('cuerpotablatutorSelec'), fila, texto, nodo, nt, estado, columna, div, link;
            var id_sol = 0;
            var idreq = 0;
            var idemp = 0;
            for (var i = 0; i < reg.length; i++) {
                fila = cuerpotablatutorSelec.insertRow(0);
                id_sol = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                nodo = reg[i].getElementsByTagName(elementos[1])[0].firstChild.nodeValue;
                idreq = reg[i].getElementsByTagName(elementos[2])[0].firstChild.nodeValue;
                //idemp=reg[i].getElementsByTagName(elementos[5])[0].firstChild.nodeValue;
                for (var j = 1; j <= 2; j++) {

                    columna = fila.insertCell(j - 1);
                    div = document.createElement("div");
                    if (j > 1) {
                        div.setAttribute("align", "center");
                    } else {
                        div.setAttribute("align", "left");
                    }
                    if (j == 1) {
                        columna.innerHTML = nodo;
                    }
                    else {
                        columna.innerHTML = "<input type='submit' value='Formalizar' name='formalizartutor' onclick= 'formalizartutor(" + id_sol + "," + idreq + ");'/>";
                    }

                    //}
                }
                //document.getElementById('buscar').style.visibility='visible'
            }
        }
    }
}
function muestraSolPracDec() {
    if (http_request.readyState == 4) {
        if (http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var lista = xmldoc.getElementsByTagName("lisSolicitudes")[0];
            var reg = lista.getElementsByTagName("solicitud");
            var elementos = ["id_sol", "nom_est", "jornada", "id_sol", "id_documento"];
            var cuerpoTablaSolPracDec = document.getElementById('cuerpoTablaSolPracDec'), fila, texto, nodo, nt, estado, columna, div, link;
            var id_sol = 0;
            var idreq = 0;
            var idemp = 0;
            for (var i = 0; i < reg.length; i++) {
                fila = cuerpoTablaSolPracDec.insertRow(0);
                id_sol = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                //idreq= reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                //idemp=reg[i].getElementsByTagName(elementos[5])[0].firstChild.nodeValue;
                for (var j = 1; j <= 2; j++) {
                    nodo = reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                    columna = fila.insertCell(j - 1);
                    div = document.createElement("div");
                    if (j > 1) {
                        div.setAttribute("align", "center");
                    } else {
                        div.setAttribute("align", "left");
                    }
                    if (j == 1) {
                        columna.innerHTML = " <a target='_blank' href='VerSolicitudPracDec?id_sol=" +
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
}

function muestraEstPracDec() {
    if (http_request.readyState != 4) return;
    if (http_request.status != 200) return;
    
    
    var xmlDoc = http_request.responseXML;
    var lista = xmlDoc.getElementsByTagName('lisEstudiantes');
    
    if (lista.length > 0) {
        
        var reg = lista[0].getElementsByTagName('estudiante');
        var cuerpoTablaEstPracDec = document.getElementById('cuerpoTablaEstPracDec');
        var fila;
        var columna;
        var idsol;
        var nombre;
        var estado;
        
        for (var i = 0; i < reg.length; i++) {
            fila = cuerpoTablaEstPracDec.insertRow(i);
            
            idsol = reg[i].getElementsByTagName('idsol')[0].firstChild.nodeValue;
            nombre = reg[i].getElementsByTagName('nombre')[0].firstChild.nodeValue;
            estado = reg[i].getElementsByTagName('est')[0].firstChild.nodeValue;
            
            columna = fila.insertCell(0);
            columna.innerHTML = '<a target="_blank" href="VerSolicitudPracDec?id_sol=' + idsol + '"'
                                + ' onclick="window.open(this.href,\'\',\'toolbar=no,scrollbars=yes,location=yes,directories=yes,status=no,menubar=no,resizable=yes\'">'
                                + nombre + '</a>';
            columna = fila.insertCell(1);
            columna.innerHTML = estado
        }
        
    } else {
        alert(xmlDoc.getElementsByTagName('valor')[0].firstChild.nodeValue);
    }
}

function mostraprofselec(id_prof, id_apli) {
    var tabla = document.getElementById('tablatutores');
    var filas = tabla.rows;
    var tam = filas.length;
    for (var i = 1; i < tam; i++) {
        tabla.deleteRow(1);
    }
    var tabla2 = document.getElementById('tablatutorSelec');
    var filas2 = tabla2.rows;
    var tam2 = filas2.length;
    for (var j = 1; j < tam2; j++) {
        tabla2.deleteRow(1);
    }
    var url = 'DatosTutor?id_t=' + id_prof + '&id_apli=' + id_apli;
    conectarMethod(url, muestraProfSelec, 'POST');

}
function AprobarOferprac(idreq) {
    var answer = confirm("Está seguro de querer aprobar esta Oferta.");
    if (answer)
    {
        var url2 = 'ActualizarEstOferPrac?' + "idreq=" + idreq + "&clave=b&" + getValores(['comentarioDecOferPrac']);
        conectarMethod(url2, muestraResultadoreload, 'POST');

    }
}
function AprobarSolprac(idreq) {
    var answer = confirm("Está seguro de querer aprobar esta Solicitud.");
    if (answer) {
        var url2 = 'ActualizarEstSolPrac?' + "idsol=" + idreq + "&clave=c&" + getValores(['comentarioDecSolPrac']);
        conectarMethod(url2, function() {
            if (http_request.readyState != 4) return;
            if (http_request.status != 200) return;
            
            var result = '';
            
            if (http_request.responseXML.childNodes.length > 0) {
                var xmlDoc = http_request.responseXML;
                var respuesta = xmlDoc.getElementsByTagName("resultado")[0];
                
                result = respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
            } else {
                var responseDoc = http_request.responseText;
                
                result = responseDoc.split('<valor>')[1].split('</valor>')[0];
            }
            
            alert(result);
            window.close();
            
        }, 'POST');
    }
}

function consultarprofesores(id_apli) {
    var tabla = document.getElementById('tablatutores');
    var filas = tabla.rows;
    var tam = filas.length;
    for (var i = 1; i < tam; i++) {
        tabla.deleteRow(1);
    }
    var url = 'lisNomTutores?id_apli=' + id_apli + "&" + getValores(['nombretutor', 'apellidotutor']);
    conectarMethod(url, muestraNombresTutor, 'POST');
}
function DevolverSolprac(idreq) {
    
    if (document.getElementById('comentarioDecSolPrac').value=='') {
        alert('Debe escribir un comentario al estudiante');
        return;
    }
    var answer = confirm("¿Está seguro de querer devolver esta solicitud?\nEl estudiante podrá editarla y volver a enviarla.");
    if (answer)
    {
        var url2 = 'ActualizarEstSolPrac?' + "idsol=" + idreq + "&clave=d&" + getValores(['comentarioDecSolPrac']);
        conectarMethod(url2, function() {
            if (http_request.readyState != 4) return;
            if (http_request.status != 200) return;
            
            var result = '';
            
            if (http_request.responseXML.childNodes.length > 0) {
                var xmlDoc = http_request.responseXML;
                var respuesta = xmlDoc.getElementsByTagName("resultado")[0];
                
                result = respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
            } else {
                var responseDoc = http_request.responseText;
                
                result = responseDoc.split('<valor>')[1].split('</valor>')[0];
            }
            
            alert(result);
            window.close();
            
        }, 'POST');

    }
}
function RechazarOferprac(idreq) {
    if (!isDiligenciado(['comentarioDecOferPrac'], ['Comentarios sobre la oferta'])) {
        return false;
    }
    else
    {
        var answer = confirm("Recuerde que sus comentarios serán enviados al correo registrado por la empresa.\n¿Desea continuar?");
        if (answer)
        {
            var url2 = 'ActualizarEstOferPrac?' + "idreq=" + idreq + "&clave=r&" + getValores(['comentarioDecOferPrac']);
            conectarMethod(url2, muestraResultadoreload, 'POST');

        }
    }
}

function RechazarSolprac(idreq) {
    
    if (document.getElementById('comentarioDecSolPrac').value=='') {
        alert('Debe escribir un comentario al estudiante');
        return;
    }
    
    var answer = confirm("¿Está seguro de querer rechazar esta solicitud?\nAl rechazarla, el estudiante no podrá volver a enviar solicitudes en el mismo semestre.");
    if (answer)
    {
        var url2 = 'ActualizarEstSolPrac?' + "idsol=" + idreq + "&clave=r&" + getValores(['comentarioDecSolPrac']);
        conectarMethod(url2, function() {
            if (http_request.readyState != 4) return;
            if (http_request.status != 200) return;
            
            var result = '';
            
            if (http_request.responseXML.childNodes.length > 0) {
                var xmlDoc = http_request.responseXML;
                var respuesta = xmlDoc.getElementsByTagName("resultado")[0];
                
                result = respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
            } else {
                var responseDoc = http_request.responseText;
                
                result = responseDoc.split('<valor>')[1].split('</valor>')[0];
            }
            
            alert(result);
            window.close();
            
        }, 'POST');

    }
}



