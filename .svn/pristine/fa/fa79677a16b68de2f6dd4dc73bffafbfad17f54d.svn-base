package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TChannelPoscustInfo;

public interface TChannelPoscustInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TChannelPoscustInfo record);

    int insertSelective(TChannelPoscustInfo record);

    TChannelPoscustInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TChannelPoscustInfo record);

    int updateByPrimaryKey(TChannelPoscustInfo record);
    
    public int insertSelectvieMap(Map<String, Object> reqMap);
    
    public List<Map<String, Object>> selectSelectiveMap(Map<String, Object> reqMap);

    public List<Map<String, Object>> queryChannelDetail(Map<String, Object> reqMap);
    
    public Long countChannelDetail(Map<String, Object> reqMap);


	String getCustIdbyStdshno(String stdmerno);

    /**
     * 
     * @param reqMap
     * @return
     */
    String selectchannelPosCustId(Map<String, Object> reqMap);

}