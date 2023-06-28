package com.neusoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//开启Spring Cloud Feign的支持功能
@EnableFeignClients
@SpringBootApplication
public class MyApplication_10300 {
	
	public static void main(String[] args) {
		SpringApplication.run(MyApplication_10300.class, args);
	}
}