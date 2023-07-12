package com.example.urlscreentshot.consumer;

import com.example.urlscreentshot.model.dto.UrlDto;
import com.example.urlscreentshot.model.enums.UrlStatus;
import com.example.urlscreentshot.service.IScreenshot;
import com.example.urlscreentshot.util.UrlUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class UrlConsumer {

    private final UrlUtil urlUtil;
    private final IScreenshot screenshot;

    @RabbitListener(queues = {"${spring.rabbitmq.template.default-receive-queue}"})
    public void consumeJsonMessage(UrlDto urlDto){
        urlDto.setStatus(UrlStatus.DOWNLOADING);
        urlDto.setTimestamp(urlUtil.getCurrentTimestamp());

        log.info("url received -> {}", urlDto);

        try {
            screenshot.takeScreenshot(urlDto);
            urlDto.setStatus(UrlStatus.DONE);
            log.info("Url is taken screenshot: {}", urlDto);


        } catch (IOException e) {
            urlDto.setStatus(UrlStatus.FAILED);
            log.info("Screenshot of the url has failed: {}", urlDto);

            log.error("Screenshot is failed: ", e);
        }

    }
}
