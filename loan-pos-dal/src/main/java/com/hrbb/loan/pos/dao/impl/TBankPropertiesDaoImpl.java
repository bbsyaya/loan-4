package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TBankPropertiesDao;
import com.hrbb.loan.pos.dao.entity.TBankProperties;

/**
 *<h1>Message dao实现</h1>
 *@author byp
 *@version Id: TBankPropertiesDaoImpl.java, v 1.0 2015-2-15 下午7:15:53  Exp
 */
@Repository("tBankPropertiesDao")
public class TBankPropertiesDaoImpl extends SqlSessionDaoSupport implements TBankPropertiesDao {


	/**
	 * <h2>获取数据</h2>
	 * 
	 * @return List
	 */
	@Override
	public List<TBankProperties> selectBy(String propName) {
		return getSqlSession().selectList("TBankPropertiesMapper.selectBy", propName);
	}
	@Override
	public TBankProperties selectByBankName(String bankName){
		return getSqlSession().selectOne("TBankPropertiesMapper.selectByBankName",bankName);
	}
	
	@Override
	public TBankProperties selectByBankId(String bankId){
		return getSqlSession().selectOne("TBankPropertiesMapper.selectByBankId",bankId);
	}
    @Override
    public List<Map<String, Object>> selectByVersion(String version) {
        return getSqlSession().selectList("TBankPropertiesMapper.selectByVersion", version);
    }
}
