<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<!--尽职调查报告-->
    <div title="尽职调查报告" style="padding:20px;">
    	<table>
    		<tr>
    			<td colspan="4" align="center">客户尽职调查表</td>
    		</tr>
    		<tr>
    			<td colspan="4" align="left">1 尽职调查信息栏</td>
    		</tr>
    		<tr>
    			<td>尽职调查单位:</td>
    			<td><input type="text" id="workcorp" name="workcorp" readonly="readonly" style="border:0"/></td>
    			<td>申请日期:</td>
    			<td><input type="text" id="applydate" name="applydate" readonly="readonly" style="border:0"/></td>
    		</tr>
    		<tr>
    			<td>调查日期:</td>
    			<td><input type="text" id="surveydate" name="surveydate" readonly="readonly" style="border:0"/></td>
    			<td>尽调员姓名:</td>
    			<td><input type="text" id="investigatorname" name="investigatorname" readonly="readonly" style="border:0"/></td>
    		</tr>
    		<tr>
    			<td>调查日期:</td>
    			<td colspan="3"><input type="text" id="investigatorid" name="investigatorid" readonly="readonly" style="border:0"/></td>
    		</tr>
    		<tr>
    			<td colspan="4" align="left">2 客户信息</td>
    		</tr>
    		<tr>
    			<td>企业名称:</td>
    			<td colspan="3"><input type="text" id="enterprisename" name="enterprisename" readonly="readonly" style="border:0"/></td>
    		</tr>
    		<tr>
    			<td>申请人姓名:</td>
    			<td><input type="text" id="applicantname" name="applicantname" readonly="readonly" style="border:0"/></td>
    			<td>身份证号码:</td>
    			<td><input type="text" id="applicantid" name="applicantid" readonly="readonly" style="border:0"/></td>
    		</tr>
    		<tr>
    			<td>年营业额:</td>
    			<td><input type="text" id="annualturnover" name="annualturnover" readonly="readonly" style="border:0"/>万元</td>
    			<td>季节性:</td>
    			<td><input type="text" id="seasonal" name="seasonal" readonly="readonly" style="border:0"/></td>
    		</tr>
    		<tr>
    			<td>旺季月份:</td>
    			<td><input type="text" id="peakseason" name="peakseason" readonly="readonly" style="border:0"/></td>
    			<td>淡季月份:</td>
    			<td><input type="text" id="offseason" name="offseason" readonly="readonly" style="border:0"/></td>
    		</tr>
    		<tr>
    			<td colspan="4" align="left">3 材料检查清单</td>
    		</tr>
    		<tr>
    			<td>资料名称:</td>
    			<td>检查结果:</td>
    			<td>资料名称:</td>
    			<td>检查结果:</td>
    		</tr>
    		<tr>
    			<td>营业执照:</td>
    			<td><input type="text" id="checklicense" name="checklicense" readonly="readonly" style="border:0"/></td>
    			<td>POS机:</td>
    			<td><input type="text" id="checkpos" name="checkpos" readonly="readonly" style="border:0"/></td>
    		</tr>
    		<tr>
    			<td>身份证(含配偶）:</td>
    			<td><input type="text" id="checkid" name="checkid" readonly="readonly" style="border:0"/></td>
    			<td>经营场所:</td>
    			<td><input type="text" id="checkpremises" name="checkpremises" readonly="readonly" style="border:0"/></td>
    		</tr>
    		<tr>
    			<td>房产证:</td>
    			<td><input type="text" id="checkhouse" name="checkhouse" readonly="readonly" style="border:0"/></td>
    			<td>申请人与尽调员经营场所门口的照片:</td>
    			<td><input type="text" id="checkphotoatdoor" name="checkphotoatdoor" readonly="readonly" style="border:0"/></td>
    		</tr>
    		<tr>
    			<td>授信协议书:</td>
    			<td><input type="text" id="checkagreement" name="checkagreement" readonly="readonly" style="border:0"/></td>
    			<td>经营场所内照片:</td>
    			<td><input type="text" id="checkphotoinpremises" name=checkphotoinpremises readonly="readonly" style="border:0"/></td>
    		</tr>
    		<tr>
    			<td>用款申请书:</td>
    			<td><input type="text" id="checkform" name="checkform" readonly="readonly" style="border:0"/></td>
    			<td>客户签写授信协议书照片:</td>
    			<td><input type="text" id="checkphotosign" name="checkphotosign" readonly="readonly" style="border:0"/></td>
    		</tr>
    		<tr>
    			<td colspan="4" align="left">4 备注（有任何异常情况可在此填写说明）</td>
    		</tr>
    		<tr>
    			<td colspan="4" align="left"><textarea id="note" name="note" cols="100" rows="5" readonly="readonly" style="border:0"></textarea></td>
    		</tr>
    		<tr>
    			<td colspan="4" align="left">5 尽职调查员对客户现场调查的可信度意见/表决</td>
    		</tr>
    		<tr>
    			<td colspan="4" align="left"><textarea id="opinion" name="opinion" cols="100" rows="5" readonly="readonly" style="border:0"></textarea></td>
    		</tr>
    		<tr>
    			<td colspan="4" align="left">尽职声明：本调查员已按相关规定要求对借款人及其用款进行实地调查，与借款人进行面谈。对借款人提供的申请资料的合法性、真实性和有效性进行了认真核实，对授信的有关情况作了全面的调查和了解。</td>
    		</tr>
    		<tr>
    			<td colspan="4" align="right">尽职调查员签字：<input type="text" id="investigatornameSign" name="investigatornameSign" readonly="readonly" style="border:0"/></td>
    		</tr>
    	</table>
    	<br/>
    	<br/>
    </div>