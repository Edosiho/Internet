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
            if (titulo.length === 0 || formato.length > 100 || (/^\s+$/.test(titulo))){ 
               alert('Los datos ingresados en el campo Titulo no cumplen el formato');   
            }else if(autor.length === 0 || autor.length > 100 || (/^\s+$/.test(autor))){
               alert('Los datos ingresados en el campo Autor no cumplen el formato');
            }else if(descripcion.length === 0 || descripcion.length > 255 || (/^\s+$/.test(descripcion))){
               alert('Los datos ingresados en el campo Descripcion no cumplen el formato');
            }else if(duracion.length !== 8 || (/^\s+$/.test(duracion))){
               alert('Los datos ingresados en el campo Duracion no cumplen el formato');
           }else if(formato.length === 0 || formato.length > 5 || (/^\s+$/.test(formato))){
               alert('Los datos ingresados en el campo formato no cumplen el formato');
           }else{
               document.getElementById('registroVid').submit(); 
           }
        });
    });
