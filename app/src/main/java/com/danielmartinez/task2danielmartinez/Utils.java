package com.danielmartinez.task2danielmartinez;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ALUMNOS on 26/01/2017.
 */
public class Utils {

    public static boolean isEmail (String email){
        String regex = "^[_a-z0-9-]+(_a-z0-9-)*@[_a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches(); //true- es email    false- no es email
    }

    public static boolean isUrl (String url){
        String regex = "^(https?://)?(([\\w!~*'().&=+$%-]+: )?[\\w!~*'().&=+$%-]+@)?(([0-9]{1,3}.){3}[0-9]{1,3}|([\\w!~*'()-]+.)*([\\w^-][\\w-]{0,61})?[\\w].[a-z]{2,6})(:[0-9]{1,4})?((/*)|(/+[\\w!~*'().;?:@&=+$,%#-]+)+/*)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches(); //true- es url    false- no es url
    }

    public static boolean isPhone (String tlf){
        String regex = "(\\+34|0034|34)?(6|7)[0-9]{8}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(tlf);
        return matcher.matches(); //true- es teléfono    false- no es teléfono
    }



}
