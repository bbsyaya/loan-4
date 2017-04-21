<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!--修改窗口-->
  <!--修改窗口
    <div id="modifyCustBankWindow" class="easyui-window" title="新增授信申请" collapsible="false" minimizable="false"
        maximizable="true" icon="icon-save"  style="width: 800px; height: 500px; padding: 5px;
        background: #fafafa;">
        <div class="easyui-layout" fit="true">-->
            <div region="center" class="easyui-tabs" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <div title="银行卡信息" style="padding:20px;">
                	<table>
						<tr>
                			<td> 开户行:</td>
							<td>
							<input type="hidden" id="bankAccno" name="bankAccno" readonly="readonly" value="${bankAccount.bankAccno }">
							<select	id="editbankName" name="editbankName" data-options="width:150" class="easyui-combobox" editable=false>
								<c:forEach items="${bankNoList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == bankAccount.bankName}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select>
							</td>
						</tr>
						<tr>
                		    <td>分行：</td>
                		    <td><input id="editbankBranName" name="editbankBranName" value="${bankAccount.bankBranName }"
                		    	class="easyui-validatebox" data-options="required:true"/></td>
						</tr>
						<tr>
                		    <td>支行：</td>
                		    <td><input id="editbankSubbName" name="editbankSubbName" value="${bankAccount.bankSubbName }"
                		    	class="easyui-validatebox" data-options="required:true"/></td>
 						<tr/>
 						<tr>
                		    <td>联行号：</td>
                		    <td><input id="editCdtbranchid" name="editCdtbranchid" value="${bankAccount.cdtbranchid }"
                		    	class="easyui-validatebox" data-options="required:true" validType="number"/></td>
 						<tr/>
                	</table>
                </div>
              
            </div>
            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
                <a id="btnEp" onclick="modifyCustBank()" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;
                <a id="btnCancel" class="easyui-linkbutton"  onclick="closeModifyCustBank()" icon="icon-cancel" href="javascript:void(0)">取消</a>
            </div>
<!--
		</div>
    </div> -->