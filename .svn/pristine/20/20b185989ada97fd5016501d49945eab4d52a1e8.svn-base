<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--新增窗口-->
<!-- 
<div id="creditApplyWindow" title="新增授信申请" maximized="true"
	collapsible="false" minimizable="false" maximizable="true"
	icon="icon-save"
	style="background: #fafafa;"> -->
		<div id="apply" region="center" class="easyui-tabs" border="false"
			style="padding: 10px; background: #fff; border: 1px solid #ccc;">
	<jsp:include page="insertCreditInfo.jsp"></jsp:include>
	<jsp:include page="insertCreditPosInfo.jsp"></jsp:include>
	<jsp:include page="insertCreditBankSerialInfo.jsp"></jsp:include>
	<jsp:include page="insertCreditImageDataInfo.jsp"></jsp:include>
	</div>
	<br/>
	<div region="south" border="false"
			style="text-align: center; height: 30px; line-height: 30px;">
				<a id="btnEpinsert2" onclick="creditApplyReg('1')"
				class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)">保存并退出</a><a
				id="btnCancel" onclick="closeCreditApply()"
				class="easyui-linkbutton" icon="icon-cancel"
				href="javascript:void(0)">取消</a>
		</div>
<!-- 
</div> -->
<div id="tab-tools">
	<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-cancel'" onclick="closeCreditApply()">关闭&nbsp;&nbsp; </a>
</div>
<script type="text/javascript">
$('#apply').tabs({ 
    border:false, 
    onSelect:function(title,index){ 
       // #这里写你要怎么处理这个选中的tab 
       if(index==1){		//pos流水
    	   reloadPOSData("#posSerialInsertTable","${loanId}");
	   		$('#insertIframe').attr("src", "<%=request.getContextPath()%>/navigation/posSerialNav.do?loanId=${loanId}&&container=posSerialInsertTable");
       }
	   if(index==3){		//影像文件
		   $('#insertImageDataIframe').attr("src", "<%=request.getContextPath()%>/navigation/insertCreditImageDataNav.do?loanId=${loanId}");
       }
	   if(index==4){
		   $('#insertImageDataIframeServer').attr("src", "<%=request.getContextPath()%>/navigation/insertCreditImageDataFromServerNav.do?loanId=${loanId}");
	   }
    },
    toolPosition:'left',
    tools: '#tab-tools'
});

</script>