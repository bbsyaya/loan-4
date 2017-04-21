/**
 * 
 */
package com.hrbb.loan.pos.util;

import java.math.BigDecimal;

/**
 * <p>Title: FinanceUtil.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年7月30日
 *
 * logs: 1. 
 */
public class FinanceUtil {
	/**
	 * 等额本息算法 average capital plus interest
	 * 
	 * @param dblThistCapi
	 * @param intRetuTerm
	 * @param termRate
	 * @return
	 */
	public static BigDecimal getSchedACPIAmount(BigDecimal dblThistCapi, int intRetuTerm, BigDecimal termRate){
        if (termRate.compareTo(BigDecimal.ZERO) == 0) { // 利率为0，则分期还款额按照等额本息处理
            return CalculateAmt_DEBJ(dblThistCapi, intRetuTerm, BigDecimal.ZERO);
        }
        BigDecimal Y = dblThistCapi;
        BigDecimal i = MathUtils.div(MathUtils.div(termRate,new BigDecimal("100")),new BigDecimal("12"));	//月利率=年利率/100/12
        int n = intRetuTerm;
        BigDecimal a = i.add(BigDecimal.ONE);
        BigDecimal b = PowerCal(a, n);

        BigDecimal Amt = Y.multiply(i).multiply(b).divide(b.subtract(BigDecimal.ONE),2,BigDecimal.ROUND_HALF_UP);	//Y * i * b / (b - 1);
        return Amt;

	}
	
	private static BigDecimal PowerCal(BigDecimal base, int exp) {
		BigDecimal result = BigDecimal.ONE;
	    long i;

	    for (i = 1; i <= exp; i++) {
	    	result = result.multiply(base);	//result *= base;

	    }
	    return result;
	}
	
	private static BigDecimal CalculateAmt_DEBJ(BigDecimal dblThistCapi, int intRetuTerm, BigDecimal termRate){
		BigDecimal Y = dblThistCapi;
        long n = intRetuTerm;
        // double i = termRate;

        /*
         * 第 k 期的还款额 cal_results_p->cur_payment = Y / n + (1 - (k - (double)1) /
         * n) Y * i;
         */

        // 取还本额
        BigDecimal Amt = Y.divide(BigDecimal.valueOf(n));	//Y / n;

        return Amt;
    }
//
//	
//	public static final void main(String[] args){
//		System.out.println(getSchedACPIAmount(new BigDecimal("100.34"),3, new BigDecimal("19.4")));
//	}


}



