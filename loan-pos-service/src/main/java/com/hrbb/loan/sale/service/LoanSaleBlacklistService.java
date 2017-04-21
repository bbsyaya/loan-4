/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.sale.service;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TBlacklist;
import com.hrbb.loan.pos.service.bean.BlackListQueryResVo;

/**
 * 消费贷黑名单service
 * 
 * @author litengfeng
 * @version $Id: LoanSaleBlacklistService.java, v 0.1 2015年5月13日 下午1:40:43 litengfeng Exp $
 */
public interface LoanSaleBlacklistService {
	/**
	 * 根据map条件查询
	 * 
	 * @param map
	 * @return
	 */
	BlackListQueryResVo queryTBlacklists(Map<String, Object> map);

	/**
	 * 
	 * 
	 * @param tBlacklist
	 * @return
	 */
	int updateTBlacklist(TBlacklist tBlacklist);

	/**
	 * 
	 * 
	 * @param tBlacklist
	 */
	void insertTBlacklist(TBlacklist tBlacklist);

	List<Map<String, Object>> getBlacklistMap(Map<String, Object> reqMap);

	Long countBlacklist(Map<String, Object> reqMap);

	/**
	 * 插入Map格式数据
	 * 
	 * @param map
	 * @return
	 */
	int insertSelectiveMap(Map<String, Object> map);

	/**
	 * 插入Map格式数据
	 * 
	 * @param map
	 * @return
	 */
	int updateSelectiveMap(Map<String, Object> map);

	public int insertTBlacklists(TBlacklist bl);

}
