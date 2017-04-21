package com.hrbb.loan.factory;

import org.apache.commons.lang.StringUtils;
import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.hrbb.loan.constants.CreditApplyConstants;

/**
 *<h1></h1>
 *@author Johnson Song
 *@version Id: CreditApplyFactory.java, v 1.0 2015-3-6 下午2:49:56 Johnson Song Exp
 */
public class CreditApplyFactory {
	
	//建材行业
	private static ImmutableList<String> consList = new ImmutableList.Builder<String>().add("木业").add("建材").add("瓷砖").add("陶瓷").add("弹簧").add("家具").add("楼梯").add("铝材").add("马赛克").add("水暖").add("卫浴").add("石材").add("灯具").add("装饰").add("木材").add("橱柜").add("厨柜").add("地板").add("五金").add("涂料").add("灯饰").add("厨具").add("橱具").add("厨俱").add("橱俱").add("家饰").add("布艺").add("窗帘").add("门业").add("洁具").add("家居").add("建筑材料").add("玻璃").add("红木").add("门窗").build();
	//服装行业
	private static ImmutableList<String> clothList = new ImmutableList.Builder<String>().add("服装").add("服饰").add("编织").add("男装").add("女装").add("童装").add("绣花").add("针织").add("皮草").add("鞋").add("纺织").add("针纺").build();
	//零售业
	private static ImmutableList<String> retailList = new ImmutableList.Builder<String>().add("日杂").add("副食").add("食品").add("烟酒").add("百货").add("日用品").add("便利").add("艺术").add("书店").add("眼镜").add("精品").add("母婴").add("妇幼").add("酒业").add("药房").add("床上用品").add("蛋糕").add("超市").add("购物").build();
	//制造业
	private static ImmutableList<String> prodList = new ImmutableList.Builder<String>().add("制造").add("机械").build();
	//外贸
	private static ImmutableList<String> forList = new ImmutableList.Builder<String>().add("商贸").add("贸易").add("进出口").build();
	//通信
	private static ImmutableList<String> infoList = new ImmutableList.Builder<String>().add("通信").add("电器").add("手机").add("电子").add("电脑").add("通讯").add("家电").add("数码").add("计算机").add("信息技术").build();
	//茶
	private static ImmutableList<String> teaList = new ImmutableList.Builder<String>().add("茶").build();
	//个体
	private static ImmutableList<String> persList = new ImmutableList.Builder<String>().add("个体").build();
	//汽车
	private static ImmutableList<String> carList = new ImmutableList.Builder<String>().add("汽车").add("摩托").add("汽修").add("轮胎").add("汽配").add("电动车").build();
	//医药
	private static ImmutableList<String> mediList = new ImmutableList.Builder<String>().add("药材").add("中药").add("西药").add("药业").build();
	//古董行业
	private static ImmutableList<String> antiList = new ImmutableList.Builder<String>().add("珠宝").add("玉器").add("古玩").add("古董").build();
	//建筑行业
	private static ImmutableList<String> induList = new ImmutableList.Builder<String>().add("装潢").add("装修").add("建筑工程").build();
	//工厂
	private static ImmutableList<String> facList = new ImmutableList.Builder<String>().add("工厂").add("加工厂").build();

	
	public static String getIndustryType(String posCustName){
		for(String str : consList){
			if(StringUtils.contains(posCustName, str)){
				return "01";
			}
		}
		
		for(String str : clothList){
			if(StringUtils.contains(posCustName, str)){
				return "02";
			}
		}
		
		for(String str : retailList){
			if(StringUtils.contains(posCustName, str)){
				return "03";
			}
		}
		
		for(String str : prodList){
			if(StringUtils.contains(posCustName, str)){
				return "04";
			}
		}
		
		for(String str : forList){
			if(StringUtils.contains(posCustName, str)){
				return "05";
			}
		}
		
		for(String str : infoList){
			if(StringUtils.contains(posCustName, str)){
				return "06";
			}
		}
		
		for(String str : teaList){
			if(StringUtils.contains(posCustName, str)){
				return "07";
			}
		}
		
		for(String str : persList){
			if(StringUtils.contains(posCustName, str)){
				return "08";
			}
		}
		
		for(String str : carList){
			if(StringUtils.contains(posCustName, str)){
				return "09";
			}
		}
		
		for(String str : mediList){
			if(StringUtils.contains(posCustName, str)){
				return "10";
			}
		}
		
		for(String str : antiList){
			if(StringUtils.contains(posCustName, str)){
				return "11";
			}
		}
		
		for(String str : induList){
			if(StringUtils.contains(posCustName, str)){
				return "12";
			}
		}
		
		for(String str : facList){
			if(StringUtils.contains(posCustName, str)){
				return "13";
			}
		}
		
		return "99";
	}
	
	public static String getStatus(String statusCode){
		switch (statusCode) {
		case CreditApplyConstants.STATUS_PENDING:
			
			return "待处理";
		
		case CreditApplyConstants.STATUS_ACCPT:
			
			return "受理";
			
		case "20":
			return "资料审核";
		
		case "21":
			return "资料审核补件";
			
		case "30":
			return "风险初审";
			
		case "31":
			return "风险复审";
		
		case "32":
			return "复审补件";
			
		case "40":
			return "尽调中";
		
		case "41":
			return "尽调审核";
			
		case "90":
			return "审批通过";
		
		case "91":
			return "直接拒绝";
		
		case "92":
			return "审批拒绝";
		
		case "93":
			return "主动撤销";
		default:
			return "未知";
		}
		
	}
	
	public static String getTermUnit(String unitCode){
		switch(unitCode){
			case "Y" :
				return "年";
			case "M" :
				return "月";
			case "D" :
				return "日";
			default : 
				return "";
		}
	}
}