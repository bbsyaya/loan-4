package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TApplyNotify;

public interface TApplyNotifyDao {
	
	/**
	 * 获取分时审批结果列表
	 * 
	 * @param request
	 * @return
	 */
	public List<TApplyNotify> selectTimelyApproval(Map<String,Object> request);
}