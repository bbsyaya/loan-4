package com.hrbb.loan.pos.biz.backstage.inter;

import com.hrbb.loan.pos.dao.entity.TPoliceInfo;


public interface IAsyncLoadPoliceInfoService {
	
	public TPoliceInfo loadPoliceInfoInTime(String loanId);
	
	/**
	 * 异步调用逻辑，若有db中有数据，则返回，如果没有，则调用公安信息查询接口
	 * @param loanId 贷款编号
	 */
	public void loadPoliceInfo(String loanId);

}
