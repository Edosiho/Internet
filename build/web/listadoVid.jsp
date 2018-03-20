<%-- 
    Document   : listadoVid
    Created on : Mar 12, 2018, 10:26:04 PM
    Author     : Wal-Mart
--%>

<%@page import="ValueObjects.Video"%>
<%@page import="Modelo.VideoSQL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ValueObjects.Video"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%HttpSession seccion = request.getSession(false);
 String nombreUsuario = seccion.getAttribute("usuario").toString();
 if(nombreUsuario.equals(null)){
      response.sendRedirect("login.jsp");
 }
%>


<!DOCTYPE html>
<html>
    <head>
        <style><%@include file="/WEB-INF/CSS/default.css"%></style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Videos</title>
    </head>
    <body>
        <div id="extra">
            <div id="wrapper" class ="container"  align >
            <form action="ListadoVideos" method="post">
            <br><br>
            <table border = "2" class="table table-horizontal">  
                <thead class="table-header">
                <tr>
                    <th>ID</td>
                    <th>TITULO</td>
                    <th>AUTOR</td>
                    <th>FECHA CREACION</td>
                    <th>DURACION</td>
                    <th>REPRODUCCIONES</td>
                    <th>DESCRIPCION</td>
                    <th>FORMATO</td>
                </tr>
                </thead>
                <tbody>
                <%ArrayList<Video> listaVideos = (ArrayList<Video>) request.getAttribute("listaVideos") ;%>
                
                <%if(listaVideos.size()>0)
                {
                    for(Video video : listaVideos) {%>  
                    <tr>
                    <td><%=video.getId()%></td>
                    <td><%=video.getTitulo()%></td>
                    <td><%=video.getAutor()%></td>
                    <td><%=video.getFechaCreacion()%></td>
                    <td><%=video.getDuracion()%></td>
                    <td><%=video.getReproducciones()%></td>
                    <td><%=video.getDescripcion()%></td>
                    <td><%=video.getFormato()%></td>
                    </tr>
                    <%}}%>

                </tbody>
            </table>
             <br>  
              <br> 
              <%seccion.setAttribute("usuario", nombreUsuario);%>
              Ingresar nuevo video:<br>
              <a href ="registroVid.jsp" class="button">Nuevo Video</a><br>
        </form> 
            </div>
        </div>
    </body>
</html>
