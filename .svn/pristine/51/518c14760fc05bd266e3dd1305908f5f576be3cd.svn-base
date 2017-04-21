/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditApplyReturnInfoDao;
import com.hrbb.loan.pos.dao.entity.TCreditApplyReturnInfo;
import com.hrbb.loan.pos.dao.entity.TCreditApplyReturnInfoKey;

/**
 * 
 * @author marco
 * @version $Id: TCreditApplyReturnInfoDaoImpl.java, v 0.1 2015-6-3 上午11:25:37
 *          marco Exp $
 */
@Repository("tCreditApplyReturnInfoDao")
public class TCreditApplyReturnInfoDaoImpl extends SqlSessionDaoSupport
		implements TCreditApplyReturnInfoDao {

	/**
	 * @see com.hrbb.loan.pos.dao.TCreditApplyReturnInfoDao#deleteByPrimaryKey(com.hrbb.loan.pos.dao.entity.TCreditApplyReturnInfoKey)
	 */
	@Override
	public int deleteByPrimaryKey(TCreditApplyReturnInfoKey key) {
		return 0;
	}

	/**
	 * @see com.hrbb.loan.pos.dao.TCreditApplyReturnInfoDao#insert(com.hrbb.loan.pos.dao.entity.TCreditApplyReturnInfo)
	 */
	@Override
	public int insert(TCreditApplyReturnInfo record) {
		return 0;
	}

	/**
	 * @see com.hrbb.loan.pos.dao.TCreditApplyReturnInfoDao#insertSelective(com.hrbb.loan.pos.dao.entity.TCreditApplyReturnInfo)
	 */
	@Override
	public int insertSelective(TCreditApplyReturnInfo record) {
		int serialNum = selectMaxSerialNumByLoanId(record.getLoanId());
		record.setSerialNum(serialNum);
		return getSqlSession().insert(
				"TCreditApplyReturnInfoMapper.insertSelective", record);
	}

	/**
	 * @see com.hrbb.loan.pos.dao.TCreditApplyReturnInfoDao#selectByPrimaryKey(com.hrbb.loan.pos.dao.entity.TCreditApplyReturnInfoKey)
	 */
	@Override
	public TCreditApplyReturnInfo selectByPrimaryKey(
			TCreditApplyReturnInfoKey key) {
		return null;
	}

	/**
	 * @see com.hrbb.loan.pos.dao.TCreditApplyReturnInfoDao#updateByPrimaryKeySelective(com.hrbb.loan.pos.dao.entity.TCreditApplyReturnInfo)
	 */
	@Override
	public int updateByPrimaryKeySelective(TCreditApplyReturnInfo record) {
		return 0;
	}

	/**
	 * @see com.hrbb.loan.pos.dao.TCreditApplyReturnInfoDao#updateByPrimaryKey(com.hrbb.loan.pos.dao.entity.TCreditApplyReturnInfo)
	 */
	@Override
	public int updateByPrimaryKey(TCreditApplyReturnInfo record) {
		return 0;
	}

	/**
	 * <h2>获取相应业务编号的最大序号</h2>
	 * 
	 * @param loanId
	 * @return reviewId
	 */
	private int selectMaxSerialNumByLoanId(String loanId) {
		int serialNum = getSqlSession().selectOne(
				"TCreditApplyReturnInfoMapper.selectMaxSerialNumByLoanId",
				loanId);
		return serialNum + 1;
	}

	@Override
	public List<TCreditApplyReturnInfo> selectAllByKey(Map<String, Object> req) {
		return getSqlSession().selectList("TCreditApplyReturnInfoMapper.selectAllByKey",req);
	}
}
