function consultaraplicantes ()
{   
    setVisibilidad(['consultamov=inline','botonconsultamov=inline','botonaprobardoc=none','tablaconsultamov=inline',
        'tablaaprobardoc=none','tablaclacificarUni=none','botonclacificarUni=none','cambiarcontratos=none','botonestEXT=none',
        'tablaconsultaestEXT=none','botonfinpro=none','tablafinproceso=none','datosRedEst=none','botondatosRedEst=none']);
}
function consultaraplicantesdec()
{

    setVisibilidad(['consultamov=inline','botonconsultamov=inline','tablaconsultamov=inline','botonaprobarsol=none','tablaaprobarsol=none','botonLisEstPlan=none','tablaaprobarplan=none','botonestEXT=none','tablaconsultaestEXT=none','botonLiscambioPlan=none','tablaaprobarcambioplan=none']);

}
function consultaraplicantesVice()
{

    setVisibilidad(['consultamov=inline','botonconsultamov=inline','tablaconsultaVice=inline','botonestEXT=none','tablaconsultaestEXT=none']);

}
function cambiarcontraseña ()
{
    setVisibilidad(['consultamov=none','tablamov=none','contraseña=inline','reportes=none','tablaclacificarUni=inline']);
}
function vercambiarcontratos()
{
    setVisibilidad(['consultamov=none','botonconsultamov=none','botonaprobardoc=none','tablaconsultamov=none',
        'tablaaprobardoc=none','tablaclacificarUni=none','botonclacificarUni=none','cambiarcontratos=inline','botonestEXT=none',
        'tablaconsultaestEXT=none','botonfinpro=none','tablafinproceso=none','datosRedEst=none','botondatosRedEst=none']);
}
function veraprobarsol ()
{
      setVisibilidad(['consultamov=inline','botonconsultamov=none','tablaconsultamov=none','botonaprobarsol=inline','tablaaprobarsol=inline','botonLisEstPlan=none','tablaaprobarplan=none','botonestEXT=none','tablaconsultaestEXT=none','botonLiscambioPlan=none','tablaaprobarcambioplan=none']);
     
}
function veraprobardoc ()
{
       setVisibilidad(['consultamov=inline','botonconsultamov=none','botonaprobardoc=inline','tablaconsultamov=none',
           'tablaaprobardoc=inline','tablaclacificarUni=none','botonclacificarUni=none','cambiarcontratos=none','botonestEXT=none',
           'tablaconsultaestEXT=none','botonfinpro=none','tablafinproceso=none','datosRedEst=none','botondatosRedEst=none']);
}
function vertablaclacificarUni ()
{
       setVisibilidad(['consultamov=inline','botonconsultamov=none','botonaprobardoc=none','tablaconsultamov=none',
           'tablaaprobardoc=none','tablaclacificarUni=inline','botonclacificarUni=inline','cambiarcontratos=none','botonestEXT=none',
           'tablaconsultaestEXT=none','botonfinpro=none','tablafinproceso=none','datosRedEst=none','botondatosRedEst=none']);
}
function veraprobarplan(){
     setVisibilidad(['consultamov=inline','botonconsultamov=none','tablaconsultamov=none','botonaprobarsol=none','tablaaprobarsol=none','botonLisEstPlan=inline','tablaaprobarplan=inline','botonestEXT=none','tablaconsultaestEXT=none','botonLiscambioPlan=none','tablaaprobarcambioplan=none']);
}
function veraprobarcambioplan(){
    setVisibilidad(['consultamov=inline','botonconsultamov=none','tablaconsultamov=none','botonaprobarsol=none','tablaaprobarsol=none','botonLisEstPlan=none','tablaaprobarplan=none','botonestEXT=none','tablaconsultaestEXT=none','botonLiscambioPlan=inline','tablaaprobarcambioplan=inline']);
}
function verconsultarestmov(){
setVisibilidad(['consultamov=inline','datosRedEst=none','botonconsultamov=none','botonaprobardoc=none','botondatosRedEst=none','tablaconsultamov=none','tablaaprobardoc=none','tablaclacificarUni=none','botonclacificarUni=none','cambiarcontratos=none','botonestEXT=inline','tablaconsultaestEXT=inline','botonfinpro=none','tablafinproceso=none']);
}
function verfinalizarprocesos(){
    setVisibilidad(['consultamov=inline','botonconsultamov=none','botonaprobardoc=none','tablaconsultamov=none',
        'tablaaprobardoc=none','tablaclacificarUni=none','botonclacificarUni=none','cambiarcontratos=none','botonestEXT=none',
        'tablaconsultaestEXT=none','botonfinpro=inline','tablafinproceso=inline','datosRedEst=none','botondatosRedEst=none']);
}
function verconsultarestmovDEC(){
     setVisibilidad(['consultamov=inline','botonconsultamov=none','tablaconsultamov=none','botonaprobarsol=none','tablaaprobarsol=none','botonLisEstPlan=none','tablaaprobarplan=none','botonestEXT=inline','tablaconsultaestEXT=inline','botonLiscambioPlan=none','tablaaprobarcambioplan=none']);
}
function verconsultarestmovVICE(){
     setVisibilidad(['consultamov=inline','botonconsultamov=none','tablaconsultaVice=none','botonestEXT=inline','tablaconsultaestEXT=inline']);
}
function vercasoespecial(){
    setVisibilidad(['consultamov=none','botonconsultamov=none','botonaprobardoc=none','tablaconsultamov=none',
        'tablaaprobardoc=none','tablaclacificarUni=none','botonclacificarUni=none','cambiarcontratos=none','botonestEXT=none',
        'tablaconsultaestEXT=none','botonfinpro=none','tablafinproceso=none','datosRedEst=inline','botondatosRedEst=inline']);
}
function DejarPendiente(){
   window.close();
}
function actualizartabbienestar(usr){
        var ProgramaAcademic = "0";
        var ProgramaMov ="0";
        var tabla=document.getElementById('tablaplicantesbienestar');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }
        var url = 'lisAplicantesVice?'+"iddpto=" + ProgramaAcademic + "&progmov=" + ProgramaMov+"&usr="+usr;
        conectarX(url,muestraApliBienestar);
}
function muestraApliBienestar()
{

        if(http_request.readyState == 4) {
            if(http_request.status == 200) {

                var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("lisaplicantesmov")[0];
                var reg = lista.getElementsByTagName("aplicante");
                var elementos=["nombre","progmov","vobo_psico","vobo_medico","exm_psico","exm_medico","id_solicitud","estado"];
                var aplibienestar=document.getElementById('aplibienestar'),fila,texto,nodo,columna,div,fecha,act,nom;
                var isolicitud = 0 ;
                var usr=reg[0].getElementsByTagName("usr")[0].firstChild.nodeValue;
                for(var i = 0; i < reg.length;i++){

                    fila=aplibienestar.insertRow(0);
                    isolicitud = reg[i].getElementsByTagName(elementos[6])[0].firstChild.nodeValue;
                    fecha=reg[i].getElementsByTagName(elementos[5])[0].firstChild.nodeValue;
                  
                    for(var j = 0; j <= 3; j++){
                        if (j <= 3 ) {
                            nodo=reg[i].getElementsByTagName(elementos[j])[0].firstChild.nodeValue;
                        }
                        columna=fila.insertCell(j);
                        div=document.createElement("div");
                        if( j > 1 ){
                            div.setAttribute("align", "center");
                        }else{
                            div.setAttribute("align", "left");
                        }

                            if (j == 0)
                            {

                                texto=nodo;
                                columna.innerHTML=texto;
                           }
                            else
                            {
                                if(j==2)
                                 {
                                       if(reg[i].getElementsByTagName(elementos[2])[0].firstChild.nodeValue == "1" ){
                                                 act="disabled";
                                                 texto="Aprobado";
                                              }
                                              else{
                                                  if(reg[i].getElementsByTagName(elementos[2])[0].firstChild.nodeValue == "0"){
                                                       act="disabled";
                                                 texto="Rechazado";
                                                  }
                                                  else{
                                                       act="";
                                                       texto="Sin evaluar";
                                                  }
                                              }
                                      fecha=reg[i].getElementsByTagName(elementos[4])[0].firstChild.nodeValue;
                                     if(fecha=="null")
                                      {
                                         columna.innerHTML="<a href='entrevistasMov?idSolicitud="+isolicitud+"&nom=exm_psico' target=_blank'>Programar entrevista</a>";
                                      }
                                      else
                                          {
                                              nom =2;
                                              columna.innerHTML=fecha+"<input type= 'submit' value='Aceptar' name='Aceptarpsico' onclick= \"Aceptarpsico("+ nom +","+ isolicitud+",'"+usr+"');\""+ act + "/> <input type= 'submit' value='Rechazado' name='rechadoPsico' onclick= \"rechazarpsico("+ nom +","+ isolicitud+",'"+usr+"');\""+ act+ "/><br>"+texto;
                                          }
                                 }
                                 else
                                 {
                                     if(j==3)
                                     {
                                           if(reg[i].getElementsByTagName(elementos[3])[0].firstChild.nodeValue == "1" ){
                                                 act="disabled";
                                                 texto="Aprobado";
                                              }
                                              else{
                                                  if(reg[i].getElementsByTagName(elementos[3])[0].firstChild.nodeValue == "0"){
                                                       act="disabled";
                                                 texto="Rechazado";
                                                  }
                                                  else{
                                                       act="";
                                                       texto="Sin evaluar";
                                                  }
                                              }
                                         fecha=reg[i].getElementsByTagName(elementos[5])[0].firstChild.nodeValue;
                                         if(fecha=="null")
                                      {
                                          act=""
                                         columna.innerHTML="<a href='entrevistasMov?idSolicitud="+isolicitud+"&nom=exm_medico' target=_blank'>Programar entrevista</a>";
                                        
                                      }
                                      else
                                          {
                                               nom =3;

                                              columna.innerHTML=fecha+"<input type= 'submit' value='Aceptar' name='Aceptarpsico' onclick= \"Aceptarpsico("+ nom +","+ isolicitud+",'"+usr+"');\""+ act + "/> <input type= 'submit' value='Rechazado' name='rechadoPsico' onclick= \"rechazarpsico("+ nom +","+ isolicitud+",'"+usr+"');\""+ act+ "/><br>"+texto;
                                          }
                                     }
                                     else
                                     {
                                         texto=nodo;
                                         columna.innerHTML=texto;
                                     }
                                 }
                            }
                    }
               }
           }
       }
}
function Aceptarpsico(nom,idsol,usr){
   var url;
   if(nom==2){
       nom="vobo_psico";
   }
   if(nom==3){
       nom="vobo_medico"
   }
   var answer = confirm("Está seguro de querer aprobar esta Solicitud.");
    if (answer)
    {
         url = "VoBoCarta?clave=True&idsolicitud=" + idsol+"&nom="+nom+"&usr="+usr;
         conectarMethod(url, muestraResultadoEntre, 'POST');
         //url = 'ActualizarEstMov?'+"idsolicitud=" + idsol + "&clave=i";
         //conectarMethod(url, muestraResultado, 'POST');
         //actualizartabbienestar();
    }
}
function rechazarpsico(nom,idsol,usr){
   var url;
   if(nom==2){
       nom="vobo_psico";
   }
   if(nom==3){
       nom="vobo_medico"
   }
    var answer = confirm("Al rechazar, RECHAZARA la solicitud del estudiante por completo. ¿Está seguro de querer hacer esto? ");
    if (answer)
    {
         url = "VoBoCarta?clave=False&idsolicitud=" + idsol+"&nom="+nom+"&usr="+usr;
         conectarMethod(url, muestraRechazovice, 'POST');
         //url = 'ActualizarEstMov?'+"idsolicitud=" + idsol + "&clave=r";
         //conectarMethod(url, muestraResultado, 'POST');
         //actualizartabbienestar();
    }
}
function GuardarComentario(idsol,nc){
    url = 'GuardarComen?'+"idsol=" + idsol + "&nom="+nc+"&"+getValores(['comentariomov']);
     conectarMethod(url, function() {location.reload();}, 'POST');
}
function RegistrarEstEspMov(){
    url = 'GuardarRegEsp?'+getValores(['Carnetest','ProgramaMovilidadEsp']);
     conectarMethod(url, muestraResultado, 'POST');
}
 

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



