/**
 * 
 */
package com.hrbb.loan.pos.entity.event;

import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.entity.listener.POSListener;


/**
 * <p>Title: EventsSource.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年7月8日
 *
 * logs: 1. 
 */
public class POSEventsSource {
	
	/**/
	private Map<String,Object> attributes = Maps.newHashMap();
	
	private Vector<POSListener> repository = new Vector<POSListener>();//监听自己的监听器队列 
	  
	public void addListener(POSListener lsnr) {     
	       repository.addElement(lsnr);
	}
	public void notifyEvent() throws EventException {	//通知所有的监听器     
	       Enumeration<POSListener> lsnrs = repository.elements();     
	       while(lsnrs.hasMoreElements()) {     
	    	   POSListener lsnr = (POSListener)lsnrs.nextElement();     
	    	   lsnr.handleEvent(EventFactory.getInstance().getEvent(lsnr.getType(), this));     
	        }
	 } 
	
	public void setAttribute(String id, Object value){
		attributes.put(id, value);
	}
	
	public Object getAttribute(String id){
		return attributes.get(id);
	}
	
}
