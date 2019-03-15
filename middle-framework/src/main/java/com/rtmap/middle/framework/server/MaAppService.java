package com.rtmap.middle.framework.server;


import com.rtmap.middle.framework.model.ActivityBasicInfoVO;
import com.rtmap.middle.framework.model.ActivityShopListVO;
import com.rtmap.middle.framework.model.ApplyShopBean;
import com.rtmap.middle.framework.model.Result;
import com.rtmap.middle.framework.model.request.market.ActivityApplyShopVO;
import com.rtmap.middle.framework.model.request.market.ActivityGroupCreationVO;
import com.rtmap.middle.framework.model.request.market.ActivityStatusOptionVO;
import com.rtmap.middle.framework.model.response.market.*;
import feign.Headers;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController("/maApp")
public interface MaAppService {

    /**
     * 创建活动组
     * Document:
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11306978
     */
    @PostMapping(value = "/D/activity/group/create")
    Result<ActivityGroupIdVO> createActivityGroup(@RequestBody ActivityGroupCreationVO activityGroupCreationVO);

    /**
     * 创建活动
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11306133
     */
    @PostMapping(value = "/D/app/activity/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<ActivityIdVO> generateActivity(@RequestBody @Valid ActivityBasicInfoVO activityVO);

    /**
     * 更改活动的状态，改为待启动
     * <p>
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11932988
     */
    @GetMapping(value = "/D/app/activity/setStatus/waitRun")
    Result setActivityStatusWaitRun(@RequestParam(value = "activityId") String activityId);


    /**
     * 活动启动暂停接口
     * <p>
     * http://10.10.11.47:8090/pages/viewpage.action?pageId=11930420
     */
    @PostMapping(value = "/D/app/activity/status/update")
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result<Long> startOrStopActivity(@RequestBody ActivityStatusOptionVO optionVO);

    /**
     * 更新活动适用商户
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11307452
     */
    @PostMapping(value = "/D/app/activity/shop/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result createActivityShops(@RequestBody @Valid ActivityApplyShopVO shopCreateOrUpdateVO);
    /**
     * 更新活动适用商户
     *
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11307452
     */
    @PostMapping(value = "/D/app/activity/shop/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Headers("Content-Type: application/json;charset=UTF-8")
    Result updateActivityShops(@RequestBody @Valid ActivityShopListVO activityShopListVO);

    /**
     * 获取活动下的关联商铺
     *
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11929568
     */
    @GetMapping(value = "/D/app/activity/shop/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<List<ApplyShopBean>> getActivityShopList(@NotBlank(message = "活动ID不能为空") @RequestParam("activityId") String activityId);

    /**
     * 查询活动的参与商户的数量
     *
     * @param activityId 活动ID
     *                   <p>
     *                   http://211.157.182.226:8090/pages/viewpage.action?pageId=11929945
     */
    @GetMapping(value = "/D/app/activity/shop/count")
    Result<ActivityApplyShopCountVO> shopCount(@RequestParam(value = "activityId") String activityId);

    /**
     * 获取活动详情
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=13665126
     */
    @GetMapping(value = "/D/app/activity/detail", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<ActivityDeatilVO>  getActivityDetail(@NotBlank(message = "活动ID不能为空") @RequestParam("activityId") String activityId);
    /**
     * 活动组列表查询
     * <p>
     * 入参：
     *
     * @param portalId    Integer  账号id  不可空
     * @param subjectType Integer 账号类型	  不可空 1商场；2商户
     * @param groupName   String 活动组名 可空
     *                    <p>
     *                    Document:
     *                    http://211.157.182.226:8090/pages/viewpage.action?pageId=13665126
     */
    @GetMapping(value = "/D/activity/group/list")
    Result<List<ActivityGroupVO>> activityGroupList(@RequestParam(value = "portalId") Long portalId, @RequestParam(value = "subjectType") Integer subjectType, @RequestParam(value = "groupName") String groupName);
    /**
     * 查询应用详情
     *
     * http://211.157.182.226:8090/pages/viewpage.action?pageId=11928263
     */
    @GetMapping(value = "/D/get/app/detail")
    Result<AppDetailVO> getAppInfoByAppId(@RequestParam(value = "appId") Long appId);
}
