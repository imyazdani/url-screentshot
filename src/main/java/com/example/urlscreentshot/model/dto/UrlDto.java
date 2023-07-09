package com.example.urlscreentshot.model.dto;

import com.example.urlscreentshot.model.enums.UrlStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlDto {
    private String urlId;
    private String url;
    private UrlStatus status;
    private Timestamp timestamp;
}
