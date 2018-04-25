/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Controlador.ServletRegistroVid;
import Controlador.ServletUsuarios;
import Modelo.Video;
import Util.UtilFecha;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Wal-Mart
 */
public class VideoSQL extends Conexion{

    public VideoSQL() {
    
    }
    private static final int INICIO_REPRODUCCIONES = 0;
    
    public String registrarVideo(Video video) {
        try {
            UtilFecha fecha = new UtilFecha();
            PreparedStatement pst;
            String consulta = "Insert into VIDEOS values (?,?,?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, obtenerIdNuevoUsuario());
            pst.setString(2, video.getTitulo());
            pst.setString(3, video.getAutor());
            pst.setString(4, fecha.obtenerFechaActualTexto());
            pst.setString(5, video.getDuracion());
            pst.setInt(6, INICIO_REPRODUCCIONES);
            pst.setString(7, video.getDescripcion());
            pst.setString(8, video.getFormato());
            pst.setString(9, video.getUbicacion());
            if(pst.executeUpdate() == 1){
                cerraConexion();
            }
            return null;
            
        } catch (SQLDataException ex) {
            Logger.getLogger(ServletUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            cerraConexion();
            return "El formato del campo duracion no es el correcto";         
        } catch (SQLIntegrityConstraintViolationException ex) {
            Logger.getLogger(ServletRegistroVid.class.getName()).log(Level.SEVERE, null, ex);
            cerraConexion();
            return "Ese titulo ya se encuatra registrado con el mismo autor";  
        } catch (SQLException ex) {
            Logger.getLogger(ServletRegistroVid.class.getName()).log(Level.SEVERE, null, ex);
            cerraConexion();
            return "Se ha presentado un error, comuniquese con el Administrador"; 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VideoSQL.class.getName()).log(Level.SEVERE, null, ex);
            cerraConexion();
            return "Se ha presentado un error, comuniquese con el Administrador"; 
        }
    }   
     
     public ArrayList<Video> ListarVideos() { 
        ArrayList<Video> listaVideos = new ArrayList<Video>();
         try {
            PreparedStatement pst;
            ResultSet rs;
            
            String consulta = "Select * from VIDEOS";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                Video video = new Video();
                video.setId(rs.getInt("ID"));
                video.setTitulo(rs.getString("TITULO"));
                video.setAutor(rs.getString("AUTOR"));
                video.setFechaCreacion(rs.getString("FECHA_CREACION"));
                video.setDuracion(rs.getString("DURACION"));
                video.setReproducciones(rs.getInt("REPRODUCCIONES"));
                video.setDescripcion(rs.getString("DESCRIPCION"));
                video.setFormato(rs.getString("FORMATO"));
                listaVideos.add(video);
            }
            cerraConexion();
            return listaVideos;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(VideoSQL.class.getName()).log(Level.SEVERE, null, ex);
            cerraConexion();
            return listaVideos;
        }
    }
     
     private int obtenerIdNuevoUsuario(){
         return obtenerIdMaximo() + 1;
     }
     
     private int obtenerIdMaximo() {
        int id = 0;
        
        try {
            PreparedStatement pst;
            ResultSet rs;
            String consulta = "Select max(id) from VIDEOS as MAX_ID";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                id = rs.getInt("1");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(VideoSQL.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return id;
    } 

    public ArrayList<Video> BurcarVideosTitulo(String tituloVideo) { 
        ArrayList<Video> listaVideos = new ArrayList<Video>();
        try {
            PreparedStatement pst;
            ResultSet rs;            
            String consulta = "Select * from VIDEOS where TITULO = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, tituloVideo);
            rs = pst.executeQuery();
            while (rs.next()) {
                Video video = new Video();
                video.setTitulo(rs.getString("TITULO"));
                video.setAutor(rs.getString("AUTOR"));
                video.setFechaCreacion(rs.getString("FECHA_CREACION"));
                video.setDuracion(rs.getString("DURACION"));
                video.setReproducciones(rs.getInt("REPRODUCCIONES"));
                video.setDescripcion(rs.getString("DESCRIPCION"));
                listaVideos.add(video);
            }
            cerraConexion();
            return listaVideos;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(VideoSQL.class.getName()).log(Level.SEVERE, null, ex);
            return listaVideos;
        }
    }
     
    public ArrayList<Video> BurcarVideosAutor(String autorVideo){ 
        ArrayList<Video> listaVideos = new ArrayList<Video>();
        try {
            PreparedStatement pst;
            ResultSet rs;    
            String consulta = "Select * from VIDEOS where AUTOR = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, autorVideo);
            rs = pst.executeQuery();
            while (rs.next()) {
                Video video = new Video();
                video.setTitulo(rs.getString("TITULO"));
                video.setAutor(rs.getString("AUTOR"));
                video.setFechaCreacion(rs.getString("FECHA_CREACION"));
                video.setDuracion(rs.getString("DURACION"));
                video.setReproducciones(rs.getInt("REPRODUCCIONES"));
                video.setDescripcion(rs.getString("DESCRIPCION"));
                listaVideos.add(video);
            }
            cerraConexion();
            return listaVideos;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VideoSQL.class.getName()).log(Level.SEVERE, null, ex);
            return listaVideos;
        }
    }
    
    public ArrayList<Video> BurcarVideosAnio(String anioVideo) { 
        ArrayList<Video> listaVideos = new ArrayList<Video>();
        try {
            PreparedStatement pst;
            ResultSet rs;
            String consulta = "Select * from VIDEOS where FECHA_CREACION between ? and ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, anioVideo+"-01-01");
            pst.setString(2, anioVideo+"-12-31");
            rs = pst.executeQuery();
            while (rs.next()) {
                Video video = new Video();
                video.setTitulo(rs.getString("TITULO"));
                video.setAutor(rs.getString("AUTOR"));
                video.setFechaCreacion(rs.getString("FECHA_CREACION"));
                video.setDuracion(rs.getString("DURACION"));
                video.setReproducciones(rs.getInt("REPRODUCCIONES"));
                video.setDescripcion(rs.getString("DESCRIPCION"));
                listaVideos.add(video);
            }
            cerraConexion();
            return listaVideos;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VideoSQL.class.getName()).log(Level.SEVERE, null, ex);
            return listaVideos;
        }
    }     
     
}
