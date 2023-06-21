/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var id_doc=null;
function iniciarvariablesPrac(idest) {
    id_doc=idest;
}

function verActualizarinfopersonalPrac() {
    setVisibilidad(['ActDatosPrac=inline','EstPrac=none','tablaconsultaEstPrac=none','tablaconsultaDisPrac=none','DisPrac=none','AfiPrac=none','tablaconsultaAfiPrac=none','tablaconsultaIdioPrac=none','idioPrac=none','tablaconsultaExpPrac=none','ExpLPrac=none','ExpLPrac2=none']);
}

function verActualizarestudiosPrac() {
    setVisibilidad(['ActDatosPrac=none','EstPrac=inline','tablaconsultaEstPrac=inline','tablaconsultaDisPrac=none','DisPrac=none','AfiPrac=none','tablaconsultaAfiPrac=none','tablaconsultaIdioPrac=none','idioPrac=none','tablaconsultaExpPrac=none','ExpLPrac=none','ExpLPrac2=none']);
    var tabla=document.getElementById('tablaestudiosPrac');
        var filas=tabla.rows;
        var tam=filas.length;
        for (var i = 1; i < tam; i++) {
            tabla.deleteRow(1);
        }

        var url = 'lisEstgrad' + '?docgrad=' + id_doc;
        conectarX(url,muestraEstprac);
}

function verActualizarDistincionesPrac() {
    setVisibilidad(['ActDatosPrac=none','EstPrac=none','tablaconsultaEstPrac=none','tablaconsultaDisPrac=inline','DisPrac=inline','AfiPrac=none','tablaconsultaAfiPrac=none','tablaconsultaIdioPrac=none','idioPrac=none','tablaconsultaExpPrac=none','ExpLPrac=none','ExpLPrac2=none']);
    var tabla=document.getElementById('tabladistincionesEgre');
        var filas=tabla.rows;
        var tam=filas.length;
        for (var i = 1; i < tam; i++) {
            tabla.deleteRow(1);
        }
        
        var url = 'lisDisgrad'+"?docgrad=" + id_doc;
        conectarX(url,muestraDisPrac);
}
function verActualizarafiliasionesPrac(){
    setVisibilidad(['ActDatosPrac=none','EstPrac=none','tablaconsultaEstPrac=none','tablaconsultaDisPrac=none','DisPrac=none','AfiPrac=inline','tablaconsultaAfiPrac=inline',
        'tablaconsultaIdioPrac=none','idioPrac=none','tablaconsultaExpPrac=none','ExpLPrac=none','ExpLPrac2=none']);
          var tabla=document.getElementById('tablaafiliacionesEgre');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }
        var url = 'lisAfigrad'+"?docgrad=" + id_doc;
        conectarX(url,muestraAfiPrac);
}
function verActualizaridiomasPrac(){
    setVisibilidad(['ActDatosPrac=none','EstPrac=none','tablaconsultaEstPrac=none','tablaconsultaDisPrac=none','DisPrac=none','AfiPrac=none','tablaconsultaAfiPrac=none',
        'tablaconsultaIdioPrac=inline','idioPrac=inline','tablaconsultaExpPrac=none','ExpLPrac=none','ExpLPrac2=none']);
      var tabla=document.getElementById('tablaidiomasEgre');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }       
        var url = 'lisIdiograd'+"?docgrad=" + id_doc;
        conectarX(url, muestraIdioPrac);
}
function verActualizarExplaboralPrac(){
    setVisibilidad(['ActDatosPrac=none','EstPrac=none','tablaconsultaEstPrac=none','tablaconsultaDisPrac=none','DisPrac=none','AfiPrac=none','tablaconsultaAfiPrac=none',
        'tablaconsultaIdioPrac=none','idioPrac=none','tablaconsultaExpPrac=inline','ExpLPrac=inline','ExpLPrac2=inline']);
     var tabla=document.getElementById('tablaExpLaboralEgre');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }
        var url = 'lisExpgrad'+"?docgrad=" + id_doc;
        conectarX(url, muestraExpPrac);
}
function versolicitudPracEst(){
    setVisibilidad(['solicitudPracEst=inline','consultaOferPracEst=none','consultaOferPracEst2=none','botonconsultaSolOferPracEst=none','solicitudOferPracEst=none','RegDisponibilidad=none']);
}
function verRegDisponivilidad(){
    setVisibilidad(['solicitudPracEst=none','consultaOferPracEst=none','consultaOferPracEst2=none','botonconsultaSolOferPracEst=none','solicitudOferPracEst=none','RegDisponibilidad=inline']);
}
function verSolPracDec(){
    setVisibilidad(['solicitudPracEst=none','consultaOferPracEst=inline','consultaOferPracEst2=inline','botonconsultaSolOferPracEst=inline','solicitudOferPracEst=inline','RegDisponibilidad=none']);
}
function ActualizarDatPrac() {
    var formobj = document.fromDatGeneralesPrac;
    
    if(!isDiligenciado(['tel2prac','celprac','email2prac','perfilprac','refprac','exvprac','electivasprac'],['Telefono 2','Numero de Celular',
        'Email 2','Perfil Profesional','Referencias','Expectativas','Línea de profundización o Electivas técnicas'])) {
            return false;
    }
    
    formobj.action = 'ActDatosPrac';
    return true;

    /* var url = 'ActDatosPrac?' +"id_est="+id_est+"&"+ getValores(['tel2prac','celprac','email2prac','perfilprac','refprac','exvprac','electivasprac']);
    conectarMethod(url, muestraResultado, 'POST');
    */
}

function actTabEstPrac(docgrad) {
    var tabla = document.getElementById('tablaestudiosPrac');
    var filas = tabla.rows;
    var tam = filas.length;

    //Limpiar Tabla
    for (var i = 1; i < tam; i++) {
        tabla.deleteRow(1);
    }

    //Realizar Petición
    var url = 'lisEstgrad?docgrad=' + docgrad;
    conectarX(url, muestraEstprac);
}

function actTabDisPrac (docgrad) {
    var tabla = document.getElementById('tabladistincionesEgre');
    var filas = tabla.rows;
    var tam = filas.length;
    
    //Limpiar Tabla
    for (var i = 1; i < tam; i++){
        tabla.deleteRow(1);
    }
    
    //Realizar Petición
    var url = 'lisDisgrad?docgrad=' + docgrad;
    conectarX(url, muestraDisPrac);
}

function actTabAfiPrac (docgrad){
    var tabla = document.getElementById('tablaafiliacionesEgre');
    var filas = tabla.rows;
    var tam = filas.length;
    
    //Limpiar Tabla
    for (var i = 1; i < tam; i++){
        tabla.deleteRow(1);
    }
    
    //Realizar Petición
    var url = 'lisAfigrad?docgrad=' + docgrad;
    conectarX(url, muestraAfiPrac);
}

function actTabIdioPrac(docgrad){
    var tabla = document.getElementById('tablaidiomasEgre');
    var filas = tabla.rows;
    var tam = filas.length;
    
    //Limpiar Tabla
    for (var i = 1; i < tam; i++) {
        tabla.deleteRow(1);
    }
    
    //Realizar Petición
    var url = 'lisIdiograd?docgrad=' + docgrad;
    conectarX(url, muestraIdioPrac);
}

function actTabExpPrac(docgrad) {
    var tabla = document.getElementById('tablaExpLaboralEgre');
    var filas = tabla.rows;
    var tam = filas.length;
    
    //Limpiar Tabla
    for (var i = 1; i < tam; i++) {
        tabla.deleteRow(1);
    }
    
    //Realizar Petición
    var url = 'lisExpgrad?docgrad=' + docgrad;
    conectarX(url, muestraExpPrac);
}

function AplicarOferprac(idofer,idest){
    document.getElementById('btnAplicarOferPrac').value = 'Realizando Aplicación...';
    document.getElementById('btnAplicarOferPrac').disabled = true;
    var url = 'AplicarOferPrac?'+"idest="+idest+"&idofer="+idofer;
    conectarMethod(url, muestraResultadoreload, 'POST');
}
function consultaOferPracEst(rol, idest){
 //Limpiar Tabla
         //document.getElementById('buscar').style.visibility='hidden';
        //var ProgramaAcademic= ProgramaAcademico.value;
        var tabla=document.getElementById('TablaOferPracEst');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }
        var url = 'lisOferPracEst?'+"iddpto=" + rol+'&idest='+idest+"&"+ getValores(['TipoOferPracEst','TipoOferPracEst2']);
        conectarX(url,muestraOferPracEst);
}
function EliminarRePrac(id, docgrad, nt){
    var url = 'EliminarReGrad?' + 'id=' + id + '&nt=' + nt;
    conectarMethod(url, function() {
        if(http_request.readyState != 4) return;
        if(http_request.status != 200) return;
        
        if (nt == 1) {
            actTabEstPrac(docgrad);
        } else if (nt == 2) {
            actTabDisPrac(docgrad)
        } else if (nt == 3) {
            actTabAfiPrac(docgrad);
        } else if (nt == 4) {
            actTabIdioPrac(docgrad);
        } else if (nt == 5) {
            actTabExpPrac(docgrad);
        }
    }, 'POST');
}

function EnviarSolPrac(idest)
{
   var url = 'GuardarSolicitudPrac?' +"idest="+idest+"&"+ getValores(['ProgramaSolicitado','exvprac','electivasprac','asigconj']);
   document.getElementById("envSolPrac").disabled = true;
   document.getElementById("envSolPrac").value = "Procesando...";
   conectarMethod(url,muestraResultadoreload, 'POST');  //location.reload();
}
function ActualizarSolPrac(idest){
    var url = 'ActualizarSolPrac?' +"idest="+idest+"&"+ getValores(['ProgramaSolicitado','exvprac','electivasprac','asigconj']);
    document.getElementById("actSolPrac").disabled = true;
   document.getElementById("actSolPrac").value = "Procesando...";
   conectarMethod(url,muestraResultadoreload, 'POST');
}

function muestraEstprac() {
    if(http_request.readyState != 4) return;
    if(http_request.status != 200) return;

    var xmldoc = http_request.responseXML;
    var lista = xmldoc.getElementsByTagName("lisaestudios");
    
    if (lista.length <= 0) {
        alert(xmldoc.getElementsByTagName("valor")[0].firstChild.nodeValue);
    }
    var reg = lista[0].getElementsByTagName("estudio");
    var elementos = ["id_estudio","nom_estudio","nom_inst", "tipo_est", "docgrad"];
    var cuerpoestudiosPrac=document.getElementById('cuerpoestudiosPrac'),fila,texto,nodo,nt,link,columna,div;
    var id = 0 ;
    var docgrad = 0 ;

    for(var i = 0; i < reg.length;i++){

        fila = cuerpoestudiosPrac.insertRow(0);
        id = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
        docgrad = reg[i].getElementsByTagName(elementos[4])[0].firstChild.nodeValue;

        for(var j = 1; j <= 4; j++) {

            if (j <= 4 ) {
                nodo=reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
            }

            columna = fila.insertCell(j-1);
            div = document.createElement("div");

            if( j > 1 ) {
                div.setAttribute("align", "center");
            } else {
                div.setAttribute("align", "left");
            }

            if (j == 4) {
                var attr = document.createAttribute('align');
                attr.value = 'center';
                columna.setAttributeNode(attr);

                nt = "1";
                columna.innerHTML = '<div class="expOpt" title="Eliminar" onclick="EliminarRePrac(' + id + ',' + docgrad + ',' + nt + ');" style="float: none;"><img src="imagenes/grad/delete.png" /></div>';
            } else {
                texto = document.createTextNode(nodo);
                div.appendChild(texto);
                columna.appendChild(div);
            }
        }
    }
}

function muestraDisPrac() {
    if(http_request.readyState != 4) return;
    if(http_request.status != 200) return;

    var xmldoc = http_request.responseXML;
    var lista = xmldoc.getElementsByTagName("listadistinciones");
    
    if (lista.length <= 0) {
        alert(xmldoc.getElementsByTagName("valor")[0].firstChild.nodeValue);
    }
    
    var reg = lista[0].getElementsByTagName("distincion");
    var elementos=["id_distincion","nom_disgrad","inst_disgrad","Tipo_disgrad","docgrad"];
    var cuerpodistincionesEgre = document.getElementById('cuerpodistincionesEgre'),fila,texto,nodo,nt,link,columna,div;
    var id = 0 ;
    var docgrad = 0 ;

    for(var i = 0; i < reg.length;i++) {

        fila = cuerpodistincionesEgre.insertRow(0);
        id = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
        docgrad = reg[i].getElementsByTagName(elementos[4])[0].firstChild.nodeValue;

        for (var j = 1; j <= 4; j++) {

            if (j <= 4 ) {
                nodo=reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
            }

            columna = fila.insertCell(j-1);
            div = document.createElement("div");

            if( j > 1 ) {
                div.setAttribute("align", "center");
            } else {
                div.setAttribute("align", "left");
            }

            if (j == 4) {
                var attr = document.createAttribute('align');
                attr.value = 'center';
                columna.setAttributeNode(attr);

                nt = "2";
                columna.innerHTML = '<div class="expOpt" title="Eliminar" onclick="EliminarRePrac(' + id + ',' + docgrad + ',' + nt + ');" style="float: none;"><img src="imagenes/grad/delete.png" /></div>';
            } else {
                texto = document.createTextNode(nodo);
                div.appendChild(texto);
                columna.appendChild(div);
            }
        }
    }
}

function muestraAfiPrac() {
    if(http_request.readyState != 4) return;
    if(http_request.status != 200) return;
    
    var xmldoc = http_request.responseXML;
    var lista = xmldoc.getElementsByTagName("listaAfiliaciones");
    
    if (lista.length <= 0) {
        alert(xmldoc.getElementsByTagName("valor")[0].firstChild.nodeValue);
    }
        
    var reg = lista[0].getElementsByTagName("Afiliacion");
    var elementos=["id_Afiliacion","inst_afigrad","Tipo_afigrad","estadoafi","docgrad"];
    var cuerpoafiliacionesEgre=document.getElementById('cuerpoafiliacionesEgre'),fila,texto,nodo,nt,estado,columna,div;
    var id = 0 ;
    var docgrad = 0 ;

    for (var i = 0; i < reg.length;i++) {

        fila = cuerpoafiliacionesEgre.insertRow(0);
        id = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
        docgrad = reg[i].getElementsByTagName(elementos[4])[0].firstChild.nodeValue;

        for(var j = 1; j <= 4; j++) {

            nodo = reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
            columna = fila.insertCell(j-1);
            div = document.createElement("div");

            if( j > 1 ) {
                div.setAttribute("align", "center");
            } else {
                div.setAttribute("align", "left");
            }

            if (j== 3) {
                if(nodo=="True" || nodo=="1") {
                    columna.innerHTML="Activa";
                } else {
                    columna.innerHTML="Finalizada";
                }
            } else {
                if (j == 4) {
                    var attr = document.createAttribute('align');
                    attr.value = 'center';
                    columna.setAttributeNode(attr);

                    nt = "3";
                    columna.innerHTML = '<div class="expOpt" title="Eliminar" onclick="EliminarRePrac(' + id + ',' + docgrad + ',' + nt + ');" style="float: none;"><img src="imagenes/grad/delete.png" /></div>';
                } else {
                    texto=document.createTextNode(nodo);
                    div.appendChild(texto);
                    columna.appendChild(div);
                }
            }
        }
    }
}

function muestraIdioPrac() {
    if (http_request.readyState != 4) return;
    if (http_request.status != 200) return;

    var xmldoc = http_request.responseXML;
    var lista = xmldoc.getElementsByTagName("listaidiomas")[0];
    
    if (lista.length <= 0) {
        alert(xmldoc.getElementsByTagName("valor")[0].firstChild.nodeValue);
    }

    var reg = lista.getElementsByTagName("idioma");
    var elementos=["id_idioma","nom_idio","nivel_lecegre","nivel_escriegre","nivel_hablaegre","docgrad"];
    var cuerpoidiomasEgre=document.getElementById('cuerpoidiomasEgre'),fila,texto,nodo,nt,estado,columna,div;

    var id = 0 ;
    var docgrad = 0 ;

    for (var i = 0; i < reg.length; i++) {

        fila=cuerpoidiomasEgre.insertRow(0);
        id = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
        docgrad = reg[i].getElementsByTagName(elementos[5])[0].firstChild.nodeValue;

        for (var j = 1; j <= 5; j++) {

            nodo=reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;

            columna=fila.insertCell(j-1);
            div=document.createElement("div");
            
            if (j > 1) {
                div.setAttribute("align", "center");
            } else {
                div.setAttribute("align", "left");
            }

            if (j == 5) {
                var attr = document.createAttribute('align');
                attr.value = 'center';
                columna.setAttributeNode(attr);

                nt = "4";
                columna.innerHTML = '<div class="expOpt" title="Eliminar" onclick="EliminarRePrac(' + id + ',' + docgrad + ',' + nt + ');" style="float: none;"><img src="imagenes/grad/delete.png" /></div>';
            } else {
                texto=document.createTextNode(nodo);
                div.appendChild(texto);
                columna.appendChild(div);
            }
        }
    }
}

function muestraOferPracEst(){
    if(http_request.readyState == 4) {
            if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("lisOfertas")[0];
                var reg = lista.getElementsByTagName("oferta");
                //var elementos=["id_req","id_oferta", "cargo",  "razon_social","horario_oferta", "fecha_limite","id_empresa", "nit"];
                var elementos=["id_req","id_oferta", "cargo",  "razon_social", "fecha_limite","id_empresa", "nit"];
                var cuerpotablaOferPracEst=document.getElementById('cuerpotablaOferPracEst'),fila,texto,nodo,nt,estado,columna,div,link;
                var idofer = 0;
                var idreq = 0;
                var idemp=0;
                for(var i = 0; i < reg.length;i++){
                    fila=cuerpotablaOferPracEst.insertRow(0);
                    idreq= reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                    idofer = reg[i].getElementsByTagName(elementos[1])[0].firstChild.nodeValue;
                    idemp=reg[i].getElementsByTagName(elementos[5])[0].firstChild.nodeValue;
                    for(var j = 1; j <= 3; j++){
                        nodo=reg[i].getElementsByTagName(elementos[j+1])[0].firstChild.nodeValue;
                        columna=fila.insertCell(j-1);
                        div=document.createElement("div");
                        if( j > 1 ){
                            div.setAttribute("align", "center");
                        }else{
                            div.setAttribute("align", "left");
                        }
                        if(j==1){
                            columna.innerHTML=" <a target='_blank' href='VerOfertaPracEst?idofer="+
                                idofer+"&idreq="+idreq+"&idemp="+idemp+ "'onclick='window.open(this.href,'ventana_','toolbar=no,scrollbars=yes,location=yes,directories=yes,status=no,menubar=no,resizable=yes'); return false;'>"+nodo+"</a>";
                        }
                        else{
                            if(j==2){
                            columna.innerHTML=" <a>"+nodo+"</a>";
                            }
                            else{
                                texto=document.createTextNode(nodo);
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

function muestraExpPrac() {
    if(http_request.readyState != 4) return;
    if(http_request.status != 200) return;

    var xmldoc = http_request.responseXML;
    var lista = xmldoc.getElementsByTagName("listaexperiencias");
     
    if (lista.length <= 0) {
        alert(xmldoc.getElementsByTagName("valor")[0].firstChild.nodeValue);
    }
        
    var reg = lista[0].getElementsByTagName("experiencia");
    var elementos=["id_exp","nom_empresaegre","cargoegre","docgrad"];
    var cuerpoExpLaboralEgre=document.getElementById('cuerpoExpLaboralEgre'),fila,texto,nodo,nt,estado,columna,div;
    var id = 0;
    var docgrad = 0;

    for(var i = 0; i < reg.length;i++){

        fila = cuerpoExpLaboralEgre.insertRow(0);
        id = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
        docgrad = reg[i].getElementsByTagName(elementos[3])[0].firstChild.nodeValue;

        for(var j = 1; j <= 3; j++){
            nodo=reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
            columna=fila.insertCell(j-1);
            div=document.createElement("div");

            if( j > 1 ) {
                div.setAttribute("align", "center");
            } else {
                div.setAttribute("align", "left");
            }

            if (j == 1) {
                /*columna.innerHTML="<a target='_blank' href='EditarExpLabGrad?idexp="+id+"&prac=1' onclick='window.open(this.href,'ventana_','toolbar=no,scrollbars=yes,"+
                     "location=yes,directories=yes,status=no,menubar=no,resizable=yes'); return false;'>"+nodo+"</a>";*/
                columna.innerHTML = nodo;
            } else {
                if (j == 3) {
                    //columna.innerHTML="<input class='inputcorto' type= 'submit' value='Eliminar' name='unico' onclick= 'EliminarExpPrac("+ id + ","+docgrad+","+nt+");'/>";
                    var attr = document.createAttribute('align');
                    attr.value = 'center';
                    columna.setAttributeNode(attr);

                    nt = "5";
                    columna.innerHTML = '<div class="expOpt" title="Eliminar" onclick="EliminarRePrac(' + id + ',' + docgrad + ',' + nt + ');" style="float: none;"><img src="imagenes/grad/delete.png" /></div>';
                } else {
                    texto=document.createTextNode(nodo);
                    div.appendChild(texto);
                    columna.appendChild(div);                    //}
                }
            }

        }
    }
}

function RegistrarEstPrac(){
    if (!isDiligenciado(['prog_estprac','titulo_prac','sector_estprac','nom_instprac','pais_estprac','ciudad_estprac','fecha_estprac'],
        ['Nombre','Titulo','Sector','Nombre de la Institución','Pais','Ciudad','Fecha de grado'])) {
        return;
    }
    
    if (!validaFecha(document.getElementById("fecha_estprac").value)){
        return;
    }
    
    var x = document.getElementById('tipo_estudio');
    var nom_tipo = x.options[x.selectedIndex].text;
    
    var url = 'RegistrarEstPrac?nom_tipo=' + nom_tipo + '&' + getValores(['prog_estprac','titulo_prac','sector_estprac','nom_instprac','pais_estprac','ciudad_estprac','fecha_estprac', 'tipo_estudio']);
    conectarX(url, muestraEstprac);
}

function RegistrarDisPrac(doc_grad) {
    if (!isDiligenciado(['nom_disgrad','inst_disgrad','amb_disgrad','Tipo_disgrad','fecha_disgrad'], ['nom_disgrad','inst_disgrad','amb_disgrad','Tipo_disgrad','fecha_disgrad']))
        return;
    
    if (!validaFecha(document.getElementById("fecha_disgrad").value))
        return;
    
    var url = 'RegistrarDisGrad?' + 'docgrad=' + doc_grad + '&' + getValores(['nom_disgrad','inst_disgrad','amb_disgrad','Tipo_disgrad','fecha_disgrad']);
    conectarX(url, muestraDisPrac);
}

function RegistrarAfiPrac(doc_grad) {
    if (!isDiligenciado(['inst_afigrad','Tipo_afigrad','fechaAfi','estadoafi'], ['Institución','Tipo_afigrad','Fecha de ingreso','estadoafi']))
        return;
    if (!validaFecha(document.getElementById("fechaAfi").value))
        return;
    
    var url = 'RegistrarAfiGrad?' +'docgrad=' + doc_grad+ '&' + getValores(['inst_afigrad','Tipo_afigrad','fechaAfi','estadoafi']);
    conectarX(url, muestraAfiPrac);
}

function RegistrarIdioPrac(doc_grad) {
    if (!isDiligenciado(['nom_idio'], ['Nombre del idioma']))
        return;
    
    var url = 'RegistrarIdioGrad?' + 'docgrad=' + doc_grad + '&' + getValores(['nom_idio','nivel_lecegre','nivel_escriegre','nivel_hablaegre']);
    conectarX(url, muestraIdioPrac);
}

function RegistrarExpPrac(doc_grad) {
    var url;
    
    if (document.getElementById('estado_expegre').value=='Finalizado') {
        if (!isDiligenciado(['empropia','nom_empresaegre','cargoegre','sector_expgrad','pais_expgrad','ciudad_expgrad','fechain_expgrad','fechaout_expgrad','contrato_expgrad','horario_expgrad','fun_expgrad','logros_expgrad','tel_expgrad','dir_expgrad','salario_expgrad','estado_expegre'],
                            ['Es su empresa','Nombre de la Empresa','Cargo','Sector','País','Ciudad','Fecha de ingreso','Fecha de retiro','Tipo de Contrato','Horario','Funciones en el cargo','Logros','Teléfono de la empresa','Dirección de la empresa','Salario','Estado']))
            return;
    } else {
        if (!isDiligenciado(['empropia','nom_empresaegre','cargoegre','sector_expgrad','pais_expgrad','ciudad_expgrad','fechain_expgrad','contrato_expgrad','horario_expgrad','fun_expgrad','logros_expgrad','tel_expgrad','dir_expgrad','salario_expgrad','estado_expegre'],
                            ['Es su empresa','Nombre de la Empresa','Cargo','Sector','País','Ciudad','Fecha de ingreso','Tipo de Contrato','Horario','Funciones en el cargo','Logros','Teléfono de la empresa','Dirección de la empresa','Salario','Estado']))
            return;
    }
    
    if (!validaFecha(document.getElementById("fechain_expgrad").value)) return;

    if (document.getElementById('estado_expegre').value=='Finalizado') {
        if (!validaFecha(document.getElementById("fechaout_expgrad").value))
            return;
    }
    
    url = 'RegistrarExpGrad?' +'docgrad=' + doc_grad + '&' + getValores(['empropia','nom_empresaegre','cargoegre','sector_expgrad','pais_expgrad','ciudad_expgrad','fechain_expgrad','fechaout_expgrad','contrato_expgrad','horario_expgrad','fun_expgrad','logros_expgrad','tel_expgrad','dir_expgrad','salario_expgrad','estado_expegre']);
    conectarX(url, muestraExpPrac);
}

function RegDisponibilidadEst(idest){
   var url = 'RegDisponibilidadEst?idest='+idest+"&"+ getValores(['DisponibilidadEst']);
            conectarX(url, muestraResultadoreload);
}

function setExpActualPrac() {
    var fecha_out = document.getElementById('fechaout_expgrad');
    if (document.getElementById('estado_expegre').value=='Actual') {
        fecha_out.value='';
        fecha_out.disabled = true;
        fecha_out.style.backgroundColor = '#AAAAAA';
    } else {
        fecha_out.disabled = false;
        fecha_out.style.backgroundColor = '#EEEBFC';
    }
}