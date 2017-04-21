package com.hrbb.loan.pos.biz.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * 
 * @author XLY
 * @version $Id: LoanRiskCheckRes.java, v 0.1 2015-3-9 下午4:27:12 XLY Exp $
 */
public class LoanRiskCheckRes implements Serializable{

    /**  */
    private static final long serialVersionUID = -3878255257406036570L;
    /**
     *  渠道 文本框 系统自动显示  字符  是   
     */
    private String channel;
    /**
                地区  文本框 系统自动显示  字符  是   
     * 
     */
    private String region;
    /**
        商户名称    文本框 系统自动显示  字符  是        */
    private String merchantName;
    /**
    姓名  文本框 系统自动显示  字符  是   
     * 
     */
    private String customerName;
    /***
     * 
    申请手机    文本框 系统自动显示  字符  是   
     */
    private String customerMobile;
    /**
    申请人身份证号 文本框 系统自动显示  字符  是   
     * 
     */
    private String customerCertNo;
    /**
    模型授信决定  文本框 suggest_decision    字符  是   
     * 
     */
    private String suggestDecision;
    /**
    模型授信额度（万）   文本框 final_model_cl  金额  是   
     * 
     */
    private BigDecimal finalModelCl;
    /**
     * 
    模型利率（%） 文本框 final_model_p   比例  是   
     */
    private String finalModelP;
    /**
     * 
    拒绝原因    文本框 decline_reason  字符      
     */
    private String declineReason;
    /**
    是否需要尽调  文本框 suggest_diligence   字符  是   
     * 
     */
    private String suggestDiligence;
    /**
    风险等级    文本框 risk_tier   字符  是   
     * 
     */
    private String riskTier;
    /**
    征信手机    文本框 系统自动显示  字符  是   
     * 
     */
    private String creditMobile;
    /**
    征信手机与申请人手机是否一致  文本框 系统自动显示  字符  是   
    0=一致，1=不一致
     * 
     */
    private String mobileMapFlag;
    /**
     * 
    人行最高信用额度    文本框 Model_Index-18申请人最高历史信用记录   金额  是   
     */
    private BigDecimal lineOfCreditFromPBC;
    /**
     * 
    年负债（万）  文本框 Model_Index-16申请人短期负债/10000 金额  是   
     */
    private BigDecimal yearsOfDebt;
    /**
     * 
    年负债/年营业收入   文本框 Model_Index-33申请人短期资产负债率    比例  是   
     */
    private String yearsOfDebtDivideIncome;
    /**
    月负债（万）  文本框 Model_Index-17申请人月负债/10000  金额  是   
     * 
     */
    private BigDecimal monthOfDebt;
    /**
     * 
    月负债/月营业收入   文本框 Model_Index-34申请人平均资产负债率    比例  是   
     */
    private BigDecimal monthOfDebtDivideIncome;
    /**
     * 
    未结清贷款余额（万）  文本框 CR.未结清贷款余额/10000    金额  是   
     */
    private BigDecimal outstandingLoanBalance;

    /**
     * 
    未销户信用卡总授信额度（万）  文本框 CR.未销户贷记卡授信总额/10000 金额  是   
     */
    private BigDecimal uncanelCeditCardAmt;
    /**
    信用卡已用额度（万）  文本框 CR.未销户贷记卡已用额度/10000 金额  是   
     * 
     */
    private BigDecimal ceditCardUsedAmt;
    /**
     * 
    信用卡额度使用率    文本框 Model_Index-14申请人贷记卡使用率 比例  是   
     */
    private BigDecimal ceditCardUtilRate;
    /**
     * 
    月平均POS金额（万） 文本框 Model_Index-26平均月交易金额/10000 金额  是   
     */
    private BigDecimal monthPosAmt;
    /**
     * 
    POS金额月波动率   文本框 Model_Index-28交易波动率 比例  是   
     */
    private String monthPosAmtFluRatio;

    /**
     * 
    总POS交易月份数   文本框 Model_Index-25商户总POS使用月份数   比例  是   
     */
    private BigDecimal posTransMonthNum;
    /**
    最近的有POS交易记录的月份  文本框 Model_Index-30最近的POS年月  数字  是   
     * 
     */
    private String posTransLastMonth;
    /**
     * 
    营业时间内的POS交易占比   文本框 Model_Index-31正常经营时间交易比率    比例  是   
     */
    private String posRatioOfAllTrans;
    /**
     * 
    申请人人行工作单位1  文本框 CR.工作单位(最近） 字符  是   
     */
    private String customerWorkCompany1;
    /**
     * 
    申请人人行工作单位2  文本框 CR.工作单位（次近） 字符  是   
     */
    private String customerWorkCompany2;
    /**
     * 
    申请人人行工作单位3  文本框 CR.工作单位（次次近）    字符  是   
     */
    private String customerWorkCompany3;
    /**
    配偶人行工作单位1   文本框 配偶.CR.工作单位(最近）  字符      
     * 
     */
    private String metaWorkCompany1;
    /**
     * 
    配偶人行工作单位2   文本框 配偶.CR.工作单位（次近）  字符      
     */
    private String metaWorkCompany2;
    /**
     * 
    配偶人行工作单位3   文本框 配偶.CR.工作单位（次次近） 字符      
     */
    private String metaWorkCompany3;
    /**
     * 
    配偶  文本框 系统自动显示  字符      
     */
    private String metaName;
    /**
     * 
    配偶身份证号  文本框 系统自动显示  字符      
     */
    private String metaCertNo;
    /**
     * 
    配偶贷款未结清额度（万）    文本框 配偶.CR.未结清贷款余额/10000 金额      
     */
    private BigDecimal metaAmtOfLoansOutstand;
    /**
     * 
    配偶信用卡总授信额度（万）   文本框 配偶.CR.未销户贷记卡授信总额/10000  金额      
     */
    private BigDecimal metaAmtOfCredit;
    /**
     * 
    配偶信用卡已使用额度（万）   文本框 配偶.CR.未销户贷记卡已用额度/10000  金额      
     */
    private BigDecimal metaAmtOfUsedCreditAmt;
    /**
     * 
    配偶信用卡额度使用率  文本框 Model_Index-47配偶贷记卡额度使用率    比例      
     */
    private String metaCeditCardUsedAmt;
    /**
     * 
    身份证归属地  文本框      字符  是   
     */
    private String metaCertAddress;
    /**
属相  文本框 系统自动计算  字符  是   
     */
    private String zodiac;
    /**
     * Getter method for property <tt>channel</tt>.
     * 
     * @return property value of channel
     */
    public String getChannel() {
        return channel;
    }
    /**
     * Setter method for property <tt>channel</tt>.
     * 
     * @param channel value to be assigned to property channel
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }
    /**
     * Getter method for property <tt>region</tt>.
     * 
     * @return property value of region
     */
    public String getRegion() {
        return region;
    }
    /**
     * Setter method for property <tt>region</tt>.
     * 
     * @param region value to be assigned to property region
     */
    public void setRegion(String region) {
        this.region = region;
    }
    /**
     * Getter method for property <tt>merchantName</tt>.
     * 
     * @return property value of merchantName
     */
    public String getMerchantName() {
        return merchantName;
    }
    /**
     * Setter method for property <tt>merchantName</tt>.
     * 
     * @param merchantName value to be assigned to property merchantName
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
    /**
     * Getter method for property <tt>customerName</tt>.
     * 
     * @return property value of customerName
     */
    public String getCustomerName() {
        return customerName;
    }
    /**
     * Setter method for property <tt>customerName</tt>.
     * 
     * @param customerName value to be assigned to property customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    /**
     * Getter method for property <tt>customerMobile</tt>.
     * 
     * @return property value of customerMobile
     */
    public String getCustomerMobile() {
        return customerMobile;
    }
    /**
     * Setter method for property <tt>customerMobile</tt>.
     * 
     * @param customerMobile value to be assigned to property customerMobile
     */
    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }
    /**
     * Getter method for property <tt>customerCertNo</tt>.
     * 
     * @return property value of customerCertNo
     */
    public String getCustomerCertNo() {
        return customerCertNo;
    }
    /**
     * Setter method for property <tt>customerCertNo</tt>.
     * 
     * @param customerCertNo value to be assigned to property customerCertNo
     */
    public void setCustomerCertNo(String customerCertNo) {
        this.customerCertNo = customerCertNo;
    }
    /**
     * Getter method for property <tt>suggestDecision</tt>.
     * 
     * @return property value of suggestDecision
     */
    public String getSuggestDecision() {
        return suggestDecision;
    }
    /**
     * Setter method for property <tt>suggestDecision</tt>.
     * 
     * @param suggestDecision value to be assigned to property suggestDecision
     */
    public void setSuggestDecision(String suggestDecision) {
        this.suggestDecision = suggestDecision;
    }
    /**
     * Getter method for property <tt>finalModelCl</tt>.
     * 
     * @return property value of finalModelCl
     */
    public BigDecimal getFinalModelCl() {
        return finalModelCl;
    }
    /**
     * Setter method for property <tt>finalModelCl</tt>.
     * 
     * @param finalModelCl value to be assigned to property finalModelCl
     */
    public void setFinalModelCl(BigDecimal finalModelCl) {
        this.finalModelCl = finalModelCl;
    }
    /**
     * Getter method for property <tt>finalModelP</tt>.
     * 
     * @return property value of finalModelP
     */
    public String getFinalModelP() {
        return finalModelP;
    }
    /**
     * Setter method for property <tt>finalModelP</tt>.
     * 
     * @param finalModelP value to be assigned to property finalModelP
     */
    public void setFinalModelP(String finalModelP) {
        this.finalModelP = finalModelP;
    }
    /**
     * Getter method for property <tt>declineReason</tt>.
     * 
     * @return property value of declineReason
     */
    public String getDeclineReason() {
        return declineReason;
    }
    /**
     * Setter method for property <tt>declineReason</tt>.
     * 
     * @param declineReason value to be assigned to property declineReason
     */
    public void setDeclineReason(String declineReason) {
        this.declineReason = declineReason;
    }
    /**
     * Getter method for property <tt>suggestDiligence</tt>.
     * 
     * @return property value of suggestDiligence
     */
    public String getSuggestDiligence() {
        return suggestDiligence;
    }
    /**
     * Setter method for property <tt>suggestDiligence</tt>.
     * 
     * @param suggestDiligence value to be assigned to property suggestDiligence
     */
    public void setSuggestDiligence(String suggestDiligence) {
        this.suggestDiligence = suggestDiligence;
    }
    /**
     * Getter method for property <tt>riskTier</tt>.
     * 
     * @return property value of riskTier
     */
    public String getRiskTier() {
        return riskTier;
    }
    /**
     * Setter method for property <tt>riskTier</tt>.
     * 
     * @param riskTier value to be assigned to property riskTier
     */
    public void setRiskTier(String riskTier) {
        this.riskTier = riskTier;
    }
    /**
     * Getter method for property <tt>creditMobile</tt>.
     * 
     * @return property value of creditMobile
     */
    public String getCreditMobile() {
        return creditMobile;
    }
    /**
     * Setter method for property <tt>creditMobile</tt>.
     * 
     * @param creditMobile value to be assigned to property creditMobile
     */
    public void setCreditMobile(String creditMobile) {
        this.creditMobile = creditMobile;
    }
    /**
     * Getter method for property <tt>mobileMapFlag</tt>.
     * 
     * @return property value of mobileMapFlag
     */
    public String getMobileMapFlag() {
        return mobileMapFlag;
    }
    /**
     * Setter method for property <tt>mobileMapFlag</tt>.
     * 
     * @param mobileMapFlag value to be assigned to property mobileMapFlag
     */
    public void setMobileMapFlag(String mobileMapFlag) {
        this.mobileMapFlag = mobileMapFlag;
    }
    /**
     * Getter method for property <tt>lineOfCreditFromPBC</tt>.
     * 
     * @return property value of lineOfCreditFromPBC
     */
    public BigDecimal getLineOfCreditFromPBC() {
        return lineOfCreditFromPBC;
    }
    /**
     * Setter method for property <tt>lineOfCreditFromPBC</tt>.
     * 
     * @param lineOfCreditFromPBC value to be assigned to property lineOfCreditFromPBC
     */
    public void setLineOfCreditFromPBC(BigDecimal lineOfCreditFromPBC) {
        this.lineOfCreditFromPBC = lineOfCreditFromPBC;
    }
    /**
     * Getter method for property <tt>yearsOfDebt</tt>.
     * 
     * @return property value of yearsOfDebt
     */
    public BigDecimal getYearsOfDebt() {
        return yearsOfDebt;
    }
    /**
     * Setter method for property <tt>yearsOfDebt</tt>.
     * 
     * @param yearsOfDebt value to be assigned to property yearsOfDebt
     */
    public void setYearsOfDebt(BigDecimal yearsOfDebt) {
        this.yearsOfDebt = yearsOfDebt;
    }
    /**
     * Getter method for property <tt>yearsOfDebtDivideIncome</tt>.
     * 
     * @return property value of yearsOfDebtDivideIncome
     */
    public String getYearsOfDebtDivideIncome() {
        return yearsOfDebtDivideIncome;
    }
    /**
     * Setter method for property <tt>yearsOfDebtDivideIncome</tt>.
     * 
     * @param yearsOfDebtDivideIncome value to be assigned to property yearsOfDebtDivideIncome
     */
    public void setYearsOfDebtDivideIncome(String yearsOfDebtDivideIncome) {
        this.yearsOfDebtDivideIncome = yearsOfDebtDivideIncome;
    }
    /**
     * Getter method for property <tt>monthOfDebt</tt>.
     * 
     * @return property value of monthOfDebt
     */
    public BigDecimal getMonthOfDebt() {
        return monthOfDebt;
    }
    /**
     * Setter method for property <tt>monthOfDebt</tt>.
     * 
     * @param monthOfDebt value to be assigned to property monthOfDebt
     */
    public void setMonthOfDebt(BigDecimal monthOfDebt) {
        this.monthOfDebt = monthOfDebt;
    }
    /**
     * Getter method for property <tt>monthOfDebtDivideIncome</tt>.
     * 
     * @return property value of monthOfDebtDivideIncome
     */
    public BigDecimal getMonthOfDebtDivideIncome() {
        return monthOfDebtDivideIncome;
    }
    /**
     * Setter method for property <tt>monthOfDebtDivideIncome</tt>.
     * 
     * @param monthOfDebtDivideIncome value to be assigned to property monthOfDebtDivideIncome
     */
    public void setMonthOfDebtDivideIncome(BigDecimal monthOfDebtDivideIncome) {
        this.monthOfDebtDivideIncome = monthOfDebtDivideIncome;
    }
    /**
     * Getter method for property <tt>outstandingLoanBalance</tt>.
     * 
     * @return property value of outstandingLoanBalance
     */
    public BigDecimal getOutstandingLoanBalance() {
        return outstandingLoanBalance;
    }
    /**
     * Setter method for property <tt>outstandingLoanBalance</tt>.
     * 
     * @param outstandingLoanBalance value to be assigned to property outstandingLoanBalance
     */
    public void setOutstandingLoanBalance(BigDecimal outstandingLoanBalance) {
        this.outstandingLoanBalance = outstandingLoanBalance;
    }
    /**
     * Getter method for property <tt>uncanelCeditCardAmt</tt>.
     * 
     * @return property value of uncanelCeditCardAmt
     */
    public BigDecimal getUncanelCeditCardAmt() {
        return uncanelCeditCardAmt;
    }
    /**
     * Setter method for property <tt>uncanelCeditCardAmt</tt>.
     * 
     * @param uncanelCeditCardAmt value to be assigned to property uncanelCeditCardAmt
     */
    public void setUncanelCeditCardAmt(BigDecimal uncanelCeditCardAmt) {
        this.uncanelCeditCardAmt = uncanelCeditCardAmt;
    }
    /**
     * Getter method for property <tt>ceditCardUsedAmt</tt>.
     * 
     * @return property value of ceditCardUsedAmt
     */
    public BigDecimal getCeditCardUsedAmt() {
        return ceditCardUsedAmt;
    }
    /**
     * Setter method for property <tt>ceditCardUsedAmt</tt>.
     * 
     * @param ceditCardUsedAmt value to be assigned to property ceditCardUsedAmt
     */
    public void setCeditCardUsedAmt(BigDecimal ceditCardUsedAmt) {
        this.ceditCardUsedAmt = ceditCardUsedAmt;
    }
    /**
     * Getter method for property <tt>ceditCardUtilRate</tt>.
     * 
     * @return property value of ceditCardUtilRate
     */
    public BigDecimal getCeditCardUtilRate() {
        return ceditCardUtilRate;
    }
    /**
     * Setter method for property <tt>ceditCardUtilRate</tt>.
     * 
     * @param ceditCardUtilRate value to be assigned to property ceditCardUtilRate
     */
    public void setCeditCardUtilRate(BigDecimal ceditCardUtilRate) {
        this.ceditCardUtilRate = ceditCardUtilRate;
    }
    /**
     * Getter method for property <tt>monthPosAmt</tt>.
     * 
     * @return property value of monthPosAmt
     */
    public BigDecimal getMonthPosAmt() {
        return monthPosAmt;
    }
    /**
     * Setter method for property <tt>monthPosAmt</tt>.
     * 
     * @param monthPosAmt value to be assigned to property monthPosAmt
     */
    public void setMonthPosAmt(BigDecimal monthPosAmt) {
        this.monthPosAmt = monthPosAmt;
    }
    /**
     * Getter method for property <tt>monthPosAmtFluRatio</tt>.
     * 
     * @return property value of monthPosAmtFluRatio
     */
    public String getMonthPosAmtFluRatio() {
        return monthPosAmtFluRatio;
    }
    /**
     * Setter method for property <tt>monthPosAmtFluRatio</tt>.
     * 
     * @param monthPosAmtFluRatio value to be assigned to property monthPosAmtFluRatio
     */
    public void setMonthPosAmtFluRatio(String monthPosAmtFluRatio) {
        this.monthPosAmtFluRatio = monthPosAmtFluRatio;
    }
    /**
     * Getter method for property <tt>posTransMonthNum</tt>.
     * 
     * @return property value of posTransMonthNum
     */
    public BigDecimal getPosTransMonthNum() {
        return posTransMonthNum;
    }
    /**
     * Setter method for property <tt>posTransMonthNum</tt>.
     * 
     * @param posTransMonthNum value to be assigned to property posTransMonthNum
     */
    public void setPosTransMonthNum(BigDecimal posTransMonthNum) {
        this.posTransMonthNum = posTransMonthNum;
    }
    /**
     * Getter method for property <tt>posTransLastMonth</tt>.
     * 
     * @return property value of posTransLastMonth
     */
    public String getPosTransLastMonth() {
        return posTransLastMonth;
    }
    /**
     * Setter method for property <tt>posTransLastMonth</tt>.
     * 
     * @param posTransLastMonth value to be assigned to property posTransLastMonth
     */
    public void setPosTransLastMonth(String posTransLastMonth) {
        this.posTransLastMonth = posTransLastMonth;
    }
    /**
     * Getter method for property <tt>posRatioOfAllTrans</tt>.
     * 
     * @return property value of posRatioOfAllTrans
     */
    public String getPosRatioOfAllTrans() {
        return posRatioOfAllTrans;
    }
    /**
     * Setter method for property <tt>posRatioOfAllTrans</tt>.
     * 
     * @param posRatioOfAllTrans value to be assigned to property posRatioOfAllTrans
     */
    public void setPosRatioOfAllTrans(String posRatioOfAllTrans) {
        this.posRatioOfAllTrans = posRatioOfAllTrans;
    }
    /**
     * Getter method for property <tt>customerWorkCompany1</tt>.
     * 
     * @return property value of customerWorkCompany1
     */
    public String getCustomerWorkCompany1() {
        return customerWorkCompany1;
    }
    /**
     * Setter method for property <tt>customerWorkCompany1</tt>.
     * 
     * @param customerWorkCompany1 value to be assigned to property customerWorkCompany1
     */
    public void setCustomerWorkCompany1(String customerWorkCompany1) {
        this.customerWorkCompany1 = customerWorkCompany1;
    }
    /**
     * Getter method for property <tt>customerWorkCompany2</tt>.
     * 
     * @return property value of customerWorkCompany2
     */
    public String getCustomerWorkCompany2() {
        return customerWorkCompany2;
    }
    /**
     * Setter method for property <tt>customerWorkCompany2</tt>.
     * 
     * @param customerWorkCompany2 value to be assigned to property customerWorkCompany2
     */
    public void setCustomerWorkCompany2(String customerWorkCompany2) {
        this.customerWorkCompany2 = customerWorkCompany2;
    }
    /**
     * Getter method for property <tt>customerWorkCompany3</tt>.
     * 
     * @return property value of customerWorkCompany3
     */
    public String getCustomerWorkCompany3() {
        return customerWorkCompany3;
    }
    /**
     * Setter method for property <tt>customerWorkCompany3</tt>.
     * 
     * @param customerWorkCompany3 value to be assigned to property customerWorkCompany3
     */
    public void setCustomerWorkCompany3(String customerWorkCompany3) {
        this.customerWorkCompany3 = customerWorkCompany3;
    }
    /**
     * Getter method for property <tt>metaWorkCompany1</tt>.
     * 
     * @return property value of metaWorkCompany1
     */
    public String getMetaWorkCompany1() {
        return metaWorkCompany1;
    }
    /**
     * Setter method for property <tt>metaWorkCompany1</tt>.
     * 
     * @param metaWorkCompany1 value to be assigned to property metaWorkCompany1
     */
    public void setMetaWorkCompany1(String metaWorkCompany1) {
        this.metaWorkCompany1 = metaWorkCompany1;
    }
    /**
     * Getter method for property <tt>metaWorkCompany2</tt>.
     * 
     * @return property value of metaWorkCompany2
     */
    public String getMetaWorkCompany2() {
        return metaWorkCompany2;
    }
    /**
     * Setter method for property <tt>metaWorkCompany2</tt>.
     * 
     * @param metaWorkCompany2 value to be assigned to property metaWorkCompany2
     */
    public void setMetaWorkCompany2(String metaWorkCompany2) {
        this.metaWorkCompany2 = metaWorkCompany2;
    }
    /**
     * Getter method for property <tt>metaWorkCompany3</tt>.
     * 
     * @return property value of metaWorkCompany3
     */
    public String getMetaWorkCompany3() {
        return metaWorkCompany3;
    }
    /**
     * Setter method for property <tt>metaWorkCompany3</tt>.
     * 
     * @param metaWorkCompany3 value to be assigned to property metaWorkCompany3
     */
    public void setMetaWorkCompany3(String metaWorkCompany3) {
        this.metaWorkCompany3 = metaWorkCompany3;
    }
    /**
     * Getter method for property <tt>metaName</tt>.
     * 
     * @return property value of metaName
     */
    public String getMetaName() {
        return metaName;
    }
    /**
     * Setter method for property <tt>metaName</tt>.
     * 
     * @param metaName value to be assigned to property metaName
     */
    public void setMetaName(String metaName) {
        this.metaName = metaName;
    }
    /**
     * Getter method for property <tt>metaCertNo</tt>.
     * 
     * @return property value of metaCertNo
     */
    public String getMetaCertNo() {
        return metaCertNo;
    }
    /**
     * Setter method for property <tt>metaCertNo</tt>.
     * 
     * @param metaCertNo value to be assigned to property metaCertNo
     */
    public void setMetaCertNo(String metaCertNo) {
        this.metaCertNo = metaCertNo;
    }
    /**
     * Getter method for property <tt>metaAmtOfLoansOutstand</tt>.
     * 
     * @return property value of metaAmtOfLoansOutstand
     */
    public BigDecimal getMetaAmtOfLoansOutstand() {
        return metaAmtOfLoansOutstand;
    }
    /**
     * Setter method for property <tt>metaAmtOfLoansOutstand</tt>.
     * 
     * @param metaAmtOfLoansOutstand value to be assigned to property metaAmtOfLoansOutstand
     */
    public void setMetaAmtOfLoansOutstand(BigDecimal metaAmtOfLoansOutstand) {
        this.metaAmtOfLoansOutstand = metaAmtOfLoansOutstand;
    }
    /**
     * Getter method for property <tt>metaAmtOfCredit</tt>.
     * 
     * @return property value of metaAmtOfCredit
     */
    public BigDecimal getMetaAmtOfCredit() {
        return metaAmtOfCredit;
    }
    /**
     * Setter method for property <tt>metaAmtOfCredit</tt>.
     * 
     * @param metaAmtOfCredit value to be assigned to property metaAmtOfCredit
     */
    public void setMetaAmtOfCredit(BigDecimal metaAmtOfCredit) {
        this.metaAmtOfCredit = metaAmtOfCredit;
    }
    /**
     * Getter method for property <tt>metaAmtOfUsedCreditAmt</tt>.
     * 
     * @return property value of metaAmtOfUsedCreditAmt
     */
    public BigDecimal getMetaAmtOfUsedCreditAmt() {
        return metaAmtOfUsedCreditAmt;
    }
    /**
     * Setter method for property <tt>metaAmtOfUsedCreditAmt</tt>.
     * 
     * @param metaAmtOfUsedCreditAmt value to be assigned to property metaAmtOfUsedCreditAmt
     */
    public void setMetaAmtOfUsedCreditAmt(BigDecimal metaAmtOfUsedCreditAmt) {
        this.metaAmtOfUsedCreditAmt = metaAmtOfUsedCreditAmt;
    }
    /**
     * Getter method for property <tt>metaCeditCardUsedAmt</tt>.
     * 
     * @return property value of metaCeditCardUsedAmt
     */
    public String getMetaCeditCardUsedAmt() {
        return metaCeditCardUsedAmt;
    }
    /**
     * Setter method for property <tt>metaCeditCardUsedAmt</tt>.
     * 
     * @param metaCeditCardUsedAmt value to be assigned to property metaCeditCardUsedAmt
     */
    public void setMetaCeditCardUsedAmt(String metaCeditCardUsedAmt) {
        this.metaCeditCardUsedAmt = metaCeditCardUsedAmt;
    }
    /**
     * Getter method for property <tt>metaCertAddress</tt>.
     * 
     * @return property value of metaCertAddress
     */
    public String getMetaCertAddress() {
        return metaCertAddress;
    }
    /**
     * Setter method for property <tt>metaCertAddress</tt>.
     * 
     * @param metaCertAddress value to be assigned to property metaCertAddress
     */
    public void setMetaCertAddress(String metaCertAddress) {
        this.metaCertAddress = metaCertAddress;
    }
    /**
     * Getter method for property <tt>zodiac</tt>.
     * 
     * @return property value of zodiac
     */
    public String getZodiac() {
        return zodiac;
    }
    /**
     * Setter method for property <tt>zodiac</tt>.
     * 
     * @param zodiac value to be assigned to property zodiac
     */
    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }
    
    
}
