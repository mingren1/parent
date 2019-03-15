package com.rtmap.middle.third;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.rtmap.middle.framework.client","com.rtmap.middle.third.server"})
@SpringBootApplication(scanBasePackages = {"com.rtmap.middle.framework","com.rtmap.middle.third.server"})
public class ThirdApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirdApplication.class, args);
	}
}
