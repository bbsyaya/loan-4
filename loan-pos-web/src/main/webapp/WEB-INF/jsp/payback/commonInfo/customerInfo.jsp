<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- 客户基本信息 -->
<div title="客户基本信息" style="padding:20px; width: 90%">
   	<table style = "width:100%">
   		<tr>
	   		<td style="width:15%;word-break;" class="tdtitle">客户编号:</td>
	   		<td style="width:35%;word-break;"><input type="text" class="insertSignCustId" readonly name="insertSignCustId3" value="${customer.custId}" size="30"></td>
	   		<td class="tdtitle">客户名称:</td>
	   		<td><input type="text" class="insertSignCustName" readonly name="insertSignCustName2" value="${customer.custName}" size="30"></td>
   		</tr>
   		<tr>
	   		<td class="tdtitle">证件类型:</td>
	   		<td><input type="text" class="insertSignCredentialtype" readonly name="insertSignCredentialtype" value="${customer.paperKind}" size="30"></td>
	   		<td class="tdtitle">证件号码:</td>
	   		<td><input type="text" class="insertSignCredentialNo" readonly name="insertSignCredentialNo" value="${customer.paperId}" size="30"></td>
   		</tr>
   		<tr>
	   		<td class="tdtitle">出生日期:</td>
	   		<td><input type="text" class="insertSignBirthDate" readonly name="insertSignBirthDate"  value="<fmt:formatDate value='${customer.birtDate}' pattern='yyyy-MM-dd'/>" size="30" /></td>
	   		<td class="tdtitle">性别:</td>
	   		<td><input type="text" class="insertSignGender" readonly name="insertSignGender" value="${customer.sexSign}" size="30"></td>
   		</tr>
   		<tr>
	   		<td class="tdtitle">最高学历:</td>
	   		<td><input type="text" class="insertSignHighestDegree" readonly name="insertSignHighestDegree" value="${customer.educSign}" size="30"></td>
	   		<td class="tdtitle">婚姻状况:</td>
	   		<td><input type="text" class="insertSignMarriageStatus" readonly name="insertSignMarriageStatus" value="${customer.marrSign}" size="30"></td>
    	</tr>
    	<tr>
	      	<td class="tdtitle">居住地址-省:</td>
			<td><input type="text" class="insertSignProvince" readonly name="insertSignProvince" value="${customer.residentProv}" size="30"></td>
	   		<td class="tdtitle">居住地址-市:</td>
	   		<td><input type="text" class="insertSignCity" readonly name="insertSignCity" value="${customer.residentCity}" size="30"></td>
   		<tr>
	   		<td class="tdtitle">居住地址-区:</td>
	   		<td><input type="text" class="insertSignDivision" readonly name="insertSignDivision" value="${customer.residentDivision}" size="30"></td>
	   		<td class="tdtitle">居住地址-具体</td>
	   		<td><input type="text" class="insertSignDetailedAddress" readonly name="insertSignCurrentAddress" value="${customer.residentDetail}" size="30"></td>
   		</tr>
   		<tr>
	   		<td class="tdtitle">子女人数:</td>
	   		<td><input type="text" class="insertSignChildrenNo" readonly name="insertSignChildrenNo" value="${customer.childNum}" size="30"></td>
	   		<td class="tdtitle">电子邮件:</td>
	   		<td><input type="text" class="insertSignEmailAddress" readonly name="insertSignEmailAddress" value="${customer.email}" size="30"></td> 		
   		</tr>
   		<tr>
	   		<td class="tdtitle">手机号码:</td>
	   		<td><input type="text" class="insertSignCellphoneNo" readonly name="insertSignCellphoneNo" value="${customer.mobilePhone}" size="30"></td>
	   		<td class="tdtitle">办公电话:</td>
	   		<td><input type="text" class="insertSignOfficeTel" readonly name="insertSignOfficeTel" value="${customer.tel}" size="30"></td>
   		</tr>
   		<tr>
	   		<td class="tdtitle">微信号:</td>
	   		<td><input type="text" class="insertSignWechatNo" readonly name="insertSignWechatNo" value="${customer.weixinNo}" size="30"></td>
	   		<td class="tdtitle">QQ号:</td>
	   		<td><input type="text" class="insertSignQQNo" readonly name="insertSignQQNo" value="${customer.qqNo}" size="30"></td>
   		</tr>
   	</table>
</div>