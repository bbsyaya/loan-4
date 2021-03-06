package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TPaybackRunningRecordDao;
import com.hrbb.loan.pos.dao.entity.TPaybackRunningRecord;
@Repository("tPaybackRunningRecordDao")
public class TPaybackRunningRecordDaoImpl extends SqlSessionDaoSupport implements TPaybackRunningRecordDao {

	@Override
	public int deleteByPrimaryKey(String paybackRunningRecordId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TPaybackRunningRecord record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TPaybackRunningRecord record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TPaybackRunningRecord selectByPrimaryKey(
			String paybackRunningRecordId) {
		return getSqlSession().selectOne("TPaybackRunningRecordMapper.queryPaybackRunnigRecordByPrimaryId", paybackRunningRecordId);
	}

	@Override
	public int updateByPrimaryKeySelective(TPaybackRunningRecord record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TPaybackRunningRecord record) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<Map<String, Object>> getPaybackRunningRecordList(
			Map<String, Object> reqMap) {
		return getSqlSession().selectList("TPaybackRunningRecordMapper.getPaybackRunningRecordList",reqMap);
	}

	/** 
	 * @see com.hrbb.loan.pos.dao.TPaybackRunningRecordInfoDao#selectRunningRecord()
	 */
	@Override
	public List<TPaybackRunningRecord> selectRecordInfoHB17() {
		return getSqlSession().selectList("TPaybackRunningRecordMapper.selectRecordInfoHB17");
	}

	@Override
	public int insertPaybackRunningInfo(Map<String, Object> runnningMap) {
		return getSqlSession().insert("TPaybackRunningRecordMapper.insertPaybackRunningInfo",runnningMap);
	}

	@Override
	public List<Map<String, Object>> queryPaybackRunningInfo(Map<String, Object> reqMap) {
		return getSqlSession().selectList("TPaybackRunningRecordMapper.queryPaybackRunningInfo",reqMap);
	}

	@Override
	public List<Map<String, Object>> queryPaybackRunnigRecordByReceiptId(
			Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("TPaybackRunningRecordMapper.queryPaybackRunnigRecordByReceiptId",reqMap);
	}

	@Override
	public long countNumber(Map<String, Object> reqMap) {
		return getSqlSession().selectOne("TPaybackRunningRecordMapper.countNumber", reqMap);
	}

    public Map<String, Object> queryPdfInfo(String paybackRunningRecordId) {
        return getSqlSession().selectOne("TPaybackRunningRecordMapper.queryPdfCertificateByPaybackRunningRecordId", paybackRunningRecordId);
    }
}
