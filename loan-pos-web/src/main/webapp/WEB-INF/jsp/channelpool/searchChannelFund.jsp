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
	<table width="800" border="0" cellspacing="1" cellpadding="0">

	  <tr>
	    <td width="90">户名:</td>
	    <td width="180">
	    	<input type="text" id="acctName" name="acctName"/>
		</td>
	    <td width="90">&nbsp;</td>
	    <td width="180">&nbsp;</td>
	    <td width="90">账户:</td>
	    <td width="180">
	    	<input type="text" id="account" name="account"/>
	    </td>
	  </tr>
		<!-- <span>业务状态:</span>
		<select id="searchApplyStatus" name="searchApplyStatus">
			<option value="00">待处理</option>
		</select> -->
	  <tr>
	    <td colspan="6" align="center">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="queryChannelFund()" iconCls="icon-search" plain="true">查询</a>&nbsp;&nbsp;
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="queryBlank()" iconCls="icon-search" plain="true">清空</a>&nbsp;&nbsp;
		</td>
	  </tr>
	  </table>
	</div>
	</fieldset>
</div> 