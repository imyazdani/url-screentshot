package com.example.urlscreentshot.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;

@Component
@Slf4j
public class UrlUtil {

    @Value("${app.storage-path}")
    private String storagePath;

    public String convertToSha256(String str){
        return DigestUtils.sha256Hex(str);
    }

    public Timestamp getCurrentTimestamp(){
        return new Timestamp(System.currentTimeMillis());
    }

    public Resource getFileAsResource(String urlId){
        try {
            Path dirPath = Paths.get(storagePath);

            Path foundFile = Files.list(dirPath).filter(file -> file.getFileName().toString().startsWith(urlId))
                    .findFirst().orElse(null);

            if (foundFile != null) {
                return new UrlResource(foundFile.toUri());
            }
        } catch (IOException e) {
            log.error("Getting an error to access a resource: ", e);
        }
        return null;
    }
}
