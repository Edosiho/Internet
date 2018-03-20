/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.addEventListener('load', function (){
        document.getElementById('btnLogear').addEventListener('click', function (){
           var nombreUsuario =  document.getElementById('txtNombreUsuario').value;
           var password =  document.getElementById('txtPassword').value;
           if (nombreUsuario.length > 0 && password.length > 0){
               document.getElementById('login').submit();
           }else{
               alert('Ingrese correctamente los campos');
           }   
        });
    });

