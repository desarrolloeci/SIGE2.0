/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function consultarApVice()
{
        var ProgramaAcademic = document.getElementById("ProgramaAcademico").value;
        var ProgramaMov = document.getElementById("ProgramaMovilidad").value;        
        var tabla=document.getElementById('tablaplicantesVice');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }        
        var url = 'lisAplicantesVice?'+"iddpto=" + ProgramaAcademic + "&progmov=" + ProgramaMov;
        conectarX(url,muestraApliMovVice);

}
function muestraApliMovVice()
{
        
        if(http_request.readyState == 4) {
            if(http_request.status == 200) {

                var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("lisaplicantesmov")[0];
                var reg = lista.getElementsByTagName("aplicante");
                var elementos=["nombre","progmov","estado","vobo_vice","id_solicitud","entre_vice"];
                var ApliMovVice=document.getElementById('ApliMovVice'),fila,texto,nodo,vobo,columna,div,fecha;
                var isolicitud = 0 ;
                for(var i = 0; i < reg.length;i++){

                    fila=ApliMovVice.insertRow(0);
                    isolicitud = reg[i].getElementsByTagName(elementos[4])[0].firstChild.nodeValue;
                    fecha=reg[i].getElementsByTagName(elementos[5])[0].firstChild.nodeValue;
                    vobo= reg[i].getElementsByTagName(elementos[3])[0].firstChild.nodeValue;
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
                                if(vobo=="null")
                                    {
                                         columna.innerHTML="<a href='solicitudVice?i="+isolicitud+"' target=_blank'>"+texto+"</a>";
                                    }
                                    else
                                        {
                                            columna.innerHTML="<a href='contratoMov?i="+isolicitud+"' target=_blank'>"+texto+"</a>";
                                        }
                            }
                            else
                            {
                                if(j==2)
                                 {
                                     if(fecha=="null")
                                      {
                                         columna.innerHTML="<a href='entrevistasMov?idSolicitud="+isolicitud+"&nom=entre_vice' target=_blank'>Programar entrevista</a>";
                                      }
                                      else
                                          {
                                              columna.innerHTML=fecha;
                                          }
                                 }
                                 else
                                 {
                                     if(j==3)
                                     {
                                           
                                           if(vobo=="null")
                                           {
                                               texto="Sin tramitar";
                                           }
                                           if(vobo=="1")
                                           {
                                               texto="Aprobado";
                                           }
                                           if(vobo=="0")
                                           {
                                               texto="Rechazado";
                                           }
                                           columna.innerHTML= texto;
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
function cargarfecha(id_sol,nom,usr)
{
    var fecha = document.getElementById("fechaEn").value;
        var hora = document.getElementById("hora").value;        
        var minutos=document.getElementById('min').value;
        var url = 'VoBoCarta?clave='+fecha+" "+hora+":"+minutos+":00"+"&idsolicitud=" + id_sol+"&nom="+nom+"&usr="+usr;
        conectarMethod(url, muestraResultadoFecha, 'POST');
        //window.close();
}