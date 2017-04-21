package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TContractInfoDao;
import com.hrbb.loan.pos.dao.entity.TContractInfo;
import com.hrbb.loan.pos.dao.entity.TContractManagement;

@Repository("tContractInfoDao")
public class TContractInfoDaoImpl extends SqlSessionDaoSupport implements
		TContractInfoDao {

    @Override
    public TContractInfo selectByPrimaryKey(String contno){
        return null;
    }
    
    @Override
    public int deleteByPrimaryKey(String contno){
        return 0;
    }

	@Override
	public int insert(TContractInfo record) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("TContractInfoMapper.insert", record);
	}

	@Override
	public int insertSelective(TContractInfo record) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("TContractInfoMapper.insertSelective", record);
	}

	@Override
	public int updateByPrimaryKeySelective(TContractInfo record) {
		// TODO Auto-generated method stub
		return getSqlSession().update("TContractInfoMapper.updateByPrimaryKeySelective", record);
	}

	@Override
	public int updateByPrimaryKey(TContractInfo record) {
		// TODO Auto-generated method stub
		return getSqlSession().update("TContractInfoMapper.updateByPrimaryKey", record);
	}

	@Override
	public List<Map<String, Object>> selectSelectiveMap(
			Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("TContractInfoMapper.selectSelectiveMap", reqMap);
	}

	@Override
	public Long countSelectiveMap(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("TContractInfoMapper.countSelectiveMap", reqMap);
	}

	@Override
	public int updateSelectiveMapByKey(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return getSqlSession().update("TContractInfoMapper.updateSelectiveMap", reqMap);
	}

	/**
     * 
     * @see com.hrbb.loan.pos.dao.TContractDao#selectByZzApp(java.util.Map)
     */
    @Override
    public List<Map<String, Object>> selectByZzApp(Map<String, Object> map) {
        return getSqlSession().selectList("TContractInfoMapper.selectContractByZzApp", map);
    }
    

    @Override
    public List<Map<String, Object>> selectAvalibleSelectiveMap(
            Map<String, Object> reqMap) {
        return getSqlSession().selectList("TContractInfoMapper.selectAvailableContracts", reqMap);
    }

    @Override
    public Long countAvalibleSelectiveMap(Map<String, Object> reqMap) {
        return getSqlSession().selectOne("TContractInfoMapper.countAvailableContracts", reqMap);
    }

	@Override
	public List<Map<String, Object>> getApproveMap(String loanId) {
		 return getSqlSession().selectList("TContractInfoMapper.getApproveMap", loanId);
	}

    @Override
    public TContractManagement selectContractInfoByLoanId(String loanId) {
        return getSqlSession().selectOne("TContractInfoMapper.selectByLoanId", loanId);
    }

}
