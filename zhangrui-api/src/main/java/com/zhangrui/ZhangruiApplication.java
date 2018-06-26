package com.zhangrui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan(basePackages = {"com.zhangrui"})
@ComponentScan(basePackages = {"com.zhangrui"})
@MapperScan("com.zhangrui.mapper")
@EnableAutoConfiguration
@EnableAsync
public class ZhangruiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ZhangruiApplication.class, args);
	}

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ZhangruiApplication.class);
    }
}
