<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/p_validator.js"></script>
	<!--复审登录
    <div id="reviewNoteWindow" class="easyui-window"  title="复审照会记录登录" collapsible="false" minimizable="false" closed="true"
        maximizable="true" icon="icon-save"  style="width: 1000px; height: 500px; padding: 5px; background: #fafafa;">-->
		<div id="reviewNoteWindow" class="easyui-layout" fit="true">
			<%
				String applyStatus = request.getParameter("applyStatus");
				if(!"90".equals(applyStatus)&&!"92".equals(applyStatus)){
			%>
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="addReviewNote()" iconCls="icon-add" plain="true">保存</a>
			<%}%>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="closeReviewNoteWindow()" iconCls="icon-cancel" plain="true">关闭</a>
			<br/><br/>
			<table>
				<tr>
					<td>照会电话类型:</td>
					<td width="150">
					<select id="rn_teltype" class="easyui-combobox" editable=false data-options="width:150,panelHeight:150,onChange:function (n,o){fillFields(n);}">
						<c:forEach items="${NoticePhones}" var="obj">
							<option value="${obj.itemNo}" <c:if test="${obj.itemNo == reviewNote.teltype}">selected</c:if>>${obj.itemName}</option>
						</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>照会电话号码:</td>
					<td><input type="text" id="rn_tel" name="rn_tel" maxlength="20" value="${reviewNote.tel}"/></td>
				</tr>
				<tr>
					<td>照会对象:</td>
					<td><select id="rn_relationtype" class="easyui-combobox" editable=false data-options="width:150,panelHeight:150">
						<c:forEach items="${Relatives}" var="obj">
							<option value="${obj.itemNo}"  <c:if test="${obj.itemNo == reviewNote.relationtype}">selected</c:if>>${obj.itemName}</option>
						</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>核实结果:</td>
					<td>
						<input type="radio" id="rn_result01" name="rn_result" value="01" <c:if test="${'01' == reviewNote.result}">checked</c:if> ><label style="cursor:pointer" for="rn_result01">核实正常</label>
						<input type="radio" id="rn_result02" name="rn_result" value="02" <c:if test="${'02' == reviewNote.result}">checked</c:if> ><label style="cursor:pointer" for="rn_result02">核实异常</label>
					</td>
				</tr>
				<!-- 
				<tr>
					<td>照会日期:</td>
					<td><input type="text" id="rn_reviewday" name="rn_reviewday" style="line-height:20px;border:1px solid #ccc" class="easyui-datebox"/></td>
				</tr>
				 -->
				<tr>
					<td>情况说明:</td>
					<td><textarea id="rn_note" name="rn_note" cols="45" rows="8">${reviewNote.note}</textarea></td>
				</tr>
				<tr><td>
				<input type="hidden" id="peopleBankPhone" name="peopleBankPhone" value="${peopleBankPhone}"/>
				<input type="hidden" id="mobilePhone" name="mobilePhone" value="${mobilePhone}"/>
				<input type="hidden" id="tel" name="tel" value="${tel}"/>
				<input type="hidden" id="mateMobilephone" name="mateMobilephone" value="${mateMobilephone}"/>
				<input type="hidden" id="relaMobilePhone" name="relaMobilePhone" value="${relaMobilePhone}"/>
				<input type="hidden" id="relaTel" name="relaTel" value="${relaTel}"/>
				<input type="hidden" id="flag" name="flag" value="${flag}"/>
				<input type="hidden" id="reviewId" name="reviewId" value="${reviewId}"/>
				</td></tr>
			</table>
		</div>
<!-- </div> -->	
<script type="text/javascript">
	function fillFields(val2){
		if (val2 == '01'){
			$('#rn_tel').val($("#mobilePhone").val());
			$('#rn_relationtype').combobox('setValue','01');
		}else if (val2 == '02'){
			$('#rn_tel').val($("#peopleBankPhone").val());
			$('#rn_relationtype').combobox('setValue','01');
		}else if (val2 == '03'){
			$('#rn_tel').val($("#tel").val());
			$('#rn_relationtype').combobox('setValue','02');
		}else if (val2 == '04'){
			$('#rn_tel').val($("#mateMobilephone").val());
			$('#rn_relationtype').combobox('setValue','03');
		}else if (val2 == '05'){
			$('#rn_tel').val($("#relaMobilePhone").val());
			$('#rn_relationtype').combobox('setValue','99');
		}else{
			$('#rn_tel').val($("#relaTel").val());
			$('#rn_relationtype').combobox('setValue','99');
		}
	}
	
	function checkAddReviewNote(){
		if ($('#rn_tel').val()==''){
			alert("请输入照会电话号码！");
			return false;
		}
		if ($('#rn_relationtype').combobox('getValue')==''){
			alert("请选择照会对象！");
			return false;
		}
		/*
		var rn_reviewday = $('#rn_reviewday').datebox("getValue");
		if (rn_reviewday == ''){
			alert("请输入照会日期！");
			return false;
		}else if (rn_reviewday.length != 10){
			alert("照会日期输入有误！");
			return false;
		}else if (!isDate(rn_reviewday,"yyyy-MM-dd")){
			alert("照会日期输入有误！");
			return false;
		}
		*/
		var note = $("#rn_note").val();
		if (getTotalBytes(note) > 1000){
			alert("备注不能超过1000个字符！");
			return false;
		}
		return true;
	}
	//新增复审照会记录
	function addReviewNote() {
		if(!checkAddReviewNote()){
			return;
		}
	    var reqUrl = "<%=request.getContextPath()%>/reviewNote/insertReviewNote.do";
	    //var row = $('#t').datagrid('getSelected');
	    var loanId = $('#loanIdForReviewNote').val();
		$.post(reqUrl, 
			{loanid: loanId,
			 teltype: $('#rn_teltype').combobox("getValue"),
			 tel: $('#rn_tel').val(),
			 relationtype: $('#rn_relationtype').combobox('getValue'),
			 result: $("input[name='rn_result']:checked").val(),
		//	 reviewday: $('#rn_reviewday').datebox("getValue"),
			 note: $('#rn_note').val(),
			 flag: $('#flag').val(),
			 reviewId: $('#reviewId').val()
			}, 
			function(data){
				alert(data);
			    clearReviewNoteWindow();
				closeReviewNoteWindow();
		        queryReviewNote();
			}
		);
	}
	//删除复审照会记录
	function delReviewNote() {
		var rows = $('#tReviewNote').datagrid('getSelections');
		var length = rows.length;
		if (length == 0){
		    alert("请选择要删除的记录！");
		    return;
		}
	    var reqUrl = "<%=request.getContextPath()%>/reviewNote/deleteReviewNote.do";
	    //var row = $('#t').datagrid('getSelected');
	    var loanId = $('#loanIdForReviewNote').val();
		var reqStr = "";
		for(var i=0; i<length; i++){
			reqStr=reqStr+rows[i].reviewid+"|";
		}
		$.post(reqUrl, 
		    {loanid: loanId,
		    reviewids: reqStr}, 
		    function(data){
				alert(data);
				queryReviewNote();
		    }
		);
	}
</script>