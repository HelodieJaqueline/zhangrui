package com.zhangrui.controller;

import com.google.j2objc.annotations.AutoreleasePool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: Kafka消息队列
 * @author: ZhangRui
 * @create: 2021-05-07 17:30
 **/
@RestController
@RequestMapping(value = "/kafka")
@Slf4j
public class KafkaController {


    @Autowired
    private KafkaTemplate kafkaTemplate;

    @PostMapping(value = "/send/order")
    public void sendOrder(@RequestBody String requestStr) {
        kafkaTemplate.send("create-order", requestStr);
        log.info("request{}", requestStr);
    }

    @KafkaListener(id = "order", topics = "create-order")
    public void listen(String input) {
        log.info("input value: {}" , input);
    }
}
