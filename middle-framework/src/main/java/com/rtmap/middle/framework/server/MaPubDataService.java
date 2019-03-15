package com.rtmap.middle.framework.server;


import com.rtmap.middle.framework.client.FeignClientConfiguration;
import com.rtmap.middle.framework.client.fallback.MaPubDataClientFallback;
import com.rtmap.middle.framework.model.Result;
import com.rtmap.middle.framework.model.response.pubdata.*;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController("/maPubData")
public interface MaPubDataService {

    /**
     * @Description:从公共数据平台获取关联店铺
     * @Auth chengshuxin@rtmap.com
     * @Date 18-7-19
     */
    @GetMapping(value = "/shop/developer/relation/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<PubShopDetailVO> getShopListByMarketId(@NotNull(message = "商场ID不能为空") @RequestParam("marketId") Long marketId, @RequestParam("pageSize") int pageSize, @RequestParam("page") int page);

    /**
     * 店铺名称模糊搜索
     *
     * @author chengshuxin@rtmap.com
     * @date 2018/9/3
     */
    @GetMapping(value = "/api/market/shop/list/condition/noToken", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<List<PubShopInfoSimpleVO>> getShopsByKeyWords(@RequestParam("marketId") Long marketId, @RequestParam("name") String name);

    /**
     * 楼层列表
     *
     * @author chengshuxin@rtmap.com
     * @date 2018/9/3
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11929755
     */
    @GetMapping(value = "/api/market/floor/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<List<PubFloorInfoVO>> getFloorListByMarketId(@NotNull(message = "商场ID 不能为空") @RequestParam("marketId") Long marketId, @RequestParam("filter") String filter);

    /**
     * 搜索商户
     *
     * @author chengshuxin@rtmap.com
     * @date 2018/9/3
     */
    @GetMapping(value = "/api/market/shop/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<List<PubShopInfoSimpleVO>> getShopList(@NotNull(message = "商户搜索类型不能为空") @RequestParam("searchType") String searchType, @NotNull(message = "商场ID不能为空") @RequestParam("marketId") Long marketId, @RequestParam("searchChar") String searchChar);

    /**
     * 获取商场详情
     *
     * @author chengshuxin@rtmap.com
     * @date 2018/9/3
     */
    @GetMapping(value = "/api/basic/market/detail", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<PubMarketInfoVO> getMarketInfo(@NotNull(message = "商场ID不能为空") @RequestParam("marketId") Long marketId);

    /**
     * 获取商户详情
     *
     * @author chengshuxin@rtmap.com
     * @date 2018/9/3
     */
    @GetMapping(value = "/shop/api/basic/shop/detail", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<PubShopSummaryVO> getShopInfo(@NotNull(message = "商场ID不能为空") @RequestParam("shopId") Long shopId);

    /**
     * 获取商户详情
     *
     * @author chengshuxin@rtmap.com
     * @date 2018/9/3
     */
    @GetMapping(value = "/shop/posn", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<PubShopInfoVO> getShopPositionInfo(@NotNull(message = "商场ID不能为空") @RequestParam("shopId") Long shopId);

}
