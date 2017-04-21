package com.hrbb.loan.pos.biz.backstage.inter.impl.withholder;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;
import com.hrbb.loan.acct.facade2.MadeLoanProcessBizSimpleFacade;
import com.hrbb.loan.acct.facade2.MadeLoanProcessQueryBankAcctBalFacade;
import com.hrbb.loan.acct.facade2.bean.InnerAccTransferReq;
import com.hrbb.loan.acct.facade2.bean.QueryBankAcctBalReq;
import com.hrbb.loan.acct.facade2.bean.QueryBankAcctBalRes;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosContractManagementBiz;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosPaybackBiz;
import com.hrbb.loan.pos.dao.TCfgChannelAccountDao;
import com.hrbb.loan.pos.dao.TCfgFundingPoolDao;
import com.hrbb.loan.pos.dao.entity.TCfgChannelAccount;
import com.hrbb.loan.pos.dao.entity.TCfgFundingPool;
import com.hrbb.loan.pos.dao.entity.TContractManagement;
import com.hrbb.loan.pos.dao.entity.TPaybackApplyInfo;
import com.hrbb.loan.pos.util.IdUtil;

@Service("withholderFromAcct")
public class WithholderFromAcct implements IWithholderService{
	
	@Autowired
	private LoanPosContractManagementBiz loanPosContractManagementBiz;
	
	@Autowired
	private TCfgChannelAccountDao tCfgChannelAccountDao;
	
	@Autowired
	private TCfgFundingPoolDao tCfgFundingPoolDao;
	
	@Autowired
	private LoanPosPaybackBiz loanPosPaybackBiz;
	
	
	@Autowired
	private MadeLoanProcessQueryBankAcctBalFacade  queryBankAcctBal;
	
	@Autowired
	private MadeLoanProcessBizSimpleFacade madeLoanProcessBizSimpleFacade;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Map<String, Object> withholder(TPaybackApplyInfo apply){
		if(apply == null){
			logger.error("还款申请为空,不继续执行");
			return null;
		}
		logger.info(apply.getPaybackApplyId() + "开始扣除还款专户还款..");
		try{
			//先查询出合同记录
			TContractManagement contract = loanPosContractManagementBiz.getContractByContNo(apply.getContNo());
			if(contract == null){
				logger.error("没有该合同");
				return null;
			}
			//查询资金池模式配置表，获取过渡户账户及过渡户户名
			Map<String, Object> p = new HashMap<>();
			p.put("channel", contract.getChannel());
			logger.info(apply.getPaybackApplyId() + " 开始查询资金池模式配置表..");
			TCfgFundingPool cfp = tCfgFundingPoolDao.selectOneSelective(p);
			if(cfp == null){
				logger.error("没有该渠道的资金池配置信息..");
			}
			logger.info(apply.getPaybackApplyId() + " 查询资金池配置信息结束..");
			//调核算记账
			logger.info(apply.getPaybackApplyId() + " 开始调核算记账还款..");
			Map<String, Object> resMap = loanPosPaybackBiz.executeRepayment(apply.getPaybackApplyId());
			logger.info("调核算记账结果为: " + resMap);
			logger.info(apply.getPaybackApplyId() + " 调核算还款记账结束..");
		}catch(Exception e){
			logger.error(apply.getPaybackApplyId() + "该还款申请扣还款过渡户发生异常", e);
		}
		logger.info(apply.getPaybackApplyId() + "扣除还款专户还款结束");
		return null;
	}

}
