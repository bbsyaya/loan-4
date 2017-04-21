<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%com.hrbb.loan.web.security.entity.AccessPrivilege access = (com.hrbb.loan.web.security.entity.AccessPrivilege)session.getAttribute("accessPrivilege"); %>
<div id="approve" width="100%" region="center" class="easyui-tabs" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
	<!-- 审批操作视图 -->
	<%if(access.hasAnyPrivilege("ROLE_APPR_LV1;ROLE_APPR_LV2;ROLE_APPR_LV3;ROLE_APPR_LV4;")){ %>
			<jsp:include page="ApprovalExecView.jsp"></jsp:include>
			<jsp:include page="riskDetection.jsp"></jsp:include>
			<jsp:include page="auditList.jsp"></jsp:include>
			<jsp:include page="detailCreditPosSerialInfo.jsp"></jsp:include>
			<jsp:include page="detailBnakInfoIframeWindow.jsp"></jsp:include>
			<jsp:include page="../creditApply/detailCredit/detailImageDataInfo.jsp"></jsp:include>
			<jsp:include page="../creditApply/detailCredit/detailBizEntitiesInfo.jsp"></jsp:include>
			<jsp:include page="../creditApply/detailCredit/detailCreditReport.jsp"></jsp:include>
			<jsp:include page="../creditApply/detailCredit/detailPoliceInfo.jsp"></jsp:include>
			<jsp:include page="../creditApply/detailCredit/detailFixedLineInfo.jsp"></jsp:include>
	<%}else if(access.hasAnyPrivilege("ROLE_INFO_APPR")){ %>
   			<jsp:include page="ApprovalSimpleView.jsp"></jsp:include>
			<jsp:include page="riskDetection.jsp"></jsp:include>
			<jsp:include page="auditList.jsp"></jsp:include>
			<jsp:include page="detailCreditPosSerialInfo.jsp"></jsp:include>
			<jsp:include page="detailBnakInfoIframeWindow.jsp"></jsp:include>
			<jsp:include page="editImageDataInfo.jsp"></jsp:include>
			<jsp:include page="../creditApply/detailCredit/detailBizEntitiesInfo.jsp"></jsp:include>
	<%}else{ %>
   			<jsp:include page="../creditApply/detailCredit/detailCreditInfo.jsp"></jsp:include>
			<jsp:include page="riskDetection.jsp"></jsp:include>
			<jsp:include page="auditList.jsp"></jsp:include>
			<jsp:include page="detailCreditPosSerialInfo.jsp"></jsp:include>
			<jsp:include page="detailBnakInfoIframeWindow.jsp"></jsp:include>
			<jsp:include page="../creditApply/detailCredit/detailImageDataInfo.jsp"></jsp:include>
			<jsp:include page="../creditApply/detailCredit/detailBizEntitiesInfo.jsp"></jsp:include>
   	<%} %>
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
    		var status = ${applyDetail[0].applyStatus};
    		//资料审核补件的时候，资料审核岗的人可以上传影响资料
    		if ('21' == status || status == "10"){
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
    		//移动到风险探测页面自动加载
			//var queryUrl = '<%=request.getContextPath()%>/creditApplyForReview/selectForRiskDetection.do?loanId=${applyDetail[0].loanId}';
			//$('#tRisk').datagrid({url:queryUrl,
			//    onLoadSuccess:function(data){
			//	}
			//});
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
    		var reqUrl = "<%=request.getContextPath()%>/creditApply/getBankSerialInfo.do";
    		var loanId = '${applyDetail[0].loanId}';
    	    $.post(reqUrl,{loanId:loanId},function(data){
    		 	$('#searchBank').val(data.searchCard);
    		 	$('#searchName').val(data.searchName);
    	 		$('#detailBankInfoIframeSummary').attr("src","<%=request.getContextPath()%>/creditApply/queryCreditApplyBankSerialDetailSummary.do?loanId=${applyDetail[0].loanId}"); 
    	 },'json')
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
    	
    	if(index==6){		//工商信息
	    	$('#aicInfoIframe').attr("src","<%=request.getContextPath()%>/aic/getAicInfo.do?posCustId=${applyDetail[3].posCustId}");
    	}
    	//公安信息
    	if(8==index){
  	       $.messager.progress({
                 text: '数据加载中，请稍等......',
             }); 
    		var url = "<%=request.getContextPath()%>/info/police/detail.do?loanId=${loanId}";
    		$('#policeInfoIframe').attr("src",url);
    	}
    	//固话综合信息
    	if(9 == index){
            $.messager.progress({
                text: '数据加载中，请稍等......',
            }); 
    		var url = "<%=request.getContextPath()%>/info/guozhengtong/fixedLine.do?loanId=${loanId}";
            $('#fixedLineInfoIframe').attr("src",url);
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
	var buttonVal = obj.innerText.trim();
	if(buttonVal == '重新上传'){
		$('#upload').linkbutton({text:'取消上传'}); 
		$("#editImageDataIframe1").attr("style","display: block");
	}else{
		$('#upload').linkbutton({text:'重新上传'}); 
		$("#editImageDataIframe1").attr("style","display: none");
	}
}

function closeSignSubmitWindow() {
    $('#signSubmitWindow').window('close');
}

function updateParentTab(url) {
	var stab = "#approve";
	<%if(access.hasAnyPrivilege("ROLE_APPR_LV1;ROLE_APPR_LV2;ROLE_APPR_LV3;ROLE_APPR_LV4;")){ %>
	var url = "openApprovalView.do?loanId=${loanId}&opflag=${opflag}&directTo=review/ApprovalExecView";
	<%}else if(access.hasAnyPrivilege("ROLE_INFO_APPR")){ %>
	var url = "openApprovalView.do?loanId=${loanId}&opflag=${opflag}&directTo=review/ApprovalSimpleView";
	<%}%>
    var tab = $(stab).tabs('getSelected');
    $(stab).tabs('update', {
        tab: tab, 
		options: {
            href: url
        }
    }); 
    tab.panel('refresh');
}
</script>