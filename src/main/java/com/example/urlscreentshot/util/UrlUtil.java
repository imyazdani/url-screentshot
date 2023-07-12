package com.example.urlscreentshot.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class UrlUtil {

    public String convertToSha256(String str){
        return DigestUtils.sha256Hex(str);
    }

    public Timestamp getCurrentTimestamp(){
        return new Timestamp(System.currentTimeMillis());
    }
}
