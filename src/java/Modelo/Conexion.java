/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wal-Mart
 */
public class Conexion {
     private final String usernameDB = "root";
    private final String passworUserDB = "root";
    private final String host = "localhost";
    private final String port = "1527";
    private final String dataBase = "ISDCM_DB";   
    private final String JDBC_CLASSNAME = "org.apache.derby.jdbc.ClientDriver";    
    private final String URL = "jdbc:derby://"+host+":"+port+"/"+dataBase;
    
    private Connection conexion;
    
     public Conexion() throws ClassNotFoundException, SQLException{
        conexion = null;
        establecerConexion();
    }
    private void establecerConexion() throws ClassNotFoundException, SQLException{

            Class.forName(JDBC_CLASSNAME);
            conexion = DriverManager.getConnection(URL, usernameDB, passworUserDB);

    }
    public void cerraConexion() {
        if ( this.conexion != null) {
            try {
                this.conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public Connection getConexion(){
        return conexion;
    }
}
