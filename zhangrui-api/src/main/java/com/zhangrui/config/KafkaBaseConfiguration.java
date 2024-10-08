/*
package com.zhangrui.config;

import org.apache.kafka.clients.admin.AdminClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

*/
/**
 * @description: kafka配置
 * @author: ZhangRui
 * @create: 2021-05-07 17:24
 **//*

@Configuration
@ConditionalOnClass(KafkaAdmin.class)
@EnableConfigurationProperties(KafkaProperties.class)
public class KafkaBaseConfiguration {

    private final KafkaProperties properties;


    public KafkaBaseConfiguration(KafkaProperties properties) {
        this.properties = properties;
    }

    */
/**
     * 初始化对kafka执行操作的对象
     * @return
     *//*

    @Bean
    public KafkaAdmin kafkaAdmin() {
        KafkaAdmin admin = new KafkaAdmin(this.properties.buildProducerProperties());
        return admin;
    }

    */
/**
     * 初始化操作连接
     * @return
     *//*

    @Bean
    public AdminClient adminClient() {
        return AdminClient.create(kafkaAdmin().getConfig());
    }
}
*/
