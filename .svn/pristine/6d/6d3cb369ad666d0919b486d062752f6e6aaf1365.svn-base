<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<!--签署意见-->
    <div id="signSubmitWindow" class="easyui-window" collapsible="false" minimizable="false" closed="true"
        maximizable="true" icon="icon-save"  style="width: 1000px; height: 500px; padding: 5px; background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" class="easyui-tabs" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <div title="审批意见" style="padding:20px;">
                	<input type="hidden" id="appNum" name="appNum" />
                	<% String privileges = (String)session.getAttribute("assignedPrivileges"); %>
                	<% if(privileges!=null && (privileges.indexOf("ROLE_APPR_LV1;")>=0 || 
			                					privileges.indexOf("ROLE_APPR_LV2;")>=0 || 
			                					privileges.indexOf("ROLE_APPR_LV3;")>=0 || 
			                					privileges.indexOf("ROLE_APPR_LV4;")>=0 ||
			                					privileges.indexOf("ROLE_DUE_DILI_ADMIN;")>=0)) {%>
                	<table id="modeCheckRezult">
                		<tr>
                			<td align="right">币种:</td>
                			<td><input type="text" id="currSignName" name="currSignName" readonly="readonly" style="border:0"/></td>
                			<td align="right">还款方式:</td>
                			<td><input type="text" id="returnKindName" name="returnKindName" readonly="readonly" style="border:0"/></td>
                		</tr>
                		<tr>
                			<td align="right">模型授信额度（元）:</td>
                			<td><input type="text" id="modeAmount" name="modeAmount" readonly="readonly" style="border:0"/></td>
                			<td align="right">模型利率（%）:</td>
                			<td><input type="text" id="modeRate" name="modeRate" readonly="readonly" style="border:0"/></td>
                		</tr>
                		<tr>
                			<td align="right">风险等级:</td>
                			<td><input type="text" id="riskLevel" name="riskLevel" readonly="readonly" style="border:0"/></td>
                			<td align="right">模型提醒:</td>
                			<td><input type="text" id="modeWarn" name="modeWarn" readonly="readonly" style="border:0"/></td>
                		</tr>
                		<tr>
                			<td width="150px" align="right">*批准金额:</td>
                			<td width="150px"><input type="text" id="apprAmount" name="apprAmount" size="17"/>元</td>
                			<td width="150px" align="right">*批准利率:</td>
                			<td width="150px"><input type="text" id="apprInte" name="apprInte" size="11"/>%</td>
                		</tr>
                		</table>
                		<% } %>
                		<table>
                		<tr height="40px">
                			<td width="150px" align="right">审批意见:</td>
                			<td colspan="3">
                				<input type="radio" id="apprResult01" name="apprResult" value="10"><label id="apprResult01L" style="cursor:pointer" for="apprResult01">通过</label>&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" id="apprResult02" name="apprResult" value="20"><label id="apprResult02L" style="cursor:pointer" for="apprResult02">拒绝</label>&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" id="apprResult06" name="apprResult" value="50"><label id="apprResult06L" style="cursor:pointer" for="apprResult06">下一阶段</label>&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" id="apprResult03" name="apprResult" value="30"><label id="apprResult03L" style="cursor:pointer" for="apprResult03">回退前手</label>
								<select id="backToInfos" class="easyui-combobox">
								</select>&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" id="apprResult04" name="apprResult" value="31"><label id="apprResult04L" style="cursor:pointer" for="apprResult04">退回补件</label>&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" id="apprResult05" name="apprResult" value="40"><label id="apprResult05L" style="cursor:pointer" for="apprResult05">展开尽调</label>
							</td>
                		</tr>
                		<tr>
                			<td align="right">意见详情（内部）:</td>
                			<td colspan="3"><textarea id="apprInfo" name="apprInfo" cols="60" rows="5"></textarea></td>
                		</tr>
                		<tr>
                			<td align="right">意见详情（外部）:</td>
                			<td colspan="3"><textarea id="apprInfoExt" name="apprInfoExt" cols="60" rows="5"></textarea></td>
                		</tr>
                		<tr height="60px">
                			<td colspan="4" align="center">
		    					<% if(privileges!=null && (privileges.indexOf("ROLE_APPR_LV1;")>=0 || 
									    					privileges.indexOf("ROLE_APPR_LV2;")>=0 || 
									    					privileges.indexOf("ROLE_APPR_LV3;")>=0 || 
									    					privileges.indexOf("ROLE_APPR_LV4;")>=0 ||
									    					privileges.indexOf("ROLE_DUE_DILI_ADMIN;")>=0)) {%>
			                	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="openBlackListForReviewWindow()">添加为黑名单</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			                	<% } %>
			                	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="saveSignInfo(0)">&nbsp;&nbsp;保存&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			                	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="saveSignInfo(1)">&nbsp;&nbsp;提交&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			                	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="closeSignSubmitWindow()">&nbsp;&nbsp;关闭&nbsp;&nbsp;</a>
                			</td>
                		</tr>
                	</table>
                </div>
            	<% if(privileges!=null && (privileges.indexOf("ROLE_APPR_LV1;")>=0 || 
            								privileges.indexOf("ROLE_APPR_LV2;")>=0 ||
            								privileges.indexOf("ROLE_APPR_LV3;")>=0 ||
            								privileges.indexOf("ROLE_APPR_LV4;")>=0 ||
            								privileges.indexOf("ROLE_DUE_DILI_ADMIN;")>=0)) {%>
	                <%-- <jsp:include page="riskCheckResult.jsp"/> --%>
	                <jsp:include page="riskDetection.jsp"/>
               	<% } %>
            	<% if(privileges!=null && privileges.indexOf("ROLE_DUE_DILI_ADMIN;")>=0) {%>
                	<jsp:include page="dueDiligence.jsp"/>
               	<% } %>
            </div>
        </div>
    </div>