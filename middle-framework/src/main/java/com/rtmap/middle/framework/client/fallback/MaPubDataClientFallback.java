/*
 * RT MAP, Home of Professional MAP
 * Copyright  Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.client.fallback;

import com.rtmap.middle.framework.consts.CodeMsg;
import com.rtmap.middle.framework.client.MaPubDataClient;
import com.rtmap.middle.framework.consts.CodeMsg;
import com.rtmap.middle.framework.model.Result;
import com.rtmap.middle.framework.model.response.pubdata.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author ishuxin.me@rtmap.com
 * @project wxapp-services
 * @package com.rtmap.middle.framework.client.fallback
 * @date 2018/11/4
 */
@Component
public class MaPubDataClientFallback implements MaPubDataClient {
    @Override
    public Result<PubShopDetailVO> getShopListByMarketId(@NotNull(message = "商场ID不能为空") Long marketId, int pageSize, int page) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result<List<PubShopInfoSimpleVO>> getShopsByKeyWords(Long marketId, String name) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result<List<PubFloorInfoVO>> getFloorListByMarketId(@NotNull(message = "商场ID 不能为空") Long marketId, String filter) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result<List<PubShopInfoSimpleVO>> getShopList(@NotNull(message = "商户搜索类型不能为空") String searchType, @NotNull(message = "商场ID不能为空") Long marketId, String searchChar) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result<PubMarketInfoVO> getMarketInfo(@NotNull(message = "商场ID不能为空") Long marketId) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result<PubShopSummaryVO> getShopInfo(@NotNull(message = "商场ID不能为空") Long shopId) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result<PubShopInfoVO> getShopPositionInfo(@NotNull(message = "商场ID不能为空") Long shopId) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }
}
