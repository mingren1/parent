package com.rtmap.middle.framework.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ActivityShopListVO {

    private Long portalId;
    private String activityId;
    private Integer isAllShop;
    private List<ShopVO> applyShops;


    public static class ShopVO implements Serializable {
        private static final long serialVersionUID = 1L;

        private Integer shopId;
        private String shopName;

        public Integer getShopId() {
            return shopId;
        }

        public void setShopId(Integer shopId) {
            this.shopId = shopId;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }
    }

}
