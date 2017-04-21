/**
 * 
 */
package com.hrbb.loan.pos.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TCreditApplyReturnInfoDao;
import com.hrbb.loan.pos.dao.entity.TCreditApplyReturnInfo;
import com.hrbb.loan.pos.service.LoanPosCreditApplyReturnInfoService;

/**
 * <p>Title: LoanPosCreditApplyReturnInfoServiceImpl.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年6月4日
 *
 * logs: 1. 
 */
@Service("loanPosCreditApplyReturnInfoService")
public class LoanPosCreditApplyReturnInfoServiceImpl implements
		LoanPosCreditApplyReturnInfoService {
	
	@Autowired
	@Qualifier("tCreditApplyReturnInfoDao")
	private TCreditApplyReturnInfoDao applyReturnInfoDao;

	@Override
	public int insertSelective(TCreditApplyReturnInfo record) {
		return applyReturnInfoDao.insert(record);
	}

	@Override
	public List<TCreditApplyReturnInfo> selectAllByKey(Map<String, Object> req) {
		return applyReturnInfoDao.selectAllByKey(req);
	}

}
