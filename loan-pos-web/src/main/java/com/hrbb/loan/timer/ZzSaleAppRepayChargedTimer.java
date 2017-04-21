package com.hrbb.loan.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrbb.sh.framework.HServiceException;

/**
 * 消费贷 还款管理     2.6.1   到期扣款.
 * 对于到期日自动扣划的还款方式，到期还款当日，约定的银行卡内资金充足则自动完成还款。
 * 如果扣款时银行卡中没有足够资金，则不能完成全额本息还款。
 * 
 * @author xiongshaogang
 * @version $Id: ZzSaleAppRepayChargedTimer.java, v 0.1 2015年5月12日 下午6:09:12 xiongshaogang Exp $
 */
@Service("zzSaleAppRepayChargedTimer")
public class ZzSaleAppRepayChargedTimer {
	
	private static final Logger logger = LoggerFactory.getLogger(ZzSaleAppRepayChargedTimer.class);
	
	
	
	
	@Scheduled(cron="0 0 12 * * ?")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class })
	public void run() throws HServiceException {
		logger.info("start ZzSaleAppRepayChargedTimer...");
		
		
		
		
		
		
        
		logger.info("end ZzSaleAppRepayChargedTimer!");
	}
}
