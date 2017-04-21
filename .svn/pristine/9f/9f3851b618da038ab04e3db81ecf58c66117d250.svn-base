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
 * <p>Title: CYRowReader.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年4月28日
 *
 * logs: 1. 
 */
public class CYRowReader extends POSRowReader {
	
	public CYRowReader(String loanId, String posType){
		/*
		0.商户编号
		1.交易卡发卡行
		2.交易卡号
		3.姓名
		4.身份证号
		5.金额
		6.交易时间		20150329182340
		7.客户评级
		 */
		RowMeta[] rm = {new RowMeta(6,DateUtil.HRRB_LONG_DATETIME_FORMAT_BRIEF,DateUtil.HRRB_LONG_DATETIME_FORMAT)};
		super.addMeta(rm);
		
		this.posChannel = BusinessDictionaryConstants.BIZ_CHANNEL_CY;
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
		insertMap.put(RowMeta.MERCHANT_ID, row.get(0));
//		insertMap.put(RowMeta.MERCHANT_TYPE_CODE, row.get(2));
		String dateStr = "";
		String timeStr = "";
		String dateTime = row.get(6);
		if(dateTime!=null && dateTime.length()>=19){
			dateStr = dateTime.substring(0,10);
			timeStr = dateTime.substring(11,dateTime.length());
			//----正常时间交易
			String sHour = timeStr.substring(0,2);
			int iHour = Integer.valueOf(sHour);
			if(iHour>=7 && iHour <=23){
				insertMap.put(RowMeta.REG_TIME_TRADE_AMT, row.get(5));		//7~23正常营业时间
			}
		}else{
			dateStr = dateTime;
		}
		insertMap.put(RowMeta.TRADE_DATE, dateStr);
		insertMap.put(RowMeta.TRADE_TIME, timeStr);
		insertMap.put(RowMeta.TRADE_AMT, row.get(5));
		insertMap.put(RowMeta.TRADE_NUM, "1");		//明细笔数为1
		insertMap.put(RowMeta.TRADE_CARD_NO, row.get(2));
		
		return insertMap;
	}

}
