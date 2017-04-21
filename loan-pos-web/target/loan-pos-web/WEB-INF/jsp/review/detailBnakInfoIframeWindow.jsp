<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--审批详情-->
<script>

	/*调用银联智慧接口，查询银行流水并入库*/
	function searchBankCardInfo(){
		var card = $("#searchBank").val();
		var name = $("#searchName").val();
		var beginDateStr = $("#searchBeginDateStr").datebox('getValue');
		var endDateStr = $("#searchEndDateStr").datebox('getValue');
		if(typeof(card) == 'undifined' || card==''){
			alert('银行卡号不能为空');
			return;
		}
		if(typeof(name) == 'undifined' || name==''){
			alert('持卡人姓名不能为空');
			return;
		}
		if(typeof(beginDateStr) == 'undifined' || beginDateStr==''){
			alert('查询开始时间不能为空');
			return;
		}
		if(typeof(endDateStr) == 'undifined' || endDateStr==''){
			alert('查询结束时间不能为空');
			return;
		}
		//检查该卡是否已经掉用过银联智慧接口
		var checkIsQueriedReqUrl = '<%=request.getContextPath()%>/bankSerialInfo/checkIsQueried.do';
		$.post(checkIsQueriedReqUrl,{card:card},function(data){
			var flag = data.flag;
			if(flag == '1'){
				if(confirm('该卡已经查询过银联智慧接口，确定再次查询吗？')){
	    			var reqUrl='<%=request.getContextPath()%>/bankSerialInfo/summary.do';
					var bankcardSearch = $("#bankcardSearch").val();
					$.messager.progress({
			 	        text: '银行流水查询中，请等待......',
			 	    });
					$.post(reqUrl,{card:card,
								   name:name,
								   beginDateStr:beginDateStr,
								   endDateStr:endDateStr},function(data){
						if(data.respCode=='999'){
							alert(data.respMsg);
							return;
						}
						$('#searchBank').val(data.searchBank);
						$('#searchName').val(data.searchName);
						$('#detailBankInfoIframeSummary').attr("src","<%=request.getContextPath()%>/creditApply/queryCreditApplyBankSerialDetailSummary.do?card="+card);
						$.messager.progress('close');
					},'json') 
				}
			}
		},'json')
		
	}
	
	/*银行流水明细*/
	function searchBankCardInfoDetail(){
		var card = $('#searchBank').val();
		$('#detailBankInfoIframe').attr("src","<%=request.getContextPath()%>/creditApply/queryCreditApplyBankSerialDetail.do?card="+card);
		$('#detailBankInfoIframe').window({
			 	title: '银行明细',
	            width: 1000,
	            modal: true,
	            shadow: true,
	            height: 400,
	            resizable:false
		});
	}
	
	/*银行流水汇总*/
	function searchBankCardInfoDetailSummary(){
		var card = $("#searchBankAccno").val();
	    $('#detailBankInfoIframeSummary').attr("src","<%=request.getContextPath()%>/creditApply/queryCreditApplyBankSerialDetailSummary.do?card="+card); 
	}
</script>
<div title="银行流水明细" style="padding: 0px 20px 0px;"><br/>
<div width="100%" >
		<fieldset>
			<legend class='dialog-label'>查询条件</legend>
			<div id="tb" style="padding: 3px">
				<table>
					<tr>
						<td>银行卡号:</td>
						<td><input id="searchBank" name="searchBank" disabled style="line-height: 20px; border: 1px solid #ccc" /></td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;持卡人姓名:</td>
						<td><input id="searchName" name="searchName" disabled style="line-height: 20px; border: 1px solid #ccc" /></td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;查询日期:</td>
						<td><input type="text" id="searchBeginDateStr" name="searchBeginDateStr" class="easyui-datebox" size="15"/>
					              ～
					    <input type="text" id="searchEndDateStr" name="searchEndDateStr" class="easyui-datebox" size="15"/>
					    </td>
					    <td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" onclick="searchBankCardInfo()" iconCls="icon-search">查询银联智慧</a></td>
					    <td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="searchBankCardInfoDetail()" class="easyui-linkbutton" iconCls="icon-filter" >查看明细</a></td>
					</tr>
				</table>
			
			
			</div>
		</fieldset>
	</div>
	<iframe id="detailBankInfoIframeSummary" name="detailBankInfoIframeSummary" height="500px" frameborder="0" width="100%" scrolling="auto" class="detailBankInfoIframeSummary"></iframe>
	<iframe id="detailBankInfoIframe" name="detailBankInfoIframe" frameborder="0" height="500px" width="100%" scrolling="auto" class="detailBankInfoIframe"></iframe>
</div>