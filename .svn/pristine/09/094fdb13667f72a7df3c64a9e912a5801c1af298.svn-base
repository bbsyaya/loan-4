/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.facade;

import javax.jws.WebService;

import com.hrbb.loan.pos.facade.bean.blacklist.BlacklistInfo;
import com.hrbb.loan.pos.facade.bean.blacklist.BlacklistInfoInsertRes;
import com.hrbb.loan.pos.facade.bean.blacklist.BlacklistInfoUpdateRes;
import com.hrbb.loan.pos.facade.bean.blacklist.QueryBlacklistReq;
import com.hrbb.loan.pos.facade.bean.blacklist.QueryBlacklistRes;

/**
 * 黑名单服务
 * @author XLY
 * @version $Id: LoanPosBlacklistBizFacade.java, v 0.1 2015-2-28 下午3:01:41 XLY Exp $
 */
@WebService
public interface LoanPosBlacklistBizFacade {

    /**
     * 跟新用户信息
     * 
     * @param req
     * @return
     */
    BlacklistInfoUpdateRes updateBlacklistInfo(BlacklistInfo req);

    
    /**
     * 增加用户记录
     * 
     * @param res
     * @return
     */
    BlacklistInfoInsertRes addBlacklistInfo(BlacklistInfo req);
    
    /**
     * 批量查询黑名单
     * 
     * @param req
     * @return
     */
    QueryBlacklistRes queryBlackLists(QueryBlacklistReq req);
    
}
