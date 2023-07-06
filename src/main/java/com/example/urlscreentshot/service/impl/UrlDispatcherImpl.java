package com.example.urlscreentshot.service.impl;

import com.example.urlscreentshot.model.request.UrlRq;
import com.example.urlscreentshot.model.response.UrlRs;
import com.example.urlscreentshot.service.UrlDispatcher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UrlDispatcherImpl implements UrlDispatcher {
    @Override
    public UrlRs dispatch(UrlRq urlRq) {
        return null;
    }
}
