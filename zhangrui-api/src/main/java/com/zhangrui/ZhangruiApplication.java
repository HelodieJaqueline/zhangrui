package com.zhangrui;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.zhangrui.repository.mapper.*")
@EnableAsync
@Slf4j
public class ZhangruiApplication{

	public static void main(String[] args) {
		SpringApplication.run(ZhangruiApplication.class);
	}

}
