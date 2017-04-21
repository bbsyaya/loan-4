<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!-- 详情窗口 -->
	<div id="paymentApprove" region="center" class="easyui-tabs" border="false" width="100%"
		style="padding: 10px; background: #fff; border: 1px solid #ccc;">
		<jsp:include page="ApprovalExecView.jsp"></jsp:include>
		<jsp:include page="../paymentApply/detailPaymentApply/detailCustomerInfo.jsp"></jsp:include>
		<jsp:include page="../paymentApply/detailPaymentApply/detailImageDataInfo.jsp"></jsp:include>
	</div>
	<div region="south" border="false" style="text-align: center;">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="savePaymentSign()" iconCls="icon-save" >保存</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitPaymentSign()" iconCls="icon-ok" >提交</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a id="btnEp" href="javascript:void(0)" class="easyui-linkbutton" onclick="colseDetailPaymentApply()" icon="icon-back" >返回</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
	<br/>
<script type="text/javascript">
$('#paymentApprove').tabs({ 
    border:false, 
    onSelect:function(title,index){ 
       // #这里写你要怎么处理这个选中的tab 
       	if(index==2){		//影像材料
       		var url = "<%=request.getContextPath()%>/navigation/loanPOSImageFiles.do?loanId=${contract.loanId}&custId=${contract.custId}";
       		$('#imageDataIframe').attr("src", url);
       	}
    } 

});

</script>