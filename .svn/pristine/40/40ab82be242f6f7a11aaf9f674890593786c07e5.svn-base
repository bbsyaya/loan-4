package com.hrbb.loan.pos.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrbb.loan.pos.dao.TApprovedRulesConfigDao;
import com.hrbb.loan.pos.dao.TApprovingAmountRateUplimitConfigDao;
import com.hrbb.loan.pos.dao.TApprovingRateUplimitConfigDao;
import com.hrbb.loan.pos.dao.TApprovingScorecutUplimitConfigDao;
import com.hrbb.loan.pos.dao.TRiskChannelConfigDao;
import com.hrbb.loan.pos.dao.TRiskZoneConfigDao;
import com.hrbb.loan.pos.dao.entity.TApprovedRulesConfig;
import com.hrbb.loan.pos.dao.entity.TApprovingAmountRateUplimitfig;
import com.hrbb.loan.pos.dao.entity.TApprovingRateUplimitConfig;
import com.hrbb.loan.pos.dao.entity.TApprovingScorecutUplimitConfig;
import com.hrbb.loan.pos.dao.entity.TRiskChannelConfig;
import com.hrbb.loan.pos.dao.entity.TRiskZoneConfig;
import com.hrbb.loan.pos.service.ModelParamConfigService;
@Service("ModelParamConfigService")
public class ModelParamConfigServiceImpl implements ModelParamConfigService {
	@Autowired
	private TRiskZoneConfigDao    tRiskZoneConfigDao;
	
	@Autowired
	private TRiskChannelConfigDao    tRiskChannelConfigDao;

	@Autowired
	private TApprovingAmountRateUplimitConfigDao    tApprovingAmountRateUplimitConfigDao;
	
	@Autowired
	private TApprovingRateUplimitConfigDao    tApprovingRateUplimitConfigDao;
	
	@Autowired
	private TApprovingScorecutUplimitConfigDao    tApprovingScorecutUplimitConfigDao;
	
	@Autowired
	private TApprovedRulesConfigDao    tApprovedRulesConfigDao;
	
	//风险区域配置
	@Override
	public List<TRiskZoneConfig> queryRiskZoneConfig(Map<String, Object> reqMap) {
		 return tRiskZoneConfigDao.selectListBySelective(reqMap);
	}
	@Override
	public long countRiskZoneConfig(Map<String, Object> reqMap) {
		 return tRiskZoneConfigDao.countListBySelective(reqMap);
	}
	@Override
	public TRiskZoneConfig selectRiskzoneConfigByRegcode(String string) {
		 return tRiskZoneConfigDao.selectRiskzoneConfigByRegcode(string);
	}
	@Override
	public int saveRiskzoneConfig(Map<String, Object> reqMap) {
		 return tRiskZoneConfigDao.saveRiskzoneConfig(reqMap);
	}
	@Override
	public TRiskZoneConfig selectRiskZoneConfigByID(Integer id) {
		 return tRiskZoneConfigDao.selectByPrimaryKey(id);
	}
	@Override
	public int modifyRiskzoneConfig(Map<String, Object> reqMap) {
		 return tRiskZoneConfigDao.updateByUpdateMap(reqMap);
	}
	@Override
	public int deleteRiskzoneConfig(String id) {
		 return tRiskZoneConfigDao.deleteRiskzoneConfigByID(id);
	}
	
	
	
	//风险渠道配置
	@Override
	public List<TRiskChannelConfig> queryRiskChannelConfig(
			Map<String, Object> reqMap) {
		 return tRiskChannelConfigDao.selectListBySelective(reqMap);
	}
	@Override
	public long countRiskChannelConfig(Map<String, Object> reqMap) {
		 return tRiskChannelConfigDao.countListBySelective(reqMap);
	}
	@Override
	public TRiskChannelConfig selectRiskchannelConfigByRegcode(String string) {
		 return tRiskChannelConfigDao.selectRiskchannelConfigByRegcode(string);
	}
	@Override
	public int saveRiskchannelConfig(Map<String, Object> reqMap) {
		 return tRiskChannelConfigDao.saveRiskchannelConfig(reqMap);
	}
	@Override
	public TRiskChannelConfig selectRiskChannelConfigByID(Integer id) {
		return tRiskChannelConfigDao.selectByPrimaryKey(id);
	}
	@Override
	public int modifyRiskchannelConfig(Map<String, Object> reqMap) {
		 return tRiskChannelConfigDao.updateByUpdateMap(reqMap);
	}
	@Override
	public int deleteRiskchannelConfig(String id) {
		 return tRiskChannelConfigDao.deleteRiskchannelConfigByID(id);
	}
	
	
	//批复金额利率配置
	@Override
	public List<TApprovingAmountRateUplimitfig> queryApprovingAmountRateUplimitConfig(
			Map<String, Object> reqMap) {
		 return tApprovingAmountRateUplimitConfigDao.selectListBySelective(reqMap);
	}
	@Override
	public long countApprovingAmountRateUplimitConfig(Map<String, Object> reqMap) {
		 return tApprovingAmountRateUplimitConfigDao.countListBySelective(reqMap);
	}
	@Override
	public TApprovingAmountRateUplimitfig selectApprovingAmountRateUplimitConfigByRegcode(String string) {
		 return tApprovingAmountRateUplimitConfigDao.selectApprovingAmountRateUplimitConfigByRegcode(string);
	}
	@Override
	public int saveApprovingAmountRateUplimitConfig(Map<String, Object> reqMap) {
		 return tApprovingAmountRateUplimitConfigDao.saveApprovingAmountRateUplimitConfig(reqMap);
	}
	@Override
	public TApprovingAmountRateUplimitfig selectApprovingAmountRateUplimitConfigByID(
			Integer id) {
		return tApprovingAmountRateUplimitConfigDao.selectByPrimaryKey(id);
	}
	@Override
	public int modifyApprovingAmountRateUplimitConfig(Map<String, Object> reqMap) {
		 return tApprovingAmountRateUplimitConfigDao.updateByUpdateMap(reqMap);
	}
	@Override
	public int deleteApprovingAmountRateUplimitConfig(String id) {
		return tApprovingAmountRateUplimitConfigDao.deleteApprovingAmountRateUplimitConfig(id);
	}
	
	
	//批复利率配置
	@Override
	public List<TApprovingRateUplimitConfig> queryApprovingRateUplimitConfig(Map<String, Object> reqMap) {
		 return tApprovingRateUplimitConfigDao.selectListBySelective(reqMap);
	}
	@Override
	public long countApprovingRateUplimitConfig(Map<String, Object> reqMap) {
		 return tApprovingRateUplimitConfigDao.countListBySelective(reqMap);
	}
	@Override
	public TApprovingRateUplimitConfig selectApprovingRateUplimitConfigByRegcode(String string) {
		 return tApprovingRateUplimitConfigDao.selectApprovingRateUplimitConfigByRegcode(string);
	}
	@Override
	public int saveApprovingRateUplimitConfig(Map<String, Object> reqMap) {
		 return tApprovingRateUplimitConfigDao.saveApprovingRateUplimitConfig(reqMap);
	}
	@Override
	public TApprovingRateUplimitConfig selectApprovingRateUplimitConfigByID(Integer id) {
		 return tApprovingRateUplimitConfigDao.selectByPrimaryKey(id);
	}
	@Override
	public int modifyApprovingRateUplimitConfig(Map<String, Object> reqMap) {
		 return tApprovingRateUplimitConfigDao.updateByUpdateMap(reqMap);
	}
	@Override
	public int deleteApprovingRateUplimitConfig(String id) {
		 return tApprovingRateUplimitConfigDao.deleteApprovingRateUplimitConfigByID(id);
	}
	
	
	//批复分数配置
	@Override
	public List<TApprovingScorecutUplimitConfig> queryApprovingScorecutUplimitConfig(Map<String, Object> reqMap) {
		 return tApprovingScorecutUplimitConfigDao.selectListBySelective(reqMap);
	}
	@Override
	public long countApprovingScorecutUplimitConfig(Map<String, Object> reqMap) {
		 return tApprovingScorecutUplimitConfigDao.countListBySelective(reqMap);
	}
	@Override
	public TApprovingScorecutUplimitConfig selectApprovingScorecutUplimitConfigByRegcode(String string) {
		 return tApprovingScorecutUplimitConfigDao.selectApprovingScorecutUplimitConfigByRegcode(string);
	}
	@Override
	public int saveApprovingScorecutUplimitConfig(Map<String, Object> reqMap) {
		 return tApprovingScorecutUplimitConfigDao.saveApprovingScorecutUplimitConfig(reqMap);
	}
	@Override
	public TApprovingScorecutUplimitConfig selectApprovingScorecutUplimitConfigByID(Integer id) {
		 return tApprovingScorecutUplimitConfigDao.selectByPrimaryKey(id);
	}
	@Override
	public int modifyApprovingScorecutUplimitConfig(Map<String, Object> reqMap) {
		 return tApprovingScorecutUplimitConfigDao.updateByUpdateMap(reqMap);
	}
	@Override
	public int deleteApprovingScorecutUplimitConfig(String id) {
		 return tApprovingScorecutUplimitConfigDao.deleteApprovingScorecutUplimitConfigByID(id);
	}
	
	//批复规则
	@Override
	public List<TApprovedRulesConfig> queryApprovedRulesConfig(Map<String, Object> reqMap) {
		 return tApprovedRulesConfigDao.selectListBySelective(reqMap);
	}
	@Override
	public long countApprovedRulesConfig(Map<String, Object> reqMap) {
		 return tApprovedRulesConfigDao.countListBySelective(reqMap);
	}
	@Override
	public TApprovedRulesConfig selectApprovedRulesConfigByRegcode(String string) {
		 return tApprovedRulesConfigDao.selectApprovedRulesConfigByRegcode(string);
	}
	@Override
	public int saveApprovedRulesConfig(Map<String, Object> reqMap) {
		 return tApprovedRulesConfigDao.saveApprovedRulesConfig(reqMap);
	}
	@Override
	public TApprovedRulesConfig selectApprovedRulesConfigByID(Integer id) {
		 return tApprovedRulesConfigDao.selectByPrimaryKey(id);
	}
	@Override
	public int modifyApprovedRulesConfig(Map<String, Object> reqMap) {
		 return tApprovedRulesConfigDao.updateByUpdateMap(reqMap);
	}
	@Override
	public int deleteApprovedRulesConfig(String id) {
		 return tApprovedRulesConfigDao.deleteApprovedRulesConfigByID(id);
	}

}
