<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div title="银行流水信息" width="100%">
	<c:if test="${applyDetail[0].applyStatus == '10'}">
		<div id="divBankInsert">
                <div>
					<span>请选择日期:</span> <span><select id="startMonth"
						name="startMonth">
							<c:forEach items="${overMonths}" var="obj">
								<option value="${obj.monthId}">${obj.month}</option>
							</c:forEach>
					</select></span> <span>到</span> <span> <select id="endMonth" name="endMonth">
							<c:forEach items="${overMonths}" var="obj">
								<option value="${obj.monthId}">${obj.month}</option>
							</c:forEach>
					</select>
					</span> <span><input type="button" value="确定"
						onclick="getOverMonths()" /></span>
					<span><input type="button" value="全部清空" onclick="bankMonthClear()"/></span>
				</div>
				<table>
					<tr align="center" id="thtitle">
						<th>流水月份</th>
						<th>银行名称</th>
						<th>银行账号</th>
						<th>流水出项</th>
						<th>流水入项</th>
						<th>当季度结息金额</th>
					</tr>
					<tr id="0" style="display:none;">
						<td><input type="text" id="currMonth0" class="easyui-validatebox"  data-options="required:true"/></td>
						<td><input id="bankName0" type="text" class="easyui-validatebox"  data-options="required:true"/></td>
						<td><input id="bankAccno0" type="text" class="easyui-validatebox" validType="account[8,20]" data-options="required:true"/></td><td><input
							id="currMonthIn0" type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td><td><input id="currMonthOut0"
							type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td><td><input id="currSeaInterestAmt0" type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td>
					</tr>
					<tr id="1" style="display:none;">
						<td><input type="text" id="currMonth1" class="easyui-validatebox" data-options="required:true"/></td>
						<td><input id="bankName1" type="text" class="easyui-validatebox" data-options="required:true"/></td>
						<td><input id="bankAccno1" type="text" class="easyui-validatebox" validType="account[8,20]" data-options="required:true"/><td><input
							id="currMonthIn1" type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td><td><input id="currMonthOut1"
							type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td><td><input id="currSeaInterestAmt1" type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td>
					</tr>
					<tr id="2" style="display:none;">
						<td><input type="text" id="currMonth2" class="easyui-validatebox"  data-options="required:true"/></td>
						<td><input id="bankName2" type="text" class="easyui-validatebox"  data-options="required:true"/></td>
						<td><input id="bankAccno2" type="text" class="easyui-validatebox" validType="account[8,20]" data-options="required:true"/></td><td><input
							id="currMonthIn2" type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td><td><input id="currMonthOut2"
							type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td><td><input id="currSeaInterestAmt2" type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td>
					</tr>
					<tr id="3" style="display:none;">
						<td><input type="text" id="currMonth3" class="easyui-validatebox"  data-options="required:true"/></td>
						<td><input id="bankName3" type="text" class="easyui-validatebox"  data-options="required:true"/></td>
						<td><input id="bankAccno3" type="text" class="easyui-validatebox" validType="account[8,20]" data-options="required:true"/></td><td><input
							id="currMonthIn3" type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td><td><input id="currMonthOut3"
							type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td><td><input id="currSeaInterestAmt3" type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td>
					</tr>
					<tr id="4" style="display:none;">
						<td><input type="text" id="currMonth4" class="easyui-validatebox"  data-options="required:true"/></td>
						<td><input id="bankName4" type="text" class="easyui-validatebox"  data-options="required:true"/></td>
						<td><input id="bankAccno4" type="text" class="easyui-validatebox" validType="account[8,20]" data-options="required:true"/></td><td><input
							id="currMonthIn4" type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td><td><input id="currMonthOut4"
							type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td><td><input id="currSeaInterestAmt4" type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td>
					</tr>
					<tr id="5" style="display:none;">
						<td><input type="text" id="currMonth5" class="easyui-validatebox"  data-options="required:true"/></td>
						<td><input id="bankName5" type="text" class="easyui-validatebox"  data-options="required:true"/></td>
						<td><input id="bankAccno5" type="text" class="easyui-validatebox" validType="account[8,20]" data-options="required:true"/></td><td><input
							id="currMonthIn5" type="text"class="easyui-validatebox" validType="amt" data-options="required:true"/></td><td><input id="currMonthOut5"
							type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td><td><input id="currSeaInterestAmt5" type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td>
					</tr>
					<tr id="6" style="display:none;">
						<td><input type="text" id="currMonth6" class="easyui-validatebox"  data-options="required:true"/></td>
						<td><input id="bankName6" type="text" class="easyui-validatebox"  data-options="required:true"/></td>
						<td><input id="bankAccno6" type="text" class="easyui-validatebox" validType="account[8,20]" data-options="required:true"/></td><td><input
							id="currMonthIn6" type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td><td><input id="currMonthOut6"
							type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td><td><input id="currSeaInterestAmt6" type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td>
					</tr>
					<tr id="7" style="display:none;">
						<td><input type="text" id="currMonth7" class="easyui-validatebox"  data-options="required:true"/></td>
						<td><input id="bankName7" type="text" class="easyui-validatebox" data-options="required:true"/></td>
						<td><input id="bankAccno7" type="text" class="easyui-validatebox" validType="account[8,20]" data-options="required:true"/></td><td><input
							id="currMonthIn7" type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td><td><input id="currMonthOut7"
							type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td><td><input id="currSeaInterestAmt7" type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td>
					</tr>
					<tr id="8" style="display:none;">
						<td><input type="text" id="currMonth8" class="easyui-validatebox"  data-options="required:true"/></td>
						<td><input id="bankName8" type="text" class="easyui-validatebox"  data-options="required:true"/></td>
						<td><input id="bankAccno8" type="text" class="easyui-validatebox" validType="account[8,20]" data-options="required:true"/></td><td><input
							id="currMonthIn8" type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td><td><input id="currMonthOut8"
							type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td><td><input id="currSeaInterestAmt8" type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td>
					</tr>
					<tr id="9" style="display:none;">
						<td><input type="text" id="currMonth9" class="easyui-validatebox"  data-options="required:true"/></td>
						<td><input id="bankName9" type="text" class="easyui-validatebox"  data-options="required:true"/></td>
						<td><input id="bankAccno9" type="text" class="easyui-validatebox" validType="account[8,20]" data-options="required:true"/></td><td><input
							id="currMonthIn9" type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td><td><input id="currMonthOut9"
							type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td><td><input id="currSeaInterestAmt9" type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td>
					</tr>
					<tr id="10" style="display:none;">
						<td><input type="text" id="currMonth10" class="easyui-validatebox"  data-options="required:true"/></td>
						<td><input id="bankName10" type="text" class="easyui-validatebox"  data-options="required:true"/></td>
						<td><input id="bankAccno10" type="text" class="easyui-validatebox" validType="account[8,20]" data-options="required:true"/></td><td><input
							id="currMonthIn10" type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td><td><input id="currMonthOut10"
							type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td><td><input id="currSeaInterestAmt10" type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td>
					</tr>
					<tr id="11" style="display:none;">
						<td><input type="text" id="currMonth11" class="easyui-validatebox"  data-options="required:true"/></td>
						<td><input id="bankName11" type="text" class="easyui-validatebox"  data-options="required:true"/></td>
						<td><input id="bankAccno11" type="text" class="easyui-validatebox" validType="account[8,20]" data-options="required:true"/></td><td><input
							id="currMonthIn11" type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td><td><input id="currMonthOut11"
							type="text"class="easyui-validatebox" validType="amt" data-options="required:true"/></td><td><input id="currSeaInterestAmt11" type="text" class="easyui-validatebox" validType="amt" data-options="required:true"/></td>
					</tr>
				</table>
			</div>		
	</c:if>
			<div id="divBankDetail" >
                	<table id="bankSerialDetailTable"
						style="width:1000px;height:290px;"						
						title="银行流水信息"
						onClickRow="clickRow" rownumbers="true" pagination="true">
						<thead>
							<tr>
								<th field="custName">客户姓名</th>
								<th field="bankName">银行名称</th>
								<th field="bankAccno">银行卡号</th>
								<th field="currMonth">月份</th>
								<th field="currMonthIn">当月进项</th>
								<th field="currMonthOut">当月出项</th>
								<th field="currSeaInterestAmt">当季结息金额</th>
							</tr>
						</thead>
					</table>
			</div>
</div>