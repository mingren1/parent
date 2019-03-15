package com.rtmap.middle.gateway.scrm.server;

import com.rtmap.middle.framework.model.Result;
import com.rtmap.middle.gateway.scrm.server.impl.GatewayConfigServiceImpl;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: GatewayConfigService
 * @Auther: wangqiang
 * @Date: 2018/11/30 20:22
 * @Version: 1.0
 * @Description:
 */
public interface GatewayConfigService {
    public Result<List<GatewayConfigServiceImpl.ZuulRouteVO>> getGatewayConfig();
}
