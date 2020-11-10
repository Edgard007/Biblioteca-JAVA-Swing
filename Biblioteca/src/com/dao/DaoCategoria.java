/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author said
 */
public class DaoCategoria extends Conexion {
    public List<Categoria> mostrarCategoria() throws Exception
    {
        ResultSet rs;
        List<Categoria>lst=new ArrayList();
        
        try
        {
            this.conectar();
            String sql="select * from genero;";
            PreparedStatement pst=this.getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {
                Categoria ca=new Categoria();
                
                ca.setIdCategoria(rs.getInt("idGenero"));
                ca.setNombre(rs.getString("nombre"));
                ca.setDescripcion(rs.getString("descripcion"));
                lst.add(ca);
            }
        }
        catch (Exception e)
                {
                  throw e;  
                }
        finally
        {
            this.desconectar();
        }
        return lst;
    }
    
    public String insertarCategoria(Categoria ca) throws ClassNotFoundException 
    {
        try 
        {
            this.conectar();
            String sql="insert into genero(nombre ,descripcion) values(?,?);";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString   (1, ca.getNombre());
            pre.setString(2, ca.getDescripcion());
            pre.executeUpdate();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,
                    "Error al insertar"+e);
        }
        finally
        {
            this.desconectar();
        }
        return "Insertado correctamente";
    }
    public String modificarCategoria(Categoria ca) throws ClassNotFoundException 
    {
        try 
        {
            this.conectar();
            String sql="update genero set nombre=?, descripcion=? where idGenero=?;";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString   (1, ca.getNombre());
            pre.setString(2, ca.getDescripcion());
            pre.setInt(3,ca.getIdCategoria());
            pre.executeUpdate();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,
                    "Error al modificar"+e);
        }
        finally
        {
            this.desconectar();
        }
        return "Modificado correctamente";
    }
    public String eliminarCategoria(Categoria ca) throws ClassNotFoundException 
    {
        try 
        {
            this.conectar();
            String sql="delete from genero where idGenero =?;";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt      (1,ca.getIdCategoria());
            pre.executeUpdate();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,
                    "Error al eliminar su producto "+e);
        }
        finally
        {
            this.desconectar();
        }
        return "eliminado correctamente";
    }
}
