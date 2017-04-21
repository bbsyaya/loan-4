package com.hrbb.loan.pos.service;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCfgCnapsInfo;

/**
 * 联行号service
 * 
 * @author cjq
 * @version $Id: BankInfoService.java, v 0.1 2015年8月24日 下午7:44:57 cjq Exp $
 */
public interface BankInfoService {
    
      List<TCfgCnapsInfo> getBankInfoBySelective(Map<String,Object> reqMap);
}
