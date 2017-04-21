package com.hrbb.loan.timer;

import java.util.Calendar;
import java.util.Date;
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
import com.hrbb.loan.pos.dao.TCallingTaskDao;
import com.hrbb.loan.pos.dao.TCreditApplyForReviewDao;
import com.hrbb.loan.pos.dao.TReceiptInfoDao;
import com.hrbb.loan.pos.dao.entity.TCallingTask;
import com.hrbb.loan.pos.dao.entity.TCreditApply;
import com.hrbb.loan.pos.util.IdUtil;
import com.hrbb.loan.pos.util.constants.ReviewNoteConstants;
import com.hrbb.sh.framework.HServiceException;

/**
 * @deprecated: (依据业务指示：暂时砍掉)消费贷 贷后管理 到期续约.
 * 当借款人剩余授信有效期为二个月时，系统会提示<授信复审岗>。
 * 经<授信复审岗>按照借/还款质量、到期前综合信用状况等数据模型的初审结果，进行是否予以续约的预审批。
 * 若预审通过，拟与客户续约，必须在授信到期一个月之前，通知客户，协助客户完成续约申请手续，
 * 如续约申请中提供了新的收入或资产证明，<授信复审岗>可根据该客户最新的申请资质和在互金部产品使用中的历史情况，
 * 得出最终的新授信额度和利率。
 * 
 * @author xiongshaogang
 * @version $Id: ZzSaleAppRiskContractExpiresTimer.java, v 0.1 2015年5月12日 下午6:09:12 xiongshaogang Exp $
 */
@Service("zzSaleAppRiskContractExpiresTimer")
public class ZzSaleAppRiskContractExpiresTimer {
	
	private static final Logger logger = LoggerFactory.getLogger(ZzSaleAppRiskContractExpiresTimer.class);
	
	@Autowired
	private TReceiptInfoDao tReceiptInfoDao;
	
	@Autowired
	private TCallingTaskDao tCallingTaskDao;
	
	@Autowired
	private TCreditApplyForReviewDao daoCA;
	
	@Scheduled(cron="0 0 12 * * ?")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class })
	public void run() throws HServiceException {
		logger.info("start ZzSaleAppRiskContractExpiresTimer...");
		
		// 当前日期
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 2);
		
		// 查询队列
		Map<String, Object> queryMap = Maps.newHashMap();
		queryMap.put("endDate", DateFormatUtils.format(calendar, "yyyyMMdd"));
		List<Map<String, Object>> riskContractExpiresList = tReceiptInfoDao.selectListMapsByTimer(queryMap);
		if (riskContractExpiresList == null || riskContractExpiresList.size() < 1) {
            logger.info("本次轮询队列为空，本日不再执行该任务！");
            return;
        }
		
		// 轮询执行队列
		for (Map<String, Object> map : riskContractExpiresList) {
            if (map.get("loanid") == null) {
                logger.info("loanid is null, 本次执行跳过！");
                continue;
            }
            
            // 暂时启动外呼任务 15: 问持卡人是否续贷?
            insertCallingTask("15", (String)map.get("loanid"));
        }
        
		logger.info("end ZzSaleAppRiskContractExpiresTimer!");
	}
	
	/**
     * 生成外呼任务
     * 
     */
    private int insertCallingTask(String callingType, String relaBizNo) {
    	
        TCallingTask ct = new TCallingTask();
        ct.setTaskNo(IdUtil.getId(ReviewNoteConstants.CALLING_TASK_KEY_PREFIX));
        ct.setGenerateTime(new Date());
        ct.setCallingType(callingType);
        ct.setRelaBizNo(relaBizNo);
        ct.setRelaBizPhase(ReviewNoteConstants.CALLING_TASK_RELABIZPHASE_APP);
		// 查询申请信息查询
		TCreditApply caForAppr = daoCA.selectOne(relaBizNo);
		ct.setCustId(caForAppr.getCustId());
		ct.setCustName(caForAppr.getCustName());
		ct.setPosCustId(caForAppr.getPosCustId());
		ct.setPosCustName(caForAppr.getPosCustName());
        return tCallingTaskDao.insertSelective(ct);
    }
}
