/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function consultarCartas()
{
        //Limpiar Tabla
         //document.getElementById('buscar').style.visibility='hidden';
        var ProgramaAcademic = document.getElementById("ProgramaAcademico").value;
        var ProgramaMov = document.getElementById("ProgramaMovilidad").value;
        //var ProgramaAcademic= ProgramaAcademico.value;
        var tabla=document.getElementById('tablasolicitudes');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }

        //Realizar Peticion
         //alert('esto es bueno');
        //setVisibilidad(['RequerimientosConMov=inline']);
        var url = 'lisSol?'+"iddpto=" + ProgramaAcademic + "&progmov=" + ProgramaMov;
        conectarX(url,muestraliscar);
        //return false;
}
function muestraliscar() {
        //alert('esto es bueno');
        if(http_request.readyState == 4) {
            if(http_request.status == 200) {

                var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("lisaplicantesmov")[0];
                var reg = lista.getElementsByTagName("aplicante");
                var elementos=["idsolicitud","nombre","progmov"];
                var cuerpo2=document.getElementById('cuerpo2'),fila,texto,nodo,url,link,columna,div;
                var isolicitud = 0 ;
                for(var i = 0; i < reg.length;i++){

                    fila=cuerpo2.insertRow(0);
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
                            link.setAttribute("href", "solicitud?idSolicitud="+isolicitud);
                            link.setAttribute("target", "_blank");
                            texto=document.createTextNode(nodo);
                            link.appendChild(texto);
                            div.appendChild(link);
                            columna.appendChild(div);
                        }/*else if (j == 2){
                            link=document.createElement("a");
                            link.setAttribute("href", "Proyectos?idPlan="+iaplicante);
                            texto=document.createTextNode("Proyectos");
                            link.appendChild(texto);
                            div.appendChild(link);
                            columna.appendChild(div);
                        }*/else {
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
function muestraEstPlan() {
        //alert('esto es bueno');
        if(http_request.readyState == 4) {
            if(http_request.status == 200) {

                var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("lisaplicantesmov")[0];
                var reg = lista.getElementsByTagName("aplicante");
                var elementos=["idsolicitud","nombre","progmov"];
                var cuerpoEstPlan=document.getElementById('cuerpoEstPlan'),fila,texto,nodo,url,link,columna,div;
                var isolicitud = 0 ;
                for(var i = 0; i < reg.length;i++){

                    fila=cuerpoEstPlan.insertRow(0);
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
                            link.setAttribute("href", "SolPlandeEstudio?idSolicitud="+isolicitud);
                            link.setAttribute("target", "_blank");
                            texto=document.createTextNode(nodo);
                            link.appendChild(texto);
                            div.appendChild(link);
                            columna.appendChild(div);
                        }/*else if (j == 2){
                            link=document.createElement("a");
                            link.setAttribute("href", "Proyectos?idPlan="+iaplicante);
                            texto=document.createTextNode("Proyectos");
                            link.appendChild(texto);
                            div.appendChild(link);
                            columna.appendChild(div);
                        }*/else {
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
function muestracambioEstPlan() {
        //alert('esto es bueno');
        if(http_request.readyState == 4) {
            if(http_request.status == 200) {

                var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("lisaplicantesmov")[0];
                var reg = lista.getElementsByTagName("aplicante");
                var elementos=["idsolicitud","nombre","progmov"];
                var cuerpocambioEstPlan=document.getElementById('cuerpocambioEstPlan'),fila,texto,nodo,url,link,columna,div;
                var isolicitud = 0 ;
                for(var i = 0; i < reg.length;i++){

                    fila=cuerpocambioEstPlan.insertRow(0);
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
                            link.setAttribute("href", "SolCambioPlanEst?idSolicitud="+isolicitud);
                            link.setAttribute("target", "_blank");
                            texto=document.createTextNode(nodo);
                            link.appendChild(texto);
                            div.appendChild(link);
                            columna.appendChild(div);
                        }/*else if (j == 2){
                            link=document.createElement("a");
                            link.setAttribute("href", "Proyectos?idPlan="+iaplicante);
                            texto=document.createTextNode("Proyectos");
                            link.appendChild(texto);
                            div.appendChild(link);
                            columna.appendChild(div);
                        }*/else {
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
function AceptarSolicitud(idsolicitud,usuario){
    /*var answer = confirm("Esta seguro de querer eliminar este registro")

    if (answer)
    {
        window.location = "eliminar3.php?idp=" + idp;
    }*/
    document.getElementById('botonSol').style.visibility='hidden';
    document.getElementById('msgBotonSol').style.visibility='visible';
    document.getElementById('msgBotonSol').innerHTML = 'Realizando operación. Por favor espere...';
    
    var answer = confirm("¿Está seguro que desea aprobar ésta solicitud?");
    if (answer)
    {
        var url = 'VoBoCarta?'+"idsolicitud=" + idsolicitud + "&clave=True"+"&nom=vobo_cartaeci&usr="+usuario;
        conectarMethod(url, muestraAprSolDec, 'POST');
        /*var url2='ActualizarEstMov?'+"idsolicitud=" + idsolicitud + "&clave=b";
        conectarMethod(url2, muestraResultadoreload, 'POST');*/
        
    } else {
        document.getElementById('botonSol').style.visibility='visible';
        document.getElementById('msgBotonSol').style.visibility='hidden';
        document.getElementById('msgBotonSol').innerHTML = '';
    }
}
function AceptarPlan(idsolicitud,usuario)
{
    var answer = confirm("Está seguro de querer aprobar este plan de estudio.");
    if (answer)
    {
         var url = 'VoBoCarta?'+"idsolicitud=" + idsolicitud + "&clave=True"+"&nom=vobo_plan&usr="+usuario;
         conectarMethod(url, enviaCreacontrato, 'POST');
        // var url2='CrearContrato?'+"idsolicitud=" + idsolicitud ;
         //conectarMethod(url2, muestranada, 'POST');
         //var url3='ActualizarEstMov?'+"idsolicitud=" + idsolicitud + "&clave=h";
         //conectarMethod(url3, muestraResultado, 'POST');
         //window.location='contratoMov?i='+idsolicitud
    }
}
function AceptarcambioPlan(idsolicitud,usr)
{
     var answer = confirm("Al aprobar este cambio se modificara el contrato registrado en el sistema. ¿está seguro de querer aprobar el cambio?");
    if (answer)
    {
     var url2='AceptarcambioPlan?'+"idsolicitud=" + idsolicitud + "&usr="+usr;
     conectarMethod(url2, muestraResultadoCambiPlan, 'POST');
     //var url3='ActualizarEstMov?'+"idsolicitud=" + idsolicitud + "&clave=i";
     //conectarMethod(url3, muestraResultado, 'POST');
     
    }
}
function RechazarcambioPlan(idsolicitud,usr){
    var answer = confirm("Está seguro de querer rechazar el cambio  en el plan de estudio.");
    if (answer)
    {
            var url='RechazarcambioPlan?'+"idsolicitud=" + idsolicitud+"&usr="+usr;
            conectarMethod(url, muestraResultadoCambiPlan, 'POST');
           // var url3='ActualizarEstMov?'+"idsolicitud=" + idsolicitud + "&clave=i";
            //conectarMethod(url3, muestraResultado, 'POST');
            //window.location='contratoMov?i='+idsolicitud
    }
}
function DevolverPlan(idsolicitud,usr){
    var answer = confirm("Está seguro de querer devolver el  plan de estudio. el estudiante podra editarlo y volver a enviar uno nuevo");
    if (answer)
    {
            var url='Devolverplan?'+"idsol=" + idsolicitud +"&usr="+usr ;
            conectarMethod(url, muestraResultadoreload, 'POST');


    }
}
function AceptarSolicitudVice(idsolicitud,usr){
    document.getElementById('botonSol').style.visibility='hidden';
    document.getElementById('msgBotonSol').style.visibility='visible';
    document.getElementById('msgBotonSol').innerHTML = 'Realizando operación. Por favor espere...';
    
    var answer = confirm("¿Está seguro de que desea aprobar esta solicitud?");
    if (answer) {
        var url = 'VoBoCarta?'+"idsolicitud=" + idsolicitud + "&clave=True"+"&nom=vobo_vice"+"&usr="+usr;
        conectarMethod(url, muestraResultadoEntre, 'POST');
    } else {
        document.getElementById('botonSol').style.visibility='visible';
        document.getElementById('msgBotonSol').style.visibility='hidden';
        document.getElementById('msgBotonSol').innerHTML = '';
    }
}
function RechazarSolicitud(idsolicitud,usuario){
    document.getElementById('botonSol').style.visibility='hidden';
    document.getElementById('msgBotonSol').style.visibility='visible';
    document.getElementById('msgBotonSol').innerHTML = 'Realizando operación. Por favor espere...';
    
    var answer = confirm("¿Está que desea rechazar la solicitud del estudiante? ");
    if (answer) {
        var url = 'VoBoCarta?'+"idsolicitud=" + idsolicitud + "&clave=False"+"&nom=vobo_cartaeci&usr="+usuario;
        conectarMethod(url, muestraRechazovice, 'POST');
    } else {
        document.getElementById('botonSol').style.visibility='visible';
        document.getElementById('msgBotonSol').style.visibility='hidden';
        document.getElementById('msgBotonSol').innerHTML = '';
    }
}
function RechazarSolicitudVice(idsolicitud,usr) {
    document.getElementById('botonSol').style.visibility='hidden';
    document.getElementById('msgBotonSol').style.visibility='visible';
    document.getElementById('msgBotonSol').innerHTML = 'Realizando operación. Por favor espere...';
    
    var answer = confirm("¿Está seguro de que desea rechazar ésta solicitud?");
    if (answer) {
        var url = 'VoBoCarta?'+"idsolicitud=" + idsolicitud + "&clave=False"+"&nom=vobo_vice&usr="+usr;
        conectarMethod(url, muestraRechazovice, 'POST');
    } else {
        document.getElementById('botonSol').style.visibility='visible';
        document.getElementById('msgBotonSol').style.visibility='hidden';
        document.getElementById('msgBotonSol').innerHTML = '';
    }
}
function consultarEstPlan(){
    var ProgramaAcademic = document.getElementById("ProgramaAcademico").value;
        var ProgramaMov = document.getElementById("ProgramaMovilidad").value;
        //var ProgramaAcademic= ProgramaAcademico.value;
        var tabla=document.getElementById('tablaLisEstPlan');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }

        //Realizar Peticion
         //alert('esto es bueno');

        var url = 'LisEstPlan?'+"iddpto=" + ProgramaAcademic + "&progmov=" + ProgramaMov;
        conectarX(url,muestraEstPlan);

}
function consultarcambioPlan(){
    var ProgramaAcademic = document.getElementById("ProgramaAcademico").value;
        var ProgramaMov = document.getElementById("ProgramaMovilidad").value;
        //var ProgramaAcademic= ProgramaAcademico.value;
        var tabla=document.getElementById('tablaLisEstcambioPlan');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }

        //Realizar Peticion
         //alert('esto es bueno');

        var url = 'LisEstcambioPlan?'+"iddpto=" + ProgramaAcademic + "&progmov=" + ProgramaMov;
        conectarX(url,muestracambioEstPlan);
}
function ListaPlanDec(idsol)
{
        var tabla=document.getElementById('tablaPlanest');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }
        var url2 = 'lisPlanMov?' +'idsol='+idsol;
        conectarMethod(url2, muestraPlanDec, 'POST');
        //conectarX(url2,muestraPlan);
}
function ListaCambioPlanDec(id_sol)
{
        var tabla=document.getElementById('tablaCambioPlan');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
         tabla.deleteRow(1);        }
        var url2 = 'liscambioPlanMov?' +'idsol='+id_sol;
       conectarMethod(url2, muestraCambioPlanDec, 'POST');
}
function muestraPlanDec()
{
    if(http_request.readyState == 4) {
            if(http_request.status == 200) {

                var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("lismaterias")[0];
                var reg = lista.getElementsByTagName("materia");
                var elementos=["semestre","materia_ud","materia_eci","est_plan","id_plan","idsolicitud","prog_mov"];
                var cuerpoplanpi=document.getElementById('cuerpoplanpi'),fila,id_plan,nodo,estado,act,columna,div,tj;
                var isolicitud = 0 ;
                var tipoprog=0;                
                
                for(var i = 0; i < reg.length;i++){

                    fila=cuerpoplanpi.insertRow(0);
                    tipoprog= reg[i].getElementsByTagName(elementos[6])[0].firstChild.nodeValue;
                    isolicitud = reg[i].getElementsByTagName(elementos[5])[0].firstChild.nodeValue;
                    if(tipoprog=="DOBLE TITULACION")
                    {
                        tj=2;
                    }
                    else{
                        tj=3;
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
                            columna.innerHTML="<a>"+ tildesPlan(nodo) +"</a>";
                        }
                        if (j == 2){
                            columna.innerHTML="<a>"+ tildesPlan(nodo) +"</a>";
                        }
                        if (j == 3){
                            columna.innerHTML="<a>"+ tildesPlan(nodo) +"</a>";
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
                             columna.innerHTML="<input type= 'submit' value='Eliminar' name='EliminarMat' onclick= 'EliminarMat("+ id_plan +","+ isolicitud +");'"+ act + "/>";
                        }
                    //}
                    }
                }
                //document.getElementById('buscar').style.visibility='visible'
            }
        }


}
 function tildesPlan(dato) {
           var result=dato;
           result=result.replace("Ã¡","á");
           result=result.replace("Ã©","é");
           result=result.replace("Ã­","í");
           result=result.replace("Ã³","ó");
           result=result.replace("Ãº","ú");             
           result=result.replace("Ã±","ñ"); 
           return result;
    }

function muestraCambioPlanDec()
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
                    for(var j = 1; j <= 4; j++){
                        nodo=reg[i].getElementsByTagName(elementos[j-1])[0].firstChild.nodeValue;

                        columna=fila.insertCell(j-1);
                        div=document.createElement("div");
                        if( j > 1 ){
                            div.setAttribute("align", "center");
                        }else{
                            div.setAttribute("align", "left");
                        }

                            columna.innerHTML="<a>"+ nodo +"</a>";


                    //}
                    }
                }
              ListaPlanDec(isolicitud);   //document.getElementById('buscar').style.visibility='visible'
            }
        }

}
 