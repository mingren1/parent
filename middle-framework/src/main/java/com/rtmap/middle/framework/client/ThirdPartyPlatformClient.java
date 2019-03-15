package com.rtmap.middle.framework.client;

import com.rtmap.middle.framework.model.Result;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
@Component
@FeignClient(
        url = "${feign.ma.rtmap-platform}",
        name = "thirdPartyPlatformUrl",
        configuration = FeignClientConfiguration.class
)
public interface ThirdPartyPlatformClient {

    /**
     * 发送微信模板消息
     * @author maoyun@rtmap.com
     * @date 6/12/18
     * @param body 发送报文
     * @return
     */
    @PostMapping(value = "/template/message/send", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result sendWxMessage(@RequestBody Map<String, Object> body);

    /**
     * 发送短信模板消息
     * @author maoyun@rtmap.com
     * @date 6/12/18
     * @param body 发送报文
     * @return
     */
    @GetMapping(value = "/sms/push", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result sendSmsMessage(@RequestBody Map<String, Object> body);

}
