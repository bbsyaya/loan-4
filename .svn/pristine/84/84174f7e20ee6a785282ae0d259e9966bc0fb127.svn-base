/**
 * 
 */
package com.hrbb.loan.pos.factory.msgr;

/**
 * <p>Title: MessengerFactory.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Aug 26, 2015
 *
 * logs: 1. 
 */
public class MessengerFactory {
	
	/**
	 * 根据渠道和进件方式获取消息推送对象
	 * @param channel
	 * @param implType
	 * @return
	 */
	public static MessengerService getMessenger(String channel,String implType){
		MessengerService messenger = null;
		
		channel = channel==null?"":channel.trim();		//trim the space of channel
		implType = implType==null?"":implType.trim();
		
		if(channel.equals("UM")){
			messenger = new UMMessenger();
		}else if(channel.equals("58")){
			messenger = new TCMessenger();
		}else if(channel.equals("HC")){
			messenger = new HCMessenger();
		}else if(channel.equals("RN")){
			messenger = new RNMessenger();
		}else if(channel.equals("SM")){
			messenger = new SMMessenger();
		}else if(channel.equals("ZY") && implType.equals("02")){	//开发商平台为ZY+02
//			messenger = new AGMessenger();
			messenger = new NullMessenger();
		}else if("ZZ".equals(channel) && "05".equals(implType)){
			messenger = new ZZMessenger();
		}else if(channel.equals("KQ")){
            messenger = new KQMessenger();
        }else if(channel.equals("WX")){
            messenger = new WXMessenger();
        }else{
			messenger = new NullMessenger();
		}
		
		return messenger;
	}
}
