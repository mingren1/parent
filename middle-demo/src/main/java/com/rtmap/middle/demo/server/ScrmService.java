package com.rtmap.middle.demo.server;


import com.rtmap.middle.framework.model.*;
import com.rtmap.middle.framework.model.customer.CustomerDetailVO;
import com.rtmap.middle.framework.model.request.crm.CrmRuleInfoVo;
import com.rtmap.middle.framework.model.response.crm.MemberInfoVO;
import com.rtmap.middle.framework.model.response.crm.ScoreRuleInfoVO;
import feign.Headers;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 外部链接直接 透传  scrm
 */
@RequestMapping("scrm")
public interface ScrmService {

    /**
     * 获取会员信息
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11934181
     */
    @GetMapping(value = "/api/v1/customer/info")
    public Result<CustomerDetailVO> getMember(@RequestParam("tenantId") Long tenantId, @RequestParam("tenantType") Integer tenantType, @RequestParam("searchType") Integer searchType, @RequestParam("searchText") String searchText);

    /**
     * 获取crm积分
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=12485421
     */
    @GetMapping(value = "/api/v1/score/account", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    public Result<UserInfoVO> getScoreByCid(@RequestParam("tenantType") Integer tenantType, @RequestParam("tenantId") Long tenantId, @RequestParam("cid") String cid);

    /**
     * 修改crm积分
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11927890
     */
    @PostMapping(value = "/api/v1/score/adjust", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    public Result<AccountAdjustParamVO> editScoreByCid(@RequestBody AccountAdjustParamVO vo);

    /**
     * 会员卡列表
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11931868
     */
    @PostMapping(value = "/api/v1/card/queryList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    public Result<PageList<CardVO>> getCardList(@RequestBody CardVO vo);

    /**
     * 成长值
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11927860
     */
    @PostMapping(value = "/api/v1/growth/account", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    public Result<CardVO> getGrowth(@RequestBody CardVO vo);

    /**
     * 积分规则
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=16025407
     */
    @PostMapping(value = "/api/v1/score/rule/info", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    public Result<ScoreRuleInfoVO> getRuleInfo(@RequestBody CrmRuleInfoVo vo);


}
