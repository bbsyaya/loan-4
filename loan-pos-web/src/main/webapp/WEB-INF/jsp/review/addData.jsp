<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--流水信息录入-->
<!-- 
<div id="addDataWindow" class="easyui-window" title="录入流水信息" closed="true" collapsible="false" minimizable="false" maximizable="true" icon="icon-save"
style="width: 1000px; height: 500px; padding: 5px;background: #fafafa;">

	<div id="detail" fit="true"> -->
    	<% String privileges = (String)session.getAttribute("assignedPrivileges"); %>
    	<div id="addDataTabs" region="center" class="easyui-tabs" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
   			<jsp:include page="../creditApply/detailCredit/detailCreditInfo.jsp"></jsp:include>
			<jsp:include page="detailCreditPosSerialInfo.jsp"></jsp:include>
			<jsp:include page="detailCreditBankSerialInfoSummary.jsp"></jsp:include>
			<jsp:include page="../creditApply/detailCredit/detailImageDataInfo.jsp"></jsp:include>
		</div>
		<br/>
    	<div region="south" border="false" style="text-align: center; height: 30px; line-height: 30px;">
	    <% if(privileges!=null && privileges.indexOf("ROLE_INFO;")>=0) {%>
		<c:if test="${applyDetail[0].applyStatus == '10'}">
			<a id="btnEpinsert" onclick="addData()" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)">提交</a>
		</c:if>
	    <% } %>
			<a id="btnCancel" onclick="closeAddDataWindow()" class="easyui-linkbutton" icon="icon-cancel"	href="javascript:void(0)">取消</a>
		</div>
<!-- 
	</div>

</div> -->

<script type="text/javascript">
$('#addDataTabs').tabs({ 
    border:false, 
    onSelect:function(title,index){ 
       // #这里写你要怎么处理这个选中的tab 
		if(index==5){		//pos流水
       	}
		if(index==6){		//银行流水
       	}
       	if(index==7){		//影像材料
       		var url = "<%=request.getContextPath()%>/navigation/loanPosImageDataNav.do?loanId=${loanId}&custId=${applyDetail[1].custId}";
       		$('#imageDataIframe').attr("src", url);
       	}
    } 

});

</script>
