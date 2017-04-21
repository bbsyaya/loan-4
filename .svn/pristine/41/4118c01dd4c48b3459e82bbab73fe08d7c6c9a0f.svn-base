<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="tb" style="padding:5px;height:auto">  
	<fieldset><legend class='dialog-label'>查询条件</legend>
	<div id="tb" style="padding:3px">
		<span>合同编号:</span>
		<input id="searchContNoLike" name="searchContNoLike" style="line-height:20px;border:1px solid #ccc"/>
		<span>商户名称:</span>
		<input id="searchPosCustNameLike" name="searchPosCustNameLike" style="line-height:20px;border:1px solid #ccc"/>
		<br/><br/>
		<span>客户名称:</span>
		<input id="searchCustNameLike" name="searchCustNameLike" style="line-height:20px;border:1px solid #ccc"/>
		<span>客户证件号:</span>
		<input id="searchPaperIdLike" name="searchPaperIdLike" style="line-height:20px;border:1px solid #ccc"/>
		<br/><br/>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="executeQeury()" iconCls="icon-search" plain="true">查询</a>
		&nbsp;&nbsp;
		<a href="javascript:void(0)"  onclick="queryBlank()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">重置</a>
		</div>
	</fieldset>
	<div id="tb">  
	<c:if test="${paymentStatus == '00'}">
	    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openCreatePaymentApply()">提起用款</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="detailPaymentApply()">申请详情</a>  
	    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="submitPaymentApply()">提交审核</a> 
    </c:if>
    <c:if test="${paymentStatus == '10'}">
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="detailPaymentApply()">申请详情</a>
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="cancelPaymentApply()">取消用款</a>
    </c:if>
    <c:if test="${paymentStatus == '90' and excuteStatus == '0'}">
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="detailPaymentApply()">申请详情</a>
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="">调整申请</a>
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="cancelPaymentApply()">取消用款</a>
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="excutePayment()">发送用款指令</a>
    </c:if>
     <c:if test="${paymentStatus == '90' and excuteStatus == '1'}">
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="detailPaymentApply()">申请详情</a>
    </c:if>
    <c:if test="${paymentStatus == '92'}">
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="detailPaymentApply()">申请详情</a>
    </c:if>
    <c:if test="${paymentStatus == '93'}">
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="detailPaymentApply()">申请详情</a>
    </c:if>
    </div>
    
</div> 
