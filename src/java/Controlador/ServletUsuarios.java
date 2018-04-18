/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Modelo.Video;
import ValueObjects.UsuarioVO;
import ValueObjects.VideoVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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
        try {           
            String nombreUsuario = request.getParameter("nombreUsuario");
            String password = request.getParameter("password");    
            HttpSession seccion = request.getSession(true);
            try {
                Usuario usuarioSQL = new Usuario();
                if (usuarioSQL.autenticacion(nombreUsuario, password)){
                    seccion.setAttribute("usuario", nombreUsuario);
                    listarVideos(request, response);
                }else{            
                    seccion.setAttribute("error", "Nombre de Usuario o Contraseña incorrecta"); 
                    response.sendRedirect("login.jsp");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ServletUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                seccion.setAttribute("error", "Se ha presentado un error, comuniquese con el Administrador"); 
                response.sendRedirect("login.jsp");
            }
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void registrarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession seccion = request.getSession(false);
        UsuarioVO usuario = new UsuarioVO();
        usuario.setNombre(request.getParameter("nombre"));
        usuario.setApellido(request.getParameter("apellido"));
        usuario.setCorreoElectronico(("correoElectronico"));
        usuario.setNombreUsuario(request.getParameter("nombreUsuario"));
        usuario.setPassword(request.getParameter("password"));
        if (usuario.getPassword().equals(request.getParameter("confirmPassword"))){
            try {
                Usuario usuarioSQL = new Usuario();
                if (usuarioSQL.registrarUsuario(usuario)){
                    response.sendRedirect("login.jsp");
                }
            } catch (SQLIntegrityConstraintViolationException ex) {
                Logger.getLogger(ServletUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                seccion.setAttribute("error", "El nombre de usuario ya se encuentra registrado"); 
                response.sendRedirect("registroUsu.jsp");;
            } catch (SQLException ex) {
                Logger.getLogger(ServletUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                seccion.setAttribute("error", "Se ha presentado un error, comuniquese con el Administrador"); 
                response.sendRedirect("login.jsp");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServletUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void listarVideos(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    try { 
            Video video = new Video();
            ArrayList<VideoVO> listaVideos = video.ListarVideos();
            request.setAttribute("listaVideos", listaVideos);
            request.getRequestDispatcher("listadoVid.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletRegistroVid.class.getName()).log(Level.SEVERE, null, ex);
            HttpSession seccion = request.getSession(false);
            seccion.setAttribute("error", "Se ha presentado un error, comuniquese con el Administrador"); 
            response.sendRedirect("login.jsp");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    
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
