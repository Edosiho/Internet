/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Video;
import ValueObjects.VideoVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLDataException;
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
public class ServletRegistroVid extends HttpServlet {

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
        HttpSession seccion = request.getSession(false);
        String nombreUsuario = seccion.getAttribute("usuario").toString();
        if(!nombreUsuario.equals("")){
            registrarVideo(request, response);
        }else{
            response.sendRedirect("login.jsp");
        }
        
    }
    private void registrarVideo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession seccion = request.getSession(true);
        VideoVO video = new VideoVO();
        video.setTitulo(request.getParameter("titulo")); 
        video.setAutor(request.getParameter("autor"));  
        video.setDuracion(request.getParameter("duracion"));
        video.setDescripcion(request.getParameter("descripcion"));
        video.setFormato(request.getParameter("formato"));      
        try {
            Video videoSQL = new Video();
            if (videoSQL.registrarVideo(video)){                 
                listarVideos(request, response);   
            }else{
                response.sendRedirect("listaVid.jsp");
            }
            
            } catch (SQLDataException ex) {
                Logger.getLogger(ServletUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                // aqui accion no cumple formato time 
                
                seccion.setAttribute("error", "El formato del campo duracion no es el correcto"); 
                response.sendRedirect("listadoVid.jsp");
                
            } catch (SQLIntegrityConstraintViolationException ex) {
            Logger.getLogger(ServletRegistroVid.class.getName()).log(Level.SEVERE, null, ex);
            // aqui accion no cumple formato time
                seccion.setAttribute("error", "Ese titulo ya se encuatra registrado con el mismo autor"); 
                response.sendRedirect("listadoVid.jsp");
            } catch (SQLException ex) {
            Logger.getLogger(ServletRegistroVid.class.getName()).log(Level.SEVERE, null, ex);
                seccion.setAttribute("error", "Se ha presentado un error, comuniquese con el Administrador"); 
                response.sendRedirect("login.jsp");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletRegistroVid.class.getName()).log(Level.SEVERE, null, ex);
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
            HttpSession seccion = request.getSession(true);
            seccion.setAttribute("error", "Se ha presentado un error, comuniquese con el Administrador"); 
            response.sendRedirect("login.jsp");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletRegistroVid.class.getName()).log(Level.SEVERE, null, ex);
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
