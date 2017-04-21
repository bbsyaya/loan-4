<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!-- 详情窗口 -->
	<div id="freezeAgreementWindow"title="协议解冻" collapsible="false" minimizable="false" maximizable="true" icon="icon-save" style="background: #fafafa;">
		<input type="hidden" class="contractInfo"/>
			<div id="freezeAgreementTab"  region="center" class="easyui-tabs" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<jsp:include page="freezeAgreementInfo.jsp"></jsp:include>
				<%-- <jsp:include page="freezeCustInfo.jsp"></jsp:include> --%>
				<jsp:include page="freezeCreditInfo.jsp"></jsp:include>
				<jsp:include page="detailImageDataInfo.jsp"></jsp:include>
			</div>
			<br/><br/><br/>
			<div region="south" border="false" style="text-align: center; height: 30px; line-height: 30px;">
				<a id="btnEp" onclick="modifyAgreement(2)" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)">确认冻结</a>
				<a id="btnEp" onclick="closeThisWindow(3)" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)">返回</a>
			</div>
		</div>
		
<script type="text/javascript">
$('#freezeAgreementTab').tabs({ 
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
