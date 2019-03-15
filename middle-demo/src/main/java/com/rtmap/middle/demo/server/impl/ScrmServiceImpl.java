package com.rtmap.middle.demo.server.impl;


import com.rtmap.middle.demo.server.ScrmService;
import com.rtmap.middle.framework.client.MaScrmClient;
import com.rtmap.middle.framework.model.*;
import com.rtmap.middle.framework.model.customer.CustomerDetailVO;
import com.rtmap.middle.framework.model.request.crm.CrmRuleInfoVo;
import com.rtmap.middle.framework.model.response.crm.MemberInfoVO;
import com.rtmap.middle.framework.model.response.crm.ScoreRuleInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * crm接口客户端
 */
@RestController
public class ScrmServiceImpl implements ScrmService {

    @Autowired
    private MaScrmClient maScrmClient;

    /**
     * 获取会员信息
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11934181
     */
    @Override
    public Result<CustomerDetailVO> getMember(Long tenantId, Integer tenantType, Integer searchType, String searchText) {
        return maScrmClient.getMember(tenantId, tenantType, searchType, searchText);
    }

    /**
     * 获取crm积分
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=12485421
     */
    @Override
    public Result<UserInfoVO> getScoreByCid(@RequestParam("tenantType") Integer tenantType, @RequestParam("tenantId") Long tenantId, @RequestParam("cid") String cid) {
        return maScrmClient.getScoreByCid(tenantType, tenantId, cid);
    }

    /**
     * 修改crm积分
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11927890
     */
    @Override
    public Result<AccountAdjustParamVO> editScoreByCid(@RequestBody AccountAdjustParamVO vo) {
        return maScrmClient.editScoreByCid(vo);
    }

    /**
     * 会员卡列表
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11931868
     */
    @Override
    public Result<PageList<CardVO>> getCardList(@RequestBody CardVO vo) {
        return maScrmClient.getCardList(vo);
    }

    /**
     * 成长值
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11927860
     */
    @Override
    public Result<CardVO> getGrowth(@RequestBody CardVO vo) {
        return maScrmClient.getGrowth(vo);
    }

    /**
     * 积分规则
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=16025407
     */
    @Override
    public Result<ScoreRuleInfoVO> getRuleInfo(@RequestBody CrmRuleInfoVo vo) {
        return maScrmClient.getRuleInfo(vo);
    }


}
