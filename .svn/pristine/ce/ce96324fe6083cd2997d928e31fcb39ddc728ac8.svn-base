package com.hrbb.loan.pos.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrbb.loan.pos.dao.TCDCImportDao;
import com.hrbb.loan.pos.service.LoanPosCDCImportkService;
@Service("loanPosCDCImportkService")
public class LoanPosCDCImportkServiceImpl implements LoanPosCDCImportkService {
	@Autowired
	private TCDCImportDao tCDCImportDao;

	@Override
	public List<Map<String, Object>> getCDCImportListInfo() {
		return tCDCImportDao.getCDCImportListInfo();
	}
	

}
