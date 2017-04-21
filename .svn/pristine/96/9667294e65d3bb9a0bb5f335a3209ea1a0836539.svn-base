<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div id="paymentSignWindow" class="easyui-window"  title="签署意见" collapsible="false" minimizable="false" closed="true"
        maximizable="true" icon="icon-save"  style="width: 600px; height: 300px; padding: 5px; background: #fafafa;">
                	<input id="payApplyIdSign" type="hidden" name="payApplyIdSign"/>
                	<table width="100%" style="padding-left:20px">
                		<tr>
                		    <td>客户名称:</td><td><input type="text" id="custName" readonly="readonly" class="custName" /></td>
                			<td>商户名称:</td><td><input type="text" id="posCustName" readonly="readonly" class="posCustName" /></td> 
                		</tr>
                		<tr>
                		<td>用款金额:</td><td><input type="text" id="payApplyAmt" name="payApplyAmt" /></td> 
                		<td>用款利率:</td><td><input id="payApplyInterest" name="payApplyInterest" value="${payApplyInterest}"/></td>
                		</tr>
                		<tr>
                		<td>用款期限:</td><td><input type="text" id="payApplyTerm" name="payApplyTerm" /></td>
                		<td>还款方式:</td>
								<td><input id="returnType" name="returnType" /></td>
                		</tr>
                		<tr>
                        <td>期望用款日期:</td>
						<td><input id="expectedDate" name="expectedDate" value='<fmt:formatDate value='${paymentApply.expectedDate}' pattern='yyyy-MM-dd'/>'/></td>
                		<td>用款到期日:</td>
						<td><input id="expectedEndDate" name="expectedEndDate" value='<fmt:formatDate value='${paymentApply.expectedEndDate}' pattern='yyyy-MM-dd'/>' /></td> 
                		</tr>
                		<tr><td colspan="4">
                		<fieldset style="padding:0; color:#333; border:#06c dashed 1px;width:94%" >
						<legend style="color:#06c; font-weight:800; background:#fff;"></legend>
						<table>
                		<tr>
                		<td>开户行名称:</td>
           				<td><input id="ptcptnm" name="ptcptnm" /></td>
                		<td colspan="2"><a style="padding-left: 10px" href="javascript:void(0)" class="easyui-linkbutton" onclick="queryBankNoByBankName()" iconCls="icon-search" plain="true">行号查询</a></td>
                		</tr>
                		<tr>
                		<td>查询结果:</td>
                		<td colspan="3"><select id="bankInfo" style="width:300px"></select>
               				</td></tr></table>
                		</fieldset>
                		</td></tr>
                		<tr>
                		<td>审批意见:</td>
                		<td colspan="3">
                			<input type="radio" name="approvalStatus" id="approvalStatus1" class="approvalStatus" value="1" checked="checked"/>同意
                			<input type="radio" name="approvalStatus" id="approvalStatus2" class="approvalStatus" value="2"/>不同意
                		</td>
                		</tr>
                		<tr>
                		<td>意见详情</td>
                		<td colspan="3">
                			<input name="approvalContent" id="approvalContent"/>
                		</td>
                		</tr>
                	</table>
                	<br/><br/>
                	<div style="text-align: center">
                	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="savePaymentSign()" iconCls="icon-save" plain="true">保存</a>
					&nbsp;&nbsp;
					<a href="javascript:void(0)"  onclick="submitPaymentSign()" class="easyui-linkbutton" iconCls="icon-save" plain="true">提交</a>
					</div>
                </div>