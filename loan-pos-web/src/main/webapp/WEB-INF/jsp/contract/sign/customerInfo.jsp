<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <div title="客户基本信息" style="padding:20px;">
                	<table>
                		<tr>
                		<td>*客户编号:</td>
                		<td><input type="text" class="insertSignCustId" readonly= "true " name="insertSignCustId3"></td>
                		<td>*客户名称:</td>
                		<td><input type="text" class="insertSignCustName" readonly= "true " name="insertSignCustName2"></td>
                		</tr>
                		<tr>
                		<td>*证件类型:</td>
                		<!-- <td><input type="text" class="insertSignCredentialtype" readonly= "true " name="insertSignCredentialtype"></td> -->
                		<td><select disabled="disabled" class="insertSignCredentialtype"
							name="insertSignCredentialtype">
								<c:forEach items="${paperList}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
							</select></td>
                		<td>*证件号码:</td>
                		<td><input type="text" class="insertSignCredentialNo" readonly= "true " name="insertSignCredentialNo"></td>
                		</tr>
                		<tr>
                		<td>*出生日期:</td>
                		<td><input type="text" class="insertSignBirthDate" readonly= "true " name="insertSignBirthDate"></td>
                		<td>*性别:</td>
                		<!-- <td><input type="text" class="insertSignGender" readonly= "true " name="insertSignGender"></td> -->
                		<td><select disabled="disabled" class="insertSignGender"
							name="insertSignGender">
								<c:forEach items="${sexList}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
							</select></td>
                		</tr>
                		<tr>
                		<td>*最高学历:</td>
                		<!-- <td><input type="text" class="insertSignHighestDegree" readonly= "true " name="insertSignHighestDegree"></td> -->
                		<td><select disabled="disabled" class="insertSignHighestDegree"
							name="insertSignHighestDegree">
								<c:forEach items="${eduList}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
							</select></td>
                		<td>*婚姻状况:</td>
                		<!-- <td><input type="text" class="insertSignMarriageStatus" readonly= "true " name="insertSignMarriageStatus"></td> -->
                		<td><select disabled="disabled" class="insertSignMarriageStatus"
							name="insertSignMarriageStatus">
								<c:forEach items="${maritalList}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
							</select></td>
                		</tr>
                		<tr>
                		<td>*居住地址-省:</td>
                	<!-- 	<td><input type="text" class="insertSignProvince" readonly= "true " name="insertSignProvince"></td> -->
                	<%-- 	<td><select  id="insertResidentProv"
							name="insertResidentProv" onchange="selectCustCity(this)">
								<option value="">--请选择--</option>
								<c:forEach items="${province}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
							</select></td> --%>
							
						<td><select disabled="disabled" class="insertSignProvince"
							name="insertSignProvince">
								<c:forEach items="${province}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
							</select></td>
                		<td>*居住地址-市:</td>
                		<!-- <td><input type="text" class="insertSignCity" readonly= "true " name="insertSignCity"></td> -->
                		<td><select disabled="disabled" class="insertSignCity"
							name="insertSignCity">
								<c:forEach items="${cities}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
							</select></td>
                		<tr>
                		<td>*居住地址-区:</td>
                		<!-- <td><input type="text" class="insertSignAddress" readonly= "true " name="insertSignAddress"></td> -->
                		<td><select disabled="disabled" class="insertSignDivision"
							name="insertSignDivision">
								<c:forEach items="${divisions}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
							</select></td>
                		<td>*居住地址-具体</td>
                		<td><input type="text" class="insertSignDetailedAddress" readonly= "true " name="insertSignCurrentAddress"></td>
                		</tr>
                		<tr>
                		<td>*子女人数:</td>
                		<td><input type="text" class="insertSignChildrenNo" readonly= "true " name="insertSignChildrenNo"></td>
                		<td>*电子邮件:</td>
                		<td><input type="text" class="insertSignEmailAddress" readonly= "true " name="insertSignEmailAddress"></td> 		
                		</tr>
                		<tr>
                		<td>*手机号码:</td>
                		<td><input type="text" class="insertSignCellphoneNo" readonly= "true " name="insertSignCellphoneNo"></td>
                		<td>*办公电话:</td>
                		<td><input type="text" class="insertSignOfficeTel" readonly= "true " name="insertSignOfficeTel"></td>
                		</tr>
                		<tr>
                		<td>*微信号:</td>
                		<td><input type="text" class="insertSignWechatNo" readonly= "true " name="insertSignWechatNo"></td>
                		<td>*QQ号:</td>
                		<td><input type="text" class="insertSignQQNo" readonly= "true " name="insertSignQQNo"></td>
                		</tr>
                	</table>
                </div>