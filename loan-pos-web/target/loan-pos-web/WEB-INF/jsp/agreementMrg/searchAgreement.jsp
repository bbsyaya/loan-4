<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="tb" style="padding:5px;height:auto">  
	<div id="tb" style="padding:3px">
	<fieldset>
	<legend class='dialog-label'>查询条件</legend>
	<table width="800" border="0" cellspacing="1" cellpadding="0">
	  <tr>
	    <td width="90">合同编号:</td>
	    <td width="180"><input id="searchContNo" name="searchContNo" style="line-height:20px;border:1px solid #ccc"/></td>
	    <td width="90">商户名称:</td>
	    <td width="180"><input id="searchPosCustName" name="searchPosCustName" style="line-height:20px;border:1px solid #ccc"/></td>
	    <!-- 
	    <td width="90">客户编号:</td>
	    <td width="180"><input id="searchCustId" name="searchCustId" style="line-height:20px;border:1px solid #ccc"/></td>
	     -->
	    <td width="90">&nbsp;</td>
	    <td width="180">&nbsp;</td>
	  </tr>
	  <tr>
	    <td width="90">客户姓名:</td>
	    <td width="180"><input id="searchCustName" name="searchCustName" style="line-height:20px;border:1px solid #ccc"/></td>
	    <td width="90">客户证件号:</td>
	    <td width="180"><input id="searchPaperId" name="searchPaperId" style="line-height:20px;border:1px solid #ccc"/></td>
	    <!--  -->
	    <td width="90">&nbsp;</td>
	    <td width="180">&nbsp;</td>
	  </tr>
	  <tr>
	    <td colspan="6" align="right">
	    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="executeQeury()">查询</a>&nbsp;&nbsp;
	    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="queryBlank()">清空</a>&nbsp;&nbsp;
	    </td>
	  </tr>
	</table>
	</fieldset>
	</div>
	
	<div id="tb">
    <c:if test="${agreementStatus == '06'}">
      <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" onclick="openSignReply()">发起签约</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" onclick="queryAgreementDetail()">协议详情</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-undo" id="btnResignAgrmt" onclick="resignAgrmt()">退回重签</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="modifyAgreement(4)">协议生效</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" onclick="openChangeBankCard()">更换银行卡</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <% com.hrbb.loan.web.security.entity.AccessPrivilege access = (com.hrbb.loan.web.security.entity.AccessPrivilege) session.getAttribute("accessPrivilege");%>
        <%if(access.hasAnyPrivilege("ROLE_CONTRACT_ADMIN")){		//合同管理员权限%>
          <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-redo" onclick="generatePdf()">生成协议pdf</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <%} %>
    </c:if>
    <c:if test="${agreementStatus == '01'}">
	    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit"  onclick="queryAgreementDetail()">协议详情</a>&nbsp;&nbsp;&nbsp;&nbsp;
	    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-tip"  onclick="openFreeAgreement()">协议冻结</a>&nbsp;&nbsp;&nbsp;&nbsp;
	    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-filter"  onclick="openModifyAgreement()">协议调整</a>&nbsp;&nbsp;&nbsp;&nbsp;
	    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"  onclick="modifyAgreement(8)">协议中止</a>&nbsp;&nbsp;&nbsp;&nbsp;
    </c:if>
    <c:if test="${agreementStatus == '02'}">
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit"  onclick="queryAgreementDetail()">协议详情</a>&nbsp;&nbsp;&nbsp;&nbsp;
	    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload"  onclick="openUnFreezeAgreement()">协议解冻</a>&nbsp;&nbsp;&nbsp;&nbsp;
    </c:if>
    <c:if test="${agreementStatus == '09'}">
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit"  onclick="queryAgreementDetail()">协议详情</a>&nbsp;&nbsp;&nbsp;&nbsp;
    </c:if>
    <c:if test="${agreementStatus == '03'}">
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit"  onclick="queryAgreementDetail()">协议详情</a>&nbsp;&nbsp;&nbsp;&nbsp;
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-redo"  onclick="agreementActive()">协议激活</a>&nbsp;&nbsp;&nbsp;&nbsp;
    </c:if>
    <c:if test="${agreementStatus == '99'}">
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit"  onclick="queryAgreementDetail()">协议详情</a>&nbsp;&nbsp;&nbsp;&nbsp;
    </c:if>
    </div>
	</div> 
