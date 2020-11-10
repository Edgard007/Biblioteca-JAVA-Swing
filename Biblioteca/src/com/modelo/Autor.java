/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

/**
 *
 * @author said
 */
public class Autor {
    private int idAutor;
    private String nombre;
    private String sexo;
    private int fechaNacimiento; 
    private int fechaDefuncion; 
    private String Genero;
    private String Pais;
    private int borradoLogico;

    public Autor() {
    }

    public Autor(int idAutor, String nombre, String sexo, int fechaNacimiento, int fechaDefuncion, String Genero, String Pais, int borradoLogico) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaDefuncion = fechaDefuncion;
        this.Genero = Genero;
        this.Pais = Pais;
        this.borradoLogico = borradoLogico;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(int fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getFechaDefuncion() {
        return fechaDefuncion;
    }

    public void setFechaDefuncion(int fechaDefuncion) {
        this.fechaDefuncion = fechaDefuncion;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public int getBorradoLogico() {
        return borradoLogico;
    }

    public void setBorradoLogico(int borradoLogico) {
        this.borradoLogico = borradoLogico;
    }

    
    
}
