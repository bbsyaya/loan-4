/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.spi.TC2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hrbb.loan.acct.facade2.MadeLoanProcessQueryBankAcctBalFacade;
import com.hrbb.loan.acct.facade2.bean.QueryBankAcctBalReq;
import com.hrbb.loan.acct.facade2.bean.QueryBankAcctBalRes;
import com.hrbb.loan.constants.PaymentApplyConstants;
import com.hrbb.loan.pos.biz.backstage.inter.CautionConfigBiz;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosContractManagementBiz;
import com.hrbb.loan.pos.dao.TBankAccnoInfoDao;
import com.hrbb.loan.pos.dao.TCfgFundingPoolDao;
import com.hrbb.loan.pos.dao.TMessageDao;
import com.hrbb.loan.pos.dao.TPaymentApplyDao;
import com.hrbb.loan.pos.dao.TReceiptInfoDao;
import com.hrbb.loan.pos.dao.entity.TBankAccnoInfo;
import com.hrbb.loan.pos.dao.entity.TCfgFundingPool;
import com.hrbb.loan.pos.dao.entity.TContractManagement;
import com.hrbb.loan.pos.dao.entity.TMessage;
import com.hrbb.loan.pos.dao.entity.TPaymentApply;
import com.hrbb.loan.pos.dao.entity.TReceiptInfo;
import com.hrbb.loan.pos.service.bean.BondSupplementMessage;
import com.hrbb.loan.pos.util.IdUtil;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.spi.TC.TCPaymentApplyServiceImpl;
import com.hrbb.loan.spiconstants.PaymentApplyHServiceConstants;

/**
 * 
 * T62用款申请
 * 
 * @author marco
 * @version $Id: TC2PaymentApplyServiceImpl.java, v 0.1 2015-8-20 上午11:34:55
 *          marco Exp $
 */
@Service("tc2PaymentApply")
public class TC2PaymentApplyServiceImpl extends TCPaymentApplyServiceImpl {

	@Autowired
	private LoanPosContractManagementBiz contBiz;

	@Autowired
	@Qualifier("tBankAccnoInfoDao")
	private TBankAccnoInfoDao tBankAccnoInfoDao;

	@Autowired
	private TMessageDao tMessageDao;

	@Autowired
	@Qualifier("tCfgFundingPoolDao")
	private TCfgFundingPoolDao tCfgFundingPoolDao;

	@Autowired
	private TPaymentApplyDao tPaymentApplyDao;

	@Autowired
	private TReceiptInfoDao tReceiptInfoDao;

	@Autowired
	private MadeLoanProcessQueryBankAcctBalFacade queryBankAcctBal;
	
	@Autowired
	private CautionConfigBiz cautionConfigBiz;

	/**
	 * 卡验真
	 * 
	 * @param accNo
	 *            卡号
	 * @return
	 */
	@Override
	protected boolean checkBankCardStatus(String accNo) {
		TBankAccnoInfo record = tBankAccnoInfoDao.selectByPrimaryKey(accNo);
		if (record == null || StringUtil.isEmpty(record.getStatus())
				|| "02".equals(record.getStatus())) {
			return false;
		}
		return true;
	}

	/**
	 * 卡验真
	 * 
	 * @param accNo
	 *            卡号
	 * @return
	 */
	@Override
	protected boolean checkCfgFundingPool() {
		// 查询保证金账号信息
		Map<String, Object> p = new HashMap<>();
		p.put("channel", getChannel());
		TCfgFundingPool cfp = tCfgFundingPoolDao.selectOneSelective(p);
		// 没有有效的资金池信息
		if (cfp == null || StringUtil.isEmpty(cfp.getBailAccount())
				|| cfp.getLeverage() == null) {
			logger.debug("没有有效的资金池配置信息");
			return false;
		}
		return true;
	}
	
	/**
	 * 校验保证金
	 * 
	 * @param reqMap
	 * @return
	 */
	@Override
	protected boolean checkCautionMoney(Map<String, Object> reqMap) {

		logger.debug("checkCautionMoney begin");

		try {
			return cautionConfigBiz.checkCautionMoney(reqMap);
		} catch (Exception e) {
			logger.error("处理异常：", e);
			return false;
		}

	}
}
