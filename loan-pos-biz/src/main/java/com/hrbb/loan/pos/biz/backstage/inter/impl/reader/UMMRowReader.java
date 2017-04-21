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
 * <p>Title: UMMRowReader.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年4月28日
 *
 * logs: 1. 
 */
public class UMMRowReader extends POSRowReader {
	
	public UMMRowReader(String loanId, String posType){
		/*
		1.商户编号
		2.客户姓名
		3.证件类型
		4.证件号码
		5.申请流水号
		6.POS交易流水号
		7.每月POS交易金额
		8.每月POS交易笔数
		9.每月正常时间（早上07:00-凌晨00:00）的交易金额
		10.每月正常时间（早上07:00-凌晨00:00）的交易笔数
		11.每月最大单笔交易金额
		12.每月信用卡交易金额占比
		13.每月信用卡交易笔数占比
		14.每月不重复卡号数
		15.POS明细汇总标示位
		16.查询开始日期
		17.查询截止日期
		 */
		RowMeta[] rm = {new RowMeta(15,DateUtil.HRRB_SHORT_DATETIME_FORMAT),
				new RowMeta(16,DateUtil.HRRB_SHORT_DATETIME_FORMAT)};
		super.addMeta(rm);
		
		this.posChannel = BusinessDictionaryConstants.BIZ_CHANNEL_UM;
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
		insertMap.put(RowMeta.TRADE_AMT, row.get(6));
		insertMap.put(RowMeta.TRADE_NUM, row.get(7));
		insertMap.put(RowMeta.REG_TIME_TRADE_AMT, row.get(8));
		insertMap.put(RowMeta.REG_TIME_TRADE_NUM, row.get(9));
		insertMap.put(RowMeta.MAX_TRADE_AMT_PER_MONTH, row.get(10));
		insertMap.put(RowMeta.CREDIT_CARD_TRADE_AMT_RADE, row.get(11));
		insertMap.put(RowMeta.CREDIT_CARD_TRADE_NUM_RATE, row.get(12));
		insertMap.put(RowMeta.DIFFERENT_CARD_NO_NUM, row.get(13));
		return insertMap;
	}

}
