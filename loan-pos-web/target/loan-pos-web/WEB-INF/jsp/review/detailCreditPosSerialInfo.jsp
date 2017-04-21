<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
				<div title="pos流水信息"  width="100%">
				<c:if test="${applyDetail[0].applyStatus == '10'||applyDetail[0].applyStatus == '20'||applyDetail[0].applyStatus == '21'}">
				    <div id="divPosInsert"><iframe id="insertIframe" name="insertIframe" frameborder="0" 
					height="50px" width="1000px" scrolling="no"></iframe></div>
					
				<script type="text/javascript">
					$('#insertIframe').attr("src", "<%=request.getContextPath()%>/navigation/posSerialNav.do?loanId=${applyDetail[0].loanId}&&container=posSerialDetailTable");
				</script>
				
				</c:if>
				<c:if test="${applyDetail[0].applyStatus != '10'}">
					<div id="divPosDetail">
					<table id="posSerialDetailTable" width="100%" height="400px"
						title="pos流水信息"
						onClickRow="clickRow" rownumbers="true" pagination="true">
						<thead>
							<tr>
								<th field="posChannel">渠道</th>
								<th field="posKind">类型</th>
								<th field="merchantId">商户编号</th>
								<th field="merchantName">商户名</th>
								<th field="merchantTypeCode">商户类别码</th>
								<th field="tradeDate">交易日期</th>
								<th field="tradeTime">交易时间</th>
								<th field="tradeType">商户名称</th>
								<th field="tradeAmt">交易金额</th>
								<th field="tradeNum">交易比数</th>
								<th field="cardLastFourState">卡号后四位</th>
								<th field="tradeCardKind">交易卡种</th>
								<th field="tradeCardNo">交易卡号</th>
								<th field="regTimeTradeAmt">正常时间交易金额</th>
								<th field="regTimeTradeNum">当前状态</th>
								<th field="maxTradeAmtPerMonth">每月最大交易金额</th>
								<th field="creditCardTradeAmtRate">每月信用卡交易金额占比</th>
								<th field="creditCardTradeNumRate">每月信用卡交易笔数占比</th>
								<th field="differentCardNoNum">每月不重复卡号数</th>
							</tr>
						</thead>
					</table>
					</div>
				</c:if>
				</div>