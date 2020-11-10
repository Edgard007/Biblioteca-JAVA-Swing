
package com.dao;

import com.conexion.Conexion;
import com.modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *Nombre de la Clase: DaoUsuario
 * Fecha: 18-08-19
 * Version:1.0
 * Copyright: ITCA-FEPADE
 * @author Francisco Hernandez
 */

public class DaoUsuario extends Conexion{
    
    
    public boolean login(Empleado usr) throws ClassNotFoundException{
        ResultSet rs = null;

        String sql = "SELECT id, usuario, password,id_tipo FROM usuarios WHERE usuario = ? LIMIT 1";

        try {
            conectar();
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, usr.getUsuario());
            rs = pre.executeQuery();

            if (rs.next()) {
                if (usr.getPass().equals(rs.getString(3))) {
                   usr.setIdUsuario(rs.getString(1));
                    /*usr.setNombre(rs.getString(2));*/
                    usr.setTipoUser(rs.getString("id_tipo"));
                    
                    if(usr.getTipoUser().equals("3"))
                    {
                        JOptionPane.showMessageDialog(null," Clientes No Pueden Acceder al Sistema ");
                        return false;
                        
                    }
                    else
                    {
                        return true;
                    }
                    
                } else {
                    return false;
                }
            }

            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    
    
}
