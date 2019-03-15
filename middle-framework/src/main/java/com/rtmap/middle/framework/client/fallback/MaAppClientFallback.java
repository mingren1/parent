package com.rtmap.middle.framework.client.fallback;

import com.rtmap.middle.framework.client.MaAppClient;
import com.rtmap.middle.framework.consts.CodeMsg;
import com.rtmap.middle.framework.client.MaAppClient;
import com.rtmap.middle.framework.consts.CodeMsg;
import com.rtmap.middle.framework.model.ActivityBasicInfoVO;
import com.rtmap.middle.framework.model.ActivityShopListVO;
import com.rtmap.middle.framework.model.ApplyShopBean;
import com.rtmap.middle.framework.model.request.market.ActivityApplyShopVO;
import com.rtmap.middle.framework.model.request.market.ActivityGroupCreationVO;
import com.rtmap.middle.framework.model.Result;
import com.rtmap.middle.framework.model.request.market.ActivityStatusOptionVO;
import com.rtmap.middle.framework.model.response.market.*;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Component
public class MaAppClientFallback implements MaAppClient {
    @Override
    public Result createActivityShops(@Valid ActivityApplyShopVO shopCreateOrUpdateVO) {
        return null;
    }

    @Override
    public Result updateActivityShops(@Valid ActivityShopListVO activityShopListVO) {
        return null;
    }

    @Override
    public Result<AppDetailVO> getAppInfoByAppId(Long appId) {
        return null;
    }

    @Override
    public Result<ActivityGroupIdVO> createActivityGroup(ActivityGroupCreationVO activityGroupCreationVO) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result<ActivityIdVO> generateActivity(@Valid ActivityBasicInfoVO activityVO) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }


    @Override
    public Result setActivityStatusWaitRun(String activityId) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result<Long> startOrStopActivity(ActivityStatusOptionVO optionVO) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result<List<ApplyShopBean>> getActivityShopList(@NotBlank(message = "活动ID不能为空") String activityId) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result<ActivityApplyShopCountVO> shopCount(String activityId) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result<ActivityDeatilVO> getActivityDetail(@NotBlank(message = "活动ID不能为空") String activityId) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }

    @Override
    public Result<List<ActivityGroupVO>> activityGroupList(Long portalId, Integer subjectType, String groupName) {
        return Result.error(CodeMsg.UNKNOWN_SERVICE);
    }
}
