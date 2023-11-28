package com.quiz.app.utility;

import java.util.Base64;

public class ServiceHelper {

    public static String decode(String base64String){
        byte[] decodedBytes = Base64.getDecoder().decode(base64String);
        return new String(decodedBytes);
    }
}
