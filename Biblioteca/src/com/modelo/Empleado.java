
package com.modelo;

/**
 *Nombre de la Clase: Empleado
 * Fecha: 04-09-19
 * Version:1.0
 * Copyright: ITCA-FEPADE
 * @author Francisco Hernandez
 */

public class Empleado {
    
    private int idEmpleado;
    private String nombre;
    private String apellido;
    private String direccion;
    private String dui;
    private String nit;
    private String afp;
    private String isss;
    private String idUsuario;
    private int borradoLogico;
    private String usuario;
    private String pass;
    private String correo;
    private int borradoLogicoUser;
    private String tipoUser;
    

    public Empleado() {
    }

    public Empleado(int idEmpleado, String nombre, String apellido, String direccion, String dui, String nit, String afp, String isss, String idUsuario, int borradoLogico, String usuario, String pass, String correo, int borradoLogicoUser, String tipoUser) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dui = dui;
        this.nit = nit;
        this.afp = afp;
        this.isss = isss;
        this.idUsuario = idUsuario;
        this.borradoLogico = borradoLogico;
        this.usuario = usuario;
        this.pass = pass;
        this.correo = correo;
        this.borradoLogicoUser = borradoLogicoUser;
        this.tipoUser = tipoUser;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        this.afp = afp;
    }

    public String getIsss() {
        return isss;
    }

    public void setIsss(String isss) {
        this.isss = isss;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getBorradoLogico() {
        return borradoLogico;
    }

    public void setBorradoLogico(int borradoLogico) {
        this.borradoLogico = borradoLogico;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getBorradoLogicoUser() {
        return borradoLogicoUser;
    }

    public void setBorradoLogicoUser(int borradoLogicoUser) {
        this.borradoLogicoUser = borradoLogicoUser;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

   
    
}
