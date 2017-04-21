package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfo;
import com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfoKey;

public interface TCreditApplyAprvInfoDao {
	int deleteByPrimaryKey(TCreditApplyAprvInfoKey key);

	int deleteSelective(TCreditApplyAprvInfo record);

	int insert(TCreditApplyAprvInfo record);

	int insertSelective(TCreditApplyAprvInfo record);

	TCreditApplyAprvInfo selectByPrimaryKey(TCreditApplyAprvInfoKey key);

	List<TCreditApplyAprvInfo> selectSelective(TCreditApplyAprvInfo record);

	int updateByPrimaryKeySelective(TCreditApplyAprvInfo record);

	int updateByPrimaryKey(TCreditApplyAprvInfo record);

	TCreditApplyAprvInfo selectNotSubmit(TCreditApplyAprvInfoKey key);

	TCreditApplyAprvInfo selectLastOne(TCreditApplyAprvInfo key);

	List<TCreditApplyAprvInfo> selectBackToInfo(TCreditApplyAprvInfo record);

	List<TCreditApplyAprvInfo> selectInforAuditList(TCreditApplyAprvInfo record);

	/**
	 * 获取正在处理的审批人信息
	 * 
	 * @author Lin, Zhaolin
	 * @param key
	 * @return
	 */
	TCreditApplyAprvInfo selectExecutor(TCreditApplyAprvInfoKey key);

	TCreditApplyAprvInfo selectLastSubbmitted(TCreditApplyAprvInfoKey key);

	int updateCreditApplyAprvInfoBySelective(Map<String, Object> reqMap);

	public String getApprIdByLessWork(String roleId);

    /**
     * @param 补件超时时间
     * @return 补件状态的申请超过2周的申请编号
     */
    List<String> selectByApprvBeginTime(String timeout);

    String getApprIdByRuleAndLessWork(List<String> apprIdList);

    List<String> getReviewPersons(String string);

    List<String> getReviewPersons2(Map<String, Object> map);

    String getApprIdFromList(List<String> ls);
}