/**
 * 
 */
package com.hrbb.loan.pos.factory.msgr;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.hrbb.loan.pos.entity.SpringBeans;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.MessageDigest;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HService;
import com.hrbb.sh.framework.util.BankUtil;

/**
 * <p>Title: UMMessenger.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Aug 26, 2015
 *
 * logs: 1. 
 */
public class UMMessenger extends AbsMessenger {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2464726810436953049L;
	
	private Map<String, Object> propMap = new HashMap<String, Object>();

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.factory.msgr.MessengerService#getChannel()
	 */
	@Override
	public String getChannel() {
		return "UM";
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.factory.msgr.MessengerService#getTransCode()
	 */
	@Override
	public String getTransCode() {
		return "HB13";
	}
	
	protected boolean initProcess() throws Exception{
		
		String msgInfo = getMessage().getMessageInfo();
		if(msgInfo!=null) msgInfo = msgInfo.replaceAll("\r\n", "").trim();	//换行符处理
		
		propMap.put("messagetype", getMessage().getMessageType());
		propMap.put("messageinfo", msgInfo);
		propMap.put("messageaddi", getMessage().getMessageAddi());
		propMap.put("custid", getMessage().getCustId());
		propMap.put("loanId", getMessage().getLoanId());
		propMap.put("contno", getMessage().getContNo());
		propMap.put(getListId(), getMessage().getListId());
		propMap.put("loanacno", getMessage().getLoanAcNo());
		String dateStr = DateUtil.getNowTime(DateUtil.HRRB_LONG_DATETIME_FORMAT_BRIEF);	//yyyyMMddHHmmss
		propMap.put("pushdate", dateStr);
		propMap.put("stdshno", getMessage().getStdshNo()==null?"":getMessage().getStdshNo().trim());
		propMap.put("stdmerno", getMessage().getStdMerNo()==null?"":getMessage().getStdMerNo().trim());
		propMap.put("srcReqDate", DateUtil.getNowTime(DateUtil.HRRB_SHORT_DATETIME_FORMAT_BRIEF));	//yyyyMMdd
		propMap.put("srcReqTime", DateUtil.getNowTime(DateUtil.HRRB_SHORT_DATETIME_FORMAT_BRIEF));
		propMap.put("srcReqId", "1");
		propMap.put("channelId", "002");
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(getMessage().getMessageType()).append('|')
				.append(getMessage().getMessageInfo()).append('|')
				.append(getMessage().getMessageAddi()).append('|')
				.append(getMessage().getCustId()).append('|')
				.append(getMessage().getLoanId()).append('|')
				.append(getMessage().getListId()).append('|')
				.append(getMessage().getLoanAcNo()).append('|')
				.append(dateStr).append('|')
				.append(getMessage().getStdshNo()).append('|')
				.append(getMessage().getStdMerNo());
		String signedMessage = "";
		try {
			signedMessage = BankUtil.getMD5(buffer.toString(), "GBK");
		} catch (Exception e) {
			try {
				signedMessage = MessageDigest.getDigestAsLowerHexString("MD5", buffer.toString());
			} catch (NoSuchAlgorithmException e1) {
				logger.warn("消息签名失败",e);
				return false;
			}
		}
		propMap.put("mac", signedMessage);
		
		return true;
	}
	
	protected boolean executeSend() throws Exception{
		//银商不发送messageType=7/13的消息
		if(getMessage().getMessageType().matches("(7|13)")) {
			logger.info("银商客户不推送7/13类型消息");
			return true;
		}
		
		
		try{
			HService hServiceum = (HService)SpringBeans.getBean("toUM");
			
			HRequest req = new HRequest();
			req.setBizType(getTransCode());
			req.setRequestTime(new Date());
			req.setProperties(propMap);
			
			logger.info(">>>>. CHANNEL is : " + getChannel());
			logger.info("hServiceum是"+hServiceum);
			
			HResponse res = new HResponse();
			res = hServiceum.serve(req);
			if(res==null){
				logger.info("["+getChannel()+"].id="+getMessage().getId()+" : response is null");
				return false;
			}
			
			logger.info(">>>>>>>>>>>发送结果为:" + res.getProperties());
//			String rspCode = res.getRespCode();
			String rspCode = (String)res.getProperties().get("RespCode");
//			logger.debug("["+getChannel()+"].id="+getMessage().getId()+" : "+rspCode);
			if(rspCode==null || !rspCode.equals("00000000")){
				return false;
			}
			logger.debug("["+getChannel()+"]消息发送成功! id="+getMessage().getId());

		}catch(Exception e){
			logger.error("银商消息发送失败!",e);
			return false;
		}
		
		return true;
	}
	
	@Override
	public String getListId(){
		return "listid";
	}

	@Override
	public String getEncryptedRander() {
		return null;
	}

	@Override
	public String getUrl() {
		return null;
	}

}
