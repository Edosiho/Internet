/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.addEventListener('load', function (){
        document.getElementById('btnRegistrar').addEventListener('click', function (){
           var titulo =  document.getElementById('txtTitulo').value; 
           var autor =  document.getElementById('txtAutor').value; 
           var duracion =  document.getElementById('txtDuracion').value; 
           var descripcion =  document.getElementById('txtDescripcion').value;
           var formato =  document.getElementById('txtFormato').value; 
            if (titulo.length > 0 && autor.length > 0 && duracion.length > 0  
                && descripcion.length > 0 && formato.length > 0){ 
                   
                document.getElementById('registroVid').submit();               
           
            }else{
               alert('Ingrese correctamente los campos');
           }   
        });
    });
