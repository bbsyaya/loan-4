<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!-- 取消窗口 -->
	<div id="cancelPayment" region="center" class="easyui-tabs" border="false" width="100%"
		style="padding: 10px; background: #fff; border: 1px solid #ccc;">
		<jsp:include page="cancelPaymentApplyInfo.jsp"></jsp:include>
		<jsp:include page="cancelContractInfo.jsp"></jsp:include>
		<jsp:include page="cancelCustomerInfo.jsp"></jsp:include>
	</div>
	<br />
	<br />
	 <div region="south" border="false" style="text-align: center; height: 30px; line-height: 30px;">
		<a id="btnConfirm" onclick="confirmCancelPaymentApply()" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)">确认取消</a>
		<a id="btnCancel" onclick="cancelPaymentApply()" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)">取消</a>
	</div>
	 
<script type="text/javascript">
	/*  $('#detail').tabs({
		border : false,
		onSelect : function(title, index) {
		}

	});  */
</script>