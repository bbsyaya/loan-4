<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div title="用款申请概要" style="padding:20px;">
	<!-- 用款申请信息 -->
	<jsp:include page="../paymentApply/detailPaymentApply/detailPaymentApplyInfo.jsp"></jsp:include>
	<br/>
	<table id="execform" style="width:800px; ">
	<tr><td>
	<!-- 行号信息 -->
	<fieldset style="padding:5px; color:#333; border:#06c dashed 1px;">
		<legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">联行号信息</legend>
		<table style="width:100%;">
			<tr>
				<td class="tdtitle">银行名称:</td>	
				<td colspan="3">
					<input type="text" id="insertPosCustDetailBankName" name="insertPosCustDetailBankName" class="easyui-validatebox" style="width:280px;" value="${bankAccount.ptcptnm}"/>
					<a style="margin-left:50px;" href="javascript:void(0)" class="easyui-linkbutton" onclick="queryBankNo()" iconCls="icon-search" disabled>行号查询</a>
				</td>
			</tr>
            <tr>
            	<td style="width:15%;word-break;" class="tdtitle">查询结果:</td>
            	<td colspan="3">
	            	<select id="cnapsBankInfo" style="width:480px">
		            	<c:if test="${not empty bankAccount.cdtbranchid}">
		            		<option value="${bankAccount.cdtbranchid }">${bankAccount.ptcptnm}</option>
		            	</c:if>
	            	</select>
				</td>
			</tr>
        </table>
	</fieldset>
	</td></tr>
	<tr><td>&nbsp;</td></tr>
	<tr><td>
	<!-- 用款审核信息 -->
	<fieldset style="padding:5px; color:#333; border:#06c dashed 1px;">
		<legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">用款审核结果</legend>
		<table style="width:100%;">
			<tr>
           		<td style="width:15%;word-break;" class="tdtitle">用款开始日期:</td>
				<td><input id="apprBeginDate" name="apprBeginDate" disabled class="easyui-datebox" value="<fmt:formatDate value='${payApprOpinion.apprBeginDate}' pattern='yyyy-MM-dd'/>" size="30"/></td>
           		<td style="width:15%;word-break;" class="tdtitle">用款到期日:</td>
				<td><input id="apprEndDate" name="apprEndDate" class="easyui-datebox" size="30" 
						value="<fmt:formatDate value='${payApprOpinion.apprEndDate}' pattern='yyyy-MM-dd' />" 
						disabled="<c:if test="${paymentApply.status=='90' or paymentApply.status=='91' }">disabled</c:if>"/></td>
         	</tr>
         	<tr>
           		<td class="tdtitle">宽限天数:</td> 
				<td><input id="graceDays" name="graceDays" disabled value="${payApprOpinion.graceDays}" size="30"/></td>
           		<td class="tdtitle">还款期次:</td>
				<td><input id="scheduleTimes" name="scheduleTimes" disabled value="${payApprOpinion.scheduleTimes}" size="30"/></td> 
         	</tr>
         	<tr>
           		<td class="tdtitle">支付通道:</td> 
				<td><select id="payChannel" name="payChannel">
					<c:forEach items="${payChannelList}" var="obj">
						<option value="${obj.itemNo}">${obj.itemName}</option>
					</c:forEach>
				</select></td>
           		<td>&nbsp;</td>
				<td>&nbsp;</td> 
         	</tr>
        </table>
	</fieldset>
	</td></tr>
	</table>
</div>
	<div region="south" border="false" style="text-align: center;">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="excuteTransfer()" iconCls="icon-ok" <c:if test="${transferStatus eq '10'}">disabled</c:if>>确认支付</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a id="btnEp" href="javascript:void(0)" class="easyui-linkbutton" onclick="colseSubmitPayment()" icon="icon-back" >返回</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
<script type="text/javascript" src='<%=request.getContextPath()%>/js/common_uiext.js'></script>
<script type="text/javascript">
	// 行政区域级联查询
	function selectDivision(provId,oCity,oCountry){
		var city = oCity.combobox({  
	        disabled:false,  
	        url:'<%=request.getContextPath()%>/provinceCity/getCity.do?itemNo='+provId,  
	        valueField:'itemNo',  
	        textField:'itemName',  
	        onLoadSuccess:function(data){ //第2选中  
	            var combobox = oCity.combobox('getData'); 
	            oCity.combobox('setText',combobox[0].itemName).combobox('setValue',combobox[0].itemNo);  
	        },  
	        onChange:function(newValue, oldValue){
	            if(newValue != ""){  
	                //刷新数据，重新读取省份下的城市，并清空当前输入的值  
	               oCountry.combobox({  
	                    disabled:false,  
	                    url:'<%=request.getContextPath()%>/provinceCity/getDistrict.do?itemNo='+newValue,  
	                    valueField:'itemNo',  
	                    textField:'itemName',  
	                    onLoadSuccess:function(){ //第2选中  
	                        var combobox = oCountry.combobox('getData');  
	                        oCountry.combobox('setText',combobox[0].itemName).combobox('setValue',combobox[0].itemNo);  
	                    }  
	                });//.combobox('clear');  
	            }  
	        }  
	    });//.combobox('clear');
	}
	
	// 联行号查询
	function queryBankNo(){
		var bankNo = $('#insertBankName').combobox('getValue');
		var province =  $('#insertPosCustProSelect').combobox('getValue');
		var city =  $('#insertPosCustCitySelect').combobox('getValue');
		var bankName = $('#insertPosCustDetailBankName').val();
		var reqUrl = "<%=request.getContextPath()%>/bank/queryBankNo.do";
		if(bankNo == null || "" == bankNo){
			alert("开户行不能为空，请选择");
			return;
		}
		if(province == null || "" == province){
			alert("开户行所在省份不能为空，请选择");
			return;
		}
		if(city == null || "" == city){
			alert("开户行所在市不能为空，请选择");
			return;
		}
		$.post(reqUrl, {
			bankNo : bankNo,
			province : province,
			city : city,
			bankName : bankName
		}, function(data) {
			$('#cnapsBankInfo').empty();
			var bankInfoSet = data.rows;
			var length = bankInfoSet.length;
			var ptcptnmAcct = '';
			var bkcd = '';
			 if(length != null && length > 0){
				 for(var i=0;i<length;i++){
					bkcd = bankInfoSet[i].cnaps;
					ptcptnmAcct = bankInfoSet[i].cnapsName;
					// 动态添加查询行号结果（名称+行号）
					$('#cnapsBankInfo').append('<option value="' + bkcd + '">' + '('+ bkcd +')' + ptcptnmAcct + '</option>'); 
				} 
			}else{
				alert('没有对应行号');
			} 
		},'json')

	}
</script>