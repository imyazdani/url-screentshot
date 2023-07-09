package com.example.urlscreentshot.consumer;

import com.example.urlscreentshot.model.dto.UrlDto;
import com.example.urlscreentshot.model.enums.UrlStatus;
import com.example.urlscreentshot.util.UrlUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UrlConsumer {

    @RabbitListener(queues = {"${spring.rabbitmq.template.default-receive-queue}"})
    public void consumeJsonMessage(UrlDto urlDto){
        urlDto.setStatus(UrlStatus.DOWNLOADING);
        urlDto.setTimestamp(UrlUtil.getCurrentTimestamp());

        log.info("url received -> {}", urlDto);
    }
}
