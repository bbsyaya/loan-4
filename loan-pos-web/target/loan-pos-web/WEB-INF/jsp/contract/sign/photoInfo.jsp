<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <div title="影像材料" style="padding:20px;">
                	<table>
                		<tr>
                			<td>配偶姓名:<input type="text" id="insertFamilyCustName" name="insertFamilyCustName"/></td>
                			<td><input type="hidden" id="insertMatePaperKind" name="insertMatePaperKind">证件类型:<input type="text" value="身份证" readonly="readonly"/></td>
                			<td>证件号码:<input class="easyui-validtebox" validtype="idcard" type="text" id="insertMatePaperId" name="insertMatePaperId"/></td>
                		</tr>
                		<tr>
                			<td>出生日期:<input class="easyui-datebox" type="text" id="insertMateBirtDate" name="insertMateBirtDate"/></td>
                			<td>性别:<select id="insertMateSexSign" name="insertMateSexSign">
                				<option value="01">
                					男
                				</option>
                				<option value="02">
                					女
                				</option>
                			</select></td>
                			<td>手机号:<input class="easyui-validatebox" validType="mobilePhone" invalidMessage="请输入正确的手机号" type="text" id="insertMateMobilePhone" name="insertMateMobilePhone"></td>
                		</tr>
                	</table>
                </div>