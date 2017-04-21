/**
 * 
 */
package com.hrbb.loan.pos.biz.backstage.inter.impl.reader;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.util.constants.BusinessDictionaryConstants;

/**
 * <p>Title: UPMRowReader.java </p>
 * <p>Description: 银联POS月汇总流水  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年4月27日
 *
 * logs: 1. 
 */
public class UPMRowReader extends POSRowReader {
	
	public UPMRowReader(String loanId, String posType){
		//商户名称	商户代码	MCC	交易月份	月交易额	月交易笔数	月交易额同比增幅	月消费客户数	信用卡交易占比	借记卡交易占比
		RowMeta[] rm = {new RowMeta(3,"yyyy/MM","yyyy-MM",RowMeta.META_TYPE_DATE)};
		super.addMeta(rm);
		
		this.posChannel = BusinessDictionaryConstants.BIZ_CHANNEL_UP;
		this.loanId = loanId;
		this.posType = posType;
	}
	
	@Override
	protected Map<String, Object> processRow(List<String> row) {
		Map<String, Object> insertMap = Maps.newHashMap();
		insertMap.put(RowMeta.LOAN_ID, loanId);
		insertMap.put(RowMeta.POS_CHANNEL, posChannel);
		insertMap.put(RowMeta.POS_KIND, posType);
		insertMap.put(RowMeta.TRADE_DATE, row.get(3));
		insertMap.put(RowMeta.MERCHANT_NAME, row.get(0));
		insertMap.put(RowMeta.MERCHANT_ID, row.get(1));
		insertMap.put(RowMeta.TRADE_NUM, row.get(5));
		insertMap.put(RowMeta.TRADE_AMT, row.get(4));
		insertMap.put(RowMeta.MERCHANT_TYPE_CODE, row.get(2));
		
		return insertMap;
	}
	
}
