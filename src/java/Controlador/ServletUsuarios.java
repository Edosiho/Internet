/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DB.UsuarioSQL;
import DB.VideoSQL;
import Modelo.Usuario;
import Modelo.Video;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Wal-Mart
 */
public class ServletUsuarios extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {   
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();   
        if (request.getParameter("request").equals("login")){
            logearUsuario(request, response);
        }else if (request.getParameter("request").equals("registrar")){
            registrarUsuario(request, response);
        }      
    }
    
    private void logearUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{          
        String nombreUsuario = request.getParameter("nombreUsuario");
        String password = request.getParameter("password");    
        HttpSession seccion = request.getSession(true);
        UsuarioSQL usuarioSQL = new UsuarioSQL();
        String respuesta = usuarioSQL.autenticacion(nombreUsuario, password);
        if (respuesta == null){
            seccion.setAttribute("usuario", nombreUsuario);
            listarVideos(request, response);
        }else{            
            seccion.setAttribute("mensaje", respuesta); 
            response.sendRedirect("login.jsp");
        }  
    }
    
    private void registrarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession seccion = request.getSession(false);
        Usuario usuario = new Usuario();
        usuario.setNombre(request.getParameter("nombre"));
        usuario.setApellido(request.getParameter("apellido"));
        usuario.setCorreoElectronico(("correoElectronico"));
        usuario.setNombreUsuario(request.getParameter("nombreUsuario"));
        usuario.setPassword(request.getParameter("password"));
        if (usuario.getPassword().equals(request.getParameter("confirmPassword"))){
            UsuarioSQL usuarioSQL = new UsuarioSQL();     
            String resultado = usuarioSQL.registrarUsuario(usuario);
            if(resultado == null){
                seccion.setAttribute("mensaje", "Usuario Registrado Exitosamente");
                response.sendRedirect("login.jsp");
            }else{
                seccion.setAttribute("mensaje", resultado);
                response.sendRedirect("login.jsp");                
            }
        }
    }
    
    private void listarVideos(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{ 
        VideoSQL video = new VideoSQL();
        ArrayList<Video> listaVideos = video.ListarVideos();
        request.setAttribute("listaVideos", listaVideos);
        request.getRequestDispatcher("listadoVid.jsp").forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
