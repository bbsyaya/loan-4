<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.border_line {
	border-bottom: 1px solid #E2D1D1
}

.align_right {
    width: 185px;
	text-align: right;
}
</style>
<!-- 固话综合信息 -->
<div title="固话信息 " style="padding: 20px;">
  <fieldset
    style="padding: 5px; color: #333; border: #06c dashed 1px; width: 800px;">
    <legend class='dialog-label'
      style="color: #06c; font-weight: 800; background: #fff;">固话综合信息 </legend>
    <table width="100%">
      <tr>
        <td class="border_line align_right"><span><strong>电话：</strong></span></td>
        <td class="border_line">${fixedLine.telNum}</td>
      </tr>
      <tr>
        <td class="border_line align_right"><span><strong>名称：</strong></span></td>
        <td class="border_line">${fixedLine.name}</td>
      </tr>
      <tr>
        <td class="border_line align_right"><span><strong>地址：</strong></span></td>
        <td class="border_line">${fixedLine.address}</td>
      </tr>
      <tr>
        <td class="border_line align_right"><span><strong>唯一标识：</strong></span></td>
        <td class="border_line">${fixedLine.uniqueNum}</td>
      </tr>
      <tr>
        <td class="border_line align_right"><span><strong>区域名称：</strong></span></td>
        <td class="border_line">${fixedLine.areaCode}</td>
      </tr>
      <tr>
        <td class="border_line align_right"><span><strong>查询结果：</strong></span></td>
        <td class="border_line">${fixedLine.queryResult}</td>
      </tr>
      <tr>
        <td class="border_line align_right"><span><strong>查询类型：</strong></span></td>
        <td class="border_line">${fixedLine.queryType}</td>
      </tr>
      <tr>
        <td class="border_line align_right"><span><strong>查得电话：</strong></span></td>
        <td class="border_line">${fixedLine.corpTel}</td>
      </tr>
      <tr>
        <td class="border_line align_right"><span><strong>查得名称：</strong></span></td>
        <td class="border_line">${fixedLine.corpName}</td>
      </tr>
      <tr>
        <td class="border_line align_right"><span><strong>查得地址：</strong></span></td>
        <td class="border_line">${fixedLine.corpAddress}</td>
      </tr>
      <tr>
        <td class="border_line align_right"><span><strong>查询时间：</strong></span></td>
        <td class="border_line"><fmt:formatDate value='${fixedLine.updated_at}' pattern='yyyy-MM-dd HH:mm:ss'/></td>
      </tr>
    </table>
  </fieldset>
  <p></p>
  <fieldset
    style="padding: 5px; color: #333; border: #06c dashed 1px; width: 800px;">
    <legend class='dialog-label'
      style="color: #06c; font-weight: 800; background: #fff;">查询结果</legend>
    <table width="100%">
      <tr>
        <td align="center"><c:choose>
            <c:when test="${empty fixedLine.queryResult}">查询结果为空</c:when>
            <c:otherwise>${fixedLine.queryResult}</c:otherwise>
          </c:choose></td>
      </tr>
    </table>
  </fieldset>
</div>
