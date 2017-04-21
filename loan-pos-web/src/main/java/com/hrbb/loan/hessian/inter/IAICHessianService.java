package com.hrbb.loan.hessian.inter;

import java.util.Map;

public interface IAICHessianService{
	
	public Map<String, String> getCustAICInfo(Map<String, ? extends Object> reqMap) throws Exception;
}
