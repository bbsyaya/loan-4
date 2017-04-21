/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.expressions.bean;

import java.math.BigDecimal;

/**
 * 
 * @author XLY
 * @version $Id: ScoreBureau.java, v 0.1 2015-3-13 下午4:38:25 XLY Exp $
 */
public class ScoreBureauBean {
    /**
     * MIN(90, Model_Index-04首笔贷款发放距今月份数)/30
     */
    private BigDecimal sb1;
    /**
     * MIN(81, Model_Index-05首张信用卡发卡距今月份数)/27
     */
    private BigDecimal sb2;
    /**
     * MIN(2,CR.住房贷款笔数)
     */
    private BigDecimal sb3;
    /**
     * MIN(390000, CR.未销户贷记卡授信总额)/130000
     */
    private BigDecimal sb4;
    /**
     * SB5  MIN(300000, CR.已结清信用无担保贷款总金额)/100000
     */
    private BigDecimal sb5;
    /**
     * MIN(300000, CR.历史最高信用无担保贷款金额)/100000
     */
    private BigDecimal sb6;
    /**
     * (3-MIN(3, CR.贷记卡逾期最长逾期月数))
     */
    private BigDecimal sb7;
    /**
     * (3-MIN(3, CR.未结清贷款机构数))
     */
    private BigDecimal sb8;
    /**
     * (3-MIN(2400, CR.贷记卡逾期单月最高逾期总额)/800)
     */
    private BigDecimal sb9;
    /**
     * (3-MIN(15000, CR.贷款逾期单月最高逾期总额)/5000)
     */
    private BigDecimal sb10;
    /**
     * MIN(18, Model_Index-10信用卡最近逾期距今月份数)/6
     */
    private BigDecimal sb11;
    /**
     * MIN(12, Model_Index-11贷款最近逾期距今月份数)/4
     */
    private BigDecimal sb12;
    /**
     *(3-MIN(0.21, Model_Index-12贷记卡数逾期率)/0.07)
     */
    private BigDecimal sb13;
    /**
     *(3-MIN(0.15, Model_Index-13贷款数逾期率)/0.05)
     */
    private BigDecimal sb14;
    /**
     * (5-MIN(0.9, Model_Index-14贷记卡使用率)/0.18)
     */
    private BigDecimal sb15;
    /**
     * 3-MIN(9,CR.近6个月查询次数)/3
     */
    private BigDecimal sb16;
    /**
     * 3-MIN(0.75, Model_Index-15近6个月查询占比)/0.25
     */
    private BigDecimal sb17;

    /**
     * 总分
     */
    private BigDecimal scoreBureau;
    
    /**
     * Getter method for property <tt>scoreBureau</tt>.
     * 
     * @return property value of scoreBureau
     */
    public BigDecimal getScoreBureau() {
        return scoreBureau;
    }
    /**
     * Setter method for property <tt>scoreBureau</tt>.
     * 
     * @param scoreBureau value to be assigned to property scoreBureau
     */
    public void setScoreBureau(BigDecimal scoreBureau) {
        this.scoreBureau = scoreBureau;
    }
    /**
     * Getter method for property <tt>sb1</tt>.
     * 
     * @return property value of sb1
     */
    
    public BigDecimal getSb1() {
        return sb1;
    }
    /**
     * Setter method for property <tt>sb1</tt>.
     * 
     * @param sb1 value to be assigned to property sb1
     */
    public void setSb1(BigDecimal sb1) {
        this.sb1 = sb1;
    }
    /**
     * Getter method for property <tt>sb2</tt>.
     * 
     * @return property value of sb2
     */
    public BigDecimal getSb2() {
        return sb2;
    }
    /**
     * Setter method for property <tt>sb2</tt>.
     * 
     * @param sb2 value to be assigned to property sb2
     */
    public void setSb2(BigDecimal sb2) {
        this.sb2 = sb2;
    }
    /**
     * Getter method for property <tt>sb3</tt>.
     * 
     * @return property value of sb3
     */
    public BigDecimal getSb3() {
        return sb3;
    }
    /**
     * Setter method for property <tt>sb3</tt>.
     * 
     * @param sb3 value to be assigned to property sb3
     */
    public void setSb3(BigDecimal sb3) {
        this.sb3 = sb3;
    }
    /**
     * Getter method for property <tt>sb4</tt>.
     * 
     * @return property value of sb4
     */
    public BigDecimal getSb4() {
        return sb4;
    }
    /**
     * Setter method for property <tt>sb4</tt>.
     * 
     * @param sb4 value to be assigned to property sb4
     */
    public void setSb4(BigDecimal sb4) {
        this.sb4 = sb4;
    }
    /**
     * Getter method for property <tt>sb5</tt>.
     * 
     * @return property value of sb5
     */
    public BigDecimal getSb5() {
        return sb5;
    }
    /**
     * Setter method for property <tt>sb5</tt>.
     * 
     * @param sb5 value to be assigned to property sb5
     */
    public void setSb5(BigDecimal sb5) {
        this.sb5 = sb5;
    }
    /**
     * Getter method for property <tt>sb6</tt>.
     * 
     * @return property value of sb6
     */
    public BigDecimal getSb6() {
        return sb6;
    }
    /**
     * Setter method for property <tt>sb6</tt>.
     * 
     * @param sb6 value to be assigned to property sb6
     */
    public void setSb6(BigDecimal sb6) {
        this.sb6 = sb6;
    }
    /**
     * Getter method for property <tt>sb7</tt>.
     * 
     * @return property value of sb7
     */
    public BigDecimal getSb7() {
        return sb7;
    }
    /**
     * Setter method for property <tt>sb7</tt>.
     * 
     * @param sb7 value to be assigned to property sb7
     */
    public void setSb7(BigDecimal sb7) {
        this.sb7 = sb7;
    }
    /**
     * Getter method for property <tt>sb8</tt>.
     * 
     * @return property value of sb8
     */
    public BigDecimal getSb8() {
        return sb8;
    }
    /**
     * Setter method for property <tt>sb8</tt>.
     * 
     * @param sb8 value to be assigned to property sb8
     */
    public void setSb8(BigDecimal sb8) {
        this.sb8 = sb8;
    }
    /**
     * Getter method for property <tt>sb9</tt>.
     * 
     * @return property value of sb9
     */
    public BigDecimal getSb9() {
        return sb9;
    }
    /**
     * Setter method for property <tt>sb9</tt>.
     * 
     * @param sb9 value to be assigned to property sb9
     */
    public void setSb9(BigDecimal sb9) {
        this.sb9 = sb9;
    }
    /**
     * Getter method for property <tt>sb10</tt>.
     * 
     * @return property value of sb10
     */
    public BigDecimal getSb10() {
        return sb10;
    }
    /**
     * Setter method for property <tt>sb10</tt>.
     * 
     * @param sb10 value to be assigned to property sb10
     */
    public void setSb10(BigDecimal sb10) {
        this.sb10 = sb10;
    }
    /**
     * Getter method for property <tt>sb11</tt>.
     * 
     * @return property value of sb11
     */
    public BigDecimal getSb11() {
        return sb11;
    }
    /**
     * Setter method for property <tt>sb11</tt>.
     * 
     * @param sb11 value to be assigned to property sb11
     */
    public void setSb11(BigDecimal sb11) {
        this.sb11 = sb11;
    }
    /**
     * Getter method for property <tt>sb12</tt>.
     * 
     * @return property value of sb12
     */
    public BigDecimal getSb12() {
        return sb12;
    }
    /**
     * Setter method for property <tt>sb12</tt>.
     * 
     * @param sb12 value to be assigned to property sb12
     */
    public void setSb12(BigDecimal sb12) {
        this.sb12 = sb12;
    }
    /**
     * Getter method for property <tt>sb13</tt>.
     * 
     * @return property value of sb13
     */
    public BigDecimal getSb13() {
        return sb13;
    }
    /**
     * Setter method for property <tt>sb13</tt>.
     * 
     * @param sb13 value to be assigned to property sb13
     */
    public void setSb13(BigDecimal sb13) {
        this.sb13 = sb13;
    }
    /**
     * Getter method for property <tt>sb14</tt>.
     * 
     * @return property value of sb14
     */
    public BigDecimal getSb14() {
        return sb14;
    }
    /**
     * Setter method for property <tt>sb14</tt>.
     * 
     * @param sb14 value to be assigned to property sb14
     */
    public void setSb14(BigDecimal sb14) {
        this.sb14 = sb14;
    }
    /**
     * Getter method for property <tt>sb15</tt>.
     * 
     * @return property value of sb15
     */
    public BigDecimal getSb15() {
        return sb15;
    }
    /**
     * Setter method for property <tt>sb15</tt>.
     * 
     * @param sb15 value to be assigned to property sb15
     */
    public void setSb15(BigDecimal sb15) {
        this.sb15 = sb15;
    }
    /**
     * Getter method for property <tt>sb16</tt>.
     * 
     * @return property value of sb16
     */
    public BigDecimal getSb16() {
        return sb16;
    }
    /**
     * Setter method for property <tt>sb16</tt>.
     * 
     * @param sb16 value to be assigned to property sb16
     */
    public void setSb16(BigDecimal sb16) {
        this.sb16 = sb16;
    }
    /**
     * Getter method for property <tt>sb17</tt>.
     * 
     * @return property value of sb17
     */
    public BigDecimal getSb17() {
        return sb17;
    }
    /**
     * Setter method for property <tt>sb17</tt>.
     * 
     * @param sb17 value to be assigned to property sb17
     */
    public void setSb17(BigDecimal sb17) {
        this.sb17 = sb17;
    }
    
}
