package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TPoliceInfo;

public interface TPoliceInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TPoliceInfo record);

    int insertSelective(TPoliceInfo record);

    TPoliceInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TPoliceInfo record);

    int updateByPrimaryKey(TPoliceInfo record);
    
    public List<Map<String, Object>> selectSelectiveMap(Map<String, Object> reqMap);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
    
    /**
     * 根据身份证号查询最新的公安信息
     * 
     * @param reqMap
     * @return
     */
    public List<Map<String, Object>> selectByCertNo(Map<String, Object> reqMap);
    
    /**
     * @param loanId 根据贷款申请编号查询公安信息
     * @return 公安身份信息
     */
    TPoliceInfo selectByLoanId(String loanId);

	public int updateSelectiveMap(Map<String, Object> reqMap);
}