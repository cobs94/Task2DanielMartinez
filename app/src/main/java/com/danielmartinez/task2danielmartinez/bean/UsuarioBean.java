package com.danielmartinez.task2danielmartinez.bean;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by ALUMNOS on 14/03/2017.
 */

public class UsuarioBean implements Serializable{
    public String nick, pass,pass2 ,email, nombre, apellido, imgPerfil;

    public UsuarioBean(String apellido, String email, String nick, String nombre, String pass2, String pass) {
        this.apellido = apellido;
        this.email = email;
        this.nick = nick;
        this.nombre = nombre;
        this.pass2 = pass2;
        this.pass = pass;
    }

    public UsuarioBean(UsuarioBean usuario) {
    }

    public UsuarioBean() {

    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

    public static UsuarioBean fromJson(String json){
        if(json!=null && !json.isEmpty()) {
            Gson gson = new Gson();
            return gson.fromJson(json, UsuarioBean.class);
        }else{
            return new UsuarioBean();
        }
    }

    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);

    }
}
