package com.hrbb.loan.pos.biz.convert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.facade.bean.QueryCreditApplyReq;
import com.hrbb.loan.pos.facade.bean.QueryCreditApplyRes;
/**
 * 外部请求转换为内部请求
 * 
 * @author XLY
 * @version $Id: CreditApplyConvert.java, v 0.1 2015-2-15 上午11:27:32 XLY Exp $
 */
public class CreditApplyConvert {

    public static Map<String,Object> CreditApplyReq2Map(QueryCreditApplyReq req){
        Map<String,Object> reqMap = new HashMap<String,Object>();
        reqMap.put("id", req.getCreditId());
        return reqMap;
    }
    
    public static QueryCreditApplyRes Map2CreditApplyRe2( List<Map<String, Object>> result){
        QueryCreditApplyRes  res = new QueryCreditApplyRes();
        res.setResultNum(result.size());
        return res;
    }
}
