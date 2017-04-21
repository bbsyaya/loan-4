package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCustomerBase;
/**
 * 
 * 
 * @author XLY
 * @version $Id: TCustomerBaseDao.java, v 0.1 2015-3-4 下午5:09:13 XLY Exp $
 */
@Deprecated
public interface TCustomerBaseDao {
    public int deleteByPrimaryKey(String custId);

    public int insert(TCustomerBase record);

    public int insertSelective(TCustomerBase record);

    public TCustomerBase selectByPrimaryKey(String custId);
    
    public List<TCustomerBase> selectSelective(Map<String, Object> map);

    public int updateByPrimaryKeySelective(TCustomerBase record);

    public int updateByPrimaryKey(TCustomerBase record);
}