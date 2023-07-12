package com.example.urlscreentshot.service;

import com.example.urlscreentshot.model.dto.UrlDto;

import java.io.IOException;

public interface IScreenshot {
    void takeScreenshot(UrlDto urlDto) throws IOException;
}
