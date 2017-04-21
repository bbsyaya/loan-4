<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div title="审批结果确认" style="padding:10px;">
	<table id="approvalform" style="width:800px; ">
		<tr><td><jsp:include page="approveInfo.jsp"></jsp:include></td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td><fieldset style="padding:5px; color:#333; border:#06c dashed 1px;">
			<legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">审批结果确认</legend>
				<table width="100%">
                		<tr>
                			<td width="150px" class="tdtitle">处理方式:</td>
                			<td colspan="3">
                				<input type="radio" id="apprResult01" name="apprResult" onclick="removeElement()" value="10" <c:if test="${(applyDetail[0].inChannelKind!='04' and applyDetail[0].inChannelKind!='99') and hasManageRole==false }">disabled</c:if>>
                					<label id="apprResult01L" style="cursor:pointer" for="apprResult01" >通过</label>&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" id="apprResult02" name="apprResult" onclick="clearInfo()" value="20">
									<label id="apprResult02L" style="cursor:pointer" for="apprResult02">拒绝</label>&nbsp;&nbsp;&nbsp;&nbsp;
							</td>
                		</tr>
                	
                		<tr id="01"> <td class="tdtitle">拒绝原因:</td>
                		<td>
	                		<label for="1"><input type="radio" name="reason" value="利率太高" id="1"/>利率太高</label>
	                		<label for="2"><input type="radio" name="reason" value="额度太低" id="2"/>额度太低</label>
	                		<label for="3"><input type="radio" name="reason" value="对服务不满意" id="3"/>对服务不满意</label>
	                		<label for="4"><input type="radio" name="reason" value="其他" id="4"/>其他</label>
                	    </td>
                	    </tr>             	    
                	    <tr id="02"> <td class="tdtitle">原因详情:</td>
                	    <td><textarea id="insertRejectReasonDetail" name="insertRejectReason" cols="50" rows="5" style="border: 1px #939393 solid;"></textarea></td>            	   
                	    </tr>
                	    
                	    <tr>
                	    <td>&nbsp;</td>
                	    <td align="right">
                	    	<a id="btnReject" onclick="commit()" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >提交</a>&nbsp;&nbsp;&nbsp;&nbsp;
                	    	<a id="btnReject" onclick="closeConfirmWindow()" class="easyui-linkbutton" icon="icon-back" href="javascript:void(0)" >返回</a>&nbsp;&nbsp;&nbsp;&nbsp;
                	    </td>
                	    </tr>

                	</table>
			</fieldset>
		</td></tr>
	</table>
</div>
<script type="text/javascript">
	//$("#insertRejectReasonDetail").tip("abc");
</script>