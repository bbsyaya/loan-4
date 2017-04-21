<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head id="Head_native">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>我的任务</title>
    <link href="<%=request.getContextPath()%>/css/default.css" rel="stylesheet" type="text/css" />

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/icon.css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/locale/easyui-lang-zh_CN.js'></script>
<style type="text/css">
<!--
.taskNum {
	font-family: "微软雅黑,宋体;";
	font-size: xx-large;
}
.div_over{border:1px solid #999;}
.div_out{border:1px solid #fff;}
-->
</style>
    </head>
<body style="background-color:#FFFFFF ">
	<% //String privileges = (String)session.getAttribute("assignedPrivileges");
	com.hrbb.loan.web.security.entity.AccessPrivilege access = (com.hrbb.loan.web.security.entity.AccessPrivilege)session.getAttribute("accessPrivilege");
	%>
<table width="100%"  border="0" cellspacing="1" cellpadding="0">
<%if(access.hasAnyPrivilege("ROLE_INFO_APPR;ROLE_APPR_LV1;ROLE_APPR_LV2;ROLE_APPR_LV3")){%>
  <tr>
    <td width="12%" height="128"><img src="../img/super_mono_3d_part2_76.png" width="96" height="96"></td>
    <td width="88%"><div class="div_out" onMouseOver="this.className='div_over'" onMouseOut="this.className='div_out'" 
		style="cursor:pointer; min-height:64px; width:720px" onClick="javascript:redir2TaskTips1();">
   	<table width="100%" height="64"  border="0" cellpadding="0" cellspacing="1">
      <tr>
        <td width="10%" valign="top"><div align="center">共有</div></td>
        <td width="10%" valign="middle">
        	<div id="cntPool" align="center" class="taskNum">
        		<img src="../img/loading.gif" width="31" height="31">
        	</div>
        </td>
        <td width="30%" valign="bottom">笔待认领审批的业务申请</td>
        <td width="15%" valign="middle">&nbsp;</td>
        <td width="10%" valign="middle">&nbsp;</td>
        <td width="25%" valign="bottom">&nbsp;</td>
      </tr>
    </table>
	</div></td>
  </tr>
  <tr>
    <td width="12%" height="128"><img src="../img/super_mono_3d_part2_16.png" width="96" height="96"></td>
    <td width="88%"><div id="cntTodo" class="div_out" onMouseOver="this.className='div_over'" onMouseOut="this.className='div_out'" 
		style="cursor:pointer; min-height:64px; width:720px" onClick="javascript:redir2TaskTips1();">
		<img src="../img/loading.gif" width="31" height="31">
    </div></td>
  </tr>
  <script type="text/javascript">
	loadTaskTips1();
	function loadTaskTips1(){
		var reqUrl = "<%=request.getContextPath()%>/statistics/queryTaskTips1.do";
		$.post(reqUrl, {}, function(data){cntPool.innerHTML=data;}, 'text');
	}
	function redir2TaskTips1(){
		window.parent.addTab("当前工作","<%=request.getContextPath()%>/navigation/queryCreditApplyForReview.do?opflag=1","icon-min-edit");
	}
	loadTaskTips5();
	function loadTaskTips5(){
		var reqUrl = "<%=request.getContextPath()%>/statistics/queryTaskTips5.do";
		$.post(reqUrl, {}, function(data){cntTodo.innerHTML=data;}, 'text');
	}
</script>
<%} %>
<%if(access.hasAnyPrivilege("ROLE_APPROVED")){%>
  <tr>
    <td width="12%" height="128"><img src="../img/super_mono_3d_part2_03.png" width="96" height="96"></td>
    <td width="88%"><div class="div_out" onMouseOver="this.className='div_over'" onMouseOut="this.className='div_out'" 
		style="cursor:pointer; min-height:64px; width:720px" onClick="javascript:redir2TaskTips2();">
	<table width="100%" height="64" border="0" cellspacing="1" cellpadding="0">
      <tr>
        <td width="10%" valign="top"><div align="center">共有</div></td>
        <td width="10%" valign="middle">
        	<div id="cntAprv" align="center" class="taskNum">
        		<img src="../img/loading.gif" width="31" height="31">
        	</div>
        </td>
        <td width="30%" valign="bottom">份未确认审批结果</td>
        <td width="15%" valign="middle">&nbsp;</td>
        <td width="10%" valign="middle">&nbsp;</td>
        <td width="25%" valign="bottom">&nbsp;</td>
      </tr>
    </table>
	</div></td>
  </tr>
<script type="text/javascript">
	loadTaskTips2();
	function loadTaskTips2(){
		var reqUrl = "<%=request.getContextPath()%>/statistics/queryTaskTips2.do";
		$.post(reqUrl, {}, function(data){cntAprv.innerHTML=data;}, 'text');
	}
	function redir2TaskTips2(){
		window.parent.addTab("待确认批复","<%=request.getContextPath()%>/navigation/queryContractManagementNav1.do?approveStatus=01","icon-min-edit");
	}
</script>
<%} %>
<%if(access.hasAnyPrivilege("ROLE_CUSTSERVICE")){%>
  <tr>
    <td width="12%" height="128"><img src="../img/super_mono_3d_36.png" width="96" height="96"></td>
    <td width="88%"><div id="cntCallTask" class="div_out" onMouseOver="this.className='div_over'" onMouseOut="this.className='div_out'" 
		style="cursor:pointer; min-height:64px; width:720px" onClick="javascript:redir2TaskTips3();">
		<img src="../img/loading.gif" width="31" height="31">
    </div></td>
  </tr>
<script type="text/javascript">
	loadTaskTips3();
	function loadTaskTips3(){
		var reqUrl = "<%=request.getContextPath()%>/statistics/queryTaskTips3.do";
		$.post(reqUrl, {}, function(data){cntCallTask.innerHTML=data;}, 'text');
	}
	function redir2TaskTips3(){
		window.parent.addTab("待处理任务","<%=request.getContextPath()%>/navigation/queryCallingTaskForReview.do?opflag=1","icon-min-edit");
	}
</script>
<%} %>
<%if(access.hasAnyPrivilege("ROLE_POSTED")){%>
  <tr>
    <td><img src="../img/super_mono_3d_86.png" width="96" height="96"></td>
    <td><div id="cntMaturity" class="div_out" onMouseOver="this.className='div_over'" onMouseOut="this.className='div_out'" 
		style="cursor:pointer; min-height:64px; width:720px" onClick="javascript:redir2TaskTips4();">
		<img src="../img/loading.gif" width="31" height="31">
    </div>
    </td>
  </tr>
<script type="text/javascript">
	loadTaskTips4();
	function loadTaskTips4(){
		var reqUrl = "<%=request.getContextPath()%>/statistics/queryTaskTips4.do";
		$.post(reqUrl, {}, function(data){cntMaturity.innerHTML=data;}, 'text');
	}
	function redir2TaskTips4(){
		window.parent.addTab("未结清业务","<%=request.getContextPath()%>/navigation/unClearedBusiness.do?clearStatus=02","icon-min-edit");
	}
</script>
<%} %>
<%if(access.hasAnyPrivilege("ROLE_CONTRACT")){%>
  <tr>
    <td><img src="../img/super_mono_3d_part2_04.png" width="96" height="96"></td>
    <td><div id="cntAgrm" class="div_out" onMouseOver="this.className='div_over'" onMouseOut="this.className='div_out'" 
		style="cursor:pointer; min-height:64px; width:720px" onClick="javascript:redir2TaskTips6();">
		<img src="../img/loading.gif" width="31" height="31">
    </div></td>
  </tr>
<script type="text/javascript">
	loadTaskTips6();
	function loadTaskTips6(){
		var reqUrl = "<%=request.getContextPath()%>/statistics/queryTaskTips6.do";
		$.post(reqUrl, {}, function(data){cntAgrm.innerHTML=data;}, 'text');
	}
	function redir2TaskTips6(){
		window.parent.addTab("待处理协议","<%=request.getContextPath()%>/navigation/queryAgreeMentNavi.do?agreementStatus=06","icon-min-edit");
	}
</script>
<%} %>
<%if(access.hasAnyPrivilege("ROLE_ISSUE_APPR")){%>
  <tr>
    <td><img src="../img/super_mono_3d_part2_67.png" width="96" height="96"></td>
    <td><div id="cntIssApr" class="div_out" onMouseOver="this.className='div_over'" onMouseOut="this.className='div_out'" 
		style="cursor:pointer; min-height:64px; width:720px" onClick="javascript:redir2TaskTips7();">
		<img src="../img/loading.gif" width="31" height="31">
    </div></td>
  </tr>
<script type="text/javascript">
	loadTaskTips7();
	function loadTaskTips7(){
		var reqUrl = "<%=request.getContextPath()%>/statistics/queryTaskTips7.do";
		$.post(reqUrl, {}, function(data){cntIssApr.innerHTML=data;}, 'text');
	}
	function redir2TaskTips7(){
		window.parent.addTab("当前审核工作","<%=request.getContextPath()%>/navigation/queryPaymentReview.do?reviewStatus=0","icon-min-edit");
	}
</script>
<%} %>
<%if(access.hasAnyPrivilege("ROLE_APPLY")){%>
  <tr>
    <td><img src="../img/super_mono_3d_78.png" width="96" height="96"></td>
    <td><div id="cntFix" class="div_out" onMouseOver="this.className='div_over'" onMouseOut="this.className='div_out'" 
		style="cursor:pointer; min-height:64px; width:720px" onClick="javascript:redir2TaskTips8();">
		<img src="../img/loading.gif" width="31" height="31">
    </div></td>
  </tr>
<script type="text/javascript">
	loadTaskTips8();
	function loadTaskTips8(){
		var reqUrl = "<%=request.getContextPath()%>/statistics/queryTaskTips8.do";
		$.post(reqUrl, {}, function(data){cntFix.innerHTML=data;}, 'text');
	}
	function redir2TaskTips8(){
		//window.parent.addTab("当前审核工作","","icon-min-edit");
		alert("玩命开发中....请期待.");
	}
</script>
<%} %>
<%if(access.hasAnyPrivilege("ROLE_ISSUE")){%>
  <tr>
    <td><img src="../img/super_mono_3d_68.png" width="96" height="96"></td>
    <td><div id="cntIssue" class="div_out" onMouseOver="this.className='div_over'" onMouseOut="this.className='div_out'" 
		style="cursor:pointer; min-height:64px; width:720px" onClick="javascript:redir2TaskTips9();">
		<img src="../img/loading.gif" width="31" height="31">
    </div></td>
  </tr>
<script type="text/javascript">
	loadTaskTips9();
	function loadTaskTips9(){
		var reqUrl = "<%=request.getContextPath()%>/statistics/queryTaskTips9.do";
		$.post(reqUrl, {}, function(data){cntIssue.innerHTML=data;}, 'text');
	}
	function redir2TaskTips9(){
		window.parent.addTab("待放款","<%=request.getContextPath()%>/navigation/queryPaymentApplyNav.do?paymentStatus=90&excuteStatus=0","icon-min-edit");
	}
</script>
<%} %>
</table>
    </body>
 </html>