package com.hrbb.loan.pos.dao;

import java.util.List;

import com.hrbb.loan.pos.dao.entity.TReviewNote;
import com.hrbb.loan.pos.dao.entity.TReviewNoteKey;

public interface TReviewNoteDao {

	List<TReviewNote> selectSelective(TReviewNote tReviewNote);

	int deleteByPrimaryKey(TReviewNoteKey key);

	int insert(TReviewNote record);

	TReviewNote selectByPrimaryKey(TReviewNoteKey key);

	int updateByPrimaryKeySelective(TReviewNote record);

	int updateByPrimaryKey(TReviewNote record);
}