<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.bankinfo_table_border{
	width:30%;
	float:left; 
	border-collapse:collapse;
	margin-left: 20px;
}
.bankinfo_table_border td{
	border: 1px solid;
	text-align: center;
	cellpadding:0px;
	cellspacing:0px;
}
.bankinfo_table_border caption{
    font-size: 25px;
    margin-bottom: 10px
}
.titleTr{
    background-color: silver;
    height:30px;
    font-size:16px
}
</style>

<div title="银行流水汇总" width="100%">
	<div width="100%" height="100%" float="right">
		<table title="condition" class="bankinfo_table_border">
			<caption>每月消费状况</caption>
			<tr class="titleTr">
				<td>消费月份</td>
				<td>消费总额</td>
				<td>消费总笔数</td>
			</tr>
			<c:forEach items="${consumeCondition}" var="condition">
				<tr>
					<td>${condition.year}-${condition.month}</td>
					<td>${condition.indexMonthConsumeAomut}</td>
					<td>${condition.indexMonthConsumeCount}</td>
				</tr>
			</c:forEach>
		</table>
		<table title="city" class="bankinfo_table_border">
			<caption>消费地域分布</caption>
			<tr class="titleTr">
				<td>消费城市</td>
				<td>消费总额</td>
				<td>消费总笔数</td>
			</tr>
			<c:forEach items="${consumeCity}" var="city">
				<tr>
					<td>${city.indexConsumeCityName}</td>
					<td>${city.indexConsumeAmount}</td>
					<td>${city.indexConsumeCount}</td>
				</tr>
			</c:forEach>
		</table>
		<table title="mcc" class="bankinfo_table_border">
			<caption>消费大类分布</caption>
			<tr class="titleTr">
				<td>行业类型</td>
				<td>消费总额</td>
				<td>消费总笔数</td>
			</tr>
			<c:forEach items="${consumeGategories}" var="mcc">
				<tr>
					<td>${mcc.indexConsumeName}</td>
					<td>${mcc.indexConsumeAmount}</td>
					<td>${mcc.indexConsumeCount}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>