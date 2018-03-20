/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.addEventListener('load', function (){
        document.getElementById('btnRegistrar').addEventListener('click', function (){
           var nombre =  document.getElementById('txtNombre').value; 
           var apellido =  document.getElementById('txtApellido').value; 
           var correoElectronico =  document.getElementById('txtCorreoElectronico').value; 
           var nombreUsuario =  document.getElementById('txtNombreUsuario').value; 
           var password =  document.getElementById('txtPassword').value;
           var ConfirmPassword =  document.getElementById('txtConfirmPassword').value; 
            if (nombre.length > 0 && apellido.length > 0 && correoElectronico.length > 0  
                && nombreUsuario.length > 0 && password.length > 0){
               if(password === ConfirmPassword){
                   document.getElementById('registroUsu').submit();
               }else{
                  alert('Los campos de contraseña no coinciden'); 
               }     
               
           }else{
               alert('Ingrese correctamente los campos');
           }   
        });
    });

