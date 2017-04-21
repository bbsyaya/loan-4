<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 还款计划 -->
<div title="还款计划" style="padding: 20px; width:90%;">
	<table id="paybackPlanRecord" class="easyui-datagrid" rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="receiptid">借据编号</th>
				<th field="period">期次</th>
				<th field="scheddate" width="120" formatter="dateFormat" align="center">应还款日</th>
				<th field="schedprincipal" width="80" formatter="formatMoney" align="right">应还本金</th>
				<th field="schedinterest" width="100" formatter="formatMoney" align="right">应还利息</th>
				<th field="unpaidinterest" width="80" formatter="formatMoney" align="right">应还欠息</th>
				<th field="schedtotalamt" width="80" formatter="formatMoney" align="right">应还总金额</th>
				<th field="gracedays" width="80" formatter="dateFormat" align="center">宽限期</th>
				<th field="reducedinterest" width="100" formatter="formatMoney" align="right">应减免利息金额</th>
				<th field="owePrincipal" width="80" formatter="formatMoney" align="right">剩余未还本金</th>
				<th field="oweInterest" width="80" formatter="formatMoney" align="right">剩余未还利息</th>
				<th field="memo" align="center">备注说明</th>
				<th field="overFlag" formatter="fmtOverFlag" align="center">拖欠标识</th>
				<th field="payoffFlag" formatter="fmtPayoffFlag" align="center">本期贷款结清标识</th>
			</tr>
		</thead>
	</table>
</div>

