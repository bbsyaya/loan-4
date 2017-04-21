/**
 * 
 */
package com.hrbb.loan.pos.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TApplyNotifyDao;
import com.hrbb.loan.pos.dao.entity.TApplyNotify;
import com.hrbb.loan.pos.service.LoanPosBusinessCodeService;
import com.hrbb.loan.pos.service.TNotifyAssistantService;

/**
 * <p>Title: TNofifyAssitantServiceImpl.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Sep 7, 2015
 *
 * logs: 1. 
 */
@Service("tNotifyAssistantService")
public class TNotifyAssistantServiceImpl implements TNotifyAssistantService {
	
	@Autowired
	private TApplyNotifyDao tApplyNotifyDao;
	
	@Autowired
	private LoanPosBusinessCodeService loanPosBusinessCodeService;
	
	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.service.TNofifyAssitantService#selectTimelyApproval(java.util.Map)
	 */
	@Override
	public List<TApplyNotify> selectTimelyApproval(Map<String, Object> request) {
		List<TApplyNotify> records = tApplyNotifyDao.selectTimelyApproval(request);
		for(TApplyNotify record:records){
			String refuseReason = record.getRefuseReason();
			if(refuseReason!=null && refuseReason.trim().length()>0){
				String reasonMemo = loanPosBusinessCodeService.getSplitedItemName("RefuseReaon", refuseReason.trim(), "\\|");
				if(reasonMemo!=null && reasonMemo.trim().length()>0) record.setRefuseReason(reasonMemo);
			}
		}
		return records;
	}

}
