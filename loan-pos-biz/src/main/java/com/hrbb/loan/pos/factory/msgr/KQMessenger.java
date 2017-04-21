/**
 * 
 */
package com.hrbb.loan.pos.factory.msgr;

import com.hrbb.loan.pos.factory.SysConfigFactory;

/**
 * <p>Title: TCMessenger.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Aug 26, 2015
 *
 * logs: 1. 
 */
public class KQMessenger extends AbsHttpMessener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4995452024442374368L;
	
	private String messageUrl;
	
	public KQMessenger(){
		messageUrl = SysConfigFactory.getInstance().getService(getChannel()).getPropertyValue("messageUrl");
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.factory.msgr.MessengerService#getChannel()
	 */
	@Override
	public String getChannel() {
		return "KQ";
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.factory.msgr.MessengerService#getEncryptedRander()
	 */
	@Override
	public String getEncryptedRander() {
		// TODO Auto-generated method stub
		return "kq";
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.factory.msgr.MessengerService#getTransCode()
	 */
	@Override
	public String getTransCode() {
		return "KQT15";
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.factory.msgr.MessengerService#getUrl()
	 */
	@Override
	public String getUrl() {
		return messageUrl;
	}

}
