package com.rtmap.middle.gateway.controller;

import com.rtmap.middle.framework.annotation.ResponseResult;
import com.rtmap.middle.framework.model.Result;
import com.rtmap.middle.framework.model.response.util.CommonCodeMsg;
import com.rtmap.middle.framework.model.response.util.ResponseFactory;
import com.rtmap.middle.gateway.config.route.RefreshRouteService;
import com.rtmap.middle.gateway.config.util.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName: IndexController
 * @Auther: wangqiang
 * @Date: 2018/11/30 21:00
 * @Version: 1.0
 * @Description:
 */
@ResponseResult
@RestControllerAdvice
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private CacheUtil cacheUtil;

    @Autowired
    private RefreshRouteService refreshRouteService;

    @GetMapping("/refresh")
    public Result refeshCache() {
        //刷新redis缓存：mysql--->redis
        cacheUtil.refreshGatewayConfigCache();
        //刷新配置文件到路由
        refreshRouteService.refreshRoute();
        return ResponseFactory.build(CommonCodeMsg.SUCCESS, "刷新缓存及路由成功");
    }


    /**
     * 加载所有可配置的路由规则
     * @return
     */
    @RequestMapping(value = "/routes",method = RequestMethod.GET)
    public String listRoutes(){
        return cacheUtil.getGatewayConfigCache().toString();
    }


}
