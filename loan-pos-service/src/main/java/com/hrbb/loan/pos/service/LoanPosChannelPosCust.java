package com.hrbb.loan.pos.service;

import java.util.Map;

public interface LoanPosChannelPosCust {
	public String getPosCustIdbyStdmerno(String stdmerno);

    /**
     * 
     * @param reqMap
     * @return
     */
    String getchannelPosCustId(Map<String, Object> reqMap);

}
