package com.danielmartinez.task2danielmartinez;

import android.content.Context;
import android.content.SharedPreferences;

import com.danielmartinez.task2danielmartinez.bean.UsuarioBean;

/**
 * Created by ALUMNOS on 14/03/2017.
 */

public class Preferencias {
    private Context context;

    private final String PREFERENCIAS = "Preferencias";
    private final String LOGIN = "login";
    private final String USUARIO = "usuario";


    public Preferencias(Context context) {
        this.context = context;
    }

    public void setUsuario(UsuarioBean usuarioBean){
        String usuarioJson = usuarioBean.toJson();

        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCIAS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(USUARIO, usuarioJson);
        editor.commit();
    }

    public UsuarioBean getUsuario(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCIAS, Context.MODE_PRIVATE);
        String json = sharedPreferences.getString(USUARIO, "");

        return UsuarioBean.fromJson(json);
    }

    public void setLogin(boolean login){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCIAS,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(LOGIN,login);

        editor.commit();
    }

    public boolean isLogin(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCIAS, Context.MODE_PRIVATE);

        return sharedPreferences.getBoolean(LOGIN, false);
    }
}
