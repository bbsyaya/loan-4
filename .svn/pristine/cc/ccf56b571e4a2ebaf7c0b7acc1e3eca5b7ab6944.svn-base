package com.hrbb.loan.pos.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TChannelPoscustInfoDao;
import com.hrbb.loan.pos.service.LoanPosChannelPosCust;
@Service("loanPosChannelPosCust")
public class LoanPosChannelPosCustImpl implements LoanPosChannelPosCust {
	@Autowired
	private TChannelPoscustInfoDao tChannelPoscustInfoDao;
	@Override
	public String getPosCustIdbyStdmerno(String stdmerno) {
		return tChannelPoscustInfoDao.getCustIdbyStdshno(stdmerno);	
	}

    @Override
    public String getchannelPosCustId(Map<String,Object> reqMap) {
        return tChannelPoscustInfoDao.selectchannelPosCustId(reqMap); 
    }
}
