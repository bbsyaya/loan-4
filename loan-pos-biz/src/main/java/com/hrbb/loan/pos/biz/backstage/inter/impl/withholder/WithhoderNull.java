package com.hrbb.loan.pos.biz.backstage.inter.impl.withholder;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.entity.TPaybackApplyInfo;

@Service("withholderNull")
public class WithhoderNull implements IWithholderService{
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Map<String, Object> withholder(TPaybackApplyInfo apply) {
		logger.debug(apply.getPaybackApplyId() + " 啥都不干");
		return null;
	}

}
