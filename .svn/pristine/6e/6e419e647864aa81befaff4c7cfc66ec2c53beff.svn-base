package com.hrbb.loan.pos.service;

import java.util.Date;
import java.util.Map;
import java.util.List;

import com.hrbb.loan.pos.dao.entity.TAICAlterInfo;
import com.hrbb.loan.pos.dao.entity.TAICLiguidationInfo;
import com.hrbb.loan.pos.dao.entity.TAICMordetailInfo;
import com.hrbb.loan.pos.dao.entity.TAICMorguaInfo;
import com.hrbb.loan.pos.dao.entity.TAICSharesFrostInfo;
import com.hrbb.loan.pos.dao.entity.TAICSharesimpawnInfo;

public interface PoliceAndAICConnectService {
	
	
	public List<Map<String, Object>> queryPoliceInfoList(Map<String, Object> reqMap);
	
	public Map<String, Object> queryOnePoliceInfo(String custName, String idNo, Date queryTime);
	
	public void insertPoliceInfo(Map<String, Object> reqMap);
	
	public void insertAICAlidebtInfo(Map<String, Object> reqMap);
	
	public void insertAICBasicInfo(Map<String, Object> reqMap);
	
	public void insertAICCaseInfo(Map<String, Object> reqMap);
	
	public void insertAICEntinvInfo(Map<String, Object> reqMap);
	
	public void insertAICOrderlistInfo(Map<String, Object> reqMap);
	
	public void insertAICPersonInfo(Map<String, Object> reqMap);
	
	public void insertAICPunishBreakInfo(Map<String, Object> reqMap);
	
	public void insertAICPunishedInfo(Map<String, Object> reqMap);
	
	public void insertAICShareHolder(Map<String, Object> reqMap);
	
	public void insertAICFrinvInfo(Map<String, Object> reqMap);
	
	public void insertAICFrpositionInfo(Map<String, Object> reqMap);
	
	public List<Map<String, Object>> queryAICOrderlist(Map<String, Object> reqMap);
	
	public Map<String, Object> queryOneAICOrderlist(String posCustName);
	
    /**
     * 根据身份证号查询最新的公安信息
     * 
     * @param reqMap
     * @return
     */
    public List<Map<String, Object>> selectByCertNo(Map<String, Object> reqMap);
    
    /**
     * 更新公安信息
     */
    public int updatePoliceInfo(Map<String, Object> reqMap);
    
    /**
     * 查询商户工商信息
     * 
     * @param posCustId
     * @return
     */
    public Map<String,List<Map<String,Object>>> queryAicInfo(String posCustName, String posCustId);
    
    
    public void insertShareFrost(TAICSharesFrostInfo taicSharesFrostInfo);
    
    public List<Map<String, Object>> getSharesFrost(Map<String, Object> reqMap);
    
    public void insertSharesimpaw(TAICSharesimpawnInfo taicSharesimpawnInfo);
    
    public List<Map<String, Object>> getSharesimpawnInfo(Map<String, Object> reqMap);
    
    public void insertMordetail(TAICMordetailInfo taicMordetailInfo);
    
    public List<Map<String, Object>> getMordetail(Map<String, Object> reqMap);
    
    public void insertMorguaInfo(TAICMorguaInfo taicMorguaInfo);
    
    public List<Map<String, Object>> getMorguaInfo(Map<String, Object> reqMap);
    
    public void insetAlterInfo(TAICAlterInfo taicAlterInfo);
    
    public List<Map<String, Object>> getAlterInfo(Map<String, Object> reqMap);
    
    public void insertLiquidationInfo(TAICLiguidationInfo taicLiguidationInfo);
    
    public List<Map<String, Object>> getLiquidationInfo(Map<String, Object> reqMap);
    
    
}
