package com.example.urlscreentshot.producer;

import com.example.urlscreentshot.model.dto.UrlDto;
import com.example.urlscreentshot.service.IScreenshot;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UrlProducer {
    @Value("${spring.rabbitmq.template.exchange}")
    private String exchangeName;    private final IScreenshot screenshot;


    @Value("${spring.rabbitmq.template.routing-key}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(UrlDto urlDto){
        rabbitTemplate.convertAndSend(exchangeName, routingKey, urlDto);
        log.info("url sent -> {}", urlDto);
    }
}
