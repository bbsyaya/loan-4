package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TPaybackApplyInfoDao;
import com.hrbb.loan.pos.dao.entity.TPaybackApplyInfo;
@Repository("tPaybackApplyInfoDao")
public class TPaybackApplyInfoDaoImpl extends SqlSessionDaoSupport implements TPaybackApplyInfoDao{

	@Override
	public int deleteByPrimaryKey(String paybackApplyId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TPaybackApplyInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TPaybackApplyInfo record) {
		return getSqlSession().insert("TPaybackApplyInfoMapper.insertSelective", record);
	}

	@Override
	public TPaybackApplyInfo selectByPrimaryKey(String paybackApplyId) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("TPaybackApplyInfoMapper.selectByPrimaryKey",paybackApplyId);
	}

	@Override
	public int updateByPrimaryKeySelective(TPaybackApplyInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TPaybackApplyInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TPaybackApplyInfo> getPaybackApplyInfo(
			Map<String, Object> reqMap) {
		return getSqlSession().selectList("TPaybackApplyInfoMapper.getPaybackApplyInfo",reqMap);
	}

	@Override
	public int updatePaybackApply(Map<String, Object> updateMap) {
		return getSqlSession().update("TPaybackApplyInfoMapper.updatePaybackApply", updateMap);
	}

    @Override
    public List<Map<String, Object>> selectPaybackDetailsByMaps(Map<String, Object> map) {
        return getSqlSession().selectList("TPaybackApplyInfoMapper.selectRepaymentByZzApp", map);
    }

    @Override
    public List<Map<String, Object>> selectPaybackDetailsBySlApp(Map<String, Object> map) {
        return getSqlSession().selectList("TPaybackApplyInfoMapper.selectRepaymentBySlApp", map);
    }

	@Override
	public List<TPaybackApplyInfo> queryPaybackApplyList(
			Map<String, Object> reqMap) {
		return getSqlSession().selectList("TPaybackApplyInfoMapper.selectPaybackApply", reqMap);
	}

	@Override
	public long countNumber(Map<String, Object> reqMap) {
		return getSqlSession().selectOne("TPaybackApplyInfoMapper.countNumber", reqMap);
	}

    @Override
    public List<String> queryPaybackApplyIdList02() {
        return getSqlSession().selectList("TPaybackApplyInfoMapper.queryPaybackApplyIdList02");
    }
    
    @Override
    public int updatePaybackApplyInfo(String paybackApplyId) {
        return getSqlSession().update("TPaybackApplyInfoMapper.updatePaybackApplyInfo",paybackApplyId);
    }

    @Override
    public List<TPaybackApplyInfo> queryPaybackApplyInfo01() {
        return getSqlSession().selectList("TPaybackApplyInfoMapper.queryPaybackApplyInfo01");
    }

	@Override
	public void insertBatch(List<Map<String, Object>> list) {
		getSqlSession().insert("TPaybackApplyInfoMapper.insertBatch", list);
		
	}

	@Override
	public void updateStatusBatch(List<Map<String, Object>> list) {
		getSqlSession().update("TPaybackApplyInfoMapper.updateStatusBatch", list);
	}

    @Override
    public TPaybackApplyInfo queryPaybackApplyInfo(Map<String, Object> reqMap) {
        return getSqlSession().selectOne("TPaybackApplyInfoMapper.queryPaybackApplyInfo",reqMap);
    }

	@Override
	public List<TPaybackApplyInfo> getPaybackApplyInfoForAuto(
			Map<String, Object> reqMap) {
		return getSqlSession().selectList("TPaybackApplyInfoMapper.getPaybackApplyInfoForAuto", reqMap);
	}

}
