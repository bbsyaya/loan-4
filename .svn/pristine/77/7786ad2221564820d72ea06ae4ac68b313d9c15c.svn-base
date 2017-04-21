/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hrbb.loan.exception.ServiceExceptionCode;
import com.hrbb.loan.pos.dao.TApproveResultDao;
import com.hrbb.loan.pos.dao.entity.TApproveResult;
import com.hrbb.loan.pos.dao.entity.TContract;
import com.hrbb.loan.pos.service.impl.LoanPosContractServiceImpl;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.RandomUtil;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HService;
import com.hrbb.sh.framework.HServiceException;

/**
 * 
 * @author byp
 * @version $Id: ContractCreatorService.java, v 0.1 2015年3月18日 下午2:50:06 byp Exp $
 */
@Service("contractCreatorService")
public class ContractCreatorService implements HService {

    private final Logger logger = Logger.getLogger(ContractCreatorService.class);
    
    @Autowired
    private LoanPosContractServiceImpl contractService;
    
    @Autowired
    @Qualifier("tApproveResultDao")
    private TApproveResultDao daoAR;
    /** 
     * @see com.hrbb.sh.framework.HService#serve(com.hrbb.sh.framework.HRequest)
     */
    @Override
    public HResponse serve(HRequest request) throws HServiceException {
        Map<String, Object> propMap = request.getProperties();
        String loanId = (String)propMap.get("loanid");
        String custId = (String)propMap.get("custid");
        
        String peerLoanId = (String)propMap.get("stdshno");
        String peerCustId = (String)propMap.get("stdmerno");
        // 获得申请审批表中的批准信息
        TApproveResult approve = daoAR.selectByLoanId(loanId);
        
        HResponse response = new HResponse();
        int respCode = 0;
        if (StringUtils.isBlank(loanId)) {
            logger.error("loanId非法 [" + loanId + "]!");
            respCode = ServiceExceptionCode.BANK_FAILURE;
            response.setRespMessage("接口申请号非法 [" + loanId + "]!");
        }
        
        if ( respCode > 0 ) {
            response.setRespCode(String.valueOf(respCode));
            response.setRespMessage("校验失败");
            response.setRespTime(new Date());
            return response;
        }
        //
        TContract contract = new TContract();
        contract.setCustId(custId);
        contract.setLoanId(loanId);
        contract.setAmt(approve.getApproveAmount());
        contract.setContNo(DateUtil.getCurrentTimePattern5()+RandomUtil.getRandom(10));
        contract.setRetuKind("90");//默认 01 - 利随本清
        contract.setRetuKind2(approve.getPaybackMethod());
        contract.setContTerm(approve.getApproveTerm());
        contract.setCustName(approve.getCustName());
        contract.setInteRate(approve.getApproveInterest());
        contract.setProdId("1001020396");//固定值
        contract.setProdName("POS贷");
        Calendar calendar = Calendar.getInstance();
        contract.setBeginDate(calendar.getTime());
        String termUnit = approve.getApproveTermUnit();
        String term = approve.getApproveTerm();
        contract.setContTerm(term);
        contract.setTermUnit(termUnit);
        int field = 0;
        if ("Y".equals(termUnit)){
            field = Calendar.YEAR;
        } else if ("M".equals(termUnit)){
            field = Calendar.MONTH;
        } else {
            field = Calendar.DAY_OF_YEAR;
        }
        calendar.add(field, Integer.valueOf(term));
        contract.setEndDate(calendar.getTime());
        contract.setDepeSubsac(approve.getAccountOpenBank());
        contract.setDepeSubsacNo(approve.getAcceptAccount());
        contract.setIndeSubsac(approve.getAccountOpenBank());
        contract.setIndeSubsacNo(approve.getAcceptAccount());
        contract.setContTotalAmt(approve.getApproveAmount());//
        contract.setApprTotalAmt(approve.getApproveAmount());//批准金额和审批通过金额都是审批最后通过的金额
        contract.setApptTerm(approve.getApplyTerm());
        //默认值部分
        contract.setCurrSign("CNY");
        contract.setLoanForm("0");//贷款形式 - 新增
        contract.setRetuKind("90");//还款方式 - 利随本清
        contract.setInteType("1");//利率类别 - 固定利率
        contract.setInteBalKind("2");//结息方式 - 按户定日
        contract.setInteCompKind("1");//计息方式 - 按期计息
        contract.setFineCompKind("1");//逾期计息方式 - 按期计息
        contractService.insertContract(contract);
        
        
        HashMap<String,Object> map = new HashMap<String, Object>(32);
        map.put("stdshno", propMap.get("stdshno"));
        map.put("stdmerno", propMap.get("stdmerno"));
        map.put("loanid",contract.getLoanId());
        map.put("custid",contract.getCustId());
        map.put("custname",contract.getCustName());
        map.put("begindate",contract.getBeginDate());
        map.put("enddate",contract.getLoanId());
        map.put("apptcapi",contract.getApprTotalAmt());
        map.put("interate",contract.getInteRate());
        map.put("retukind",contract.getRetuKind());
        map.put("retukind2",contract.getRetuKind2());
        map.put("loanbankname",approve.getAccountOpenBank());
        map.put("loanbankbranchname",approve.getAccountBranchBank());
        map.put("loanbanksubname",approve.getAccountSubBranchBank());
        map.put("loanbankacno",approve.getAcceptAccount());
        map.put("loanbankacname",contract.getCustName());
        map.put("repaybankname",approve.getAccountOpenBank());
        map.put("repaybankbranchname",approve.getAccountBranchBank());
        map.put("repaybanksubname",approve.getAccountSubBranchBank());
        map.put("repaybankaccno",approve.getAcceptAccount());
        map.put("repaybankaccname",contract.getCustName());
        map.put("loadendtime","15:30");
        
        response.setRespCode(String.valueOf(respCode));
        response.setRespTime(new Date());
        response.setProperties(map);
        return response;
    }

}