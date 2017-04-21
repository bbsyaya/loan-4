package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TPaybackApplyInfo;
import com.hrbb.loan.pos.dao.entity.TRepaymentApply;

public interface TRepaymentApplyDao {
	TRepaymentApply selectByPrimaryKey(String payApplyId);

	TRepaymentApply selectByApplyNo(String applyNo);
	
//    int insert(TPaybackApplyInfo tPaybackApplyInfo);
    
    int updateSelectiveMap(Map<String, Object> reqMap);

	int insert(TPaybackApplyInfo tPaybackApplyInfo);    
	
	List<Map<String, Object>> selectListByZzApp(Map<String, Object> map);
	

}
