package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditReportProfessionDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportProfession;

/**
 * <h1>职业信息</h1>
 * 
 * @author Johnson Song
 * @version Id: TBankAccnoInfoDaoImpl.java, v 1.0 2015-3-2 上午10:56:57 Johnson
 *          Song Exp
 */
@Repository("tCreditReportProfessionDao")
public class TCreditReportProfessionDaoImpl extends SqlSessionDaoSupport
		implements TCreditReportProfessionDao {

	@Override
	public int deleteByPrimaryKey(String serialNo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insert(TCreditReportProfession record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insertSelective(TCreditReportProfession record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public TCreditReportProfession selectByPrimaryKey(String serialNo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditReportProfession record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TCreditReportProfession record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TCreditReportProfessionMapper.insertSelectiveMap", reqMap);
	}
	
	@Override
	public List<TCreditReportProfession> selectSelective(TCreditReportProfession record) {
		return getSqlSession().selectList("TCreditReportProfessionMapper.selectSelective", record);
	}
}
