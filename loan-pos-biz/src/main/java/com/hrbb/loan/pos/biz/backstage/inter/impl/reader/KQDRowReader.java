/**
 * 
 */
package com.hrbb.loan.pos.biz.backstage.inter.impl.reader;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.constants.BusinessDictionaryConstants;

/**
 * <p>Title: KQDRowReader.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年4月28日
 *
 * logs: 1. 
 */
public class KQDRowReader extends POSRowReader {
	
	public KQDRowReader(String loanId, String posType){
		/*
		0.渠道
		1.申请人姓名
		2.证件号码
		3.商户名称
		4.交易时间
		5.交易金额
		6.数据导出日期
		 */
		RowMeta[] rm = {new RowMeta(4,DateUtil.HRRB_SHORT_DATETIME_FORMAT_BRIEF),
				new RowMeta(6, DateUtil.HRRB_SHORT_DATETIME_FORMAT_BRIEF)};
		super.addMeta(rm);
		
		this.posChannel = BusinessDictionaryConstants.BIZ_CHANNEL_KQ;
		this.loanId = loanId;
		this.posType = posType;
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.biz.backstage.inter.impl.reader.POSRowReader#processRow(java.util.List)
	 */
	@Override
	protected Map<String, Object> processRow(List<String> row) {
		Map<String, Object> insertMap = Maps.newHashMap();
		insertMap.put(RowMeta.LOAN_ID, loanId);
		insertMap.put(RowMeta.POS_CHANNEL, posChannel);
		insertMap.put(RowMeta.POS_KIND, posType);
		insertMap.put(RowMeta.MERCHANT_NAME, row.get(3));
		insertMap.put(RowMeta.TRADE_DATE, row.get(4));
		insertMap.put(RowMeta.TRADE_AMT, row.get(5));
		insertMap.put(RowMeta.MERCHANT_ID, row.get(2));
		insertMap.put(RowMeta.TRADE_NUM, "1");
		
		return insertMap;
	}

}
