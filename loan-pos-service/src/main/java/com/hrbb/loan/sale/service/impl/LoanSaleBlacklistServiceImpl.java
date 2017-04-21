/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.sale.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.dao.TBlacklistDao;
import com.hrbb.loan.pos.dao.entity.TBlacklist;
import com.hrbb.loan.pos.service.bean.BlackListQueryResVo;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.RandomUtil;
import com.hrbb.loan.pos.util.constants.BlacklistTypeConstants;
import com.hrbb.loan.pos.util.constants.ReviewNoteConstants;
import com.hrbb.loan.sale.service.LoanSaleBlacklistService;

/**
 * 消费贷黑名单service 
 * @author litengfeng
 * @version $Id: LoanSaleBlacklistServiceImpl.java, v 0.1 2015年5月13日 下午1:42:01 litengfeng Exp $
 */
@Service("loanSaleBlacklistService")
public class LoanSaleBlacklistServiceImpl implements LoanSaleBlacklistService {
	@Autowired
	private TBlacklistDao tBlacklistDao;

	@Override
	public BlackListQueryResVo queryTBlacklists(Map<String, Object> map) {
		BlackListQueryResVo vo = new BlackListQueryResVo();
		vo.setList(tBlacklistDao.selectSelective(map));
		return vo;
	}

	@Override
	public int updateTBlacklist(TBlacklist tBlacklist) {
		return tBlacklistDao.updateByPrimaryKeySelective(tBlacklist);
	}

	@Override
	public void insertTBlacklist(TBlacklist tBlacklist) {
		tBlacklistDao.insert(tBlacklist);
	}

	@Override
	public Long countBlacklist(Map<String, Object> reqMap) {
		return tBlacklistDao.countBlacklist(reqMap);
	}

	@Override
	public List<Map<String, Object>> getBlacklistMap(Map<String, Object> reqMap) {
		return tBlacklistDao.selectSelectiveMap(reqMap);
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return tBlacklistDao.insertSelectiveMap(reqMap);

	}

	@Override
	public int updateSelectiveMap(Map<String, Object> reqMap) {
		return tBlacklistDao.updateSelectiveMap(reqMap);
	}

	/**
	 * 插入黑名单表多条
	 * 
	 * @param bl
	 * @return
	 */
	@Override
	public int insertTBlacklists(TBlacklist bl) {
		// 类型
		String[] infoTypes = bl.getInfoType().split(
				ReviewNoteConstants.STRING_SEPARATOR_CODE);
		// 认定维度结果
		String[] infoDetails = bl.getInfoDetail().split(
				ReviewNoteConstants.STRING_SEPARATOR_CODE);
		int result = 0;

		for (int i = 0; i < infoDetails.length; i++) {
			// 维度
			bl.setInfoType(infoTypes[i]);
			// 内容
			bl.setInfoDetail(infoDetails[i]);
			// 判断黑名单内容是否存在
			if (!checkExist(bl)) {
				bl.setId(DateUtil.getCurrentTimePattern5()
						+ RandomUtil.getRandom(4));
				// 0-证件黑名单
				if (BlacklistTypeConstants.CERT_BLACK.equals(bl.getInfoType())) {
					// 00-身份证
					bl.setCertType(BlacklistTypeConstants.CERTTYPE_CERTIFCATE);
					// 0-证件黑名单以外
				} else {
					bl.setCertType(null);
				}
				// 插入黑名单表
				if (tBlacklistDao.insertSelective(bl) == 1) {
					result++;
					// 插入失败
				} else {
					result = -1;
					break;
				}
			} else {
				// 内容存在，不插入
			}
		}
		return result;
	}

	/**
	 * 判断黑名单内容是否存在
	 * 
	 * @param bl
	 * @return
	 */
	private boolean checkExist(TBlacklist bl) {
		Map<String, Object> map = Maps.newHashMap();
		map.put(BlacklistTypeConstants.INFO_TYPE, bl.getInfoType());
		map.put(BlacklistTypeConstants.INFO_DETAIL, bl.getInfoDetail());
		long count = tBlacklistDao.countBlacklist(map);
		if (count > 0) {
			return true;
		}
		return false;
	}
}
