<%-- 
    Document   : registroUsu
    Created on : Mar 12, 2018, 2:30:15 PM
    Author     : Wal-Mart
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style><%@include file="/WEB-INF/CSS/default.css"%></style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Usuarios</title>
        <script src ="JavaScript/registroUsu.js"></script>
    </head>
    <body>
        <div id="extra">
            <div id="wrapper" class ="container"  align >
                <form action="Usuarios" method="post" id = "registroUsu">
                    Nombre: <input type="text" name="nombre" id = "txtNombre"><br>
                    Apellido: <input type="text" name="apellido" id = "txtApellido"><br>
                    Correo Electronico: <input type="text" name="correoElectronico" id = "txtCorreoElectronico"><br>
                    Nombre de Usuario: <input type="text" name="nombreUsuario" id = "txtNombreUsuario"><br>
                    Password: <input type="password" name="password" id = "txtPassword"><br>           
                    Confirmar Password: <input type="password" name="confirmPassword" id = "txtConfirmPassword"><br>            
                    <input type="button" value="Registrar" id = "btnRegistrar" class="button">
                    <input type="hidden" name="request" value ="registrar">
                </form>
            </div>
        </div>
    </body>
</html>
