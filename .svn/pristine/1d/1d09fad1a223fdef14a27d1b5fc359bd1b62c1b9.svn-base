<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- 展业机构信息 -->
<div id="riskZoneDiv" title="机构信息"
  style="padding: 20px; margin: auto; width: 90%">
  <table id="riskZoneTable" style="width: 100%">
    <tr>
      <td style="width: 15%;" class="tdtitle">地区code:</td>
      <td style="width: 35%;"><select id="region_code" name="region_code"
        class="easyui-combobox" style="width: 243px;"
        validType="selectedRequired"
        <c:if test="${oprFlag=='3'||oprFlag=='1'}">readonly="readonly"</c:if>>
          <option value="">--请选择(省/市)--</option>
          <c:forEach items="${provinceList}" var="obj">
            <option value="${obj.itemNo}"
              <c:if test="${obj.itemNo == tRiskZoneConfig.region_code}">selected</c:if>>${obj.itemName}</option>
          </c:forEach>
      </select></td>
      <td class="tdtitle">风险等级:</td>
      <td><select id="risk_type" name="risk_type" class="easyui-combobox"
        style="width: 243px;" validType="selectedRequired"
        <c:if test="${oprFlag=='3'}">readonly="readonly"</c:if>>
          <option value="">--请选择风险等级--</option>
          <c:forEach items="${risktypeList}" var="obj">
            <option value="${obj.itemNo}"
              <c:if test="${obj.itemNo == tRiskZoneConfig.risk_type}">selected</c:if>>${obj.itemName}</option>
          </c:forEach>
      </select></td>
    </tr>
    <tr>
      <td class="tdtitle">是否生效:</td>
      <td><select id="deleted_flag_select" name="deleted_flag_select"
        style="width: 243px;" class="easyui-combobox"
        validType="selectedRequired"
        <c:if test="${oprFlag=='3'}">readonly="readonly"</c:if>>
          <option value="">--请选择是否有效--</option>
          <c:forEach items="${deleteflagList}" var="obj">
            <option value="${obj.itemNo}"
              <c:if test="${obj.itemNo == tRiskZoneConfig.deleted_flag}">selected</c:if>>${obj.itemName}</option>
          </c:forEach>
      </select></td>
    </tr>
    <tr>
      <td class="tdtitle">生效时间:</td>
      <td><input type="text" id="valid_date" class="easyui-datebox" data-options="required:true"
        value='<fmt:formatDate value="${tRiskZoneConfig.valid_date}" pattern="yyyy-MM-dd"/>'
        <c:if test="${oprFlag=='3'}">readonly="readonly"</c:if> size="30" /></td>
      <td class="tdtitle">失效时间:</td>
      <td><input type="text" id="invalid_date" class="easyui-datebox" data-options="required:true"
        value='<fmt:formatDate value="${tRiskZoneConfig.invalid_date}" pattern="yyyy-MM-dd"/>'
        <c:if test="${oprFlag=='3'}">readonly="readonly"</c:if> size="30"></td>
    </tr>
  </table>
  <br /> <br />
  <div style="text-align: center;display:${oprFlag=='3' ? 'none' : 'block'}">
    <a href="javascript:void(0)" id="save" width="100px"
      class="easyui-linkbutton" iconCls="icon-ok"
      onclick="saveRiskzoneConfig(${oprFlag})">保存</a>&nbsp;&nbsp; <a
      href="javascript:void(0)" id="cancel" width="100px"
      class="easyui-linkbutton" iconCls="icon-no"
      onclick="cancelRiskzoneConfig(${oprFlag})">返回</a>
  </div>
</div>