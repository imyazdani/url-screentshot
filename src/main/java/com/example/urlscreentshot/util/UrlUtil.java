package com.example.urlscreentshot.util;

import org.apache.commons.codec.digest.DigestUtils;

public class UrlUtil {

    public static String convertToSha256(String str){
        return DigestUtils.sha256Hex(str);
    }
}
