<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
				<div title="银行流水信息">
                	<table id="bankSerialDetailTable"
						style="height:290px;" width="100%"		
						title="银行流水信息"
						onClickRow="clickRow" rownumbers="true" pagination="true">
						<thead>
							<tr>
								<th field="custName">客户姓名</th>
								<th field="bankName">银行名称</th>
								<th field="bankAccno">银行卡号</th>
								<th field="currMonth">月份</th>
								<th field="currMonthIn">当月进项</th>
								<th field="currMonthOut">当月出项</th>
								<th field="currSeaInterestAmt">当季结息金额</th>
							</tr>
						</thead>
					</table>
                </div>