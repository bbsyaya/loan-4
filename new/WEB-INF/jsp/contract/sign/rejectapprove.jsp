<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div id="RejectApproveWindow" class="easyui-window" title="批复详情" collapsible="false" minimizable="false"
        maximizable="true" icon="icon-save"  style="width: 100%; height: 100%;padding: 5px";
        background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" class="easyui-tabs" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                 <div title="拒绝原因" style="padding:20px;">
                	<table>
                		<tr>
                		<td>*客户名称:</td>
                		<td><input type="text" id="insertRejectCustName" readonly= "true " name="insertRejectCustName1"/></td>
                		<td>*证件号码:</td>
                		<td><input type="text" id="insertRejectIdNo" readonly= "true " name="insertRejectIdNo"/></td>	
                		</tr>
                	
                		<tr>
                		<td>*批复额度:</td>
                		<td><input type="text" id="insertRejectApproveAmount" readonly= "true " name="insertRejectApproveAmount1"/></td>
                		<td>*批复币种:</td>
                		<td><input type="text" id="insertRejectApproveMoneyKind" readonly= "true " name="insertRejectApproveMoneyKind"/></td>	
                		</tr>
                		
                		<tr>
                		<td>*批复期限:</td>
                		<td><input type="text" id="insertRejectApproveTerm" readonly= "true " name="insertRejectApproveTerm1"/></td>
                		<td>*批复利率:</td>
                		<td><input type="text" id="insertRejectApproveInterest" readonly= "true " name="insertRejectApproveInterest1"/></td>	
                		</tr>
                		<tr>
                		<td>*拒绝原因:</td>
                		<td>
                		<label for="1">
                		<input type="radio" name="reason" value="利率太高"/ id="1">利率太高
                		</label>
                		<label for="2">
                		<input type="radio" name="reason" value="额度太低"/ id="2">额度太低
                		</label>
                		<label for="3">
                		<input type="radio" name="reason" value="对服务不满意" id="3" />对服务不满意
                		</label>
                		<label for="4">
                		<input type="radio" name="reason" value="其他"/ id="4">其他
                	    </label>
                	    </td>
                	    </tr>             	    
                	    <tr>
                	    <td>*原因详情:</td>
                	    <td><textarea id="insertRejectReasonDetail" name="insertRejectReason" cols="30" rows="5" style="border: 1px #939393 solid;"></textarea></td>            	   
                	    </tr>
                	</table>
                </div>
                <!-- 
                 <div title="批复信息" style="padding:20px;">
                	<table>
                	    <th>批复信息</th>
                		<tr>
                		<td>业务渠道:<input type="text" id="insertRejectChannelName" readonly= "true " name="insertRejectChannelName" readonly="readonly"value="展业"/></td>
                		<td>期限单位:<input type="text" id="insertRejectTermUnit" readonly= "true " name="insertRejectTermUnit"/></td>	
                		</tr>
                		<tr>
                		<td>申请额度:<input type="text" id="insertRejectApllyAmount" readonly= "true " name="insertRejectApllyAmount"/></td>
                		<td>申请币种:<input type="text" id="insertRejectApplyMoneyKind" readonly= "true " name="insertRejectApplyMoneyKind"/></td>	
                		</tr>
                		<tr>
                		<td>申请期限:<input type="text" id="insertRejectApplyTerm" readonly= "true " name="insertRejectApplyTerm"/></td>
                		<td>申请提交日期:<input type="text" id="insertRejectApplyCommitDate" readonly= "true " name="insertRejectApplyCommitDate"/></td>
                		</tr>
                		<tr>
                		<td>批复额度:<input type="text" id="insertRejectApproveAmount2" readonly= "true " name="insertRejectApproveAmount2"/></td>
                		<td>批复利率:<input type="text" id="insertRejectApproveInterest2" readonly= "true " name="insertRejectApproveInterest2"/></td>
                		</tr>
                		<tr>
                		<td>批复期限:<input type="text" id="insertRejectApproveTerm2" readonly= "true " name="insertRejectApproveTerm2"/></td>
                		<td>批复日期:<input type="text" id="insertRejectApproveDate" readonly= "true " name="insertRejectApproveDate"/></td>
                		</tr>
                		<tr>
                		<td>收款账号:<input type="text" id="insertRejectAcceptAccount" readonly= "true " name="insertRejectAcceptAccount"/></td>
                		</tr>
                		<tr>
                		<td>账户开户行:<input type="text" id="insertRejectAccountOpenBank" readonly= "true " name="insertRejectAccountOpenBank"/></td>
                		</tr>
                		<tr>
                		<td>批复状态:<input type="text" id="insertRejectApproveStatus" readonly= "true " name="insertRejectApproveStatus"/></td>
                		</tr>
                	</table>
                </div>
                 <div title="客户基本信息" style="padding:20px;">
                	<table>
                		<tr>
                			<td>客户编号:<input type="text" id="insertRejectCustId" readonly= "true " name="insertRejectCustId"></td>
                			<td>客户名称:<input type="text" id="insertRejectCustName2" readonly= "true " name="insertRejectCustName2"></td>
  
                		</tr>
                		<tr>
                			<td>证件类型:<input type="text" id="insertRejectCredentialtype" readonly= "true " name="insertRejectCredentialtype"></td>
                			<td>证件号码:<input type="text" id="insertRejectCredentialNo" readonly= "true " name="insertRejectCredentialNo"></td>
                		</tr>
                		<tr>
                			<td>出生日期:<input type="text" id="insertRejectBirthDate" readonly= "true " name="insertRejectBirthDate"></td>
                			<td>性别:<input type="text" id="insertRejectGender" readonly= "true " name="insertRejectGender"></td>
                		</tr>
                			<tr>
                			<td>最高学历:<input type="text" id="insertRejectHighestDegree" readonly= "true " name="insertRejectHighestDegree"></td>
                			<td>婚姻状况:<input type="text" id="insertRejectMarriageStatus" readonly= "true " name="insertRejectMarriageStatus"></td>
                		</tr>
                			<tr>
                			<td>居住地址-省:<input type="text" id="insertRejectProvince" readonly= "true " name="insertRejectProvince"></td>
                			<td>居住地址-市:<input type="text" id="insertRejectCity" readonly= "true " name="insertRejectCity"></td>
                			<td>居住地址-具体:<input type="text" id="insertRejectAddress" readonly= "true " name="insertRejectAddress"></td>
                		</tr>
                			<tr>
                			<td>民族:<input type="text" id="insertRejectNation" readonly= "true " name="insertRejectNation"></td>
                			<td>子女人数:<input type="text" id="insertRejectChildrenNo" readonly= "true " name="insertRejectChildrenNo"></td>
                		</tr>
                			<tr>
                			
                			<td>现居住地址:<input type="text" id="insertRejectCurrentAddress" readonly= "true " name="insertRejectCurrentAddress"></td>
                		</tr>
                			<tr>
                			<td>手机号码:<input type="text" id="insertRejectCellphoneNo" readonly= "true " name="insertRejectCellphoneNo"></td>
                			<td>办公电话:<input type="text" id="insertRejectOfficeTel" readonly= "true " name="insertRejectOfficeTel"></td>
                		</tr>
                			<tr>
                			<td>微信号:<input type="text" id="insertRejectWechatNo" readonly= "true " name="insertRejectWechatNo"></td>
                			<td>QQ号:<input type="text" id="insertRejectQQNo" readonly= "true " name="insertRejectQQNo"></td>
                		</tr>
                			<tr>
                			<td>电子邮件:<input type="text" id="insertRejectEmailAddress" readonly= "true " name="insertRejectEmailAddress"></td> 		
                	</table>
                </div> -->
                 <jsp:include page="approveInfo.jsp"></jsp:include>
                 <jsp:include page="../../creditApply/detailCredit/detailCreditCustInfo.jsp"></jsp:include>
                <%--  <jsp:include page="customerInfo.jsp"></jsp:include> --%>
            
            
            
            </div>
            <div region="south" border="false" style="text-align: center; height: 30px; line-height: 30px;">
                <a id="btnReject" onclick="rejectConfrimWindow()" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >
                    确认拒绝</a> <a id="btnYes" onclick="closeRejectWindow()"  class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >
                    关闭</a>
            </div>
        </div>
    </div>
	
	
	
	