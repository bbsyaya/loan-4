<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!--修改窗口-->
	<!-- 
    <div id="modifyApplyWindow" title="修改授信申请"
	collapsible="false" minimizable="false" maximizable="true"
	icon="icon-save"
	style="background: #fafafa;"> -->
		<div id="edit" region="center" class="easyui-tabs" border="false"
			style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <jsp:include page="editCreditInfo.jsp"></jsp:include>
                <jsp:include page="editCreditPosSerialInfo.jsp"></jsp:include>
                <jsp:include page="editCreditBankSerialInfo.jsp"></jsp:include>
                <jsp:include page="editImageDataInfo.jsp"></jsp:include>
            </div>
            <br/><br/>
            <div region="south" border="false" style="text-align: center;">
            	<a id="btnEi" onclick="modifyCreditApply()" class="easyui-linkbutton" icon="icon-ok">修改</a>
				<a id="btnCancel" onclick="closeModifyApply()" class="easyui-linkbutton" icon="icon-cancel">取消</a>
            </div>
    <!-- </div> -->
<div id="tab-tools">
	<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-cancel'" onclick="closeModifyApply()">关闭&nbsp;&nbsp; </a>
</div>
    <script type="text/javascript">
	$('#edit').tabs({ 
	    border:false, 
	    onSelect:function(title,index){ 
	       // #这里写你要怎么处理这个选中的tab 
			if(index==1){		//pos流水
		    	reloadPOSData("#posSerialEditTable","${loanId}");
				$('#editPosSerialIframe').attr("src", "<%=request.getContextPath()%>/navigation/posSerialNav.do?loanId=${loanId}&container=posSerialEditTable");
	       	}
			if(index==2){		//银行流水
		    	$('#bankSerialEditTable').datagrid({
		    		url: "<%=request.getContextPath()%>/creditApply/queryCreditApplyBankSerialDetail.do?loanId=${loanId}"
		    	});
	       	}
	       	if(index==3){		//影像材料
	       		var url = "<%=request.getContextPath()%>/navigation/loanPOSImageFiles.do?loanId=${loanId}&custId=${applyDetail[1].custId}";
	       		//var urlBigger = "<%=request.getContextPath()%>/navigation/loanPosImageDataNavBigger.do?loanId=${loanId}&custId=${applyDetail[1].custId}";
	       		//window.open(urlBigger);
	       		$('#editImageDataIframe').attr("src", url);
	       		$('#editImageDataIframe1').attr("src", "<%=request.getContextPath()%>/navigation/insertCreditImageDataNav.do?loanId=${loanId}");
	       	}
	       	if(index==4){		//影像材料备用
	       		var url = "<%=request.getContextPath()%>/navigation/loanPOSImageFiles.do?loanId=${loanId}&custId=${applyDetail[1].custId}";
	       		//var urlBigger = "<%=request.getContextPath()%>/navigation/loanPosImageDataNavBigger.do?loanId=${loanId}&custId=${applyDetail[1].custId}";
	       		$('#editImageDataIframeback').attr("src", url);
	       		$('#editImageDataIframeback1').attr("src", "<%=request.getContextPath()%>/navigation/insertCreditImageDataFromServerNav.do?loanId=${loanId}");
	       	}
	    },
	    toolPosition:'left',
	    tools: '#tab-tools'
	
	});

	function reloadImage(tabCntr, tabName){
		$.messager.alert("操作提示","影像文件上传成功.","info");
		var url = "<%=request.getContextPath()%>/navigation/loanPOSImageFiles.do?loanId=${loanId}&custId=${applyDetail[1].custId}";
		$('#editImageDataIframe').attr("src", url);
		$("#editImageDataIframe").attr("style","display: block");
		$("#editImageDataIframe1").attr("style","display: none");
	}
	
</script>
