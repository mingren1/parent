package com.rtmap.middle.gateway.scrm;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
/**
 * @ClassName: TestScrm
 * @Auther: wangqiang
 * @Date: 2018/11/29 11:44
 * @Version: 1.0
 * @Description:泛会员 网关测试
 */
@Controller
@Configuration
public class TestScrm {

    @Bean
    @LoadBalanced
    public static RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public static String router() {
        RestTemplate tpl = getRestTemplate();
        String json = tpl.getForObject("http://demo/maApp//D/app/activity/shop/list?activityId=A0517eUCj", String.class);
        System.out.println(json);
        return json;
    }

    public void testEureka(String[] args) {
        for (int i=0;i<10;i++){
            router();
        }
    }
}
