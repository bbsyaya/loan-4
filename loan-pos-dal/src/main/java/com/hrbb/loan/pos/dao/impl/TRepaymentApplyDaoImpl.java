package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TRepaymentApplyDao;
import com.hrbb.loan.pos.dao.entity.TPaybackApplyInfo;
import com.hrbb.loan.pos.dao.entity.TRepaymentApply;

@Repository("tRepaymentApplyDao")
public class TRepaymentApplyDaoImpl extends SqlSessionDaoSupport implements
		TRepaymentApplyDao {
	@Override
	public TRepaymentApply selectByPrimaryKey(String payApplyId) {
		return getSqlSession().selectOne(
				"TRepaymentApplyMapper.selectByPrimaryKey", payApplyId);
	}

	@Override
	public TRepaymentApply selectByApplyNo(String applyNo) {
		return getSqlSession().selectOne(
				"TRepaymentApplyMapper.selectByApplyNo", applyNo);
	}

	@Override
	public int insert(TPaybackApplyInfo tPaybackApplyInfo) {
		return getSqlSession().insert("TPaybackApplyInfoMapper.insert", tPaybackApplyInfo);
	}

	@Override
	public int updateSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().update(
				"TRepaymentApplyMapper.updateSelectiveMap", reqMap);
	}

    @Override
    public List<Map<String, Object>> selectListByZzApp(Map<String, Object> map) {
        return getSqlSession().selectList("TRepaymentApplyMapper.selectRepaymentByZzApp", map);
    }

   /*	
    @Override
	public int insert(TPaybackApplyInfo tPaybackApplyInfo) {
		// TODO Auto-generated method stub
		return 0;
	}*/

}
