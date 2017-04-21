package com.hrbb.loan.pos.integration.common.gongshangju;

import com.hrbb.loan.pos.integration.common.gongshangju.bean.GongshangjuInfoReqBean;
import com.hrbb.loan.pos.integration.common.gongshangju.bean.GongshangjuInfoResBean;

/**
 * 
 * 
 * @author XLY
 * @version $Id: GongshangjuQueryClient.java, v 0.1 2015-2-17 下午12:59:52 XLY Exp $
 */
public interface GongshangjuQueryClient {

    /**
     * 查询工商局的信息
     * 
     * @param req
     * @return
     */
    GongshangjuInfoResBean queryGongshangjuInfo(GongshangjuInfoReqBean req);
}
