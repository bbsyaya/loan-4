<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!-- 详情窗口 -->
	<!-- 
	<div id="detailApplyWindow" title="申请详情"
	collapsible="false" minimizable="false" maximizable="true"
	icon="icon-save"
	style="background: #fafafa;"> -->
		<div id="detail" region="center" class="easyui-tabs" border="false" width="100%"
			style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<jsp:include page="detailCreditInfo.jsp"></jsp:include>
				<jsp:include page="detailCreditPosSerialInfo.jsp"></jsp:include>
				<jsp:include page="detailCreditBankSerialInfo.jsp"></jsp:include>
				<jsp:include page="detailImageDataInfo.jsp"></jsp:include>
			</div>
			<br/><br/>
			<div region="south" border="false"
				style="text-align: center; height: 30px; line-height: 30px;">

				<a id="btnEp" onclick="closeDetailApply()" class="easyui-linkbutton"
					icon="icon-ok" href="javascript:void(0)">退出</a>
			</div>
<!-- 
	</div> -->
<div id="tab-tools">
	<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-cancel'" onclick="closeDetailApply()">关闭&nbsp;&nbsp; </a>
</div>
<script type="text/javascript">
$('#detail').tabs({ 
    border:false, 
    onSelect:function(title,index){ 
       // #这里写你要怎么处理这个选中的tab 
		if(index==1){		//pos流水
			$('#posSerialDetailTable').datagrid({
	    		url: "<%=request.getContextPath()%>/creditApply/queryCreditApplyPosSerialDetail.do?loanId=${loanId}"
	    	});
       	}
		if(index==2){		//银行流水
	    	$('#bankSerialDetailTable').datagrid({
	    		url: "<%=request.getContextPath()%>/creditApply/queryCreditApplyBankSerialDetail.do?loanId=${loanId}"
	    	});
       	}
       	if(index==3){		//影像材料
       		//var url = "<%=request.getContextPath()%>/navigation/loanPosImageDataNav.do?loanId=${loanId}&custId=${applyDetail[1].custId}";
       		var urlBigger = "<%=request.getContextPath()%>/navigation/loanPOSImageFiles.do?loanId=${loanId}&custId=${applyDetail[1].custId}";
       		window.open(urlBigger);
       		//$('#imageDataIframe').attr("src", url);
       	}
    },
    toolPosition:'left',
    tools: '#tab-tools'
});

</script>