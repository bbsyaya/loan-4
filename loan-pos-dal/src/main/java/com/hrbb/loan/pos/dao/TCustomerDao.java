package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCustomer;

public interface TCustomerDao {
	public int deleteByPrimaryKey(String custId);

	public int insert(TCustomer record);

	public int insertSelective(TCustomer record);

	public TCustomer selectByPrimaryKey(String custId);

	public List<TCustomer> selectSelective(Map<String, Object> map);

	public int updateByPrimaryKeySelective(TCustomer record);

	public int updateByPrimaryKey(TCustomer record);

	public List<Map<String, Object>> selectSelectiveMap(
			Map<String, Object> reqMap);

	public int insertSelectiveMap(Map<String, Object> reqMap);

	public int updateByPrimaryKeySelectiveMap(Map<String, Object> reqMap);

	public Long selectCountForRiskCheck(TCustomer record);
	
	/**
	 * @param loanId 申请编号
	 * @return 客户信息
	 */
	TCustomer selectByLoanId(String loanId);
}