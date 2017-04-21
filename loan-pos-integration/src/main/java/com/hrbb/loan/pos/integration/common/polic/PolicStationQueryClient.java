package com.hrbb.loan.pos.integration.common.polic;

import com.hrbb.loan.pos.integration.common.polic.bean.PolicStationInfoReqBean;
import com.hrbb.loan.pos.integration.common.polic.bean.PolicStationInfoResBean;

/**
 * 公安局信息查询接口
 * https://api.nciic.com.cn/nciic_ws/services/NciicServices?wsdl
 * @author XLY
 * @version $Id: PolicstationQueryClient.java, v 0.1 2015-2-17 下午12:57:08 XLY Exp $
 */
public interface PolicStationQueryClient {

    /**
     * 查询公安局的信息
     * 
     * @param req
     * @return
     */
    PolicStationInfoResBean queryPolicStationInfo(PolicStationInfoReqBean req);
}
