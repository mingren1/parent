package com.rtmap.middle.third.server;


import com.rtmap.middle.framework.model.*;
import com.rtmap.middle.framework.model.customer.CustomerDetailVO;
import com.rtmap.middle.framework.model.request.crm.CrmRuleInfoVo;
import com.rtmap.middle.framework.model.response.crm.MemberInfoVO;
import com.rtmap.middle.framework.model.response.crm.ScoreRuleInfoVO;
import com.rtmap.middle.framework.model.validate.DGeneralCreateValidate;
import com.rtmap.middle.framework.model.validate.DGeneralUpdateValidate;
import feign.Headers;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 外部链接直接 透传  scrm
 */
@RequestMapping("scrm")
public interface ScrmService {

    /**
     * 交易补录
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=13665177
     *
     * @Auth zhangshaohua@rtmap.com
     * @Date 2018-12-04
     */
    @PostMapping(value = "/api/v1/trade/replenish", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<TradeResponseVO> tradeReplenish(@Valid @RequestBody ReplenishParamVO replenishParamVO);

    /**
     * 查询是否注册会员
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=16646235
     *
     * @Auth zhangshaohua@rtmap.com
     * @Date 2018-12-04
     */
    @GetMapping(value = "/api/v1/customer/isMember", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<IsMember> isMember(@RequestParam(name = "searchText") String searchText, @RequestParam(name = "searchType") Integer searchType, @RequestParam(name = "tenantId") Long tenantId, @RequestParam(name = "tenantType") Integer tenantType);

    /**
     * 注册会员更新接口
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=16646248#id-泛会员修改(中台)-1注册会员更新接口
     * 返回数据data为空
     *
     * @Auth zhangshaohua@rtmap.com
     * @Date 2018-12-04
     */
    @PostMapping(value = "/api/v1/customer/member/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result memberUpdate(@Validated(value = DGeneralUpdateValidate.class) @RequestBody MemberVO memberVO);

    /**
     * 微信会员更新接口
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=16646248#id-泛会员修改(中台)-2微信会员更新接口
     * 返回数据data为空
     *
     * @Auth zhangshaohua@rtmap.com
     * @Date 2018-12-04
     */
    @PostMapping(value = "/api/v1/customer/fans/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result fansUpdate(@Validated(value = DGeneralUpdateValidate.class) @RequestBody CustomerFansVO customerFansVO);


    /**
     * 微信小程序会员更新接口
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=16646248#id-泛会员修改(中台)-4微信小程序会员更新接口
     * 返回数据data为空
     *
     * @Auth zhangshaohua@rtmap.com
     * @Date 2018-12-04
     */
    @PostMapping(value = "/api/v1/customer/mini/program/fans/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result miniProgramFansUpdate(@Validated(value = DGeneralUpdateValidate.class) @RequestBody CustomerMiniProgramFansVO customerMiniProgramFansVO);

    /**
     * 注册会员注册接口
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=16646246#id-泛会员注册(中台)-1注册会员注册接口
     *
     * @Auth zhangshaohua@rtmap.com
     * @Date 2018-12-04
     */
    @PostMapping(value = "/api/v1/customer/member/regist", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<CustomerVO> memberRegist(@Validated(value = DGeneralCreateValidate.class) @RequestBody MemberVO memberVO);

    /**
     * 注册会员信息补全接口
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=16646246#id-泛会员注册(中台)-2注册会员信息补全接
     * 返回数据中的data为空
     *
     * @Auth zhangshaohua@rtmap.com
     * @Date 2018-12-04
     */
    @PostMapping(value = "/api/v1/customer/member/addInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result memberAddInfo(@Validated(value = DGeneralUpdateValidate.class) @RequestBody MemberVO memberVO);

    /**
     * 微信会员信息补全接口
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=16646246#id-泛会员注册(中台)-3微信会员信息补全接口
     * 返回数据中的data为空
     */
    @PostMapping(value = "/api/v1/customer/fans/addInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result fansAddInfo(@Validated(value = DGeneralUpdateValidate.class) @RequestBody CustomerFansVO customerFansVO);

    /**
     * 微信小程序会员信息补全
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=16646246#id-泛会员注册(中台)-4微信小程序会员信息补全接口
     * 返回数据中的data为空
     *
     * @Auth zhangshaohua@rtmap.com
     * @Date 2018-12-04
     */
    @PostMapping(value = "/api/v1/customer/mini/program/fans/addInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result miniProgramAddInfo(@Validated(value = DGeneralUpdateValidate.class) @RequestBody CustomerMiniProgramFansVO customerMiniProgramFansVO);

    /**
     * 获取会员信息
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11934181
     */
    @GetMapping(value = "/api/v1/customer/info")
    Result<CustomerDetailVO> getMember(@RequestParam("tenantId") Long tenantId, @RequestParam("tenantType") Integer tenantType, @RequestParam("searchType") Integer searchType, @RequestParam("searchText") String searchText);


    /**
     * 积分流水
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=16646260
     *
     * @Auth zhangshaohua@rtmap.com
     * @Date 2018-12-04
     */
    @GetMapping(value = "/api/v1/score/flow/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<PageList<FlowResultVO>> scoreFlowList(FlowParamVO flowParamVO);


    /**
     * 获取crm积分
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=12485421
     */
    @GetMapping(value = "/api/v1/score/account", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<UserInfoVO> getScoreByCid(@RequestParam("tenantType") Integer tenantType, @RequestParam("tenantId") Long tenantId, @RequestParam("cid") String cid);

    /**
     * 修改crm积分
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11927890
     */
    @PostMapping(value = "/api/v1/score/adjust", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<AccountAdjustParamVO> editScoreByCid(@RequestBody AccountAdjustParamVO vo);

    /**
     * 会员卡列表
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11931868
     */
    @PostMapping(value = "/api/v1/card/queryList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<PageList<CardVO>> getCardList(@RequestBody CardVO vo);

    /**
     * 通过ID查询卡信息
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=16646254
     *
     * @Auth zhangshaohua@rtmap.com
     * @Date 2018-12-04
     */
    @GetMapping(value = "/api/v1/card/queryByPrimaryKey", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<OutCardInfoVo> selectByPrimaryKey(@RequestParam(name = "id") Long id);

    /**
     * 成长值
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11927860
     */
    @PostMapping(value = "/api/v1/growth/account", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<CardVO> getGrowth(@RequestBody CardVO vo);

    /**
     * 积分规则
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=16025407
     */
    @PostMapping(value = "/api/v1/score/rule/info", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<ScoreRuleInfoVO> getRuleInfo(@RequestBody CrmRuleInfoVo vo);



}
