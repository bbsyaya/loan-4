package com.hrbb.loan.pos.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrbb.loan.pos.dao.TImportDao;
import com.hrbb.loan.pos.service.LoanPosImportkService;
@Service("loanPosImportkService")
public class LoanPosImportkServiceImpl implements LoanPosImportkService {
	@Autowired
	private TImportDao tImportDao;
	@Override
	public List<Map<String, Object>> getImportListInfo() {
		// TODO Auto-generated method stub
		return tImportDao.getImportListInfo();
	}
	@Override
	public int insertImportData(Map<String, Object> importMap) {
		// TODO Auto-generated method stub
		return tImportDao.insertImportData(importMap);
	}

}
