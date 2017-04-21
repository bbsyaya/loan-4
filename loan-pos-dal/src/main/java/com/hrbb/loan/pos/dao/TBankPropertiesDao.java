package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TBankProperties;

public interface TBankPropertiesDao {
    
    public List<TBankProperties> selectBy(String propName);
    
    /**
     * 根据银行名称获取银行信息
     * @author cjq
     * @param bankName
     * @return
     */
    public TBankProperties selectByBankName(String bankName);
    
    /**
     * 根据银行Id获取限额配置信息
     * @author Lin,Zhaolin
     * @param bankId
     * @return
     */
    public TBankProperties selectByBankId(String bankId);
    
    public List<Map<String, Object>> selectByVersion(String version);
}