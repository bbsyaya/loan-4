package com.hrbb.loan.pos.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TPaybackApplyInfoDao;
import com.hrbb.loan.pos.dao.TReceiptInfoDao;
import com.hrbb.loan.pos.dao.entity.TPaybackApplyInfo;
import com.hrbb.loan.pos.dao.entity.TReceiptInfo;
import com.hrbb.loan.pos.service.LoanPosPaybackService;

@Service("loanPosPaybackService")
public class LoanPosPaybackServiceImpl implements LoanPosPaybackService {
	@Autowired
	private TReceiptInfoDao tReceiptInfoDao;
	
	@Autowired
	private TPaybackApplyInfoDao tPaybackApplyInfoDao;

	@Override
	public List<TReceiptInfo> getPaybackMap(Map<String, Object> reqMap) {
		List<TReceiptInfo> l =tReceiptInfoDao.selectSelectiveMap(reqMap);
		return l;
	}
	
	@Override
	public long countPaybackInfo(Map<String,Object> reqMap){
	    return tReceiptInfoDao.countSelectiveMap(reqMap);
	}
	@Override
	public TReceiptInfo getReceiptInfoByReceiptId(String r) {
		return tReceiptInfoDao.selectByPrimaryKey(r);
	}

	@Override
	public String getContNoByReceiptId(String receiptId) {
		return tReceiptInfoDao.getContNoByReceiptId(receiptId);
	}

	@Override
	public String getReceiptTotalAmountByContNo(String contno) {
		return tReceiptInfoDao.getReceiptTotalAmountByContNo(contno);
	}

	@Override
	public Double getLoanTotalBalanceByReceiptId(String listid) {
		return tReceiptInfoDao.getLoanTotalBalanceByReceiptId(listid);
	}

	@Override
	public String getReceiptIdByPayApplyId(String listid) {
		return tReceiptInfoDao.getReceiptIdByPayApplyId(listid);
	}

	@Override
	public String getBeginDateByPayApplyId(String listid) {
		return tReceiptInfoDao.getBeginDateByPayApplyId(listid);
	}

	@Override
	public List<TReceiptInfo> getReceiptList(Map<String, Object> reqMap) {
		return tReceiptInfoDao.getReceiptList(reqMap);
	}

	@Override
	public List<TReceiptInfo> getAllReceipts(Map<String, Object> reqMap) {
		return tReceiptInfoDao.getAllReceipts(reqMap);
	}

	@Override
	public Map<String, Object> getReceiptMapByReceiptId(String receiptId) {
		return tReceiptInfoDao.getReceiptMapByReceiptId(receiptId);
	}

    @Override
    public int savePaybackApply(TPaybackApplyInfo paybackApplyInfo) {
        return tPaybackApplyInfoDao.insertSelective(paybackApplyInfo);
    }


	@Override
	public List<TReceiptInfo> getAllUnClearedReceipts() {
		return tReceiptInfoDao.getAllUnClearedReceipts();
	}


	@Override
	public List<TPaybackApplyInfo> queryPaybackApplyList(
			Map<String, Object> reqMap) {
		return tPaybackApplyInfoDao.queryPaybackApplyList(reqMap);
	}

	@Override
	public long countNumber(Map<String, Object> reqMap) {
		return tReceiptInfoDao.countNumber(reqMap);
	}

	@Override
	public int updateReceipt(Map<String, Object> receiptMap) {
		return tReceiptInfoDao.updateReceipt(receiptMap);
	}

	@Override
	public long countCustRelatedReceiptNumber(Map<String, Object> reqMap) {
		return tReceiptInfoDao.countCustRelatedReceiptNumber(reqMap);
	}

}
