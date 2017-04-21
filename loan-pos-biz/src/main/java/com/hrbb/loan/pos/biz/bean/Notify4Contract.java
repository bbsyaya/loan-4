/**
 * 
 */
package com.hrbb.loan.pos.biz.bean;

import com.hrbb.loan.pos.dao.TContractInfoDao;
import com.hrbb.loan.pos.dao.TCreditApplyDao;
import com.hrbb.loan.pos.dao.entity.TContractManagement;
import com.hrbb.loan.pos.dao.entity.TCreditApply;
import com.hrbb.loan.pos.entity.SpringBeans;
import com.hrbb.loan.pos.factory.SysConfigFactory;
import com.hrbb.loan.pos.service.LoanPosCreditApplyService;
import com.hrbb.sh.framework.HServiceException;
import com.hrbb.sh.framework.ftp.HttpClient;
import com.hrbb.sh.framework.ftp.ParamReqBean;
import com.hrbb.sh.framework.ftp.ParamResBean;

/**
 * <p>Title: Notify4Archive.java </p>
 * <p>Description: 通知文档服务器进行归档处理 </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年7月27日
 *
 * logs: 1. 
 */
public class Notify4Contract extends AbsInternalService {
	
	private String loanId;
	
	private String imagefilepackagename;
	
	private String url;
	
	public void setUrl(String url) {
		this.url = url;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public void setImagefilepackagename(String imagefilepackagename) {
		this.imagefilepackagename = imagefilepackagename;
	}

	@Override
	public boolean initService() throws HServiceException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean processService() throws HServiceException {
		logger.debug("通知ftp做文件上传处理...");
		logger.debug("loanid=" + loanId);
		
		String URL = SysConfigFactory.getInstance().getService("basicService").getPropertyValue("webUrl");
		
		TCreditApplyDao creditDao = (TCreditApplyDao)SpringBeans.getBean("tCreditApplyDao");
		
		TContractInfoDao contractInfoDao = (TContractInfoDao)SpringBeans.getBean("tContractInfoDao");
		
		TCreditApply apply = creditDao.selectByPrimaryKey(loanId);
		TContractManagement contract = contractInfoDao.selectContractInfoByLoanId(loanId);
		logger.info("apply:" + apply +"contract:" +contract);
		if(apply != null && contract != null){
			logger.debug("imagefilepackagename=" + imagefilepackagename);
			// ftp请求参数
			ParamReqBean paramReqBean = new ParamReqBean();
			paramReqBean.setKeyValue(
					"InstNo",
					"BD");
			paramReqBean.setCustId(apply.getCustId());
			logger.debug("CustId=" + apply.getCustId());
			paramReqBean.setVersion("1.0.0");
			paramReqBean.setBizType("0001");
			paramReqBean.setTransType("0001");
			paramReqBean.setKeyValue(
					"Prefix",
					"APP");
			paramReqBean.setKeyValue(
					"RemoteFileName",
					imagefilepackagename);
			logger.debug("不等贷回调LocalSubFolderNameDef:" + apply.getLoanId());
			paramReqBean.setKeyValue(
					"LocalSubFolderNameDef",
					loanId);
			paramReqBean.setKeyValue("ctNo", contract.getContNo());
			paramReqBean.setKeyValue("url",
					URL + "contractManagement/updateContractStatus.do");
			
			logger.debug("paramReqBean = " + paramReqBean.toURLParam());
			ParamResBean paramResBean = HttpClient.send(paramReqBean);
			if (paramResBean == null) {
				rspResult.put("respCode", "999");
				rspResult.put("respMsg", "HttpClient error!");
				return false;
			} else {
				String respCode = paramResBean.getRespCode();
				rspResult.put("respCode", paramResBean.getRespCode());
				rspResult.put("respMsg", paramResBean.getRespMsg());
				if(respCode!=null && respCode.equals("000")){
					return true;
				}else{
					return false;
				}
			}
			
		}else{
			logger.info("没有合同或申请信息");
			return false;
		}
	}

	@Override
	public boolean processService(String fileName, byte[] bytes)
			throws HServiceException {
		// TODO Auto-generated method stub
		return false;
	}

}
