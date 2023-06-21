/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function verActualizarinfopersonal() {
    setVisibilidad(['ActDatos=inline',
                    'FotoGrad=none',
                    'EstEgre=none',
                    'tablaconsultaEstEgre=none',
                    'tablaconsultaDisEgre=none',
                    'DisEgre=none',
                    'AfiEgre=none',
                    'tablaconsultaAfiEgre=none',
                    'tablaconsultaIdioEgre=none',
                    'idioEgre=none',
                    'tablaconsultaExpEgre=none',
                    'ExpLEgre=none',
                    'ExpLEgre2=none']);
}

function verActualizarFoto() {
    setVisibilidad(['ActDatos=none',
                    'FotoGrad=inline',
                    'EstEgre=none',
                    'tablaconsultaEstEgre=none',
                    'tablaconsultaDisEgre=none',
                    'DisEgre=none',
                    'AfiEgre=none',
                    'tablaconsultaAfiEgre=none',
                    'tablaconsultaIdioEgre=none',
                    'idioEgre=none',
                    'tablaconsultaExpEgre=none',
                    'ExpLEgre=none',
                    'ExpLEgre2=none']);
}

function verActualizarestudios() {
    setVisibilidad(['ActDatos=none',
                    'FotoGrad=none',
                    'EstEgre=inline',
                    'tablaconsultaEstEgre=inline',
                    'tablaconsultaDisEgre=none',
                    'DisEgre=none',
                    'AfiEgre=none',
                    'tablaconsultaAfiEgre=none',
                    'tablaconsultaIdioEgre=none',
                    'idioEgre=none',
                    'tablaconsultaExpEgre=none',
                    'ExpLEgre=none',
                    'ExpLEgre2=none']);

}

function verActualizarDistinciones() {
    setVisibilidad(['ActDatos=none',
                    'FotoGrad=none',
                    'EstEgre=none',
                    'tablaconsultaEstEgre=none',
                    'tablaconsultaDisEgre=inline',
                    'DisEgre=inline',
                    'AfiEgre=none',
                    'tablaconsultaAfiEgre=none',
                    'tablaconsultaIdioEgre=none',
                    'idioEgre=none',
                    'tablaconsultaExpEgre=none',
                    'ExpLEgre=none',
                    'ExpLEgre2=none']);
}

function verActualizarafiliasiones() {
    setVisibilidad(['ActDatos=none',
                    'FotoGrad=none',
                    'EstEgre=none',
                    'tablaconsultaEstEgre=none',
                    'tablaconsultaDisEgre=none',
                    'DisEgre=none',
                    'AfiEgre=inline',
                    'tablaconsultaAfiEgre=inline',
                    'tablaconsultaIdioEgre=none',
                    'idioEgre=none',
                    'tablaconsultaExpEgre=none',
                    'ExpLEgre=none',
                    'ExpLEgre2=none']);
}

function verActualizaridiomas() {
    setVisibilidad(['ActDatos=none',
                    'FotoGrad=none',
                    'EstEgre=none',
                    'tablaconsultaEstEgre=none',
                    'tablaconsultaDisEgre=none',
                    'DisEgre=none',
                    'AfiEgre=none',
                    'tablaconsultaAfiEgre=none',
                    'tablaconsultaIdioEgre=inline',
                    'idioEgre=inline',
                    'tablaconsultaExpEgre=none',
                    'ExpLEgre=none',
                    'ExpLEgre2=none']);
}

function verActualizarExplaboral() {
    setVisibilidad(['ActDatos=none',
                    'FotoGrad=none',
                    'EstEgre=none',
                    'tablaconsultaEstEgre=none',
                    'tablaconsultaDisEgre=none',
                    'DisEgre=none',
                    'AfiEgre=none',
                    'tablaconsultaAfiEgre=none',
                    'tablaconsultaIdioEgre=none',
                    'idioEgre=none',
                    'tablaconsultaExpEgre=inline',
                    'ExpLEgre=inline',
                    'ExpLEgre2=inline']);
}

function verconsultarofergrad(){
    setVisibilidad(['consultaofergrad=none','botonconsultaofergrad=inline','tablaofertasgrad=inline','cambiocontrasenagrad=none'
    ,'tablaconsultaclasificado=none','clasificadoEgre=none','LosclasificadoEgre=none']);
}
function vercambiarcontrasena(){
    setVisibilidad(['consultaofergrad=none','botonconsultaofergrad=none','tablaofertasgrad=none','cambiocontrasenagrad=inline'
        ,'tablaconsultaclasificado=none','clasificadoEgre=none','LosclasificadoEgre=none']);
}
function verclacificados(){
    setVisibilidad(['consultaofergrad=none','botonconsultaofergrad=none','tablaofertasgrad=none','cambiocontrasenagrad=none'
        ,'tablaconsultaclasificado=inline','clasificadoEgre=inline','LosclasificadoEgre=none']);
}
function vertodosclacificados(){
    setVisibilidad(['consultaofergrad=none','botonconsultaofergrad=none','tablaofertasgrad=none','cambiocontrasenagrad=none'
        ,'tablaconsultaclasificado=none','clasificadoEgre=none','LosclasificadoEgre=inline']);
}

function ActualizarDatEgre(docegre) {
    
    var paisSel = document.getElementById("pais_res").options[document.getElementById("pais_res").selectedIndex].value;
    var ciudadSel = document.getElementById("ciudad_res").options[document.getElementById("ciudad_res").selectedIndex].value;
    if(paisSel=="" || ciudadSel==""){
        alert("Diligencie el país y ciudad");
        return;
    }else{

        //Verificación del teléfono
        var tel_res = document.getElementById('tel_res').value;
        var cel = document.getElementById('cel').value;

        if (/[^\d]/g.test(tel_res) && tel_res.length > 0) {
            alert('El teléfono de la residencia debe contener solo números.\n\nPor favor corrija el teléfono y vuelva a oprimir Actualizar.');
            return;
        }

        if (/[^\d]/g.test(cel) && cel.length > 0) {
            alert('El celular debe contener solo números.\n\nPor favor corrija el celular y vuelva a oprimir Actualizar.');
            return;
        }

        if (false&&tel_res.length > 7) {
            alert('El teléfono de la residencia no debe contener más de 7 caracteres.\n\nPor favor corrija el teléfono y vuelva a oprimir Actualizar.');
            return;
        }

        //Verificaciones del Email
        var email = document.getElementById('emails').value;
        var email2 = document.getElementById('email2').value;
        var mailRegEx = /^[a-z0-9-_.]{3,}@[a-z0-9-_.]{3,}[.][a-z]{2,}$/ig;

        if (!mailRegEx.test(email) && email.length > 0) {
            alert('El correo electrónico del campo Email contiene un formato incorrecto.\n\nPor favor verifique su formato y vuelva a oprimir Actualizar.');
            return;
        }

        mailRegEx.lastIndex = 0;

        if (!mailRegEx.test(email2) && email2.length > 0) {
            alert('El correo electrónico del campo Email 2 contiene un formato incorrecto.\n\nPor favor verifique su formato y vuelva a oprimir Actualizar.');
            return;
        }

        //Graduado fallecido
        var fallecido = document.getElementById('fallecido');

        if (fallecido != null) {
            fallecido = fallecido.checked == true?'1':'0';
        } else {
            fallecido = '0';
        }
        console.info(docegre);
        var url = 'ActDatosEgre?' + 'docegre=' + docegre + '&' + 'fallecido=' + fallecido + '&' + getValores(['num_trj', 'estcivil', 'dir_res', 'tel_indicativo', 'tel_res', 'cel_indicativo', 'cel', 'pais_res', 'ciudad_res', 'emails', 'email2', 'social_fb', 'social_tw', 'social_insta', 'social_gplus', 'social_linkedin','perfil', 'nomcortoes']);
        conectarMethod(url, muestraResultado, 'POST');
    }
}


function reiniciarpassGrad(docegre){
    var answer = confirm("¿Está seguro de querer reiniciar la contraseña de este graduado?");
    if (answer) {
        var url = 'reiniciarpassGrad?' + "docegre=" + docegre;
        conectarMethod(url, muestraResultado, 'POST');
    }
}

function DejarPendienteDatGrad(){
   window.close();
}

function ActualizarExpLab(IdExp,docgrad) {
    var formobj = document.fromExpLab;
    if (document.getElementById('estado_expegre').value=='Finalizado') {
        if (!isDiligenciado(['empropia', 'nom_empresaegre', 'cargoegre', 'sector_expgrad', 'pais_expgrad', 'ciudad_expgrad', 'fechain_expgrad', 'fechaout_expgrad', 'contrato_expgrad', 'horario_expgrad', 'fun_expgrad', 'logros_expgrad', 'tel_expgrad', 'dir_expgrad', 'salario_expgrad', 'estado_expegre'],
            ['Es su empresa', 'Nombre de la Empresa', 'Cargo', 'Sector', 'País', 'Ciudad', 'Fecha de ingreso', 'Fecha de retiro', 'Tipo de Contrato', 'Horario', 'Funciones en el cargo', 'Logros', 'Teléfono de la empresa', 'Dirección de la empresa', 'Salario', 'Estado']))
            return false;
        
    } else {
        if (!isDiligenciado(['empropia', 'nom_empresaegre', 'cargoegre', 'sector_expgrad', 'pais_expgrad', 'ciudad_expgrad', 'fechain_expgrad', 'contrato_expgrad', 'horario_expgrad', 'fun_expgrad', 'logros_expgrad', 'tel_expgrad', 'dir_expgrad', 'salario_expgrad', 'estado_expegre'],
            ['Es su empresa', 'Nombre de la Empresa', 'Cargo', 'Sector', 'País', 'Ciudad', 'Fecha de ingreso', 'Tipo de Contrato', 'Horario', 'Funciones en el cargo', 'Logros', 'Teléfono de la empresa', 'Dirección de la empresa', 'Salario', 'Estado']))
            return false;
    }

    if (!validaFecha(document.getElementById("fechain_expgrad").value)) 
        return false;
    
    if (document.getElementById("fechain_expgrad").value.split('/')[1] == '1900') {
        alert('La fecha de ingreso es incorrecta.');
        return false;
    }


    if ((document.getElementById('estado_expegre').value=='Finalizado')) {
        if (!validaFecha(document.getElementById("fechaout_expgrad").value))
            return false;
        
        if (document.getElementById("fechaout_expgrad").value.split('/')[1] == '1900') {
            alert('La fecha de retiro es incorrecta.');
            return false;
        }
    }

    formobj.action = 'EditarExpLab?idExp=' + IdExp+"&doc_grad="+docgrad;
    return true;
}

function actTabMisClasificados(docgrad){
    //Limpiar Tabla
         //document.getElementById('buscar').style.visibility='hidden';
        //var ProgramaAcademic= ProgramaAcademico.value;
        var tabla=document.getElementById('tablaMisclasificados');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }
        //Realizar Peticion
         //alert('esto es bueno');
        //setVisibilidad(['RequerimientosConMov=inline']);
        var url = 'lisMisClasificados'+"?docgrad=" + docgrad;
        conectarX(url,muestraMisClasificados);
}
function actTabLosClasificados(){
    //Limpiar Tabla
         //document.getElementById('buscar').style.visibility='hidden';
        //var ProgramaAcademic= ProgramaAcademico.value;
        var tabla=document.getElementById('tablaLosclasificados');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }
        //Realizar Peticion
         //alert('esto es bueno');
        //setVisibilidad(['RequerimientosConMov=inline']);
        var url = 'lisLosClasificados';
        conectarX(url,muestraLosClasificados);
}

function actualizarTabEstEgre(docgrad)
{
        //Limpiar Tabla
         //document.getElementById('buscar').style.visibility='hidden';
        //var ProgramaAcademic= ProgramaAcademico.value;
        var tabla=document.getElementById('tablaestudiosEgre');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }
        //Realizar Peticion
         //alert('esto es bueno');
        //setVisibilidad(['RequerimientosConMov=inline']);
        var url = 'lisEstgrad'+"?docgrad=" + docgrad;
        conectarX(url,muestraEstgrad);
        //return false;
}
function actTabDisEgre(docgrad){
    //Limpiar Tabla
         //document.getElementById('buscar').style.visibility='hidden';
        //var ProgramaAcademic= ProgramaAcademico.value;
        var tabla=document.getElementById('tabladistincionesEgre');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }
        //Realizar Peticion
         //alert('esto es bueno');
        //setVisibilidad(['RequerimientosConMov=inline']);
        var url = 'lisDisgrad'+"?docgrad=" + docgrad;
        conectarX(url,muestraDisgrad);
}
function actTabIdioEgre(docgrad){
    //Limpiar Tabla        
        var tabla=document.getElementById('tablaidiomasEgre');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }       
        var url = 'lisIdiograd'+"?docgrad=" + docgrad;
        conectarX(url,muestraIdiograd);
}
function actTabAfiEgre (docgrad){
        var tabla=document.getElementById('tablaafiliacionesEgre');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }        
        var url = 'lisAfigrad'+"?docgrad=" + docgrad;
        conectarX(url,muestraAfigrad);
}
function actTabExpEgre(docgrad){
     var tabla=document.getElementById('tablaExpLaboralEgre');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }
        var url = 'lisExpgrad'+"?docgrad=" + docgrad;
        conectarX(url,muestraExpgrad);
}
function AplicarOfertaGrad(idoferta,usuario){
    var url='AplicarOferGrad?idoferta='+idoferta+"&usr="+usuario;
    document.getElementsByName('EnvAplicaciongrad')[0].disabled = true;
    document.getElementsByName('EnvAplicaciongrad')[0].value = 'Postulando...';
    conectarMethod(url, resultadoAplicaOfertaGrad, 'POST');
}
function resultadoAplicaOfertaGrad() {
    if(http_request.readyState != 4) return;
    if(http_request.status != 200) return;
    var xmldoc = http_request.responseXML;
    var respuesta=xmldoc.getElementsByTagName("resultado")[0];
    var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
    var tipo=respuesta.getElementsByTagName("tipo")[0].firstChild.nodeValue;
    if (tipo="1") {
        document.getElementById('btnAplicarOferta').innerHTML = '<a class="textocom3">Postulación exitosa</a>';
    } else {
        document.getElementById('btnAplicarOferta').disabled = false;
        document.getElementsByName('EnvAplicaciongrad')[0].value = 'Postularse'; 
    }
    
    alert(resul);
    window.close();

}
function    cambiarcontrasenagrad(usr){
    if(document.getElementById("pswnuevo").value == document.getElementById("pswnuevo2").value){
         var url='CambiarPassGrad?docgrad='+usr+"&pswantiguo="+ encodeURIComponent(document.getElementById("pswantiguo").value)+"&pswnuevo="+ 
                 encodeURIComponent(document.getElementById("pswnuevo2").value);// encodeURIComponent(
         conectarMethod(url, muestraResultadoreload, 'POST');
    }
    else{
        alert("Nueva contraseña y confirme nueva contraseña deben ser iguales");
        return;
    }
}
function consultarofergrad(docgrad,tipo){
     var tabla=document.getElementById('tablaofergrad');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }
    var url = 'lisOfertaGrad?docgrad='+docgrad+"&tipoconsultaofergrad=" + tipo;
        conectarMethod(url, muestraOfertasgrad, 'POST');
}
function muestraEstgrad() {
        //alert('esto es bueno');
        if(http_request.readyState == 4) {
            if(http_request.status == 200) {

                var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("lisaestudios")[0];
                var reg = lista.getElementsByTagName("estudio");
                var elementos=["id_estudio","nom_estudio","nom_inst","nivel_formacion","docgrad"];
                var cuerpoestudiosEgre=document.getElementById('cuerpoestudiosEgre'),fila,texto,nodo,nt,link,columna,div;
                var id = 0 ;
                var docgrad = 0 ;
                for(var i = 0; i < reg.length;i++){

                    fila=cuerpoestudiosEgre.insertRow(0);
                    id = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                    docgrad = reg[i].getElementsByTagName(elementos[4])[0].firstChild.nodeValue;
                    for(var j = 1; j <= 4; j++){
                        if (j <= 4 ) {
                            nodo=reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                        }
                        columna=fila.insertCell(j-1);
                        div=document.createElement("div");
                        if( j > 1 ){
                            div.setAttribute("align", "center");
                        }else{
                            div.setAttribute("align", "left");
                        }
                        if (j == 4) {
                            var attr = document.createAttribute('align');
                            attr.value = 'center';
                            columna.setAttributeNode(attr);
                            
                            nt = "1";
                            columna.innerHTML = '<div class="expOpt" title="Eliminar" onclick="EliminarReGrad(' + id + ',' + docgrad + ',' + nt + ');" style="float: none; width: 32%;"><img src="imagenes/grad/delete.png" /></div>';
                            //columna.innerHTML="<input type= 'submit' value='Eliminar' name='unico' onclick= 'EliminarReGrad("+ id + ","+docgrad+","+nt+");'/>";
                        }
                        else {
                            texto=document.createTextNode(nodo);
                            div.appendChild(texto);
                            columna.appendChild(div);                    //}
                        }
                }
                //document.getElementById('buscar').style.visibility='visible'
            }
        }
    }
}
function muestraDisgrad() {
    if(http_request.readyState != 4) return;
    if(http_request.status != 200) return;

    var xmldoc = http_request.responseXML;
    var lista = xmldoc.getElementsByTagName("listadistinciones");
    if (lista.length > 0) {
        var reg = lista[0].getElementsByTagName("distincion");
        var elementos=["id_distincion","nom_disgrad","inst_disgrad","Tipo_disgrad","docgrad"];
        var cuerpodistincionesEgre=document.getElementById('cuerpodistincionesEgre'),fila,texto,nodo,nt,link,columna,div;
        var id = 0 ;
        var docgrad = 0 ;

        for(var i = 0; i < reg.length;i++) {

            fila=cuerpodistincionesEgre.insertRow(0);
            id = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
            docgrad = reg[i].getElementsByTagName(elementos[4])[0].firstChild.nodeValue;

            for(var j = 1; j <= 4; j++) {

                if (j <= 4 ) {
                    nodo=reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                }

                columna=fila.insertCell(j-1);
                div=document.createElement("div");

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
                    columna.innerHTML = '<div class="expOpt" title="Eliminar" onclick="EliminarReGrad(' + id + ',' + docgrad + ',' + nt + ');" style="float: none; width: 32%;"><img src="imagenes/grad/delete.png" /></div>';
                    //columna.innerHTML="<input type= 'submit' value='Eliminar' name='unico' onclick= 'EliminarReGrad("+ id + ","+docgrad+","+nt+");'/>";
                } else {
                    texto=document.createTextNode(nodo);
                    div.appendChild(texto);
                    columna.appendChild(div);                    //}
                }
            }
                    //document.getElementById('buscar').style.visibility='visible'
        }
    } else {
        alert(xmldoc.getElementsByTagName("valor")[0].firstChild.nodeValue);
    }
}

function muestraAfigrad() {
    if(http_request.readyState != 4) return;
    if(http_request.status != 200) return;
    
    var xmldoc = http_request.responseXML;
    var lista = xmldoc.getElementsByTagName("listaAfiliaciones");
    
    if (lista.length > 0) {
        
        var reg = lista[0].getElementsByTagName("Afiliacion");
        var elementos=["id_Afiliacion","inst_afigrad","Tipo_afigrad","estadoafi","docgrad"];
        var cuerpoafiliacionesEgre=document.getElementById('cuerpoafiliacionesEgre'),fila,texto,nodo,nt,estado,columna,div;
        var id = 0 ;
        var docgrad = 0 ;
        
        for(var i = 0; i < reg.length;i++){

            fila=cuerpoafiliacionesEgre.insertRow(0);
            id = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
            docgrad = reg[i].getElementsByTagName(elementos[4])[0].firstChild.nodeValue;

            for(var j = 1; j <= 4; j++) {

                nodo=reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                columna=fila.insertCell(j-1);
                div=document.createElement("div");
                    
                if( j > 1 ) {
                    div.setAttribute("align", "center");
                } else {
                    div.setAttribute("align", "left");
                }
                    
                if(j== 3) {
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
                        columna.innerHTML = '<div class="expOpt" title="Eliminar" onclick="EliminarReGrad(' + id + ',' + docgrad + ',' + nt + ');" style="float: none; width: 32%;"><img src="imagenes/grad/delete.png" /></div>';
                        //columna.innerHTML="<input type= 'submit' value='Eliminar' name='unico' onclick= 'EliminarReGrad("+ id + ","+docgrad+","+nt+");'/>";
                    } else {
                        texto=document.createTextNode(nodo);
                        div.appendChild(texto);
                        columna.appendChild(div);                    //}
                    }
                }
            }
                //document.getElementById('buscar').style.visibility='visible'
        }
    } else {
        alert(xmldoc.getElementsByTagName("valor")[0].firstChild.nodeValue);
    }
}

function muestraIdiograd() {
        //alert('esto es bueno');
        if(http_request.readyState == 4) {
            if(http_request.status == 200) {
/*res ="<listaidiomas><idioma>" +"<id_idioma>" + item.get("id")+ "</id_idioma>" + "<nom_idio>" + nom_idio+
"</nom_idio>"  + "<nivel_lecegre>" + nivel_lecegre +
"</nivel_lecegre>"+  "<nivel_escriegre>" + nivel_escriegre + "</nivel_escriegre>"
+  "<nivel_hablaegre>" + nivel_escriegre + "</nivel_hablaegre>"+  "<docgrad>" + docgrad + "</docgrad>" +"</idioma></listaidiomas>";*/
                var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("listaidiomas")[0];
                var reg = lista.getElementsByTagName("idioma");
                var elementos=["id_idioma","nom_idio","nivel_lecegre","nivel_escriegre","nivel_hablaegre","docgrad"];
                var cuerpoidiomasEgre=document.getElementById('cuerpoidiomasEgre'),fila,texto,nodo,nt,estado,columna,div;
                var id = 0 ;
                var docgrad = 0 ;
                for(var i = 0; i < reg.length;i++){

                    fila=cuerpoidiomasEgre.insertRow(0);
                    id = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                    docgrad = reg[i].getElementsByTagName(elementos[5])[0].firstChild.nodeValue;
                    for(var j = 1; j <= 5; j++){

                        nodo=reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;


                        columna=fila.insertCell(j-1);
                        div=document.createElement("div");
                        if( j > 1 ){
                            div.setAttribute("align", "center");
                        }else{
                            div.setAttribute("align", "left");
                        }


                            if (j == 5) {
                                var attr = document.createAttribute('align');
                                attr.value = 'center';
                                columna.setAttributeNode(attr);
                                
                                nt = "4";
                                columna.innerHTML = '<div class="expOpt" title="Eliminar" onclick="EliminarReGrad(' + id + ',' + docgrad + ',' + nt + ');" style="float: none; width: 32%;"><img src="imagenes/grad/delete.png" /></div>';
                                //columna.innerHTML="<input class='inputcorto' type= 'submit' value='Eliminar' name='unico' onclick= 'EliminarReGrad("+ id + ","+docgrad+","+nt+");'/>";
                            }
                            else {
                                texto=document.createTextNode(nodo);
                                div.appendChild(texto);
                                columna.appendChild(div);                    //}
                            }

                }
                //document.getElementById('buscar').style.visibility='visible'
            }
        }
    }
}
function muestraExpgrad() {
    if(http_request.readyState != 4) return;
    if(http_request.status != 200) return;
        
    var xmldoc = http_request.responseXML;
        
    var lista = xmldoc.getElementsByTagName("listaexperiencias");
        
    if (lista.length > 0) {
        var reg = lista[0].getElementsByTagName("experiencia");
        var elementos=["id_exp","nom_empresaegre","cargoegre","docgrad","principal", "estado", "validate"];
        var cuerpoExpLaboralEgre=document.getElementById('cuerpoExpLaboralEgre'),fila,texto,nodo,nt,estado,columna,div, principal, actual, validate;
        var id = 0;
        var docgrad = 0;
            
        for(var i = 0; i < reg.length;i++) {

            fila=cuerpoExpLaboralEgre.insertRow(0);
            id = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
            docgrad = reg[i].getElementsByTagName(elementos[3])[0].firstChild.nodeValue;
                
            for (var j = 1; j <= 3; j++) {

                nodo=reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                principal = reg[i].getElementsByTagName(elementos[4])[0].firstChild.nodeValue=='0'?false:true;
                actual = reg[i].getElementsByTagName(elementos[5])[0].firstChild.nodeValue=='Finalizado'?false:true;
                validate = reg[i].getElementsByTagName(elementos[6])[0].firstChild.nodeValue=='0'?false:true;
                columna=fila.insertCell(j-1);
                div=document.createElement("div");
                
                if (!validate) document.getElementById('InvalidMsg').style.display = 'block';
                
                if (!validate && j != 3) {
                    columna.style.backgroundColor = '#F8ECEC';
                    //columna.setAttribute('style', 'background: #F8ECEC');
                }
                
                if (j == 1) {
                    var attr = document.createAttribute('align');
                    attr.value = 'left';
                    columna.setAttributeNode(attr);
                    
                    columna.innerHTML = nodo + (!validate?' <span style="font-size: 10px; color: #FE2E2E;">[Inválida]</span>':'');
                   //columna.innerHTML =  '<a target="_blank" href="EditarExpLabGrad?idexp=' + id + '&prac=1" onclick="window.open(this.href,\'ventana_\',\'toolbar=no,scrollbars=yes,location=yes,directories=yes,status=no,menubar=no,resizable=yes\'); return false;">' + nodo + '</a>';
                } else if (j == 3) {
                    var attr = document.createAttribute('align');
                    attr.value = 'center';
                    columna.setAttributeNode(attr);
                    columna.style.paddingLeft = '10px';
                    
                    nt = "5";
                    columna.innerHTML = '<div class="expOpt star' + (principal?' favSel':'') + '" ' + (!principal?'onclick="setExpPrincipal(' + id + ', ' + docgrad + ');" ':'') + 'title="' + (principal?'Principal':'Seleccionar como principal') + '"' + (!actual?' style="visibility: true;"':'') + '><img src="imagenes/grad/favorite.png" /></div>' +
                                        '<div class="expOpt" title="Editar" onclick="window.open(\'EditarExpLabGrad?idexp=' + id + '&prac=1' + (!validate?'&men=Requiere actualizacion.':'') + '\',\'ventana_\',\'toolbar=no,scrollbars=yes,location=yes,directories=yes,status=no,menubar=no,resizable=yes\')"><img src="imagenes/grad/edit.png" /></div>' +
                                        '<div class="expOpt" title="Eliminar" onclick="EliminarReGrad(' + id + ',' + docgrad + ',' + nt + ');"><img src="imagenes/grad/delete.png" /></div>';
                    //columna.innerHTML = '<input class="inputcorto" type="submit" value="Eliminar" name="unico" onclick="EliminarReGrad(' + id + ',' + docgrad + ',' + nt + ');"/>';
                } else {
                    var attr = document.createAttribute('align');
                    attr.value = 'center';
                    div.setAttributeNode(attr);
                    
                    texto=document.createTextNode(nodo);
                    div.appendChild(texto);
                    columna.appendChild(div);                    //}
                }
             }
                //document.getElementById('buscar').style.visibility='visible'
        }
    } else {
        alert(xmldoc.getElementsByTagName("valor")[0].firstChild.nodeValue);
    }
}
function muestraMisClasificados() {
        //alert('esto es bueno');
        if(http_request.readyState == 4) {
            if(http_request.status == 200) {

                var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("listaclasificados")[0];
                var reg = lista.getElementsByTagName("clasificado");
                var elementos=["id","id_documento","titulo","cuerpoclas","estado_clas","tel_clas","email_clas"];
                var cuerpoMisclacificados=document.getElementById('cuerpoMisclacificados'),fila,texto,titulo,nt,link,columna,div;
                var id = 0 ;
                var docgrad = 0 ;
                for(var i = 0; i < reg.length;i++){

                    fila=cuerpoMisclacificados.insertRow(0);
                    id = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                    docgrad = reg[i].getElementsByTagName(elementos[1])[0].firstChild.nodeValue;
                    titulo = reg[i].getElementsByTagName(elementos[2])[0].firstChild.nodeValue;
                    for(var j = 1; j <= 2; j++){
                            nodo=reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                        columna=fila.insertCell(j-1);
                        div=document.createElement("div");
                        if( j > 1 ){
                            div.setAttribute("align", "center");
                        }else{
                            div.setAttribute("align", "left");
                        }
                        if (j == 1){

                           link=document.createElement("a");
                            link.setAttribute("id", titulo);
                            link.setAttribute("href", "VerClacificadosGrad?i="+id);
                            link.setAttribute("target", "blank");
                            texto=document.createTextNode(titulo);
                            link.appendChild(texto);
                            div.appendChild(link);
                            columna.appendChild(div);
                        }
                        else {
                                nt="6";
                                columna.innerHTML="<input class='inputcorto' type= 'submit' value='Eliminar' name='unico' onclick= 'EliminarReGrad("+ id + ","+docgrad+","+nt+");'/>";                   //}
                        }
                }
                //document.getElementById('buscar').style.visibility='visible'
            }
        }
    }
}
function muestraLosClasificados() {
        //alert('esto es bueno');
        if(http_request.readyState == 4) {
            if(http_request.status == 200) {

                var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("listaclasificados")[0];
                var reg = lista.getElementsByTagName("clasificado");
                var elementos=["id","id_documento","titulo","cuerpoclas","estado_clas","tel_clas","email_clas"];
                var cuerpoLosclacificados=document.getElementById('cuerpoLosclacificados'),fila,texto,titulo,nt,link,columna,div;
                var id = 0 ;
                var docgrad = 0 ;
                for(var i = 0; i < reg.length;i++){

                    fila=cuerpoLosclacificados.insertRow(0);
                    id = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                    docgrad = reg[i].getElementsByTagName(elementos[1])[0].firstChild.nodeValue;
                    titulo = reg[i].getElementsByTagName(elementos[2])[0].firstChild.nodeValue;
                    for(var j = 1; j <= 1; j++){
                            nodo=reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                        columna=fila.insertCell(j-1);
                        div=document.createElement("div");
                        if( j > 1 ){
                            div.setAttribute("align", "center");
                        }else{
                            div.setAttribute("align", "left");
                        }
                        if (j == 1){

                            link=document.createElement("a");
                            link.setAttribute("id", titulo);
                            link.setAttribute("href", "VerClacificadosGrad?i="+id);
                            link.setAttribute("target", "blank");
                            texto=document.createTextNode(titulo);
                            link.appendChild(texto);
                            div.appendChild(link);
                            columna.appendChild(div);
                        }
                        else {
                                nt="6";
                                columna.innerHTML="<input class='inputcorto' type= 'submit' value='Eliminar' name='unico' onclick= 'EliminarReGrad("+ id + ","+docgrad+","+nt+");'/>";                   //}
                        }
                }
                //document.getElementById('buscar').style.visibility='visible'
            }
        }
    }
}
function muestraOfertasgrad(){

    if(http_request.readyState == 4) {
            if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("listaofertas")[0];
                var reg = lista.getElementsByTagName("oferta");
                var elementos=["id_oferta","cargo","fecha_publicacion","fecha_limite","salario_oferta","estado"];
                var cuerpotablaofertasgrad=document.getElementById('cuerpotablaofertasgrad'),fila,texto,nodo,nt,estado,columna,div,link;
                var id = 0;               
                for(var i = 0; i < reg.length;i++){
                    fila=cuerpotablaofertasgrad.insertRow(0);
                    id = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                    
                    for(var j = 1; j < 6; j++){
                        nodo=reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                        columna=fila.insertCell(j-1);
                        div=document.createElement("div");
                        if( j > 1 ){
                            div.setAttribute("style", "margin: 5px 0px 5px 0px;");
                            div.setAttribute("align", "center");
                        }else{
                            div.setAttribute("style", "margin: 5px 0px 5px 5px;");
                            div.setAttribute("align", "left");
                        }
                        if(j==1){
                            link=document.createElement("a");
                            link.setAttribute("id", nodo);
                            link.setAttribute("href", "VerOfertaGrad?i="+id);
                            link.setAttribute("target", "blank");
                            texto=document.createTextNode(nodo);
                            link.appendChild(texto);
                            div.appendChild(link);
                            columna.appendChild(div);
                        }
                        else{
                                texto=document.createTextNode(nodo);
                                div.appendChild(texto);
                                columna.appendChild(div);
                        }//}


                }
                //document.getElementById('buscar').style.visibility='visible'
            }
        }
    }
}

function EliminarEstGrad(idestudio,docgrad) {
    var url = 'EliminarEstGrad?' +'idestudio='+idestudio;
    conectarMethod(url, muestranada, 'POST');
    actualizarTabEstEgre(docgrad);
}

function EliminarReGrad(id, docgrad, nt) {
    var url = 'EliminarReGrad?' + 'id=' + id +'&nt=' + nt;
    conectarMethod(url, function() {
        
        if(http_request.readyState != 4) return;
        if(http_request.status != 200) return;
        
        if (nt == 1) {
            //conectarMethod(url, actualizarTabEstEgre(), 'POST');
            actualizarTabEstEgre(docgrad);
        } else if (nt == 2) {
            //conectarMethod(url, actTabDisEgre(), 'POST');
            actTabDisEgre(docgrad);
        } else if (nt == 3) {
            // conectarMethodGrad(url, actTabAfiEgre(docgrad), 'POST');
            actTabAfiEgre(docgrad);
        } else if (nt == 4) {
            //conectarMethod(url, actTabIdioEgre(docgrad), 'POST');
            actTabIdioEgre(docgrad);
        } else if (nt == 5) {
            //conectarMethod(url, actTabExpEgre(docgrad), 'POST');
            actTabExpEgre(docgrad);
        } else if (nt == 6) {
            //conectarMethod(url, actTabMisClasificados(docgrad), 'POST');
            actTabMisClasificados(docgrad);
        }
    }, 'POST');
}
function RegistrarClasificado(doc_grad){
    if(!isDiligenciado(['Tituloclas','Teloclas','emailclas','cuerpoclas'],
    ['Titulo del Clasificado','Telefono de contacto','clasificado']))
   {
       return;
   }
   else
   {
            var url = 'RegistrarClasGrad?' +'docgrad='+doc_grad+"&"+ getValores(['Tituloclas','Teloclas','emailclas','cuerpoclas']);
            conectarX(url, muestraMisClasificados);
   }
    //actualizarTabEstEgre(doc_grad);
}
function RegistrarEstGrad(doc_grad){
    if(!isDiligenciado(['NivEst','prog_estgrad','titulo_grad','sector_estgrad','nom_inst','pais_estgrad','ciudad_estgrad','fecha_estgrad'],
    ['Nivel de Formación','Programa Académico','Titulo','Sector','Nombre de la Institución','Pais','Ciudad','Fecha de grado']))
   {
       return;
   }
   else
   {
         if (!validaFecha(document.getElementById("fecha_estgrad").value)){
             return;
         }
         else{
            var url = 'RegistrarEstGrad?' +'docgrad='+doc_grad+"&"+ getValores(['NivEst','prog_estgrad','titulo_grad','sector_estgrad','nom_inst','pais_estgrad','ciudad_estgrad','fecha_estgrad']);
            conectarX(url, muestraEstgrad);
         }
   }
    //actualizarTabEstEgre(doc_grad);
}
function RegistrarDisGrad(doc_grad){
     if(!isDiligenciado(['nom_disgrad','inst_disgrad','amb_disgrad','Tipo_disgrad','fecha_disgrad'],
    ['nom_disgrad','inst_disgrad','amb_disgrad','Tipo_disgrad','fecha_disgrad']))
   {
       return;
   }
   else
   {
         if (!validaFecha(document.getElementById("fecha_disgrad").value)){
             return;
         }
         else{
            var url = 'RegistrarDisGrad?' +'docgrad='+doc_grad+"&"+ getValores(['nom_disgrad','inst_disgrad','amb_disgrad','Tipo_disgrad','fecha_disgrad']);
            conectarX(url, muestraDisgrad);
            //actualizarTabEstEgre(doc_grad);
         }
   }
}
function RegistrarAfiGrad(doc_grad){
    if(!isDiligenciado(['inst_afigrad','Tipo_afigrad','fechaAfi','estadoafi'],
    ['Institución','Tipo_afigrad','Fecha de ingreso','estadoafi']))
   {
       return;
   }
   else
   {
         if (!validaFecha(document.getElementById("fechaAfi").value)){
             return;
         }
         else{
            var url = 'RegistrarAfiGrad?' +'docgrad='+doc_grad+"&"+ getValores(['inst_afigrad','Tipo_afigrad','fechaAfi','estadoafi']);
            conectarX(url, muestraAfigrad);
         }
   }
}
function RegistrarIdioGrad(doc_grad){
    if(!isDiligenciado(['nom_idio'],
    ['Nombre del idioma']))
   {
       return;
   }
   else
   {
        var url = 'RegistrarIdioGrad?' +'docgrad='+doc_grad+"&"+ getValores(['nom_idio','nivel_lecegre','nivel_escriegre','nivel_hablaegre']);
        conectarX(url, muestraIdiograd);
   }
}
function RegistrarExpGrad(doc_grad){
    var url;
    if (document.getElementById('estado_expegre').value=='Finalizado') {
        if(!isDiligenciado(['empropia','nom_empresaegre','cargoegre','sector_expgrad','pais_expgrad','ciudad_expgrad','fechain_expgrad','fechaout_expgrad','contrato_expgrad','horario_expgrad','fun_expgrad','logros_expgrad','tel_expgrad','dir_expgrad','salario_expgrad','estado_expegre'],
        ['Es su empresa','Nombre de la Empresa','Cargo','Sector','País','Ciudad','Fecha de ingreso','Fecha de Retiro','Tipo de Contrato','Horario','Funciones en el cargo','Logros','Teléfono de la empresa','Dirección de la empresa','Salario','Estado']))
            return;
    } else {
        if(!isDiligenciado(['empropia','nom_empresaegre','cargoegre','sector_expgrad','pais_expgrad','ciudad_expgrad','fechain_expgrad','contrato_expgrad','horario_expgrad','fun_expgrad','logros_expgrad','tel_expgrad','dir_expgrad','salario_expgrad','estado_expegre'],
        ['Es su empresa','Nombre de la Empresa','Cargo','Sector','País','Ciudad','Fecha de ingreso','Tipo de Contrato','Horario','Funciones en el cargo','Logros','Teléfono de la empresa','Dirección de la empresa','Salario','Estado']))
            return;
    }
    
    if (!validaFecha(document.getElementById("fechain_expgrad").value)) return;
    
    if (document.getElementById("fechain_expgrad").value.split('/')[1] == '1900') {
        alert('La fecha de ingreso es incorrecta.');
        return;
    }

    if (document.getElementById('estado_expegre').value=='Finalizado') {
        if (!validaFecha(document.getElementById("fechaout_expgrad").value))
            return;
        
        if (document.getElementById("fechaout_expgrad").value.split('/')[1] == '1900') {
            alert('La fecha de retiro es incorrecta.');
            return;
        }
    }

    url = 'RegistrarExpGrad?' +'docgrad='+doc_grad+"&"+ getValores(['empropia','nom_empresaegre','cargoegre','sector_expgrad','pais_expgrad','ciudad_expgrad','fechain_expgrad','fechaout_expgrad','contrato_expgrad','horario_expgrad','fun_expgrad','logros_expgrad','tel_expgrad','dir_expgrad','salario_expgrad','estado_expegre']);
    conectarX(url, muestraExpgrad);
}
function conectarMethodGrad(url, funcion, met){
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
            } catch (e){}
        }
    }
    if (!http_request) {
        alert('No se Instanciado el Objeto XMLHttpRequest');
        return false;
    }

    //Preparar funcion de respuesta
    http_request.onreadystatechange = funcion;

    //Enviar Peticion
    http_request.open(met, url, true);
    http_request.send(null);
    return false;
}
function AceptarReglamentoGrad(doc){
    var url;
    url = 'AceptarReglamentoGrad?' +'docgrad='+doc
      conectarX(url, muestraMenugrad);
}
function muestraMenugrad(){
    if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
                  alert(resul);
                  //window.close();
                  window.location='Menugraduado';
                  
                   //response.sendRedirect("loginAdmin" );
            if(respuesta.getElementsByTagName("dato")[0]!=null){//if(resul=="Operación Exitosa"){
                eval(respServlet+"("+");");
            }
        }
    }
    
}


function setExpActualGrad() {
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

function setExpPrincipal(id, docgrad) {
    var url = 'setExpPrincipal?' +'id=' + id + '&doc=' + docgrad;
    conectarMethod(url, function() {
        if(http_request.readyState != 4) return;
        if(http_request.status != 200) return;
        
        var xmlDoc = http_request.responseXML.getElementsByTagName('docAnswer')[0];
        var result = xmlDoc.getElementsByTagName('result')[0].firstChild.nodeValue;
        
        if (result == '0') {
            var msg = xmlDoc.getElementsByTagName('msg')[0].firstChild.nodeValue;
            alert(msg);
            return;
        }
        
        actTabExpEgre(docgrad);
    }, 'POST');
}

function newExpPrincipal(docgrad) {
    
    if (!confirm('¿Está seguro que desea registrar esta nueva experiencia laboral para el graduado?')) return;
    
    var nom_emp = document.getElementById('nom_emp').value;
    var emp_propia = document.getElementById('emp_propia').value;
    var cargo = document.getElementById('cargo').value;
    var tel_emp = document.getElementById('tel_emp').value;
    
    var url = 'newExpPrincipal?' +'doc=' + docgrad + '&nomemp=' + nom_emp + '&emppropia=' + emp_propia + '&cargo=' + cargo + '&telemp=' + tel_emp;
    conectarMethod(url, function() {
        if (http_request.readyState != 4) return;
        if (http_request.status != 200) return;
        
        var xmlDoc = http_request.responseXML.getElementsByTagName('docAnswer')[0];
        var msg = xmlDoc.getElementsByTagName('msg')[0].firstChild.nodeValue;
        alert(msg);
        
    }, 'POST');
}

function loadPhoto() {
    var fileSelect = document.getElementById('photoFile');
    var upBtn = document.getElementById('upPhoto');
    
    if (fileSelect.files.length == 0) {
        alert('Debe escoger una foto para cargar');
        return;
    }
    
    if (!confirm('Una vez cargue la foto esta quedará visible en su hoja de vida\n¿Desea subir esta foto?')) return;

    upBtn.value = 'Cargando foto...';
    upBtn.disabled = true;
    
    var formData = new FormData();
    
    var file = fileSelect.files[0];

    // Check the file type.
    if (!file.type.match('image.*')) {
        alert('El archivo seleccionado debe ser una imagen');
        return;
    }

    // Add the file to the request.
    formData.append('photoFile', file, file.name);
    
    // Obtener la instancia del objeto XMLHttpRequest
    http_request = false;
    http_request = new XMLHttpRequest();
    
    http_request.onreadystatechange = function() {
        if (http_request.readyState != 4) return;
        
        var upBtn = document.getElementById('upPhoto');
        upBtn.value = 'Cargar Foto';
        upBtn.disabled = false;
        
        if (http_request.status != 200) return;
        
        var xmlDoc = http_request.responseXML.getElementsByTagName('docAnswer')[0];
        var msg = xmlDoc.getElementsByTagName('msg')[0].firstChild.nodeValue;
        alert(msg);

        if (xmlDoc.getElementsByTagName('redir').length > 0) {
            var redir = xmlDoc.getElementsByTagName('redir')[0].firstChild.nodeValue;
            location = redir;
        }
    };

    //Enviar Peticion
    http_request.open('POST', 'cargarFoto', true);
    http_request.send(formData);
    return;
}

function deletePhoto() {
    if (!confirm('Una vez eliminada la foto ya no aparecerá en su hoja de vida\n¿Está seguro que desea eliminarla?')) return;
    
    var deleteBtn = document.getElementById('deletePhoto');

    deleteBtn.value = 'Borrando foto...';
    deleteBtn.disabled = true;

    conectarMethod('cargarFoto', function() {
        if (http_request.readyState != 4) return;
        
        var deleteBtn = document.getElementById('deletePhoto');
        deleteBtn.value = 'Borrar foto';
        deleteBtn.disabled = false;
        
        if (http_request.status != 200) return;
        
        var xmlDoc = http_request.responseXML.getElementsByTagName('docAnswer')[0];
        var msg = xmlDoc.getElementsByTagName('msg')[0].firstChild.nodeValue;
        alert(msg);

        if (xmlDoc.getElementsByTagName('redir').length > 0) {
            var redir = xmlDoc.getElementsByTagName('redir')[0].firstChild.nodeValue;
            location = redir;
        }
    }, 'GET');
}

function actCiudadesConPaisGrad(){
    var e = document.getElementById("pais_res");
    var paisSel = e.options[e.selectedIndex].value;
    var ciudades = document.getElementById("ciudad_res").options;
    for (var i = 0, max = ciudades.length; i < max; i++) {
        (ciudades[i].getAttribute("data-pais") == paisSel || (ciudades[i].value == "")) ? ciudades[i].disabled = false : ciudades[i].disabled = true ;
        if(ciudades[i].value == ""){
            ciudades[i].selected=true;
        }
    }
}