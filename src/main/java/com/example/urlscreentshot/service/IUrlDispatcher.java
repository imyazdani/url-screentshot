package com.example.urlscreentshot.service;

import com.example.urlscreentshot.model.request.UrlRq;
import com.example.urlscreentshot.model.response.UrlRs;
import org.springframework.http.ResponseEntity;

public interface IUrlDispatcher {
    UrlRs dispatch(UrlRq urlRq);

    ResponseEntity<?> getImage(String urlId);
}
