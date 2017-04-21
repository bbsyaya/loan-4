package com.hrbb.loan.controller.helper;

import java.util.Map;

import com.google.common.collect.Maps;

public class CallingTaskHelper {
	
	Map<String, Integer> callingTypeMap = Maps.newHashMap();
	Map<String, String> bizPhare = Maps.newHashMap();
	String [] callingTypeArray={
			"业务人员触发的补件",
			"POS流水未成功获取",
			"客户在审批过程中主动撤销申请",
			"沟通预授信结果（对需要尽调的客户）",
			"客户拒绝接受授信",
			"客户长时间未响应授信结果（审批通知后3个自然日）",
			"银行卡未验真，放款前电话确认卡号",
			"客户代扣还款未成功（主动提前还款和到期代扣12点批次）",
			"到期前提醒（7个自然日）",
			"客户不满足综合准入条件",
			"业务申请初审自动拒绝",
			"业务申请复审通过",
			"业务申请复审拒绝",
			"用款审核不通过"};
	public CallingTaskHelper(){
		for (int i = 0; i < getCallingTypeArray().length; i++) {
			callingTypeMap.put(getCallingTypeArray()[i], i+1);
		}
		bizPhare.put("APP", "申请阶段");
		bizPhare.put("APR", "批复阶段");
		bizPhare.put("CNT", "合同阶段");
		bizPhare.put("ISS", "用款阶段");
		bizPhare.put("REP", "还款阶段");
		bizPhare.put("PST", "贷后阶段");
		
	}
	public Map<String, Integer> getCallingTypeMap() {
		return callingTypeMap;
	}
	public void setCallingTypeMap(Map<String, Integer> callingTypeMap) {
		this.callingTypeMap = callingTypeMap;
	}
	
	public Map<String, String> getBizPhare() {
		return bizPhare;
	}
	public void setBizPhare(Map<String, String> bizPhare) {
		this.bizPhare = bizPhare;
	}
	public String[] getCallingTypeArray() {
		return callingTypeArray;
	}
	public void setCallingTypeArray(String[] callingTypeArray) {
		this.callingTypeArray = callingTypeArray;
	}
	
	
}
