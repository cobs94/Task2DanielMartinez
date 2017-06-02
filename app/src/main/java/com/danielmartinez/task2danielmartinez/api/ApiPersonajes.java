package com.danielmartinez.task2danielmartinez.api;

import com.danielmartinez.task2danielmartinez.bean.PersonajeBean;
import com.danielmartinez.task2danielmartinez.bean.ResponsePersonaje;
import com.danielmartinez.task2danielmartinez.bean.ResponsePersonajes;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ALUMNOS on 16/05/2017.
 */

public class ApiPersonajes {
    private final String URL = "http://danielmartinezsanz.esy.es/APIandroid/personajes/";
    private OkHttpClient client;

    public ApiPersonajes() {
        client = new OkHttpClient();
    }

    public ArrayList<PersonajeBean> getPersonajes(){
        try {
            Request request = new Request.Builder().url(URL).build();
            Response response = client.newCall(request).execute();

            String json = response.body().string();
            ResponsePersonajes responsePersonajes = ResponsePersonajes.fromJson(json);
            return responsePersonajes.getPersonajes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public PersonajeBean getPersonaje (String idPersonaje){
        try {
            Request request = new Request.Builder().url(URL+idPersonaje).build();
            Response response = client.newCall(request).execute();

            String json = response.body().string();
            ResponsePersonaje responsePersonaje = ResponsePersonaje.fromJson(json);
            return responsePersonaje.getPersonaje();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
