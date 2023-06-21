/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var popemp;
var mensajeemp;
function vercambiarcontraseñaemp(){
     setVisibilidad(['cambiocontraseñaemp=inline','consultoferemp=none','botonconsultaoferemp=none','botonconsultaoferpracemp=none','tablaconsultaoferemp=none','tablaconsultaoferpracemp=none']);
}
function verconsultarofergrad(){
     setVisibilidad(['cambiocontraseñaemp=none','consultoferemp=inline','botonconsultaoferemp=inline','botonconsultaoferpracemp=none','tablaconsultaoferemp=inline','tablaconsultaoferpracemp=none']);
}

function verconsultaroferprac(){
     setVisibilidad(['cambiocontraseñaemp=none','consultoferemp=none','botonconsultaoferemp=none','botonconsultaoferpracemp=inline','tablaconsultaoferemp=none','tablaconsultaoferpracemp=inline']);
}
function actuaizardatosemp(){
    var url='ActDatEmpresa';
    var paramRequest = getValores(['nit','rasocial','paisemp','ciudademp','diremp','webemp','emailemp','telemp','nomconte',
        'cargoconte','areaconte','porfconte','telconte','faxconte','emailconte','celconte','nomrrhh','telrrhh','emailrrhh','tipoid']);
    conectarSendParam(url, muestraantGeneral, 'POST', paramRequest);
    //conectarMethod(url, muestraantGeneral, 'POST');
}
function abrirRegistaraemp(){
    if (http_request.readyState == 4) {
        if (http_request.status == 200) {
            var xmldoc = http_request.responseXML;
            var root_node = xmldoc.getElementsByTagName('root').item(0);
            if(root_node.firstChild.data != "OK"){
                alert(root_node.firstChild.data);
            } else {
               window.location = "RegistrarEmp2";
            }
        }
    }
}
function actualizarTabContEmp(nit)
{
        //Limpiar Tabla
         //document.getElementById('buscar').style.visibility='hidden';
        //var ProgramaAcademic= ProgramaAcademico.value;
        var tabla=document.getElementById('tablacontactosEmp');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }
        //Realizar Peticion
        //setVisibilidad(['RequerimientosConMov=inline']);
        var url = 'lisContEmp'+"?nit=" + nit;
        conectarX(url,muestraContemp);
        //return false;
}
function cambiarcontraseñaemp(usr) {
    if(document.getElementById("pswnuevo").value != document.getElementById("pswnuevo2").value) {
        alert("Nueva contraseña y confirme nueva contraseña deben ser iguales");
        return;
    }
    
    var url = 'CambiarPassEmp'
    var paramRequest = 'idemp=' + usr + "&pswantiguo=" + encodeURIComponent(document.getElementById("pswantiguo").value) + "&pswnuevo=" +
        encodeURIComponent(document.getElementById("pswnuevo").value);
    conectarSendParam(url, muestraResultadoreload, 'POST', paramRequest);
}

function ConsultarOferemp(usr,tipo)
{
        //Limpiar Tabla
         //document.getElementById('buscar').style.visibility='hidden';

        //var ProgramaAcademic= ProgramaAcademico.value;
        var tabla=document.getElementById('tablaoferemp');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }
        //Realizar Peticion
         //alert('esto es bueno');
        //setVisibilidad(['RequerimientosConMov=inline']);
        var url = 'lisOferEmp?idemp='+usr+'&tipoconsultoferemp='+tipo;
        conectarX(url,muestraOferemp);
        //return false;
}
function ConsultarOferempCont(usr,nit,tipo)
{
        //Limpiar Tabla
         //document.getElementById('buscar').style.visibility='hidden';

        //var ProgramaAcademic= ProgramaAcademico.value;
        var tabla=document.getElementById('tablaoferemp');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }
        //Realizar Peticion
         //alert('esto es bueno');
        //setVisibilidad(['RequerimientosConMov=inline']);
        var url = 'lisOferEmpCont?idemp='+usr+'&nit='+nit+'&tipoconsultoferemp='+tipo;
        conectarX(url,muestraOferemp);
        //return false;
}
function ConsultarOferpracempCont(usr,nit,tipo)
{
        //Limpiar Tabla
         //document.getElementById('buscar').style.visibility='hidden';

        //var ProgramaAcademic= ProgramaAcademico.value;
        var tabla=document.getElementById('tablaoferpracemp');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }
        //Realizar Peticion
         //alert('esto es bueno');
        //setVisibilidad(['RequerimientosConMov=inline']);
        var url = 'lisOferPracEmpCont?idemp='+usr+'&nit='+nit+'&tipoconsultoferemp='+tipo;
        conectarX(url,muestraOferPracEmp);
        //return false;
}
function ConsultarOferpracemp(usr,tipo)
{
        //Limpiar Tabla
         //document.getElementById('buscar').style.visibility='hidden';

        //var ProgramaAcademic= ProgramaAcademico.value;
        var tabla=document.getElementById('tablaoferpracemp');
        var filas=tabla.rows;
        var tam=filas.length;
        for(var i = 1; i < tam; i++){
            tabla.deleteRow(1);
        }
        //Realizar Peticion
         //alert('esto es bueno');
        //setVisibilidad(['RequerimientosConMov=inline']);
        var url = 'lisOferPracEmp?idemp='+usr+"&tipoconsultoferemp="+tipo;
        conectarX(url,muestraOferPracEmp);
        //return false;
}

function EliminarRegemp(idcont,nit,nt)
{
    var url = 'EliminarRegEmp?' +'idcont='+idcont+'&nt='+nt;
    conectarMethod(url, function EliminarAct() {
        if (http_request.readyState != 4) return;
        if (http_request.status != 200) return;
        if (nt==1) actualizarTabContEmp(nit);
    }, 'POST');
     
}
function muestraContemp() {
        if(http_request.readyState == 4) {
            if(http_request.status == 200) {

                var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("listacontactos")[0];
                var reg = lista.getElementsByTagName("contacto");
                var elementos=[ "id_contacto","nom_contacto", "cargo_contacto","nit"];
                var cuerpoContactosEgre=document.getElementById('cuerpoContactosEgre'),fila,texto,nodo,nt,link,columna,div;
                var id = 0 ;
                var nit=0;
                for(var i = 0; i < reg.length;i++){

                    fila=cuerpoContactosEgre.insertRow(0);
                    id = reg[i].getElementsByTagName(elementos[0])[0].firstChild.nodeValue;
                    nit= reg[i].getElementsByTagName(elementos[3])[0].firstChild.nodeValue;
                    for(var j = 0; j <= 2; j++){
                        if (j < 2 ) {
                            nodo=reg[i].getElementsByTagName(elementos[j+1])[0].firstChild.nodeValue;
                        }

                        columna=fila.insertCell(j);
                        div=document.createElement("div");
                        if( j > 1 ){
                            div.setAttribute("align", "center");
                        }else{
                            div.setAttribute("align", "left");
                        }
                        if(j<2){
                          columna.innerHTML=nodo;
                        }
                        else{
                            nt="1";
                            columna.innerHTML='<input class="inputcorto" type="submit" value="Eliminar" name="unico" onclick="EliminarRegemp(\'' + id + '\',\'' + nit + '\',\'' + nt + '\');"/>';
                        }
                }

            }
        }
    }
}

function muestraOferemp() {
        //alert('esto es bueno');
        if(http_request.readyState == 4) {
            if(http_request.status == 200) {

                var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("listaofertas")[0];
                var reg = lista.getElementsByTagName("oferta");
                var elementos=[ "cargo", "fecha_limite","id_oferta"];
                var cuerpotablaoferemp=document.getElementById('cuerpotablaoferemp'),fila,texto,nodo,url,link,columna,div;
                var id = 0 ;
                for(var i = 0; i < reg.length;i++){

                    fila=cuerpotablaoferemp.insertRow(0);
                    id = reg[i].getElementsByTagName(elementos[2])[0].firstChild.nodeValue;
                    for(var j = 0; j < 3; j++){
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
                            link.setAttribute("href", "VerOfertaEmpGrad?idofer="+id);
                            link.setAttribute("target", "_blank");
                            texto=document.createTextNode(nodo);
                            link.appendChild(texto);
                            div.appendChild(link);
                            columna.appendChild(div);
                        }
                        else {
                        if (j == 2){
                            columna.innerHTML=" <a target='_blank' href='VerAplicantesOferGrad?idofer="+id+"'onclick='window.open(this.href,'ventana_','toolbar=no,scrollbars=yes,location=yes,directories=yes,status=no,menubar=no,resizable=yes'); return false;'>Ver Postulantes</a>";
                        }                        
                        else{
                            texto=document.createTextNode(nodo);
                            div.appendChild(texto);
                            columna.appendChild(div);
                        }
                    }
                }
               
            }
        }
    }
}
function muestraOferPracEmp() {
        //alert('esto es bueno');
        if(http_request.readyState == 4) {
            if(http_request.status == 200) {

                var xmldoc = http_request.responseXML;
                var lista = xmldoc.getElementsByTagName("listaofertas")[0];
                var reg = lista.getElementsByTagName("oferta");
                var elementos=[ "cargo", "fecha_limite","id_oferta"];
                var cuerpotablaoferpracemp=document.getElementById('cuerpotablaoferpracemp'),fila,texto,nodo,url,link,columna,div;
                var id = 0 ;
                for(var i = 0; i < reg.length;i++){

                    fila=cuerpotablaoferpracemp.insertRow(0);
                    id = reg[i].getElementsByTagName(elementos[2])[0].firstChild.nodeValue;
                    for(var j = 0; j < 3; j++){
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
                            link.setAttribute("href", "VerOfertaEmpPrac?idofer="+id);
                            link.setAttribute("target", "_blank");
                            texto=document.createTextNode(nodo);
                            link.appendChild(texto);
                            div.appendChild(link);
                            columna.appendChild(div);
                        }
                        else {
                        if (j == 2){
                            columna.innerHTML=" <a target='_blank' href='VerAplicantesOferPrac?idofer="+id+"'onclick='window.open(this.href,'ventana_','toolbar=no,scrollbars=yes,location=yes,directories=yes,status=no,menubar=no,resizable=yes'); return false;'>Ver Postulantes</a>";
                        }
                        else{
                            texto=document.createTextNode(nodo);
                            div.appendChild(texto);
                            columna.appendChild(div);
                        }
                    }
                }
            }
        }
    }
}
function registrarcontactoEmp(){

    if(!isDiligenciado(['nit','rasocial','nomconte','cargoconte','areaconte','porfconte','telconte',
        'emailconte','celconte','doccont','doccont2','SistemaSolicitado'],['nit','Razón Social','Nombre del contacto','Cargo en la empresa','Área','Profesión','Teléfono',
        'Email','Celular','Documento del contacto','Confirme documento del contacto','SistemaSolicitado']))
        {
            return;
        }

    if(!isemail (['emailconte'],['Email']))
        {
            return;
        }

    if (document.getElementById("doccont").value != document.getElementById("doccont2").value) {
        alert("Los documentos no son iguales");
        return;
    }
    var url='RegistrarContEmp'
    var paramRequest = getValores(['nit','rasocial','nomconte','cargoconte','areaconte','porfconte','telconte',
                            'emailconte','celconte','doccont','doccont2','SistemaSolicitado']);
    conectarSendParam(url, muestraContemp, 'POST', paramRequest);
}
function registraremp(){
    if(!isDiligenciado(['nit','rasocial','paisemp','ciudademp','diremp','webemp','emailemp','telemp','nomconte','cargoconte','areaconte',
        'porfconte','telconte','faxconte','emailconte','celconte','passemp','passemp2','nomrrhh','telrrhh','emailrrhh'],
    ['nit','Razón Social','País de la empresa','Ciudad de la empresa','Dirección de la empresa','Pagina web','Email de la empresa',
    'Teléfono de la empresa','Nombre del contacto','Cargo en la empresa','Área','Profesión','Teléfono','Fax','Email','Celular','clave',
    'Confirme su clave','Nombre del jefe de Recursos Humanos','Teléfono RRHH','Email RRHH'])) {
        return;
    }
    
    if(!isemail (['emailemp','emailconte','emailrrhh'],['Ingrese Email de la Empresa','Ingrese Email del contacto','Ingrese Email RRHH'])) {
        return;
    }
    
    if(document.getElementById("passemp").value != document.getElementById("passemp2").value) {
        alert("Las claves no son iguales.");
        return;
    }
    
    var btn = document.getElementById('BtnRegEmp');
    btn.value = 'Registrando...';
    btn.disabled = 'true';
    var url='RegEmpresa?'+ getValores(['nit','rasocial','paisemp','ciudademp','diremp','webemp','emailemp',
        'telemp','nomconte','cargoconte','areaconte','porfconte','telconte','faxconte','emailconte','celconte',
        'nomrrhh','telrrhh','emailrrhh','tipoid'])+"&passemp="+ encodeURIComponent(document.getElementById("passemp").value)+"&passemp2="+ encodeURIComponent(document.getElementById("passemp2").value);
    conectarMethod(url, muestraregistraremp, 'POST');

 
}
function verificardatosemp() {
    var nit = document.getElementById("nit").value.replace(" ","");
    
    if (nit.indexOf('-') != -1) {
        alert("El ID ingresado tiene el guión (\"-\"). Por favor ingrese un ID sin el guión del dígito de verificación en caso de ser NIT.");
        return;
    }
    
    if (nit.indexOf('.') != -1) {
            alert("El ID ingresado tiene puntos. Por favor ingrese un ID sin puntos ");
            return;
    }
    
    if (/[^\d]/g.test(nit)) {
        alert("El ID ingresado no debe contener caracteres. Por favor ingrese un valor numérico.\n");
        return;
    }
    
    var url = 'Verificardatosemp?' + getValores(['nit']).replace(" ","");
    conectarMethod(url, abrirRegistaraemp, 'POST');
}
function bloqueoemp()
{
                popemp=(verifwp==null);
                mensajeemp=(popemp)?"Existe bloqueador":"No existe bloqueador";
}
function Actestadoapligrad(id_apli){
     var url='ActualizarEstApliGrad?id_apli=' + id_apli + '&' + getValores(['estadoapligrad']);
      conectarMethod(url, muestraResultadoreload, 'POST');
}

function ActestadoapliPrac(id_apli,id_est){
     var url='ActualizarEstApliPrac?id_est='+id_est+'&id_apli='+id_apli+"&"+getValores(['estadoapliprac']);
      conectarMethod(url, muestraResultadoreload, 'POST');
}

