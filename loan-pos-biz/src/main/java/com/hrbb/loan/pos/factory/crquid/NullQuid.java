/**
 * 
 */
package com.hrbb.loan.pos.factory.crquid;

/**
 * <p>Title: NullQuid.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Oct 7, 2015
 *
 * logs: 1. 
 */
public class NullQuid extends AbsCRQuid {
	
	public NullQuid(){
		this.quid = "nullId";
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.factory.crquid.ICRQuid#isNull()
	 */
	@Override
	public boolean isNull() {
		return true;
	}
	
	@Override
	public void accumulate() {
		super.accumulate();
		logger.debug("征信查询用户空对象第 "+ this.getTimesInCurrentMinite() +" 次调用.");
	}
}
