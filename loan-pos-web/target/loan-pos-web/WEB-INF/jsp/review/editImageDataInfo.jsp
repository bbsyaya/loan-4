<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--新增窗口-->
<div title="影像资料" style="padding: 0px 20px 0px;">
	<table>
	<tr><td>
	<iframe id="editImageDataIframe" name="editImageDataIframe" frameborder="0"
		height="550px" width="1000px"  scrolling="no" class="imageDataIframe"></iframe>
	</td></tr>
	<tr><td align="center">
	<c:if test="${opflag == '1'}">
	<a id="upload" href="javascript:void(0)" class="easyui-linkbutton" onclick="editImageDataButton(this)" iconCls="icon-reload" >重新上传</a>
	</c:if>
	</td></tr>
	<tr><td>
	<iframe id="editImageDataIframe1" name="editImageDataIframe1" frameborder="0"
		height="600px" width="1000px" scrolling="no" class="imageDataIframe" style="display: none"></iframe>
	</td></tr>
	</table>
</div>