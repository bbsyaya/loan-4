/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.controller.converts;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.constants.black.BlacklistCertTypeEnum;
import com.hrbb.loan.constants.black.BlacklistEffectFlagEnum;
import com.hrbb.loan.constants.black.BlacklistInfoTypeEnum;
import com.hrbb.loan.constants.black.BlacklistIntervalTypeEnum;

/**
 * 
 * @author XLY
 * @version $Id: BlacklistConverter.java, v 0.1 2015-3-4 下午7:05:00 XLY Exp $
 */
public class BlacklistConverter {

    /**
     * 
     * 
     * @param lists
     * @return
     */
    public static List<Map<String, Object>> blacklistConvert(List<Map<String, Object>> lists){
        for(Map<String, Object> map:lists){
            map.put("blacklistId", map.get("id"));
            if(null!=map.get("infoType"))map.put("infoType", BlacklistInfoTypeEnum.getDescByValue((String)map.get("infoType")));
            if(null!=map.get("certType"))map.put("certType", BlacklistCertTypeEnum.getDescByValue((String)map.get("certType")));
            if(null!=map.get("effectFlag"))map.put("effectFlag", BlacklistEffectFlagEnum.getDescByValue((String)map.get("effectFlag")));
            if(null!=map.get("intervalType"))map.put("intervalType", BlacklistIntervalTypeEnum.getDescByValue((String)map.get("intervalType")));
        }
        return lists;
    }
}
