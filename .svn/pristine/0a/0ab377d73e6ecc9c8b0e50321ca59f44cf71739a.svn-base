<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div id="ReceiptRelatedInfoWindow" class="easyui-window" title="借据详情" collapsible="false" minimizable="false"
        maximizable="true" icon="icon-save"  style="width: 100%; height: 100%; padding: 5px;background: #fafafa">
        <div class="easyui-layout" fit="true">
            <div region="center" class="easyui-tabs" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; height: 403px">
                 <jsp:include page="ReceiptInfo.jsp"></jsp:include>
                 <jsp:include page="paybackRecord.jsp"></jsp:include>
                 <jsp:include page="contractInfo.jsp"></jsp:include>
                 <jsp:include page="customerInfo.jsp"></jsp:include>
                 <jsp:include page="photoInfo.jsp"></jsp:include> 
            </div>
            <div region="south" border="false" style="text-align: center; height: 30px; line-height: 30px;">
                <a id="btnEp" onclick="closeDetailWindow()" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >
                    关闭</a> 
            </div>
        </div>
    </div>
