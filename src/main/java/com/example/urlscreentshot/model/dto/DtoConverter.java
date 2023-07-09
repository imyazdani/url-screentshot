package com.example.urlscreentshot.model.dto;

import com.example.urlscreentshot.model.enums.UrlStatus;
import com.example.urlscreentshot.util.UrlUtil;
import lombok.Data;

import java.time.Instant;

@Data
public class DtoConverter {

    public static UrlDto createUrl(String url){
        return new UrlDto(UrlUtil.convertToSha256(url), url, UrlStatus.PENDING, Instant.now());
    }
}
