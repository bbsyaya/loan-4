package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TContractInfo;
import com.hrbb.loan.pos.dao.entity.TContractManagement;

public interface TContractInfoDao {
    int deleteByPrimaryKey(String contno);

    int insert(TContractInfo record);

    int insertSelective(TContractInfo record);

    TContractInfo selectByPrimaryKey(String contno);

    int updateByPrimaryKeySelective(TContractInfo record);

    int updateByPrimaryKey(TContractInfo record);
    
    List<Map<String, Object>> selectSelectiveMap(Map<String, Object> reqMap);
    
    public Long countSelectiveMap(Map<String, Object> reqMap);
    
    public int updateSelectiveMapByKey(Map<String, Object> reqMap);
    
    public List<Map<String, Object>> selectByZzApp(Map<String, Object> map);
    
    /**
     * 查询满足用款申请的协议列表
     * 
     * @param reqMap
     * @return
     */
    List<Map<String, Object>> selectAvalibleSelectiveMap(Map<String, Object> reqMap);
    
    /**
     * 获取满足用款申请的协议总数
     * 
     * @param reqMap
     * @return
     */
    Long countAvalibleSelectiveMap(Map<String, Object> reqMap);

    List<Map<String, Object>> getApproveMap(String loanId);
	
	TContractManagement selectContractInfoByLoanId(String loanId);
}