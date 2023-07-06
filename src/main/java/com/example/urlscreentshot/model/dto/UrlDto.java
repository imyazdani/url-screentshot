package com.example.urlscreentshot.model.dto;

import com.example.urlscreentshot.model.enums.UrlStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UrlDto {
    private Long id;
    private String urlId;
    private String url;
    private UrlStatus status;
}
