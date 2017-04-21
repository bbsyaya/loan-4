<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%com.hrbb.loan.web.security.entity.AccessPrivilege access = (com.hrbb.loan.web.security.entity.AccessPrivilege)session.getAttribute("accessPrivilege"); %>
<div id="approve" width="100%" region="center" class="easyui-tabs" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
	<!-- 审批操作视图 -->
	<c:choose>
		<c:when test="${'31'==applyDetail[0].applyStatus 
			or '33'==applyDetail[0].applyStatus 
			or '34'==applyDetail[0].applyStatus
			or '41'==applyDetail[0].applyStatus
			or '90'==applyDetail[0].applyStatus
			or '91'==applyDetail[0].applyStatus
			or '92'==applyDetail[0].applyStatus}">
			<jsp:include page="ApprovalExecView.jsp"></jsp:include>
			<jsp:include page="riskDetection.jsp"></jsp:include>
			<jsp:include page="auditList.jsp"></jsp:include>
			<jsp:include page="detailCreditPosSerialInfo.jsp"></jsp:include>
			<jsp:include page="detailCreditBankSerialInfo.jsp"></jsp:include>
			<jsp:include page="../creditApply/detailCredit/detailImageDataInfo.jsp"></jsp:include>
			<%if(access.hasAnyPrivilege("ROLE_APPR_LV1;ROLE_APPR_LV2;ROLE_APPR_LV3;")){ %>
			<jsp:include page="../creditApply/detailCredit/detailBizEntitiesInfo.jsp"></jsp:include>
			<jsp:include page="../creditApply/detailCredit/detailCreditReport.jsp"></jsp:include>
			<%} %>
		</c:when>
		<c:when test="${'21'==applyDetail[0].applyStatus}">
   			<jsp:include page="ApprovalSimpleView.jsp"></jsp:include>
			<jsp:include page="riskDetection.jsp"></jsp:include>
			<jsp:include page="auditList.jsp"></jsp:include>
			<jsp:include page="detailCreditPosSerialInfo.jsp"></jsp:include>
			<jsp:include page="detailCreditBankSerialInfo.jsp"></jsp:include>
			<jsp:include page="editImageDataInfo.jsp"></jsp:include>
			<jsp:include page="../creditApply/detailCredit/detailBizEntitiesInfo.jsp"></jsp:include>
		</c:when>
   		<c:otherwise>
   			<jsp:include page="ApprovalSimpleView.jsp"></jsp:include>
			<jsp:include page="riskDetection.jsp"></jsp:include>
			<jsp:include page="auditList.jsp"></jsp:include>
			<jsp:include page="detailCreditPosSerialInfo.jsp"></jsp:include>
			<jsp:include page="detailCreditBankSerialInfo.jsp"></jsp:include>
			<jsp:include page="../creditApply/detailCredit/detailImageDataInfo.jsp"></jsp:include>
			<jsp:include page="../creditApply/detailCredit/detailBizEntitiesInfo.jsp"></jsp:include>
   		</c:otherwise>
   	</c:choose>
</div>
<div id="tab-tools">
	<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-cancel'" onclick="closeSignSubmitWindow()">关闭&nbsp;&nbsp; </a>
</div>
<script type="text/javascript">
$('#approve').tabs({ 
    border:false, 
    toolPosition:'left',
    tools: '#tab-tools',
    onSelect:function(title,index){ 
       // #这里写你要怎么处理这个选中的tab 
    	if(index==5){		//影像材料
    		var s = ${applyDetail[0].applyStatus};
    		//资料审核补件的时候，资料审核岗的人可以上传影响资料
    		if ('21' == s){
           		$('#editImageDataIframe').attr("src", "<%=request.getContextPath()%>/navigation/loanPOSImageFiles.do?loanId=${applyDetail[0].loanId}");
           		$('#editImageDataIframe1').attr("src", "<%=request.getContextPath()%>/navigation/insertCreditImageDataNavForReview.do?loanId=${applyDetail[0].loanId}");
    		}else{
       		    //var url = "<%=request.getContextPath()%>/navigation/loanPosImageDataNav.do?loanId=${applyDetail[0].loanId}";
       		 	//var urlBigger = "<%=request.getContextPath()%>/navigation/loanPosImageDataNavBigger.do?loanId=${applyDetail[0].loanId}&custId=${applyDetail[1].custId}";
        		var urlBigger = "<%=request.getContextPath()%>/navigation/loanPOSImageFiles.do?loanId=${applyDetail[0].loanId}&custId=${applyDetail[1].custId}";
       		 	window.open(urlBigger);
       		    //$('#imageDataIframe').attr("src", url);
    		}
       	}
       	
    	if(index==1){		//风险探测
			var queryUrl = '<%=request.getContextPath()%>/creditApplyForReview/selectForRiskDetection.do?loanId=${applyDetail[0].loanId}';
			$('#tRisk').datagrid({url:queryUrl,
			    onLoadSuccess:function(data){
				}
			});
    	}
    	
    	if(index==2){		//审批记录
    		var reqUrl = "<%=request.getContextPath()%>/auditList/getInforAuditList.do";
			$.post(reqUrl,
				{loanId: '${applyDetail[0].loanId}'}, 
				function(data){
					$('#auditListWindow').html(data);
				}
			);
    	}
    	
    	if(index==3){		//POS流水
    		$('#posSerialDetailTable').datagrid({
		    	url: "<%=request.getContextPath()%>/creditApply/queryCreditApplyPosSerialDetail.do?loanId=${applyDetail[0].loanId}"
		    });
    	}
    	
    	if(index==4){		//银行流水
	    	$('#bankSerialDetailTable').datagrid({
				url: "<%=request.getContextPath()%>/creditApply/queryCreditApplyBankSerialDetail.do?loanId=${applyDetail[0].loanId}"
			});
    	}
    	
    	if(title=="征信报告"){
    		//alert("征信报告");
    		var reqUrl = "<%=request.getContextPath()%>/creditReport/getReportHtml.do";
    		$.post(reqUrl,
    				{paperId: '${applyDetail[1].paperId}'}, 
    				function(htmlUrl){
    					$('#creditReportFrame').attr("src", htmlUrl);
    				}
    			);
		    
    	}
    	
    	if(index==6){		//银行流水
	    	$('#aicInfoIframe').attr("src","<%=request.getContextPath()%>/creditApply/queryAicInfo.do?posCustId=${applyDetail[3].posCustId}");
    	}
    } 
});

function reloadPOSData(container,loandId){
	$(container).datagrid({
		url: "<%=request.getContextPath()%>/creditApply/queryCreditApplyPosSerialDetail.do?loanId=${applyDetail[0].loanId}"
	});
}
//影像件修改
function editImageDataButton(obj){
	var buttonVal = obj.value;
	if(buttonVal == '重新上传'){
		$(obj).val('取消上传');
		$("#editImageDataIframe1").attr("style","display: block");
	}else{
		$(obj).val('重新上传');
		$("#editImageDataIframe1").attr("style","display: none");
	}
}

function closeSignSubmitWindow() {
    $('#signSubmitWindow').window('close');
}
</script>