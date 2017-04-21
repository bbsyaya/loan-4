package com.hrbb.loan.pos.biz.backstage.inter;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TPaybackApplyInfo;
import com.hrbb.loan.pos.dao.entity.TReceiptInfo;

public interface LoanPosPaybackBiz {

	List<TReceiptInfo> queryPaybackInfo(Map<String, Object> reqMap);

	TReceiptInfo getReceiptInfoByReceiptId(String receiptId);

	String getContNoByReceiptId(String receiptId);

	List<TReceiptInfo> getAllReceipts(Map<String, Object> reqMap);
	
	/**
	 * 增加还款申请
	 * 
	 * @param reqMap
	 * @return
	 */
	int savePaybackApply(TPaybackApplyInfo paybackApplyInfo);
	
	/**
	 * 查询还款申请信息
	 * @param reqMap
	 * @return
	 */
	public List<TPaybackApplyInfo> queryPaybackApplyList(Map<String, Object> reqMap);
	
	/**
	 * 针对还款申请执行还款操作
	 * 
	 * @param paybackApplyId
	 */
	public Map<String,Object> executeRepayment(String paybackApplyId);
	
	public Map<String,Object> executeRepayment(String paybackApplyId, String userName);

	long countNumber(Map<String, Object> reqMap);

	int updateReceipt(Map<String, Object> receiptMap);

    long countPaybackInfo(Map<String, Object> reqMap);

}
