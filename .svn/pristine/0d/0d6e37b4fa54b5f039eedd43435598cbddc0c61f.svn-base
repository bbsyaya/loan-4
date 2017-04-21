package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TcustomerAccountDao;
import com.hrbb.loan.pos.dao.entity.TcustomerAccount;
@Repository("loanPosCustomerAccountDao")
public class loanPosCustomerAccountDaoImpl extends SqlSessionDaoSupport implements TcustomerAccountDao {
	@Override
	public int deleteByPrimaryKey(String innerAccount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TcustomerAccount record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TcustomerAccount record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TcustomerAccount selectByPrimaryKey(String innerAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TcustomerAccount record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TcustomerAccount record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String,Object> getCustomerAccountInfoByCustId(String custId) {
		 return getSqlSession().selectOne("TcustomerAccountMapper.getCustomerAccountInfoByCustId", custId);
	}

	@Override
	public int updateCustomerAccount(Map<String, Object> bankAccNoMap) {
		 return getSqlSession().update("TcustomerAccountMapper.updateCustomerAccount", bankAccNoMap);
	}

	@Override
	public int insertCustomerAccount(Map<String, Object> bankAccNoMap) {
		 return getSqlSession().insert("TcustomerAccountMapper.insertCustomerAccount", bankAccNoMap);
	}

	@Override
	public List<Map<String, Object>> getAllInnerAccountList(
			Map<String, Object> accno) {
		 return getSqlSession().selectList("TcustomerAccountMapper.getAllInnerAccountList", accno);
	}

	@Override
	public long countAccountNumber(Map<String, Object> accno) {
		 return getSqlSession().selectOne("TcustomerAccountMapper.countAccountNumber", accno);
	}

}
