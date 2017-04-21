package com.hrbb.loan.pos.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.dao.TBusinessDictionaryDao;
import com.hrbb.loan.pos.dao.entity.TBusinessDictionary;
import com.hrbb.loan.pos.service.LoanPosBusinessCodeService;
import com.hrbb.loan.pos.util.ListUtil;
import com.hrbb.loan.pos.util.constants.BusinessDictionaryConstants;

/**
 *<h1></h1>
 *@author Johnson Song
 *@version Id: LoanPosBusinessCodeServiceImpl.java, v 1.0 2015-3-9 下午4:31:21 Johnson Song Exp
 */
@Service("loanPosBusinessCodeService")
public class LoanPosBusinessCodeServiceImpl implements
		LoanPosBusinessCodeService {
	
	private static final String CODE_NO = "codeNo";
	
	private static final String ITEM_NO = "itemNo";
	
	private static final String ITEM_NAME = "itemName";
	
	private static final String STATUS = "status";
	
	private static final String STATUS_ACTIVE = "0";
	
	private static final String STATUS_NOT_ACTIVE = "1";
	
	private static final String ITEM_NO_LIKE = "itemNoLike";
	
	@Autowired
	private TBusinessDictionaryDao tBusinessDictionaryDao;

	@Override
	public List<Map<String, Object>> getItemNames(String codeNo) {
		Map<String, Object> reqMap = Maps.newHashMap();
		reqMap.put(CODE_NO, codeNo);
		reqMap.put(STATUS, STATUS_ACTIVE);
		List<Map<String, Object>> resList = tBusinessDictionaryDao.getBusinessCode(reqMap);
		return resList;
	}

	@Override
	public String getItemNameByNo(String codeNo, String itemNo) {
		Map<String, Object> reqMap = Maps.newHashMap();
		reqMap.put(CODE_NO, codeNo);
		reqMap.put(ITEM_NO, itemNo);
		reqMap.put(STATUS, STATUS_ACTIVE);
		List<Map<String, Object>> resList = tBusinessDictionaryDao.getBusinessCode(reqMap);
		if(ListUtil.isNotEmpty(resList)){
			return (String)resList.get(0).get(ITEM_NAME);
		}else{
			return null;
		}
	}
    @Override
    public String getItemNoByName(String codeNo, String itemName) {
        Map<String, Object> reqMap = Maps.newHashMap();
        reqMap.put(CODE_NO, codeNo);
        reqMap.put(ITEM_NAME, itemName);
        reqMap.put(STATUS, STATUS_ACTIVE);
        List<Map<String, Object>> resList = tBusinessDictionaryDao.getBusinessCode(reqMap);
        if(ListUtil.isNotEmpty(resList)){
            return (String)resList.get(0).get(ITEM_NO);
        }else{
            return null;
        }
    }
	
	@Override
	public List<Map<String, Object>> getProvinceCityOrDic(String itemNoLike) {
		Map<String, Object> reqMap = Maps.newHashMap();
		reqMap.put(CODE_NO, BusinessDictionaryConstants.AdminDivision);
		reqMap.put(ITEM_NO_LIKE, itemNoLike);
		List<Map<String, Object>> resList = tBusinessDictionaryDao.getBusinessCode(reqMap);
		return resList;
	}

	@Override
	public List<Map<String, Object>> getSeletiveMap(Map<String, Object> reqMap) {
		return tBusinessDictionaryDao.getBusinessCode(reqMap);
	}
	
	@Override
	public List<Map<String, Object>> getItemNamesWithExtOrder(Map<String, Object> reqMap) {
		reqMap.put(STATUS, STATUS_ACTIVE);
		List<Map<String, Object>> resList = tBusinessDictionaryDao.getItemNamesWithExtOrder(reqMap);
		
		return resList;
	}

	@Override
	public String getExtAttrByNo(String codeNo, String itemNo) {
		Map<String, Object> reqMap = Maps.newHashMap();
		reqMap.put(CODE_NO, codeNo);
		reqMap.put(ITEM_NO, itemNo);
		reqMap.put(STATUS, STATUS_ACTIVE);
		List<Map<String, Object>> resList = tBusinessDictionaryDao.getBusinessCode(reqMap);
		if(ListUtil.isNotEmpty(resList)){
			return (String)resList.get(0).get("extAttr");
		}else{
			return null;
		}
	}

	@Override
	public String getSplitedItemName(String codeNo, String itemNos) {
		return getSplitedItemName(codeNo, itemNos, ",");
	}

	@Override
	public String getSplitedItemName(String codeNo, String itemNos, String splitor) {
		if(splitor==null || splitor.trim().length()==0) return "";
		
		String[] items = itemNos.split(splitor, -1);
		List<TBusinessDictionary> codeList = tBusinessDictionaryDao.selectByIds(codeNo, items);
		StringBuffer sb = new StringBuffer("");
		for(TBusinessDictionary code:codeList){
			sb.append(",").append(code.getItemName());
		}
		if(sb.length()>0) sb.deleteCharAt(0);
		
		return sb.toString();
	}

}
