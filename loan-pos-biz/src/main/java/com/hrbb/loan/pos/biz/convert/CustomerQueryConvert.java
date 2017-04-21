package com.hrbb.loan.pos.biz.convert;

import com.hrbb.loan.pos.dao.entity.TCustomer;
import com.hrbb.loan.pos.dao.entity.TCustomerBase;
import com.hrbb.loan.pos.dao.entity.TRelativeInfo;
import com.hrbb.loan.pos.facade.bean.customer.QueryCustomerBaseInfoReq;
import com.hrbb.loan.pos.facade.bean.customer.QueryCustomerBaseInfoRes;
import com.hrbb.loan.pos.facade.bean.customer.QueryCustomerInfoReq;
import com.hrbb.loan.pos.facade.bean.customer.QueryCustomerInfoRes;
import com.hrbb.loan.pos.facade.constants.SysRetCodeConstants;

/**
 * 
 * 
 * @author XLY
 * @version $Id: CustomerConvert.java, v 0.1 2015-2-16 下午2:05:13 XLY Exp $
 */
public class CustomerQueryConvert {
    
    public static TCustomerBase  queryCustomerBaseInfoReq2TCustomerBase(QueryCustomerBaseInfoReq req) {
        TCustomerBase t = new TCustomerBase();
        t.setCustId(req.getCustId());
        return t;
    }

    public static QueryCustomerBaseInfoRes tCustomerBase2QueryCustomerBaseInfoRes(TCustomerBase t){
        QueryCustomerBaseInfoRes res = new QueryCustomerBaseInfoRes();
        res.setAcustId(t.getAcustId());
        res.setBankId(t.getBankId());
        res.setBlackBeginDate(t.getBlackBeginDate());
        res.setBlackEndDate(t.getBlackEndDate());
        res.setBlackReason(t.getBlackReason());
        res.setBlackType(t.getBlackType());
        res.setBookDate(t.getBookDate());
        res.setCorpCustFlag(t.getCorpCustFlag());
        res.setCustId(t.getCustId());
        res.setCustName(t.getCustName());
        res.setCustState(t.getCustState());
        res.setDelFlag(t.getDelFlag());
        res.setIsBadLoan(t.getIsBadLoan());
        res.setIsBlack(t.getIsBlack());
        res.setIsLoan(t.getIsLoan());
        res.setIsOutAssu(t.getIsOutAssu());
        res.setIsPayOffLoan(t.getIsPayOffLoan());
        res.setIsRela(t.getIsRela());
        
        res.setLastChanBankId(t.getLastChanBankId());
        res.setLastChanDate(t.getLastChanDate());
        res.setLastChanPerson(t.getLastChanPerson());
        
        res.setOperId(t.getOperId());
        res.setOrigBankId(t.getOrigBankId());
        res.setOrigOperId(t.getOrigOperId());
        res.setPaperId(t.getPaperId());
        res.setPaperKind(t.getPaperKind());
        res.setRecoId(t.getRecoId());
        
        res.setRespCode(SysRetCodeConstants.SUCCESS.getCode());
        
        
        return res;
    }
    
    public static TCustomer  queryCustomerInfoReq2TCustomer(QueryCustomerInfoReq req) {
        TCustomer t = new TCustomer();
        t.setCustId(req.getCustId());
        return t;
    }
    
    public static QueryCustomerInfoRes tCustomer2QueryCustomerInfoRes(TCustomer t){
        QueryCustomerInfoRes res = new QueryCustomerInfoRes();

        res.setBirtDate(t.getBirtDate());
        res.setBusiYear(t.getBusiYear());
        res.setCustId(t.getCustId());
        res.setCustName(t.getCustName());
        res.setChildNum(t.getChildNum());
        res.setContactAddrFlag(t.getContactAddrFlag());
        res.setCorpAddr(t.getCorpAddr());
        res.setEducSign(t.getEducSign());
        res.setEmail(t.getEmail());
        res.setFamilyCustName(t.getFamilyCustName());
        res.setInhabStatSign(t.getInhabStatSign());
        res.setLastChanDate(t.getLastChanDate());
        res.setLastChanPerson(t.getLastChanPerson());
        res.setLoanPaperCheckDate(t.getLoanPaperCheckDate());
        res.setLoanPaperId(t.getLoanPaperId());
        res.setLocalHouseNum(t.getLocalHouseNum());
        res.setMarrSign(t.getMarrSign());
        res.setMateMobilephone(t.getMateMobilephone());
        res.setMatePaperId(t.getMatePaperId());
        res.setMatePaperKind(t.getMatePaperKind());
        res.setMobilePhone(t.getMobilePhone());
        res.setNatiFlag(t.getNatiFlag());
        res.setNatiSign1(t.getNatiSign1());
        res.setOtherHouseNum(t.getOtherHouseNum());
        res.setPaperId(t.getPaperId());
        res.setPaperKind(t.getPaperKind());
        res.setQqNo(t.getQqNo());
        res.setRegiSeat(t.getRegiSeat());
        res.setRemarks(t.getRemarks());
        res.setResidentCity(t.getResidentCity());
        res.setResidentDetail(t.getResidentDetail());
        res.setResidentProv(t.getResidentProv());
        res.setSexSign(t.getSexSign());
        res.setTel(t.getTel());
        res.setVeriFication(t.getVeriFication());
        res.setWeixinNo(t.getWeixinNo());
        res.setWorkCorp(t.getWorkCorp());
        
        res.setRespCode(SysRetCodeConstants.SUCCESS.getCode());
        return res;
    }
    
    /***
     * 
     * 
     * @param t
     * @param res
     * @return
     */
    public static QueryCustomerInfoRes  tRelativeInfoAdd2QueryCustomerInfoRes(TRelativeInfo t,QueryCustomerInfoRes res){
        res.setRelaCustName(t.getRelaCustName());
        res.setRelaKind(t.getRelaKind());
        res.setRelaMobilephone(t.getRelaMobilePhone());
        res.setRelaTel(t.getRelaTel());
        return res;
    }
}
