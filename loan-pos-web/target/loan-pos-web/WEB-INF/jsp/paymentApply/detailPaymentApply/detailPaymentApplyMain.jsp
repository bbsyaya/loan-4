<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!-- 详情窗口 -->
	<div id="detailPayment" region="center" class="easyui-tabs" border="false" width="100%"
		style="padding: 10px; background: #fff; border: 1px solid #ccc;">
		<div title="用款信息" style="padding:20px;"><jsp:include page="detailPaymentApplyInfo.jsp"></jsp:include></div>
		<jsp:include page="detailCustomerInfo.jsp"></jsp:include>
		<jsp:include page="detailImageDataInfo.jsp"></jsp:include>
	</div>
	<br/>
	<div region="south" border="false" style="text-align: center; height: 30px; line-height: 30px;">
		<a id="btnEp" onclick="colseDetailPaymentApply()" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)">返回</a>
	</div>
<script type="text/javascript">
$('#detailPayment').tabs({ 
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