<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!--补件-->
   <div id="addInfoWindow" class="easyui-window" title="影像资料补件" collapsible="false" minimizable="false" closed="true"
        maximizable="true" icon="icon-save"  style="width: 600px; height: 300px; padding: 5px; background: #fafafa;">
		<div id="addInfoWindow" class="easyui-layout" fit="true">
			<br/>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="addInfoSubmit()" iconCls="icon-add" plain="true">确定</a>
			&nbsp;&nbsp;<a href="javascript:void(0)" onclick="closeAddInfoWindow()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">取消</a>
			<br/><br/>		
			<table>
		    <tr>
                			<td class="tdtitle">补件资料：</td>
                			<td colspan="5">
              					<%-- <c:forEach items="${addInfoList}" var="obj">
									<input type="checkbox" id="addInfoExt${obj.itemNo}" name="addInfoExt" value="${obj.itemNo}" /><label style="cursor:pointer" for="addInfoExt${obj.itemNo}">${obj.itemName}</label>
								</c:forEach>
								 --%>
								<input type="checkbox" id="apprInfoExtC51" name="apprInfoExtC" value="51" /><label style="cursor:pointer" for="apprInfoExtC51">流水不足</label>
								<input type="checkbox" id="apprInfoExtC52" name="apprInfoExtC" value="52" /><label style="cursor:pointer" for="apprInfoExtC51">银行流水无户名</label>
								<input type="checkbox" id="apprInfoExtC53" name="apprInfoExtC" value="53" /><label style="cursor:pointer" for="apprInfoExtC51">流水非本人</label>
								<input type="checkbox" id="apprInfoExtC54" name="apprInfoExtC" value="54" /><label style="cursor:pointer" for="apprInfoExtC51">申请表信息填写错误</label>
								<input type="checkbox" id="apprInfoExtC55" name="apprInfoExtC" value="55" /><label style="cursor:pointer" for="apprInfoExtC51">申请表非现行版本</label>
								<input type="checkbox" id="apprInfoExtC56" name="apprInfoExtC" value="56" /><label style="cursor:pointer" for="apprInfoExtC51">材料不清晰</label>
								<input type="checkbox" id="apprInfoExtC57" name="apprInfoExtC" value="57" /><label style="cursor:pointer" for="apprInfoExtC51">必选材料缺失</label>
								<input type="checkbox" id="apprInfoExtC58" name="apprInfoExtC" value="58" /><label style="cursor:pointer" for="apprInfoExtC51">材料非原件</label>
                			</td>
            </tr>
			</table>
			<table>
				<tr>
					<td>补件说明</td>
				</tr>
				<tr>
					<td><textarea id="needReason" name="needReason" cols="50" rows="3"></textarea></td>
				</tr>
				<tr>
					<td>选择需补件的类型</td>
				</tr>
			</table>
            <table id="tAddInfo" style="width:350px;height:280px" iconCls="icon-search" onClickRow="clickRow" rownumbers="true">
				<thead>
					<tr>
						<th field="addInfo_id" checkbox="true"></th>
						<th field="itemNo" width="50px"></th>
						<th field="itemName" width="180px"></th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
