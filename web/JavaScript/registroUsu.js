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
            if (nombre.length === 0 || nombre.length > 50 || (/^\s+$/.test(nombre))){
               alert('Los datos ingresados en el campo Nombre no cumplen el formato');
           }else if(apellido.length === 0 || apellido.length > 50 || (/^\s+$/.test(apellido))){
               alert('Los datos ingresados en el campo Apellido no cumplen el formato');
            }else if(correoElectronico.length < 6 || correoElectronico.length > 50 || (/\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)/.test(correoElectronico))){
               alert('Los datos ingresados en el campo Correo Electronico no cumplen el formato');
            }else if(nombreUsuario.length < 6 || nombreUsuario.length > 20 || (/^\s+$/.test(nombreUsuario))){
               alert('Los datos ingresados en el campo Nombre de Usuario no cumplen el formato');
           }else if(password.length < 6 || password.length > 15 || (/^\s+$/.test(password))){
               alert('Los datos ingresados en el campo Password no cumplen el formato');
           }else {
               
               if(password === ConfirmPassword){
                   document.getElementById('registroUsu').submit();
               }else{
                  alert('Los campos de contraseña no coinciden'); 
               } 
           }   
        });
    });

