/**
 * 
 */
package com.hrbb.loan.pos.biz.backstage.inter.impl.reader;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Sets;
import com.hrbb.loan.pos.service.LoanPosCreditApplyService;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.MessageDigest;
import com.hrbb.loan.pos.util.excel.IRowReader;

/**
 * <p>Title: POSRowReader.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年4月27日
 *
 * logs: 1. 
 */
public abstract class POSRowReader implements IRowReader {
	private Logger logger = LoggerFactory.getLogger(POSRowReader.class);
	
	//数据起始行
	protected int rowStart = 2;
	//批处理数据条数
	protected int batchNum = 2000;
	
	protected String loanId;
	protected String posChannel;
	protected String posType;

	//待处理结果列表
	private List<Map<String, Object>> insertList = null;
	
	//唯一性POS流水主键池
	private Set<String> uniquePOSKey = Sets.newHashSet();
	
	//
	protected LoanPosCreditApplyService applyService;
	
	//reader对应excel版本
	private int readerVersion = READER_VER_UNKOWN;
	//转换日期元数据定义
	private RowMeta[] rowMeta = null;
	
	private boolean exceptionTrigger = false;
	
	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.util.excel.IRowReader#getRows(int, int, java.util.List)
	 */
	@Override
	public void getRows(int sheetIndex, int curRow, List<String> rowlist) {
		if(curRow < rowStart-1) return;
		if(exceptionTrigger) return;
		
		//------------------流水去重：素有字段MD5后比较
		try {
			String uniqueKey = MessageDigest.getDigestAsUpperHexString("MD5", rowlist.toString());
			
			if(uniquePOSKey.contains(uniqueKey)){
				return;
			}else{
				uniquePOSKey.add(uniqueKey);
			}
//			System.out.println(curRow+"\tuniqueKey:\t"+uniqueKey+"\t"+rowlist);
		} catch (NoSuchAlgorithmException e1) {
		}
		
		//-------在office2007的情况下，对指定日期列作转换
//		if(getVersion() == READER_VER_07){
			if(rowMeta != null){
				for(RowMeta rm: rowMeta){
					String dateVal = rowlist.get(rm.getIndex());
					try {
						Date date = null;
						if(getVersion() == READER_VER_07 && rm.getType()==RowMeta.META_TYPE_DATE){		//07版本的日期做转化
							date = HSSFDateUtil.getJavaDate(Double.valueOf(dateVal));
						}else{
							date = DateUtil.parse2Date(dateVal, rm.getFromFormat());
						}
						String formatedDate = DateUtil.formatDate(date, rm.getToFormat());
						rowlist.set(rm.getIndex(), formatedDate);		//replace value
						
					} catch (ParseException e) {
						exceptionTrigger = true;
					}
				}
			}
//		}
		
		if(exceptionTrigger) return;
		
//		System.out.println(curRow+" : "+rowlist);
		insertList.add(processRow(rowlist));
		if(insertList.size() >= batchNum){
			applyService.insertPosSerialSelectiveMapBatch(insertList);
			insertList.clear();
		}
	}
	
	public boolean fireTrigger() {
		return exceptionTrigger;
	}

	@Override
	public void setVersion(int ver) {
		this.readerVersion = ver;
	}
	
	public int getVersion() {
		return readerVersion;
	}

	public void addMeta(RowMeta[] rm){
		this.rowMeta = rm;
	}
	
	public void addHandleList(List<Map<String, Object>> list){
		insertList = list;
	}
	
	public void addService(LoanPosCreditApplyService service){
		applyService = service;
	}
	
	public void addUniqueKey(Set<String> uniquePOSKey) {
		this.uniquePOSKey = uniquePOSKey;
	}

	abstract protected Map<String, Object> processRow(List<String> row);
	
}
