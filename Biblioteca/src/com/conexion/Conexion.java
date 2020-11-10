
package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Nombre de la clase: Conexion
 * Fecha: 01-09-2019
 * Version: 1.0
 * Copyright: Denis Valladares
 * @author Denis Valladares 
 */
public class Conexion {
    private Connection con;

    public Connection getCon() {
          return con;
    }
    
    public void conectar() throws ClassNotFoundException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con =(Connection) DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/biblioteca?user=root&password=");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con el servidor "+e.getMessage());
        }
    }
    
    public void desconectar(){
        try {
            if(con.isClosed()==false){
                con.close();;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al desconectar "+e.getMessage());
        }
    }    
}
