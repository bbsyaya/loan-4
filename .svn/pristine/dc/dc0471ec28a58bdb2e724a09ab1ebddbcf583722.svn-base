package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TMessageDao;
import com.hrbb.loan.pos.dao.entity.TMessage;

/**
 *<h1>Message dao实现</h1>
 *@author byp
 *@version Id: TMessageDaoImpl.java, v 1.0 2015-2-15 下午7:15:53  Exp
 */
@Repository("tMessageDao")
public class TMessageDaoImpl extends SqlSessionDaoSupport implements TMessageDao {
	
	/**
	 * <h2>根据id删除记录</h2>
	 * @param Integer
	 * @return int
	 */
	@Override
	public int deleteById(Integer id) {
		return getSqlSession().delete("TMessageMapper.deleteById", id);
	}
	
	
	/**
	 * <h2>插入数据</h2>
	 * @param TMessage
	 * @return int
	 */
	@Override
	public int insert(TMessage record) {
		return getSqlSession().insert("TMessageMapper.insert", record);
	}

	/**
	 * <h2>获取数据</h2>
	 * 
	 * @return List
	 */
	@Override
	public List<TMessage> selectAll() {
		return getSqlSession().selectList("TMessageMapper.selectAll");
	}


	@Override
	public int insertBatchMap(List<Map<String, Object>> reqMap) {
		return getSqlSession().insert("TMessageMapper.insertSelectiveMapBatch", reqMap);
	}
	
	@Override
	public List<TMessage> selectByMap(Map map){
	    return getSqlSession().selectList("TMessageMapper.selectByMap", map);
	}


    @Override
    public int updateCount(Map<String, Object> map) {
        return getSqlSession().update("TMessageMapper.updateCount", map);
    }

}
