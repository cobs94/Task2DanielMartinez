package com.danielmartinez.task2danielmartinez.bean;

import java.io.Serializable;

/**
 * Created by ALUMNOS on 30/03/2017.
 */

public class TipsBean implements Serializable{
    public String nombre, descripcion, foto;

    public TipsBean() {
    }

    public TipsBean(String descripcion, String foto, String nombre) {
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
