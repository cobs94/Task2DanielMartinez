package com.danielmartinez.task2danielmartinez.bean;

import java.io.Serializable;

/**
 * Created by ALUMNOS on 30/03/2017.
 */

public class PersonajeBean implements Serializable{
    public String nombre, descripcion;
    public int foto;

    public PersonajeBean() {
    }

    public PersonajeBean(String descripcion, int foto, String nombre) {
        this.descripcion = descripcion;
        this.foto = foto;
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
