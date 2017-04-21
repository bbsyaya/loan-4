package com.hrbb.loan.pos.service.constants;

/**
 * 短信类型定义,类型大体划分如下:
 * 0*: 共用服务类短信，注册验证码等
 * 1*: 业务受理类短信 
 * 2*: 审查审批类短信
 * 3*: 协议签约类短信
 * 4*: 授信用款类短信
 * 5*: 贷后管理类短信
 * 6*: 信息变更类短信
 */
public class SmsTypeContants {
    
    //注册REGIST
    public static final String 用户注册 = "SMS0001";
    
    //密码找回PASSWORD_GET
    public static final String 密码找回 = "SMS0002";
    
    //手动发送
    public static final String 手动发送 = "SMS0003";
    
    //业务受理CREDIT_APPLY
    public static final String 业务受理 = "SMS1001";
    
    //协议生效CONTRACT
    public static final String 协议生效 = "SMS3001";
    
    //放款PAY
    public static final String 放款通知 = "SMS4001";
    
    //还款PAYBACK
    public static final String 还款通知 = "SMS5001";
    
    //结清CLEAR
    public static final String 结清通知 = "SMS5002";
    
    //未结清UNCLEAR
    public static final String 未结清通知 = "SMS5003";
    
    //授信通过APPROVE
    public static final String 审批通过 = "SMS2001";
    
    //授信拒绝APPROVE_REFUSE
    public static final String 审批拒绝 = "SMS2002";
    
    //补件PATCH
    public static final String 审核补件 = "SMS2003";
    
    
}
