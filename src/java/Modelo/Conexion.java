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
   /* private final String host = "localhost";
    private final String port = "1527";
    private final String dataBase = "ISDCM_DB";*/
    private final String JDBC_CLASSNAME = "org.apache.derby.jdbc.ClientDriver";
    private final String URL = "jdbc:derby://localhost:1527/ISDCM_DB";
    private Connection conexion;
    
     public Conexion(){
        conexion = null;
        establecerConexion();
    }
    private void establecerConexion(){
        try {
            Class.forName(JDBC_CLASSNAME);
            conexion = DriverManager.getConnection(URL, usernameDB, passworUserDB);
        } catch ( SQLException ex) {
            System.err.printf("ERROR: "+ex);
        } catch (ClassNotFoundException ex) {
            System.err.printf("ERROR: "+ex);
        }
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
