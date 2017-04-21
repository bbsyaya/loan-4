package com.hrbb.loan.pos.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TApproveResultDao;
import com.hrbb.loan.pos.dao.TCreditApplyAprvDao;
import com.hrbb.loan.pos.dao.TMessageDao;
import com.hrbb.loan.pos.dao.entity.TCreditApplyAprv;
import com.hrbb.loan.pos.service.LoanPosCreditApplyAprvService;

/**
 *<h1>业务申请确认实现</h1>
 *@author Johnson Song
 *@version Id: CreditApplyAprvServiceImpl.java, v 1.0 2015-2-16 下午2:00:19 Johnson Song Exp
 */
@Service("loanPosCreditApplyAprvService")
public class LoanPosCreditApplyAprvServiceImpl implements LoanPosCreditApplyAprvService{

	@Autowired
	private TCreditApplyAprvDao tCreditApplyAprvDao;
	
	@Autowired
	private TApproveResultDao tApproveResultDao;
	
	@Autowired
	private TMessageDao tMessageDao;
	
	/**
	 * <h2>根据主键获取记录</h2>
	 * @param String, String
	 * @return TCreditApplyAprv
	 */
	@Override
	public TCreditApplyAprv getTCreditApplyAprvById(String loanId, String appNum) {
		TCreditApplyAprv reqApplyAprv = new TCreditApplyAprv();
		reqApplyAprv.setAppNum(appNum);
		reqApplyAprv.setLoanId(loanId);
		return tCreditApplyAprvDao.selectByPrimaryKey(reqApplyAprv);
	}

	/**
	 * <h2>根据条件获取记录</h2>
	 * @param Map
	 * @return List
	 */
	@Override
	public List<TCreditApplyAprv> getTCreditApplyAprvSelective(
			Map<String, Object> map) {
		return tCreditApplyAprvDao.selectSelective(map);
	}

	/**
	 * <h2>插入记录</h2>
	 * @param TCreditApplyAprv
	 * @return int
	 */
	@Override
	public int insertCreditApplyAprv(TCreditApplyAprv tCreditApplyAprv) {
		return tCreditApplyAprvDao.insertSelective(tCreditApplyAprv);
	}
	
	/**
	 * <h2>修改记录</h2>
	 * @param TCreditApplyAprv
	 * @return int
	 */
	@Override
	public int updateCreditApplyAprv(TCreditApplyAprv tCreditApplyAprv) {
		return tCreditApplyAprvDao.updateByPrimaryKeySelective(tCreditApplyAprv);
	}
	
	/**
	 * <h2>删除记录</h2>
	 * @param String, String
	 * @return int
	 */
	@Override
	public int deleteCreditApplyAprv(String loanId, String appNum) {
		TCreditApplyAprv tCreditApplyAprv = new TCreditApplyAprv();
		tCreditApplyAprv.setLoanId(loanId);
		tCreditApplyAprv.setAppNum(appNum);
		return tCreditApplyAprvDao.deleteByPrimaryKey(tCreditApplyAprv);
	}

	@Override
	public List<Map<String, Object>> getExpiredRecord(Map<String, Object> reqMap) {
		return tApproveResultDao.getExpiredRecord(reqMap);
	}

	@Override
	public void updateExpiredRecord(Map<String, Object> reqMap) {
		tApproveResultDao.updateExpiredRecord(reqMap);
	}

	@Override
	public void insertExpiredMessageBatch(List<Map<String, Object>> list) {
		tMessageDao.insertBatchMap(list);
	}

	@Override
	public void updateBatch(List<Map<String, Object>> list) {
		tApproveResultDao.batchUpdateRecord(list);		
	}

	@Override
	public List<Map<String, Object>> selectCallTask(Map<String, Object> reqMap) {
		return tApproveResultDao.getCallTask(reqMap);
	}
	
	
}
