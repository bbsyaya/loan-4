package com.hrbb.loan.pos.biz.backstage.inter;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.hrbb.loan.pos.dao.entity.TCreditApply;


/**
 *<h1></h1>
 *@author Johnson Song
 *@version Id: ILoanPosCreditApplyBackStageBiz.java, v 1.0 2015-2-28 上午11:12:22 Johnson Song Exp
 */
public interface ILoanPosCreditApplyBackStageBiz {
	/**
	 * 申请信息登记
	 * @param map
	 * @return
	 */
	public Map<String, Object>  creditApplyReg(Map<String, Object> creMap, Map<String, Object> custMap, Map<String, Object> posCustMap, Map<String, Object> bankMap, Map<String, Object> relMap,List<Map<String, Object>>bankSerList);
	
	/**
	 * 申请信息查询
	 * @param map
	 * @return list
	 */
	public List<Map<String, Object>> queryCreditApply(Map<String, Object> reqMap);
	
	
	
	public boolean hasCreditInvestigate(Map<String, Object> reqMap);
	
	public boolean downloadContract(Map<String, Object> reqMap);
	
	
	
	/**
	 * 申请信息浏览
	 * @param map
	 * @return map
	 */
	public Map<String, Object> queryCreditApplyDetail(Map<String, Object> reqMap);
	
	/**
	 * 登记信息修改
	 * @param map
	 * @return 
	 */
	public void modifyCreditApplyInfo(Map<String, Object> creMap, Map<String, Object> custMap, Map<String, Object> posCustMap, Map<String, Object> bankMap, Map<String, Object> relMap,List<Map<String, Object>> bankSerList);
	
	 /**
     * 记录修改痕迹的更新申请信息
     * 
     * @param creMap
     * @param custMap
     * @param posCustMap
     * @param bankMap
     * @param relMap
     * @param user 操作人
     */
    public void updateApplyWithTrack(Map<String,Object> creMap,Map<String,Object> custMap, Map<String,Object> posCustMap, Map<String,Object> bankMap, Map<String,Object> relMap, String user);
	
    /**
     * 更新后生成同步消息
     * @param creMap
     * @param custMap
     * @param posCustMap
     * @param bankMap
     * @param relMap
     * @param user
     */
    public void updateApplyWithSync(Map<String,Object> creMap,Map<String,Object> custMap, Map<String,Object> posCustMap, Map<String,Object> bankMap, Map<String,Object> relMap, String user);
    
    public void deleteCreditApplyInfo(Map<String, Object> reqMap);
	/**
	 * 登记记录撤销
	 * @param map
	 * @return
	 */
	public void cancelCreditApply(Map<String, Object> reqMap);


	TCreditApply queryCreditApplyDetail(String loanId);
	
	public boolean uploadPosSerial(File file, String posChannel, String posType, String loanId) throws Exception;
	
	public List<Map<String, Object>> getCreditApplyDetail(String loanId);
	
	public JSONObject getPosSerialDetail(String loanId, Integer pageNo, Integer pageSize);
	
	public JSONObject getBankSerialDetail(String loanId, Integer pageNo, Integer pageSize);
	
	public boolean updloadPosSerial(String posChannel, String posType, List<Map<String, Object>> posSerialMapList);
	
	public List<Map<String, Object>> getCreditApplyDetailByStdshno(String stdshno, String channel);
	
	public Map<String, Object> getCreditApplyDetailByShmerno(String stdshno, String shmerno, String startnum, String recnum, String channel);
	
	/**
	 * 查询pos流水数目
	 * 
	 * @param loanId
	 * @return
	 */
	public Long countPosSerials(String loanId);
	/**
	 * 删除pos流水
	 * 
	 * @param loanId
	 */
	public void deletePosSerial(String loanId);
	/**
	 * 调用征信接口
	 * 
	 */
	public Map<String, Object> creditInvestigate(Map<String, Object> custMap);
	
	public List<Map<String, Object>> queryCreditApplyDetailByZzApp(String loanId, String custId,
        String paperKind,
        String paperId, String custName,
        String beginDate, String endDate);
	
	public boolean getUmImg(Map<String, Object> reqMap);

	public List<Map<String, Object>> selectSelectiveMap(Map<String, Object> custMap);
	
	public Long selectSelectiveCount(Map<String, Object> custMap);
	
	public Map<String, String> getAllBankMapByChannel(String channel);

    /**
     * 同步影像件处理
     * 
     * @param reqMap
     * @return
     */
    boolean getImgSync(Map<String, Object> reqMap);
    
    public Map<String, Object> uploadCreditInvestHtml(Map<String, Object> reqMap);
    
    /**
     * 获取进件方式
     * 
     * @param loanId
     * @return
     */
    public String getInChannelKindByLoanId(String loanId);
    

    /**
     * 查询还款计划
     */
    
    public Map<String, Object> queryRepaymentPlan(Map<String, Object> reqMap);

    /**
     * 获取贷款模式
     * 
     * @param loanId
     * @return
     */
    public String getLoanType(String loanId);

}
