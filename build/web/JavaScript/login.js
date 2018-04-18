/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.addEventListener('load', function (){
        document.getElementById('btnLogear').addEventListener('click', function (){
           var nombreUsuario =  document.getElementById('txtNombreUsuario').value;
           var password =  document.getElementById('txtPassword').value;
           if (nombreUsuario.length < 6 || nombreUsuario.length > 20 || (/^\s+$/.test(nombreUsuario))){
               alert('Los datos ingresados en el campo Nombre de Usuario no cumplen el formato');
           }else if(password.length < 4 || password.length > 15 || (/^\s+$/.test(password))){
               alert('Los datos ingresados en el campo Password no cumplen el formato');
           }else {
               document.getElementById('login').submit();
           }     
        });
    });

