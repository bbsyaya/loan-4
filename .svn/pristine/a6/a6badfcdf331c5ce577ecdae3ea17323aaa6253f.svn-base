package com.hrbb.loan.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrbb.sh.framework.HServiceException;

/**
 * 消费贷 贷后管理 风险数据重新导入.
 * 由于消费贷产品对借款人授信额度有效期为1-3年，在授信有效期内，
 * 客户可循环使用其有效授信额度，因此系统会对所有有贷客户每两个月提示<贷后管理岗>查询申请人信息(包括人行征信、银联智、国政通等)。
 * 系统查询征信报告后，智能判断提取信用评级下降的客户列表，提示<贷后管理岗>进行审核。
 * 对于这类客户，<贷后管理岗>可要求其提供相关的贷款用途等证明材料。
 * 
 * @author xiongshaogang
 * @version $Id: ZzSaleAppRiskDataSynTimer.java, v 0.1 2015年5月12日 下午6:09:12 xiongshaogang Exp $
 */
@Service("zzSaleAppRiskDataSynTimer")
public class ZzSaleAppRiskDataSynTimer {
	
	private static final Logger logger = LoggerFactory.getLogger(ZzSaleAppRiskDataSynTimer.class);
	
	
	
	
	@Scheduled(cron="0 0 12 * * ?")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class })
	public void run() throws HServiceException {
		logger.info("start ZzSaleAppRiskDataSynTimer...");
		
		
		
		
		
		
        
		logger.info("end ZzSaleAppRiskDataSynTimer!");
	}
}
