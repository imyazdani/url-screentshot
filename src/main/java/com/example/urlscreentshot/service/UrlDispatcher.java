package com.example.urlscreentshot.service;

import com.example.urlscreentshot.model.request.UrlRq;
import com.example.urlscreentshot.model.response.UrlRs;

public interface UrlDispatcher {
    UrlRs dispatch(UrlRq urlRq);
}