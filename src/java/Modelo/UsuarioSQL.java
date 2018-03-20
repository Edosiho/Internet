/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import ValueObjects.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Wal-Mart
 */
public class UsuarioSQL extends Conexion{
    public boolean autenticacion(String nombreUsuario, String password) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        String consulta = "Select * from USUARIOS where NOMBRE_USUARIO = ? and PASSWORD = ?";
        pst = getConexion().prepareStatement(consulta);
        pst.setString(1, nombreUsuario);
        pst.setString(2, password);
        rs = pst.executeQuery();   
        while (rs.next()) {
           cerraConexion();
           return true;
        }  
    return false;
    }
       
    public boolean registrarUsuario(Usuario usuario) throws SQLException{
        PreparedStatement pst = null;
        String consulta = "Insert into USUARIOS values (?,?,?,?,?)";
        pst = getConexion().prepareStatement(consulta);
        pst.setString(1, usuario.getNombreUsuario());
        pst.setString(2, usuario.getNombre());
        pst.setString(3, usuario.getApellido());
        pst.setString(4, usuario.getCorreoElectronico());
        pst.setString(5, usuario.getPassword());
        if(pst.executeUpdate() == 1){
            cerraConexion();
             return true;
        }
        cerraConexion();    
        return false;
    }   
    
}
