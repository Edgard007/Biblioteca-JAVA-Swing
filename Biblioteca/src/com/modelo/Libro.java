
package com.modelo;

/**
 * Nombre de la clase: Libro
 * Fecha: 01-09-2019
 * Version: 1.0
 * Copyright: Denis Valladares
 * @author Denis Valladares
 */
public class Libro {
    private int idLibro;
    private String nombre;
    private String fechaLanzamiento;
    private String sinopsis;
    private String isbn;
    private int cantidad;
    private String genero;
    private String tipoLibro;
    private String edicion;
    private double costo;
    private double precio;
    private String editorial;
    private String autor;

    public Libro() {
    }

    public Libro(int idLibro, String nombre, String fechaLanzamiento, String sinopsis, String isbn, int cantidad, String genero, String tipoLibro, String edicion, double costo, double precio, String editorial, String autor) {
        this.idLibro = idLibro;
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.sinopsis = sinopsis;
        this.isbn = isbn;
        this.cantidad = cantidad;
        this.genero = genero;
        this.tipoLibro = tipoLibro;
        this.edicion = edicion;
        this.costo = costo;
        this.precio = precio;
        this.editorial = editorial;
        this.autor = autor;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipoLibro() {
        return tipoLibro;
    }

    public void setTipoLibro(String tipoLibro) {
        this.tipoLibro = tipoLibro;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    
       
}
