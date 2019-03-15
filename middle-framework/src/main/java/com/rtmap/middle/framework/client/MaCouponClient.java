package com.rtmap.middle.framework.client;

import com.alibaba.fastjson.JSONObject;
import com.rtmap.middle.framework.client.fallback.MaCouponClientFallback;
import com.rtmap.middle.framework.client.fallback.MaCouponClientFallback;
import com.rtmap.middle.framework.model.*;
import com.rtmap.middle.framework.model.request.coupon.QRCodeGetVO;
import com.rtmap.middle.framework.model.request.coupon.QRCodePregrantOptionVO;
import com.rtmap.middle.framework.model.request.coupon.QRCodePregrantVO;
import com.rtmap.middle.framework.model.request.coupon.QRCodeReturnVO;
import com.rtmap.middle.framework.model.response.coupon.CouponActivityDetatilVO;
import com.rtmap.middle.framework.model.response.coupon.CouponDetailVO;
import com.rtmap.middle.framework.model.response.coupon.QRCodePregrantResultVO;
import com.rtmap.middle.framework.model.response.coupon.QRCodeDetailVO;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
@Component
@FeignClient(
        url = "${feign.ma.rtmap-coupon-web}",
        name = "couponUrl",
        configuration = FeignClientConfiguration.class,
        fallback = MaCouponClientFallback.class
)
public interface MaCouponClient {


    /**
     * 获取券种列表
     */
    @PostMapping(value = "/api/developer/coupon/market/coupon/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<PageList<CouponDetailVO>> getCouponList(CouponKindVO couponKindVO);


    /**
     * 创建活动-优惠券-获取券种详情
     * <p>
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11307689
     */
    @GetMapping(value = "/api/developer/coupon/market/coupon/detail")
    Result<CouponDetailVO> getCouponDetail(@RequestParam(value = "couponId") Long couponId);

    /**
     * @Description: 券批详情
     * @Auth chengshuxin@rtmap.com
     * @Date 18-6-15
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=7308342
     */
    @GetMapping(value = "/api/common/coupon/detail")
    Result<CouponActivityDetatilVO> getCouponActivityDetail(
            @NotNull(message = "券id不能为空")
            @RequestParam(value = "id") Long id,
            @NotBlank(message = "券批id不能为空")
            @RequestParam(value = "couponActivityId") String couponActivityId);

    /**
     * 券码详情
     * <p>
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11307705
     */
    @GetMapping(value = "/api/developer/coupon/instance/detail")
    Result<QRCodeDetailVO> getQrcodeDetail(@RequestParam(value = "qrCode") String qrCode);

    /**
     * 直接领券API
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11307737
     */
    @PostMapping(value = "/api/coupon/get")
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<QRCodeDetailVO> getCoupon(QRCodeGetVO vo);

    /**
     * 退券接口
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=14844559
     */
    @PostMapping(value = "/api/developer/coupon/instance/online/return")
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result returnCoupon(QRCodeReturnVO vo);

    /**
     * 预领券API
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11928849
     */
    @PostMapping(value = "/api/developer/coupon/instance/pre/grant")
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<QRCodePregrantResultVO> preGetCoupon(QRCodePregrantVO vo);

    /**
     * 预发放券激活
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11928852
     */
    @PostMapping(value = "/api/developer/coupon/instance/activation")
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<QRCodeDetailVO> preCouponActivate(QRCodePregrantOptionVO vo);


    /**
     * 预发放券退券
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11928854
     */
    @PostMapping(value = "/api/developer/coupon/instance/pre/grant/return")
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result returnPreCoupon(QRCodePregrantOptionVO vo);


    /**
     * 活动投放到券种
     */
    @PostMapping(value = "/api/developer/coupon/batch/coupon/inject/activity", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<CouponActivityDetatilVO> voucherDeliverAdd(MaCouponBatchVO vo);

    /**
     * 操作券批状态
     *
     * @param pathVariableName
     * @param statusVO
     * @return
     * @author daishaolong@rtmap.com
     */
    @PostMapping(value = "api/developer/coupon/batch/status/{action}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result updateVoucherStatus(@PathVariable(value = "action") String pathVariableName, CouponActivityStatusVO statusVO);

    /**
     * 券批库存修改
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=12485039
     */
    @GetMapping(value = "/api/coupon/activity/increase/quantity", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result updateNum(@RequestParam(value = "couponActivityId") String couponActivityId, @RequestParam(value = "quantity") Integer quantity);

    /**
     * 创建优惠券接口
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11307693
     */
    @PostMapping(value = "/api/developer/coupon/market/coupon/add")
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result createCoupon(JSONObject jsonObject);

    /**
     * @Description:获取卡包列表
     * @Auth chengshuxin@rtmap.com
     * @Date 18-7-19
     * @todo MA暂时没有提供筛选功能，需要的话自己来，此接口也没有分页功能
     */
    @GetMapping(value = "/api/instance/user/coupon/card")
    Result<List<QRCodeDetailVO>> getMyCouponsFromCardBag(
            @NotBlank(message = "openId 不能为空")
            @RequestParam(value = "openId") String openId);

}
