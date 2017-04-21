<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!-- 详情窗口 -->
	<div id="unFreezeAgreementWindow" title="协议解冻" collapsible="false" minimizable="false" maximizable="true" icon="icon-save" style="background: #fafafa;">
		<input type="hidden" class="contractInfo"/>
			<div id="unfreezeAgreementTab" region="center" class="easyui-tabs" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<jsp:include page="unFreezeAgreementInfo.jsp"></jsp:include>
				<%-- <jsp:include page="unfreezeCustInfo.jsp"></jsp:include> --%>
				<jsp:include page="unfreezeCreditInfo.jsp"></jsp:include>
				<jsp:include page="detailImageDataInfo.jsp"></jsp:include>
			</div>
			<br/>
			<br/>
			<div region="south" border="false" style="text-align: center; height: 30px; line-height: 30px;">
				<a id="btnEp" onclick="modifyAgreement(3)" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)">协议解冻</a>
				<a id="btnEp" onclick="closeThisWindow(4)" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)">返回</a>
			</div>
		</div>
<script type="text/javascript">
$('#unfreezeAgreementTab').tabs({ 
    border:false, 
    onSelect:function(title,index){ 
       // #这里写你要怎么处理这个选中的tab 
       	if(index==3){		//影像材料
       		var url = "<%=request.getContextPath()%>/navigation/loanPosImageDataNav.do?loanId=${contract.loanId}&custId=${contract.custId}";
       		window.open(url);
       		$('#imageDataIframe3').attr("src", url);
       	}
    } 

});
</script>
