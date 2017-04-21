package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TModelResultDao;
import com.hrbb.loan.pos.dao.entity.TModelResult;
import com.hrbb.loan.pos.util.StringUtil;
/**
 * 
 * @author zhangxi
 *
 */
@Repository("tModelResultDao")
public class TModelResultDaoImpl extends SqlSessionDaoSupport implements TModelResultDao {
		
	//调用PROCEDURE执行风险初审
	@Override
	public String computeCreditScoreResult(Map<String, Object> reqMap) {
		this.getSqlSession().selectOne("TModelResultMapper.creditRiskCheck", reqMap);
		if(StringUtil.isNotEmpty((String)reqMap.get("approved_result"))){
			return (String)reqMap.get("approved_result");
		}
		return "";
	}
	
	//根据loanId删除风险初审结果
	@Override
	public void deleteByLoanId(String loanId) {
		
		this.getSqlSession().selectList("TModelResultMapper.deleteByLoanId", loanId);
	}
	//根据loanId查询风险初审结果
	@Override
	public TModelResult getModelResultByLoanId(String loanId) {
		List<TModelResult> lists = this.getSqlSession().selectList("TModelResultMapper.selectByLoanId", loanId);
		if(!lists.isEmpty()){
			return lists.get(0);
		}
		return null;
	}

}
