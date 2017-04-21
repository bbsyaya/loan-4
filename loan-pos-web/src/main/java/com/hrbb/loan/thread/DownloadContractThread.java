package com.hrbb.loan.thread;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosCreditApplyBackStageBiz;

@Scope("prototype")
@Component("downloadContract")
public class DownloadContractThread implements Runnable {

	private Map<String, Object> reqMap;
	
	@Autowired
	private ILoanPosCreditApplyBackStageBiz iLoanPosCreditApplyBackStageBiz;
	
	private Logger logger = LoggerFactory.getLogger(DownloadContractThread.class);
	
	
	public Map<String, Object> getReqMap() {
		return reqMap;
	}



	public void setReqMap(Map<String, Object> reqMap) {
		this.reqMap = reqMap;
	}



	@Override
	public void run() {
		try{
			boolean uploadImg = iLoanPosCreditApplyBackStageBiz.downloadContract(reqMap);
			if(uploadImg){
				logger.info(reqMap + "通知下载成功");
			}else{
				logger.error(reqMap + "通知下载合同失败");
			}
		}catch(Exception e){
			logger.error("调影像资料下载异常:", e);
		}
	}

}
