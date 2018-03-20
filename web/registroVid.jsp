<%-- 
    Document   : registroVid
    Created on : Mar 13, 2018, 2:33:47 PM
    Author     : Wal-Mart
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%HttpSession seccion = request.getSession(false);
 String nombreUsuario = seccion.getAttribute("usuario").toString();
 if(nombreUsuario.equals("")){
      response.sendRedirect("login.jsp");
 }
%>
<!DOCTYPE html>
<html>
    <head>
        <style><%@include file="/WEB-INF/CSS/default.css"%></style>
        <title>Registro de Videos</title>
        <script src ="JavaScript/registroVid.js"></script>
    </head>
    <body>
        <div id="extra">
            <div id="wrapper" class ="container" >
                <form action="RegistroVideo" method="post" id = "registroVid">
                   Título: <input type="text" name="titulo" id = "txtTitulo"><br>
                   Autor: <input type="text" name="autor" id = "txtAutor"><br>
                   Duración: <input type="text" name="duracion" id = "txtDuracion"><br>
                   Descripcion: <input type="text" name="descripcion" id = "txtDescripcion"><br>
                   Formato: <input type="text" name="formato" id = "txtFormato"><br>
                   <input type="button" value="Registrar" id = "btnRegistrar" class="button">
                   <%seccion.setAttribute("usuario", nombreUsuario);%>
               </form>
            </div>
        </div>
    </body>
</html>
