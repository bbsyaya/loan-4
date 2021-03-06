<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div title="公安信息" style="padding: 0px 20px 0px;">
  <fieldset
    style="padding-top: 15px; margin-bottom: -30px; border: 0px; width: 800px;">
    <table width="100%">
      <tr>
        <td align="right"><a href="javascript:void(0)"
          class="easyui-linkbutton" onclick="updatePoliceInfo('${loanId}')"
          iconCls="icon-reload">更新公安信息</a></td>
      </tr>
    </table>
  </fieldset>
  <iframe id="policeInfoIframe" name="policeInfoIframe" frameborder="0"
    width="80%" height="720px" scrolling="auto" class="aicInfoIframe"></iframe>
</div>

<script type="text/javascript">
  function updatePoliceInfo(loanId){
     $.messager.progress({
            text: '数据加载中，请稍等......',
        }); 
	  var url = "<%=request.getContextPath()%>/info/police/update.do?loanId="+loanId;
      $('#policeInfoIframe').attr("src",url);
      //iframe 加载完成，可以重复点击
  }
  $('#policeInfoIframe').load(function(){
      $.messager.progress('close');
  });
</script>

