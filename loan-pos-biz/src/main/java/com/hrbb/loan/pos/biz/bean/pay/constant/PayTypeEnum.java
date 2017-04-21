package com.hrbb.loan.pos.biz.bean.pay.constant;

/**
 * 支付交易类型
 * 
 * @author cjq
 * @version $Id: payTypeEnum.java, v 0.1 2015年8月14日 下午3:41:38 cjq Exp $
 */
public enum PayTypeEnum {
    
    PAY("pay","代付"),
    REPAY("repay","代扣")
    ;
    
    private String payTypeCode;
  
    private String payTypeName;
    
    PayTypeEnum(String payTypeCode,String payTypeName){
        this.payTypeCode = payTypeCode;
        this.payTypeName = payTypeName;
    }
    public String getPayTypeCode() {
        return payTypeCode;
    }
    public void setPayTypeCode(String payTypeCode) {
        this.payTypeCode = payTypeCode;
    }
    public String getPayTypeName() {
        return payTypeName;
    }
    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }
}
