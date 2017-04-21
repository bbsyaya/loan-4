/**
 * 
 */
package com.hrbb.loan.pos.factory.crquid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Title: AbsCRQuid.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Oct 7, 2015
 *
 * logs: 1. 
 */
public abstract class AbsCRQuid implements ICRQuid {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	protected String quid;
	
	protected int counter = 0;
	
	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.factory.crquid.ICRQuid#getId()
	 */
	@Override
	public String getId() {
		return quid;
	}
	
	/**
	 * 获取新周期内的ID
	 * @return
	 */
	public String getIdAsRenew(){
		resetCumulate();
		return getId();
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.factory.crquid.ICRQuid#isNull()
	 */
	@Override
	public boolean isNull() {
		return false;
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.factory.crquid.ICRQuid#getTimesInCurrentMinite()
	 */
	@Override
	public int getTimesInCurrentMinite() {
		return counter;
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.factory.crquid.ICRQuid#accumulate()
	 */
	@Override
	public void accumulate() {
		counter++;
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.factory.crquid.ICRQuid#resetCumulate()
	 */
	@Override
	public void resetCumulate() {
		counter = 0;
	}

}
