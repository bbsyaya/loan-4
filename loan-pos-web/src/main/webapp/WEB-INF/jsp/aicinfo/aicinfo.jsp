<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	.title {background-color:#D4E7E6}
	.showrow {height:30px; font-weight:bolder;}
	.item {height:32px;}
	.poscustname{height:45px; font-weight:bolder;}
</style>

<head>
	<title>工商信息</title>
</head>
<table align="center" width="1000px">
	<tr class="poscustname">
		<td>${poscustName}</td>
	</tr>
	<tr>
		<td>订单号码:  ${orderNo}</td>
	</tr>
	<tr>
		<td>提交时间：  ${queryTime}</td>
	</tr>
	<tr>
		<td>完成时间:  ${finishTime}</td>
	</tr>
</table>
<br/><br/>
<c:if test="${punishBreak != null && not empty punishBreak}">
	<table align="center" border="1" width="1000px">
	<tr>
		<td class="title showrow" colspan="2">失信被执行人信息<font color="red">（试用）声明：本信息从公开渠道获得，且有可能存在数据延迟，仅供参考，不作为任何法律依据。如有疑问，请到最高人民法院和相关公示网站进一步核实。</font></td>
	</tr>
	<c:forEach items="${punishBreak}" var="obj">
	<tr>
		<td colspan="2">案号:${obj.caseCode}</td>
	</tr>
	<tr>
		<td width="40%">被执行人姓名/名称</td>
		<td width="60%">${obj.iNameClean}</td>
	</tr>
	<tr>
		<td width="40%">身份证号码/企业注册号</td>
		<td width="60%">${obj.cardNumClean}</td>
	</tr>
	<tr>
		<td width="40%">性别</td>
		<td width="60%">${obj.sexyClean}</td>
	</tr>
	<tr>
		<td width="40%">年龄</td>
		<td width="60%">${obj.ageClean}</td>
	</tr>
	<tr>
		<td width="40%">身份证号码</td>
		<td width="60%">${obj.cardNum}</td>
	</tr>
	<tr>
		<td width="40%">省份</td>
		<td width="60%">${obj.areaNameClean}</td>
	</tr>
	<tr>
		<td width="40%">身份证原始发证地</td>
		<td width="60%">${obj.ysFzd}</td>
	</tr>
	<tr>
		<td width="40%">执行法院</td>
		<td width="60%">${obj.courtName}</td>
	</tr>
	<tr>
		<td width="40%">立案时间</td>
		<td width="60%">${obj.regDateClean}</td>
	</tr>
	<tr>
		<td width="40%">发布时间</td>
		<td width="60%">${obj.publishDateClean}</td>
	</tr>
	<tr>
		<td width="40%">执行依据单位</td>
		<td width="60%">${obj.gistUnit}</td>
	</tr>
	<tr>
		<td width="40%">法律文书确定义务</td>
		<td width="60%">${obj.duty}</td>
	</tr>
	<tr>
		<td width="40%">失信被执行人行为具体情形</td>
		<td width="60%">${obj.disruptTypeName}</td>
	</tr>
	<tr>
		<td width="40%">被执行人履行情况</td>
		<td width="60%">${obj.performance}</td>
	</tr>
	<tr>
		<td width="40%">已履行</td>
		<td width="60%">${obj.performedPart}</td>
	</tr>
	<tr>
		<td width="40%">未履行</td>
		<td width="60%">${obj.unperformPart}</td>
	</tr>
	<tr>
		<td colspan="2"></td>
	</tr>
	</c:forEach>
</table>
</c:if>
<br/><br/>
<c:if test="${punished != null && not empty punished}">
<table align="center" border="1" width="1000px">
	<tr>
		<td class="title showrow" colspan="2">被执行人信息<font color="red">（试用）声明：本信息从公开渠道获得，且有可能存在数据延迟，仅供参考，不作为任何法律依据。如有疑问，请到最高人民法院和相关公示网站进一步核实。</font></td>
	</tr>
	<c:if test="${punished != null && not empty punished}">
	<c:forEach items="${punished}" var="obj">
	<tr>
		<td colspan="2">案号:${obj.caseCode}</td>
	</tr>
	<tr>
		<td width="40%">被执行人姓名/名称</td>
		<td width="60%">${obj.iNameClean}</td>
	</tr>
	<tr>
		<td width="40%">身份证号码/企业注册号</td>
		<td width="60%">${obj.cardNumClean}</td>
	</tr>
	<tr>
		<td width="40%">性别</td>
		<td width="60%">${obj.sexyClean}</td>
	</tr>
	<tr>
		<td width="40%">年龄</td>
		<td width="60%">${obj.ageClean}</td>
	</tr>
	<tr>
		<td width="40%">省份</td>
		<td width="60%">${obj.areaNameClean}</td>
	</tr>
	<tr>
		<td width="40%">身份证原始发证地</td>
		<td width="60%">${obj.ysFzd}</td>
	</tr>
	<tr>
		<td width="40%">执行法院</td>
		<td width="60%">${obj.courtName}</td>
	</tr>
	<tr>
		<td width="40%">立案时间</td>
		<td width="60%">${obj.regDateClean}</td>
	</tr>
	<tr>
		<td width="40%">案件状态</td>
		<td width="60%"></td>
	</tr>
	<tr>
		<td width="40%">执行标的（元）</td>
		<td width="60%"></td>
	</tr>
	<tr>
		<td width="40%">关注次数</td>
		<td width="60%"></td>
	</tr>
	</c:forEach>
	</c:if>
	<c:if test="${punished == null || empty punished}">
		<tr>
			<td>该项目无信息</td>
		</tr>
	</c:if>
</table>
</c:if>
<br/><br/>
<table align="center" border="1" width="1000px">
<tr>
	<td class="title showrow" colspan="2">企业照面（基本）信息</td>
</tr>
<c:if test="${basic != null && not empty basic}">
<c:forEach items="${basic}" var="obj">
<tr class="item">
	<td width="40%">企业名称</td>
	<td width="60%">${obj.entName}</td>
</tr>
<tr class="item">
	<td width="40%">法定代表人/负责人/执行事务合伙人</td>
	<td width="60%">${obj.frName}</td>
</tr>
<tr class="item">
	<td width="40%">注册号</td>
	<td width="60%">${obj.regNo}</td>
</tr>
<tr class="item">
	<td width="40%">原注册号</td>
	<td width="60%">${obj.oriRegNo}</td>
</tr>
<tr class="item">
	<td width="40%">注册资本（万元）</td>
	<td width="60%">${obj.regCap}</td>
</tr>
<tr class="item">
	<td width="40%">实收资本（万元）</td>
	<td width="60%">${obj.regCap}</td>
</tr>
<tr class="item">
	<td width="40%">注册资本币种</td>
	<td width="60%">${obj.regCapCur}</td>
</tr>
<tr class="item">
	<td width="40%">开业时间</td>
	<td width="60%">${obj.esDate}</td>
</tr>
<tr class="item">
	<td width="40%">企业（机构）类型</td>
	<td width="60%">${obj.entType}</td>
</tr>
<tr class="item">
	<td width="40%">经营状态</td>
	<td width="60%">${obj.entStatus}</td>
</tr>
<tr class="item">
	<td width="40%">注销日期</td>
	<td width="60%">${obj.canDate}</td>
</tr>
<tr class="item">
	<td width="40%">吊销日期</td>
	<td width="60%">${obj.revDate}</td>
</tr>
<tr class="item">
	<td width="40%">住址</td>
	<td width="60%">${obj.addr}</td>
</tr>
<tr class="item">
	<td width="40%">许可经营项目</td>
	<td width="60%">${obj.abuiTem}</td>
</tr>
<tr class="item">
	<td width="40%">一般经营项目</td>
	<td width="60%">${obj.cbuiTem}</td>
</tr>
<tr class="item">
	<td width="40%">经营（业务）范围</td>
	<td width="60%">${obj.opScope}</td>
</tr>
<tr class="item">
	<td width="40%">经营（业务）范围及方式</td>
	<td width="60%">${obj.opScoAndForm}</td>
</tr>
<tr class="item">
	<td width="40%">登记机关</td>
	<td width="60%">${obj.regOrg}</td>
</tr>
<tr class="item">
	<td width="40%">最后年检年度</td>
	<td width="60%">${obj.anCheYear}</td>
</tr>
<tr class="item">
	<td width="40%">行业门类代码</td>
	<td width="60%">${obj.industryPhyCode}</td>
</tr>
<tr class="item">
	<td width="40%">行业门类名称</td>
	<td width="60%"></td>
</tr>
<tr class="item">
	<td width="40%">国民经济行业代码</td>
	<td width="60%">${obj.industryCoCode}</td>
</tr>
<tr class="item">
	<td width="40%">国民经济行业名称</td>
	<td width="60%"></td>
</tr>
</c:forEach>
</c:if>
<c:if test="${basic == null || empty basic}">
	<tr>
		<td>该项无信息</td>
	</tr>
</c:if>
</table>
<br/></br>
<table align="center" border="1" width="1000px">
<tr>
	<td class="title showrow" colspan="6">股东及出资信息</td>
</tr>
<c:if test="${shareholder != null && not empty shareholder}">
<tr>
	<th>
		股东名称
	</th>
	<th>认缴出资额（万元）</th>
	<th>认缴出资币种</th>
	<th>出资比例</th>
	<th>出资日期</th>
	<th>国别</th>
<tr>
<c:forEach items="${shareholder}" var="obj">
	<tr>
		<td>${obj.shaName}</td>
		<td>${obj.subConAm}</td>
		<td>${obj.regCapCur}</td>
		<td>${obj.funDedRatio}</td>
		<td>${obj.conDate}</td>
		<td>中国</td>
	</tr>
</c:forEach>
</c:if>
<c:if test="${shareholder == null || empty shareholder}">
	<tr>
		<td colspan="6">该项无信息</td>
	</tr>
</c:if>
</table>
<br/>
<br/>
<table align="center" border="1" width="1000px">
	<tr>
	<td class="title showrow" colspan="3">主要管理人员</td>
	</tr>
	<c:if test="${person != null && not empty person}">
	<tr>
		<th>人员姓名</th>
		<th>职务</th>
		<th>性别</th>
	</tr>
	<c:forEach items="${person}" var="obj">
	<tr>
		<td>${obj.perName}</td>
		<td>${obj.position}</td>
		<td></td>
	</tr>
	</c:forEach>
	</c:if>
	<c:if test="${person == null || empty person}">
		<tr>
			<td>无该信息</td>
		</tr>
	</c:if>
</table>
<br/><br/>
<table align="center" border="1" width="1000px">
	<tr>
		<td class="title showrow" colspan="6">法定代表人对外投资</td>
	</tr>
	<c:if test="${frinv != null && not empty frinv}">
	<tr>
		<th>企业（机构名称）</th>
		<th>注册号</th>
		<th>企业（机构）类型</th>
		<th>注册资本（万元）</th>
		<th>企业状态</th>
		<th>注销日期</th>
		<th>吊销日期</th>
		<th>登记机关</th>
		<th>认缴出资额（万元）</th>
		<th>币种</th>
		<th>出资比例</th>
		<th>开业日期</th>
	</tr>
	<c:forEach items="${frinv}" var="obj">
		<tr>
			<td>${obj.entName}</td>
			<td>${obj.regNo}</td>
			<td>${obj.entType}</td>
			<td>${obj.regCap}</td>
			<td>${obj.entStatus}</td>
			<td>${obj.canDate}</td>
			<td>${obj.revDate}</td>
			<td>${obj.regOrg}</td>
			<td>${obj.subConAm}</td>
			<td>${obj.currency}</td>
			<td>${obj.funDedRatio}</td>
			<td>${obj.esDate}</td>
		</tr>
	</c:forEach>
	</c:if>
	<c:if test="${frinv == null ||  empty frinv}">
		<tr>
			<td>无该信息</td>
		</tr>
	</c:if>
</table>
<br/><br/>
<table align="center" border="1" width="1000px">
	<tr>
		<td class="title showrow" colspan="6">法定代表人其他公司任职</td>
	</tr>
	<c:if test="${frposition != null && not empty frposition}">
		<tr>
			<th>企业（机构）名称</th>
			<th>注册号</th>
			<th>企业（机构）类型</th>
			<th>注册资本（万元）</th>
			<th>企业状态</th>
			<th>注销日期</th>
			<th>吊销日期</th>
			<th>登记机关</th>
			<th>职务</th>
			<th>是否法定代表人<th>
			<th>开业日期</th>
		</tr>
		<c:forEach items="${frpostion}" var="obj">
			<tr>
				<td>${obj.entName}</td>
				<td>${obj.regNo}</td>
				<td>${obj.entType}</td>
				<td>${obj.regCap}</td>
				<td>${obj.entStatus}</td>
				<td>${obj.canDate}</td>
				<td>${obj.revDate}</td>
				<td>${obj.regOrg}</td>
				<td>${obj.position}</td>
				<td>${obj.lerepSign}</td>
				<td>${obj.esDate}</td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${frposition == null || empty frposition}">
		<tr>
			<td>无该信息</td>
		</tr>
	</c:if>
</table>
<br/><br/>
<table align="center" border="1" width="1000px">
	<tr>
		<td class="title showrow" colspan="6">企业对外投资</td>
	</tr>
	
	<c:if test="${entinv != null && not empty entinv}">
		<tr>
			<th>企业（机构）名称</th>
			<th>注册号</th>
			<th>企业（机构）类型</th>
			<th>注册资本（万元）</th>
			<th>企业状态</th>
			<th>注销日期</th>
			<th>吊销日期</th>
			<th>注销日期</th>
			<th>吊销日期</th>
			<th>登记机关</th>
			<th>认缴出资额（万元）</th>
			<th>币种</th>
			<th>出资比例</th>
			<th>开业日期</th>
		</tr>
		<c:forEach items="${entinv}" var="obj">
			<tr>
				<td>${obj.entName}</td>
				<td>${obj.regNo}</td>
				<td>${obj.entType}</td>
				<td>${obj.regCap}</td>
				<td>${obj.entStatus}</td>
				<td>${obj.canDate}</td>
				<td>${obj.revDate}</td>
				<td>${obj.regOrg}</td>
				<td>${obj.subConAm}</td>
				<td>${obj.congroCur}</td>
				<td>${obj.funDedRatio}</td>
				<td>${obj.esDate}</td>
			</tr>
		</c:forEach>
		</c:if>
		<c:if test="${entinv == null || empty entinv}">
			<tr>
			<td>该项无信息</td>
			</tr>
		</c:if>
</table>
<br/><br/>
<table align="center" border="1" width="1000px">
	<tr>
		<td class="title showrow" colspan="2">动产抵押信息</td>
	</tr>
	<c:if test="${mordetai != null && not empty mordetai}">
		<c:forEach items="${mordetai}" var="obj">
		<tr>
			<td>抵押ID</td>
			<td>${obj.morRegId}</td>
		</tr>
		<tr>
			<td>抵押人</td>
			<td>${obj.mortGagor}</td>
		</tr>
		<tr>
			<td>抵押权人</td>
			<td>${obj.more}</td>
		</tr>
		<tr>
			<td>登记机关</td>
			<td>${obj.regOrg}</td>
		</tr>
		<tr>
			<td>登记日期</td>
			<td>${obj.regiDate}</td>
		</tr>
		<tr>
			<td>状态标识</td>
			<td>${obj.morType}</td>
		</tr>
		<tr>
			<td>登记证号</td>
			<td>${obj.morRegcNo}</td>
		</tr>
		<tr>
			<td>申请抵押原因</td>
			<td>${obj.appRegRea}</td>
		</tr>
		<tr>
			<td>被担保主债权种类</td>
			<td>${obj.priClasecKind}</td>
		</tr>
		<tr>
			<td>被担保主债权数额(万元)</td>
			<td>${obj.priClasecAm}</td>
		</tr>
		<tr>
			<td>履约起始日期</td>
			<td>${obj.pefPerForm}</td>
		</tr>
		<tr>
			<td>履约截止日期</td>
			<td>${obj.pefPerTo}</td>
		</tr>
		<tr>
			<td>注销日期</td>
			<td>${obj.canDate}</td>
		</tr>
		<tr>
			<td colspan="2"></td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${mordetail == null || empty mordetai}">
		<tr>
			<td>该项无信息</td>
		</tr>
	</c:if>
</table>
<br/><br/>
<table align="center" border="1" width="1000px">
	<tr>
		<td class="title showrow" colspan="2">动产抵押物信息</td>
	</tr>
	<c:if test="${morguaInfo != null && not empty morguaInfo}">
		<c:forEach items="${morguaInfo}" var="obj">
			<tr>
				<td>抵押ID</td>
				<td>${obj.morRegId}</td>
			</tr>
			<tr>
				<td>抵押物名称</td>
				<td>${obj.guaName}</td>
			</tr>
			<tr>
				<td>数量</td>
				<td>${obj.quan}</td>
			</tr>
			<tr>
				<td>价值(万元)</td>
				<td>${obj.value}</td>
			</tr>
			<tr>
				<td colspan="2"></td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${morguaInfo == null || empty morguaInfo}">
		<tr>
			<td>该项无信息</td>
		</tr>
	</c:if>
</table>
<br/><br/>
<table align="center" border="1" width="1000px">
	<tr>
		<td class="title showrow" colspan="4">历史变更信息</td>
	</tr>
	<c:if test="${alter != null && not empty alter}">
	<tr>
		<th>变更日期</th>
		<th>变更事项</th>
		<th>变更前内容</th>
		<th>变更后内容</th>
	</tr>
		<c:forEach items="${alter}" var="obj">
			<tr>
				<td>${obj.altDate}</td>
				<td>${obj.altItem}</td>
				<td>${obj.altBe}</td>
				<td>${obj.altAf}</td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${alter == null || empty alter}">
		<tr>
		<td>该项无信息</td>
	</tr>
	</c:if>
</table>
<br/><br/>
<table align="center" border="1" width="1000px">
	
	<tr>
		<td class="title showrow" colspan="7">清算信息</td>
	</tr>
	<c:if test="${liquidation != null && not empty liquidation}">
		<tr>
			<th>清算责任人</th>
			<th>清算负责人</th>
			<th>清算组成员</th>
			<th>清算完结情况</th>
			<th>清算完结日期</th>
			<th>债务承接人</th>
			<th>债权承接人</th>
		</tr>
		<c:forEach items="${liquidation}" var="obj">
			<tr>
				<td>${obj.ligEntity}</td>
				<td>${obj.ligPrincipal}</td>
				<td>${obj.liqMen}</td>
				<td>${obj.ligSt}</td>
				<td>${obj.ligEndDate}</td>
				<td>${obj.debtTranee}</td>
				<td>${obj.claimTranee}</td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${liquidation == null || empty liquidation}">
	<tr>
		<td>该项无信息</td>
	</tr>
	</c:if>
</table>
<br/><br/>
<table align="center" border="1" width="1000px">
	<tr>
		<td class="title showrow" colspan="4">分支机构</td>
	</tr>
	<tr>
		<td>该项无信息</td>
	</tr>
</table>
<br/><br/>
<table align="center" border="1" width="1000px">
	<tr>
		<td class="title showrow" colspan="7">股权出质历史（试用）</td>
	</tr>
	<c:if test="${sharesImpawn != null && not empty sharesImpawn}">
		<tr>
			<th>质权人姓名</th>
			<th>质权人类别</th>
			<th>出质金额</th>
			<th>出质备案日期</th>
			<th>出质审批部门</th>
			<th>出质批准日期</th>
			<th>出质截至日期</th>
		</tr>
		<c:forEach items="${sharesImpawn}" var="obj">
			<tr>
				<td>${obj.impOrg}</td>
				<td>${obj.impOrgType}</td>
				<td>${obj.impAm}</td>
				<td>${obj.impOnRecDate}</td>
				<td>${obj.impExAeep}</td>
				<td>${obj.impSanDate}</td>
				<td>${obj.impTo}</td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${sharesImpawn == null || empty sharesImpawn}">
		<tr>
			<td>该项无信息</td>
		</tr>
	</c:if>
	
</table>
<br/><br/>
<table align="center" border="1" width="1000px">
	<tr>
		<td class="title showrow" colspan="9">股权冻结历史（试用）</td>
	</tr>
	<c:if test="${shareFro != null && not empty shareFro}">
		<tr>
			<th>冻结文号</th>
			<th>冻结机关</th>
			<th>冻结起始日期</th>
			<th>冻结截至日期</th>
			<th>冻结金额</th>
			<th>解冻机关</th>
			<th>解冻文号</th>
			<th>解冻日期</th>
			<th>解冻说明</th>
		</tr>
		<c:forEach items="${shareFro}" var="obj">
			<tr>
				<td>${obj.froDocNo}</td>
				<td>${obj.froAuth}</td>
				<td>${obj.froFrom}</td>
				<td>${obj.froTo}</td>
				<td>${obj.froAm}</td>
				<td>${obj.thawAuth}</td>
				<td>${obj.thawDocNo}</td>
				<td>${obj.thawDate}</td>
				<td>${obj.thawComment}</td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${shareFro == null || empty shareFro}">
	<tr>
		<td>该项无信息</td>
	</tr>
	</c:if>
</table>
<br/><br/>
<table align="center" border="1" width="1000px">
	<tr>
		<td class="title showrow" colspan="4">行政处罚历史（试用）</td>
	</tr>
	<c:if test="${caseinfo != null && not empty caseinfo}">
	<tr>
		<th>
			案发时间
		</th>
		<th>案由</th>
		<th>案值</th>
		<th>案件类型</th>
		<th>执行类别</th>
		<th>案件结果</th>
		<th>处罚决定书</th>
		<th>处罚决定书签发日期</th>
		<th>处罚机关</th>
		<th>主要违法事实</th>
		<th>处罚依据</th>
		<th>处罚种类</th>
		<th>处罚结果</th>
		<th>处罚金额</th>
		<th>处罚执行情况</th>
		</tr>
		<c:forEach items="${caseinfo}" var="obj">
		<tr>
			<td>${obj.caseTime}</td>
			<td>${obj.caseReason}</td>
			<td>${obj.caseVal}</td>
			<td>${obj.caseType}</td>
			<td>${obj.exeSort}</td>
			<td>${obj.caseResult}</td>
			<td>${obj.pendecNo}</td>
			<td>${obj.pendecissDate}</td>
			<td>${obj.penAuth}</td>
			<td>${obj.illegFact}</td>
			<td>${obj.penBasis}</td>
			<td>${obj.penType}</td>
			<td>${obj.penResult}</td>
			<td>${obj.penAm}</td>
			<td>${obj.penExest}</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${caseinfo == null || empty caseinfo}">
		<tr>
			<td>该项无信息</td>
		</tr>
	</c:if>
</table>
<br/><br/>
<table align="center" border="1" width="1000px">
	<tr>
		<td class="title showrow" colspan="4">企业年检情况（试用）</td>
	</tr>
	<tr>
		<td>该项无信息</td>
	</tr>
</table>
<br/><br/>
<c:if test="${punished == null || empty punished}">
<table align="center" border="1" width="1000px">
	<tr>
		<td class="title showrow" colspan="2">被执行人信息<font color="red">（试用）声明：本信息从公开渠道获得，且有可能存在数据延迟，仅供参考，不作为任何法律依据。如有疑问，请到最高人民法院和相关公示网站进一步核实。</font></td>
	</tr>
	<c:if test="${punished != null && not empty punished}">
	<c:forEach items="${punished}" var="obj">
	<tr>
		<td colspan="2">案号:${obj.caseCode}</td>
	</tr>
	<tr>
		<td width="40%">被执行人姓名/名称</td>
		<td width="60%">${obj.iNameClean}</td>
	</tr>
	<tr>
		<td width="40%">身份证号码/企业注册号</td>
		<td width="60%">${obj.cardNumClean}</td>
	</tr>
	<tr>
		<td width="40%">性别</td>
		<td width="60%">${obj.sexyClean}</td>
	</tr>
	<tr>
		<td width="40%">年龄</td>
		<td width="60%">${obj.ageClean}</td>
	</tr>
	<tr>
		<td width="40%">省份</td>
		<td width="60%">${obj.areaNameClean}</td>
	</tr>
	<tr>
		<td width="40%">身份证原始发证地</td>
		<td width="60%">${obj.ysFzd}</td>
	</tr>
	<tr>
		<td width="40%">执行法院</td>
		<td width="60%">${obj.courtName}</td>
	</tr>
	<tr>
		<td width="40%">立案时间</td>
		<td width="60%">${obj.regDateClean}</td>
	</tr>
	<tr>
		<td width="40%">案件状态</td>
		<td width="60%">${obj.caseState}</td>
	</tr>
	<tr>
		<td width="40%">执行标的（元）</td>
		<td width="60%">${obj.execMoney}</td>
	</tr>
	<tr>
		<td width="40%">关注次数</td>
		<td width="60%">${obj.focusNumber}</td>
	</tr>
	</c:forEach>
	</c:if>
	<c:if test="${punished == null || empty punished}">
		<tr>
			<td>该项目无信息</td>
		</tr>
	</c:if>
</table>
</c:if>
<c:if test="${punishBreak == null || empty punishBreak}">
<br/><br/>
	<table align="center" border="1" width="1000px">
	<tr>
		<td class="title showrow" colspan="2">失信被执行人信息<font color="red">（试用）声明：本信息从公开渠道获得，且有可能存在数据延迟，仅供参考，不作为任何法律依据。如有疑问，请到最高人民法院和相关公示网站进一步核实。</font></td>
	</tr>
	<tr>
		<td>该项无信息</td>
	</tr>
</table>
</c:if>
</html>