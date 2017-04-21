/**
 * 
 */
package com.hrbb.loan.pos.entity.event;

import java.util.HashMap;
import java.util.Map;

import com.hrbb.loan.pos.entity.event.EventException;

/**
 * <p>Title: POSMessage.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年7月8日
 *
 * logs: 1. 
 */
public interface ListenerEventAction {
	
	public static final int  监听事件类型_外呼任务_用款审核拒绝 = 21;
	
	/**
	 * 银商的返回代码转换
	 */
	public static final Map<String,String> returnKindUM = new HashMap<String,String>(){
		private static final long serialVersionUID = 1L;
		{
			put("90", "01");
		}
	};
	
	public void execute() throws EventException;
}
