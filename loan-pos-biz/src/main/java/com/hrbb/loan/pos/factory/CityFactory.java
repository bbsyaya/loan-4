/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.factory;

import java.util.ArrayList;
import java.util.List;

import com.hrbb.loan.pos.util.StringUtil;

/**
 * 
 * @author marco
 * @version $Id: FirsttierCity.java, v 0.1 2015-7-15 下午2:51:22 marco Exp $
 */
public class CityFactory {
	// 一线城市
	private static List<String> cityList_Firsttier_0 = new ArrayList<String>();

	// 弱一线城市
	private static List<String> cityList_Firsttier_1 = new ArrayList<String>();

	// 省会城市
	private static List<String> cityList_Capital = new ArrayList<String>();

	static {
		// 一线城市
		cityList_Firsttier_0.add("1101");// 北京市
		cityList_Firsttier_0.add("3101");// 上海市
		cityList_Firsttier_0.add("4401");// 广州市
		cityList_Firsttier_0.add("4403");// 深圳市
		// 弱一线城市
		cityList_Firsttier_1.add("1201");// 天津市
		cityList_Firsttier_1.add("2101");// 沈阳市
		cityList_Firsttier_1.add("2102");// 大连市
		cityList_Firsttier_1.add("3201");// 南京市
		cityList_Firsttier_1.add("3202");// 无锡市
		cityList_Firsttier_1.add("3205");// 苏州市
		cityList_Firsttier_1.add("3301");// 杭州市
		cityList_Firsttier_1.add("3302");// 宁波市
		cityList_Firsttier_1.add("3501");// 福州市
		cityList_Firsttier_1.add("3502");// 厦门市
		cityList_Firsttier_1.add("3701");// 济南市
		cityList_Firsttier_1.add("3702");// 青岛市
		cityList_Firsttier_1.add("4201");// 武汉市
		cityList_Firsttier_1.add("4301");// 长沙市
		cityList_Firsttier_1.add("5001");// 重庆市
		cityList_Firsttier_1.add("5101");// 成都市
		cityList_Firsttier_1.add("6101");// 西安市

		// 省会城市
		cityList_Capital.add("1201");// 天津市
		cityList_Capital.add("2101");// 沈阳市
		// cityList_Capital.add("2102");// 大连市
		cityList_Capital.add("3201");// 南京市
		// cityList_Capital.add("3202");// 无锡市
		// cityList_Capital.add("3205");// 苏州市
		cityList_Capital.add("3301");// 杭州市
		// cityList_Capital.add("3302");// 宁波市
		cityList_Capital.add("3501");// 福州市
		// cityList_Capital.add("3502");// 厦门市
		cityList_Capital.add("3701");// 济南市
		// cityList_Capital.add("3702");// 青岛市
		cityList_Capital.add("4201");// 武汉市
		cityList_Capital.add("4301");// 长沙市
		cityList_Capital.add("5001");// 重庆市
		cityList_Capital.add("5101");// 成都市
		cityList_Capital.add("6101");// 西安市
		cityList_Capital.add("1301");// 石家庄市
		cityList_Capital.add("1401");// 太原市
		cityList_Capital.add("1501");// 呼和浩特市
		cityList_Capital.add("2201");// 长春市
		cityList_Capital.add("2301");// 哈尔滨市
		cityList_Capital.add("3303");// 温州市
		cityList_Capital.add("3401");// 合肥市
		cityList_Capital.add("3601");// 南昌市
		cityList_Capital.add("3703");// 淄博市
		cityList_Capital.add("3706");// 烟台市
		cityList_Capital.add("4101");// 郑州市
		cityList_Capital.add("4406");// 佛山市
		cityList_Capital.add("4419");// 东莞市
		cityList_Capital.add("4501");// 南宁市
		cityList_Capital.add("4601");// 海口市
		cityList_Capital.add("5201");// 贵阳市
		cityList_Capital.add("5301");// 昆明市
		cityList_Capital.add("5401");// 拉萨市
		cityList_Capital.add("6201");// 兰州市
		cityList_Capital.add("6301");// 西宁市
		cityList_Capital.add("6401");// 银川市
		cityList_Capital.add("6501");// 乌鲁木齐市
	}

	/**
	 * 根据地区编码，判断该地区在不在一线城市
	 * 
	 * @param cityCode
	 * @return
	 */
	public static boolean isFirsttierCity(String cityCode) {
		if (StringUtil.isEmpty(cityCode)) {
			return false;
		} else if (cityCode.length() != 6) {
			return false;
		} else {
			String cityCodeTemp = cityCode.substring(0, 4);
			if (cityList_Firsttier_0.lastIndexOf(cityCodeTemp) != -1) {
				return true;
			} else {
				if (cityList_Firsttier_1.lastIndexOf(cityCodeTemp) != -1) {
					return true;
				} else {
					return false;
				}
			}
		}
	}

	/**
	 * 省会
	 * 
	 * @param cityCode
	 * @return
	 */
	public static boolean isFirsttierCity4(String cityCode) {
		if (StringUtil.isEmpty(cityCode)) {
			return false;
		} else if (cityCode.length() != 6) {
			return false;
		} else {
			if (cityList_Firsttier_0.lastIndexOf(cityCode.substring(0, 4)) != -1) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * 省会
	 * 
	 * @param cityCode
	 * @return
	 */
	public static boolean isCapitalCity(String cityCode) {
		if (StringUtil.isEmpty(cityCode)) {
			return false;
		} else if (cityCode.length() != 6) {
			return false;
		} else {
			if (cityList_Capital.lastIndexOf(cityCode.substring(0, 4)) != -1) {
				return true;
			} else {
				return false;
			}
		}
	}
}
