package com.hrbb.loan.pos.integration.common.creditInvestigate;
import javax.xml.rpc.Stub;
public class DemoClient {
	public static void main(String[] args) throws Exception
	{
		String locatorUrl = "";
//		locatorUrl = "http://130.1.9.94:9080/AmarCRQ/services/ASWebService?wsdl";
//		locatorUrl = "http://130.1.9.57:9080/AmarCRQ/services/ASWebService?wsdl";
//		locatorUrl = "http://200.198.3.236:8080/AmarCRQ/services/ASWebService?wsdl";
//		locatorUrl = "http://197.17.66.179:8080/AmarCRQ/services/ASWebService?wsdl";
		locatorUrl = "http://197.17.66.178:8080/AmarCRQ/services/ASWebService?wsdl";
		
		String tradeCode = "";
		String rqtXml = "";
		ASWebService_ServiceLocator locator = new ASWebService_ServiceLocator();
		ASWebServicePortBindingStub service = new ASWebServicePortBindingStub();
		if(locatorUrl!=null && locatorUrl.trim().length()>0){
			((Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address",locatorUrl);
		}
		
		tradeCode = "CRQ2014080100001";
//		tradeCode = "CRQ2014091610101";
//		for(int i = 10000;i<11000;i++){
			rqtXml = "<transaction><header><tx_client>ALS</tx_client><tx_seq>CRQ2014121110001100000000003</tx_seq><tx_date>20140826</tx_date><tx_time>175704</tx_time></header><body><record name=\"QuestInfo\">" +
			"<row no=\"0\">" +
				"<field name=\"ReportType\" type=\"string\" value=\"ECR\" />" +
				"<field name=\"CustomerName\" type=\"string\" value=\"宋依麟\" />" +
				"<field name=\"CertType\" type=\"string\" value=\"K\" />" +
				"<field name=\"CertID\" type=\"string\" value=\"5105240000045414\" />" +
				"<field name=\"LoancardPwd\" type=\"string\" value=\"8888888888888\" />" +
				"<field name=\"QueryReason\" type=\"string\" value=\"03E\" />" +
				"<field name=\"AccessStrategy\" type=\"string\" value=\"1\" />" +
				"<field name=\"ReportValid\" type=\"string\" value=\"8\" />" +
				"<field name=\"QueryDemand\" type=\"string\" value=\"3\" />" +
				"<field name=\"QuerySource\" type=\"string\" value=\"ALS\" />" +
				"<field name=\"OperateOrgID\" type=\"string\" value=\"111314\" />" +
				"<field name=\"OperateUserID\" type=\"string\" value=\"tj-lxx\" />" +
				/*"<field name=\"ApproveUserID\" type=\"string\" value=\"003319\" />" +*/
				"<field name=\"QueryAccount\" type=\"string\" value=\"\" />" +
				"<field name=\"QueryAccountPwd\" type=\"string\" value=\"\" />" +
				"<field name=\"ReportNo\" type=\"string\" value=\"\" />" +
				"<field name=\"ReportVersion\" type=\"string\" value=\"\" />" +
				"<field name=\"CustomerAuthorize\" type=\"string\" value=\"Y\" />" +
				"<field name=\"QueryTime\" type=\"string\" value=\"2014/12/25 17:57:04\" />" +
				"<field name=\"RequestAddr\" type=\"string\" value=\"123.123.123.123\" />" +
			"</row></record></body></transaction>";
			String repXml = service.execute(tradeCode, rqtXml);
			System.out.println("请求报文~~~~~~~~~~~~~"+rqtXml);
			System.out.println("返回报文~~~~~~~~~~~~~"+repXml);
//		}
		
		
		
	}
}
