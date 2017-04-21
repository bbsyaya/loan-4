package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TApproveResult;

public interface TApproveResultDao {
    int deleteByPrimaryKey(String approveId);

    int insert(TApproveResult record);

    int insertSelective(TApproveResult record);

    TApproveResult selectByPrimaryKey(String approveId);

    int updateByPrimaryKeySelective(TApproveResult record);

    int updateByPrimaryKey(TApproveResult record);

    TApproveResult selectByLoanId(String loanId);
    
    public List<Map<String, Object>> getExpiredRecord(Map<String, Object> reqMap);
    
    public int updateExpiredRecord(Map<String, Object> reqMap);
    
    public void batchUpdateRecord(List<Map<String, Object>> reqList);
    
    public Map<String, Object> getApproveMap(String approveId);
    
    public List<Map<String, Object>> getCallTask(Map<String, Object> reqMap);
    
    public int updateForReconsider(TApproveResult record);
    
    public int insertSelectiveToHist(TApproveResult record);

	int updateByApproveId(TApproveResult ar);

	int updateApproveResultInfo(Map<String, Object> approveBankMap);
}