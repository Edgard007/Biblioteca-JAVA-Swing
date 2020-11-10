
package com.dao;

import com.conexion.Conexion;
import com.modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *Nombre de la Clase: DaoEmpleado
 * Fecha: 18-08-19
 * Version:1.0
 * Copyright: ITCA-FEPADE
 * @author Francisco Hernandez
 */

public class DaoEmpleado extends Conexion{
    
    
     public List<Empleado> mostrarEmp() throws Exception
    {
        ResultSet rs;
        List<Empleado>lst=new ArrayList();
        
        try 
        {
         conectar();
         String sql="SELECT empleado.idEmpleado,empleado.nombre,empleado.apellido,empleado.direccion,empleado.dui,empleado.nit,empleado.afp,empleado.isss,usuarios.id,usuarios.usuario,correo,password\n" +
            "AS usuarios, tipo_usuario.nombre AS tipo_usuario\n" +
            "FROM empleado JOIN usuarios\n" +
            "ON usuarios.id = empleado.idUsuario\n" +
            "JOIN tipo_usuario ON tipo_Usuario.id = usuarios.id_tipo where empleado.borradoLogico=1";
         PreparedStatement pre=this.getCon().prepareStatement(sql);
         rs=pre.executeQuery();
         while(rs.next())
         {
             Empleado emp=new Empleado();
             emp.setIdEmpleado(rs.getInt("idEmpleado"));
             emp.setNombre(rs.getString("nombre"));
             emp.setApellido(rs.getString("apellido"));
             emp.setDireccion(rs.getString("direccion"));
             emp.setDui(rs.getString("dui"));
             emp.setNit(rs.getString("nit"));
             emp.setAfp(rs.getString("afp"));
             emp.setIsss(rs.getString("isss"));
             emp.setIdUsuario(rs.getString("usuario"));
             emp.setCorreo(rs.getString("correo"));
             emp.setPass(rs.getString("usuarios"));
             emp.setTipoUser(rs.getString("tipo_usuario"));
             lst.add(emp);
         }
            
        } catch (Exception e) 
        {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        
        return lst;
    
    }
     
     public  ArrayList<String> cargarCombo(){
        ArrayList<String> ls = new ArrayList<String>();
        ResultSet rs;
        try {
            String sql = "select nombre from tipo_usuario where id=2";
            this.conectar();
            PreparedStatement pre = getCon().prepareStatement(sql);
            rs= pre.executeQuery();
            while(rs.next()){
                ls.add(rs.getString("nombre"));
            }
        } catch (Exception e) {
        }
        return ls;
    }
         
     
     public int sacarIdUser(String user){
         ResultSet rs2;
            int idUser=0;
            try {
             String sql2 = "SELECT id FROM usuarios WHERE usuario=?";
            PreparedStatement pre2 = this.getCon().prepareStatement(sql2);
            pre2.setString(1, user);
            rs2 = pre2.executeQuery();
            while(rs2.next()){
                idUser= rs2.getInt("id");
            }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
         }
            return idUser;
     }
  
     public void insertarEmp(Empleado emp) throws ClassNotFoundException
    {
        try 
        {
            this.conectar();
            String sql="insert into usuarios(usuario,password,correo,id_tipo, borradoLogico) values(?,?,?,2,1);";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(1,emp.getUsuario());
            pre.setString(2, emp.getPass());
            pre.setString(3, emp.getCorreo());
            pre.executeUpdate();  
            
            
            
            String sql3 = "INSERT INTO empleado(nombre, apellido, direccion, dui, nit, afp, isss, idUsuario, borradoLogico) VALUES(?,?,?,?,?,?,?,?,1)";
            PreparedStatement pre3 = this.getCon().prepareStatement(sql3);
            pre3.setString(1, emp.getNombre());
            pre3.setString(2, emp.getApellido());
            pre3.setString(3, emp.getDireccion());
            pre3.setString(4, emp.getDui());
            pre3.setString(5, emp.getNit());
            pre3.setString(6, emp.getAfp());
            pre3.setString(7, emp.getIsss());
            pre3.setInt(8, sacarIdUser(emp.getUsuario()));
            pre3.executeUpdate(); 
            
            JOptionPane.showMessageDialog(null, "Insertado correctamente");
        } catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Error al Insertar "+e);
        }
        finally
        {
            this.desconectar();
        }        
    }
     
     public void modificarEmp(Empleado emp) throws ClassNotFoundException
    {
        try 
        {
            this.conectar();
            String sql="UPDATE usuarios SET usuario=?,password=?,correo=? WHERE id=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(1,emp.getUsuario());
            pre.setString(2, emp.getPass());
            pre.setString(3, emp.getCorreo());
            pre.setInt(4, sacarIdUser(emp.getUsuario()));
            pre.executeUpdate();
            
            
            
            String sql3 = "UPDATE empleado SET nombre=?, apellido=?, direccion=?, dui=?, nit=?, afp=?, isss=?, idUsuario=? WHERE idEmpleado=?";
            PreparedStatement pre3 = this.getCon().prepareStatement(sql3);
            pre3.setString(1, emp.getNombre());
            pre3.setString(2, emp.getApellido());
            pre3.setString(3, emp.getDireccion());
            pre3.setString(4, emp.getDui());
            pre3.setString(5, emp.getNit());
            pre3.setString(6, emp.getAfp());
            pre3.setString(7, emp.getIsss());
            pre3.setInt(8, sacarIdUser(emp.getUsuario()));
            pre3.setInt(9, emp.getIdEmpleado());
            pre3.executeUpdate(); 
            
            JOptionPane.showMessageDialog(null, "Modificado correctamente");
        } catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Error al modificar "+e);
        }
        finally
        {
            this.desconectar();
        }        
    }
     
      
   public void eliminarEmp(Empleado emp) throws ClassNotFoundException
    {
        try 
        {
            this.conectar();
            String sql="UPDATE usuarios SET borradoLogico=2 WHERE id=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, sacarIdUser(emp.getUsuario()));
            pre.executeUpdate();
            
            
            
            String sql3 = "UPDATE empleado SET borradoLogico=2 WHERE idEmpleado=?";
            PreparedStatement pre3 = this.getCon().prepareStatement(sql3);
            pre3.setInt(1, emp.getIdEmpleado());
            pre3.executeUpdate(); 
            
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        } catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Error al eliminar "+e);
        }
        finally
        {
            this.desconectar();
        }        
    }
    public int existeUsuario(String usuario) throws ClassNotFoundException {
        ResultSet rs = null;

        String sql = "SELECT count(id) FROM usuarios WHERE usuario = ?";

        try {
            conectar();
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, usuario);
            rs = pre.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

            return 1;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return 1;
        } 
    }
    
    
    public boolean esEmail(String correo) {

        // Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(correo);

        return mather.find();

    }
}
