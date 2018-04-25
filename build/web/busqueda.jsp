<%-- 
    Document   : busqueda
    Created on : Apr 14, 2018, 2:00:57 PM
    Author     : Wal-Mart
--%>

<%@page import="ClienteWS_BusquedaVideosWS.Video"%>
<%@page import="java.util.ArrayList"%>
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
        <title>Busqueda de Videos</title>
    </head>
    <body>
        <div id="extra">
         <div  class ="container"  >
        <form action="ListadoVideos" method="post">
                    <br><br>
                    <%ArrayList<Video> listaVideos = (ArrayList<Video>) request.getAttribute("listaVideos") ;%> 
                    <%if(listaVideos.size()>0)
                    {%>
                    <table border = "2" class="table table-horizontal">  
                        <thead class="table-header">
                            <tr>
                                <th>TITULO</td>
                                <th>AUTOR</td>
                                <th>FECHA CREACION</td>
                                <th>DURACION</td>
                                <th>REPRODUCCIONES</td>
                                <th>DESCRIPCION</td>
                            </tr>
                        </thead>
                        <tbody>
                             <%   for(Video video : listaVideos) {%>  
                            <tr>
                                <td><%=video.getTitulo()%></td>
                                <td><%=video.getAutor()%></td>
                                <td><%=video.getFechaCreacion()%></td>
                                <td><%=video.getDuracion()%></td>
                                <td><%=video.getReproducciones()%></td>
                                <td><%=video.getDescripcion()%></td>
                            </tr>
                            <%}}else{%>
                                <h3>No hay videos con estas caracteristicas</h3>
                            <%}%>

                        </tbody>
                    </table>       
                    <br>  
                    <br> 
                    <%seccion.setAttribute("usuario", nombreUsuario);%>
                    <input type="submit" value="Regresar">
                </form> 
            </div>
        </div>
    </body>
</html>
