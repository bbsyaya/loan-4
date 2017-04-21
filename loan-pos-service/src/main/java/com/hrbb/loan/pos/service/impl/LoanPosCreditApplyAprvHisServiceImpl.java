package com.hrbb.loan.pos.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TCreditApplyAprvHisDao;
import com.hrbb.loan.pos.dao.entity.TCreditApplyAprvHis;
import com.hrbb.loan.pos.service.LoanPosCreditApplyAprvHisService;

/**
 *<h1>业务申请</h1>
 *@author Johnson Song
 *@version Id: CreditApplyAprvHisServiceImpl.java, v 1.0 2015-2-16 下午5:35:44 Johnson Song Exp
 */
@Service("loanPosCreditApplyAprvHisService")
public class LoanPosCreditApplyAprvHisServiceImpl implements LoanPosCreditApplyAprvHisService{
	
	@Autowired
	private TCreditApplyAprvHisDao tCreditApplyAprvHisDao;

	/**
	 * <h2>根据id获取记录</h2>
	 * @param String, String
	 * @return TCreditApplyAprvHis
	 */
	@Override
	public TCreditApplyAprvHis getTCreditApplyAprvHisById(String loanId,
			String appNum) {
		TCreditApplyAprvHis req = new TCreditApplyAprvHis();
		req.setLoanId(loanId);
		req.setAppNum(appNum);
		return tCreditApplyAprvHisDao.selectByPrimaryKey(req);
	}
	
	/**
	 * <h2>根据条件查询出记录</h2>
	 * @param Map
	 * @return List
	 */
	@Override
	public List<TCreditApplyAprvHis> getSelective(Map<String, Object> map) {
		return tCreditApplyAprvHisDao.selectSelective(map);
	}

	/**
	 * <h2>插入记录</h2>
	 * @param TCreditApplyAprvHis
	 * @return int
	 */
	@Override
	public int insertCreditApplyAprvHis(TCreditApplyAprvHis req) {
		return tCreditApplyAprvHisDao.insertSelective(req);
	}

	/**
	 * <h2>修改记录</h2>
	 * @param TCreditApplyAprvHis
	 * @return int
	 */
	@Override
	public int updateCreditApplyAprvHis(TCreditApplyAprvHis req) {
		return tCreditApplyAprvHisDao.updateByPrimaryKeySelective(req);
	}
	
	/**
	 * <h2>删除记录</h2>
	 * @param String, String
	 * @return int
	 */
	@Override
	public int deleteCreditApplyAprvHis(String loanId, String appNum) {
		TCreditApplyAprvHis tCreditApplyAprvHis = new TCreditApplyAprvHis();
		tCreditApplyAprvHis.setLoanId(loanId);
		tCreditApplyAprvHis.setAppNum(appNum);
		return tCreditApplyAprvHisDao.deleteByPrimaryKey(tCreditApplyAprvHis);
	}

}
