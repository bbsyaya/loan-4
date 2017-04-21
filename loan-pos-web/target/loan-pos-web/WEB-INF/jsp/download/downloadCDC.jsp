<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/icon.css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/locale/easyui-lang-zh_CN.js'></script>
<script type="text/javascript">
$(function(){
	var url = "<%=request.getContextPath()%>/downloadCDC/downloadBatch.do";
	$.post(url,{},function(data){
		if (typeof(data) == "undefined" || data == null)
		{
		    alert("暂时没有批量文件");
		}else{
			$.each(data, function(i,obj){
				if(obj != null){
					var batchLink = "<br><br><a href='"+"<%=request.getContextPath()%>"+"/downloadCDC/download.do?fileName="+obj+"'>"+"下载批量文件"+obj+"</a>";
					$("#payin").append(batchLink);
				}
				
			});
		}
	},'json');
});
</script>
</head>

<body>
<a id="repay" href="<%=request.getContextPath()%>/downloadCDC/download.do?fileName=cdc_realtime_repay.csv">下载实时文件cdc_realtime_repay.csv</a>
<br>
<br>
<a id="payin" href="<%=request.getContextPath()%>/downloadCDC/download.do?fileName=cdc_realtime_payin.csv">下载实时文件cdc_realtime_payin.csv</a>

</body>
</html>