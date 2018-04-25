/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.addEventListener('load', function (){
        document.getElementById('btnBuscar').addEventListener('click', function (){
           var parametro =  document.getElementById('txtParametro').value;  
            if(document.getElementById('radioTitulo').checked){
                   if(parametro.length === 0 || parametro.length > 100 || (/^\s+$/.test(parametro))){
                       alert('Los datos ingresados no tienen un formato correcto');
                   }else{
                       document.getElementById('listadoVid').submit();
                   }
            }
            else if(document.getElementById('radioAutor').checked) {
                   if(parametro.length === 0 || parametro.length > 100 || (/^\s+$/.test(parametro))){
                       alert('Los datos ingresados no tienen un formato correcto');
                   }else{
                       document.getElementById('listadoVid').submit();
                   }
            }else if(document.getElementById('radioAnio').checked) {
                   if(parametro.length !== 4 || (!/^([0-9])*$/.test(parametro))){
                       alert('Los datos ingresados no corresponden aun formato de año correcto');
                   }else{
                       document.getElementById('listadoVid').submit();
                   }
            }else {
                alert('Se debe eligir un parametro de busqueda');
            }
        });
    });


