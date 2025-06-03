package com.zhangrui.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * Push Msg
 */
@Slf4j
@Component
public class PushMessage implements MessageListener {


    @Override
    public void onMessage(Message message, byte[] pattern) {
        log.info("receive message: {}", message);
    }
}
