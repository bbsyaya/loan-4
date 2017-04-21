<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	/* 重载*/
	function queryContractManagement() {
		$('#tp').datagrid('load', {
			loanIdLike : $('#loanId').val(),
			custNameLike : $('#custName').val(),
			merchantNameLike : $('#merchantName').val(),
			custIdLike : $('#custId').val(),
			custIdNoLike : $('#custIdNo').val(),
		});
	}
	/* 清空*/
	function clearInfo() {
		$('#loanId').val("");
		$('#custName').val("");
		$('#merchantName').val("");
		$('#custId').val("");
		$('#custIdNo').val("");
	}
	/* 签约*/
	function signAgreement() {
		var rows = $('#tp').datagrid("getSelections");
		var length = rows.length;
		if (length == 0) {
			alert("请选择一条记录！");
			return;
		} else if (length > 1) {
			alert("请只选择一条记录！");
			return;
		}
		var approveId = rows[0].approveId;
		$("#contractWindow").openWin(
						{
							title : '协议信息',
							href : 'openContractWindow.do?approveId='+ approveId
									+ '&direct2Path=agreementMrg/pendingAgreement/contractMain',
						})
	}
	/* 初始化*/
	$(function() {
		$('#tp').datagrid({
			onClickCell : function(rowIndex, field, value) {
				if (field != 'id') {
					$(this).datagrid('unselectAll');
				}
			},
		});
	})
</script>
	<div id="pendingAgreementMain" region="center" border="false" width="100%" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
		<table id="tp" class="easyui-datagrid" 
		   url="<%=request.getContextPath()%>/contractManagement/queryAvailableContractManagement.do?searchApproveStatus=${approveStatus}"
		   title="Searching" iconCls="icon-search" toolbar="#tc" onClickRow="clickRow"  rownumbers="true" pagination="true">
			<div id="tc" style="padding:3px">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="signAgreement()">签约</a>
				<br/>
				<span>申请编号:</span>
				<input id="loanId" name="loanId" style="line-height:20px;border:1px solid #ccc"/>
				<span>客户名称:</span>
				<input id="custName" name="custName" style="line-height:20px;border:1px solid #ccc"/>
				<span>商户名称:</span>
				<input id="merchantName" name="merchantName" style="line-height:20px;border:1px solid #ccc"/>
				<br/><br/>
				<span>客户编号:</span>
				<input id="custId" name="custId" style="line-height:20px;border:1px solid #ccc"/>
				<span>客户证件号码:</span>
				<input id="custIdNo" name="custIdNo" style="line-height:20px;border:1px solid #ccc"/>
				<br/>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="clearInfo()">清空</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="queryContractManagement()">查询</a>
			</div>
			<thead>
				<tr>
				    <th field="id" checkbox="true"></th>
				    <th field="approveId" width="120">批复编号</th> 
				    <th field="custName" width="120">客户名称</th>
					<th field="businessSource" width="120">业务来源</th>
					<th field="applyAmt" formatter="formatdecimal" width="120">申请额度</th>
				    <th field="applyMoneyKind" width="120">申请币种</th>
				    <th field="termUnit" width="120">期限单位</th>
				    <th field="applyTerm" width="120">申请期限</th>
				    <th field="applyCommitDateStr" width="120">申请提交日期</th>  
				    <th field="acceptAccount" width="120">收款账号</th>
				    <th field="accountOpenBank" width="120">账户开户行</th>
					<th field="loanId" width="120">申请编号</th>
					<th field="custId" width="120">客户编号</th>
					<th field="approveAmount" formatter="formatdecimal" width="120">批复额度</th>
					<th field="approveInterest" width="120">批复利率</th>
					<th field="approveTermUnit" width="120">批复期限单位</th>
					<th field="approveTerm" width="120">批复期限</th>
					<th field="approveDateStr" width="120">批复日期</th>
					<th field="paybackMethod" width="120">还款方式</th>  
				</tr>
			</thead>
		</table>
		<div id="contractWindow"></div>	<!-- 生成协议信息 -->
	</div>