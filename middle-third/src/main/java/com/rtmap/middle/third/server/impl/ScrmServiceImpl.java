package com.rtmap.middle.middle.third.server.impl;


import com.rtmap.middle.framework.client.MaScrmClient;
import com.rtmap.middle.framework.model.*;
import com.rtmap.middle.framework.model.customer.CustomerDetailVO;
import com.rtmap.middle.framework.model.request.crm.CrmRuleInfoVo;
import com.rtmap.middle.framework.model.response.crm.MemberInfoVO;
import com.rtmap.middle.framework.model.response.crm.ScoreRuleInfoVO;
import com.rtmap.middle.framework.model.validate.DGeneralCreateValidate;
import com.rtmap.middle.framework.model.validate.DGeneralUpdateValidate;
import com.rtmap.middle.third.server.ScrmService;
import feign.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * crm接口客户端
 */
@RestController
public class ScrmServiceImpl implements ScrmService {

    @Autowired
    private MaScrmClient client;

    /**
     * 交易补录
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=13665177
     *
     * @Auth zhangshaohua@rtmap.com
     * @Date 2018-12-04
     */
    @Override
    public Result<TradeResponseVO> tradeReplenish(@Valid @RequestBody ReplenishParamVO replenishParamVO) {
        return client.tradeReplenish(replenishParamVO);
    }

    /**
     * 查询是否注册会员
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=16646235
     *
     * @Auth zhangshaohua@rtmap.com
     * @Date 2018-12-04
     */
    @GetMapping(value = "/api/v1/customer/isMember", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    @Override
    public  Result<IsMember> isMember(@RequestParam(name = "searchText") String searchText, @RequestParam(name = "searchType") Integer searchType, @RequestParam(name = "tenantId") Long tenantId, @RequestParam(name = "tenantType") Integer tenantType){
        return client.isMember(searchText,searchType,tenantId,tenantType);
    }

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
    @Override
    public  Result memberUpdate(@Validated(value = DGeneralUpdateValidate.class) @RequestBody MemberVO memberVO){
        return client.memberUpdate(memberVO);
    }

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
    @Override
    public  Result fansUpdate(@Validated(value = DGeneralUpdateValidate.class) @RequestBody CustomerFansVO customerFansVO){
        return client.fansUpdate(customerFansVO);
    }


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
    @Override
    public  Result miniProgramFansUpdate(@Validated(value = DGeneralUpdateValidate.class) @RequestBody CustomerMiniProgramFansVO customerMiniProgramFansVO){
        return client.miniProgramFansUpdate(customerMiniProgramFansVO);
    }

    /**
     * 注册会员注册接口
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=16646246#id-泛会员注册(中台)-1注册会员注册接口
     *
     * @Auth zhangshaohua@rtmap.com
     * @Date 2018-12-04
     */
    @PostMapping(value = "/api/v1/customer/member/regist", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    @Override
    public   Result<CustomerVO> memberRegist(@Validated(value = DGeneralCreateValidate.class) @RequestBody MemberVO memberVO){
        return client.memberRegist(memberVO);
    }

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
    @Override
    public   Result memberAddInfo(@Validated(value = DGeneralUpdateValidate.class) @RequestBody MemberVO memberVO){
        return  client.memberAddInfo(memberVO);
    }

    /**
     * 微信会员信息补全接口
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=16646246#id-泛会员注册(中台)-3微信会员信息补全接口
     * 返回数据中的data为空
     */
    @PostMapping(value = "/api/v1/customer/fans/addInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    @Override
    public Result fansAddInfo(@Validated(value = DGeneralUpdateValidate.class) @RequestBody CustomerFansVO customerFansVO){
        return client.fansAddInfo(customerFansVO);
    }

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
    @Override
    public  Result miniProgramAddInfo(@Validated(value = DGeneralUpdateValidate.class) @RequestBody CustomerMiniProgramFansVO customerMiniProgramFansVO){
        return client.miniProgramAddInfo(customerMiniProgramFansVO);
    }

    /**
     * 获取会员信息
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11934181
     */
    @GetMapping(value = "/api/v1/customer/info")
    @Override
    public  Result<CustomerDetailVO> getMember(@RequestParam("tenantId") Long tenantId, @RequestParam("tenantType") Integer tenantType, @RequestParam("searchType") Integer searchType, @RequestParam("searchText") String searchText){
        return client.getMember(tenantId,tenantType,searchType,searchText);
    }


    /**
     * 积分流水
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=16646260
     *
     * @Auth zhangshaohua@rtmap.com
     * @Date 2018-12-04
     */
    @GetMapping(value = "/api/v1/score/flow/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    @Override
    public  Result<PageList<FlowResultVO>> scoreFlowList(FlowParamVO flowParamVO){
        return client.scoreFlowList(flowParamVO);
    }


    /**
     * 获取crm积分
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=12485421
     */
    @GetMapping(value = "/api/v1/score/account", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    @Override
    public   Result<UserInfoVO> getScoreByCid(@RequestParam("tenantType") Integer tenantType, @RequestParam("tenantId") Long tenantId, @RequestParam("cid") String cid){
        return client.getScoreByCid(tenantType,tenantId,cid);
    }

    /**
     * 修改crm积分
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11927890
     */
    @PostMapping(value = "/api/v1/score/adjust", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    @Override
    public  Result<AccountAdjustParamVO> editScoreByCid(@RequestBody AccountAdjustParamVO vo){
        return client.editScoreByCid(vo);
    }

    /**
     * 会员卡列表
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11931868
     */
    @PostMapping(value = "/api/v1/card/queryList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    @Override
    public  Result<PageList<CardVO>> getCardList(@RequestBody CardVO vo){
        return client.getCardList(vo);
    }

    /**
     * 通过ID查询卡信息
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=16646254
     *
     * @Auth zhangshaohua@rtmap.com
     * @Date 2018-12-04
     */
    @GetMapping(value = "/api/v1/card/queryByPrimaryKey", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    @Override
    public  Result<OutCardInfoVo> selectByPrimaryKey(@RequestParam(name = "id") Long id){
        return client.selectByPrimaryKey(id);
    }

    /**
     * 成长值
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11927860
     */
    @PostMapping(value = "/api/v1/growth/account", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    @Override
    public  Result<CardVO> getGrowth(@RequestBody CardVO vo){
        return client.getGrowth(vo);
    }

    /**
     * 积分规则
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=16025407
     */
    @PostMapping(value = "/api/v1/score/rule/info", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    @Override
    public   Result<ScoreRuleInfoVO> getRuleInfo(@RequestBody CrmRuleInfoVo vo){
        return client.getRuleInfo(vo);
    }


}
