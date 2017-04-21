/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TReviewNoteDao;
import com.hrbb.loan.pos.dao.entity.TReviewNote;
import com.hrbb.loan.pos.dao.entity.TReviewNoteKey;

/**
 * 
 * @author marco
 * @version $Id: TReviewNoteDaoImpl.java, v 0.1 2015-3-2 下午1:42:54 marco Exp $
 */
@Repository("tReviewNoteDao")
public class TReviewNoteDaoImpl extends SqlSessionDaoSupport implements
		TReviewNoteDao {

	/**
	 * @see com.hrbb.loan.pos.dao.TReviewNoteDao#deleteByPrimaryKey(java.lang.String)
	 */
	@Override
	public int deleteByPrimaryKey(TReviewNoteKey key) {
		return getSqlSession().delete("TReviewNoteMapper.deleteByPrimaryKey",
				key);
	}

	/**
	 * @see com.hrbb.loan.pos.dao.TReviewNoteDao#insert(com.hrbb.loan.pos.dao.entity.TReviewNote)
	 */
	@Override
	public int insert(TReviewNote record) {
		// 获取最大复审编号
		int reviewId = selectMaxReviewIdByLoanId(record.getloanid());
		record.setReviewid(reviewId);
		return getSqlSession().insert("TReviewNoteMapper.insert", record);
	}

	/**
	 * @see com.hrbb.loan.pos.dao.TReviewNoteDao#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public TReviewNote selectByPrimaryKey(TReviewNoteKey key) {
		return getSqlSession().selectOne(
				"TReviewNoteMapper.selectByPrimaryKey", key);
	}

	/**
	 * @see com.hrbb.loan.pos.dao.TReviewNoteDao#updateByPrimaryKeySelective(com.hrbb.loan.pos.dao.entity.TReviewNote)
	 */
	@Override
	public int updateByPrimaryKeySelective(TReviewNote record) {
		return getSqlSession().update(
				"TReviewNoteMapper.updateByPrimaryKeySelective", record);
	}

	/**
	 * @see com.hrbb.loan.pos.dao.TReviewNoteDao#updateByPrimaryKey(com.hrbb.loan.pos.dao.entity.TReviewNote)
	 */
	@Override
	public int updateByPrimaryKey(TReviewNote record) {
		return 0;
	}

	/**
	 * @see com.hrbb.loan.pos.dao.TReviewNoteDao#selectSelective(com.hrbb.loan.pos.dao.entity.TReviewNote)
	 */
	@Override
	public List<TReviewNote> selectSelective(TReviewNote tReviewNote) {
		return getSqlSession().selectList("TReviewNoteMapper.selectAll",
				tReviewNote);
	}

	/**
	 * <h2>获取相应业务编号的最大复审编号</h2>
	 * 
	 * @param loanId
	 * @return reviewId
	 */
	private int selectMaxReviewIdByLoanId(String loanId) {
		int reviewId = getSqlSession().selectOne(
				"TReviewNoteMapper.selectMaxReviewIdByLoanId", loanId);
		return reviewId + 1;
	}
}
