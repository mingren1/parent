package com.rtmap.middle.gateway.scrm.server.impl;

import com.rtmap.middle.framework.model.Result;
import com.rtmap.middle.framework.model.response.util.CommonCodeMsg;
import com.rtmap.middle.framework.model.response.util.ResponseFactory;
import com.rtmap.middle.gateway.scrm.server.GatewayConfigService;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: GatewayConfigServiceImpl
 * @Auther: wangqiang
 * @Date: 2018/11/30 20:22
 * @Version: 1.0
 * @Description:
 */
@Service
public class GatewayConfigServiceImpl implements GatewayConfigService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public final static Logger logger = LoggerFactory.getLogger(GatewayConfigServiceImpl.class);


    /**
     * @return 网关配置结果
     * @Author wangqiang
     * @Date 2018/11/30
     * @Param []
     * @Description 数据库获取网关配置信息【后续持久层做修改】
     **/
    @Override
    public Result<List<GatewayConfigServiceImpl.ZuulRouteVO>> getGatewayConfig() {
        Map<String, ZuulProperties.ZuulRoute> routes = new LinkedHashMap<>();
        List<GatewayConfigServiceImpl.ZuulRouteVO> results = jdbcTemplate.query("select * from gateway_api_config where enabled = true ", new BeanPropertyRowMapper<>(GatewayConfigServiceImpl.ZuulRouteVO.class));
        return ResponseFactory.build(CommonCodeMsg.SUCCESS, "查询数据库成功", results);
    }

    @Setter
    @Getter
    public static class ZuulRouteVO {
        /**
         * 主键
         */
        private String id;

        /**
         * The path (pattern) for the route, e.g. /foo/**.
         */
        private String path;

        /**
         * The service ID (if any) to map to this route. You can specify a physical URL or
         * a service, but not both.
         */
        private String serviceId;

        /**
         * A full physical URL to map to the route. An alternative is to use a service ID
         * and service discovery to find the physical address.
         */
        private String url;

        /**
         * Flag to determine whether the prefix for this route (the path, minus pattern
         * patcher) should be stripped before forwarding.
         */
        private boolean stripPrefix = true;

        /**
         * Flag to indicate that this route should be retryable (if supported). Generally
         * retry requires a service ID and ribbon.
         */
        private Boolean retryable;

        //是否可用
        private Boolean enabled;

        //主体编码
        private Long tenantId;
        //主体类型
        private Integer tenantType;
        //主体名称
        private String tenantName;

    }
}
