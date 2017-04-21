<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<form action="<%=request.getContextPath()%>/navigation/uploadModelResult.do"
		method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td style="padding-left:5px">
					请选择上传文件:</td><td style="padding-left:5px"><input id="uploadFile" type="file" name="uploadFile" />&nbsp;&nbsp;<input type="submit" value="上传" />
				</td>
			<c:if test="${not empty result}">
				<td colspan="3"style="color: red;padding-left:5px">提示:&nbsp;${result}</td>
			</c:if>
			</tr>
		</table>
	</form>
</body>
</html>