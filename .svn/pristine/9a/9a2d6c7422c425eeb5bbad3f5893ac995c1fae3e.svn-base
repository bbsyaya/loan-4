package com.hrbb.loan.pos.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TPosCustInfoDao;
import com.hrbb.loan.pos.dao.entity.TPosCustInfo;
import com.hrbb.loan.pos.service.LoanPosCustService;

/**
 *  查询客户信息
 * @author XLY
 * @version $Id: LoanPosCustServiceImpl.java, v 0.1 2015-2-13 上午10:23:05 XLY Exp $
 */
@Service("loanPosCustService")
public class LoanPosCustServiceImpl implements LoanPosCustService {

	@Autowired
	private TPosCustInfoDao tPosCustInfoDao;
	
	@Override
	public TPosCustInfo selectOnePosCust(String posCustId) {
		// TODO 自动生成的方法存根
		return tPosCustInfoDao.selectByPrimaryKey(posCustId);
	}

	@Override
	public int updateByPrimaryKeySelectiveMap(Map<String, Object> map) {
		return tPosCustInfoDao.updateByPrimaryKeySelectiveMap(map);
	}
}
