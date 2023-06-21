/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function vernuevaofertaprac()
{
    setVisibilidad(['FormOfertaPrac=inline','mensajeReg=none']);
}
function Registrarofertaprac(usr,cont){
    var formobj = document.fromprogramaspre;
    var FecLimApl = document.getElementById("fechaoutnop");
    var FecIniPrac = document.getElementById("fechainprac");
    var FecFinPrac = document.getElementById("fechaoutprac");
    //var FecIniPracAdmin = document.getElementById("fechainiadmin");
    //var FecFinPracAdmin = document.getElementById("fechafinadmin");
    
    FecLimApl.value = FecLimApl.value.replace(' ', '').trim();
    FecIniPrac.value = FecIniPrac.value.replace(' ', '').trim();
    FecFinPrac.value = FecFinPrac.value.replace(' ', '').trim();
    
    
    
    if(!isDiligenciado(['nomcargonop','descripcionnop','Requisitosnop','paisnop','ciudadnop','areanop','salarionop','fechaoutnop','fechainprac','fechaoutprac','horarionop',
        'contratonop','seguros_arp','nom_jefe','cargo_jefe','tel_jefe','email_jefe'],
        ['Nombre del Cargo','Descripción del cargo','Requisitos','Pais','Ciudad','Area de actividad','Apoyo Económico','Fecha de vencimiento','Fecha inicio de la práctica',
        'Fecha finalización de la práctica','Jornada Laboral','Tipo de Contrato','Sistema de seguro y riesgos profesionales','Reporta a (Nombre)','Reporta a (Cargo)',
        'Reporta a (Telefono)','Reporta a (Email)']))
        return false;

    if (!validaFechaCompleta(FecLimApl.value) || !validaFechaCompleta(FecIniPrac.value) || !validaFechaCompleta(FecFinPrac.value))
        return false;
    
    //if (!validaDespuesFecha(document.getElementById("fechainprac").value, '22-05-2016')) 
    if (!validaDespuesFechaIn(document.getElementById("fechainprac").value, document.getElementById("fechainiadmin").value)) 
        return false;
    
    if (!validaAntesFechaFin(document.getElementById("fechaoutprac").value, document.getElementById("fechafinadmin").value)) 
        return false;    
    
    var progList = getCheckboxprogramaspre();
    
    if (progList == false || progList == '&') {
        return false;
    }
    
    formobj.action='NuevaOfertaPrac?nit='+usr +'&cont='+cont + progList;
    return true;
}


function generarCartaDecEmp(idapli){

    var answer = confirm("Recuede que para formalizar la Práctica Profesional se deben diligenciar la totalidad de los campos de la Carta de Aceptación con información actualizada.");
    if(answer)
    {
        var url='CartaPracDec?ida='+idapli;
        window.location= url;

    }
}
function show(id,e) {
    var obj = document.getElementById(id);
      obj.style.display = 'block';
      obj.style.top = (parseInt(e.clientY) + 1) + 'px';
      obj.style.left = (parseInt(e.clientX) + 1) + 'px';
}

function hide(id) {
    document.getElementById(id).style.display = 'none';
}

function showCharCount(infoText, txt, limitLength) {
    if (txt.value.length > limitLength) txt.value = txt.value.substr(0,limitLength);
    document.getElementById(infoText).innerHTML = 'Quedan ' + (limitLength-txt.value.length) + ' caracteres';
}

function validaDespuesFecha(fecha, fechaLimite) {
    var sF = fecha.split('/');
    var sFL = fechaLimite.split('/');
    
    var dF = new Date();
    var dFL = new Date();
    
    dF.setFullYear(sF[2], sF[1]-1, sF[0]);
    dFL.setFullYear(sFL[2], sFL[1]-1, sFL[0]);
    
    if (dF < dFL) {
        alert('La fecha de inicio de prÃ¡cticas profesionales para Ã©ste semestre debe ser mÃ­nimo desde el ' + fechaLimite);
        return false;
    }
    
    return true;
}

function validaDespuesFechaIn(fecha, fechaLimite) {
    fechaLimite = fechaLimite.split("-").reverse().join("/");
    
    var sF = fecha.split('/');
    var sFL = fechaLimite.split('/');
    
    var dF = new Date(sF[2], sF[1] - 1, sF[0]);
    var dFL = new Date(sFL[2], sFL[1] - 1, sFL[0]);
    
   // dF.setFullYear(sF[2], sF[1], sF[0]);
   // dFL.setFullYear(sFL[2], sFL[1], sFL[0]);
    
   // alert("fec ini: "+fecha+" feclim: "+fechaLimite);
   // alert("fec ini: "+dF+" feclim: "+dFL);
    
    if (dF < dFL) {
        alert('La fecha minima de inicio de práctica profesional para el periodo académico actual es:  ' + fechaLimite);
        return false;
    }
    
    return true;
}

function validaAntesFechaFin(fecha, fechaLimite) {
    fechaLimite = fechaLimite.split("-").reverse().join("/");
    
    var sF = fecha.split('/');
    var sFL = fechaLimite.split('/');
    
    var dF = new Date(sF[2], sF[1] - 1, sF[0]);
    var dFL = new Date(sFL[2], sFL[1] - 1, sFL[0]);
    
   // dF.setFullYear(sF[2], sF[1], sF[0]);
   // dFL.setFullYear(sFL[2], sFL[1], sFL[0]);
    
   // alert("fec ini: "+fecha+" feclim: "+fechaLimite);
   // alert("fec ini: "+dF+" feclim: "+dFL);
    
    if (dF > dFL) {
        alert(' La fecha máxima de finalización de práctica profesional para el periodo académico actual es: ' + fechaLimite);
        return false;
    }
    
    return true;
}