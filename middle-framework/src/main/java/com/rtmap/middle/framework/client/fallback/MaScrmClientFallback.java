/*
 * RT MAP, Home of Professional MAP
 * Copyright  Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.client.fallback;

import com.rtmap.middle.framework.client.MaScrmClient;
import com.rtmap.middle.framework.model.*;
import com.rtmap.middle.framework.model.customer.CustomerDetailVO;
import com.rtmap.middle.framework.model.page.PageResponseVo;
import com.rtmap.middle.framework.model.request.crm.CrmRuleInfoVo;
import com.rtmap.middle.framework.model.response.crm.MemberInfoVO;
import com.rtmap.middle.framework.model.response.crm.ScoreRuleInfoVO;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

/**
 * @author ishuxin.me@rtmap.com
 * @project wxapp-services
 * @package com.rtmap.middle.framework.client.fallback
 * @date 2018/11/8
 */
@Component
public class MaScrmClientFallback implements MaScrmClient {
    @Override
    public Result<TradeResponseVO> tradeReplenish(@Valid ReplenishParamVO replenishParamVO) {
        return null;
    }

    @Override
    public Result<IsMember> isMember(String searchText, Integer searchType, Long tenantId, Integer tenantType) {
        return null;
    }

    @Override
    public Result memberUpdate(MemberVO memberVO) {
        return null;
    }

    @Override
    public Result fansUpdate(CustomerFansVO customerFansVO) {
        return null;
    }

    @Override
    public Result miniProgramFansUpdate(CustomerMiniProgramFansVO customerMiniProgramFansVO) {
        return null;
    }

    @Override
    public Result<CustomerVO> memberRegist(MemberVO memberVO) {
        return null;
    }

    @Override
    public Result memberAddInfo(MemberVO memberVO) {
        return null;
    }

    @Override
    public Result fansAddInfo(CustomerFansVO customerFansVO) {
        return null;
    }

    @Override
    public Result miniProgramAddInfo(CustomerMiniProgramFansVO customerMiniProgramFansVO) {
        return null;
    }

    @Override
    public Result<CustomerDetailVO> getMember(Long tenantId, Integer tenantType, Integer searchType, String searchText) {
        return null;
    }

    @Override
    public Result<PageList<FlowResultVO>> scoreFlowList(FlowParamVO flowParamVO) {
        return null;
    }

    @Override
    public Result<UserInfoVO> getScoreByCid(Integer tenantType, Long tenantId, String cid) {
        return null;
    }

    @Override
    public Result<AccountAdjustParamVO> editScoreByCid(AccountAdjustParamVO vo) {
        return null;
    }

    @Override
    public Result<PageList<CardVO>> getCardList(CardVO vo) {
        return null;
    }

    @Override
    public Result<OutCardInfoVo> selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public Result<CardVO> getGrowth(CardVO vo) {
        return null;
    }

    @Override
    public Result<ScoreRuleInfoVO> getRuleInfo(CrmRuleInfoVo vo) {
        return null;
    }

    @Override
    public Result<String> getExternalId(String searchText,Integer searchType, Long tenantId,Integer tenantType) {
        return null;
    }

    /**
     * 查询卡列表
     *
     * @param cardInfoVo
     * @return
     */
    @Override
    public Result<PageResponseVo<OutCardInfoVo>> queryList(CardInfoVo cardInfoVo) {
        return null;
    }
}
