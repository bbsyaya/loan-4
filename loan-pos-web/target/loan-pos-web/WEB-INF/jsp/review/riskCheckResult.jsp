<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--风险初审结果-->
<div title="风险初审结果" style="padding:20px;">
	<table id="riskCheckResult">
		<tr>
			<td width="600px" align="right">商户名称:</td>
			<td width="100px"><input type="text" id="result03" name="result03" readonly="readonly" style="border:0"/></td>
			<td width="600px" align="right">渠道:</td>
			<td width="150px"><input type="text" id="result01" name="result01" readonly="readonly" style="border:0"/></td>
			<td width="300px" align="right">地区:</td>
			<td width="100px"><input type="text" id="result02" name="result02" readonly="readonly" style="border:0"/></td>
		</tr>
		<tr>
			<td align="right">姓名:</td>
			<td><input type="text" id="result04" name="result04" readonly="readonly" style="border:0"/></td>
			<td align="right">申请人身份证号:</td>
			<td><input type="text" id="result06" name="result06" readonly="readonly" style="border:0"/></td>
			<td align="right">申请手机:</td>
			<td><input type="text" id="result05" name="result05" readonly="readonly" style="border:0"/></td>
		</tr>
		<tr>
			<td align="right">模型授信决定:</td>
			<td><input type="text" id="result07" name="result07" readonly="readonly" style="border:0"/></td>
			<td align="right">模型授信额度（万）:</td>
			<td><input type="text" id="result08" name="result08" readonly="readonly" style="border:0"/></td>
			<td align="right">模型利率（%）:</td>
			<td><input type="text" id="result09" name="result09" readonly="readonly" style="border:0"/></td>
		</tr>
		<tr>
			<td align="right">拒绝原因:</td>
			<td colspan="5"><textarea id="result10" name="result10" cols="60" rows="5" readonly="readonly"></textarea></td>
		</tr>
		<tr>
			<td align="right">是否需要尽调:</td>
			<td><input type="text" id="result11" name="result11" readonly="readonly" style="border:0"/></td>
			<td align="right">风险等级:</td>
			<td><input type="text" id="result12" name="result12" readonly="readonly" style="border:0"/></td>
			<td></td>
			<td></td>
		</tr>
		<tr>			
			<td align="right">征信手机:</td>
			<td><input type="text" id="result13" name="result13" readonly="readonly" style="border:0"/></td>
			<td align="right">与申请人手机是否一致:</td>
			<td><input type="text" id="result14" name="result14" readonly="readonly" style="border:0"/></td>
			<td align="right">人行最高信用额度:</td>
			<td><input type="text" id="result15" name="result15" readonly="readonly" style="border:0"/></td>
		</tr>
		<tr>
			<td align="right">年负债（万）:</td>
			<td><input type="text" id="result16" name="result16" readonly="readonly" style="border:0"/></td>
			<td align="right">年负债/年营业收入:</td>
			<td><input type="text" id="result17" name="result17" readonly="readonly" style="border:0"/></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td align="right">月负债（万）:</td>
			<td><input type="text" id="result18" name="result18" readonly="readonly" style="border:0"/></td>
			<td align="right">月负债/月营业收入:</td>
			<td><input type="text" id="result19" name="result19" readonly="readonly" style="border:0"/></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td align="right">未结清贷款余额（万）:</td>
			<td><input type="text" id="result20" name="result20" readonly="readonly" style="border:0"/></td>
			<td align="right">未销户信用卡总授信额度（万）:</td>
			<td><input type="text" id="result21" name="result21" readonly="readonly" style="border:0"/></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td align="right">信用卡已用额度（万）:</td>
			<td><input type="text" id="result22" name="result22" readonly="readonly" style="border:0"/></td>
			<td align="right">信用卡额度使用率:</td>
			<td><input type="text" id="result23" name="result23" readonly="readonly" style="border:0"/></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td align="right">月平均POS金额（万）:</td>
			<td><input type="text" id="result24" name="result24" readonly="readonly" style="border:0"/></td>
			<td align="right">POS金额月波动率:</td>
			<td><input type="text" id="result25" name="result25" readonly="readonly" style="border:0"/></td>
			<td align="right">总POS交易月份数:</td>
			<td><input type="text" id="result26" name="result26" readonly="readonly" style="border:0"/></td>
		</tr>
		<tr>
			<td align="right">最近的有POS交易记录的月份:</td>
			<td><input type="text" id="result27" name="result27" readonly="readonly" style="border:0"/></td>
   			<td align="right">营业时间内的POS交易占比:</td>
   			<td><input type="text" id="result28" name="result28" readonly="readonly" style="border:0"/></td>
			<td></td>
			<td></td>
   		</tr>
   		<tr>
   			<td align="right">申请人人行工作单位1:</td>
   			<td colspan="5"><input type="text" id="result29" name="result29" readonly="readonly" style="border:0;width:400px"/></td>
   		</tr>
   		<tr>
   			<td align="right">申请人人行工作单位2:</td>
   			<td colspan="5"><input type="text" id="result30" name="result30" readonly="readonly" style="border:0;width:400px"/></td>
   		</tr>
   		<tr>
   			<td align="right">申请人人行工作单位3:</td>
   			<td colspan="5"><input type="text" id="result31" name="result31" readonly="readonly" style="border:0;width: 400px"/></td>
   		</tr>
   		<tr>
   			<td align="right">身份证归属地:</td>
   			<td><input type="text" id="result32" name="result32" readonly="readonly" style="border:0"/></td>
   			<td align="right">属相:</td>
   			<td><input type="text" id="result33" name="result33" readonly="readonly" style="border:0"/></td>
			<td></td>
			<td></td>
   		</tr>
   	</table>
   	<br/>
   	<br/>
   	<br/>
   </div>