package com.rtmap.middle.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;


@EnableZuulServer
//@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.rtmap.middle.framework","com.rtmap.middle.gateway"})
public class GatewayApplicatoin {

	private static final Logger logger = LoggerFactory.getLogger(GatewayApplicatoin.class);

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplicatoin.class, args);
	}
}