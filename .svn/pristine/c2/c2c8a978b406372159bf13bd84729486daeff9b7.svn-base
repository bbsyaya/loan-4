package com.hrbb.loan.timer;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrbb.loan.pos.biz.backstage.inter.SynFileUploadBiz;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.constants.ReviewNoteConstants;
import com.hrbb.sh.framework.HServiceException;

/**
 * 银商周报文件作成并上传
 * 
 * @author marco
 * @version $Id: POSSynFileTimer.java, v 0.1 2015年5月27日 下午4:45:50 marco Exp $
 */
@Service("POSSynFileTimer")
public class POSSynFileTimer {

	private Logger logger = LoggerFactory.getLogger(POSSynFileTimer.class);

	@Autowired
	@Qualifier("synFileUploadBiz")
	private SynFileUploadBiz bizUpload;

	/**
	 * 定时查询放款结果
	 * 
	 */
	// @Scheduled(cron = "0 30 12 ? * FRI")
	@Scheduled(cron = "0 30 12 * * ?")
	// @Scheduled(cron = "0/30 * * * * *")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void run() throws HServiceException {

		logger.info("POSSynFileTimer begin");
		// 生成并上传文件
		bizUpload.makeAndUpload(ReviewNoteConstants.CHANNEL_CODE_UM,
				DateUtil.getDateToString3(new Date()), true);
		logger.info("POSSynFileTimer end");
	}
}
