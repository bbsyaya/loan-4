<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.tdtitle {
	background-color: #E0ECFF;
	height: 25px;
	width: 120px;
}

td {
	border-style: none;
}
</style>
<!-- 公安信息 -->
<div title="公安信息" style="padding: 20px;">
	<fieldset
		style="padding: 5px; color: #333; border: #06c dashed 1px; width: 800px;">
		<legend class='dialog-label'
			style="color: #06c; font-weight: 800; background: #fff;">简项信息</legend>
		<table width="100%">
			<tr>
				<td>
					<table>
						<tr>
							<td class="tdtitle">证件名称</td>
							<td><input readonly value="居民身份证" /></td>
							<td class="tdtitle">姓名</td>
							<td><input value="${policeInfo.policeCustName}" readonly /></td>
						</tr>
						<tr>
							<td class="tdtitle">证件号码</td>
							<td><input readonly value="${policeInfo.policeIdNo}" /></td>
							<td class="tdtitle">性别</td>
							<td><input readonly value="${policeInfo.sexSign}" /></td>
						</tr>
						<tr>
							<td class="tdtitle">出生日期</td>
							<td><input readonly value="${policeInfo.birthDate}" /></td>
							<td class="tdtitle">名族</td>
							<td><input readonly value="${policeInfo.nation}" /></td>
						</tr>
						<tr>
							<td class="tdtitle">文化程度</td>
							<td><input readonly value="${policeInfo.eduSign}" /></td>
							<td class="tdtitle">籍贯</td>
							<td><input readonly value="${policeInfo.nativePlace}" /></td>
						</tr>
						<tr>
							<td class="tdtitle">婚姻状况</td>
							<td><input readonly value="${policeInfo.mariSign}" /></td>
							<td class="tdtitle">出生所在地</td>
							<td><input readonly value="${policeInfo.birthPlace}" /></td>
						</tr>
						<tr>
							<td class="tdtitle">服务场所</td>
							<td><input readonly value="${policeInfo.servPlace}" /></td>
							<td class="tdtitle">查询日期</td>
							<td><input readonly
								value="<fmt:formatDate value='${policeInfo.queryTime}' pattern='yyyy-MM-dd'/>" /></td>
						</tr>
					</table>
				</td>
				<td><img src="data:image/jpg;base64,${policeInfo.photo}"
					style="height: 180px" /></td>
			</tr>
		</table>
	</fieldset>
	<p></p>
	<fieldset style="padding: 5px; color: #333; border: #06c dashed 1px; width: 800px;">
		<legend class='dialog-label'
			style="color: #06c; font-weight: 800; background: #fff;">认证结果</legend>
		<table width="100%">
			<tr>
				<td align="center">${policeInfo.result}</td>
			</tr>
		</table>
	</fieldset>
</div>
