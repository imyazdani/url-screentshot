package com.example.urlscreentshot.controller;

import com.example.urlscreentshot.model.request.UrlRq;
import com.example.urlscreentshot.model.response.UrlRs;
import com.example.urlscreentshot.service.IUrlDispatcher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/url")
public class UrlController {

    private final IUrlDispatcher urlDispatcher;

    @PostMapping()
    public ResponseEntity<UrlRs> register(@RequestBody UrlRq urlRq) {
        return ResponseEntity.ok(urlDispatcher.dispatch(urlRq));
    }
}
