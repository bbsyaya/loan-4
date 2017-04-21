package com.hrbb.loan.pos.biz.convert;

import com.hrbb.loan.pos.dao.entity.TCustomer;
import com.hrbb.loan.pos.dao.entity.TCustomerBase;
import com.hrbb.loan.pos.dao.entity.TRelativeInfo;
import com.hrbb.loan.pos.facade.bean.customer.CustomerInfoBaseInsertRes;
import com.hrbb.loan.pos.facade.bean.customer.CustomerInfoBaseReq;
import com.hrbb.loan.pos.facade.bean.customer.CustomerInfoInsertRes;
import com.hrbb.loan.pos.facade.bean.customer.CustomerInfoReq;
/**
 * 
 * 
 * @author XLY
 * @version $Id: CustomerAddConvert.java, v 0.1 2015-2-28 下午3:22:24 XLY Exp $
 */
public class CustomerAddConvert {

    /**
     * add Customer
     * 
     * @param req
     * @return
     */
    public static TCustomer CustomerInfoInsertReq2TCustomer(CustomerInfoReq tCustomerReq) {
        TCustomer tCustomer = new TCustomer();
        tCustomer.setBirtDate(tCustomerReq.getBirtDate());
        tCustomer.setBusiYear(tCustomerReq.getBusiYear());
        tCustomer.setCustId(tCustomerReq.getCustId());
        tCustomer.setCustName(tCustomerReq.getCustName());
        tCustomer.setChildNum(tCustomerReq.getChildNum());
        tCustomer.setContactAddrFlag(tCustomerReq.getContactAddrFlag());
        tCustomer.setCorpAddr(tCustomerReq.getCorpAddr());
        tCustomer.setEducSign(tCustomerReq.getEducSign());
        tCustomer.setEmail(tCustomerReq.getEmail());
        tCustomer.setFamilyCustName(tCustomerReq.getFamilyCustName());
        tCustomer.setInhabStatSign(tCustomerReq.getInhabStatSign());
        tCustomer.setLastChanDate(tCustomerReq.getLastChanDate());
        tCustomer.setLastChanPerson(tCustomerReq.getLastChanPerson());
        tCustomer.setLoanPaperCheckDate(tCustomerReq.getLoanPaperCheckDate());
        tCustomer.setLoanPaperId(tCustomerReq.getLoanPaperId());
        tCustomer.setLocalHouseNum(tCustomerReq.getLocalHouseNum());
        tCustomer.setMarrSign(tCustomerReq.getMarrSign());
        tCustomer.setMateMobilephone(tCustomerReq.getMateMobilephone());
        tCustomer.setMatePaperId(tCustomerReq.getMatePaperId());
        tCustomer.setMatePaperKind(tCustomerReq.getMatePaperKind());
        tCustomer.setMobilePhone(tCustomerReq.getMobilePhone());
        tCustomer.setNatiFlag(tCustomerReq.getNatiFlag());
        tCustomer.setNatiSign1(tCustomerReq.getNatiSign1());
        tCustomer.setOtherHouseNum(tCustomerReq.getOtherHouseNum());
        tCustomer.setPaperId(tCustomerReq.getPaperId());
        tCustomer.setPaperKind(tCustomerReq.getPaperKind());
        tCustomer.setQqNo(tCustomerReq.getQqNo());
        tCustomer.setRegiSeat(tCustomerReq.getRegiSeat());
        tCustomer.setRemarks(tCustomerReq.getRemarks());
        tCustomer.setResidentCity(tCustomerReq.getResidentCity());
        tCustomer.setResidentDetail(tCustomerReq.getResidentDetail());
        tCustomer.setResidentProv(tCustomerReq.getResidentProv());
        tCustomer.setSexSign(tCustomerReq.getSexSign());
        tCustomer.setTel(tCustomerReq.getTel());
        tCustomer.setVeriFication(tCustomerReq.getVeriFication());
        tCustomer.setWeixinNo(tCustomerReq.getWeixinNo());
        tCustomer.setWorkCorp(tCustomerReq.getWorkCorp());    
        return tCustomer;
    }
    
    public static TRelativeInfo CustomerInfoInsertReq2TRelativeInfo(CustomerInfoReq tCustomerReq) {
        TRelativeInfo tCustomer = new TRelativeInfo();
        tCustomer.setRelaCustName(tCustomerReq.getRelaCustName());
        tCustomer.setRelaKind(tCustomerReq.getRelaKind());
        tCustomer.setRelaMobilePhone(tCustomerReq.getRelaMobilephone());
        tCustomer.setRelaTel(tCustomerReq.getRelaTel());
        return tCustomer;
    }
    
    /**
     * add Customer return
     * 
     * @param req
     * @return
     */
    public static CustomerInfoInsertRes TCustomer2TCustomerInfoInsertRes(TCustomer tCustomer) {
        CustomerInfoInsertRes res = new CustomerInfoInsertRes();
        res.setCustId(tCustomer.getCustId());
        return res;
    }
    

    /**
     * add CustomerBase
     * 
     * @param req
     * @return
     */
    public static TCustomerBase  CustomerInfoBaseInsertReq2TCustomerBase(CustomerInfoBaseReq req) {
        TCustomerBase tCustomerBase = new TCustomerBase();
        tCustomerBase.setCustId(req.getCustId());
        tCustomerBase.setAcustId(req.getAcustId());
        tCustomerBase.setBankId(req.getBankId());
        tCustomerBase.setBlackBeginDate(req.getBlackBeginDate());
        tCustomerBase.setBlackEndDate(req.getBlackEndDate());
        tCustomerBase.setBlackReason(req.getBlackReason());
        tCustomerBase.setBlackType(req.getBlackType());
        tCustomerBase.setBookDate(req.getBookDate());
        tCustomerBase.setCorpCustFlag(req.getCorpCustFlag());
        tCustomerBase.setCustId(req.getCustId());
        tCustomerBase.setCustName(req.getCustName());
        tCustomerBase.setCustState(req.getCustState());
        tCustomerBase.setDelFlag(req.getDelFlag());
        tCustomerBase.setIsBadLoan(req.getIsBadLoan());
        tCustomerBase.setIsBlack(req.getIsBlack());
        tCustomerBase.setIsLoan(req.getIsLoan());
        tCustomerBase.setIsOutAssu(req.getIsOutAssu());
        tCustomerBase.setIsPayOffLoan(req.getIsPayOffLoan());
        tCustomerBase.setIsRela(req.getIsRela());
        
        tCustomerBase.setLastChanBankId(req.getLastChanBankId());
        tCustomerBase.setLastChanDate(req.getLastChanDate());
        tCustomerBase.setLastChanPerson(req.getLastChanPerson());
        
        tCustomerBase.setOperId(req.getOperId());
        tCustomerBase.setOrigBankId(req.getOrigBankId());
        tCustomerBase.setOrigOperId(req.getOrigOperId());
        tCustomerBase.setPaperId(req.getPaperId());
        tCustomerBase.setPaperKind(req.getPaperKind());
        tCustomerBase.setRecoId(req.getRecoId());
        return tCustomerBase;
    }
    
    /**
     * add CustomerBase return
     * 
     * @param req
     * @return
     */
    public static  CustomerInfoBaseInsertRes tCustomerBase2CustomerInfoBaseInsertRes(TCustomerBase req) {
        CustomerInfoBaseInsertRes t = new CustomerInfoBaseInsertRes();
        t.setAcustId(req.getAcustId());
        return t;
    }
}
