package com.example.urlscreentshot.model.dto;

import com.example.urlscreentshot.model.enums.UrlStatus;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class UrlDto {
    private String urlId;
    private String url;
    private UrlStatus status;
    private Instant timestamp;
}
