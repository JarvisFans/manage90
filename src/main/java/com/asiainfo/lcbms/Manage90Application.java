package com.asiainfo.lcbms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Manage90Application {

	public static void main(String[] args) {
		SpringApplication.run(Manage90Application.class, args);
	}

}
