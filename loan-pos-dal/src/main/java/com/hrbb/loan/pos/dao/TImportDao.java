package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

public interface TImportDao {
	public List<Map<String, Object>> getImportListInfo();

	public int insertImportData(Map<String, Object> importMap);
}
