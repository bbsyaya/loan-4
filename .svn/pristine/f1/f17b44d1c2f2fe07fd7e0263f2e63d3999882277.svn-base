<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div title="固话信息" style="padding: 0px 20px 0px;">
    <fieldset style="padding-top: 15px;margin-bottom:-30px;  border: 0px; width: 800px;">
        <table width="100%">
            <tr>
                <td align="right"><a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateFixLineInfo('${loanId}')" iconCls="icon-reload">更新固话信息</a></td>
            </tr>
        </table>
    </fieldset>
  <iframe id="fixedLineInfoIframe" name="fixedLineInfoIframe" frameborder="0"
    width="80%" height="720px" scrolling="auto" class="aicInfoIframe"></iframe>
</div>

<script type="text/javascript">
  function updateFixLineInfo(loanId){
     $.messager.progress({
            text: '数据加载中，请稍等......',
        }); 
      var url = "<%=request.getContextPath()%>/info/guozhengtong/fixedLine/update.do?loanId="+loanId;
      $('#fixedLineInfoIframe').attr("src",url);
  }
  $('#fixedLineInfoIframe').load(function(){
	  $.messager.progress('close');
  });
</script>

