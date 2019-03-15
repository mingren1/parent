package com.rtmap.middle.registed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName: Application
 * @Auther: wangqiang
 * @Date: 2018/11/2 22:00
 * @Description:注册中心启动类
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class RegApplication {

    private final static Logger logger = LoggerFactory.getLogger(RegApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(RegApplication.class, args);
//        Scanner scan = new Scanner(System.in);
//        String profiles = scan.nextLine();
//        new SpringApplicationBuilder(RegApplication.class).profiles(profiles).run(args);
        logger.info("SpringBoot Start Success");
    }
}
