/**
 * 
 */
package com.hrbb.loan.pos.service;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditApplyReturnInfo;

/**
 * <p>Title: TCreditApplyReturnInfoService.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年6月4日
 *
 * logs: 1. 
 */
public interface LoanPosCreditApplyReturnInfoService {
	
	public int insertSelective(TCreditApplyReturnInfo record);
	
	/**
     * 返回一笔申请的所有(或指定)回池记录
     * @param req
     * @return
     */
    List<TCreditApplyReturnInfo> selectAllByKey(Map<String,Object> req);
}
