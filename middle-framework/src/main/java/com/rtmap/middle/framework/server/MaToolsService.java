package com.rtmap.middle.framework.server;


import com.rtmap.middle.framework.client.FeignClientConfiguration;
import com.rtmap.middle.framework.client.fallback.MaToolsClientFallback;
import com.rtmap.middle.framework.model.Result;
import com.rtmap.middle.framework.model.response.tbox.WxAccessTokenDTO;
import com.rtmap.middle.framework.model.response.tbox.WxAppinfoVO;
import com.rtmap.middle.framework.model.response.tbox.WxChannelDetailVO;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController("/maTools")
public interface MaToolsService {
    /**
     * 根据id获取渠道详情
     * <p>
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11933821
     */
    @GetMapping(value = "/channel/c/detail", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<WxChannelDetailVO> getChannelDetailById(@NotNull(message = "渠道ID不能为空") @RequestParam("id") Long id);

    /**
     * 获取小程序配置详情
     * <p>
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11933807
     */
    @GetMapping(value = "/miniConf/c/detail", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<WxAppinfoVO> getMiniAppDetail(@NotNull(message = "appID不能为空") @RequestParam("appId") String appId);

    /**
     * 获取小程序accesstoken
     * <p>
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11933571
     */
    @GetMapping(value = "/mp/token", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<WxAccessTokenDTO> getAccessToken(@NotNull(message = "tenantId 不能为空") @RequestParam("tenantId") Long tenantId, @NotNull(message = "tenantType 不能为空") @RequestParam("tenantType") Integer tenantType, @NotNull(message = "appID不能为空") @RequestParam("appId") String appId);

    /**
     * 刷新小程序accesstoken
     */
    @GetMapping(value = "/mp/refresh/token", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<WxAccessTokenDTO> refreshAccessToken(@NotNull(message = "tenantId 不能为空") @RequestParam("tenantId") Long tenantId, @NotNull(message = "tenantType 不能为空") @RequestParam("tenantType") Integer tenantType, @NotNull(message = "appID不能为空") @RequestParam("appId") String appId);
}
