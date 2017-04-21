/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.spi.KQ;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosContractManagementBiz;
import com.hrbb.loan.pos.dao.TApproveResultDao;
import com.hrbb.loan.pos.dao.TCreditApplyForReviewDao;
import com.hrbb.loan.pos.dao.entity.TApproveResult;
import com.hrbb.loan.pos.dao.entity.TCallingTask;
import com.hrbb.loan.pos.dao.entity.TCreditApply;
import com.hrbb.loan.pos.service.CallingTaskService;
import com.hrbb.loan.pos.util.IdUtil;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.pos.util.constants.ReviewNoteConstants;
import com.hrbb.loan.spi.POSHService;
import com.hrbb.loan.spi.TC.TCApprResultConfirmServiceImpl;
import com.hrbb.loan.spi.TC.TCCreditApplyHServiceImpl;
import com.hrbb.loan.spiconstants.HServiceReturnCode;
import com.hrbb.loan.spiconstants.PaymentApplyHServiceConstants;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HService;
import com.hrbb.sh.framework.HServiceException;

/**
 * 线上审批结果确认反馈HB05
 * 
 * @author marco
 * @version $Id: UMApprResultConfirmServiceImpl.java, v 0.1 2015-6-3 下午5:47:06
 *          marco Exp $
 */
@Service("kqApprResultConfirm")
public class KQApprResultConfirmServiceImpl extends TCApprResultConfirmServiceImpl {

	@Override
	public String getChannel() {
		return POSHService.进件渠道_快钱;
	}

}
