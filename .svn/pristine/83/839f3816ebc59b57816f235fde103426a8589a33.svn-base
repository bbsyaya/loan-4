package com.hrbb.loan.spi.TC2;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hrbb.loan.constants.CreditApplyConstants;
import com.hrbb.loan.pos.dao.TCfgFundingPoolDao;
import com.hrbb.loan.pos.dao.entity.TCfgFundingPool;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.spi.POSHService;
import com.hrbb.loan.spi.TC.TCCreditApplyHServiceImpl;

/**
 * T51业务受理
 * 
 * @author Johnson
 * 
 */
@Service("tc2CreditApply")
public class TC2CreditApplyHServiceImpl extends TCCreditApplyHServiceImpl {

	@Autowired
	private TCfgFundingPoolDao tCfgFundingPoolDao;

	/**
	 * 贷款方式
	 * 
	 * @return
	 */
	public String getLoanType() {
		return POSHService.贷款模式_资金池;
	}

	/**
	 * @see com.hrbb.loan.spi.TC.AbsApplyService#executeExtensionAction(java.util.Map,
	 *      java.util.Map, java.util.Map, java.util.Map, java.util.Map)
	 */
	@Override
	protected boolean executeExtensionAction(Map<String, Object> creMap,
			Map<String, Object> custMap, Map<String, Object> posCustMap,
			Map<String, Object> bankMap, Map<String, Object> relaMap) {

		// 资金池编号
		Map<String, Object> p = Maps.newHashMap();
		p.put(CreditApplyConstants.channel, getChannel());
		p.put(CreditApplyConstants.beginDate, DateUtil.getToday());
		List<TCfgFundingPool> poolInfos = tCfgFundingPoolDao.selectSelective(p);
		if (poolInfos.size() == 0) {
			return false;
		}
		creMap.put(CreditApplyConstants.poolNo, poolInfos.get(0).getPoolNo());
		return true;
	}
}
