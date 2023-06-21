/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function VerEnviarSolicitud()
{
    setVisibilidad(['datosol=inline', 'Cnestado=none','cargardocumentos=none','enviarplandeestudio=none']);
}
function VerConsultarEstado()
{
    setVisibilidad(['datosol=none', 'Cnestado=inline','cargardocumentos=none','enviarplandeestudio=none']);
}
function vercargardoc ()
{
      setVisibilidad(['datosol=none', 'Cnestado=none','cargardocumentos=inline','enviarplandeestudio=none']);
}
function verenviarplandeestudio(){
    setVisibilidad(['datosol=none', 'Cnestado=none','cargardocumentos=none','enviarplandeestudio=inline']);
}
function VerCambiarplan(){
     setVisibilidad(['datosol=none', 'Cnestado=none','cargardocumentos=none','enviarplandeestudio=none']);
}
function EnviarSolicitud(idest)
{
     var formobj=document.fromSolicitudMov;
   if (! validaFecha(document.getElementById("fechain").value))
   {
       return false;
   }
   else
       {
           if (! validaFecha(document.getElementById("fechaout").value))
           {
               return false;
           }
           else
           {
               if(!isTextoObligatorio(['opc1','prog1','pais_mov'], ['Universidad1','Programa1','País al que desea aplicar']))
               {
                   return false;
               }
               else
               {
                   if(!isemail (['email_acudiente'],['Ingrese Email del Acudiente']))
                       {
                           return false;
                       }
                       else{
                           if(!isTextoOpcional(['opc2','prog2'], ['Universidad2','programa2']))
                           {
                              return false;
                           }
                           if(document.getElementById("carta_eci").value.length >= 5000){
                               alert("La carta de intencion supera los 5000 caracteres");
                               return false;
                           }
                           document.getElementById('EnvSolMov').disabled = 'true';
                           formobj.action = 'GuardarSolicitud?' +"idest="+idest;
                           document.getElementById('EnvSolMov').disabled = 'false'; 
                           return true;
                           /*var url = 'GuardarSolicitud?' +"idest="+idest+"&opc1="+encodeURIComponent(document.getElementById("opc1").value)+
                                   
                                   "&opc2="+encodeURIComponent(document.getElementById("opc2").value)+ 
                                   "&prog1="+encodeURIComponent(document.getElementById("prog1").value)+ 
                                   "&prog2="+encodeURIComponent(document.getElementById("prog2").value)+ "&"+
                                   getValores(['email_acudiente','ProgramaSolicitado','pais_mov','fechain','fechaout','carta_eci']);
                           conectarMethod(url,muestraResultadoreload, 'POST');*/
                           //location.reload();
                       }
               }
           }

       }
}
function CargarDocumento(idsol,tipo)
{
     var url = 'FileUp?tipo='+ tipo + '&idsol'+ idsol;
     conectarMethod(url, muestraResultado, 'POST');
}
function actualizarestadoest(idsolicitud)
{
     var url2='ActualizarEstMov?'+"idsolicitud=" + idsolicitud + "&clave=c";
      conectarMethod(url2, muestraResultadoreload, 'POST');
   
}
function actualizartablaCrgardoc(idsol)
{
        //Limpiar Tabla
         //document.getElementById('buscar').style.visibility='hidden';
        //var ProgramaAcademic= ProgramaAcademico.value;
        var tabla=document.getElementById('tablaCrgardoc');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }
        //Realizar Peticion
         //alert('esto es bueno');
        //setVisibilidad(['RequerimientosConMov=inline']);
        var url = 'lisDocumentos'+"?id=" + idsol;
        conectarX(url,muestraCrgarDoc);
        //return false;
}
function muestraCrgarDoc() {
        //alert('esto es bueno');
        if(http_request.readyState == 4) {
            if(http_request.status == 200) {

                var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("lisdocumetosest")[0];
                var reg = lista.getElementsByTagName("estadosdocu");
                var elementos=["carta_ud","vobo_foresp","estado_cpadres","estado_idiomas","estado_notas","estado_HV","idsolicitud","id_est"];
                //"carta_ud","vobo_foresp","estado_cpadres","estado_idiomas","estado_notas","estado_HV","idsolicitud","id_est"
                var cuerpo5=document.getElementById('cuerpo5'),fila,act,nodo,columna,div,idest;
                var isolicitud = 0 ;
                isolicitud = reg[0].getElementsByTagName(elementos[6])[0].firstChild.nodeValue;
                idest= reg[0].getElementsByTagName(elementos[7])[0].firstChild.nodeValue;
                var ban=reg.length;              
                for(var i = 0; i < 8;i++){
                    fila=cuerpo5.insertRow(0);
                    for(var j = 0; j <= 1; j++)
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
                                    case 0:    columna.innerHTML="<a>Ingrese el archivo con la Carta de Intención Opción 2</a>";
                                                break;
                                    case 1:  columna.innerHTML="<a>Ingrese el archivo con la Carta de Intención Opción 1</a>";
                                                break;
                                    case 2:  columna.innerHTML="<a>Ingrese el archivo con los Formularios y Documentos específicos Opción 2</a>";
                                                break;
                                    case 3:  columna.innerHTML="<a>Ingrese el archivo con los Formularios y Documentos específicos Opción 1</a>";
                                                break;
                                    case 4:  columna.innerHTML="<a>Ingrese el archivo con sus Anexos:</a>";
                                                break;
                                    case 5:  columna.innerHTML="<a>Ingrese el archivo con sus Idiomas:</a>";
                                                break;
                                    case 6:  columna.innerHTML="<a>Ingrese el archivo con su Certificado de Notas:</a>";
                                                break;
                                    case 7:     columna.innerHTML="<a>Ingrese el archivo con su Hoja de vida:</a>";
                                                break;
                            }


                        }
                       else
                       {
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
                                //   nodo = reg[1].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                               //}
                               if(i==1)
                               {
                                   nodo = reg[0].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                               }
                               //if(i==2)
                               //{
                                  // nodo = reg[1].getElementsByTagName(elementos[1])[0].firstChild.nodeValue;
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

                            if(nodo == "cargado" || nodo =="cargado   " || nodo == "aceptado" || nodo =="aceptado  ")
                             {
                                   act="disabled";
                             }
                             else
                             {
                                   act="";
                             }

                           //"carta_ud","vobo_foresp","estado_cpadres","estado_idiomas","estado_notas","estado_HV","idsolicitud","id_est"
                            switch (i) {
                                    case 0:
                                        if (ban>1) {
                                            columna.innerHTML='<form name="cargarcarta2" method="POST" ENCTYPE="multipart/form-data" action="FileUp" onsubmit="document.getElementById(\'subCuni2\').value=\'Subiendo...\';document.getElementById(\'subCuni2\').disabled=true" ' + act +'>'
                                                            + '<input type="hidden" name="clave" value="cargado">'
                                                            + '<input type="hidden" name="tipo" value="CartaU2">'
                                                            + '<input type="hidden" name="nom" value="carta_ud">'
                                                            + '<input type="hidden" name="idsol" value="' + isolicitud + '">'
                                                            + '<input type="hidden" name="idest" value="' + idest + '">'
                                                            + '<input class="inputlargo" type="file" name="CartaU2upload" id="Cuni2upload" ' + act + '>'
                                                            + '<input id="subCuni2" value="Enviar PDF" type="submit" ' + act + ' />'
                                                            + '</form>';
                                        } else {
                                            columna.innerHTML='Sin opción 2';
                                        }
                                            
                                        break;
                                    case 1:
                                        columna.innerHTML='<form name="cargarcarta1" method="POST" ENCTYPE="multipart/form-data" action="FileUp" onsubmit="document.getElementById(\'subCuni1\').value=\'Subiendo...\';document.getElementById(\'subCuni1\').disabled=true" ' + act +'>'
                                                            + '<input type="hidden" name="clave" value="cargado">'
                                                            + '<input type="hidden" name="tipo" value="CartaU1">'
                                                            + '<input type="hidden" name="nom" value="carta_ud">'
                                                            + '<input type="hidden" name="idsol" value="' + isolicitud + '">'
                                                            + '<input type="hidden" name="idest" value="' + idest + '">'
                                                            + '<input class="inputlargo" type="file" name="CartaU1upload" id="Cuni1upload" ' + act + '>'
                                                            + '<input id="subCuni1" value="Enviar PDF" type="submit" ' + act + ' />'
                                                            + '</form>';
                                        break;
                                    case 2:
                                        if (ban>1) {
                                            columna.innerHTML='<form name="cargarFormatoU2" method="POST" ENCTYPE="multipart/form-data" action="FileUp" onsubmit="document.getElementById(\'subFor2\').value=\'Subiendo...\';document.getElementById(\'subFor2\').disabled=true" ' + act +'>'
                                                            + '<input type="hidden" name="clave" value="cargado">'
                                                            + '<input type="hidden" name="tipo" value="FormatoU2">'
                                                            + '<input type="hidden" name="nom" value="vobo_foresp">'
                                                            + '<input type="hidden" name="idsol" value="' + isolicitud + '">'
                                                            + '<input type="hidden" name="idest" value="' + idest + '">'
                                                            + '<input class="inputlargo" type="file" name="FormatoU2upload" id="For2upload" ' + act + '>'
                                                            + '<input id="subFor2" value="Enviar PDF" type="submit" ' + act + ' />'
                                                            + '</form>';
                                        }else{
                                            columna.innerHTML='Sin opción 2';
                                        }
                                        
                                        break;
                                    case 3:
                                        columna.innerHTML='<form name="cargarFormatoU1" method="POST" ENCTYPE="multipart/form-data" action="FileUp" onsubmit="document.getElementById(\'subFor1\').value=\'Subiendo...\';document.getElementById(\'subFor1\').disabled=true" ' + act +'>'
                                                            + '<input type="hidden" name="clave" value="cargado">'
                                                            + '<input type="hidden" name="tipo" value="FormatoU1">'
                                                            + '<input type="hidden" name="nom" value="vobo_foresp">'
                                                            + '<input type="hidden" name="idsol" value="' + isolicitud + '">'
                                                            + '<input type="hidden" name="idest" value="' + idest + '">'
                                                            + '<input class="inputlargo" type="file" name="FormatoU1upload" id="For1upload" ' + act + '>'
                                                            + '<input id="subFor1" value="Enviar PDF" type="submit" ' + act + ' />'
                                                            + '</form>';
                                        break;
                                    case 4:
                                        columna.innerHTML='<form name="cargarCpadres" method="POST" ENCTYPE="multipart/form-data" action="FileUp" onsubmit="document.getElementById(\'subCpadres\').value=\'Subiendo...\';document.getElementById(\'subCpadres\').disabled=true" ' + act +'>'
                                                            + '<input type="hidden" name="clave" value="cargado">'
                                                            + '<input type="hidden" name="tipo" value="Cpadres">'
                                                            + '<input type="hidden" name="nom" value="estado_cpadres">'
                                                            + '<input type="hidden" name="idsol" value="' + isolicitud + '">'
                                                            + '<input type="hidden" name="idest" value="' + idest + '">'
                                                            + '<input class="inputlargo" type="file" name="Cpadresupload" id="Cpadresupload" ' + act + '>'
                                                            + '<input id="subCpadres" value="Enviar PDF" type="submit" ' + act + ' />'
                                                            + '</form>';
                                        break;
                                    case 5:
                                        columna.innerHTML='<form name="cargarIdiomas" method="POST" ENCTYPE="multipart/form-data" action="FileUp" onsubmit="document.getElementById(\'subIdiomas\').value=\'Subiendo...\';document.getElementById(\'subIdiomas\').disabled=true" ' + act +'>'
                                                            + '<input type="hidden" name="clave" value="cargado">'
                                                            + '<input type="hidden" name="tipo" value="Idiomas">'
                                                            + '<input type="hidden" name="nom" value="estado_idiomas">'
                                                            + '<input type="hidden" name="idsol" value="' + isolicitud + '">'
                                                            + '<input type="hidden" name="idest" value="' + idest + '">'
                                                            + '<input class="inputlargo" type="file" name="Idiomasupload" id="Idiomasupload" ' + act + '>'
                                                            + '<input id="subIdiomas" value="Enviar PDF" type="submit" ' + act + ' />'
                                                            + '</form>';
                                        break;
                                    case 6:
                                        columna.innerHTML='<form name="cargarNotas" method="POST" ENCTYPE="multipart/form-data" action="FileUp" onsubmit="document.getElementById(\'subNotas\').value=\'Subiendo...\';document.getElementById(\'subNotas\').disabled=true" ' + act +'>'
                                                            + '<input type="hidden" name="clave" value="cargado">'
                                                            + '<input type="hidden" name="tipo" value="Notas">'
                                                            + '<input type="hidden" name="nom" value="estado_notas">'
                                                            + '<input type="hidden" name="idsol" value="' + isolicitud + '">'
                                                            + '<input type="hidden" name="idest" value="' + idest + '">'
                                                            + '<input class="inputlargo" type="file" name="Notasupload" id="Notasupload" ' + act + '>'
                                                            + '<input id="subNotas" value="Enviar PDF" type="submit" ' + act + ' />'
                                                            + '</form>';
                                        break;
                                    case 7:
                                        //columna.innerHTML="<form name='cargarHV' method='POST' ENCTYPE='multipart/form-data' action='FileUp?tipo=HojaVida&idsol="+ isolicitud + "&clave=cargado&nom=estado_HV&idest="+idest+"'"+ act +"><input class='inputlargo'type='file' name='HojaVidaupload' id='HVupload'"+ act +"><input id='subHV' value='Enviar Pdf' type='submit'"+ act +" /> </form>";
                                        columna.innerHTML='<form name="cargarHV" method="POST" ENCTYPE="multipart/form-data" action="FileUp" onsubmit="document.getElementById(\'subHV\').value=\'Subiendo...\';document.getElementById(\'subHV\').disabled=true" ' + act +'>'
                                                            + '<input type="hidden" name="clave" value="cargado">'
                                                            + '<input type="hidden" name="tipo" value="HojaVida">'
                                                            + '<input type="hidden" name="nom" value="estado_HV">'
                                                            + '<input type="hidden" name="idsol" value="' + isolicitud + '">'
                                                            + '<input type="hidden" name="idest" value="' + idest + '">'
                                                            + '<input class="inputlargo" type="file" name="HojaVidaupload" id="HVupload" ' + act + '>'
                                                            + '<input id="subHV" value="Enviar PDF" type="submit" ' + act + ' />'
                                                            + '</form>';
                                        break;
                            }
                            //actualizartablaCrgardoc(isolicitud);

                        }
                    }
            }
        }
    }
}
function Registrarmat(idsol,progmov)
{

             if (! validaperdiodo(document.getElementById("periodomat").value))
             {
               return;
           }
           else {

                var url = 'RegistrarMatMov?'+'prog_mov='+progmov +'&idsol='+idsol +'&'+ getValores(['periodomat','Mateci','Matext']);
                   //conectarMethod(url, , 'POST');
                   conectarMethod(url, muestraPlan, 'POST');
           }
           //ListaPlan(idsol);

}
function Enviarplan(idsol,usr)
{
    var answer = confirm("Esta seguro que el plan de estudio esta correcto.");
    if (answer)
    {
                  var url = 'enviarplan?'+'idsol='+idsol+"&usr="+usr;
                   conectarMethod(url, muestraant, 'POST');
    }
                   
}
function Enviarcambioplan(idsol,usr)
{
                  var url = 'EnviarCambioPlan?'+'idsol='+idsol+'&usr='+usr;
                   conectarMethod(url, muestraant, 'POST');
}
function ListaPlan(idsol)
{
        var tabla=document.getElementById('tablaPlanest');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }
        var url2 = 'lisPlanMov?' +'idsol='+idsol;
      conectarMethod(url2, muestraPlan, 'POST');
        //conectarX(url2,muestraPlan);
}
function ListaPlanActual(id_sol)
{
        var tabla=document.getElementById('tablaPlanest');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
        tabla.deleteRow(1);        }
        var url2 = 'lisPlanMov?' +'idsol='+id_sol;
        conectarMethod(url2, muestraPlan2, 'POST');
}
function ListaCambioPlan(id_sol){
        var tabla=document.getElementById('tablaCambioPlan');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
         tabla.deleteRow(1);        }
        var url2 = 'liscambioPlanMov?' +'idsol='+id_sol;
      conectarMethod(url2, muestraCambioPlanest, 'POST');
}
function muestraPlan()
{
    if(http_request.readyState == 4) {
            if(http_request.status == 200) {

                var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("lismaterias")[0];
                var reg = lista.getElementsByTagName("materia");

                var elementos=["semestre","materia_ud","materia_eci","est_plan","id_plan","idsolicitud","prog_mov"];
                var cuerpoplanpi=document.getElementById('cuerpoplanpi'),fila,id_plan,nodo,estado,act,columna,div,tj,tipoprog;
                var isolicitud = 0 ;
                
                for(var i = 0; i < reg.length;i++){

                    fila=cuerpoplanpi.insertRow(0);
                    tipoprog= reg[i].getElementsByTagName(elementos[6])[0].firstChild.nodeValue;
                    isolicitud = reg[i].getElementsByTagName(elementos[5])[0].firstChild.nodeValue;
                    if(tipoprog=="DOBLE TITULACION")
                    {
                        tj=3;
                    }
                    else{
                        tj=4;
                    }
                    for(var j = 1; j <= tj; j++){

                        nodo=reg[i].getElementsByTagName(elementos[j-1])[0].firstChild.nodeValue;

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
                            if(tj==3)
                            {
                                 estado=reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                                 id_plan=reg[i].getElementsByTagName(elementos[j+1])[0].firstChild.nodeValue;
                                 if(estado == "cargado   "){
                                      act="";
                                 }
                                 else{
                                     act="disabled";
                                 }
                                 columna.innerHTML="<input type= 'submit' value='Eliminar' name='EliminarMat' onclick= 'EliminarMat("+ id_plan +","+ isolicitud +");'"+ act + "/>";
                            }
                            else
                            {
                                   columna.innerHTML="<a>"+ nodo +"</a>";
                            }
                            
                        }
                        if (j == 4){
                             estado=reg[i].getElementsByTagName(elementos[j-1])[0].firstChild.nodeValue;
                             id_plan=reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                             if(estado == "cargado   "){
                                  act="";
                             }
                             else{
                                 act="disabled";
                             }
                             columna.innerHTML="<input type='submit' value='Eliminar' name='EliminarMat' onclick= 'EliminarMat("+ id_plan +","+ isolicitud +");'"+ act + "/>";
                        }
                    //}
                    }
                }
                //document.getElementById('buscar').style.visibility='visible'
            }
        }

}
function muestraPlan2()
{
    if(http_request.readyState == 4) {
            if(http_request.status == 200) {

                var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("lismaterias")[0];
                var reg = lista.getElementsByTagName("materia");

                var elementos=["semestre","materia_ud","materia_eci","est_plan","id_plan","idsolicitud","prog_mov"];
                var cuerpoplanpi=document.getElementById('cuerpoplanpi'),fila,id_plan,nodo,estado,act,columna,div,tj,tipoprog;
                var isolicitud = 0 ;

                for(var i = 0; i < reg.length;i++){

                    fila=cuerpoplanpi.insertRow(0);
                    tipoprog= reg[i].getElementsByTagName(elementos[6])[0].firstChild.nodeValue;
                    isolicitud = reg[i].getElementsByTagName(elementos[5])[0].firstChild.nodeValue;
                    if(tipoprog=="DOBLE TITULACION")
                    {
                        tj=3;
                    }
                    else{
                        tj=4;
                    }
                    for(var j = 1; j <= tj; j++){

                        nodo=reg[i].getElementsByTagName(elementos[j-1])[0].firstChild.nodeValue;

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
                            if(tj==3)
                            {
                                 estado=reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                                 id_plan=reg[i].getElementsByTagName(elementos[j+1])[0].firstChild.nodeValue;
                                 if(estado == "enviado   "){
                                      act="";
                                 }
                                 else{
                                     act="disabled";
                                 }
                                 columna.innerHTML="<a href='cambioplanMov2?id_plan="+id_plan+"&idsol="+isolicitud+"'> Cambiar</a>";
                            }
                            else
                            {
                                   columna.innerHTML="<a>"+ nodo +"</a>";
                            }
                        }
                        if (j == 4){
                             estado=reg[i].getElementsByTagName(elementos[j-1])[0].firstChild.nodeValue;
                             id_plan=reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                             if(estado == "cargado   "){
                                  act="";
                             }
                             else{
                                 act="disabled";
                             }
                            columna.innerHTML="<a href='cambioplanMov2?id_plan="+id_plan+"&idsol="+isolicitud+"'> Cambiar</a>";
                        }
                    //}
                    }
                }
                ListaCambioPlan(isolicitud);
                //document.getElementById('buscar').style.visibility='visible'
            }
        }

}
function muestraCambioPlanest()
{
    
    if(http_request.readyState == 4) {
            if(http_request.status == 200) {

                var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("lismaterias")[0];
                var reg = lista.getElementsByTagName("materia");

                var elementos=["materia_actual","materia_nueva","semestre","motivo","est_plan","id_plan","idsolicitud"];
                var cuerpocambioplan=document.getElementById('cuerpocambioplan'),fila,id_plan,nodo,estado,act,columna,div,tj,tipoprog;
                var isolicitud = 0 ;

                for(var i = 0; i < reg.length;i++){
                    fila=cuerpocambioplan.insertRow(0);                    
                    isolicitud = reg[i].getElementsByTagName(elementos[6])[0].firstChild.nodeValue;
                    for(var j = 1; j <= 5; j++){
                        nodo=reg[i].getElementsByTagName(elementos[j-1])[0].firstChild.nodeValue;

                        columna=fila.insertCell(j-1);
                        div=document.createElement("div");
                        if( j > 1 ){
                            div.setAttribute("align", "center");
                        }else{
                            div.setAttribute("align", "left");
                        }
                        if (j == 5){
                           estado=reg[i].getElementsByTagName(elementos[j-1])[0].firstChild.nodeValue;
                           id_plan=reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                           if(estado == "cargado   "){
                                  act="";
                             }
                             else{
                                 act="disabled";
                             }
                           columna.innerHTML="<input class='inputcorto'type= 'submit' value='Eliminar' name='EliminarcambioMat' onclick= 'EliminarcambioMat("+ id_plan +","+ isolicitud +");'"+ act + "/>";
                        }
                        else{
                            columna.innerHTML="<a>"+ nodo +"</a>";                            
                        }
                        
                    //}
                    }
                }
                //document.getElementById('buscar').style.visibility='visible'
            }
        }

}
function EliminarMat(id_plan, idsol)
{
    var url = 'EliminarMatMov?' +'id_plan='+id_plan;
    conectarMethod(url, muestranada, 'POST');
    ListaPlan(idsol);
}
function registrarcambiomat(plan){
    
    if(!isTextoObligatorio(['nuevamat','nuevoperiodo','motivocambio'], ['Materia propuesta','Periodo de la nueva Materia','Motivo del Cambio']))
               {
                   return false;
               }
               else{
    var url = 'registrarcaMat?plan='+ plan+"&"+getValores(['nuevamat','nuevoperiodo','motivocambio']);
     conectarMethod(url, muestraResultadoreload, 'POST');
               }
}
function EliminarcambioMat(id_plan, idsol)
{
    var url = 'EliminarcambioMatMov?' +'id_plan='+id_plan;
    conectarMethod(url, muestranada, 'POST');
    ListaCambioPlan(idsol);
}
/*function muestraElimCambioPlan() {
    var url;
    if(http_request.readyState == 4) {
        if(http_request.status == 200) {
            ListaCambioPlan(idsol);
                  
        }
    }
}*/

 