<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!--修改窗口-->
  <!--修改窗口-->
    <div id="modifyCustomerWindow" class="easyui-window" title="新增授信申请" collapsible="false" minimizable="false"
        maximizable="true" icon="icon-save"  style="width: 800px; height: 500px; padding: 5px;
        background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" class="easyui-tabs" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <div title="申请人个人信息" style="padding:20px;">
                	<table>
						<tr>
                			<td>		
                				居住省：<input id="editresidentProv" name="editresidentProv" style="line-height:20px;border:1px solid #ccc"/>
							</td>
                		    <td>		
                				居住市：<input id="editresidentCity" name="editresidentCity" style="line-height:20px;border:1px solid #ccc"/>
							</td>
                		    <td>		
                				居住地址：<input id="editresidentDetail" name="editresidentDetail" style="line-height:20px;border:1px solid #ccc"/>
							</td>
                		    <td>		
                				联系地址：<input id="editcontactAddrFlag" name="editcontactAddrFlag" style="line-height:20px;border:1px solid #ccc"/>
							</td>
 						<tr/>
						<tr>
							<td>		
                				工作单位：<input id="editworkCorp" name="editworkCorp" style="line-height:20px;border:1px solid #ccc"/>
							</td>
                		    <td>		
                				工作单位地址：<input id="editcorpAddr" name="editcorpAddr" style="line-height:20px;border:1px solid #ccc"/>
							</td>
						<tr/>
						<tr>
                		    <td>		
                				手机号码：<input id="editmobilePhone" name="editmobilePhone" style="line-height:20px;border:1px solid #ccc"/>
							</td>
                		    <td>		
                				固定电话：<input id="edittel" name="edittel" style="line-height:20px;border:1px solid #ccc"/>
							</td>
                		    <td>		
                				微信号：<input id="editweixinNo" name="editweixinNo" style="line-height:20px;border:1px solid #ccc"/>
							</td>
                		    <td>		
                				qq：<input id="editqqNo" name="editqqNo" style="line-height:20px;border:1px solid #ccc"/>
							</td>
							<tr/>
						<tr>
                		    <td>		
                				邮箱：<input id="editemail" name="editemail" style="line-height:20px;border:1px solid #ccc"/>
							</td>
                		    <td>		
                				备注：<input id="editremarks" name="editremarks" style="line-height:20px;border:1px solid #ccc"/>
							</td>
						<tr/>
                	</table>
                </div>
                <div title="申请人配偶信息" style="padding:20px;">
                	<table>
						<tr>
                			<td>		
                				配偶姓名：<input id="editfamilyCustName" name="editfamilyCustName" style="line-height:20px;border:1px solid #ccc"/>
							</td>
                		    <td>		
                				配偶证件类型：<input id="editmatePaperKind" name="editmatePaperKind" style="line-height:20px;border:1px solid #ccc"/>
							</td>
                		    <td>		
                				配偶生日：<input id="editmateBirtDate" name="editmateBirtDate" style="line-height:20px;border:1px solid #ccc"/>
							</td>
                		    <td>		
                				配偶性别：<input id="editmatePaperId" name="editmatePaperId" style="line-height:20px;border:1px solid #ccc"/>
							</td>
													<tr/>
						<tr>
							<td>		
                				配偶手机：<input id="editmateMobilephone" name="editmateMobilephone" style="line-height:20px;border:1px solid #ccc"/>
							</td>
 
						<tr/>
                	</table>
                </div>
                 <div title="其他信息" style="padding:20px;">
                	<table>
						<tr>
                			<td>		
                				贷款卡号：<input id="editloanPaperId" name="editloanPaperId" style="line-height:20px;border:1px solid #ccc"/>
							</td>
                		    <td>		
                				贷款卡年检日期：<input id="editloanPaperCheckDate" name="editloanPaperCheckDate" style="line-height:20px;border:1px solid #ccc"/>
							</td>
                		    <td>		
                				从业年限：<input id="editbusiYear" name="editbusiYear" style="line-height:20px;border:1px solid #ccc"/>
							</td>
            	    	<tr/>
						<tr>
							<td>		
                				拥有经营地房产数量：<input id="editlocalHouseNum" name="editlocalHouseNum" style="line-height:20px;border:1px solid #ccc"/>
							</td>
							<td>		
                				拥有非经营地房产数量：<input id="editotherHouseNum" name="editotherHouseNum" style="line-height:20px;border:1px solid #ccc"/>
							</td>
						    <td><input type="hidden" id="custId" name="custId" readonly="readonly"></td>
						<tr/>
                	</table>
                	
                </div>
            </div>
            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
                <a id="btnEp" onclick="modifyCustomer()" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)">
             		      保存并退出</a> <a id="btnCancel" class="easyui-linkbutton"  onclick="closeModifyCustomer()" icon="icon-cancel" href="javascript:void(0)">取消</a>
            </div>
        </div>
    </div>