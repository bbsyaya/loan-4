package com.hrbb.loan.pos.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TMessageHistDao;
import com.hrbb.loan.pos.dao.entity.TMessageHist;

@Repository("tMessageHistDao")
public class TMessageHistDaoImpl extends SqlSessionDaoSupport implements TMessageHistDao {

	@Override
	public int insertMessageHist(TMessageHist tMessageHist) {
		return getSqlSession().insert("TMessageHistMapper.insert", tMessageHist);
	}

}
