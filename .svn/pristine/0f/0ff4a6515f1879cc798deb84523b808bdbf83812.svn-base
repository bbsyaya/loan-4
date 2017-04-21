package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TPosSerialnoInfo;

public interface TPosSerialnoInfoDao {
    public int deleteByPrimaryKey(String posSerialNo);
    
    public int insert(TPosSerialnoInfo record);

    public int insertSelective(TPosSerialnoInfo record);

    public TPosSerialnoInfo selectByPrimaryKey(String posSerialNo);

    public int updateByPrimaryKeySelective(TPosSerialnoInfo record);

    public int updateByPrimaryKey(TPosSerialnoInfo record);
    
    public int insertSelectiveMap(Map<String, Object> map);

    public List<Map<String, Object>> selectMap(Map<String, Object> reqMap);

    public int updateByPrimaryKeySelectiveMap(Map<String, Object> reqMap);
    
    public Long countMap(Map<String, Object> reqMap);
    
    public int insertSelectiveMapBatch(List<Map<String, Object>> list);

    /**
     * 查询pos水流数量
     * 
     * @param loanId
     * @return
     */
    public Long countPosSerials(String loanId) ;
    /**
     * 根据loanId删除pos流水
     * 
     * @param loanId
     * @return
     */
    public int deleteByLoanId(String loanId);
    
    List<Map<String, Object>>  selectSumMap(Map<String,Object> reqMap);
    
    List<Map<String, Object>>  selectSumMapStdev(Map<String,Object> reqMap);
    
    List<Map<String, Object>>  selectSumBankCard(Map<String,Object> reqMap);

    List<Map<String, Object>>  selectCountMonth(Map<String,Object> reqMap);
    
    public List<Map<String, Object>>  selectSumMapReview2(Map<String,Object> reqMap);
    
    List<TPosSerialnoInfo>  selectTPosByMap(Map<String,Object> reqMap);
}