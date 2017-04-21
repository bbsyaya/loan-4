<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!-- 详情窗口 
	<div id="detailAgreementWindow" title="协议详情" collapsible="false" minimizable="false" maximizable="true" icon="icon-save" style="background: #fafafa;">-->
			<input type="hidden" class="contractInfo"/>
			<input type="hidden" name="loanId1" id ="loanId1"/>
			<div id="detailAgreementTab" region="center" class="easyui-tabs" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<jsp:include page="detailAgreementInfo.jsp"></jsp:include>
				<%-- <jsp:include page="detailCustInfo.jsp"></jsp:include> --%>
				<div title="审批结果" style="padding:20px;">
				<jsp:include page="../../contract/sign/approveInfo.jsp"></jsp:include>
				</div>
				<jsp:include page="../../creditApply/detailCredit/detailCreditInfo.jsp"></jsp:include>
				<jsp:include page="detailImageDataInfo.jsp"></jsp:include>
				<jsp:include page="detailProtocolInfo.jsp"></jsp:include>
			</div>
			<br/><br/><br/>
			<div region="south" border="false" style="text-align: center; height: 30px; line-height: 30px;">
				<a id="btnEp" onclick="closeThisWindow(1)" class="easyui-linkbutton" icon="icon-back" href="javascript:void(0)">返回</a>
			</div>
	<!-- </div> -->
<div id="tab-tools">
	<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-cancel'" onclick="closeThisWindow(1)">关闭&nbsp;&nbsp; </a>
</div>
	<script type="text/javascript">
$('#detailAgreementTab').tabs({ 
    border:false, 
    onSelect:function(title,index){ 
       // #这里写你要怎么处理这个选中的tab 
       	if(index==3){		//影像材料
       		var url = "<%=request.getContextPath()%>/navigation/loanPOSImageFiles.do?loanId=${contract.loanId}&custId=${contract.custId}";
       		//var url = "<%=request.getContextPath()%>/navigation/loanPosImageDataNav.do?loanId=${contract.loanId}&custId=${contract.custId}";
       		//window.open(url);
       		$('#imageDataIframe1').attr("src", url);
       	}
       	if(index==4){		//电子协议
       		//var loanId1 = $('#loanId1').val();
       		var url = "<%=request.getContextPath()%>/creditApply/viewProtocol.do?loanId=${approveInfo.loanId}";
       		$('#protocolIframe').attr("src", url);
       	}
       
    },
    toolPosition:'left',
    tools: '#tab-tools'

});
</script>