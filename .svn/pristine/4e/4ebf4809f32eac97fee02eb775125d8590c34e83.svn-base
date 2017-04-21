package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditApplyReturnInfo;
import com.hrbb.loan.pos.dao.entity.TCreditApplyReturnInfoKey;

public interface TCreditApplyReturnInfoDao {
    int deleteByPrimaryKey(TCreditApplyReturnInfoKey key);

    int insert(TCreditApplyReturnInfo record);

    int insertSelective(TCreditApplyReturnInfo record);

    TCreditApplyReturnInfo selectByPrimaryKey(TCreditApplyReturnInfoKey key);

    int updateByPrimaryKeySelective(TCreditApplyReturnInfo record);

    int updateByPrimaryKey(TCreditApplyReturnInfo record);
    
    /**
     * 返回一笔申请的所有(或指定)回池记录
     * @param req
     * @return
     */
    List<TCreditApplyReturnInfo> selectAllByKey(Map<String,Object> req);
}