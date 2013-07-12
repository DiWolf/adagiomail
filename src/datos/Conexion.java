/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DiWolf
 */
public class Conexion {

    // Crear un objto de tipo conexión para conectar a la base de datos. 
    private java.sql.Connection connection = null;
    //Esta variable permitirá al usuario escribir el servidor al que deseea conectarse.
    //esto ayudará a no tener que recompilar el sistema cada vez que se pierda una ip.
    public static String servidor = ""; 
    
    public java.sql.Connection getConnection() {
        if (connection == null) {
            try {
                java.sql.Driver driver = new com.mysql.jdbc.Driver();
                DriverManager.registerDriver(driver);
               // connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/icymail", "root", "220686");
                connection = DriverManager.getConnection("jdbc:mysql://"+servidor+"/icymail","root","220686");
            } catch (SQLException ex) {
               //excepciones.NoBaseDatos(); // [Javier] Esto se encuentra en la clase Excepciones. 
            }

        }
        return connection;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }
    
}
