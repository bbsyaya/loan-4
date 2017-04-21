<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 
            <div id="confirmationSignWindow1"  title="贷款申请信息" collapsible="false" minimizable="false" 
        maximizable="true" icon="icon-save"  class="easyui-tabs" border="false" style="padding: 10px;overflow :auto; background: #fff; border: 1px solid #ccc;"> 
                      <jsp:include page="ApprovalConfirmView.jsp"></jsp:include>
                      <jsp:include page="../../creditApply/detailCredit/detailCreditInfo.jsp"></jsp:include>
                      
        
            </div> 
            
            <!-- 
            <div region="south" border="false" style="text-align: center; height: 30px; line-height: 30px;">
                <a id="btnEp" onclick="closeSignWindow()" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >
                    关闭</a>
            </div>-->
  