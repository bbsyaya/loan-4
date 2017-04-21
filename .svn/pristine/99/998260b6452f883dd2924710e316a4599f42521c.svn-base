package com.hrbb.loan.timer;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrbb.loan.pos.biz.backstage.inter.SynFileSummaryBiz;
import com.hrbb.loan.pos.factory.SysConfigFactory;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.constants.ReviewNoteConstants;
import com.hrbb.sh.framework.HServiceException;

/**
 * 汇总报表文件作成并上传
 * 
 * @author marco
 * @version $Id: POSSynSumFileTimer.java, v 0.1 2015年5月27日 下午4:45:50 marco Exp $
 */
@Service("POSSynSumFileTimer")
public class POSSynSumFileTimer {

	private Logger logger = LoggerFactory.getLogger(POSSynSumFileTimer.class);

	@Autowired
	@Qualifier("synFileSummaryBiz")
	private SynFileSummaryBiz biz;

//	@Value("#{systemInfo[synFileUploanEnable]}")
//	private boolean synFileUploanEnable;

	/**
	 * 定时查询放款结果
	 * 
	 */
	// @Scheduled(cron = "0 30 12 ? * FRI")
	@Scheduled(cron = "0 35 12 * * ?")
	// @Scheduled(cron = "0/30 * * * * *")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void run() throws HServiceException {

		logger.info("POSSynSumFileTimer begin");
		// 生成文件
		Map<String, String> resp = biz.makeSynFile(
				ReviewNoteConstants.CHANNEL_CODE_UM, null,
				DateUtil.getDateToString3(new Date()));
		// 生成文件成功
		if ("0".equals(resp.get("code"))) {
			String synFileUploadEnable = SysConfigFactory.getInstance().getService("uploadService").getPropertyValue("synFileUploadEnable");
			if (synFileUploadEnable.toLowerCase().matches("(true|t|yes|y)")) {
				biz.upload(resp.get("fileName"));
			}
		}
		// 上传文件
		logger.info("POSSynSumFileTimer end");
	}
}
