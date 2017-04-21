package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TPaybackApplyInfo;

public interface TPaybackApplyInfoDao {
    int deleteByPrimaryKey(String paybackApplyId);

    int insert(TPaybackApplyInfo record);

    int insertSelective(TPaybackApplyInfo record);

    TPaybackApplyInfo selectByPrimaryKey(String paybackApplyId);

    int updateByPrimaryKeySelective(TPaybackApplyInfo record);

    int updateByPrimaryKey(TPaybackApplyInfo record);

	List<TPaybackApplyInfo> getPaybackApplyInfo(Map<String, Object> reqMap);

	int updatePaybackApply(Map<String, Object> updateMap);
	
	List<Map<String, Object>> selectPaybackDetailsByMaps(Map<String, Object> map);
	
	List<Map<String, Object>> selectPaybackDetailsBySlApp(Map<String, Object> map);
	
	/**
	 * 查询还款申请信息
	 * @param reqMap
	 * @return
	 */
	public List<TPaybackApplyInfo> queryPaybackApplyList(Map<String, Object> reqMap);

	long countNumber(Map<String, Object> reqMap);
	
	List<TPaybackApplyInfo> queryPaybackApplyInfo01();
	
	List<String> queryPaybackApplyIdList02();
	
	int updatePaybackApplyInfo(String paybackApplyId);

	
	
	//批量插入
	public void insertBatch(List<Map<String, Object>> list);
	
	//批量更新状态
	public void updateStatusBatch(List<Map<String, Object>> list);
	
	TPaybackApplyInfo queryPaybackApplyInfo(Map<String,Object> reqMap);

	List<TPaybackApplyInfo> getPaybackApplyInfoForAuto(
			Map<String, Object> reqMap);

}