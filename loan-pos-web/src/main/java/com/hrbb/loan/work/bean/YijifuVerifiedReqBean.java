package com.hrbb.loan.work.bean;

/**
 * 易极付卡验证 请求.
 * 
 * @author xiongshaogang
 * @version $Id: YijifuVerifiedReqBean.java, v 0.1 2015年5月20日 下午5:35:26 xiongshaogang Exp $
 */
public class YijifuVerifiedReqBean {
    
    private String bankCode;
    private String bankBranchName;
    private String bankSubbranchName;
    private String bankCardNo;
    private String certType;
    private String certId;
    private String certName;
    
    public String getBankCode() {
        return bankCode;
    }
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
    public String getBankBranchName() {
        return bankBranchName;
    }
    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName;
    }
    public String getBankSubbranchName() {
        return bankSubbranchName;
    }
    public void setBankSubbranchName(String bankSubbranchName) {
        this.bankSubbranchName = bankSubbranchName;
    }
    public String getBankCardNo() {
        return bankCardNo;
    }
    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }
    public String getCertType() {
        return certType;
    }
    public void setCertType(String certType) {
        this.certType = certType;
    }
    public String getCertId() {
        return certId;
    }
    public void setCertId(String certId) {
        this.certId = certId;
    }
    public String getCertName() {
        return certName;
    }
    public void setCertName(String certName) {
        this.certName = certName;
    }
}
