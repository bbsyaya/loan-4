package com.hrbb.loan.pos.service;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TApprovedRulesConfig;
import com.hrbb.loan.pos.dao.entity.TApprovingAmountRateUplimitfig;
import com.hrbb.loan.pos.dao.entity.TApprovingRateUplimitConfig;
import com.hrbb.loan.pos.dao.entity.TApprovingScorecutUplimitConfig;
import com.hrbb.loan.pos.dao.entity.TBdExecutor;
import com.hrbb.loan.pos.dao.entity.TRiskChannelConfig;
import com.hrbb.loan.pos.dao.entity.TRiskZoneConfig;

public interface ModelParamConfigService {
 
   //风险区域参数配置   
	List<TRiskZoneConfig> queryRiskZoneConfig(Map<String, Object> reqMap);

	long countRiskZoneConfig(Map<String, Object> reqMap);

	TRiskZoneConfig selectRiskzoneConfigByRegcode(String string);

	int saveRiskzoneConfig(Map<String, Object> reqMap);

	TRiskZoneConfig selectRiskZoneConfigByID(Integer id);

	int modifyRiskzoneConfig(Map<String, Object> reqMap);

	int deleteRiskzoneConfig(String id);

	
	
	//风险渠道配置
	List<TRiskChannelConfig> queryRiskChannelConfig(Map<String, Object> reqMap);

	long countRiskChannelConfig(Map<String, Object> reqMap);
	
	TRiskChannelConfig selectRiskchannelConfigByRegcode(String string);

	int saveRiskchannelConfig(Map<String, Object> reqMap);

	TRiskChannelConfig selectRiskChannelConfigByID(Integer id);
	
	int modifyRiskchannelConfig(Map<String, Object> reqMap);
	
	int deleteRiskchannelConfig(String id);

	
	//批复金额利率配置
	List<TApprovingAmountRateUplimitfig> queryApprovingAmountRateUplimitConfig(
			Map<String, Object> reqMap);

	long countApprovingAmountRateUplimitConfig(Map<String, Object> reqMap);
	
	TApprovingAmountRateUplimitfig selectApprovingAmountRateUplimitConfigByRegcode(String string);

	int saveApprovingAmountRateUplimitConfig(Map<String, Object> reqMap);

	TApprovingAmountRateUplimitfig selectApprovingAmountRateUplimitConfigByID(Integer id);
	
	int modifyApprovingAmountRateUplimitConfig(Map<String, Object> reqMap);

	int deleteApprovingAmountRateUplimitConfig(String id);

	
	
	//批复利率配置
	List<TApprovingRateUplimitConfig> queryApprovingRateUplimitConfig(
			Map<String, Object> reqMap);

	long countApprovingRateUplimitConfig(Map<String, Object> reqMap);

	TApprovingRateUplimitConfig selectApprovingRateUplimitConfigByRegcode(String string);

	int saveApprovingRateUplimitConfig(Map<String, Object> reqMap);

	TApprovingRateUplimitConfig selectApprovingRateUplimitConfigByID(Integer id);

	int modifyApprovingRateUplimitConfig(Map<String, Object> reqMap);

	int deleteApprovingRateUplimitConfig(String id);

	
	
	
	
	//批复分数
	List<TApprovingScorecutUplimitConfig> queryApprovingScorecutUplimitConfig(
			Map<String, Object> reqMap);

	long countApprovingScorecutUplimitConfig(Map<String, Object> reqMap);

	TApprovingScorecutUplimitConfig selectApprovingScorecutUplimitConfigByRegcode(String string);

	int saveApprovingScorecutUplimitConfig(Map<String, Object> reqMap);


	TApprovingScorecutUplimitConfig selectApprovingScorecutUplimitConfigByID(
			Integer id);

	int modifyApprovingScorecutUplimitConfig(Map<String, Object> reqMap);

	int deleteApprovingScorecutUplimitConfig(String id);

	
	
	
	//批复规则
	List<TApprovedRulesConfig> queryApprovedRulesConfig(Map<String, Object> reqMap);

	long countApprovedRulesConfig(Map<String, Object> reqMap);

	TApprovedRulesConfig selectApprovedRulesConfigByRegcode(String string);

	int saveApprovedRulesConfig(Map<String, Object> reqMap);

	TApprovedRulesConfig selectApprovedRulesConfigByID(Integer id);

	int modifyApprovedRulesConfig(Map<String, Object> reqMap);

	int deleteApprovedRulesConfig(String id);
}
