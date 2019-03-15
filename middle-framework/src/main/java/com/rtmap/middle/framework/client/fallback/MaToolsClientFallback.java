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
import com.rtmap.middle.framework.client.MaToolsClient;
import com.rtmap.middle.framework.consts.CodeMsg;
import com.rtmap.middle.framework.model.Result;
import com.rtmap.middle.framework.model.response.pubdata.*;
import com.rtmap.middle.framework.model.response.tbox.WxAccessTokenDTO;
import com.rtmap.middle.framework.model.response.tbox.WxAppinfoVO;
import com.rtmap.middle.framework.model.response.tbox.WxChannelDetailVO;
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
public class MaToolsClientFallback implements MaToolsClient {
    @Override
    public Result<WxChannelDetailVO> getChannelDetailById(@NotNull(message = "渠道ID不能为空") Long id) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result<WxAppinfoVO> getMiniAppDetail(@NotNull(message = "appID不能为空") String appId) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result<WxAccessTokenDTO> getAccessToken(@NotNull(message = "tenantId 不能为空") Long tenantId, @NotNull(message = "tenantType 不能为空") Integer tenantType, @NotNull(message = "appID不能为空") String appId) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result<WxAccessTokenDTO> refreshAccessToken(@NotNull(message = "tenantId 不能为空") Long tenantId, @NotNull(message = "tenantType 不能为空") Integer tenantType, @NotNull(message = "appID不能为空") String appId) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }
}
