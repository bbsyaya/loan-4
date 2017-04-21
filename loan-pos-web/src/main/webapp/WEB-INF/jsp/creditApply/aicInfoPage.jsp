<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href='<%=request.getContextPath()%>/css/common.css' />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src='<%=request.getContextPath()%>/js/locale/easyui-lang-zh_CN.js'></script>
<script type="text/javascript"
	src='<%=request.getContextPath()%>/js/validator.js'></script>
<script type="text/javascript"
	src='<%=request.getContextPath()%>/js/review/reviewNote.js'></script>
<script type="text/javascript"
	src='<%=request.getContextPath()%>/js/common_uiext.js'></script>
<style>
table {
	width: 100%
}

.tdtitle {
	width: 20%;
	background-color: #E0ECFF;
	word-break
}

.tdcontent {
	width: 30%;
	border: #E0ECFF solid 1px
}
.tdcontent_color{
	width: 30%;
	border: #E0ECFF solid 1px;
	color:red
}
table{
font-size:12px
}
legend{
font-size:12px
}
</style>
</head>
<body>
	<div title="工商信息" style="padding: 20px;">
		<c:if test="${aicInfo == null}">
			<div>
				<h3>没有查到工商信息</h3>
			</div>
		</c:if>
		<c:if test="${aicInfo != null}">
			<fieldset style="padding: 5px; color: #333; border: #06c dashed 1px;">
				<legend id="t_aic_orderlist_info" class='dialog-label'
					style="color: #06c; font-weight: 800; background: #fff;">订单信息</legend>
				<table>
					<c:forEach items="${aicInfo.orderListMap}" var="orderlist" varStatus="index">
						<c:if test="${aicInfo.orderListMap !=null && aicInfo.orderListMap.size() > 1}">
						<tr>
							<td class="tdtitle">记录数:</td>
							<td class="tdcontent_color">${index.index + 1}</td>
						</tr>
						</c:if>
						<tr>
							<td class="tdtitle">商户号:</td>
							<td class="tdcontent">${orderlist.posCustId}</td>
							<td class="tdtitle">流水号:</td>
							<td class="tdcontent">${orderlist.orderNo}</td>
						</tr>
						<tr>
							<td class="tdtitle">查询用的id:</td>
							<td class="tdcontent">${orderlist.queryUid}</td>
							<td class="tdtitle">商户名:</td>
							<td class="tdcontent">${orderlist.posCustName}</td>
						</tr>
						<tr>
							<td class="tdtitle">查询类型:</td>
							<td class="tdcontent">${orderlist.keyType}</td>
							<td class="tdtitle">查询状态:</td>
							<td class="tdcontent">${orderlist.status}</td>
						</tr>
						<tr>
							<td class="tdtitle">查询时间:</td>
							<td class="tdcontent">${orderlist.queryTime}</td>
						</tr>
					</c:forEach>
				</table>
			</fieldset>

			<fieldset style="padding: 5px; color: #333; border: #06c dashed 1px;">
				<legend id="t_aic_basic_info" class='dialog-label'
					style="color: #06c; font-weight: 800; background: #fff;">业务照面信息</legend>
				<table>
					<c:forEach items="${aicInfo.basicMap}" var="basic" varStatus="index">
						<c:if test="${aicInfo.basicMap !=null && aicInfo.basicMap.size() > 1}">
						<tr>
							<td class="tdtitle">记录数:</td>
							<td class="tdcontent_color">${index.index + 1}</td>
						</tr>
						</c:if>
						<tr>
							<td class="tdtitle">商户号:</td>
							<td class="tdcontent">${basic.posCustId}</td>
							<td class="tdtitle">流水号:</td>
							<td class="tdcontent">${basic.orderNo}</td>
						</tr>
						<tr>
							<td class="tdtitle">法定代表人姓名:</td>
							<td class="tdcontent">${basic.frName}</td>
							<td class="tdtitle">注册号:</td>
							<td class="tdcontent">${basic.regNo}</td>
						</tr>
						<tr>
							<td class="tdtitle">注册资本:</td>
							<td class="tdcontent">${basic.regCap}</td>
							<td class="tdtitle">币种:</td>
							<td class="tdcontent">${basic.regCapCur}</td>
						</tr>
						<tr>
							<td class="tdtitle">经营状况:</td>
							<td class="tdcontent">${basic.entStatus}</td>
							<td class="tdtitle">企业机构类型:</td>
							<td class="tdcontent">${basic.entType}</td>
						</tr>
						<tr>
							<td class="tdtitle">开业日期:</td>
							<td class="tdcontent">${basic.esDate}</td>
							<td class="tdtitle">经营期限自:</td>
							<td class="tdcontent">${basic.opFrom}</td>
						</tr>
						<tr>
							<td class="tdtitle">经营期限至:</td>
							<td class="tdcontent">${basic.opTo}</td>
							<td class="tdtitle">地址:</td>
							<td class="tdcontent">${basic.addr}
							<td class="tdtitle">
						</tr>
						<tr>
							<td class="tdtitle">登记机关:</td>
							<td class="tdcontent">${basic.regOrg}</td>
							<td class="tdtitle">许可经营项目:</td>
							<td class="tdcontent">${basic.abuiTem}</td>
						</tr>
						<tr>
							<td class="tdtitle">一般经营项目:</td>
							<td class="tdcontent">${basic.cbuiTem}</td>
							<td class="tdtitle">经营业务范围:</td>
							<td class="tdcontent">${basic.opScope}</td>
						</tr>
						<tr>
							<td class="tdtitle">经营业务范围及方式:</td>
							<td class="tdcontent">${basic.opScoAndForm}</td>
							<td class="tdtitle">最后年检年度:</td>
							<td class="tdcontent">${basic.anCheYear}</td>
						</tr>
						<tr>
							<td class="tdtitle">注销日期:</td>
							<td class="tdcontent">${basic.canDate}</td>
							<td class="tdtitle">吊销日期:</td>
							<td class="tdcontent">${basic.revDate}</td>
						</tr>
						<tr>
							<td class="tdtitle">最后年检日期:</td>
							<td class="tdcontent">${basic.anCheDate}</td>
							<td class="tdtitle">行业门类代码:</td>
							<td class="tdcontent">${basic.industryPhyCode}</td>
						</tr>
						<tr>
							<td class="tdtitle">国民经济行业代码:</td>
							<td class="tdcontent">${basic.industryCoCode}</td>
							<td class="tdtitle">中数人员身份ID:</td>
							<td class="tdcontent">${basic.cdId}</td>
					</c:forEach>
				</table>
			</fieldset>

			<fieldset style="padding: 5px; color: #333; border: #06c dashed 1px;">
				<legend id="t_aic_shareholder_info" class='dialog-label'
					style="color: #06c; font-weight: 800; background: #fff;">企业股东及主次信息</legend>
				<table>
					<c:forEach items="${aicInfo.shareholderMap}" var="shareholder" varStatus="index">
						<c:if test="${aicInfo.shareholderMap !=null && aicInfo.shareholderMap.size() > 1}">
						<tr>
							<td class="tdtitle">记录数:</td>
							<td class="tdcontent_color">${index.index + 1}</td>
						</tr>
						</c:if>
						<tr>
							<td class="tdtitle">商户号:</td>
							<td class="tdcontent">${shareholder.posCustId}</td>
							<td class="tdtitle">流水号:</td>
							<td class="tdcontent">${shareholder.orderNo}</td>
						</tr>
						<tr>
							<td class="tdtitle">股东名称:</td>
							<td class="tdcontent">${shareholder.shaName}</td>
							<td class="tdtitle">认缴出金额:</td>
							<td class="tdcontent">${shareholder.subConAm}</td>
						</tr>
						<tr>
							<td class="tdtitle">币种:</td>
							<td class="tdcontent">${shareholder.regCapCur}</td>
							<td class="tdtitle">出资日期:</td>
							<td class="tdcontent">${shareholder.conDate}</td>
						</tr>
						<tr>
							<td class="tdtitle">中数人员身份:</td>
							<td class="tdcontent">${shareholder.cdId}</td>
						</tr>
					</c:forEach>
				</table>
			</fieldset>

			<fieldset style="padding: 5px; color: #333; border: #06c dashed 1px;">
				<legend id="t_aic_person_info" class='dialog-label'
					style="color: #06c; font-weight: 800; background: #fff;">企业主要管理人员信息</legend>
				<table>
					<c:forEach items="${aicInfo.personMap}" var="person" varStatus="index">
						<c:if test="${aicInfo.personMap !=null && aicInfo.personMap.size() > 1}">
						<tr>
							<td class="tdtitle">记录数:</td>
							<td class="tdcontent_color">${index.index + 1}</td>
						</tr>
						</c:if>
						<tr>
							<td class="tdtitle">商户号:</td>
							<td class="tdcontent">${person.posCustId}</td>
							<td class="tdtitle">流水号:</td>
							<td class="tdcontent">${person.orderNo}</td>
						</tr>
						<tr>
							<td class="tdtitle">人员姓名:</td>
							<td class="tdcontent">${person.perName}</td>
							<td class="tdtitle">职务:</td>
							<td class="tdcontent">${person.position}</td>
						</tr>
						<tr>
							<td class="tdtitle">中数人员身份ID:</td>
							<td class="tdcontent">${person.cdId}</td>
						</tr>
					</c:forEach>
				</table>
			</fieldset>

			<fieldset style="padding: 5px; color: #333; border: #06c dashed 1px;">
				<legend id="t_aic_frinv_info" class='dialog-label'
					style="color: #06c; font-weight: 800; background: #fff;">企业法定代表人对外投资信息</legend>
				<table>
					<c:forEach items="${aicInfo.frinvMap}" var="frinv" varStatus="index">
						<c:if test="${aicInfo.frinvMap !=null && aicInfo.frinvMap.size() > 1}">
						<tr>
							<td class="tdtitle">记录数:</td>
							<td class="tdcontent_color">${index.index + 1}</td>
						</tr>
						</c:if>
						<tr>
							<td class="tdtitle">商户号:</td>
							<td class="tdcontent">${frinv.posCustId}</td>
							<td class="tdtitle">流水号:</td>
							<td class="tdcontent">${frinv.orderNo}</td>
						</tr>
						<tr>
							<td class="tdtitle">企业机构名称:</td>
							<td class="tdcontent">${frinv.entName}</td>
							<td class="tdtitle">注册号:</td>
							<td class="tdcontent">${frinv.regNo}</td>
						</tr>
						<tr>
							<td class="tdtitle">企业机构类型:</td>
							<td class="tdcontent">${frinv.entType}</td>
							<td class="tdtitle">注册资本:</td>
							<td class="tdcontent">${frinv.regCap}</td>
						</tr>
						<tr>
							<td class="tdtitle">企业状态:</td>
							<td class="tdcontent">${frinv.entStatus}</td>
							<td class="tdtitle">登记机关:</td>
							<td class="tdcontent">${frinv.regOrg}</td>
						</tr>
						<tr>
							<td class="tdtitle">认缴出资额:</td>
							<td class="tdcontent">${frinv.subConAm}</td>
							<td class="tdtitle">币种:</td>
							<td class="tdcontent">${frinv.currency}</td>
						</tr>
					</c:forEach>
				</table>
			</fieldset>

			<fieldset style="padding: 5px; color: #333; border: #06c dashed 1px;">
				<legend id="t_aic_frposition_info" class='dialog-label'
					style="color: #06c; font-weight: 800; background: #fff;">企业法定代表人其他公司任职信息</legend>
				<table>
					<c:forEach items="${aicInfo.frpositionMap}" var="frposition" varStatus="index">
						<c:if test="${aicInfo.frpositionMap !=null && aicInfo.frpositionMap.size() > 1}">
						<tr>
							<td class="tdtitle">记录数:</td>
							<td class="tdcontent_color">${index.index + 1}</td>
						</tr>
						</c:if>
						<tr>
							<td class="tdtitle">商户号:</td>
							<td class="tdcontent">${frposition.posCustId}</td>
							<td class="tdtitle">流水号:</td>
							<td class="tdcontent">${frposition.orderNo}</td>
						</tr>
						<tr>
							<td class="tdtitle">企业机构名称:</td>
							<td class="tdcontent">${frposition.entName}</td>
							<td class="tdtitle">注册号:</td>
							<td class="tdcontent">${frposition.regNo}</td>
						</tr>
						<tr>
							<td class="tdtitle">企业（机构）类型:</td>
							<td class="tdcontent">${frposition.entType}</td>
							<td class="tdtitle">注册资本:</td>
							<td class="tdcontent">${frposition.regCap}</td>
						</tr>
						<tr>
							<td class="tdtitle">企业状态:</td>
							<td class="tdcontent">${frposition.entStatus}</td>
							<td class="tdtitle">登记机关:</td>
							<td class="tdcontent">${frposition.regOrg}</td>
						</tr>
						<tr>
							<td class="tdtitle">职务:</td>
							<td class="tdcontent">${frposition.position}</td>
							<td class="tdtitle">是否法定代表人:</td>
							<td class="tdcontent">${frposition.lerepSign}</td>
						</tr>
					</c:forEach>
				</table>
			</fieldset>

			<fieldset style="padding: 5px; color: #333; border: #06c dashed 1px;">
				<legend id="t_aic_entinv_info" class='dialog-label'
					style="color: #06c; font-weight: 800; background: #fff;">企业对外投资信息</legend>
				<table>
					<c:forEach items="${aicInfo.entinvMap}" var="entinv" varStatus="index">
						<c:if test="${aicInfo.entinvMap !=null && aicInfo.entinvMap.size() > 1}">
						<tr>
							<td class="tdtitle">记录数:</td>
							<td class="tdcontent_color">${index.index + 1}</td>
						</tr>
						</c:if>
						<tr>
							<td class="tdtitle">商户号:</td>
							<td class="tdcontent">${entinv.posCustId}</td>
							<td class="tdtitle">流水号:</td>
							<td class="tdcontent">${entinv.orderNo}</td>
						</tr>
						<tr>
							<td class="tdtitle">企业（机构）类型:</td>
							<td class="tdcontent">${entinv.entName}</td>
							<td class="tdtitle">注册资本:</td>
							<td class="tdcontent">${entinv.regCap}</td>
						</tr>
						<tr>
							<td class="tdtitle">企业状态:</td>
							<td class="tdcontent">${entinv.entStatus}</td>
							<td class="tdtitle">登记机关:</td>
							<td class="tdcontent">${entinv.regOrg}</td>
						</tr>
						<tr>
							<td class="tdtitle">认缴出资额:</td>
							<td class="tdcontent">${entinv.subConAm}</td>
							<td class="tdtitle">币种:</td>
							<td class="tdcontent">${entinv.congroCur}</td>
						</tr>
					</c:forEach>
				</table>
			</fieldset>

			<fieldset style="padding: 5px; color: #333; border: #06c dashed 1px;">
				<legend id="t_aic_case_info" class='dialog-label'
					style="color: #06c; font-weight: 800; background: #fff;">行政处罚信息</legend>
				<table>
					<c:forEach items="${aicInfo.caseMap}" var ="caseMap" varStatus="index">
						<c:if test="${aicInfo.caseMap !=null && aicInfo.caseMap.size() > 1}">
						<tr>
							<td class="tdtitle">记录数:</td>
							<td class="tdcontent_color">${index.index + 1}</td>
						</tr>
						</c:if>
						<tr>
							<td class="tdtitle">商户号:</td>
							<td class="tdcontent">${caseMap.posCustId}</td>
							<td class="tdtitle">流水号</td>
							<td class="tdcontent">${caseMap.orderNo}</td>
						</tr>
						 <tr>
							<td class="tdtitle">案发时间</td>
							<td class="tdcontent">${caseMap.caseTime}</td>
							<td class="tdtitle">案由</td>
							<td class="tdcontent">${caseMap.caseReason}</td>
						</tr>
						<tr>
							<td class="tdtitle">案值</td>
							<td class="tdcontent">${caseMap.caseVal}</td>
							<td class="tdtitle">案件类型</td>
							<td class="tdcontent">${caseMap.caseType}</td>
						</tr>
						<tr>
							<td class="tdtitle">执行类型</td>
							<td class="tdcontent">${caseMap.exeSort}</td>
							<td class="tdtitle">案件结果</td>
							<td class="tdcontent">${caseMap.caseResult}</td>
						</tr>
						<tr>
							<td class="tdtitle">处罚判决书</td>
							<td class="tdcontent">${caseMap.pendecNo}</td>
							<td class="tdtitle">处罚判决书签发日期</td>
							<td class="tdcontent">${caseMap.pendecissDate}</td>
						</tr>
						<tr>
							<td class="tdtitle">处罚机关</td>
							<td class="tdcontent">${caseMap.penAuth}</td>
							<td class="tdtitle">主要违法事实</td>
							<td class="tdcontent">${caseMap.illegFact}</td>
						</tr>
						<tr>
							<td class="tdtitle">处罚依据</td>
							<td class="tdcontent">${caseMap.penBasis}</td>
							<td class="tdtitle">处罚类型</td>
							<td class="tdcontent">${caseMap.penType}</td>
						</tr>
						<tr>
							<td class="tdtitle">处罚结果</td>
							<td class="tdcontent">${caseMap.penResult}</td>
							<td class="tdtitle">处罚金额</td>
							<td class="tdcontent">${caseMap.penAm}</td>
						</tr>
						<tr>
							<td class="tdtitle">处罚执行情况</td>
							<td class="tdcontent">${caseMap.penExest}</td>
						</tr>
					</c:forEach>
				</table>
			</fieldset>

			<fieldset style="padding: 5px; color: #333; border: #06c dashed 1px;">
				<legend id="t_aic_punish_break_info" class='dialog-label'
					style="color: #06c; font-weight: 800; background: #fff;">失信被执行人信息</legend>
				<table>
					<c:forEach items="${aicInfo.punishBreakMap}" var="punishBreak" varStatus="index">
						<c:if test="${aicInfo.punishBreakMap !=null && aicInfo.punishBreakMap.size() > 1}">
						<tr>
							<td class="tdtitle">记录数:</td>
							<td class="tdcontent_color">${index.index + 1}</td>
						</tr>
						</c:if>
						<tr>
							<td class="tdtitle">商户号:</td>
							<td class="tdcontent">${punishBreak.posCustId}</td>
							<td class="tdtitle">流水号:</td>
							<td class="tdcontent">${punishBreak.orderNo}</td>
						</tr>
						<tr>
							<td class="tdtitle">案号:</td>
							<td class="tdcontent">${punishBreak.caseCode}</td>
							<td class="tdtitle">被执行人名称:</td>
							<td class="tdcontent">${punishBreak.iNameClean}</td>
						</tr>
						<tr>
							<td class="tdtitle">失信人类型:</td>
							<td class="tdcontent">${punishBreak.type}</td>
							<td class="tdtitle">性别:</td>
							<td class="tdcontent">${punishBreak.sexyClean}</td>
						</tr>
						<tr>
							<td class="tdtitle">年龄:</td>
							<td class="tdcontent">${punishBreak.ageClean}</td>
							<td class="tdtitle">身份证号码/工商注册号:</td>
							<td class="tdcontent">${punishBreak.cardNum}</td>
						</tr>
						<tr>
							<td class="tdtitle">身份证原始发证地:</td>
							<td class="tdcontent">${punishBreak.ysFzd}</td>
							<td class="tdtitle">法定代表人/负责人姓名:</td>
							<td class="tdcontent">${punishBreak.businessEntity}</td>
						</tr>
						<tr>
							<td class="tdtitle">立案时间:</td>
							<td class="tdcontent">${punishBreak.regDateClean}</td>
							<td class="tdtitle">公布时间:</td>
							<td class="tdcontent">${punishBreak.publishDateClean}</td>
						</tr>
						<tr>
							<td class="tdtitle">执行法院:</td>
							<td class="tdcontent">${punishBreak.courtName}</td>
							<td class="tdtitle">省份:</td>
							<td class="tdcontent">${punishBreak.areaNameClean}</td>
						</tr>
						<tr>
							<td class="tdtitle">执行依据文号:</td>
							<td class="tdcontent">${punishBreak.gistId}</td>
							<td class="tdtitle">做出执行依据单位:</td>
							<td class="tdcontent">${punishBreak.gistUnit}</td>
						</tr>
						<tr>
							<td class="tdtitle">生效法律文书确定的义务:</td>
							<td class="tdcontent">${punishBreak.duty}</td>
							<td class="tdtitle">失信被执行人行为具体情形:</td>
							<td class="tdcontent">${punishBreak.disruptTypeName}</td>
						</tr>
						<tr>
							<td class="tdtitle">被执行人履行的情况:</td>
							<td class="tdcontent">${punishBreak.performance}</td>
							<td class="tdtitle">已履行:</td>
							<td class="tdcontent">${punishBreak.performedPart}</td>
						</tr>
						<tr>
							<td class="tdtitle">未履行:</td>
							<td class="tdcontent">${punishBreak.unperformPart}</td>
							<td class="tdtitle">关注次数:</td>
							<td class="tdcontent">${punishBreak.focusNumber}</td>
						</tr>
					</c:forEach>
				</table>
			</fieldset>

			<fieldset style="padding: 5px; color: #333; border: #06c dashed 1px;">
				<legend id="t_aic_punished_info" class='dialog-label'
					style="color: #06c; font-weight: 800; background: #fff;">被执行人信息</legend>
				<table>
					<c:forEach items="${aicInfo.punishedMap}" var="punished" varStatus="index">
						<c:if test="${aicInfo.punishedMap !=null && aicInfo.punishedMap.size() > 1}">
						<tr>
							<td class="tdtitle">记录数:</td>
							<td class="tdcontent_color">${index.index + 1}</td>
						</tr>
						</c:if>
						<tr>
							<td class="tdtitle">商户号:</td>
							<td class="tdcontent">${punished.posCustId}</td>
							<td class="tdtitle">流水号:</td>
							<td class="tdcontent">${punished.orderNo}</td>
						</tr>
						<tr>
							<td class="tdtitle">案号:</td>
							<td class="tdcontent">${punished.caseCode}</td>
							<td class="tdtitle">被执行姓名:</td>
							<td class="tdcontent">${punished.iNameClean}</td>
						</tr>
						<tr>
							<td class="tdtitle">身份证号码/企业注册号:</td>
							<td class="tdcontent">${punished.cardNumClean}</td>
							<td class="tdtitle">性别:</td>
							<td class="tdcontent">${punished.sexyClean}</td>
						</tr>
						<tr>
							<td class="tdtitle">省份:</td>
							<td class="tdcontent">${punished.areaNameClean}</td>
							<td class="tdtitle">身份证发证地:</td>
							<td class="tdcontent">${punished.ysFzd}</td>
						</tr>
						<tr>
							<td class="tdtitle">执行法院:</td>
							<td class="tdcontent">${punished.courtName}</td>
							<td class="tdtitle">立案时间:</td>
							<td class="tdcontent">${punished.regDateClean}</td>
						</tr>
						<tr>
							<td class="tdtitle">案件状态:</td>
							<td class="tdcontent">${punished.caseState}</td>
							<td class="tdtitle">执行标的:</td>
							<td class="tdcontent">${punished.execMoney}</td>
						</tr>
						<tr>
							<td class="tdtitle">关注次数:</td>
							<td class="tdcontent">${punished.focusNumber}</td>
						</tr>
					</c:forEach>
				</table>
			</fieldset>

			<fieldset style="padding: 5px; color: #333; border: #06c dashed 1px;">
				<legend id="t_aic_alidebt_info" class='dialog-label'
					style="color: #06c; font-weight: 800; background: #fff;">阿里欠款</legend>
				<table>
					<c:forEach items="${aicInfo.alidebtMap}" var="alidebt" varStatus="index">
						<c:if test="${aicInfo.alidebtMap !=null && aicInfo.alidebtMap.size() > 1}">
						<tr>
							<td class="tdtitle">记录数:</td>
							<td class="tdcontent_color">${index.index + 1}</td>
						</tr>
						</c:if>
						<tr>
							<td class="tdtitle">商户号:</td>
							<td class="tdcontent">${alidebt.posCustId}</td>
							<td class="tdtitle">流水号:</td>
							<td class="tdcontent">${alidebt.orderNo}</td>
						</tr>
						<tr>
							<td class="tdtitle">性别:</td>
							<td class="tdcontent">${alidebt.sexyClean}</td>
							<td class="tdtitle">年龄:</td>
							<td class="tdcontent">${alidebt.ageClean}</td>
						</tr>
						<tr>
							<td class="tdtitle">省份:</td>
							<td class="tdcontent">${alidebt.areaNameClean}</td>
							<td class="tdtitle">省份证原始发源地:</td>
							<td class="tdcontent">${alidebt.ysFzd}</td>
						</tr>
						<tr>
							<td class="tdtitle">欠款额度:</td>
							<td class="tdcontent">${alidebt.qked}</td>
							<td class="tdtitle">违约情况:</td>
							<td class="tdcontent">${alidebt.wyqk}</td>
						</tr>
						<tr>
							<td class="tdtitle">贷款到期时间:</td>
							<td class="tdcontent">${alidebt.dkdqsj}</td>
							<td class="tdtitle">淘宝账户:</td>
							<td class="tdcontent">${alidebt.tbzh}</td>
						</tr>
						<tr>
							<td class="tdtitle">法定代表人:</td>
							<td class="tdcontent">${alidebt.legalPerson}</td>
							<td class="tdtitle">贷款期限:</td>
							<td class="tdcontent">${alidebt.dkqx}
							<td class="tdtitle">
						</tr>
					</c:forEach>
				</table>
			</fieldset>
		</c:if>
	</div>
</body>