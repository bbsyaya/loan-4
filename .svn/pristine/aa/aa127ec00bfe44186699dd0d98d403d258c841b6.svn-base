package com.hrbb.loan.pos.biz.backstage.inter;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TBlacklist;

public interface ILoanPosBlacklistBackStageBiz {

	List<Map<String, Object>> queryBlacklist(Map<String, Object> reqMap);

	/**
	 * 录入黑名单
	 * 
	 * @param map
	 * @return
	 */
	public void insertBlacklist(Map<String, Object> reqMap);

	/**
	 * 录入黑名单多条
	 * 
	 * @param map
	 * @return
	 */
	public int insertBlacklists(TBlacklist bl);

	/**
	 * 更新黑名单
	 * 
	 * @param map
	 * @return
	 */
	public void updateBlacklist(Map<String, Object> reqMap);
}
