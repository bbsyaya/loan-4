package com.hrbb.loan.spiconstants;

public enum SaleLoanReturnCode {

	SUCCESS("SL0000", "操作成功"),

	POS_ORG_ERROR("SL0001", "收单机构为空或有误"),

	POSCUSTNAME_ERROR("SL0053", "商户名称为空或有误"),

	REGICODE_ERROR("SL0002", "营业执照为空或有误"),

	DEALSCOPE_ERROR("SL0003", "主营业务为空或有误"),

	OPERADDRREGION_ERROR("SL0004", "行政区划为空或有误"),

	OPERADDRDETAIL_ERROR("SL0005", "实际经营地址为空或有误"),

	INDUSTRYTYPEID_ERROR("SL0006", "所属行业为空或有误"),

	CUSTNAME_ERROR("SL0007", "客户姓名为空或有误"),

	PAPERKIND_ERROR("SL0008", "证件类型为空或有误"),

	PAPERID_ERROR("SL0009", "证件号码为空或有误"),

	SEXSIGN_ERROR("SL0010", "性别为空或有误"),

	BUSIYEAR_ERROR("SL0011", "从业年限为空或有误"),

	MARRSIGN_ERROR("SL0012", "婚姻状况为空或有误"),

	EDUSIGN_ERROR("SL0013", "受教育程度为空或有误"),

	CHILDNUM_ERROR("SL0014", "子女人数为空或有误"),

	LOCALHOUSENUM_ERROR("SL0015", "拥有经营性房产数量为空或有误"),

	OTHERHOUSENUM_ERROR("SL0016", "拥有非经营地房产数量为空或有误"),

	MOBILEPHONE_ERROR("SL0017", "手机号码为空或有误"),

	TEL_ERROR("SL0018", "办公电话为空或有误"),

	RESIDENTREGION_ERROR("SL0019", "居住地行政区划为空或有误"),

	RESIDENTDETAIL_ERROR("SL0020", "具体居住地址为空或有误"),

	CONTACTADDRFALG_ERROR("SL0021", "联系地址为空或有误"),

	FAMILYCUSTNAME_ERROR("SL0022", "配偶姓名为空或有误"),

	MATEPAPERKIND_ERROR("SL0023", "配偶证件类型为空或有误"),

	MATEPAPERID_ERROR("SL0024", "配偶证件号码为空或有误"),

	MATEMOBILEPHONE_ERROR("SL0025", "配偶手机号码为空或有误"),

	RELACUSTNAME_ERROR("SL0026", "亲属姓名为空或有误"),

	RELAKIND_ERROR("SL0027", "亲属类型为空或有误"),

	RELAMOBILEPHONE_ERROR("SL0028", "亲属手机为空或有误"),

	IMAGEFILEPACKAGENAME_ERROR("SL0029", "影像资料文件包名为空或有误"),

	APPTCAPI_ERROR("SL0030", "申请额度为空或有误"),

	APPTERM_ERROR("SL0031", "申请期限为空或有误"),

	RETURNKIND_ERROR("SL0032", "还款方式为空或有误"),

	BANKACCNO_ERROR("SL0033", "卡号为空或有误"),

	BANKNAME_ERROR("SL0034", "账户开户行为空或有误"),

	BANKBRANNAME_ERROR("SL0035", "账户分行为空或有误"),

	BANKSUBNAME_ERROR("SL0036", "账户支行为空或有误"),

	BANKID_ERROR("SL0037", "推荐机构为空或有误"),

	OPERID_ERROR("SL0038", "推荐人为空或有误"),

	STDSHNO_ERROR("SL0039", "商户流水号为空或有误"),

	STDMERNO_ERROR("SL0040", "商户ID为空或有误"),

	CUSTID_ERROR("SL0041", "商户编号为空或有误"),

	LOANID_ERROR("SL0042", "申请流水号为空或有误"),

	POSFLOAWID_ERROR("SL0043", "POS交易流水号为空或有误"),

	POSAMT_ERROR("SL0044", "每月pos交易金额为空或有误"),

	POSSUM_ERROR("SL0045", "每月pos交易笔数为空或有误"),

	POSAMTNOR_ERROR("SL0046", "每月正常时间交易金额为空或有误"),

	POSSUMNOR_ERROR("SL0047", "每月正常时间交易笔数为空或有误"),

	POSAMTMAX_ERROR("SL0048", "每月最大单笔交易金额为空或有误"),

	POSAMTCREPER_ERROR("SL0049", "每月信用卡交易金额占比为空或有误"),

	POSSUMCREPER_ERROR("SL0050", "每月信用卡交易笔数占比为空或有误"),

	POSCARDSUM_ERROR("SL0051", "每月不重复卡好书为空或有误"),

	POSFLAG_ERROR("SL0052", "POS明细汇总标示位为空或有误"),

	STARTNUM_ERROR("SL0053", "起始记录号为空或有误"),

	RECNUM_ERROR("SL0054", "返回记录数为空或有误"),
	
    UESRID_ERROR("SL0055","用户编号错误"),
    
    SESSIONID_ERROR("SL0056","会话编号错误"),

	LOANID_EXIST_ERROR("SL9001", "申请流水号不存在"),

	FTP_ERROR("SL9901", "ftp连接失败"),

	RETURN_FAIL("SL9998", "失败"),

	CONTNO_ERROR("PY0001", "合同编号为空或有误"),

	TCAPI_ERROR("PY0002", "用款额度为空或有误"),

	TTERM_ERROR("PY0003", "用款期限为空或有误"),

	TERMUNIT_ERROR("PY0004", "期限单位为空或有误"),

	RETUKIND_ERROR("PY0005", "还款方式为空或有误"),

	INDESUBSACNO_ERROR("PY0006", "放款账号为空或有误"),

	DESIREDDATE_ERROR("PY0007", "期望用款日期为空或有误"),

	LOANUSE_ERROR("PY0008", "资金用途为空或有误"),

	BEGINDATE_ERROR("PY0009", "申请日期为空或有误"),

	STDMERNO_PAY_ERROR("PY0010", "商户ID为空或有误"),

	STARTNUM_PAY_ERROR("PY0011", "起始记录号为空"),

	RECNUM_PAY_ERROR("PY0012", "查询记录数为空"),

	LISTID_REPAY_ERROR("RP0001", "用款借据为空"),

	AMT_REPAY_ERROR("RP0002", "还款金额非法"),
	
	FAILURE_REPAY_ERROR("RP0003", "还款申请失败"),
	
	POS_CONTRACT_ERROR("SL00012", "电子协议生成失败"),
	
	POS_CONTRACT_QUERY_ERROR("SL00013", "电子协议查询失败"),
	
	POS_CONTRACT_BACK_ERROR("SL00116", "电子协议回传失败"),
	
	PAYSLYID_ERROR("SL00014", "用款申请编号错"),
	
	RETUTYPE_ERROR("SL00015", "还款类型错"),
	
	SUMAMT_ERROR("SL00016", "还款金额错"),
	
	QUERY_KEY_ERROR("SL00017", "检索条件错"),
	
	POS_PAYBACK_RUNNING_QUERY_ERROR("SL00014", "还款流水查询失败"),
	
	POS_PAYBACK_TRY_CALCULATE_ERROR("SL00015", "还款试算查询失败"),
	
	VERSION_ERRO_ERROR("SL00018", "版本号错"),
	
	AHEAKIND_ERRO_ERROR("SL00019", "提前还款类型错"),
	
	RCAPI_ERRO_ERROR("SL00020", "归还本金错"),
	
	CALCULATE_ERRO_ERROR("SL00021", "试算错"),
	
	PAYSLYID_ERROR_ERROR("SL00022", "用款申请编号错"),
	
	SMSTYPE_ERROR("SL00023", "短信模板编号错"),
	
	SMSSENDFAIL_ERROR("SL00025", "短信发送失败"),
	
	DUE_ERROR("SL00026", "尽调任务参数错"),
	
	NO_SUPPORT_ERROR("SL00027", "暂不支持该功能"),
	
	NO_LOGIN_ERROR("SL00028", "未登陆"),
	
	OTHER_ERROR("SL9999", "系统异常");

	private String returnCode;
	private String returnMessage;

	private SaleLoanReturnCode(String returnCode, String returnMessage) {
		this.returnCode = returnCode;
		this.returnMessage = returnMessage;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String errorCode) {
		this.returnCode = errorCode;
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String errorMessage) {
		this.returnMessage = errorMessage;
	}

}
