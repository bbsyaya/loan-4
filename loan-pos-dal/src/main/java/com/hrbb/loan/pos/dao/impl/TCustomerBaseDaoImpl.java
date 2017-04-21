package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCustomerBaseDao;
import com.hrbb.loan.pos.dao.entity.TCustomerBase;

/**
 *<h1>用户基本信息dao实现</h1>
 *@author Johnson Song
 *@version Id: TCustomerBaseDaoImpl.java, v 1.0 2015-2-15 下午1:59:40 Johnson Song Exp
 */
@Repository("tCustomerBaseDao")
public class TCustomerBaseDaoImpl extends SqlSessionDaoSupport implements TCustomerBaseDao{
	
	/**
	 * <h2>根据id删除记录</h2>
	 * @param custId
	 * @return int
	 */
	@Override
	public int deleteByPrimaryKey(String custId) {
		return getSqlSession().delete("TCustomerBaseMapper.deleteByPrimaryKey", custId);
	}

	/**
	 * <h2>插入记录</h2>
	 * @param TCustomerBase
	 * @return int
	 */
	@Override
	public int insert(TCustomerBase record) {
		return getSqlSession().insert("TCustomerBaseMapper.insert", record);
	}
	
	/**
	 * <h2>选择性插入记录</h2>
	 * @param TCustomerBase
	 * @return int
	 * 
	 */
	@Override
	public int insertSelective(TCustomerBase record) {
		return getSqlSession().insert("TCustomerBaseMapper.insertSelective", record);
	}
	
	/**
	 * <h2>根据id获取数据</h2>
	 * @param custId
	 * @return TCustomerBase
	 */
	@Override
	public TCustomerBase selectByPrimaryKey(String custId) {
		return getSqlSession().selectOne("TCustomerBaseMapper.selectByPrimaryKey", custId);
	}
	
	/**
	 * <h2>选择性更新</h2>
	 * @param TCustomerBase
	 * @return int
	 */
	@Override
	public int updateByPrimaryKeySelective(TCustomerBase record) {
		return getSqlSession().update("TCustomerBaseMapper.updateByPrimaryKeySelective", record);
	}
	
	/**
	 * <h2>根据id更新数据</h2>
	 * @param TCustomerBase
	 * @return int
	 */
	@Override
	public int updateByPrimaryKey(TCustomerBase record) {
		return getSqlSession().update("TCustomerBaseMapper.updateByPrimaryKey", record);
	}

	/**
	 * <h2>根据条件获取记录</h2>
	 * @param Map
	 * @return List
	 */
	@Override
	public List<TCustomerBase> selectSelective(Map<String, Object> map) {
		return getSqlSession().selectList("TCustomerBaseMapper.selectSelective", map);
	}
	

}
