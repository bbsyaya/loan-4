/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * 
 * @author XLY
 * @version $Id: MathUtils.java, v 0.1 2015-3-10 下午2:47:36 XLY Exp $
 */
public class MathUtils {
	public static MathContext MC = new MathContext(6, RoundingMode.HALF_UP);
	public static java.text.DecimalFormat DF = new java.text.DecimalFormat(
			"#.000000");

	/**
	 * 
	 * 
	 * @param b1
	 * @param b2
	 * @param def
	 * @param mc
	 * @return
	 */
	public static BigDecimal div(BigDecimal b1, BigDecimal b2) {
		return div(b1, b2, BigDecimal.ZERO, MC);
	}

	/**
	 * 
	 * 
	 * @param b1
	 * @param b2
	 * @param def
	 * @param mc
	 * @return
	 */
	public static BigDecimal div(BigDecimal b1, BigDecimal b2,
			BigDecimal defb2EqZero, MathContext mc) {
		if (null == b2 || BigDecimal.ZERO.equals(b2))
			return BigDecimal.ZERO;
		if (null == mc)
			return format1(b1.divide(b2, MC));
		return format1(b1.divide(b2, mc));
	}

	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static BigDecimal divInt(Integer v1, Integer v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(v1.toString());
		BigDecimal b2 = new BigDecimal(v2.toString());
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 
	 * 
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static BigDecimal getMax(BigDecimal b1, BigDecimal b2) {
		if (null != b1 && null != b2)
			return b1.compareTo(b2) > 0 ? b1 : b2;
		if (null == b1 && null != b2)
			return b2;
		if (null == b2 && null != b1)
			return b1;
		return BigDecimal.ZERO;
	}

	/**
	 * 
	 * 
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static BigDecimal getMin(BigDecimal b1, BigDecimal b2) {
		if (null != b1 && null != b2)
			return b1.compareTo(b2) < 0 ? b1 : b2;
		if (null == b1 && null != b2)
			return b2;
		if (null == b2 && null != b1)
			return b1;
		return BigDecimal.ZERO;
	}

	/**
	 * 
	 * 
	 * @param b1
	 * @param interval
	 * @return
	 */
	public static BigDecimal round(BigDecimal b1, BigDecimal interval) {
		BigDecimal tmp = b1.remainder(interval);
		if (tmp.compareTo(interval.divide(new BigDecimal(2))) <= 0) {
			return b1.subtract(tmp);
		} else {
			return b1.subtract(tmp).add(interval);
		}
	}

	/**
	 * 
	 * 
	 * @param b
	 * @return
	 */
	public static BigDecimal format1(BigDecimal b) {
		return new BigDecimal(DF.format(b));
	}

	/**
	 * 
	 * 
	 * @param b1
	 * @param b2
	 * @param b3
	 * @return
	 */
	// public static BigDecimal getMin(BigDecimal b1,BigDecimal b2,BigDecimal
	// b3){
	// BigDecimal tmp = b1.compareTo(b2)<0?b1:b2;
	// return getMin(tmp,b3);
	// }

	/**
	 * 
	 * 
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static Integer getMax(Integer b1, Integer b2) {
		if (null != b1 && null != b2)
			return b1.compareTo(b2) > 0 ? b1 : b2;
		if (null == b1 && null != b2)
			return b2;
		if (null == b2 && null != b1)
			return b1;
		return 0;
	}
	
	/**
	 * 数组个数
	 * @param inputData
	 * @return
	 */
	public static int getCount(double[] inputData) {
		if (inputData == null)
			return -1;

		return inputData.length;
	}

	/**
	 * 数组求和
	 * @param inputData
	 * @return
	 */
	public static double getSum(double[] inputData) {
		if (inputData == null || inputData.length == 0)
			return -1;
		int len = inputData.length;
		double sum = 0;
		for (int i = 0; i < len; i++) {
			sum = sum + inputData[i];
		}

		return sum;

	}
	
	/**
	 * 数组均值
	 * @param inputData
	 * @return
	 */
	public static double getAverage(double[] inputData) {
		if (inputData == null || inputData.length == 0)
			return -1;
		int len = inputData.length;
		double result;
		result = getSum(inputData) / len;

		return result;
	}

	/**
	 * 数组平方和
	 * @param inputData
	 * @return
	 */
	public static double getSquareSum(double[] inputData) {
		if (inputData == null || inputData.length == 0)
			return -1;
		int len = inputData.length;
		double sqrsum = 0.0;
		for (int i = 0; i < len; i++) {
			sqrsum += inputData[i] * inputData[i];
		}

		return sqrsum;
	}

	/**
	 * 数组的样本方差  (∑(xi-u)2)/(N-1)
	 * @param inputData
	 * @return
	 */
	public static double getVariance(double[] inputData) {
		int count = getCount(inputData);
		double average = getAverage(inputData);
		
		//等值简化算法
		double sqrsum = getSquareSum(inputData);
		double result = (sqrsum - count * average * average) / (count-1);
		
//		//公式算法
//		double[] avgDiv = new double[inputData.length];
//		for(int i=0; i<avgDiv.length; i++){
//			avgDiv[i] = inputData[i] - average;		//样本与均值差
//		}
//		double sqrsum = getSquareSum(avgDiv);
//		double result = sqrsum / (count-1);

		return result;
	}

	/**
	 * 数组标准差
	 * @param inputData
	 * @return
	 */
	public static double getStandardDiviation(double[] inputData) {
		double result;
		// 绝对值化很重要
		result = Math.sqrt(Math.abs(getVariance(inputData)));

		return result;

	}
	
	/**
	 * 计算波动率=STD(月交易金额)/金额汇总 *次数汇总
	 * @param inputData
	 * @return
	 */
	public static double getVolability(double[] inputData) {
		double totalSum = getSum(inputData);
		if(totalSum==0) return 0;
		
		return getStandardDiviation(inputData) / totalSum * getCount(inputData);
	}
	

	public static void main(String... strings) {
//		System.out.println(round(new BigDecimal(10), new BigDecimal(5)));
//		System.out.println(div(new BigDecimal(100000), new BigDecimal(3)));
		double [] testData=new double[]{95,85,75,65,55,45};
		System.out.println("标准差："+getStandardDiviation(testData));		//标准差：18.71
		double [] testData1=new double[]{73,72,71,69,68,67};
		System.out.println("标准差："+getStandardDiviation(testData1));	//标准差：2.37
	}
}
