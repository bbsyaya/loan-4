package com.hrbb.loan.hessian.inter;

import java.util.Map;

public interface IBankCardCheckHessianService {
	
	public Map<String, String> bankCardCheck(Map<String, String> reqMap);
}
