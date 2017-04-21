package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditApplyAprvDao;
import com.hrbb.loan.pos.dao.entity.TCreditApplyAprv;
import com.hrbb.loan.pos.dao.entity.TCreditApplyAprvKey;

/**
 *<h1>业务申请dao实现</h1>
 *@author Johnson Song
 *@version Id: TCreditApplyAprvDaoImpl.java, v 1.0 2015-2-15 上午9:59:22 Johnson Song Exp
 */
@Repository("tCreditApplyAprvDao")
public class TCreditApplyAprvDaoImpl extends SqlSessionDaoSupport implements TCreditApplyAprvDao{
	
	/**
	 * <h2>根据id删除记录</h2>
	 * @param TCreditApplyAprvKey
	 * @return int
	 */
	@Override
	public int deleteByPrimaryKey(TCreditApplyAprvKey key) {
		return getSqlSession().delete("TCreditApplyAprvMapper.deleteByPrimaryKey", key);
	}
	
	/**
	 * <h2>插入记录</h2>
	 * @param TCreditApplyAprv
	 * @return int
	 */
	@Override
	public int insert(TCreditApplyAprv record) {
		return getSqlSession().insert("TCreditApplyAprvMapper.insert", record);
	}

	/**
	 * <h2>个别插入</h2>
	 * @param TCreditApplyAprv
	 * @return int
	 */
	@Override
	public int insertSelective(TCreditApplyAprv record) {
		return getSqlSession().insert("TCreditApplyAprvMapper.insertSelective", record);
	}
	
	/**
	 * <h2>根据主键获取记录</h2>
	 * @param TCreditApplyAprvKey
	 * @return TCreditApplyAprvKey
	 */
	@Override
	public TCreditApplyAprv selectByPrimaryKey(TCreditApplyAprvKey key) {
		return getSqlSession().selectOne("TCreditApplyAprvMapper.selectByPrimaryKey", key);
	}

	/**
	 * <h2>根据id更新数据</h2>
	 * @param TCreditApplyAprv
	 * @return int
	 */
	@Override
	public int updateByPrimaryKeySelective(TCreditApplyAprv record) {
		return getSqlSession().update("TCreditApplyAprvMapper.updateByPrimaryKeySelective", record);
	}
	
	/**
	 * <h2>根据id更新记录</h2>
	 * @param TCreditApplyAprv
	 * @return int
	 */
	@Override
	public int updateByPrimaryKey(TCreditApplyAprv record) {
		return getSqlSession().update("TCreditApplyAprvMapper.updateByPrimaryKey", record);
	}
	
	/**
	 * <h2></h2>
	 * @param Map
	 * @return List
	 */
	@Override
	public List<TCreditApplyAprv> selectSelective(Map<String, Object> map) {
		return getSqlSession().selectList("TCreditApplyAprvMapper.selectSelective", map);
	}
	
	

	

}
