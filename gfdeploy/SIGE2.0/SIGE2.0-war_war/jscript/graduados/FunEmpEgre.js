/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function vernuevaofertaegre()
{
    setVisibilidad(['FormOfertaGrad=inline','mensajeReg=none']);
}
function Registrarofertagrad(usr, cont) {
    var formobj = document.fromprogramas;
    var FecVenc = document.getElementById("fechaoutnog");
    
    FecVenc.value = FecVenc.value.replace(' ', '');
    
    
    if(!isDiligenciado(['nomcargonog','descripcionnog','Requisitosnog', 'paisnog','ciudadnog','areanog','salarionog','fechaoutnog','horarionog','contratonog','anosexpnog', 'vacnog','ciudadnog'],
    ['Nombre del Cargo','Descripción del cargo','Requisitos', 'Pais','Ciudad','Area de actividad','Salario','Fecha de vencimiento','Jornada Laboral','Tipo de Contrato','Años de experiencia', 'Vacantes']))
        return false;

    if (!validaFechaCompleta(FecVenc.value))
        return false;

    if(!isNumero(['anosexpnog'],['Años de experiencia']))
        return false;
    
    var progList = getCheckboxprogramas();
    var estreqList = getCheckboxestudios();
    
    
    if (progList == false || progList == '&') {
        return false;
    }
    
    if (estreqList == false || estreqList == '&') {
        return false;
    }
    
    formobj.action='NuevaOfertaGrad?nit='+usr +'&cont='+cont + progList + estreqList;
    return true;
    
    /*var url = 'NuevaOfertaGrad?nit='+usr +'&cont='+cont+'&'
    + getValores(['nomcargonog','descripcionnog','Requisitosnog','paisnog','ciudadnog',
      'areanog','salarionog','fechaoutnog','horarionog','contratonog','anosexpnog'])+ getCheckboxprogramas();
      conectarMethod(url, muestraResultadoreload, 'POST');
    var url = 'NuevaOfertaGrad?nit='+usr +'&cont='+cont+'&'
      + getValores(['nomcargonog','paisnog','ciudadnog',
      'areanog','salarionog','fechaoutnog','horarionog','contratonog','anosexpnog'])+ getCheckboxprogramas();
    conectarMethod(url, muestraResultadoreload, 'POST');*/

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