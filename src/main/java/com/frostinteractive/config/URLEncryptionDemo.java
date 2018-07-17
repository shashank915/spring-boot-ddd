package com.frostinteractive.config;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URLEncryptionDemo {
    public static void main(String[] args) throws Exception{
        String simpleUrlStr = "Shashank";

        String encryptedStr = URLEncoder.encode(simpleUrlStr,StandardCharsets.UTF_8.name());
        System.out.println(simpleUrlStr);
        System.out.println(encryptedStr);
    }
}
