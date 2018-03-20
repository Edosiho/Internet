/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import ValueObjects.Video;
import Util.UtilFecha;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Wal-Mart
 */
public class VideoSQL extends Conexion{
    private static int INICIO_REPRODUCCIONES = 0;
    
    public boolean registrarVideo(Video video) throws SQLException{
        UtilFecha fecha = new UtilFecha();
        PreparedStatement pst;
        String consulta = "Insert into VIDEOS values (?,?,?,?,?,?,?,?)";
        pst = getConexion().prepareStatement(consulta);
        pst.setInt(1, obtenerIdNuevoUsuario());
        pst.setString(2, video.getTitulo());
        pst.setString(3, video.getTitulo());
        pst.setString(4, fecha.obtenerFechaActualTexto());
        pst.setString(5, video.getDuracion());
        pst.setInt(6, INICIO_REPRODUCCIONES);
        pst.setString(7, video.getDescripcion());
        pst.setString(8, video.getFormato());
        if(pst.executeUpdate() == 1){
            cerraConexion();
            return true;
        }
        cerraConexion();
        return false;
    }   
     
     public ArrayList<Video> ListarVideos() throws SQLException{ 
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<Video> listaVideos = new ArrayList<Video>();
        String consulta = "Select * from VIDEOS";
        pst = getConexion().prepareStatement(consulta);
        rs = pst.executeQuery();
        while (rs.next()) {
           Video video = new Video(); 
           video.setId(rs.getInt("ID"));
           video.setTitulo(rs.getString("TITULO"));
           video.setAutor(rs.getString("AUTOR"));
           video.setFechaCreacion(rs.getString("FECHACREACION"));
           video.setDuracion(rs.getString("DURACION"));
           video.setReproducciones(rs.getInt("REPRODUCCIONES"));
           video.setDescripcion(rs.getString("DESCRIPCION"));
           video.setFormato(rs.getString("FORMATO"));
           listaVideos.add(video);
        }   
           cerraConexion();
        return listaVideos;
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
        } catch (SQLException ex) {
            Logger.getLogger(VideoSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    } 
   
}
