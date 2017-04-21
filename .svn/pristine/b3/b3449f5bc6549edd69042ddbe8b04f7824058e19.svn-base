<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div id="contractMainDiv" title="协议信息11" style="padding: 20px;">
		<input type="hidden" id="insertApproveId" value="${approveResult.approveId }" />
		<div region="center" class="easyui-tabs" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
			<jsp:include page="contractInfo.jsp"></jsp:include>
			<jsp:include page="imageDataInfo.jsp"></jsp:include>
		</div>
		<br />
		<div region="south" border="false" style="text-align: center; height: 30px; line-height: 30px;">
			<a id="btn" onclick="signContractBtn()" class="easyui-linkbutton" icon="icon-save" plain="true" href="javascript:void(0)">签约</a>
		</div>
	</div>
<script>
    $(function(){
    	$("#insertSignContractBeginDate").datebox({
    			required:true,
    			onSelect: function(date){
    				calculateExpectedEndDate();
    		    }
    	})
    })
    //计算用款到期日
   	function calculateExpectedEndDate(){
   		var reqUrl = '<%=request.getContextPath()%>/paymentApply/calculateDate.do';
   		//期望用款日
   		var expectedDate = $("#insertSignContractBeginDate").datebox('getValue');
   		//用款期限
   		var payApplyTerm = $("#insertSignApproveTerm").val().trim();
   		$.post(reqUrl,{
   			expectedDate: expectedDate,
   			payApplyTerm: payApplyTerm
   		},
   		function(data){
   			$("#insertSignContractEndDate").datebox('setValue',data);
   		},'text')
   	}
    //签约
    function signContractBtn(){
    	var approveId = $('#insertApproveId').val();
    	var beginDate = $('#insertSignContractBeginDate').datebox('getValue');
    	var endDate = $('#insertSignContractEndDate').datebox('getValue');
    	var signDate = $('#insertSignDate').datebox('getValue');
    	var reqUrl = '<%=request.getContextPath()%>/contractManagement/insertContractManagement.do';
						$.post(reqUrl, {
							approveId : approveId,
							beginDate : beginDate,
							endDate : endDate,
							signDate : signDate
						}, function(data) {
							alert(data);
							$('#contractWindow').window('close');
							$('#tp').datagrid('reload');
							$('#tt').datagrid('reload');
						},'text');
					}
</script>