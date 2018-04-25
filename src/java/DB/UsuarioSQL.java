/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Controlador.ServletUsuarios;
import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wal-Mart
 */
public class UsuarioSQL extends  Conexion{

    public UsuarioSQL() {
    
    }
    
    public String autenticacion(String nombreUsuario, String password) {
        String respuesta = null;
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "Select * from USUARIOS where NOMBRE_USUARIO = ? and PASSWORD = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, nombreUsuario);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (!rs.next()) {
                respuesta = "El usuario o contraseña no son correctas";
                cerraConexion();
            }
            return respuesta;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioSQL.class.getName()).log(Level.SEVERE, null, ex);
            return "Se ha presentado un error, comuniquese con el Administrador";
        }
    }
       
    public String registrarUsuario(Usuario usuario) {
        try {
            PreparedStatement pst = null;
            String consulta = "Insert into USUARIOS values (?,?,?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, usuario.getNombreUsuario());
            pst.setString(2, usuario.getNombre());
            pst.setString(3, usuario.getApellido());
            pst.setString(4, usuario.getCorreoElectronico());
            pst.setString(5, usuario.getPassword());
            pst.executeUpdate();
            cerraConexion();
            return null;
        } catch (SQLIntegrityConstraintViolationException ex) {
                Logger.getLogger(ServletUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                return  "El nombre de usuario ya se encuentra registrado"; 
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioSQL.class.getName()).log(Level.SEVERE, null, ex);
            return "Se ha presentado un error, comuniquese con el Administrador";
        }
    }   
    
}
