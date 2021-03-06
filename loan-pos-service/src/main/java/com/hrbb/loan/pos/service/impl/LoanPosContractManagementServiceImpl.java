package com.hrbb.loan.pos.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.hrbb.loan.pos.dao.TBankAccnoInfoDao;
import com.hrbb.loan.pos.dao.TContractInfoDao;
import com.hrbb.loan.pos.dao.TContractManagementDao;
import com.hrbb.loan.pos.dao.TCreditApplyDao;
import com.hrbb.loan.pos.dao.entity.TApproveReject;
import com.hrbb.loan.pos.dao.entity.TApproveResult;
import com.hrbb.loan.pos.dao.entity.TContractManagement;
import com.hrbb.loan.pos.service.LoanPosContractManagementService;
import com.hrbb.loan.pos.service.LoanPosPaybackService;
import com.hrbb.loan.pos.service.PaymentApplyService;
import com.hrbb.loan.pos.util.ListUtil;
import com.hrbb.loan.pos.util.StringUtil;

@Service("loanPosContractManagementService")
public class LoanPosContractManagementServiceImpl implements
		LoanPosContractManagementService {
	private static final String CONT_NO = "contNo";

	@Autowired
	private TContractManagementDao tContractManagementDao;
	
	@Autowired
	private TContractInfoDao tContractInfoDao;
	
	@Autowired
	private LoanPosPaybackService loanPosPaybackService;
	
	@Autowired
	private TCreditApplyDao tCreditApplyDao;
	
	@Autowired
    private PaymentApplyService paymentApplyService;
	
	@Autowired
	private TBankAccnoInfoDao bankAccnoInfoDao;
	
	@Override
	public Long countContractManagement(Map<String, Object> reqMap) {
		return tContractManagementDao.countContractManagement(reqMap);
	}

	@Override
	public List<Map<String, Object>> getContractManagementMap(Map<String, Object> reqMap) {
		List<Map<String, Object>> l =tContractManagementDao.selectSelectiveMap(reqMap);
		/*  应通过独立的外部批量定时处理
		String approveStatus = (String) reqMap.get("searchApproveStatus");
		int s = Integer.parseInt(approveStatus);
		if(s==01){
			for (Map<String, Object> r : l) {
				Date approveDate = (Date) r.get("approveDate");
				Date expiryDate = (Date) r.get("expiryDate");
				
				Calendar currentDate = Calendar.getInstance();
				Date curDate = currentDate.getTime();
				String approveId = (String) r.get("approveId");
				if(curDate.after(expiryDate)){
					  Map<String, Object> updateMap = Maps.newHashMap();
		  			  updateMap.put("approveId", approveId);
		  			  updateMap.put("approveStatus", "09");
		  			  int a = tContractManagementDao.updateByPrimaryKey(updateMap);
				}
				long b = curDate.getTime()-approveDate.getTime();
				long c =24*60*60*1000;
				long d =b/c;
				if(d>=3&&d<7){
					//生成客户外呼任务
					System.out.print("please inform the customer soon");
				}
				
			}
			List<Map<String, Object>> la =tContractManagementDao.selectSelectiveMap(reqMap);
			return la;
			
			
		}else{
			return l;
		}
		*/
		return l;
		
	}

	@Override
	public int insertContractManagementMap(Map<String, Object> reqMap) {
		
		return tContractManagementDao.insertSelectiveMap(reqMap);
	}
	@Override
	public int insertRejectReason(Map<String, Object> reqMap){
		return tContractManagementDao.insertRejectReason(reqMap);
	}
	
	@Override
	public int delContractManagement(String approveId) {
		return tContractManagementDao.deleteByPrimaryKey(approveId);
	}

	@Override
	public int updateContractManagementInfo(Map<String, Object> updateMap){
		return tContractManagementDao.updateByPrimaryKey(updateMap);
		
	}
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor=Exception.class)
	public int updateApprovalInfo(Map<String, Object> updateMap){
		
		Map<String, Object> logMap = Maps.newHashMap();
		String approveId = (String)updateMap.get("approveId");
		int f = getAdjustMaxApproveNum(approveId);
		logMap.put("approveId",approveId);
		logMap.put("approvenum",f);
		logMap.put("adjustreason",(String)updateMap.get("reasondetail"));
		logMap.put("adjustdt", new Date());
		logMap.put("adjustpersonId",(String)updateMap.get("userName"));
		tContractManagementDao.insertApproveAdjust(logMap);
		
		boolean newCard = (boolean)updateMap.get("isNewCard");
		Map<String, Object> cardMap = Maps.newHashMap();
		cardMap.put("bankAccno",(String)updateMap.get("accountNo"));
		cardMap.put("bankBranName",(String)updateMap.get("bankBranName"));
		cardMap.put("bankSubbName",(String)updateMap.get("bankSubbName"));
		if(newCard){
			cardMap.put("custId",(String)updateMap.get("custId"));
			cardMap.put("bankName",(String)updateMap.get("bankId"));
			cardMap.put("createTime",new Date());
			bankAccnoInfoDao.insertSelectiveMap(cardMap);
		}else{
			bankAccnoInfoDao.updateByPrimaryKeySelectiveMap(cardMap);
		}
		
		Map<String, Object> approvalMap = Maps.newHashMap();
		approvalMap.put("approveId", approveId);
		approvalMap.put("accountOpenBank", (String)updateMap.get("bankId"));
		approvalMap.put("accountBranchBank", (String)updateMap.get("bankBranName"));
		approvalMap.put("accountSubBranchBank", (String)updateMap.get("bankSubbName"));
		approvalMap.put("acceptAccount", (String)updateMap.get("accountNo"));
		
		if(updateMap.containsKey("approveAmount")){
			approvalMap.put("approveAmount", (BigDecimal)updateMap.get("approveAmount"));
		}
		if(updateMap.containsKey("approveInterest")){
			approvalMap.put("approveInterest", (BigDecimal)updateMap.get("approveInterest"));
		}

		
		return tContractManagementDao.updateByPrimaryKey(approvalMap);
	}

	@Override
	public List<Map<String, Object>> selectSelectiveMap(
			Map<String, Object> reqMap) {
		return tContractInfoDao.selectSelectiveMap(reqMap);
	}

	@Override
	public Map<String, Object> selectOneMapById(String contNo) {
		if(contNo == null){
			return null;
		}
		Map<String, Object> reqMap = Maps.newHashMap();
		reqMap.put(CONT_NO, Objects.firstNonNull(contNo, ""));
		List<Map<String, Object>> resList = selectSelectiveMap(reqMap);
		if(ListUtil.isNotEmpty(resList)){
			return resList.get(0);
		}else{
			return Maps.newHashMap();
		}
	}
	
	@Override
    public Map<String, Object> selectOneMapByZzApp(String contNo) {
        if(contNo == null){
            return null;
        }
        Map<String, Object> reqMap = Maps.newHashMap();
        reqMap.put("contNoLike", contNo);
        List<Map<String, Object>> resList = selectSelectiveMap(reqMap);
        if(ListUtil.isNotEmpty(resList)){
            return resList.get(0);
        }else{
            return Maps.newHashMap();
        }
    }

	@Override
	public Long countAgreementMap(Map<String, Object> reqMap) {
		return tContractInfoDao.countSelectiveMap(reqMap);
	}

	@Override
	public int updateContractSelectiveMap(Map<String, Object> reqMap) {
		return tContractInfoDao.updateSelectiveMapByKey(reqMap);
	}
//	@Override
//	public TContractManagement getContractInfoById(String contno) {
//		return tContractManagementDao.getContractInfoById(contno);
//	}

	@Override
	public int insertApproveReject(Map<String, Object> map) {
		return tContractManagementDao.insertApproveReject(map);
	}

	@Override
	public int getRejectMaxApproveNum(String approveId) {
		return tContractManagementDao.selectRejectMaxApproveNumByApproveId(approveId);
	}
	
	@Override
	public int getAdjustMaxApproveNum(String approveId) {
		return tContractManagementDao.selectAdjustMaxApproveNumByApproveId(approveId);
	}

	@Override
	public TApproveReject getRejectInfo(Map<String, Object> updateMap) {
		return tContractManagementDao.selectByPrimaryKey(updateMap);
	}

	@Override
	public int updateApproveInfo(Map<String, Object> updateMap) {
		return tContractManagementDao.updateApproveChange(updateMap);
	}

	@Override
	public int insertApproveAdjust(Map<String, Object> map) {
		return tContractManagementDao.insertApproveAdjust(map);
	}

	@Override
	public TApproveResult getApproveInfo(String approveId) {
		return tContractManagementDao.getApproveInfo(approveId);
	}

	@Override
	public TContractManagement getContractInfoByLoanId(String loanId) {
		return tContractManagementDao.getContractInfoByLoanId(loanId);
	}

	@Override
	public String getcustId(String contNo) {
		return tContractManagementDao.getcustIdByContNo(contNo);
	}

	@Override
	public TContractManagement getContractInfoByContNo(String contNo) {
		return tContractManagementDao.getContractInfoByContNo(contNo);
	}

	@Override
	public TApproveResult getApproveResultInfoByLoanId(String loanId) {
		return tContractManagementDao.getApproveResultInfoByLoanId(loanId);
	}

	@Override
	public int updateContractStatus(Map<String, Object> updateMap) {
		return tContractManagementDao.updateContractStatus(updateMap);
	}




	/**
	 * 
	 * @see com.hrbb.loan.pos.service.LoanPosContractManagementService#queryListByZzApp(java.util.Map)
	 */
    @Override
    public List<Map<String, Object>> queryListByZzApp(Map<String, Object> map) {
        // 1. 查询
        List<Map<String, Object>> retList = tContractInfoDao.selectByZzApp(map);
        if (retList.isEmpty()) {
            return null;
        }
        
        // 2. 统计信息补入
        for (int i = 0; i < retList.size(); i++) {
            Map<String, Object> tmpMap = retList.get(i);
            String contNo = (String) tmpMap.get("contno");
            if (StringUtil.isEmpty(contNo)) {
                continue;
            }
            
            String sumLoanTotalBalance = loanPosPaybackService.getReceiptTotalAmountByContNo(contNo);
            if (StringUtil.isEmpty(sumLoanTotalBalance)) {
                sumLoanTotalBalance = "0";
            }
            
            BigDecimal sumLoanTotalBalanceAmt = new BigDecimal(sumLoanTotalBalance);
            BigDecimal conttotalamt = (BigDecimal) tmpMap.get("conttotalamt");
            BigDecimal conttouseamt = conttotalamt.subtract(sumLoanTotalBalanceAmt);
            if (conttouseamt == null) {
                continue;
            }
            
            // 减掉10、80状态的用款金额
            BigDecimal totalPayApplyAmt = paymentApplyService.getPaymentApplyInfocontno(contNo);
            if (totalPayApplyAmt == null) {
                totalPayApplyAmt = new BigDecimal("0.0");
            }
            conttouseamt = conttouseamt.subtract(totalPayApplyAmt);
            
            tmpMap.put("conttouseamt", conttouseamt.doubleValue() < 0 ? 0 : conttouseamt.doubleValue());
        }
        
        return retList;
    }

    @Override
    public List<Map<String, Object>> selectAvalibleSelectiveMap(Map<String, Object> reqMap) {
        return tContractInfoDao.selectAvalibleSelectiveMap(reqMap);
    }

    @Override
    public Long countAvalibleAgreementMap(Map<String, Object> reqMap) {
        return tContractInfoDao.countAvalibleSelectiveMap(reqMap);
    }

	@Override
	public List<Map<String, Object>> getApproveMap(String loanId) {
		 return tContractInfoDao.getApproveMap(loanId);
	}

//	@Override
//	public TContractManagement getReceiptList(String contno) {
//		return tContractManagementDao.selectContractFetchReceipt(contno);
//	}

    @Override
    public List<TApproveResult> getAvailableContractManagementMap(
            Map<String, Object> reqMap) {
        List<TApproveResult> l =tContractManagementDao.selectAvailableSelectiveMap(reqMap);
        /*		建议通过外部独立
        String approveStatus  (String) reqMap.get("searchApproveStatus");
        int s = Integer.parseInt(approveStatus);
        if(s==01){
            for (TApproveResult r : l) {
                Date approveDate = r.getApproveDate();
                Date expiryDate = r.getExpiryDate();
                Calendar currentDate = Calendar.getInstance();
                Date curDate = currentDate.getTime();
                if(curDate.after(expiryDate)){
                      Map<String, Object> updateMap = Maps.newHashMap();
                      updateMap.put("approveId", r.getApproveId());
                      updateMap.put("approveStatus", "09");
                      int a = tContractManagementDao.updateByPrimaryKey(updateMap);
                }
                long b = curDate.getTime()-approveDate.getTime();
                long c =24*60*60*1000;
                long d =b/c;
                if(d>=3&&d<7){
                    //生成客户外呼任务
                    System.out.print("please inform the customer soon");
                }
                
            }
            List<TApproveResult> la =tContractManagementDao.selectAvailableSelectiveMap(reqMap);
            return la;
            
            
        }else{
            return l;
        }
        */
        return l;
        
    }

    @Override
    public Long countAvailableContractManagementMap(Map<String, Object> reqMap) {
        return tContractManagementDao.countAvailableContractManagement(reqMap);
    }

	@Override
	public int updateContractInfo(Map<String, Object> contractMap) {
		return tContractManagementDao.updateContractInfo(contractMap);
	}

	@Override
	public long countApprove(Map<String, Object> reqMap) {
		return tContractManagementDao.countApprove(reqMap);
	}

	@Override
	public TContractManagement getContractInfoByPayapplyId(String payApplyId) {
		return tContractManagementDao.getContractInfoByPayApplyId(payApplyId);
	}
	


		
}
