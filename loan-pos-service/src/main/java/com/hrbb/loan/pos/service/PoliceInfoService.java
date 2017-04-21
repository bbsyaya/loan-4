package com.hrbb.loan.pos.service;

import com.hrbb.loan.pos.dao.entity.TPoliceInfo;

/**
 * @author zhangwei5@hrbb.com.cn
 * @date 2015年9月24日下午3:02:16 
 */
public interface PoliceInfoService {
    
    /**
     * @param loanId 贷款申请编号
     * @return 公安身份信息
     */
    TPoliceInfo queryPoliceInfoByLoadId(String loanId);

}
