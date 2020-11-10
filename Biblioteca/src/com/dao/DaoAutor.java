/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.Autor;
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
public class DaoAutor extends Conexion {
    public List<Autor> mostrarAutor() throws Exception
    {
        ResultSet rs;
        List<Autor>lst=new ArrayList();
        
        try
        {
            this.conectar();
            String sql="SELECT autor.idAutor, autor.nombre, autor.sexo, autor.fechaNacimiento,"
                    + " autor.fechaDefuncion, genero.nombre as genero,"
                    + " pais.nombre as  pais FROM autor join genero ON "
                    + "autor.idGenero=genero.idGenero join pais on "
                    + "autor.idPais= pais.idPais WHERE autor.borradoLogico=1";
            
            PreparedStatement pst=this.getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {
                Autor a=new Autor();
                
                a.setIdAutor(rs.getInt("idAutor"));
                a.setNombre(rs.getString("nombre"));
                a.setSexo(rs.getString("sexo"));
                a.setFechaNacimiento(rs.getInt("fechaNacimiento"));
                a.setFechaDefuncion(rs.getInt("fechaDefuncion"));
                a.setGenero(rs.getString("genero"));
                a.setPais(rs.getString("pais"));
                lst.add(a);
                
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
    

    public String insertarAutor(Autor a) throws ClassNotFoundException 
    {
        try 
        {
            this.conectar();
            String sql="insert into autor (nombre,sexo,fechaNacimiento,fechaDefuncion,idGenero,idPais,borradoLogico) values(?,?,?,?,?,?,1);";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString   (1, a.getNombre());
            pre.setString   (2, a.getSexo());
            pre.setInt      (3, a.getFechaNacimiento());
            pre.setInt      (4, a.getFechaDefuncion());
            pre.setInt      (5, sacarIdGenero(a.getGenero()));
            pre.setInt      (6, sacarIdPais(a.getPais()));
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
    public String modificarAutor(Autor a) throws ClassNotFoundException 
    {
        try 
        {
            this.conectar();
            String sql="update autor set nombre=?, sexo=?, "
                    + "fechaNacimiento=?, fechaDefuncion=?, idGenero=?, idPais=?"
                    + " where idAutor=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString   (1, a.getNombre());
            pre.setString   (2, a.getSexo());
            pre.setInt      (3, a.getFechaNacimiento());
            pre.setInt      (4, a.getFechaDefuncion());
            pre.setInt      (5, sacarIdGenero(a.getGenero()));
            pre.setInt      (6, sacarIdPais(a.getPais()));
            pre.setInt      (7,a.getIdAutor());
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
    public String eliminarAutor(Autor a) throws ClassNotFoundException 
    {
        try 
        {
            this.conectar();
            String sql="UPDATE autor SET borradoLogico=2 where idAutor=?;";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt      (1,a.getIdAutor());
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
    
    
public ArrayList<String> comboLibros() throws ClassNotFoundException, SQLException{
ArrayList<String> ls = new ArrayList<String>();
ResultSet rs;
try{
conectar();
String sql = "SELECT nombre FROM genero";
        PreparedStatement pre = this.getCon().prepareStatement(sql);
        rs = pre.executeQuery();
        while(rs.next()){
        ls.add(rs.getString("nombre"));
        }
}catch (SQLException e){
    JOptionPane.showMessageDialog(null, "Error al cargar los generos de los "
            + "Libros."+e.getMessage());
}
finally{
desconectar();
}
return ls;
}


/////////////////////////////////////////////////////////////////////////////

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

/*--------------------------------------------------------------------------*/
    

public ArrayList<String> comboGenero() throws ClassNotFoundException{
        ArrayList<String> ls = new ArrayList<String>();
        ResultSet rs;
        try {
            conectar();
            String sql = "SELECT nombre FROM genero";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            rs = pre.executeQuery();
            while(rs.next()){
                ls.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar combo Genero "
                    + ""+e.getMessage());
        }
        finally{
            desconectar();
        }
        return ls;
    }
    
    public int sacarIdGenero(String genero) throws ClassNotFoundException{
        ResultSet rs;
        int id = 0;
        try {
            conectar();
            String sql= "SELECT idGenero FROM genero WHERE nombre=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, genero);
            rs = pre.executeQuery();
            while(rs.next()){
                id = Integer.parseInt(rs.getString("idGenero"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al sacar id Genero "+e.getMessage());
        }
        return id;
    }    
    
    
}
