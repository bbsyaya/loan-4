package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TContractDao;
import com.hrbb.loan.pos.dao.entity.TContract;

/**
 *<h1>合同表dao实现</h1>
 *@author Johnson Song
 *@version Id: TContractDaoImpl.java, v 1.0 2015-2-15 下午7:15:53 Johnson Song Exp
 */
@Repository("tContractDao")
public class TContractDaoImpl extends SqlSessionDaoSupport implements TContractDao {
	
	/**
	 * <h2>根据id删除记录</h2>
	 * @param string
	 * @return int
	 */
	@Override
	public int deleteByPrimaryKey(String contNo) {
		return getSqlSession().delete("TContractMapper.deleteByPrimaryKey", contNo);
	}
	
	/**
	 * <h2>插入数据</h2>
	 * @param TContract
	 * @return int
	 */
	@Override
	public int insert(TContract record) {
		return getSqlSession().insert("TContractMapper.insert", record);
	}

	/**
	 * <h2>选择性插入数据</h2>
	 * @param TContract
	 * @return int
	 */
	@Override
	public int insertSelective(TContract record) {
		return getSqlSession().insert("TContractMapper.insertSelective", record);
	}
	
	/**
	 * <h2>根据主键获取数据</h2>
	 * @param String
	 * @return TContract
	 */
	@Override
	public TContract selectByPrimaryKey(String contNo) {
		return getSqlSession().selectOne("TContractMapper.selectByPrimaryKey", contNo);
	}
	
	/**
	 * <h2>选择性获取数据</h2>
	 * @param Map
	 * @return List
	 */
	@Override
	public List<TContract> selectSelective(Map<String, Object> map) {
		return getSqlSession().selectList("TContractMapper.selectSelective", map);
	}
	
	/**
	 * <h2>根据主键更新数据</h2>
	 * @param TContract
	 * @return ints
	 */
	@Override
	public int updateByPrimaryKeySelective(TContract record) {
		return getSqlSession().update("TContractMapper.updateByPrimaryKeySelective", record);
	}
	
	/**
	 * <h2>根据id更新数据</h2>
	 * @param record
	 * @return int
	 */
	@Override
	public int updateByPrimaryKey(TContract record) {
		return getSqlSession().update("TContractMapper.updateByPrimaryKey", record);
	}
}
