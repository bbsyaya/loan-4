<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	function selectCity(obj){
		var reqUrl = "<%=request.getContextPath()%>/provinceCity/getCity.do";
		var province = $(obj).val();
		$('#sel2').empty();
		$('#sel2').append("<option value=''>--请选择--</option>");
		$.post(reqUrl, {itemNo : province}, function(data){
			var obj2 = eval("("+data+")");
			for(var i=0; i<obj2.length; i++){
				$('#sel2').append("<option value="+obj2[i].itemNo+">"+obj2[i].itemName+"</option>");
			}
		});
	}
</script>
</head>
<body>
	<table>
		<tr>
			<td>
				<select id="sel1" name="sel2" onchange="selectCity(this)">
					<option value="">--请选择--</option>
					<c:forEach items="${testPro}" var="obj">
						<option value="${obj.itemNo}">
							${obj.itemName}
						</option>
					</c:forEach>
				</select>
			</td>
				
			<td>
				<select id="sel2" name="sel2">
					<option value="">--请选择--</option>
				</select>
			</td>
		</tr>
	</table>
</body>
</html>