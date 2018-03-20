/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.VideoSQL;
import ValueObjects.Video;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLDataException;
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
        Video video = new Video();
        video.setTitulo(request.getParameter("titulo")); 
        video.setAutor(request.getParameter("autor"));  
        video.setDuracion(request.getParameter("duracion"));
        video.setDescripcion(request.getParameter("descripcion"));
        video.setFormato(request.getParameter("formato"));      
        try {
            VideoSQL videoSQL = new VideoSQL();
            if (videoSQL.registrarVideo(video)){                 
                listarVideos(request, response);   
            }else{
                response.sendRedirect("listaVid.jsp");
            }
            
            } catch (SQLDataException ex) {
                Logger.getLogger(ServletUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
            Logger.getLogger(ServletRegistroVid.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void listarVideos(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    try {
            VideoSQL videoSQL = new VideoSQL();
            ArrayList<Video> listaVideos = videoSQL.ListarVideos();
            request.setAttribute("listaVideos", listaVideos);
            request.getRequestDispatcher("listadoVid.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletListadoVid.class.getName()).log(Level.SEVERE, null, ex);
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
