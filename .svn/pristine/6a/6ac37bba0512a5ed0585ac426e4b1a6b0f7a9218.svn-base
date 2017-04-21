package com.hrbb.loan.pos.dao;

import com.hrbb.loan.pos.dao.entity.TFixLineInfo;

public interface TFixLineInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TFixLineInfo record);

    int insertSelective(TFixLineInfo record);

    TFixLineInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TFixLineInfo record);

    int updateByPrimaryKey(TFixLineInfo record);
    
    /**
     * @param telNum 座机号码
     * @return 根据给座机号码返回固话综合信息
     */
    TFixLineInfo selectByTelNum(String telNum);
    
    void updateByTelNumSelective(TFixLineInfo record);
}