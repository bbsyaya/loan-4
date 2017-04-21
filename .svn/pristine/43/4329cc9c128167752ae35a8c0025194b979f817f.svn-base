package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TBankAccnoInfo;

public interface TBankAccnoInfoDao {
    public int deleteByPrimaryKey(String bankAccno);

    public int insert(TBankAccnoInfo record);

    public int insertSelective(TBankAccnoInfo record);
    
    public int insertSelectiveMap(Map<String, Object> map);

    public List<Map<String, Object>> selectMap(Map<String, Object> reqMap);

    public int updateByPrimaryKeySelectiveMap(Map<String, Object> reqMap);
    
    public TBankAccnoInfo selectByPrimaryKey(String bankAccno);
    

    public int updateByPrimaryKeySelective(TBankAccnoInfo record);
    

    public int updateByPrimaryKey(TBankAccnoInfo record);
    /**
     * 获取记录总数
     * @param reqMap
     * @return
     */
    public long selectAccountCount(Map<String, Object> reqMap);

	public String getLoanBankNameByBankAccno(String bankAccno);
}