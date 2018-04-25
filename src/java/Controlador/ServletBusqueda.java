/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;



import ClienteWS_BusquedaVideosWS.BusquedaVideosWS;
import ClienteWS_BusquedaVideosWS.BusquedaVideosWS_Service;
import ClienteWS_BusquedaVideosWS.Video;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Wal-Mart
 */
@WebServlet(name = "BusquedaVideos", urlPatterns = {"/ServletBusqueda"})
public class ServletBusqueda extends HttpServlet {

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
        HttpSession seccion = request.getSession(false);
        String nombreUsuario = seccion.getAttribute("usuario").toString();
        if(!nombreUsuario.equals("")){
            iniciarBusqueda(request, response);
        }else{
            response.sendRedirect("login.jsp");
        }
    }
    
    private void iniciarBusqueda(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        if (request.getParameter("parametroBusqueda").equals("titulo")){
            buscarVideosTitulo(request, response, request.getParameter("parametro"));
        }else if (request.getParameter("parametroBusqueda").equals("autor")){
            buscarVideosAutor(request, response, request.getParameter("parametro"));
        }else if (request.getParameter("parametroBusqueda").equals("anio")){
            buscarVideosAnio(request, response, request.getParameter("parametro"));
        }
    }
    
    private void buscarVideosTitulo(HttpServletRequest request, HttpServletResponse response, String titulo) throws IOException, ServletException{
        
        BusquedaVideosWS_Service buscarVideosWS_Service = new BusquedaVideosWS_Service();
        BusquedaVideosWS buscarVideosWS;
        buscarVideosWS = buscarVideosWS_Service.getBusquedaVideosWSPort();
        List<Video> listaVideosWS = buscarVideosWS.buscarVideosTitulo(titulo);
        request.setAttribute("listaVideos", listaVideosWS);
        request.getRequestDispatcher("busqueda.jsp").forward(request, response);
    }   
    
    private void buscarVideosAutor(HttpServletRequest request, HttpServletResponse response, String autor) throws IOException, ServletException{    
    
        BusquedaVideosWS_Service buscarVideosWS_Service = new BusquedaVideosWS_Service();
        BusquedaVideosWS buscarVideosWS;
        buscarVideosWS = buscarVideosWS_Service.getBusquedaVideosWSPort();
        List<Video> listaVideosWS = buscarVideosWS.buscarVideosAutor(autor);
        request.setAttribute("listaVideos", listaVideosWS);
        request.getRequestDispatcher("busqueda.jsp").forward(request, response);
    }
    
    private void buscarVideosAnio(HttpServletRequest request, HttpServletResponse response, String anio) throws IOException, ServletException{
    
        BusquedaVideosWS_Service buscarVideosWS_Service = new BusquedaVideosWS_Service();
        BusquedaVideosWS buscarVideosWS;
        buscarVideosWS = buscarVideosWS_Service.getBusquedaVideosWSPort();
        List<Video> listaVideosWS = buscarVideosWS.buscarVideosAnio(anio);
        request.setAttribute("listaVideos", listaVideosWS);
        request.getRequestDispatcher("busqueda.jsp").forward(request, response);
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
