package com.hrbb.loan.pos.biz.backstage.inter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.biz.backstage.inter.UserApprInfoBiz;
import com.hrbb.loan.pos.dao.entity.TUserApprInfo;
import com.hrbb.loan.pos.service.UserApprInfoService;

/**
 * <h1>查询操作者的审批额度信息</h1>
 * 
 * @author marco
 * @version Id: UserApprInfoServiceImpl.java, v 1.0 2015-3-9 下午3:46:36 marco Exp
 */
@Service("userApprInfoBiz")
public class UserApprInfoBizImpl implements UserApprInfoBiz {

	@Autowired
	private UserApprInfoService userApprInfoService;

	@Override
	public TUserApprInfo selectByPrimaryKey(String userName) {
		return userApprInfoService.selectByPrimaryKey(userName);
	}

}
