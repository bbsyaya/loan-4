package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCustomerDao;
import com.hrbb.loan.pos.dao.entity.TCustomer;

/**
 *<h1>用户信息Dao实现</h1>
 *@author Johnson Song
 *@version Id: TCustomerDaoImpl.java, v 1.0 2015-2-15 下午4:54:43 Johnson Song Exp
 */
@Repository("tCustomerDao")
public class TCustomerDaoImpl extends SqlSessionDaoSupport implements TCustomerDao{
	
	/**
	 * <h2>根据id删除记录</h2>
	 * @param String
	 * @return int
	 */
	@Override
	public int deleteByPrimaryKey(String custId) {
		return getSqlSession().delete("TCustomerMapper.deleteByPrimaryKey", custId);
	}

	/**
	 * <h2>插入记录</h2>
	 * @param TCustomer
	 * @return int
	 */
	@Override
	public int insert(TCustomer record) {
		return getSqlSession().insert("TCustomerMapper.insert", record);
	}
	
	/**
	 * <h2>选择性插入记录</h2>
	 * @param TCustomer
	 * @return int
	 */
	@Override
	public int insertSelective(TCustomer record) {
		return getSqlSession().insert("TCustomerMapper.insertSelective", record);
	}

	/**
	 * <h2>根据id获取记录</h2>
	 * @param String
	 * @return TCustomer
	 */
	@Override
	public TCustomer selectByPrimaryKey(String custId) {
		Object obj=null;
        
            obj = getSqlSession().selectOne("TCustomerMapper.selectByPrimaryKey", custId);
       
		return (TCustomer)obj;
	}

	/**
	 * <h2>根据条件获取记录</h2>
	 * @param Map
	 * @return List
	 */
	@Override
	public List<TCustomer> selectSelective(Map<String, Object> map) {
		return getSqlSession().selectList("TCustomerMapper.selectSelective", map);
	}
	
	/**
	 * <h2>更新记录</h2>
	 * @param TCustomer
	 * @return int
	 */
	@Override
	public int updateByPrimaryKeySelective(TCustomer record) {
		return getSqlSession().update("TCustomerMapper.updateByPrimaryKeySelective", record);
	}
	
	/**
	 * <h2>选择性更新记录</h2>
	 * @param record
	 * @return int
	 */
	@Override
	public int updateByPrimaryKey(TCustomer record) {
		return getSqlSession().update("TCustomerMapper.updateByPrimaryKey", record);
	}

	@Override
	public List<Map<String, Object>> selectSelectiveMap(
			Map<String, Object> reqMap) {
		return getSqlSession().selectList("TCustomerMapper.selectSelectiveMap", reqMap);
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TCustomerMapper.insertSelectiveMap", reqMap);
	}

	@Override
	public int updateByPrimaryKeySelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().update("TCustomerMapper.updateByPrimaryKeySelectiveMap", reqMap);
	}
	
    @Override
    public Long selectCountForRiskCheck(TCustomer record){   
        return getSqlSession().selectOne("TCustomerMapper.selectCountForRiskCheck", record);
    }

    public TCustomer selectByLoanId(String loanId) {
        return getSqlSession().selectOne("TCustomerMapper.selectByLoanId", loanId);
    }
}
