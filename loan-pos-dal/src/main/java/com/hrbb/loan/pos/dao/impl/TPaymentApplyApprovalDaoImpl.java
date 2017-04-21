package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TPaymentApplyApprovalDao;
import com.hrbb.loan.pos.dao.entity.TPaymentApplyApproval;
@Repository("tPaymentApplyApprovalDao")
public class TPaymentApplyApprovalDaoImpl extends SqlSessionDaoSupport implements TPaymentApplyApprovalDao {

    @Override
    public int insert(TPaymentApplyApproval record) {
        return 0;
    }

    @Override
    public int insertSelective(TPaymentApplyApproval record) {
        return getSqlSession().insert("TPaymentApplyApprovalMapper.insertSelective", record);
    }

    @Override
    public TPaymentApplyApproval selectOneByPayApplyIdAndBeforeStatus(Map<String, Object> map) {
        
        return getSqlSession().selectOne("TPaymentApplyApprovalMapper.selectByPayApplyIdAndBeforeStatus",map);
    }

    @Override
    public int updateSelectiveMap(Map<String, Object> map) {
        return getSqlSession().update("TPaymentApplyApprovalMapper.updateSelectiveMap", map);
    }

    @Override
    public List<Map<String, Object>> queryPaymentApplyCurr(Map<String, Object> reqMap) {
        return getSqlSession().selectList("TPaymentApplyApprovalMapper.queryPaymentApplyCurrWork", reqMap);
    }
    
    @Override
    public Long countPaymentApplyCurr(Map<String, Object> reqMap) {
        return getSqlSession().selectOne("TPaymentApplyApprovalMapper.countPaymentApplyCurrWork",reqMap);
    }
    
    @Override
    public List<Map<String, Object>> queryPaymentApplyFinished(Map<String, Object> reqMap) {
        return getSqlSession().selectList("TPaymentApplyApprovalMapper.queryPaymentApplyFinishedWork", reqMap);
    }

    @Override
    public Long countPaymentApplyFinished(Map<String, Object> reqMap) {
        return getSqlSession().selectOne("TPaymentApplyApprovalMapper.countPaymentApplyFinishedWork", reqMap);
    }

	@Override
	public TPaymentApplyApproval selectApprOpinion(Map<String, Object> map) {
		return getSqlSession().selectOne("TPaymentApplyApprovalMapper.selectApprOpinion", map);
	}

    @Override
    public int deleteByPaymentApplyId(String payApplyId) {
        return getSqlSession().delete("TPaymentApplyApprovalMapper.deleteByPaymentId", payApplyId);
    }
}
