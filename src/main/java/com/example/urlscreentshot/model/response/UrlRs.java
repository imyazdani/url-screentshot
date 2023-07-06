package com.example.urlscreentshot.model.response;

import com.example.urlscreentshot.model.enums.UrlStatus;
import lombok.Data;

@Data
public class UrlRs {
    private String urlId;
    private String url;
    private UrlStatus status;
}
