package com.hrbb.loan.sale.service;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TBankAccnoInfo;
import com.hrbb.loan.pos.dao.entity.TCreditApply;
import com.hrbb.loan.pos.dao.entity.TPosSerialnoInfo;

/**
 * 消费贷申请服务类
 * @author litengfeng
 * @version $Id: LoanSaleApplyService.java, v 0.1 2015年5月13日 上午11:43:22 litengfeng Exp $
 */
public interface LoanSaleApplyService {
	
	public List<TCreditApply> getCreditApply(Map<String, Object> reqMap);
	
	public List<Map<String, Object>> getCreditApplyMap(Map<String, Object> reqMap);
	
	public int updateCreditApply(TCreditApply tCreditApply);
	
	public int updateCreditApplyMap(Map<String, Object> map);
	
	public int delCreditApply(String loanId);
	
	public int insertCreditApply(TCreditApply tCreditApply);
	
	public int insertCreditApplyMap(Map<String, Object> reqMap);
	
	public Long countCreditApply(Map<String, Object> reqMap);
	
	public int deleteBatch(List<String> loanIds);
	
	public Map<String, Object> getOneCreditApply(String loanId);
	
	public String selectLoanId(String stdshno, String channel);
	
	
	///////////////////////////////////////////////////////
	public List<Map<String, Object>> selectBankAccMap(Map<String, Object> reqMap);
	
	public Map<String, Object> selectOneBankAcc(String bankAccno);

    public int updateBankAccByPrimaryKeySelectiveMap(Map<String, Object> reqMap);
    
    public int insertBankAccSelectiveMap(Map<String, Object> map);
    
    //////////////////////////////////////////////////////
    
    public List<Map<String, Object>> selectPosCustMap(Map<String, Object> reqMap);
    
    public Map<String, Object> selectOnePosCustMap(String posCustName);
    
    public Map<String, Object> selectOnePosCustMapById(String posCustId);

    public int updatePosCustByPrimaryKeySelectiveMap(Map<String, Object> reqMap);
    
    public int insertPosCustSelectiveMap(Map<String, Object> map);
    
    //////////////////////////////////////////////////////////
    public List<Map<String, Object>> selectPosSerialMap(Map<String, Object> reqMap);

    public int updatePosSerialByPrimaryKeySelectiveMap(Map<String, Object> reqMap);
    
    public int insertPosSerialSelectiveMap(Map<String, Object> map);
    
    public int insertPosSerialSelectiveMapBatch(List<Map<String, Object>> insertList);
    
    ////////////////////////////////////////////////////////////
    public List<Map<String, Object>> selectBankSerialMap(Map<String, Object> reqMap);
    
    public List<Map<String, Object>> selectMapByCurrMonth(Map<String, Object> reqMap);
    
    public int updateBankSerialMap(Map<String, Object> reqMap);
    
    public int insertBankSerialMap(Map<String, Object> reqMap);
    
	public TCreditApply queryCreditApply(String loanId);
	
	public String getCustIdbyStdshno(String stdshno);
	
	public String getLoanIdbyStdshno(String stdshno);
    
    public Long countBankSerialNum(Map<String, Object> reqMap);
    
    public Long countPosSerialNum(Map<String, Object> reqMap);
    
    /////////////////////////////channelposcust/////////////////////
    
    public List<Map<String, Object>> selectChannelPosCustSelectiveMap(Map<String, Object> reqMap);
    
    public void insertChannelPosCustSelectiveMap(Map<String, Object> reqMap);
    
    public  Map<String, Object> selectOneChannelPosCustSelectiveMap(Map<String, Object> reqMap);
    
    public Map<String, Object> selectOneChannelPosCustByEle(String channelPoscustId, String channel);

	public String getCustIdbyPosCustId(String posCustId);

	public String getLoanIdbyPosCustId(String posCustId);

	public String getStdshnobyPosCustId(String posCustId);
    
    public List<Map<String, Object>> queryChannelDetail(String stdshno, String stdmerno, String channel, Long startPage, Long long1);
    
    public List<Map<String, Object>> queryChannlDetailMap(Map<String, Object> reqMap);
    
    public Long countChannelDetail(String stdshno, String stdmerno, String channel);
    
    public Long countChannelDetailMap(Map<String, Object> reqMap);
    
	public List<Map<String, Object>> queryListBySaleApp(Map<String, Object> queryMap);
    //add by cjq 
    /**
     * 查询pos流水数量
     * 
     * @param loanId
     * @return
     */
    public Long countPosSerials(String loanId);
    
    /**
     * 删除pos流水
     * @param loanId
     * @return
     */
    public int deletePosSerial(String loanId);
    //end by cjq
    
    public int updateApplyStatus(Map<String, Object> updateMap);
    
    //获取业务数据--导出excel时使用
    public List<Map<String, Object>> getBizData(Map<String, Object> reqMap);
    
    public List<TPosSerialnoInfo> selectTPosByMap(Map<String, Object> reqMap);
    
    public TBankAccnoInfo selectByBankAccno(String bankAccno);
	
}
