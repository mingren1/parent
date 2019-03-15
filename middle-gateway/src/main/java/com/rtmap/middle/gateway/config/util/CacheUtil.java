package com.rtmap.middle.gateway.config.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.rtmap.middle.framework.model.Result;
import com.rtmap.middle.framework.utils.JedisWrapper;
import com.rtmap.middle.gateway.scrm.server.GatewayConfigService;
import com.rtmap.middle.gateway.scrm.server.impl.GatewayConfigServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: CacheUtil
 * @Auther: wangqiang
 * @Date: 2018/11/30 20:14
 * @Version: 1.0
 * @Description:缓存工具类
 */
@Component
public class CacheUtil {

    public static final String GATE_API_CONFIG_KEY = "middle:config:api";

    public static final String GATE_API_CONFIG_TENANT_KEY = "middle:config:api:tenant";

    public static final String GATE_API_CONFIG_TENANT_FIELD= "middle:config:api:tenant_%s_%s";


    public final static Logger logger = LoggerFactory.getLogger(CacheUtil.class);

    @Autowired
    private JedisWrapper jedisWrapper;

    @Autowired
    private GatewayConfigService gatewayConfigService;

    public void refreshGatewayConfigCache() {
        Result<List<GatewayConfigServiceImpl.ZuulRouteVO>> dbList = gatewayConfigService.getGatewayConfig();
        List<GatewayConfigServiceImpl.ZuulRouteVO> listData = dbList.getData();
        logger.info("获取数据库配置数据到缓存中，routeData：{}", listData);
        if (listData != null && listData.size() > 0) {
            Map<String, ZuulProperties.ZuulRoute> routes = new LinkedHashMap<>();
            for (GatewayConfigServiceImpl.ZuulRouteVO result : listData) {
                if (org.apache.commons.lang3.StringUtils.isBlank(result.getPath()) && org.apache.commons.lang3.StringUtils.isBlank(result.getUrl()) && org.apache.commons.lang3.StringUtils.isBlank(result.getServiceId())) {
                    continue;
                }
                ZuulProperties.ZuulRoute zuulRoute = new ZuulProperties.ZuulRoute();
                try {
                    org.springframework.beans.BeanUtils.copyProperties(result, zuulRoute);
                } catch (Exception e) {
                    logger.error("=============load zuul route error==============", e);
                }
                routes.put(zuulRoute.getPath(), zuulRoute);
            }
            JSONObject jsonObject = (JSONObject) JSON.toJSON(routes);
            //缓存整体对象（路由使用）
            if (jedisWrapper.exists(GATE_API_CONFIG_KEY)) {
                jedisWrapper.set(GATE_API_CONFIG_KEY, jsonObject.toString());
            }
            //缓存tenantId_tenantType 为Key,  server_id为value 的值
            listData.forEach((GatewayConfigServiceImpl.ZuulRouteVO vo) -> {
                if (vo.getTenantType() != null && vo.getTenantId() != null) {
                    String tenantKey = String.format(GATE_API_CONFIG_TENANT_FIELD, vo.getTenantType(), vo.getTenantId());
                    jedisWrapper.hset(GATE_API_CONFIG_TENANT_KEY, tenantKey, vo.getServiceId());
                    logger.info("插入 tenantKey {} 值为 {}", tenantKey, vo.getServiceId());
                }
            });

        } else {
            if (jedisWrapper.exists(GATE_API_CONFIG_KEY)) {
                //清空缓存
                jedisWrapper.del(GATE_API_CONFIG_KEY);
            }
            if (jedisWrapper.exists(GATE_API_CONFIG_TENANT_KEY)) {
                jedisWrapper.hdel(GATE_API_CONFIG_TENANT_KEY);
            }
        }
    }

    /**
     * @return 路由
     * @Author wangqiang
     * @Date 2018/12/4
     * @Param []
     * @Description 缓存获取路由信息
     **/
    public Map<String, ZuulProperties.ZuulRoute> getGatewayConfigCache() {
        Map<String, ZuulProperties.ZuulRoute> result = null;
        if (jedisWrapper.exists(GATE_API_CONFIG_KEY)) {
            String gatewayConfig = jedisWrapper.get(GATE_API_CONFIG_KEY);
            if (StringUtils.isNotBlank(gatewayConfig)) {
                result = JSONObject.parseObject(gatewayConfig, new TypeReference<Map<String, ZuulProperties.ZuulRoute>>() {
                });
            }
        }
        return result;
    }

    /**
     * @return 服务ID
     * @Author wangqiang
     * @Date 2018/12/4
     * @Param [tenantType, tenantId]
     * @Description tenantType【主体类型】 tenantId 【主体编码】
     **/
    public String getServerId(Integer tenantType, Long tenantId) {
        String result = "";
        if (jedisWrapper.exists(GATE_API_CONFIG_TENANT_KEY)) {
            String tenantKey = String.format(GATE_API_CONFIG_TENANT_FIELD, tenantType, tenantId);
            result = jedisWrapper.hget(GATE_API_CONFIG_TENANT_KEY, tenantKey);
            logger.info("获取到 tenantKey {} 值为 {}", tenantKey, result);
        }
        return result;
    }
}
