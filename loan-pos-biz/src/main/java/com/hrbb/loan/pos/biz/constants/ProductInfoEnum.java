package com.hrbb.loan.pos.biz.constants;

/**
 * 产品信息
 * 
 * @author cjq
 * @version $Id: ProductInfoEnum.java, v 0.1 2015年6月8日 下午2:08:07 Cjq Exp $
 */
public enum ProductInfoEnum {
    
    PRODUCT_POS("1001020306","POS"),
    PRODUCT_LIULIANG("1001020305","流量贷"),
    PRODUCT_XIAOFEI("1001020351","消费贷");
    
    private String prodId;
    private String prodName;
    
    ProductInfoEnum(String prodId, String prodName){
        this.prodId = prodId;
        this.prodName = prodName;
    }
    
    public String getProdId() {
        return prodId;
    }
    public void setProdId(String prodId) {
        this.prodId = prodId;
    }
    public String getProdName() {
        return prodName;
    }
    public void setProdName(String prodName) {
        this.prodName = prodName;
    }
}
