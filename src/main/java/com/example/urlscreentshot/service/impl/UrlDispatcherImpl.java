package com.example.urlscreentshot.service.impl;

import com.example.urlscreentshot.model.dto.DtoConverter;
import com.example.urlscreentshot.model.dto.UrlDto;
import com.example.urlscreentshot.model.request.UrlRq;
import com.example.urlscreentshot.model.response.UrlRs;
import com.example.urlscreentshot.producer.UrlProducer;
import com.example.urlscreentshot.service.IUrlDispatcher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UrlDispatcherImpl implements IUrlDispatcher {

    private final UrlProducer urlProducer;

    @Override
    public UrlRs dispatch(UrlRq urlRq) {
        UrlDto urlDto = DtoConverter.createUrl(urlRq.getUrl());
        urlProducer.sendMessage(urlDto);

        return DtoConverter.toUrlResponse(urlDto);
    }
}
