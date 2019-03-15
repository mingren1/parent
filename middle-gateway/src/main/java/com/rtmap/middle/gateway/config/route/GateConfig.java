package com.rtmap.middle.gateway.config.route;

import com.rtmap.middle.gateway.config.filter.ScrmFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: GateConfig
 * @Auther: wangqiang
 * @Date: 2018/11/30 23:58
 * @Version: 1.0
 * @Description:
 */
@Configuration
public class GateConfig {

    @Autowired
    ServerProperties server;
    @Autowired
    ZuulProperties zuulProperties;
//    @Bean
//    public ScrmRouteLocator routeLocator() {
//        ScrmRouteLocator routeLocator = new ScrmRouteLocator(this.server.getServlet().getServletPrefix(), this.zuulProperties);
//        return routeLocator;
//    }

//    @Bean
//    public ScrmFilter scrmFilter() {
//        return  new ScrmFilter();
//    }
}
