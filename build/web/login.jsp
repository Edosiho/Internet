<%-- 
    Document   : login
    Created on : Mar 12, 2018, 2:01:15 PM
    Author     : Wal-Mart
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style><%@include file="/WEB-INF/CSS/default.css"%></style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <script src ="JavaScript/login.js"></script>
    </head>
    <body>
        <div id="extra">
            <div id="wrapper" class ="container"  align >
                <form action = "Usuarios" method="post" id = "login">
                    Nombre de Usuario: (mínimo 6 máximo 20 caracteres ) <input type="text" name="nombreUsuario" id = "txtNombreUsuario"><br>
                    Password: (mínimo 6 máximo 15 caracteres) <input type="password" name="password" id = "txtPassword"><br>
                    <input type="button" value = "Login" id = "btnLogear" class="button"><br>
                    <input type="hidden" name="request" value ="login" align="center">
                    <br>No tienes Cuenta?<br>
                    <a href ="registroUsu.jsp" class="button">Registrar</a>
                    
                    <% HttpSession seccion = request.getSession(false);
                    if (seccion.getAttribute("error") != null){%>
                        <br><br><h3><%=seccion.getAttribute("error").toString()%></h3>
                    <% seccion.removeAttribute("error");
                    } %>
                </form>
            </div>
        </div>    
    </body>
</html>
