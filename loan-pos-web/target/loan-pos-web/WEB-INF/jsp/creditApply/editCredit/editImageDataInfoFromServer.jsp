<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--新增窗口-->

<div title="影像资料备用" style="padding: 0px 20px 0px;">
	<table>
	<tr><td>
	<iframe id="editImageDataIframeback" name="editImageDataIframeback" frameborder="0"
		height="550px" width="1000px"  scrolling="no" class="imageDataIframe"></iframe>
	</td></tr>
	<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;
	<a id="reUploadback" name="reUploadback" href="javascript:void(0)" class="easyui-linkbutton" onclick="editImageDataButtonFromServer(this)" iconCls="icon-reload" >重新上传</a>
	</td></tr>
	<tr><td>
	<iframe id="editImageDataIframeback1" name="editImageDataIframeback1" frameborder="0"
		height="1250px" width="1148px" scrolling="yes" style="display: none"></iframe>
	</td></tr>
	</table>
</div>
