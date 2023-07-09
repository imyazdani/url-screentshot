package com.example.urlscreentshot.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Timestamp;

public class UrlUtil {

    public static String convertToSha256(String str){
        return DigestUtils.sha256Hex(str);
    }

    public static Timestamp getCurrentTimestamp(){
        return new Timestamp(System.currentTimeMillis());
    }
}
