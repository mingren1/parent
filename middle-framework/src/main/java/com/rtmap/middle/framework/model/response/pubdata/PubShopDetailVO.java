/*
 * RT MAP, Home of Professional MAP
 * Copyright  Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.model.response.pubdata;

import lombok.Data;

import java.util.List;

/**
 * @author chengshuxin@rtmap.com
 * @project CouponMALL
 * @package com.rtmap.micro.services.couponmall.client.vo.pubdata
 * @date 2018/9/9
 */
@Data
public class PubShopDetailVO {

    private Integer pageSize;
    private Integer total;
    private Integer pages;
    private Integer page;
    private List<PubShopDetail> list;

    public class PubShopDetail {
        /**
         * {
         * "shopId": 1723909,
         * "marketId": 290,
         * "brandId",
         * "brandName",
         * "industryId": 97,
         * "industryName": "男士正装",
         * "shopName": "测试商户6",
         * "address": "11",
         * "contactId",
         * "contactName": "白克勤",
         * "status": 1,
         * "statusDesc": "关联",
         * "buildId",
         * "floor",
         * "imgLogoUrl",
         * "tel",
         * "imgRealUrl",
         * "wxOriginalId",
         * "email",
         * "userName",
         * "mobile",
         * "userEmail",
         * "isRelation",
         * "nameChn": "下沉式会议室",
         * "floorId": "F10",
         * "poiNo": "26",
         * "x": "3.81026",
         * "y": "-24.16875",
         * "externalPoi",
         * "cityId",
         * "cityName",
         * "idcard"
         * }
         */

        private Long shopId;
        private Long marketId;
        /**
         * 品牌id
         */
        private Long brandId;
        /**
         * 品牌名称
         */
        private String brandName;
        private String shopName;
        /**
         * LBS商户名称
         */
        private String address;
        /**
         * /**
         * LBS建筑物ID
         */
        private String buildId;
        private String imgLogoUrl;
        /**
         * 电话号码
         */
        private String mobile;
        /**
         * 楼层
         */
        private String floorId;
        /**
         * poi信息
         */
        private Integer poiNo;
        /**
         * 室内x坐标
         */
        private float x;
        /**
         * 室内x坐标
         */
        private float y;
    }
}
