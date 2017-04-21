package com.hrbb.loan.pos.biz.backstage.inter.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosCustomerBackStageBiz;
import com.hrbb.loan.pos.biz.convert.CustomerAddConvert;
import com.hrbb.loan.pos.dao.entity.TBankProperties;
import com.hrbb.loan.pos.dao.entity.TCustomer;
import com.hrbb.loan.pos.facade.bean.customer.CustomerInfoInsertRes;
import com.hrbb.loan.pos.facade.bean.customer.CustomerInfoReq;
import com.hrbb.loan.pos.facade.constants.SysRetCodeConstants;
import com.hrbb.loan.pos.service.LoanPosCustomerService;
import com.hrbb.loan.pos.util.IdUtil;

/**
 * 
 * 
 * @author XLY
 * @version $Id: LoanPosCustomerBackStageBiz.java, v 0.1 2015-3-5 上午9:58:06 XLY Exp $
 */
public class LoanPosCustomerBackStageBizImpl implements ILoanPosCustomerBackStageBiz{
    private Logger LOG = LoggerFactory.getLogger(LoanPosCustomerBackStageBizImpl.class);

    @Autowired
    private LoanPosCustomerService loanPosCustomerService;
    
    public List<Map<String, Object>> queryCustomerInfo(Map<String, Object> reqMap) {
        return loanPosCustomerService.selectCustomerInfoSelectiveMap(reqMap);
    }
    
    public List<Map<String, Object>> queryCustRelaInfo(Map<String, Object> reqMap){
        return loanPosCustomerService.getRelativeInfo(reqMap);
    }
    
    public List<Map<String, Object>> queryCustMerchantInfo(Map<String, Object> reqMap){
        return loanPosCustomerService.getPosCustInfo(reqMap);
    }
    
    @Override
    public List<Map<String, Object>> queryCustBankInfo(Map<String, Object> reqMap){
        return loanPosCustomerService.getBankAccno(reqMap);
    }
    
    @Override
    public void modifyCustomerInfo(Map<String, Object> reqMap) {
        //申请信息修改
        loanPosCustomerService.updateCustomerInfoMap(reqMap);
    } 
    @Override
    public void modifyCustRelaInfo(Map<String, Object> reqMap) {
        //申请信息修改
        loanPosCustomerService.updateRelativeInfo(reqMap);
    } 
    
    @Override
    public void modifyCustMerchantInfo(Map<String, Object> reqMap){
        loanPosCustomerService.updatePosCustInfo(reqMap);
    }
    
    @Override
    public void modifyCustBankInfo(Map<String, Object> reqMap){
        loanPosCustomerService.updateBankAccno(reqMap);
    }


    
    public Map<String,Object> insertCustomerFromApplyByMap(Map<String,Object> reqMap){
        Map<String,Object> res = new HashMap<String,Object>();
        String custId="";
        try {
            List<TCustomer> queryResult =  loanPosCustomerService.getCustomerInfoSelective(reqMap);
            if(CollectionUtils.isEmpty(queryResult)){
                //insertCustomer
                custId = IdUtil.getId("CU");
                res.put("custId", custId);
                reqMap.put("custId", custId);
                loanPosCustomerService.insertCustomerInfoMap(reqMap);
                //insertRela
                String relativeId=IdUtil.getId("RE");
                {
                    Map<String,Object> relaMap = new HashMap<String,Object>();
                    relaMap.put("relativeId",relativeId);
                    relaMap.put("custId", reqMap.get("custId"));
                    relaMap.put("relaCustName",reqMap.get("relaCustName"));
                    relaMap.put("relaKind",reqMap.get("relaKind"));
                    relaMap.put("relaMobilePhone",reqMap.get("relaMobilePhone"));
                    relaMap.put("relaTel",reqMap.get("relaTel"));
                    loanPosCustomerService.insertRelativeInfo(relaMap);
                }
                String posCustId=IdUtil.getId("MH");
                {
                    Map<String,Object> mercMap = new HashMap<String,Object>();
                    mercMap.put("posCustId",posCustId);
                    mercMap.put("custId",custId);
                    mercMap.put("posCustName",reqMap.get("posCustName"));
                    mercMap.put("busiDivision",reqMap.get("busiDivision"));
                    mercMap.put("operName",reqMap.get("operName"));
                    mercMap.put("operDate",new Date());
                    mercMap.put("posCustBusiScope",reqMap.get("posCustBusiScope"));
                    mercMap.put("posCustAddress",reqMap.get("posCustAddress"));
                    mercMap.put("operAddrCode",reqMap.get("operAddrCode"));
                    mercMap.put("industryTypeId",reqMap.get("industryTypeId"));
                    mercMap.put("industryTypeId2",reqMap.get("industryTypeId2"));
                    mercMap.put("regiCode",reqMap.get("regiCode"));
                    loanPosCustomerService.insertPosCustInfo(mercMap);
                }
                {
                    Map<String,Object> bankAccNoMap = new HashMap<String,Object>();
                    bankAccNoMap.put("bankAccno",reqMap.get("bankAccno"));
                    bankAccNoMap.put("custId",custId);
                    bankAccNoMap.put("bankName",reqMap.get("bankName"));
                    bankAccNoMap.put("bankBranName",reqMap.get("bankBranName"));
                    bankAccNoMap.put("bankSubbName",reqMap.get("bankSubbName"));
                    loanPosCustomerService.insertBankAccno(bankAccNoMap);
                }
                res.put("relativeId", relativeId);
                res.put("posCustId", posCustId);
            }else{
                custId = queryResult.get(0).getCustId();
                res.put("custId", custId);
                {
                    Map<String,Object> reqRelaMap = new HashMap<String,Object>();
                    reqRelaMap.put("custId", custId);
                    reqRelaMap.put("relaCustName", reqMap.get("relaCustName"));
                    List<Map<String,Object>> resList = loanPosCustomerService.getRelativeInfo(reqRelaMap);
                    if(CollectionUtils.isEmpty(resList)){
                        String relativeId = IdUtil.getId("RE");
                        Map<String,Object> relaMap = new HashMap<String,Object>();
                        relaMap.put("relativeId",relativeId);
                        relaMap.put("custId", reqMap.get("custId"));
                        relaMap.put("relaCustName",reqMap.get("relaCustName"));
                        relaMap.put("relaKind",reqMap.get("relaKind"));
                        relaMap.put("relaMobilePhone",reqMap.get("relaMobilePhone"));
                        relaMap.put("relaTel",reqMap.get("relaTel"));
                        loanPosCustomerService.insertRelativeInfo(relaMap);
                        res.put("relativeId",(String)relaMap.get("relativeId"));
                    }else{
                        res.put("relativeId",(String)resList.get(0).get("relativeId"));
                    }
                }
                {
                    Map<String,Object> reqMerchMap = new HashMap<String,Object>();
                    reqMerchMap.put("custId", custId);
                    reqMerchMap.put("posCustName", reqMap.get("posCustName"));
                    List<Map<String,Object>> resList = loanPosCustomerService.getPosCustInfo(reqMerchMap);
                    if(CollectionUtils.isEmpty(resList)){
                        String posCustId=IdUtil.getId("MH");
                        Map<String,Object> mercMap = new HashMap<String,Object>();
                        mercMap.put("posCustId",posCustId);
                        mercMap.put("custId",custId);
                        mercMap.put("posCustName",reqMap.get("posCustName"));
                        mercMap.put("busiDivision",reqMap.get("busiDivision"));
                        mercMap.put("operName",reqMap.get("operName"));
                        mercMap.put("operDate",new Date());
                        mercMap.put("posCustBusiScope",reqMap.get("posCustBusiScope"));
                        mercMap.put("posCustAddress",reqMap.get("posCustAddress"));
                        mercMap.put("operAddrCode",reqMap.get("operAddrCode"));
                        mercMap.put("industryTypeId",reqMap.get("industryTypeId"));
                        mercMap.put("industryTypeId2",reqMap.get("industryTypeId2"));
                        mercMap.put("regiCode",reqMap.get("regiCode"));
                        loanPosCustomerService.insertPosCustInfo(mercMap);
                        res.put("posCustId",posCustId);
                    }else{
                        res.put("posCustId",(String)resList.get(0).get("posCustId"));
                    }
                }
                {
                    Map<String,Object> reqBankAccnoMap = new HashMap<String,Object>();
                    reqBankAccnoMap.put("custId", custId);
                    reqBankAccnoMap.put("bankAccno", reqMap.get("bankAccno"));
                    List<Map<String,Object>> resList = loanPosCustomerService.getBankAccno(reqBankAccnoMap);
                    if(CollectionUtils.isEmpty(resList)){
                        Map<String,Object> bankAccNoMap = new HashMap<String,Object>();
                        bankAccNoMap.put("bankAccno",reqMap.get("bankAccno"));
                        bankAccNoMap.put("custId",custId);
                        bankAccNoMap.put("bankName",reqMap.get("bankName"));
                        bankAccNoMap.put("bankBranName",reqMap.get("bankBranName"));
                        bankAccNoMap.put("bankSubbName",reqMap.get("bankSubbName"));
                        loanPosCustomerService.insertBankAccno(bankAccNoMap);
                    }
                }
            }
        } catch (Exception e) {
         
            LOG.info("INSERT ERROR:"+reqMap.toString());
            res.put("respCode", SysRetCodeConstants.SYSTEM_ERROR.getCode());
        }
        return res;
    
    }
    
    
    public CustomerInfoInsertRes insertCustomerFromApply(CustomerInfoReq req){
        CustomerInfoInsertRes res = new CustomerInfoInsertRes();
        String custId="";
        try {
            Map<String,Object> reqMap = new HashMap<String,Object>();
            reqMap.put("paperId", req.getPaperId());
            List<TCustomer> queryResult =  loanPosCustomerService.getCustomerInfoSelective(reqMap);
            if(CollectionUtils.isEmpty(queryResult)){
                //insertCustomer
                TCustomer tCustomer = CustomerAddConvert.CustomerInfoInsertReq2TCustomer(req);
                custId = IdUtil.getId("CU");
                res.setCustId(custId);
                tCustomer.setCustId(custId);
                loanPosCustomerService.addTCustomer(tCustomer);
                //insertRela
                String relativeId=IdUtil.getId("RE");
                {
                    Map<String,Object> relaMap = new HashMap<String,Object>();
                    relaMap.put("relativeId",relativeId);
                    relaMap.put("custId",tCustomer.getCustId());
                    relaMap.put("relaCustName",req.getRelaCustName());
                    relaMap.put("relaKind",req.getRelaKind());
                    relaMap.put("relaMobilePhone",req.getRelaMobilephone());
                    relaMap.put("relaTel",req.getRelaTel());
                    loanPosCustomerService.insertRelativeInfo(relaMap);
                }
                String posCustId=IdUtil.getId("MH");
                {
                    Map<String,Object> mercMap = new HashMap<String,Object>();
                    mercMap.put("posCustId",posCustId);
                    mercMap.put("custId",custId);
                    mercMap.put("posCustName",req.getPosCustName());
                    mercMap.put("busiDivision",req.getBusiDivision());
                    mercMap.put("operName",req.getOprName());
                    mercMap.put("operDate",new Date());
                    mercMap.put("posCustBusiScope",req.getPosCustBusiScope());
                    mercMap.put("posCustAddress",req.getOperAddrDetail());
                    mercMap.put("operAddrCode",req.getOperAddrCode());
                    mercMap.put("industryTypeId",req.getIndustryTypeId());
                    mercMap.put("industryTypeId2",req.getIndustryTypeId2());
                    mercMap.put("regiCode",req.getRegiCode());
                    loanPosCustomerService.insertPosCustInfo(mercMap);
                }
                {
                    Map<String,Object> bankAccNoMap = new HashMap<String,Object>();
                    bankAccNoMap.put("bankAccno",req.getBankAccno());
                    bankAccNoMap.put("custId",custId);
                    bankAccNoMap.put("bankName",req.getBankName());
                    bankAccNoMap.put("bankBranName",req.getBankBranName());
                    bankAccNoMap.put("bankSubbName",req.getBankSubbName());
                    bankAccNoMap.put("createTime",new Date());
                    loanPosCustomerService.insertBankAccno(bankAccNoMap);
                }
                res.setRelativeId(relativeId);
                res.setPosCustId(posCustId);
            }else{
                custId = queryResult.get(0).getCustId();
                res.setCustId(custId);
                {
                    Map<String,Object> reqRelaMap = new HashMap<String,Object>();
                    reqRelaMap.put("custId", custId);
                    reqRelaMap.put("relaCustName", req.getRelaCustName());
                    List<Map<String,Object>> resList = loanPosCustomerService.getRelativeInfo(reqRelaMap);
                    if(CollectionUtils.isEmpty(resList)){
                        String relativeId = IdUtil.getId("RE");
                        Map<String,Object> relaMap = new HashMap<String,Object>();
                        relaMap.put("relativeId",relativeId);
                        relaMap.put("custId",custId);
                        relaMap.put("relaCustName",req.getRelaCustName());
                        relaMap.put("relaKind",req.getRelaKind());
                        relaMap.put("relaMobilePhone",req.getRelaMobilephone());
                        relaMap.put("relaTel",req.getRelaTel());
                        loanPosCustomerService.insertRelativeInfo(relaMap);
                        res.setRelativeId((String)relaMap.get("relativeId"));
                    }else{
                        res.setRelativeId((String)resList.get(0).get("relativeId"));
                    }
                }
                {
                    Map<String,Object> reqMerchMap = new HashMap<String,Object>();
                    reqMerchMap.put("custId", custId);
                    reqMerchMap.put("posCustName", req.getPosCustName());
                    List<Map<String,Object>> resList = loanPosCustomerService.getPosCustInfo(reqMerchMap);
                    if(CollectionUtils.isEmpty(resList)){
                        String posCustId=IdUtil.getId("MH");
                        Map<String,Object> mercMap = new HashMap<String,Object>();
                        mercMap.put("posCustId",posCustId);
                        mercMap.put("custId",custId);
                        mercMap.put("posCustName",req.getPosCustName());
                        mercMap.put("busiDivision",req.getBusiDivision());
                        mercMap.put("operName",req.getOprName());
                        mercMap.put("operDate",new Date());
                        mercMap.put("posCustBusiScope",req.getPosCustBusiScope());
                        mercMap.put("posCustAddress",req.getOperAddrDetail());
                        mercMap.put("operAddrCode",req.getOperAddrCode());
                        mercMap.put("industryTypeId",req.getIndustryTypeId());
                        mercMap.put("industryTypeId2",req.getIndustryTypeId2());
                        mercMap.put("regiCode",req.getRegiCode());
                        loanPosCustomerService.insertPosCustInfo(mercMap);
                        res.setPosCustId(posCustId);
                    }else{
                        res.setPosCustId((String)resList.get(0).get("posCustId"));
                    }
                }
                {
                    Map<String,Object> reqBankAccnoMap = new HashMap<String,Object>();
                    reqBankAccnoMap.put("custId", custId);
                    reqBankAccnoMap.put("bankAccno", reqMap.get("bankAccno"));
                    List<Map<String,Object>> resList = loanPosCustomerService.getBankAccno(reqBankAccnoMap);
                    if(CollectionUtils.isEmpty(resList)){
                        String posCustId=IdUtil.getId("MH");
                        Map<String,Object> bankAccNoMap = new HashMap<String,Object>();
                        bankAccNoMap.put("bankAccno",req.getBankAccno());
                        bankAccNoMap.put("custId",custId);
                        bankAccNoMap.put("bankName",req.getBankName());
                        bankAccNoMap.put("bankBranName",req.getBankBranName());
                        bankAccNoMap.put("bankSubbName",req.getBankSubbName());
                        bankAccNoMap.put("createTime",new Date());
                        loanPosCustomerService.insertBankAccno(bankAccNoMap);
                    }
                }
            }
        } catch (Exception e) {

            LOG.info("INSERT ERROR:"+req.toString());
            res.setCustId(custId);
            res.setRespCode(SysRetCodeConstants.SYSTEM_ERROR.getCode());
        }
        return res;
    }
    
    public void  insertCustomerFromApply(Map<String, Object> reqMap){

    }

	@Override
	public List<TCustomer> queryCustomerByPaperId(String paperId) {
		return loanPosCustomerService.selectOneCustomerByPaper(paperId);
	}

	@Override
	public TBankProperties queryBankPropertiesByBankName(String bankName) {
		return loanPosCustomerService.queryBankPropertiesByBankName(bankName);
	}
	
	@Override
	public TBankProperties queryBankLimitById(String bankId) {
		return loanPosCustomerService.queryBankLimitById(bankId);
	}
}
