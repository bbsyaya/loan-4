<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript" src='<%=request.getContextPath()%>/js/common_uiext.js'></script>
<style>
.bankinfo_table_border{
	border: 1px solid;
	width:100%;
	border-collapse:collapse;
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

<div title="银行流水明细" width="100%">
	<div width="100%" height="100%">
		<table title="condition" class="bankinfo_table_border">
			<caption>消费明细</caption>
			<tr class="titleTr">
				<td>交易时间</td>
				<td>记账日期</td>
				<td>交易币种</td>
				<td>交易状态</td>
				<td>交易金额（收）</td>
				<td>交易金额（支）</td>
				<td>商户名称</td>
				<td>商户类型</td>
			</tr>
			<c:forEach items="${upsBillcardstatSerials}" var="upsBillcardstatSerial">
				<tr>
					<td><fmt:formatDate value='${upsBillcardstatSerial.transactionTime}' pattern='yyyy-MM-dd HH:mm:ss'/></td>
					<td><fmt:formatDate value='${upsBillcardstatSerial.chargeTime}' pattern='yyyy-MM-dd HH:mm:ss'/></td>
					<td>${upsBillcardstatSerial.transactionCurrency}</td>
					<td>${upsBillcardstatSerial.transactionStatus}</td>
					<td>${upsBillcardstatSerial.borrow}</td>
					<td>${upsBillcardstatSerial.lend}</td>
					<td>${upsBillcardstatSerial.mName}</td>
					<td>${upsBillcardstatSerial.mcc}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>