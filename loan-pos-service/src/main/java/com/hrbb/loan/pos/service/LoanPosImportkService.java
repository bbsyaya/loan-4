package com.hrbb.loan.pos.service;

import java.util.List;
import java.util.Map;

public interface LoanPosImportkService {
	List<Map<String, Object>> getImportListInfo();

	int insertImportData(Map<String, Object> importMap); 
}
