/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 var href; 

function consultarApMov()
{
        //Limpiar Tabla
         //document.getElementById('buscar').style.visibility='hidden';
        var ProgramaAcademic = document.getElementById("ProgramaAcademico").value;
        var ProgramaMov = document.getElementById("ProgramaMovilidad").value;
        //var ProgramaAcademic= ProgramaAcademico.value;
        var tabla=document.getElementById('tablaplicantes');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }
        //Realizar Peticion
         //alert('esto es bueno');
        //setVisibilidad(['RequerimientosConMov=inline']);
        var url = 'lisAplicantesMov2?'+"iddpto=" + ProgramaAcademic + "&progmov=" + ProgramaMov;
        conectarX(url,muestraApliMov);
        //return false;
}
function consultarDocumentos()
{
        //Limpiar Tabla
         //document.getElementById('buscar').style.visibility='hidden';
        var ProgramaAcademic = document.getElementById("ProgramaAcademico").value;
        var ProgramaMov = document.getElementById("ProgramaMovilidad").value;
        //var ProgramaAcademic= ProgramaAcademico.value;
        var tabla=document.getElementById('tablaestdocumentos');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }        
        var url = 'lisEstDoc?'+"iddpto=" + ProgramaAcademic + "&progmov=" + ProgramaMov;
        conectarX(url,muestralisDoc);
       
}
function consultaropcuni()
{
    var ProgramaAcademic = document.getElementById("ProgramaAcademico").value;
    var ProgramaMov = document.getElementById("ProgramaMovilidad").value;
    var tabla=document.getElementById('tablaclacifUni');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }
        var url = 'lisOpcUni?'+"iddpto=" + ProgramaAcademic + "&progmov=" + ProgramaMov;
        conectarX(url,muestraOpcUni);

}
function consultarestEXT(){
        var ProgramaAcademic = document.getElementById("ProgramaAcademico").value;
        var ProgramaMov = document.getElementById("ProgramaMovilidad").value;
        //var ProgramaAcademic= ProgramaAcademico.value;
        var tabla=document.getElementById('tablaestEXT');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }
        var url = 'lisAplicantesMov3?'+"iddpto=" + ProgramaAcademic + "&progmov=" + ProgramaMov;
        conectarX(url,muestraApliMov3);
}
function consultarestEXTfin(){
    var ProgramaAcademic = document.getElementById("ProgramaAcademico").value;
        var ProgramaMov = document.getElementById("ProgramaMovilidad").value;
        //var ProgramaAcademic= ProgramaAcademico.value;
        var tabla=document.getElementById('tablafinpro');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }
        var url = 'lisAplicantesMov3?'+"iddpto=" + ProgramaAcademic + "&progmov=" + ProgramaMov;
        conectarX(url,muestraApliMovfin);
}
function cambiarcontrato()
{
                var url = 'CambiarContrato?' + getValores(['OpcContratoPrograma','descripcioncont_mov','comentariocont_mov']);
                conectarMethod(url, muestraResultado, 'POST');
}
function actualizartabdocu(idsol)
{
        //Limpiar Tabla
         //document.getElementById('buscar').style.visibility='hidden';
        //var ProgramaAcademic= ProgramaAcademico.value;
        var tabla=document.getElementById('tabladocumentos');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }
        //Realizar Peticion
         //alert('esto es bueno');
        //setVisibilidad(['RequerimientosConMov=inline']);
        var url = 'lisDocumentos'+"?id=" + idsol;
        conectarX(url,muestraDocumentos);
        //return false;
}
function muestraOpcUni(){
    if(http_request.readyState == 4) {
            if(http_request.status == 200) {

                var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("lisopcuni")[0];
                var reg = lista.getElementsByTagName("opcuni");

                var elementos=["idsolicitud","nombre","unidestino","estadoopcud","idopcion"];
                var cuerpo6=document.getElementById('cuerpo6'),fila,texto,nodo,estado,act,columna,div;
                var isolicitud = 0 ;
                for(var i = 0; i < reg.length;i++){

                    fila=cuerpo6.insertRow(0);
                    isolicitud = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                    for(var j = 1; j <= 4; j++){
                        
                        nodo=reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                       
                        columna=fila.insertCell(j-1);
                        div=document.createElement("div");
                        if( j > 1 ){
                            div.setAttribute("align", "center");
                        }else{
                            div.setAttribute("align", "left");
                        }
                        if (j == 1){
                            columna.innerHTML="<a>"+ nodo +"</a>";
                        }
                        if (j == 2){
                            columna.innerHTML="<a>"+ nodo +"</a>";
                        }
                        if (j == 3){
                            columna.innerHTML="<a>"+ nodo +"</a>";
                        }
                        if (j == 4){
                             estado=reg[i].getElementsByTagName(elementos[j-1])[0].firstChild.nodeValue;
                             texto=reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                             if(estado == "en espera"){
                                  act="";
                             }
                             else{
                                 act="disabled";
                             }
                             columna.innerHTML="<input type= 'submit' value='Aceptar' name='AceptarUni' onclick= 'Aceptaruni("+ nodo +","+ isolicitud+","+texto+");'"+ act + "/> \n\
                                                <input type= 'submit' value='Rechazado por la uni' name='AceptarUni2' onclick= 'rechazarporuni("+ nodo +","+ isolicitud+","+texto+");'"+ act + "/>\n\
                                                <input type= 'submit' value='Rechazado por el est' name='AceptarUni3' onclick= 'rechazarporest("+ nodo +","+ isolicitud+","+texto+");'"+ act + "/>";
                        }
                   
                    }
                }
                //document.getElementById('buscar').style.visibility='visible'
            }
        }
    
}
function Aceptaruni(idopc,idsol,estopc){
     var url;
     url = 'Actulizarestadoopcuni?idsol='+idsol+'&idopc='+idopc+'&clave=aceptado';
     conectarMethod(url, muestraResultadouni, 'POST');     
     //url = 'ActualizarEstMov?'+"idsolicitud=" + idsol;
     //conectarMethod(url, muestraResultado, 'POST');
     //consultaropcuni();
}
function rechazarporuni(idopc,idsol,estopc){
    var url;
     url = 'Actulizarestadoopcuni?idsol='+idsol+'&idopc='+idopc+'&clave=rechazado_por_uni';
     conectarMethod(url, muestraResultadouni, 'POST');
    // url = 'ActualizarEstMov?'+"idsolicitud=" + idsol;
     //conectarMethod(url, muestraResultado, 'POST');
     //consultaropcuni();
}
function rechazarporest(idopc,idsol,estopc){
     var url;
     url = 'Actulizarestadoopcuni?idsol='+idsol+'&idopc='+idopc+'&clave=rechazado_por_est';
     conectarMethod(url, muestraResultadouni, 'POST');
     //url = 'ActualizarEstMov?'+"idsolicitud=" + idsol;
     //conectarMethod(url, muestraResultado, 'POST');
     //consultaropcuni();
}
function muestraApliMov() {
        //alert('esto es bueno');
        if(http_request.readyState == 4) {
            if(http_request.status == 200) {
              
                var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("lisaplicantesmov")[0];
                var reg = lista.getElementsByTagName("aplicante");
                var elementos=["nombre","progmov","estado","id_solicitud"];
                var cuerpo=document.getElementById('cuerpo'),fila,texto,nodo,url,link,columna,div;
                var isolicitud = 0 ;
                for(var i = 0; i < reg.length;i++){
                  
                    fila=cuerpo.insertRow(0);
                    isolicitud = reg[i].getElementsByTagName(elementos[3])[0].firstChild.nodeValue;
                    for(var j = 0; j <= 2; j++){
                        if (j <= 2 ) {
                            nodo=reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                        }
                        columna=fila.insertCell(j);
                        div=document.createElement("div");
                        if( j > 1 ){
                            div.setAttribute("align", "center");
                        }else{
                            div.setAttribute("align", "left");
                        }
                        
                            if (j == 0){
                            link=document.createElement("a");
                            link.setAttribute("id", nodo);
                            link.setAttribute("href", "DatGeneralesSolMov?idSolicitud="+isolicitud);
                            link.setAttribute("target", "_blank");
                            texto=document.createTextNode(nodo);
                            link.appendChild(texto);
                            div.appendChild(link);
                            columna.appendChild(div);
                        }
                        else {
                            texto=document.createTextNode(nodo);
                            div.appendChild(texto);
                            columna.appendChild(div);
                    //}
                    }
                }
                //document.getElementById('buscar').style.visibility='visible'
            }
        }
    }
}
function muestraApliMov3() {
        //alert('esto es bueno');
        if(http_request.readyState == 4) {
            if(http_request.status == 200) {

                var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("lisaplicantesmov")[0];
                var reg = lista.getElementsByTagName("aplicante");
                var elementos=["nombre","progmov","estado","id_solicitud"];
                var cuerpoestEXT=document.getElementById('cuerpoestEXT'),fila,texto,nodo,url,link,columna,div;
                var isolicitud = 0 ;
                for(var i = 0; i < reg.length;i++){

                    fila=cuerpoestEXT.insertRow(0);
                    isolicitud = reg[i].getElementsByTagName(elementos[3])[0].firstChild.nodeValue;
                    for(var j = 0; j <= 2; j++){
                        if (j <= 2 ) {
                            nodo=reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                        }
                        columna=fila.insertCell(j);
                        div=document.createElement("div");
                        if( j > 1 ){
                            div.setAttribute("align", "center");
                        }else{
                            div.setAttribute("align", "left");
                        }

                            if (j == 0){
                            link=document.createElement("a");
                            link.setAttribute("id", nodo);
                            link.setAttribute("href", "DatGeneralesSolMov?idSolicitud="+isolicitud);
                            link.setAttribute("target", "_blank");
                            texto=document.createTextNode(nodo);
                            link.appendChild(texto);
                            div.appendChild(link);
                            columna.appendChild(div);
                        }
                        else {
                            texto=document.createTextNode(nodo);
                            div.appendChild(texto);
                            columna.appendChild(div);
                    //}
                    }
                }
                //document.getElementById('buscar').style.visibility='visible'
            }
        }
    }
}
function muestraApliMovfin() {
        //alert('esto es bueno');
        if(http_request.readyState == 4) {
            if(http_request.status == 200) {

                var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("lisaplicantesmov")[0];
                var reg = lista.getElementsByTagName("aplicante");
                var elementos=["nombre","progmov","estado","id_solicitud"];
                var cuerpotablafinpro=document.getElementById('cuerpotablafinpro'),fila,texto,nodo,url,link,columna,div;
                var isolicitud = 0 ;
                for(var i = 0; i < reg.length;i++){

                    fila=cuerpotablafinpro.insertRow(0);
                    isolicitud = reg[i].getElementsByTagName(elementos[3])[0].firstChild.nodeValue;
                    for(var j = 0; j <= 2; j++){
                        if (j <= 2 ) {
                            nodo=reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                        }
                        columna=fila.insertCell(j);
                        div=document.createElement("div");
                        if( j > 1 ){
                            div.setAttribute("align", "center");
                        }else{
                            div.setAttribute("align", "left");
                        }

                            if (j == 0){
                            link=document.createElement("a");
                            link.setAttribute("id", nodo);
                            link.setAttribute("href", "finproceso?idSolicitud="+isolicitud);
                            link.setAttribute("target", "_blank");
                            texto=document.createTextNode(nodo);
                            link.appendChild(texto);
                            div.appendChild(link);
                            columna.appendChild(div);
                        }
                        else {
                            texto=document.createTextNode(nodo);
                            div.appendChild(texto);
                            columna.appendChild(div);
                    //}
                    }
                }
                //document.getElementById('buscar').style.visibility='visible'
            }
        }
    }
}
function muestralisDoc() {
        //alert('esto es bueno');
        if(http_request.readyState == 4) {
            if(http_request.status == 200) {

                var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("lisaplicantesmov")[0];
                var reg = lista.getElementsByTagName("aplicante");
                var elementos=["idsolicitud","nombre","progmov"];
                var cuerpo3=document.getElementById('cuerpo3'),fila,texto,nodo,url,link,columna,div;
                var isolicitud = 0 ;
                for(var i = 0; i < reg.length;i++){

                    fila=cuerpo3.insertRow(0);
                    isolicitud = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                    for(var j = 1; j <= 2; j++){
                        if (j <= 2 ) {
                            nodo=reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                        }
                        columna=fila.insertCell(j-1);
                        div=document.createElement("div");
                        if( j > 1 ){
                            div.setAttribute("align", "center");
                        }else{
                            div.setAttribute("align", "left");
                        }
                        if (j == 1){
                            link=document.createElement("a");
                            link.setAttribute("id", nodo);
                            link.setAttribute("href", "documentosEst?idSolicitud="+isolicitud);
                            link.setAttribute("target", "_blank");
                            texto=document.createTextNode(nodo);
                            link.appendChild(texto);
                            div.appendChild(link);
                            columna.appendChild(div);
                        }
                        else {
                            texto=document.createTextNode(nodo);
                            div.appendChild(texto);
                            columna.appendChild(div);
                    //}
                    }
                }
                //document.getElementById('buscar').style.visibility='visible'
            }
        }
    }
}
function muestraDocumentos() {
        //alert('esto es bueno');
        if(http_request.readyState == 4) {
            if(http_request.status == 200) {

                var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("lisdocumetosest")[0];
                var reg = lista.getElementsByTagName("estadosdocu");
                var elementos=["carta_ud","vobo_foresp","estado_cpadres","estado_idiomas","estado_notas","estado_HV","idsolicitud","id_est","estado"];
                //"carta_ud","vobo_foresp","estado_cpadres","estado_idiomas","estado_notas","estado_HV","idsolicitud","id_est"
                var cuerpo4=document.getElementById('cuerpo4'),fila,act,nodo,columna,div,idest,estado;
                act="";
                var isolicitud = 0 ;
                var ban=reg.length;
                isolicitud = reg[0].getElementsByTagName(elementos[6])[0].firstChild.nodeValue;
                idest = reg[0].getElementsByTagName(elementos[7])[0].firstChild.nodeValue;
                estado = reg[0].getElementsByTagName(elementos[8])[0].firstChild.nodeValue;
                for(var i = 0; i < 8;i++){
                    fila=cuerpo4.insertRow(0);
                    for(var j = 0; j <= 3; j++)
                    {
                        columna=fila.insertCell(j);
                        div=document.createElement("div");
                        if( j > 1 ){
                            div.setAttribute("align", "center");
                        }else{
                            div.setAttribute("align", "left");
                        }
                        if (j == 0)
                        {
                            switch (i)
                            {
                                /*
                                    case 0:    columna.innerHTML="<a href='http://localhost:8080/DocumentosAplicantesMovilidad/"+idest+"-CartaU2-"+isolicitud
                                                                   +".pdf' target='_blank'> Carta para la Universidad Opcion2</a>";
                                                break;
                                    case 1:  columna.innerHTML="<a href='http://localhost:8080/DocumentosAplicantesMovilidad/"+idest+"-CartaU1-"+isolicitud
                                                                   +".pdf' target='_blank'> Carta para la Universidad Opcion1</a>";
                                                break;
                                    case 2:  columna.innerHTML="<a href='http://localhost:8080/DocumentosAplicantesMovilidad/"+idest+"-FormatoU2-"+isolicitud
                                                                   +".pdf' target='_blank'> Formato Especifico Opcion 2</a>";
                                                break;
                                    case 3:  columna.innerHTML="<a href='http://localhost:8080/DocumentosAplicantesMovilidad/"+idest+"-FormatoU1-"+isolicitud
                                                                   +".pdf' target='_blank'> Formato Especifico Opcion 1</a>";
                                                break;
                                    case 4:  columna.innerHTML="<a href='http://localhost:8080/DocumentosAplicantesMovilidad/"+idest+"-Cpadres-"+isolicitud
                                                                   +".pdf' target='_blank'> Carta de los Padres</a>";
                                                break;
                                    case 5:  columna.innerHTML="<a href='http://localhost:8080/DocumentosAplicantesMovilidad/"+idest+"-Idiomas-"+isolicitud
                                                                   +".pdf' target='_blank'> Idiomas</a>";
                                                break;
                                    case 6:  columna.innerHTML="<a href='http://localhost:8080/DocumentosAplicantesMovilidad/"+idest+"-Notas-"+isolicitud
                                                                   +".pdf' target='_blank'> Notas</a>";
                                                break;
                                    case 7:     columna.innerHTML="<a href='http://localhost:8080/DocumentosAplicantesMovilidad/"+idest+"-HojaVida-"+isolicitud
                                                                   +".pdf' target='_blank'> Hoja de Vida</a>";
                                                break;*/
                            case 0: if(ban>1){   
                                columna.innerHTML="<a href='http://practicas.escuelaing.edu.co/doc_movilidad/"+idest+"-CartaU2-"+isolicitud
                                                                   +".pdf' target='_blank'>Carta de Intención Opción 2</a>";}
                                                       else{
                                                           
                                                            columna.innerHTML="Sin opción 2"
                                                       }
                                                break;
                                    case 1:  columna.innerHTML="<a href='http://practicas.escuelaing.edu.co/doc_movilidad/"+idest+"-CartaU1-"+isolicitud
                                                                   +".pdf' target='_blank'>Carta de Intención Opción 1</a>";
                                                break;
                                    case 2:
                                        if(ban>1){  
                                        columna.innerHTML="<a href='http://practicas.escuelaing.edu.co/doc_movilidad/"+idest+"-FormatoU2-"+isolicitud
                                                                   +".pdf' target='_blank'>Formularios y Documentos específicos Opción 2</a>";}
                                                        else{
                                                           
                                                            columna.innerHTML="Sin opción 2"
                                                       }
                                                break;
                                    case 3:  columna.innerHTML="<a href='http://practicas.escuelaing.edu.co/doc_movilidad/"+idest+"-FormatoU1-"+isolicitud
                                                                   +".pdf' target='_blank'>Formularios y Documentos específicos Opción 1</a>";
                                                break;
                                    case 4:  columna.innerHTML="<a href='http://practicas.escuelaing.edu.co/doc_movilidad/"+idest+"-Cpadres-"+isolicitud
                                                                   +".pdf' target='_blank'>Anexos</a>";
                                                break;
                                    case 5:  columna.innerHTML="<a href='http://practicas.escuelaing.edu.co/doc_movilidad/"+idest+"-Idiomas-"+isolicitud
                                                                   +".pdf' target='_blank'>Idiomas</a>";
                                                break;
                                    case 6:  columna.innerHTML="<a href='http://practicas.escuelaing.edu.co/doc_movilidad/"+idest+"-Notas-"+isolicitud
                                                                   +".pdf' target='_blank'>Certificado de Notas</a>";
                                                break;
                                    case 7:     columna.innerHTML="<a href='http://practicas.escuelaing.edu.co/doc_movilidad/"+idest+"-HojaVida-"+isolicitud
                                                                   +".pdf' target='_blank'>Hoja de Vida</a>";
                                                break
                            }


                        }
                       else
                       {
                           //"carta_ud","vobo_foresp","estado_cpadres","estado_idiomas","estado_notas","estado_HV","idsolicitud","id_est"
                           if(ban > 1){
                           if(i<4)
                           {
                               if(i==0)
                               {  
                                   nodo = reg[1].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                               }
                               if(i==1)
                               {   
                                   nodo = reg[0].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                               }
                               if(i==2)
                               {
                                   nodo = reg[1].getElementsByTagName(elementos[1])[0].firstChild.nodeValue;
                               }    
                               if(i==3)
                               {
                                   nodo = reg[0].getElementsByTagName(elementos[1])[0].firstChild.nodeValue;
                               }
                           }
                           else
                           {
                               nodo = reg[1].getElementsByTagName(elementos[i-2])[0].firstChild.nodeValue;
                           }
                       }
                       else{
                           if(i<4)
                           {
                               //if(i==0)
                               //{  
                                 ///  nodo = reg[1].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                               //}
                               if(i==1)
                               {   
                                   nodo = reg[0].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                               }
                               //if(i==2)
                               //{
                                 //  nodo = reg[1].getElementsByTagName(elementos[1])[0].firstChild.nodeValue;
                               //}    
                               if(i==3)
                               {
                                   nodo = reg[0].getElementsByTagName(elementos[1])[0].firstChild.nodeValue;
                               }
                           }
                           else
                           {
                               nodo = reg[0].getElementsByTagName(elementos[i-2])[0].firstChild.nodeValue;
                           }
                           
                           
                       }

                            if(nodo == "cargado" || nodo =="cargado   " )
                             {
                                   act="";
                             }
                             else
                             {
                                 if(estado=="d         ")
                                 {
                                   act="disabled";
                                 }
                             }

                            if(j==1)
                            {
                                switch (i)
                                {
                                    //"carta_ud","vobo_foresp","estado_cpadres","estado_idiomas","estado_notas","estado_HV","idsolicitud","id_est"
                                        case 0:if(ban>1){     
                                            columna.innerHTML="<input class='button_azul_consulta' type= 'submit' value='Aceptar' name='unico' onclick= 'AceptarDocOpc("+ i +","+ isolicitud + ");'"+ act+ "/>";
                                        }else{
                                                columna.innerHTML="Sin opción 2"
                                            }break;
                                        case 1:     columna.innerHTML="<input class='button_azul_consulta' type= 'submit' value='Aceptar' name='unico' onclick= 'AceptarDocOpc("+ i +","+ isolicitud + ");'"+ act+ "/>";
                                                    break;
                                        case 2:     if(ban>1){columna.innerHTML="<input class='button_azul_consulta' type= 'submit' value='Aceptar' name='unico' onclick= 'AceptarDocOpc("+ i +","+ isolicitud + ");'"+ act+ "/>";
                                        }else{
                                                columna.innerHTML="Sin opción 2"
                                            }break;
                                        case 3:     columna.innerHTML="<input class='button_azul_consulta' type= 'submit' value='Aceptar' name='unico' onclick= 'AceptarDocOpc("+ i +","+ isolicitud + ");'"+ act+ "/>";
                                                    break;
                                        case 4:     columna.innerHTML="<input class='button_azul_consulta' type= 'submit' value='Aceptar' name='unico' onclick= 'AceptarDocGen("+ i+","+ isolicitud + ");'"+ act+ "/>";
                                                    break;
                                        case 5:     columna.innerHTML="<input class='button_azul_consulta' type= 'submit' value='Aceptar' name='unico' onclick= 'AceptarDocGen("+ i +","+ isolicitud + ");'"+ act+ "/>";
                                                    break;
                                        case 6:     columna.innerHTML="<input class='button_azul_consulta' type= 'submit' value='Aceptar' name='unico' onclick= 'AceptarDocGen("+ i +","+ isolicitud + ");'"+ act+ "/>";
                                                    break;
                                        case 7:     columna.innerHTML="<input class='button_azul_consulta' type= 'submit' value='Aceptar' name='unico' onclick= 'AceptarDocGen("+ i +","+ isolicitud + ");'"+ act+ "/>";
                                                    break;
                                }

                            }
                            if(j==2)

                            {
                                switch (i)
                                {
                                        case 0:    columna.innerHTML="<input class='button_azul_consulta' type= 'submit' value='Rechazar' name='unico' onclick= 'RechazarDocOpc("+ i +","+ isolicitud + ");'"+ act+ "/>";
                                                    break;
                                        case 1:    columna.innerHTML="<input class='button_azul_consulta' type= 'submit' value='Rechazar' name='unico' onclick= 'RechazarDocOpc("+ i +","+ isolicitud + ");'"+ act+ "/>";
                                                    break;
                                        case 2:    columna.innerHTML="<input class='button_azul_consulta' type= 'submit' value='Rechazar' name='unico' onclick= 'RechazarDocOpc("+ i +","+ isolicitud + ");'"+ act+ "/>";
                                                    break;
                                        case 3:    columna.innerHTML="<input class='button_azul_consulta' type= 'submit' value='Rechazar' name='unico' onclick= 'RechazarDocOpc("+ i +","+ isolicitud + ");'"+ act+ "/>";
                                                    break;
                                        case 4:    columna.innerHTML="<input class='button_azul_consulta' type= 'submit' value='Rechazar' name='unico' onclick= 'RechazarDocGen("+ i +","+ isolicitud + ");'"+ act+ "/>";
                                                    break;
                                        case 5:   columna.innerHTML="<input class='button_azul_consulta' type= 'submit' value='Rechazar' name='unico' onclick= 'RechazarDocGen("+ i +","+ isolicitud + ");'"+ act+ "/>";
                                                    break;
                                        case 6:   columna.innerHTML="<input class='button_azul_consulta' type= 'submit' value='Rechazar'name='unico' onclick= 'RechazarDocGen("+ i +","+ isolicitud + ");'"+ act+ "/>";
                                                    break;
                                        case 7:    columna.innerHTML="<input class='button_azul_consulta' type= 'submit' value='Rechazar'  name='unico' onclick= 'RechazarDocGen("+ i +","+ isolicitud + ");'"+ act+ "/>";
                                                    break;
                                }

                            }
                            if(j==3)

                            {
                                columna.innerHTML=nodo;                                

                            }

                        }
                    }                
            }
        }
    }
}
function planes(){
        //Limpiar Tabla
         document.getElementById('buscar').style.visibility='hidden';
        var tabla=document.getElementById('tabla');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }
        //Realizar Peticion
         //alert('esto es bueno');
        //setVisibilidad(['RequerimientosConMov=inline']);
        var url = 'pave.xml';
        conectarX(url,prueba);
    }
function AceptarDocOpc(tipo,idsolicitud)    {
        var url;

        switch (tipo)
        {
               case 0:      url = 'AceptarDocumento?tipo=CartaU2&idsol='+idsolicitud+'&clave=aceptado&nom=carta_ud';
                            conectarMethod(url, tramitadocumentomov, 'POST');
                            //url = 'ActualizarEstMov?'+"idsolicitud=" + idsolicitud;
                            //conectarMethod(url, muestranadareload, 'POST');
                            //conectarMethod(url, tramitadocumentomov(idsolicitud), 'POST');
                            
                            //actualizartabdocu(idsolicitud);
                            break;
                case 1:     url = 'AceptarDocumento?tipo=CartaU1&idsol='+idsolicitud+'&clave=aceptado&nom=carta_ud';
                            conectarMethod(url, tramitadocumentomov, 'POST');
                            //url = 'ActualizarEstMov?'+"idsolicitud=" + idsolicitud;
                            //conectarMethod(url, muestranadareload, 'POST');
                            //actualizartabdocu(idsolicitud);
                            break;
                case 2:     url = 'AceptarDocumento?tipo=FormatoU2&idsol='+idsolicitud+'&clave=aceptado&nom=vobo_foresp';
                            conectarMethod(url, tramitadocumentomov, 'POST');
                            //url = 'ActualizarEstMov?'+"idsolicitud=" + idsolicitud;
                            //conectarMethod(url, muestranadareload, 'POST');
                            //actualizartabdocu(idsolicitud);
                            break;
                case 3:     url = 'AceptarDocumento?tipo=FormatoU1&idsol='+idsolicitud+'&clave=aceptado&nom=vobo_foresp';
                            conectarMethod(url, tramitadocumentomov, 'POST');
                            //url = 'ActualizarEstMov?'+"idsolicitud=" + idsolicitud;
                            //conectarMethod(url, muestranadareload, 'POST');
                            //actualizartabdocu(idsolicitud);
                            break;
        }
        
    } 
    
function AceptarDocGen(tipo,idsolicitud)    {
        var url;
        switch (tipo)
        {
                case 4:     url = 'AceptarDocumento?tipo=CartaPa&idsol='+idsolicitud+'&clave=aceptado&nom=estado_cpadres';
                            conectarMethod(url, tramitadocumentomov, 'POST');
                            //conectarMethod(url, muestranadareload, 'POST');
                            //url = 'ActualizarEstMov?'+"idsolicitud=" + idsolicitud;
                            //conectarMethod(url, muestranadareload, 'POST');
                            //actualizartabdocu(idsolicitud);
                            break;
                case 5:     url = 'AceptarDocumento?tipo=idiomas&idsol='+idsolicitud+'&clave=aceptado&nom=estado_idiomas';
                     conectarMethod(url, tramitadocumentomov, 'POST');
                             //conectarMethod(url, muestranadareload, 'POST');
                            //url = 'ActualizarEstMov?'+"idsolicitud=" + idsolicitud;
                            //conectarMethod(url, muestranadareload, 'POST');
                            //actualizartabdocu(idsolicitud);
                            break;
                case 6:    url = 'AceptarDocumento?tipo=Notas&idsol='+idsolicitud+'&clave=aceptado&nom=estado_notas';
                     conectarMethod(url, tramitadocumentomov, 'POST');
                          //conectarMethod(url, muestranadareload, 'POST');
                            //url = 'ActualizarEstMov?'+"idsolicitud=" + idsolicitud;
                            //conectarMethod(url, muestranadareload, 'POST');
                            //actualizartabdocu(idsolicitud);
                            break;
                case 7:     url = 'AceptarDocumento?tipo=HojaVida&idsol='+idsolicitud+'&clave=aceptado&nom=estado_HV';
                     conectarMethod(url, tramitadocumentomov, 'POST');
                            //conectarMethod(url, muestranadareload, 'POST');
                            //url = 'ActualizarEstMov?'+"idsolicitud=" + idsolicitud;
                            //conectarMethod(url, muestranadareload, 'POST');
                            //actualizartabdocu(idsolicitud);
                            break;
        }
    }
function RechazarDocOpc(tipo,idsolicitud)    {
        var url;

        switch (tipo)
        {
               case 0:      url = 'AceptarDocumento?tipo=CartaU2&idsol='+idsolicitud+'&clave=rechazado&nom=carta_ud';
                   conectarMethod(url, tramitadocumentomov, 'POST');
                            //conectarMethod(url, muestranadareload, 'POST');
                            //url = 'ActualizarEstMov?'+"idsolicitud=" + idsolicitud;                           
                            //conectarMethod(url, muestranadareload, 'POST');
                            //actualizartabdocu(idsolicitud);
                            break;
                case 1:     url = 'AceptarDocumento?tipo=CartaU1&idsol='+idsolicitud+'&clave=rechazado&nom=carta_ud';
                            conectarMethod(url, tramitadocumentomov, 'POST');
                            //actualizartabdocu(idsolicitud);
                            break;
                case 2:     url = 'AceptarDocumento?tipo=FormatoU2&idsol='+idsolicitud+'&clave=rechazado&nom=vobo_foresp';
                           conectarMethod(url, tramitadocumentomov, 'POST');
                            //actualizartabdocu(idsolicitud);
                            break;
                case 3:     url = 'AceptarDocumento?tipo=FormatoU1&idsol='+idsolicitud+'&clave=rechazado&nom=vobo_foresp';
                            conectarMethod(url, tramitadocumentomov, 'POST');
                            //actualizartabdocu(idsolicitud);
                            break;
        }
    }
function RechazarDocGen(tipo,idsolicitud)    {
        var url;
        switch (tipo)
        {
                case 4:     url = 'AceptarDocumento?tipo=CartaPa&idsol='+idsolicitud+'&clave=rechazado&nom=estado_cpadres';
                           conectarMethod(url, tramitadocumentomov, 'POST');
                            //actualizartabdocu(idsolicitud);
                            break;
                case 5:     url = 'AceptarDocumento?tipo=idiomas&idsol='+idsolicitud+'&clave=rechazado&nom=estado_idiomas';
                            conectarMethod(url, tramitadocumentomov, 'POST');
                            //actualizartabdocu(idsolicitud);
                            break;
                case 6:    url = 'AceptarDocumento?tipo=Notas&idsol='+idsolicitud+'&clave=rechazado&nom=estado_notas';
                            conectarMethod(url, tramitadocumentomov, 'POST');
                            //actualizartabdocu(idsolicitud);
                            break;
                case 7:     url = 'AceptarDocumento?tipo=HojaVida&idsol='+idsolicitud+'&clave=rechazado&nom=estado_HV';
                           conectarMethod(url, tramitadocumentomov, 'POST');
                            //actualizartabdocu(idsolicitud);
                            break;
        }
    }
function generareportes(){   
    setVisibilidad(['consultamov=none','tablamov=none','contraseña=none','reportes=inline']);
}
function prueba2(){

   // alert('esto es bueno');
    
        // setVisibilidad('Requerimientos=inline');
        alert('esta funcion esta en construccion');
         //var mensaje=document.getElementById('mensaje');
         //mensaje.innerHTML=http_request.responseText;
     
}
function finalizarestado(idsolicitud, estado){
    var answer;
    var comment = '';
    if (estado.trim() == 'i' || estado.trim() == 'j') {
        answer = confirm("¿Está seguro de querer Finalizar con exito este proceso?");
    } else {
        comment = document.getElementById('comment').value;
        if (comment == '') {
            alert('Debe escribir un comentario');
            return;
        }
        answer = confirm("¿Está seguro de querer Finalizar e interrumpir este proceso?");
    }
    if (answer)
    {
    var url2='ActualizarEstMov?'+"idsolicitud=" + idsolicitud + "&clave=k&comentario=" + comment;
      conectarMethod(url2, muestraResultadoclose, 'POST');
       //window.close();
    }

}
function tramitaUnivermov() {
    var url;
    if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
            var idsolicitud=respuesta.getElementsByTagName("dato")[0].firstChild.nodeValue;
                 // alert(resul);                
                consultaropcuni();
                  // response.sendRedirect("EstMov" );
            
        }
    }
}
function muestraResultadouni() {
    var url;
    if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var respuesta=xmldoc.getElementsByTagName("resultado")[0];
            var resul=respuesta.getElementsByTagName("valor")[0].firstChild.nodeValue;
            var idsolicitud=respuesta.getElementsByTagName("dato")[0].firstChild.nodeValue;
            url = url = 'ActualizarEstMov?'+"idsolicitud=" + idsolicitud;
            conectarMethod(url, tramitaUnivermov, 'POST');
            // response.sendRedirect("EstMov" );
        }
    }
}