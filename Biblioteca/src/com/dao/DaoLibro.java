
package com.dao;

import com.conexion.Conexion;
import com.modelo.Libro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Nombre de la clase: DaoLibro
 * Fecha: 01-09-2019
 * Version: 1.0
 * Copyright: Denis Valladares
 * @author Denis Valladares
 */
public class DaoLibro extends Conexion{
    
    public List<Libro> mostrarLibro() throws ClassNotFoundException{
        ResultSet rs;
        List ls = new ArrayList();
        try {
            conectar();
            String sql = "SELECT libro.idLibro, libro.nombre, genero.nombre AS genero,  "
                    + " libro.anioLanzamiento, editorial.nombre AS editorial,  "
                    + " libro.sinopsis, libro.isbn, libro.cantidad, tipolibro.tipo,  "
                    + " libro.edicion, libro.costoCompra, libro.costoVenta,  "
                    + " autor.nombre AS autor FROM libro INNER JOIN genero  "
                    + " ON libro.idGenero= genero.idGenero INNER JOIN editorial  "
                    + " ON libro.idEditorial=editorial.idEditorial INNER JOIN tipolibro  "
                    + " ON libro.idTipoLibro=tipolibro.idTipoLibro INNER JOIN autor  "
                    + " ON libro.idAutor = autor.idAutor WHERE libro.borradoLogico=1 ";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            rs = pre.executeQuery();
            while(rs.next()){
                Libro l = new Libro();
                l.setNombre(rs.getString("nombre"));
                l.setGenero(rs.getString("genero"));
                l.setFechaLanzamiento(rs.getString("anioLanzamiento"));
                l.setEditorial(rs.getString("editorial"));
                l.setSinopsis(rs.getString("sinopsis"));
                l.setIsbn(rs.getString("isbn"));
                l.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                l.setTipoLibro(rs.getString("tipo"));
                l.setEdicion(rs.getString("edicion"));
                l.setCosto(Double.parseDouble(rs.getString("costoCompra")));
                l.setPrecio(Double.parseDouble(rs.getString("costoVenta")));
                l.setAutor(rs.getString("autor"));
                l.setIdLibro(Integer.parseInt(rs.getString("idLibro")));
                ls.add(l);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar tabla en Dao "+e.getMessage());
        }
        finally{
            desconectar();
        }
        return ls;
    }
    
    public ArrayList<String> comboEditorial() throws ClassNotFoundException{
        ArrayList<String> ls = new ArrayList<String>();
        ResultSet rs;
        try {
            conectar();
            String sql = "SELECT nombre FROM editorial";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            rs = pre.executeQuery();
            while(rs.next()){
                ls.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar comboEditorial "+e.getMessage());
        }
        finally{
            desconectar();
        }
        return ls;
    }
    
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
            JOptionPane.showMessageDialog(null, "Error al cargar comboGenero "+e.getMessage());
        }
        finally{
            desconectar();
        }
        return ls;
    }
    
    public ArrayList<String> comboTipo() throws ClassNotFoundException{
        ArrayList<String> ls = new ArrayList<String>();
        ResultSet rs;
        try {
            conectar();
            String sql = "SELECT tipo FROM tipoLibro";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            rs = pre.executeQuery();
            while(rs.next()){
                ls.add(rs.getString("tipo"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar comboTipo "+e.getMessage());
        }
        finally{
            desconectar();
        }
        return ls;
    }
    
    public ArrayList<String> comboAutor() throws ClassNotFoundException{
        ArrayList<String> ls = new ArrayList<String>();
        ResultSet rs;
        try {
            conectar();
            String sql = "SELECT nombre FROM autor";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            rs = pre.executeQuery();
            while(rs.next()){
                ls.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar comboAutor "+e.getMessage());
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
            JOptionPane.showMessageDialog(null, "Error al sacar id genero "+e.getMessage());
        }
        return id;
    }
    
    public int sacarIdAutor(String autor) throws ClassNotFoundException{
        ResultSet rs;
        int id = 0;
        try {
            conectar();
            String sql= "SELECT idAutor FROM autor WHERE nombre=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, autor);
            rs = pre.executeQuery();
            while(rs.next()){
                id = Integer.parseInt(rs.getString("idAutor"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al sacar id autor "+e.getMessage());
        }
        return id;
    }
    
    public int sacarIdEditorial(String editorial) throws ClassNotFoundException{
        ResultSet rs;
        int id = 0;
        try {
            conectar();
            String sql= "SELECT idEditorial FROM editorial WHERE nombre=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, editorial);
            rs = pre.executeQuery();
            while(rs.next()){
                id = Integer.parseInt(rs.getString("idEditorial"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al sacar id editorial "+e.getMessage());
        }
        return id;
    }
    
    public int sacarIdTipoLibro(String tipo) throws ClassNotFoundException{
        ResultSet rs;
        int id = 0;
        try {
            conectar();
            String sql= "SELECT idTipoLibro FROM tipoLibro WHERE tipo=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, tipo);
            rs = pre.executeQuery();
            while(rs.next()){
                id = Integer.parseInt(rs.getString("idTipoLibro"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al sacar id tipo libro "+e.getMessage());
        }
        return id;
    }
    
    public void insertarLibro(Libro l) throws ClassNotFoundException{
        try {
            conectar();
            String sql ="INSERT INTO `libro`(`nombre`, `idGenero`, `anioLanzamiento`, "
                    + "`idEditorial`, `sinopsis`, `isbn`, `cantidad`, `idTipoLibro`, "
                    + "`edicion`, `costoCompra`, `costoVenta`, `idAutor`, `borradoLogico`) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,1)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, l.getNombre());
            pre.setInt(2, sacarIdGenero(l.getGenero()));
            pre.setString(3, l.getFechaLanzamiento());
            pre.setInt(4, sacarIdEditorial(l.getEditorial()));
            pre.setString(5, l.getSinopsis());
            pre.setString(6, l.getIsbn());
            pre.setInt(7, l.getCantidad());
            pre.setInt(8, sacarIdTipoLibro(l.getTipoLibro()));
            pre.setString(9, l.getEdicion());
            pre.setDouble(10, l.getCosto());
            pre.setDouble(11, l.getPrecio());
            pre.setInt(12, sacarIdAutor(l.getAutor()));
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Insertado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar libro "+e.getMessage());
        }
    }
    
    public void modificarLibro(Libro l) throws ClassNotFoundException{
        try {
            conectar();
            String sql ="UPDATE libro SET nombre=?, idGenero=?, anioLanzamiento=?, "
                    + "idEditorial=?, sinopsis=?, isbn=?, cantidad=?, idTipoLibro=?,"
                    + "edicion=?, costoCompra=?, costoVenta=?, idAutor=? WHERE idLibro=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, l.getNombre());
            pre.setInt(2, sacarIdGenero(l.getGenero()));
            pre.setString(3, l.getFechaLanzamiento());
            pre.setInt(4, sacarIdEditorial(l.getEditorial()));
            pre.setString(5, l.getSinopsis());
            pre.setString(6, l.getIsbn());
            pre.setInt(7, l.getCantidad());
            pre.setInt(8, sacarIdTipoLibro(l.getTipoLibro()));
            pre.setString(9, l.getEdicion());
            pre.setDouble(10, l.getCosto());
            pre.setDouble(11, l.getPrecio());
            pre.setInt(12, sacarIdAutor(l.getAutor()));
            pre.setInt(13, l.getIdLibro());
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modificado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar libro "+e.getMessage());
        }
    }
    
    public void eliminarLibro(Libro l) throws ClassNotFoundException{
        try {
            conectar();
            String sql ="UPDATE libro SET borradoLogico=2 WHERE idLibro=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, l.getIdLibro());
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar libro "+e.getMessage());
        }
    }
}
