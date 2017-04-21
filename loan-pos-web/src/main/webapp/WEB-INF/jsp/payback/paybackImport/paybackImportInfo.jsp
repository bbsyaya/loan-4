<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 还款进项详情 -->
<div id="ImportDetailWindow" class="easyui-window" title="还款进项详情" collapsible="false" minimizable="false" maximizable="true"
        maximizable="true" icon="icon-save" closed="true" style="width: 900; height: 500; padding: 5px; background: #fafafa;">
     <div class="easyui-layout" fit="true">
         <div region="center"  border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
           <div title="进项信息" style="padding:20px;">
             	<table>
             		<tr>
	             		<td>*币种:</td>
	             		<td><input type="text" class="insertMoneyKind" readonly name="insertMoneyKind"/></td>
	             		<td>*委托时间:</td>
	             		<td><input type="text" class="insertDelegateDate" readonly name="insertDelegateDate"/></td>	
             	    </tr>
             	    <tr>
	             	    <td>*进项金额:</td>
	             		<td><input type="text" class="insertImportAccount" readonly name="insertImportAccount"/></td>
	             		<td>*付款人名称:</td>
	             		<td><input type="text" class="insertPaybackPersonName" readonly name="insertPaybackPersonName"/></td>	
             	    </tr>
             	    <tr>
	             	    <td>*付款人账号:</td>
	             		<td><input type="text" class="insertPaybackPersonAccount" readonly name="insertPaybackPersonAccount"/></td>
	             		<td>*付款人开户行名称:</td>
	             		<td><input type="text" class="insertPaybackPersonOpenBankName" readonly name="insertPaybackPersonOpenBankName"/></td>	
             	    </tr>
             	    <tr>
	             	    <td>*付款清算行行号:</td>
	             		<td><input type="text" class="insertPaybackClearBankId" readonly name="insertPaybackClearBankId"/></td>
	             		<td>*付款人开户行行号:</td>
	             		<td><input type="text" class="insertPaybackPersonOpenBankId" readonly name="insertPaybackPersonOpenBankId"/></td>	
             	    </tr>
             	    <tr>
	             	    <td>*付款行行号:</td>
	             		<td><input type="text" class="insertPaybackBankId" readonly name="insertPaybackBankId"/></td>
	             		<td>*业务属性:</td>
	             		<td><input type="text" class="insertBusinessProperty" readonly name="insertBusinessProperty"/></td>	
             	    </tr>
             	    <tr>
	             	    <td>*业务种类:</td>
	             		<td><input type="text" class="insertBusinessKind" readonly name="insertBusinessKind"/></td>
	             		<td>*附言:</td>
	             		<td><input type="text" class="insertAdditional" readonly name="insertAdditional"/></td>	
             	    </tr>
             	    <tr>
	             	    <td>*备注:</td>
	             		<td><input type="text" class="insertNote" readonly name="insertNote"/></td>
	             		<td>*待分配金额:</td>
	             		<td><input type="text" class="insertNotAllocateAmount" readonly name="insertNotAllocateAmount"/></td>	
             	    </tr>
             	</table>
           </div>
           <div region="south" border="false" style="text-align: center; height: 30px; line-height: 30px;">
             <a id="btnEp" onclick="closeDetailWindow()" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >关闭</a> 
            </div>
         </div>
	 </div>
</div>