
package com.zhangrui.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import javax.annotation.Resource;


/**
 * Redis Subscriber
 * @author zhangrui
 */

@Configuration
public class SubscriberConfig {

    public static final String REDIS_CHANNEL = "ai:agent";


    @Resource
    private PushMessage pushMessage;

    @Bean
    RedisMessageListenerContainer writingEventListenerContainer(
            RedisConnectionFactory redisConnectionFactory) {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        redisMessageListenerContainer.addMessageListener(pushMessage, new ChannelTopic(REDIS_CHANNEL));
        return redisMessageListenerContainer;
    }

}
