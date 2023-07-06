package com.example.urlscreentshot.model.entity;

import com.example.urlscreentshot.model.enums.UrlStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UrlEntity {
    private Long id;
    private String urlId;
    private String url;
    private UrlStatus status;
}
