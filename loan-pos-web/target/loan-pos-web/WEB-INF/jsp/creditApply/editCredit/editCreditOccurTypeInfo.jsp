<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tr>
	<td style="width: 100%;" colspan="4">
		<c:forEach items="${occurTypes}" var="obj">
			<input id="${obj.itemNo}" name="editOccurType" type="radio" 
			class="easyui-validatebox" value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[0].occurType}">checked</c:if>>${obj.itemName}
		</c:forEach>
	</td>
</tr>

