package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TPosSerialnoInfoDao;
import com.hrbb.loan.pos.dao.entity.TPosSerialnoInfo;

/**
 *<h1></h1>
 *@author Johnson Song
 *@version Id: TPosSerialnoInfoDaoImpl.java, v 1.0 2015-3-2 上午10:58:39 Johnson Song Exp
 */
@Repository("tPosSerialnoInfoDao")
public class TPosSerialnoInfoDaoImpl extends SqlSessionDaoSupport implements TPosSerialnoInfoDao {

	@Override
	public int deleteByPrimaryKey(String posSerialNo) {
		return getSqlSession().delete("TPosSerialnoInfoMapper.deleteByPrimaryKey", posSerialNo);
	}

	@Override
	public int insert(TPosSerialnoInfo record) {
		return getSqlSession().insert("TPosSerialnoInfoMapper.insert", record);
	}

	@Override
	public int insertSelective(TPosSerialnoInfo record) {
		return getSqlSession().insert("TPosSerialnoInfoMapper.insertSelective", record);
	}

	@Override
	public TPosSerialnoInfo selectByPrimaryKey(String posSerialNo) {
		return getSqlSession().selectOne("TPosSerialnoInfoMapper.selectByPrimaryKey", posSerialNo);
	}

	@Override
	public int updateByPrimaryKeySelective(TPosSerialnoInfo record) {
		return getSqlSession().update("TPosSerialnoInfoMapper.updateByPrimaryKeySelective", record);
	}

	@Override
	public int updateByPrimaryKey(TPosSerialnoInfo record) {
		return getSqlSession().update("TPosSerialnoInfoMapper.updateByPrimaryKey", record);
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> map) {
		return getSqlSession().insert("TPosSerialnoInfoMapper.insertSelectiveMap", map);
	}

	@Override
	public List<Map<String, Object>> selectMap(Map<String, Object> reqMap) {
		return getSqlSession().selectList("TPosSerialnoInfoMapper.selectMap", reqMap);
	}

	@Override
	public int updateByPrimaryKeySelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().update("TPosSerialnoInfoMapper.updateByPrimaryKeySelectiveMap", reqMap);
	}

	@Override
	public Long countMap(Map<String, Object> reqMap) {
		return getSqlSession().selectOne("TPosSerialnoInfoMapper.countMap", reqMap);
	}

    @Override
    public int deleteByLoanId(String loanId) {
        return getSqlSession().delete("TPosSerialnoInfoMapper.deleteByLoanId", loanId);
    }

    @Override
    public Long countPosSerials(String loanId) {
        return getSqlSession().selectOne("TPosSerialnoInfoMapper.countPosSerials", loanId);
    }
    
    @Override
    public List<Map<String, Object>>  selectSumMap(Map<String,Object> reqMap){
        return getSqlSession().selectList("TPosSerialnoInfoMapper.selectSumMap", reqMap);
    }
    
    @Override
    public List<Map<String, Object>> selectSumMapStdev(Map<String,Object> reqMap){
        return getSqlSession().selectList("TPosSerialnoInfoMapper.selectSumMapStdev", reqMap);
    }
    @Override
    public List<Map<String, Object>>  selectSumBankCard(Map<String,Object> reqMap){
        return getSqlSession().selectList("TPosSerialnoInfoMapper.selectSumBankCard", reqMap);
    }
    @Override
    public List<Map<String, Object>>  selectCountMonth(Map<String,Object> reqMap){
        return getSqlSession().selectList("TPosSerialnoInfoMapper.selectCountMonth", reqMap);
    }

	@Override
	public int insertSelectiveMapBatch(List<Map<String, Object>> list) {
		return getSqlSession().insert("TPosSerialnoInfoMapper.insertSelectiveMapBatch", list);
	}
	
    @Override
    public List<Map<String, Object>>  selectSumMapReview2(Map<String,Object> reqMap){
        return getSqlSession().selectList("TPosSerialnoInfoMapper.selectSumMapReview2", reqMap);
    }
    
    @Override
    public List<TPosSerialnoInfo> selectTPosByMap(Map<String,Object> reqMap) {
        return getSqlSession().selectList("TPosSerialnoInfoMapper.selectTPosByMap", reqMap);
    }
}
