package com.hrbb.loan.pos.biz.backstage.inter.impl;

import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableMap;
import com.hrbb.loan.pos.biz.backstage.inter.IUserMessagePushBiz;

@Component("iUserMessagePushBiz")
public class UserMessagePushBizImpl implements IUserMessagePushBiz {

    @Override
    public String createUserMessage(String bizType) {
        return userMessagePushMap.get(bizType);
    }
    
    /**
     * 消息推送biz_type.
     * 
     */
    private static ImmutableMap<String, String> userMessagePushMap = new ImmutableMap.Builder<String, String>().put("0", "test.")
                                                                                                           .put("1", "您有一笔资料审核结果通知，请查收。")
                                                                                                           .put("2", "您有一笔预授信结果确认通知，请查收。")
                                                                                                           .put("3", "您有一笔电子签约通知，请查收。")
                                                                                                           .put("4", "您有一笔放款通知，请查收。")
                                                                                                           .put("5", "您有一笔到期还款通知，请查收。")
                                                                                                           .put("6", "您有一笔逾期催收通知，请查收。")
                                                                                                           .build();
}
