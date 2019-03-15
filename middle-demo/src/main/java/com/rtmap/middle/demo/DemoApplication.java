package com.rtmap.middle.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.rtmap.middle.framework.client")
@SpringBootApplication(scanBasePackages =  {"com.rtmap.middle.framework","com.rtmap.middle.demo.server"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
