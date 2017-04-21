package com.hrbb.loan.pos.biz.backstage.inter;

import com.hrbb.loan.pos.dao.entity.TUserApprInfo;

public interface UserApprInfoBiz {
	public TUserApprInfo selectByPrimaryKey(String userName);
}