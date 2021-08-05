package com.enerjisa.enframework.helpers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.regex.Pattern;


@SuppressWarnings("unused")
public class ENStringHelpers {

    public static String getAsJson(Object object) {

        return new Gson().toJson(object);
    }

    public static String getAsJsonWithFormat(Object object) {

        Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();

        return gson.toJson(object);
    }

    public static boolean isEmpty(String text) {

        return text == null || text.trim().equals("");
    }

    public static boolean isFilled(String text) {

        return !isEmpty(text);
    }

    public static boolean isValidMail(String mail) {

        return Pattern.compile(".+@.+\\.[a-z]+").matcher(mail).matches();
    }
}
