package com.example.urlscreentshot.service.impl;

import com.example.urlscreentshot.model.dto.DtoConverter;
import com.example.urlscreentshot.model.dto.UrlDto;
import com.example.urlscreentshot.model.request.UrlRq;
import com.example.urlscreentshot.model.response.UrlRs;
import com.example.urlscreentshot.producer.UrlProducer;
import com.example.urlscreentshot.service.IUrlDispatcher;
import com.example.urlscreentshot.util.UrlUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UrlDispatcherImpl implements IUrlDispatcher {

    private final UrlProducer urlProducer;
    private final DtoConverter dtoConverter;
    private final UrlUtil urlUtil;

    @Override
    public UrlRs dispatch(UrlRq urlRq) {
        UrlDto urlDto = dtoConverter.createUrl(urlRq.getUrl());
        urlProducer.sendMessage(urlDto);

        return dtoConverter.toUrlResponse(urlDto);
    }

    @Override
    public ResponseEntity<?> getImage(String urlId){

        Resource resource = urlUtil.getFileAsResource(urlId);
        if(resource == null){
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }

        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }
}
