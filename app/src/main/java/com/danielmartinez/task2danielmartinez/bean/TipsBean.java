package com.danielmartinez.task2danielmartinez.bean;

import java.io.Serializable;

/**
 * Created by ALUMNOS on 30/03/2017.
 */

public class TipsBean implements Serializable{
    public String nombre, descripcion;

    public TipsBean() {
    }

    public TipsBean(String descripcion, String nombre) {
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
