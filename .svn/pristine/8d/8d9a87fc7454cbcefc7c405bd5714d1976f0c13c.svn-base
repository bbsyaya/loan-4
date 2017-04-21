package com.hrbb.loan.timer;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.IMadeLoanAcctBiz;
import com.hrbb.loan.pos.biz.backstage.inter.IPaymentApplyBiz;
import com.hrbb.loan.pos.biz.backstage.inter.IReceiptManageBiz;
import com.hrbb.loan.pos.dao.TPaymentApplyTmpDao;
import com.hrbb.loan.pos.dao.entity.TPaymentApply;
import com.hrbb.loan.pos.dao.entity.TPaymentApplyTmp;
import com.hrbb.loan.pos.dao.entity.TReceiptInfo;
import com.hrbb.sh.framework.HServiceException;

/**
 * 消费贷 用款轮询处理.
 * 处理前一天由于核算系统未开放而未放款的用款.
 * 
 * @author xiongshaogang
 * @version $Id: ZzSaleAppPaymentTimer.java, v 0.1 2015年5月12日 下午6:09:12 xiongshaogang Exp $
 */
@Service("zzSaleAppPaymentTimer")
public class ZzSaleAppPaymentTimer {
	
	private static final Logger logger = LoggerFactory.getLogger(ZzSaleAppPaymentTimer.class);
	
	@Autowired
	private TPaymentApplyTmpDao tPaymentApplyTmpDao;
	
	@Autowired
	private IMadeLoanAcctBiz iMadeLoanAcctBiz;
	
	/** 用款申请 */
    @Autowired
    private IPaymentApplyBiz paymentApplyBiz;
    
    /** 借据管理 */
    @Autowired
    private IReceiptManageBiz receiprManageBiz;
    
	@Scheduled(cron="0 0 9 * * ?")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class })
	public void run() throws HServiceException {
		logger.info("start ZzSaleAppPaymentTimer...");
		
		Calendar curCalendar = Calendar.getInstance();
		curCalendar.add(Calendar.DAY_OF_YEAR, -1);
		
		Map<String, Object> objMap = Maps.newHashMap();
		objMap.put("status", "90");
		objMap.put("modifiedDate", DateFormatUtils.format(curCalendar.getTime(), "yyyyMMdd"));
		List<TPaymentApplyTmp> execList = tPaymentApplyTmpDao.selectByObj(objMap);
		if (execList == null || execList.size() < 1) {
            logger.info("待发送核算用款申请列表为空");
            return;
        }
		
		// 串行发送
		for (TPaymentApplyTmp tPaymentApplyTmp : execList) {
		    
		    TPaymentApply paymentApply = paymentApplyBiz.queryPaymentApplyById(tPaymentApplyTmp.getPayApplyId());
		    TReceiptInfo tReceiptInfo = receiprManageBiz.selectReceiptOne(tPaymentApplyTmp.getPayApplyId());
		    
		    if (paymentApply == null || tReceiptInfo == null) {
                logger.info("用款流水号:[" + tPaymentApplyTmp.getPayApplyId() + "],借据不完整，跳过!");
                continue;
            }
		    
		    Map<String, Object> madeLoanRetMap = iMadeLoanAcctBiz.sendMadeLoanCommend(tReceiptInfo);
            if (madeLoanRetMap != null && "000000".equals(madeLoanRetMap.get("resCode"))) {
                logger.info("用款流水号:[" + tPaymentApplyTmp.getPayApplyId() + "],放款成功!");
                
                // 删除临时表
                int ret = tPaymentApplyTmpDao.deleteByPrimaryKey(tPaymentApplyTmp.getPayApplyId());
                logger.info("用款流水号:[" + tPaymentApplyTmp.getPayApplyId() + "],删除临时表流水 ret = [" + ret + "]!");
            }
        }
		
		logger.info("end ZzSaleAppPaymentTimer!");
	}
}
