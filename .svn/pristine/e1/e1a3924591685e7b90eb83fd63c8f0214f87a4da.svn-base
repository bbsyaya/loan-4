<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- 还款信息 -->
<div title="还款信息" style="padding: 20px; width: 90%">
	<table id="detailform" style="width:100%">
		<tr>
			<td>
				<fieldset style="padding: 5px; color: #333; border: #06c dashed 1px;">
					<legend class='dialog-label' style="color: #06c; font-weight: 800; background: #fff;">授信协议信息</legend>
					<table style="width: 100%;"><jsp:include page="contractInfo.jsp"></jsp:include></table>
				</fieldset>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>
				<fieldset style="padding: 5px; color: #333; border: #06c dashed 1px;">
					<legend class='dialog-label' style="color: #06c; font-weight: 800; background: #fff;">借据信息</legend>
					<table style="width: 100%;"><jsp:include page="receiptInfo.jsp"></jsp:include></table>
				</fieldset>
			</td>
		</tr>
		<!-- 当选择'发起还款'时 -->
		<c:if test="${mode=='create'}">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>
					<fieldset style="padding: 5px; color: #333; border: #06c dashed 1px;">
						<legend class='dialog-label' style="color: #06c; font-weight: 800; background: #fff;">还款信息</legend>
						<table style="width: 100%;"><jsp:include page="paybackApply.jsp"></jsp:include></table>
					</fieldset>
				</td>
			</tr>
		</c:if>
	</table>
</div>