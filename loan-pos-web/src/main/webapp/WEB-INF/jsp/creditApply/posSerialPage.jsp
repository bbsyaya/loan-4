<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<form action="<%=request.getContextPath()%>/navigation/uploadPosSerial.do"
		method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td style="padding-left:5px">
					<input id="container"  name="container" type="hidden" value="${container}"/>
					<input id="loanId"  name="loanId" type="hidden" value="${loanId}"/>请选择渠道:</td>
				<td style="padding-left:5px">
					<select id="posChannel" name="posChannel" onchange="showImplType()">
					<option value="UP">银联</option>
					<option value="YB">易宝</option>
					<option value="KQ">快钱</option>
					<option value="CY">四川烟草</option>
					</select>
				</td>
				<td style="padding-left:5px">请选择类型:</td>
				<td style="padding-left:5px">
					<select id="posType"  name="posType">
						<option value="1">日明细</option>
						<option value="4">月汇总</option>
					</select>
				</td>
				<td style="padding-left:5px">
					请选择上传文件:</td><td style="padding-left:5px"><input id="uploadFile" type="file" name="uploadFile" />&nbsp;&nbsp;<input type="submit" onClick="window.parent.showProcess('上传POS流水');" value="上传" />
				</td>
			<c:if test="${not empty result}">
					<c:if test="${result == '上传成功'}">
						<td colspan="3"style="color: green;padding-left:5px">提示:&nbsp;${result}</td>
						<c:if test="${not empty container}">	
							<script type="text/javascript">
								window.parent.reloadPOSData("#${container}",'${loanId}');
								window.parent.hideProcess();
							</script>
						</c:if>
					</c:if>
					<c:if test="${result != '上传成功'}">
						<td colspan="3"style="color: red;padding-left:5px">提示:&nbsp;${result}</td>
					</c:if>
					<script type="text/javascript">
						window.parent.hideProcess();
					</script>
			</c:if>
			</tr>
		</table>
	</form>
</body>
</html>
<script type="text/javascript">
	var implType= {"UP":[{"id":"1","text":"日明细"},{"id":"4","text":"月汇总"}],"YB":[{"id":"1","text":"日明细"}],"KQ":[{"id":"1","text":"日明细"}],"UM":[{"id":"4","text":"月汇总"}],"CY":[{"id":"1","text":"日明细"}]};
	function showImplType(){
		var channel = document.getElementById("posChannel"); 
		var posType = document.getElementById("posType"); 
		posType.innerHTML="";
		//generate options
		var options = implType[channel.value];
		for(var i=0; i<options.length; i++){
			var opt = document.createElement("OPTION");
			opt.value = options[i]["id"];
			opt.text = options[i]["text"];
			posType.add(opt);
		}
	}
</script>