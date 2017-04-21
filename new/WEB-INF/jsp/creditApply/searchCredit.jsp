<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="tb" style="padding:5px;height:auto">
	<fieldset>
	<legend class='dialog-label'>
		<img class="filterPlus" src="../img/1x1.gif" width="1" height="1" id="filterIconPlus" onClick="showFilterArea()">
		<img class="filterMinus" src="../img/1x1.gif" width="1" height="1" id="filterIconMinus" onClick="hideFilterArea()">
		查询条件
	</legend>
	<div id="filterArea" style="padding:3px">
		<!-- 
		<span>申请流水号:</span>
		<input id="searchLoanId" name="searchLoanId" style="line-height:20px;border:1px solid #ccc"/> -->
		<span>申请编号:</span>
		<input id="searchBizLoanId" name="searchBizLoanId" style="line-height:20px;border:1px solid #ccc"/>
		<span>商户名称:</span>
		<input id="searchPosCustName" name="searchPosCustName" style="line-height:20px;border:1px solid #ccc"/>
		<br/><br/>
		<!-- <span>客户编号:</span>
		<input id="searchCustId" name="searchCustId" style="line-height:20px;border:1px solid #ccc"/> -->
		<span>客户姓名:</span>
		<input id="searchCustName" name="searchCustName" style="line-height:20px;border:1px solid #ccc"/>
		<span>客户证件号:</span>
		<input id="searchPaperId" name="searchPaperId" style="line-height:20px;border:1px solid #ccc"/>
		<br/><br/>
		<span>推荐机构:</span>
		<input id="searchRecOrg" name="searchRecOrg" style="line-height:20px;border:1px solid #ccc"/>
		<span>推荐人:</span>
		<input id="searchRecPerson" name="searchRecPerson" style="line-height:20px;border:1px solid #ccc"/>
		<!-- <span>业务状态:</span>
		<select id="searchApplyStatus" name="searchApplyStatus">
			<option value="00">待处理</option>
		</select> -->
		<br/><br/>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="executeQeury()" iconCls="icon-search" plain="true">查询</a>
		&nbsp;&nbsp;<a href="javascript:void(0)"  onclick="queryBlank()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">重置</a>
	</div>
	</fieldset>
	<div id="tb">  
	<c:if test="${applyStatus == '00'}">
	    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" onclick="openCreditApply()">新增申请</a>&nbsp;&nbsp;
	    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" onclick="submitCreditApply()">提交审批</a>&nbsp;&nbsp;
	    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" onclick="deleteCreditApply()">取消申请</a>&nbsp;&nbsp;
    </c:if>
    <c:if test="${applyStatus == '10'}">
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" onclick="openDetailApply()">申请详情</a>&nbsp;&nbsp;
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" onclick="interfaceProces()">手动执行接口处理</a>&nbsp;&nbsp;
	    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="submitCreditApplyApproval()">提交资料审核</a>&nbsp;&nbsp;
    </c:if>
    <c:if test="${empty applyStatus}">
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" onclick="openDetailApply()">申请详情</a>&nbsp;&nbsp;
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" onclick="executeApproval()">审批详情</a>&nbsp;&nbsp;
    </c:if>
    <c:if test="${applyStatus == '90'}">
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" onclick="openDetailApply()">申请详情</a>&nbsp;&nbsp;
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" onclick="executeApproval()">审批详情</a>&nbsp;&nbsp;
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" onclick="openReconsiderWindow()">申请复议</a>&nbsp;&nbsp;
    </c:if>
    <c:if test="${applyStatus == '92'}">
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" onclick="openDetailApply()">申请详情</a>&nbsp;&nbsp;
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" onclick="executeApproval()">审批详情</a>&nbsp;&nbsp;
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" onclick="openReconsiderWindow()">申请复议</a>&nbsp;&nbsp;
    </c:if>
    <c:if test="${applyStatus == '93'}">
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" onclick="openDetailApply()">申请详情</a>&nbsp;&nbsp;
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" onclick="">审批意见</a>&nbsp;&nbsp;
    </c:if>
    </div>
</div> 