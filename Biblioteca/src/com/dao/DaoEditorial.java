
package com.dao;

import com.conexion.Conexion;
import com.modelo.Editorial;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Nombre de la clase: DaoEditorial
 * Fecha: 01-09-2019
 * Version: 1.0
 * Copyright: Denis Valladares
 * @author Denis Valladares
 */
public class DaoEditorial extends Conexion {
    
    public ArrayList<String> comboPais() throws ClassNotFoundException{
        ArrayList<String> ls = new ArrayList<String>();
        ResultSet rs;
        try {
            conectar();
            String sql = "SELECT nombre FROM pais";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            rs = pre.executeQuery();
            while(rs.next()){
                ls.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar comboPais "+e.getMessage());
        }
        finally{
            desconectar();
        }
        return ls;
    }
    
    public int sacarIdPais(String pais) throws ClassNotFoundException{
        ResultSet rs;
        int id = 0;
        try {
            conectar();
            String sql= "SELECT idPais FROM pais WHERE nombre=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, pais);
            rs = pre.executeQuery();
            while(rs.next()){
                id = Integer.parseInt(rs.getString("idPais"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al sacar id pais "+e.getMessage());
        }
        return id;
    }
    
    public List<Editorial> mostrarEditorial() throws ClassNotFoundException{
        ResultSet rs;
        List ls = new ArrayList();
        try {
            conectar();
            String sql = "SELECT editorial.idEditorial, editorial.nombre, pais.nombre AS pais "
                    + "FROM editorial JOIN pais ON editorial.idPais = pais.idPais WHERE editorial.borradoLogico=1";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            rs = pre.executeQuery();
            while(rs.next()){
                Editorial e = new Editorial();
                e.setIdEditorial(Integer.parseInt(rs.getString("idEditorial")));
                e.setNombre(rs.getString("nombre"));
                e.setPais(rs.getString("pais"));
                ls.add(e);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar tabla en Dao "+e.getMessage());
        }
        finally{
            desconectar();
        }
        return ls;
    }
    
    public void insertarEditorial(Editorial e) throws ClassNotFoundException{
        try {
            conectar();
            String sql ="INSERT INTO editorial(nombre,idPais, borradoLogico) values(?,?,1)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, e.getNombre());
            pre.setInt(2, sacarIdPais(e.getPais()));
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Insertado correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar Editrorial "+ex.getMessage());
        }
    }
    public void modificarEditorial(Editorial e) throws ClassNotFoundException{
        try {
            conectar();
            String sql ="UPDATE editorial SET nombre=?,idPais=? WHERE idEditorial=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, e.getNombre());
            pre.setInt(2, sacarIdPais(e.getPais()));
            pre.setInt(3,e.getIdEditorial());
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modificado correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar Editrorial "+ex.getMessage());
        }
    }
    
    public void eliminarEditorial(Editorial e) throws ClassNotFoundException{
        try {
            conectar();
            String sql ="UPDATE editorial SET borradoLogico=2 WHERE idEditorial=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1,e.getIdEditorial());
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar Editrorial "+ex.getMessage());
        }
    }
    
}
