/*
 * RT MAP, Home of Professional MAP
 * Copyright 2018-07-07 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author 87114@rtmap.com
 * @project rtmap-scrm
 * @package com.rtmap.scrm.vo.trade
 * @date 2018/7/7
 */
@Getter
@Setter
@ToString
public class TradeResponseVO {

    /**
     * 本次新增积分
     */
    private Integer incScoreValue;
    /**
     * 当前总积分
     */
    private Integer scoreTotal;

    /**
     * 积分标识，用于提示单日封顶积分差值
     * 值为1的时，存在单日封顶差值提示，例如"您已达到今日上限，本次只获得10积分"
     */
    private Integer scoreMsgFlag;

    /**
     * 积分提示信息，用于单日封顶积分差值提示
     */
    private String scoreMsg;
    /**
     * 本次新增积分
     */
    private Integer incGrowthValue;
    /**
     * 当前总积分
     */
    private Integer growthTotal;

    /**
     * 成长值标识，用于提示单日封顶成长值差值
     * 值为1的时，存在单日封顶差值提示，例如"您已达到今日上限，本次只获得10成长值"
     */
    private Integer growthMsgFlag;

    /**
     * 成长值提示信息，用于成长值单日封顶差值提示
     */
    private String growthMsg;

    /**
     * 变动时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date tradeTime;


    /**
     * 如果小票已经被使用了，用一下参数进行展现信息
     * 小票是否被使用，根据flag字段进行判断
     */
    private Integer flag;
    private String name;
    private String mobile;
    private String usedTime;
    private String cardNo;

}
