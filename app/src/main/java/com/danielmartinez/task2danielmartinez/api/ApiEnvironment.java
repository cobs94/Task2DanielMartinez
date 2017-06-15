package com.danielmartinez.task2danielmartinez.api;

import com.danielmartinez.task2danielmartinez.BuildConfig;

/**
 * Created by ALUMNOS on 15/06/2017.
 */

public class ApiEnvironment {
    private static final int DEV=0;
    private static final int PRO=1;

    private static final String URL_BASE_DEV="url";
    private static final String URL_BASE_PRO="url";

    public static String GetUsuario(){
        switch (BuildConfig.ENVIRONMENT) {
            case DEV:
                return URL_BASE_DEV+"/usuarios/";
            case PRO:
                return URL_BASE_PRO+"/usuarios/";
        }
        return URL_BASE_DEV+"/usuarios/";
    }
}
