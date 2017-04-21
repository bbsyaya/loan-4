<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="ta" style="padding:5px;height:auto">  
   <fieldset>
   <legend class='dialog-label'>
		<img class="filterPlus" src="../img/1x1.gif" width="1" height="1" id="filterIconPlus" onClick="showFilterArea()">
		<img class="filterMinus" src="../img/1x1.gif" width="1" height="1" id="filterIconMinus" onClick="hideFilterArea()">
		查询条件
	</legend>
	<div id="filterArea" style="padding:3px">
		<span>合同编号:</span>
		<input id="contNoLike" name="contNoLike" style="line-height:20px;border:1px solid #ccc"/>
		<span>商户名称:</span>
		<input id="posCustNameLike" name="posCustNameLike" style="line-height:20px;border:1px solid #ccc"/>
		<br/><br/>
		<span>客户名称:</span>
		<input id="custNameLike" name="custNameLike" style="line-height:20px;border:1px solid #ccc"/>
		<span>客户证件号:</span>
		<input id="paperIdLike" name="paperIdLike" style="line-height:20px;border:1px solid #ccc"/>
		<br/><br/>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="queryAvailableAgreements()" iconCls="icon-search" plain="true">查询</a>
		&nbsp;&nbsp;<a href="javascript:void(0)"  onclick="queryAvailableAgreementsBlank()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">重置</a>
	</div>
   </fieldset>
   <!-- 
   <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="insertPaymentApply()">新增用款申请</a> -->
</div> 
