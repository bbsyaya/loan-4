package com.hrbb.loan.pos.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.dao.TPaymentApplyDao;
import com.hrbb.loan.pos.dao.entity.TPaymentApply;
import com.hrbb.loan.pos.service.PaymentApplyService;
import com.hrbb.loan.pos.util.StringUtil;

@Service("paymentApplyService")
public class PaymentApplyServiceImpl implements PaymentApplyService {

	private static final String CUSTID = "custId";
	
	private static final String CONTNO = "contNo";
	

	private static final String PAYAPPLYID = "payApplyId";

	@Autowired
	private TPaymentApplyDao tPaymentApplyDao;
	
	private String STDSHNO = "stdshno";
	
	private String STDMERNO = "stdmerno";
	
	private String CHANNEL = "channel";
	
	@Override
	public void insertPaymentApply(Map<String, Object> reqMap) {
		tPaymentApplyDao.insertSelectiveMap(reqMap);
	}

	@Override
	public void updatePaymentApply(Map<String, Object> reqMap) {
		tPaymentApplyDao.updateSelectiveMap(reqMap);
	}

	@Override
	public Long countPaymentApplyMap(Map<String, Object> reqMap) {
		return tPaymentApplyDao.countPaymentApplyNum(reqMap);
	}

	@Override
	public List<Map<String, Object>> queryByStdmernoMap(Map<String, Object> reqMap) {
		return tPaymentApplyDao.queryByStdmerno(reqMap);
	}

	@Override
	public Long countPaymentApply(String custId, String stdshno, String stdmerno,
			String channel) {
		Map<String, Object> reqMap = Maps.newHashMap();
		if(!StringUtil.isEmpty(stdshno)){
			reqMap.put(STDSHNO, stdshno);
		}
		reqMap.put(STDMERNO, stdmerno);
		reqMap.put(CHANNEL, channel);
		if(!StringUtil.isEmpty(custId)){
			reqMap.put("custId", custId);
		}
		
		return countPaymentApplyMap(reqMap);
	}


	@Override
	public List<Map<String, Object>> queryByStdmerno(String custId, String payApplyId, String contNo, String stdshno,
			String stdmerno, String channel, String startnum, String recnum) {
		Map<String, Object> reqMap = Maps.newHashMap();
		if(!StringUtil.isEmpty(stdshno)){
			reqMap.put(STDSHNO, stdshno);
		}
		if(!StringUtil.isEmpty(stdmerno)){
			reqMap.put(STDMERNO, stdmerno);
		}
		if(!StringUtil.isEmpty(custId)){
			reqMap.put(CUSTID, custId);
		}
		if(!StringUtil.isEmpty(payApplyId)){
			reqMap.put(PAYAPPLYID, payApplyId);
		}
		if(!StringUtil.isEmpty(contNo)){
			reqMap.put(CONTNO, contNo);
		}
		
		reqMap.put(CHANNEL, channel);
		if(!StringUtil.isEmpty(startnum) && !StringUtil.isEmpty(recnum)){
			reqMap.put("startPage", Long.valueOf(startnum)-1 >=0 ? Long.valueOf(startnum)-1L : 0);
			reqMap.put("pageSize", Long.valueOf(recnum));
		}
		return queryByStdmernoMap(reqMap);
	}


    @Override
    public List<Map<String, Object>> queryPaymentApply(Map<String, Object> reqMap) {
        return tPaymentApplyDao.queryPaymentApply(reqMap);
    }

    @Override
    public List<Map<String, Object>> queryPaymentApply90(Map<String, Object> reqMap) {
        return tPaymentApplyDao.queryPaymentApply90(reqMap);
    }
    
    @Override
    public TPaymentApply queryById(String id) {
        
        return tPaymentApplyDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Map<String, Object>> queryPaymentListByZzApp(Map<String, Object> queryMap) {
        return tPaymentApplyDao.selectListByZzApp(queryMap);
    }

    @Override
    public List<Map<String, Object>> queryPaymentApplyByPayApplyId(Map<String, Object> reqMap) {
        return tPaymentApplyDao.queryPaymentApplyByPayApplyId(reqMap);
    }

	/** 
	 * @see com.hrbb.loan.pos.service.PaymentApplyService#selectRecordInfo()
	 */
	@Override
	public List<TPaymentApply> selectRecordInfoLending() {
		return tPaymentApplyDao.selectRecordInfoLending();
	}
	
	/** 
	 * @see com.hrbb.loan.pos.service.PaymentApplyService#selectRecordInfo()
	 */
	@Override
	public List<TPaymentApply> selectRecordInfoCommission() {
		return tPaymentApplyDao.selectRecordInfoCommission();
	}

    @Override
    public Long countPaymentApplys(Map<String, Object> reqMap) {
        return tPaymentApplyDao.countPaymentApplys(reqMap);
    }
    
    @Override
    public Long countPaymentApplys90(Map<String, Object> reqMap) {
        return tPaymentApplyDao.countPaymentApplys90(reqMap);
    }
    
    @Override
    public List<Map<String, Object>> queryAvailablePaymentApply(Map<String, Object> reqMap) {
        return tPaymentApplyDao.queryAvailablePaymentApply(reqMap);
    }

    @Override
    public Long countAvailablePaymentApplys(Map<String, Object> reqMap) {
        return tPaymentApplyDao.countAvailablePaymentApplys(reqMap);
    }

	@Override
	public BigDecimal getPaymentApplyInfocontno(String contno) {
		 return tPaymentApplyDao.getPaymentApplyInfocontno(contno);
	}

    @Override
    public List<Map<String, Object>> queryPaymentListBySlApp(Map<String, Object> queryMap) {
        return tPaymentApplyDao.selectListBySlApp(queryMap);
    }

	@Override
	public String getPaymentApplyIdByContno(String contno) {
		 return tPaymentApplyDao.getPaymentApplyIdByContno(contno);
	}

	@Override
	public Map<String, Object> queryByStdisno(Map<String, Object> reqMap) {
		return tPaymentApplyDao.queryByStdisno(reqMap);
	}

}
