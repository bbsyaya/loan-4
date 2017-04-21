<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- 展业机构信息 -->
<div id="apprvScoreDiv" title="机构信息"
  style="padding: 20px; margin: auto; width: 90%">
  <table style="width: 100%">
    <tr>
      <td style="width: 15%;" class="tdtitle">分数:</td>
      <td style="width: 35%;"><input type="text" class="scorecut easyui-validatebox"
       validType="amt" invalidMessage="必须填写数字" <c:if test="${oprFlag=='3'}">readonly="readonly"</c:if>
        value="${tApprovingScorecutUplimitConfig.scorecut}" size="30"></td>
      <td class="tdtitle">是否生效:</td>
      <td><select id="score_deleted_flag" style="width: 243px;"
        class="easyui-combobox" <c:if test="${oprFlag=='3'}">readonly="readonly"</c:if>>
          <option value="">--请选择是否有效--</option>
          <c:forEach items="${deleteflagList}" var="obj">
            <option value="${obj.itemNo}"
              <c:if test="${obj.itemNo == tApprovingScorecutUplimitConfig.deleted_flag}">selected</c:if>>${obj.itemName}</option>
          </c:forEach>
      </select></td>
    </tr>
    <tr>
      <td class="tdtitle">生效时间:</td>
      <td><input type="text" class="valid_date easyui-datebox" data-options="required:true"
        <c:if test="${oprFlag=='3'}">readonly="readonly"</c:if>
        name="valid_date"
        value="<fmt:formatDate value='${tApprovingScorecutUplimitConfig.valid_date}' pattern='yyyy-MM-dd'/>"
        size="30" /></td>
      <td class="tdtitle">失效时间:</td>
      <td><input type="text" class="invalid_date easyui-datebox" data-options="required:true"
        <c:if test="${oprFlag=='3'}">readonly="readonly"</c:if>
        name="invalid_date"
        value="<fmt:formatDate value='${tApprovingScorecutUplimitConfig.invalid_date}' pattern='yyyy-MM-dd'/>"
        size="30"></td>
    </tr>
  </table>
  <br /> <br />
  <div style="text-align: center;display:${oprFlag=='3' ? 'none' : 'block'}">
    <input type="hidden" id="orgId" value="${institution.orgId}" /> <a
      href="javascript:void(0)" id="save" width="100px"
      class="easyui-linkbutton" iconCls="icon-ok"
      onclick="saveApprovingScorecutUplimitConfig(${oprFlag})">保存</a>&nbsp;&nbsp;
    <a href="javascript:void(0)" id="cancel" width="100px"
      class="easyui-linkbutton" iconCls="icon-no"
      onclick="cancelApprovingScorecutUplimitConfig(${oprFlag})">返回</a>
  </div>
</div>