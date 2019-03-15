/*
 * RT MAP, Home of Professional MAP
 * Copyright  Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.client.fallback;

import com.alibaba.fastjson.JSONObject;
import com.rtmap.middle.framework.consts.CodeMsg;
import com.rtmap.middle.framework.client.MaCouponClient;
import com.rtmap.middle.framework.consts.CodeMsg;
import com.rtmap.middle.framework.model.*;
import com.rtmap.middle.framework.model.request.coupon.QRCodeGetVO;
import com.rtmap.middle.framework.model.request.coupon.QRCodePregrantOptionVO;
import com.rtmap.middle.framework.model.request.coupon.QRCodePregrantVO;
import com.rtmap.middle.framework.model.request.coupon.QRCodeReturnVO;
import com.rtmap.middle.framework.model.response.coupon.CouponActivityDetatilVO;
import com.rtmap.middle.framework.model.response.coupon.CouponDetailVO;
import com.rtmap.middle.framework.model.response.coupon.QRCodeDetailVO;
import com.rtmap.middle.framework.model.response.coupon.QRCodePregrantResultVO;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author ishuxin.me@rtmap.com
 * @project wxapp-services
 * @package com.rtmap.middle.framework.client.fallback
 * @date 2018/11/4
 */
@Component
public class MaCouponClientFallback implements MaCouponClient {
    @Override
    public Result<PageList<CouponDetailVO>> getCouponList(CouponKindVO couponKindVO) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result<CouponDetailVO> getCouponDetail(Long couponId) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result<CouponActivityDetatilVO> getCouponActivityDetail(@NotNull(message = "券id不能为空") Long id, @NotBlank(message = "券批id不能为空") String couponActivityId) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result<QRCodeDetailVO> getQrcodeDetail(String qrCode) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result<QRCodeDetailVO> getCoupon(QRCodeGetVO vo) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result returnCoupon(QRCodeReturnVO vo) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result<QRCodePregrantResultVO> preGetCoupon(QRCodePregrantVO vo) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result<QRCodeDetailVO> preCouponActivate(QRCodePregrantOptionVO vo) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result returnPreCoupon(QRCodePregrantOptionVO vo) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result<CouponActivityDetatilVO> voucherDeliverAdd(MaCouponBatchVO vo) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result updateVoucherStatus(String pathVariableName, CouponActivityStatusVO statusVO) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result updateNum(String couponActivityId, Integer quantity) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result createCoupon(JSONObject jsonObject) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result<List<QRCodeDetailVO>> getMyCouponsFromCardBag(@NotBlank(message = "openId 不能为空") String openId) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }
}
