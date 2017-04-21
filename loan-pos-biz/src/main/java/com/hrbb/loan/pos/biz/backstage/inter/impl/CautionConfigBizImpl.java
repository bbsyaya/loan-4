package com.hrbb.loan.pos.biz.backstage.inter.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.hrbb.loan.acct.facade2.MadeLoanProcessQueryBankAcctBalFacade;
import com.hrbb.loan.acct.facade2.bean.QueryBankAcctBalReq;
import com.hrbb.loan.acct.facade2.bean.QueryBankAcctBalRes;
import com.hrbb.loan.pos.biz.backstage.inter.CautionConfigBiz;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosContractManagementBiz;
import com.hrbb.loan.pos.dao.TCfgFundingPoolDao;
import com.hrbb.loan.pos.dao.TMessageDao;
import com.hrbb.loan.pos.dao.TPaymentApplyDao;
import com.hrbb.loan.pos.dao.TReceiptInfoDao;
import com.hrbb.loan.pos.dao.entity.TCfgFundingPool;
import com.hrbb.loan.pos.dao.entity.TContractManagement;
import com.hrbb.loan.pos.dao.entity.TMessage;
import com.hrbb.loan.pos.dao.entity.TPaymentApply;
import com.hrbb.loan.pos.dao.entity.TReceiptInfo;
import com.hrbb.loan.pos.service.bean.BondSupplementMessage;
import com.hrbb.loan.pos.util.IdUtil;
import com.hrbb.loan.pos.util.StringUtil;

@Component("cautionConfigBiz")
public class CautionConfigBizImpl implements CautionConfigBiz {
	
	private Logger logger = LoggerFactory.getLogger(CautionConfigBizImpl.class);
	
	@Autowired
	private TCfgFundingPoolDao tCfgFundingPoolDao;
	
	@Autowired
	private TPaymentApplyDao tPaymentApplyDao;
	
	@Autowired
	private TReceiptInfoDao tReceiptInfoDao;
	
	@Autowired
	private LoanPosContractManagementBiz contBiz;
	
	@Autowired
	private TMessageDao tMessageDao;
	
	@Autowired
	private MadeLoanProcessQueryBankAcctBalFacade  queryBankAcctBal;
	
	private Map<String, String> fundingPoolMap = Maps.newHashMap();
	
	@PostConstruct
	private void init(){
		Map<String, Object> reqMap = Maps.newHashMap();
		List<TCfgFundingPool> resList = tCfgFundingPoolDao.selectSelective(reqMap);
		for(TCfgFundingPool cfg : resList){
			fundingPoolMap.put(cfg.getChannel().trim(), cfg.getAccountName().trim() + "|" + cfg.getBailAccount().trim() + "|" + cfg.getLeverage().toString().trim());
		}
	}


	@Override
	public boolean checkCfgFundingPool(String channel) {
		// 查询保证金账号信息
		Map<String, Object> p = new HashMap<>();
		p.put("channel", channel);
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
	public boolean checkCautionMoney(Map<String, Object> reqMap) {

		logger.debug("checkCautionMoney begin");

		try {
			
			// 用款申请编号
			String payApplyId = reqMap.get("issueid")
					.toString();
			if(payApplyId == null){
				payApplyId = (String)reqMap.get("payApplyId");
			}
			logger.debug("payApplyId=" + payApplyId);
			TContractManagement contract = contBiz
					.getContractByPayApplyId(payApplyId);
			// 银行账户开户行
			/*String loanbankname = reqMap.get(
					PaymentApplyHServiceConstants.loanbankname).toString();
			logger.debug("银行账户开户行loanbankname=" + loanbankname);*/
			// 用款额度
			/*String payApplyAmt = reqMap.get(PaymentApplyConstants.payApplyAmt)
					.toString();
			logger.debug("用款额度payApplyAmt=" + payApplyAmt);*/
			TPaymentApply paymentApply = tPaymentApplyDao.selectByPrimaryKey(payApplyId);
			BigDecimal payApplyAmt = paymentApply.getPayApplyAmt();

			// 查询保证金账号信息
			Map<String, Object> p = new HashMap<>();
			String acctNameAndAcct = fundingPoolMap.get(contract.getChannel());
			String acctNameAndAccts[] = acctNameAndAcct.split("[|]");
			// 保证金账号
			String bailAccount = acctNameAndAccts[1];
			logger.debug("证金账号bailAccount=" + bailAccount);

			// 杠杆倍数
			BigDecimal leverage = new BigDecimal(acctNameAndAccts[2]);
			logger.debug("杠杆倍数leverage=" + leverage);

			// 用款额度
			BigDecimal payApplyAmtB = paymentApply.getPayApplyAmt();
			logger.debug("用款额度payApplyAmtB=" + payApplyAmtB);
			
			BigDecimal balance = new BigDecimal("0");
			// 调用核算查询保证金账户余额
			for(String account : bailAccount.split("[,]")){
				QueryBankAcctBalReq bReq = new QueryBankAcctBalReq();
				bReq.setBankAcctNo(account.trim());
				bReq.setBankAcctName(acctNameAndAccts[0]);
				bReq.setSeqNo(IdUtil.getId("Seq"));
				QueryBankAcctBalRes bRes = queryBankAcctBal.queryBankAcctBal(bReq);
				if (bRes == null || StringUtil.isEmpty(bRes.getBankAcctBalance())) {
					logger.error("调用核算查询保证金账户余额处理异常!");
					return false;
				}
				balance = balance.add(new BigDecimal(bRes.getBankAcctBalance()));
			}
			logger.debug("保证金账户余额BankAcctBalance=" + balance.toString());
			
			//BigDecimal balance = new BigDecimal("10000000");

			p.clear();
			// 该笔用款申请先更新用款申请状态为00，再进行计算，根据结果修改状态
			p.put("payApplyId", payApplyId);
			p.put("status", "00");
			int result = tPaymentApplyDao.updateSelectiveMap(p);
			if (result == 1) {
				logger.debug("用款申请状态更新为00，成功");
			} else {
				logger.debug("用款申请状态更新为00，失败");
			}

			p.clear();
			// 设置渠道
			p.put("channel", contract.getChannel());
			// 贷款总余额
			TReceiptInfo loanTotalBalanceR = tReceiptInfoDao
					.selectTotalBalanceSum(p);
			BigDecimal loanTotalBalanceSum = loanTotalBalanceR
					.getLoanTotalBalance();
			logger.debug("贷款总余额loanTotalBalanceSum=" + loanTotalBalanceSum);

			// 借据总金额
			TReceiptInfo payApplyAmtR = tReceiptInfoDao.selectPayApplyAmtSum(p);
			BigDecimal payApplyAmtSum = payApplyAmtR.getPayApplyAmt();
			logger.debug("借据总余额payApplyAmtSum=" + payApplyAmtSum);

			// 在途总用款金额
			TPaymentApply pa = tPaymentApplyDao.selectPayApplyAmtSum(p);
			BigDecimal payApplyAmtSumPA = pa.getPayApplyAmt();
			logger.debug("在途总用款金额payApplyAmtSumPA=" + payApplyAmtSumPA);

			// 应追加金额=(贷款总余额+借据总金额+在途总用款金额+该笔用款金额)*杠杆倍数-保证金余额
			BigDecimal margin = loanTotalBalanceSum.add(payApplyAmtSum)
					.add(payApplyAmtSumPA).add(payApplyAmtB)
					.divide(leverage, 2, RoundingMode.UP).subtract(balance);
			logger.debug("应追加金额margin=" + margin);

			// 应追加金额大于0，需要追加保证金
			if (margin.compareTo(BigDecimal.ZERO) == 1) {
				logger.debug("应追加金额大于0，需要追加保证金");
				// 查询合同信息
				
				// 推送不足保证金消息
				TMessage message = new TMessage();
				message.setListId(payApplyId);
				message.setContNo(contract.getContNo());
				message.setLoanId(contract.getLoanId());
				message.setCustId(contract.getCustId());
				message.setChannel(contract.getChannel());
				message.setMessageType("15");
				message.setInChannelKind(contract.getInChannelKind());

				BondSupplementMessage boMessage = new BondSupplementMessage();
				// 用款申请编号
				boMessage.setIssueid(payApplyId);
				// 保证金账号
				boMessage.setAccno(bailAccount);
				// 账户余额
				boMessage.setBalance(balance);
				// 应追加金额
				boMessage.setMargin(margin);
				message.setMessageInfo(boMessage.toString());
				result = tMessageDao.insert(message);
				if (result == 1) {
					logger.debug("发送保证金补充通知，成功");
				} else {
					logger.debug("发送保证金补充通知，失败");
				}
				return false;
			} else {
				logger.debug("应追加金额小于等于0，无需追加保证金");
				p.clear();
				// 更新用款申请状态为00
				p.put("payApplyId", payApplyId);
				p.put("status", "10");
				result = tPaymentApplyDao.updateSelectiveMap(p);
				if (result == 1) {
					logger.debug("用款申请状态更新为10，成功");
				} else {
					logger.debug("用款申请状态更新为10，失败");
				}
			}
		} catch (Exception e) {
			logger.error("处理异常：", e);
			return false;
		}
		logger.debug("checkCautionMoney end");
		return true;
	}

	@Override
	public BigDecimal getInterestPriceByChannel(String channel) {
		// TODO Auto-generated method stub
		return tCfgFundingPoolDao.getInterestPriceByChannel(channel);
	}

}
