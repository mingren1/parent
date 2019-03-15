package com.rtmap.middle.gateway.config.filter;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.rtmap.middle.gateway.config.util.CacheUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @ClassName: Filter
 * @Auther: wangqiang
 * @Date: 2018/11/30 17:25
 * @Version: 1.0
 * @Description:
 */
public class ScrmFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(ScrmFilter.class);
    @Value("${middle.third.serverId}")
    private String thirdServerId;

    @Autowired
    private CacheUtil cacheUtil;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }


    @Override
    public int filterOrder() {
        log.info("filterOrder ");
        return 0;
    }


    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        log.info("run");
        // 获取到request
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        // 获取请求参数name
        Long tenantId = null;
        Integer tenantType = null;
        try {
            // 请求方法
            String method = request.getMethod();
            log.info(String.format("%s >>> %s>>> %s", method, request.getRequestURL().toString(), request.getRequestURI().toString()));
            // 获取请求的输入流
            InputStream in = request.getInputStream();
            String body = StreamUtils.copyToString(in, Charset.forName("UTF-8"));
            // 如果body为空初始化为空json
            if (StringUtils.isBlank(body)) {
                body = "{}";
            }
            log.info("body" + body);
            // 转化成json
            JSONObject json = JSONObject.parseObject(body);
            // get方法和post、put方法处理方式不同
            if (StringUtils.isNotBlank(request.getParameter("tenantId"))&& StringUtils.isNotBlank(request.getParameter("tenantType"))) {
                tenantId = Long.parseLong(request.getParameter("tenantId"));
                tenantType=Integer.parseInt(request.getParameter("tenantType"));
                log.info("当前请求的参数 tenantId:{}  tenantType:{}", tenantId, tenantType);
                RequestContext context = RequestContext.getCurrentContext();
                Object originalRequestPath = request.getRequestURI();
                String modifiedRequestPath = exChangeUrl(originalRequestPath.toString(), tenantId, tenantType);
                log.info("请求前地址为：{} 匹配规则后 地址为：{}", originalRequestPath, modifiedRequestPath);
//                context.put(FilterConstants.REQUEST_URI_KEY, modifiedRequestPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * @Author wangqiang
     * @Date 2018/12/3
     * @Param [orgUrl, tenantId, tenantType]
     * @return java.lang.String
     * @Description 转换后的规则
     **/
    private String exChangeUrl(String orgUrl, Long tenantId, Integer tenantType) {
        StringBuffer result = new StringBuffer();
        if (tenantId != null && tenantType != null) {
            //判断当前服务是否被
            String serverId = cacheUtil.getServerId(tenantType, tenantId);
            if (StringUtils.isNotBlank(serverId)) {
                //路由分发到对应serverId 微服务中
                result.append("/"+serverId+"/");
            } else {
                //当前没有对应微服务，统一转发到 third服务执行
                result.append("/"+thirdServerId+"/");
            }
        }
        //替换原有gateway 参数
        orgUrl = orgUrl.substring(orgUrl.split("/")[1].length() + 2, orgUrl.length());
        result.append(orgUrl);
        return result.toString();
    }
}
