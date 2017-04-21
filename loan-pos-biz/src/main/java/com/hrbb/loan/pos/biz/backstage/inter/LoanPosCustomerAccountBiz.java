package com.hrbb.loan.pos.biz.backstage.inter;

import java.util.List;
import java.util.Map;

public interface LoanPosCustomerAccountBiz {
	Map<String,Object> getCustomerAccountInfoByCustId(String custId);

	int insertCustomerAccount(Map<String, Object> bankAccNoMap);

	int updateCustomerAccount(Map<String, Object> bankAccNoMap);

	List<Map<String, Object>> getAllInnerAccountList(Map<String, Object> accno);

	long countAccountNumber(Map<String, Object> accno);
}
