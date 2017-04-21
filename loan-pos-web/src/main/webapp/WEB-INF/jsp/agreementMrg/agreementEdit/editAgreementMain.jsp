<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!-- 详情窗口 -->
	<div id="editAgreementWindow" title="协议调整" collapsible="false" minimizable="false" maximizable="true" icon="icon-save" style="background: #fafafa;">
		<input type="hidden" class="contractInfo"/>
			<div id="editAgreementTab" region="center" class="easyui-tabs" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<jsp:include page="editAgreementInfo.jsp"></jsp:include>
				<%-- <jsp:include page="editCustInfo.jsp"></jsp:include> --%>
				<jsp:include page="editCreditInfo.jsp"></jsp:include>
				<jsp:include page="detailImageDataInfo.jsp"></jsp:include>
			</div>
			<br/><br/><br/>
			<div region="south" border="false" style="text-align: center; height: 30px; line-height: 30px;">
				<a id="btnEp" onclick="modifyAgreement(1)" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)">确认调整</a>
				<a id="btnEp" onclick="closeThisWindow(2)" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)">返回</a>
			</div>
		</div>
	<script type="text/javascript">
	$('#editAgreementTab').tabs({ 
	    border:false, 
	    onSelect:function(title,index){ 
	       // #这里写你要怎么处理这个选中的tab 
	       	if(index==3){		//影像材料
	       		var url = "<%=request.getContextPath()%>/navigation/loanPosImageDataNav.do?loanId=${contract.loanId}&custId=${contract.custId}";
	       		window.open(url);
	       		$('#imageDataIframe2').attr("src", url);
	       	}
	    } 
	
	});
	
	$(function(){
		$("#editAgreementBiginDate").datebox({
				required:true,
				onSelect: function(date){
					calculateStdMaturity();
			    }
		})
	})
	
	//计算用款到期日
	function calculateStdMaturity(){
		var reqUrl = "<%=request.getContextPath()%>/paymentApply/calculateStdMaturity.do";
		//合约生效日
		var effectDate = $("#editAgreementBiginDate").datebox('getValue');
		//授信期限
		var contTerm = $("#editContTerm").val().trim();
		
		$.post(reqUrl,{
			calcDateFrom: effectDate,
			calcTerm: contTerm
		},
		function(data){
			$("#editAgreementEndDate").datebox('setValue',data);
		},'text')
	}
</script>