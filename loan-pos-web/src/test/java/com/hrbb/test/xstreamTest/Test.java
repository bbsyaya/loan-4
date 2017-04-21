package com.hrbb.test.xstreamTest;

import java.util.List;

import com.google.common.collect.Lists;
import com.thoughtworks.xstream.XStream;

public class Test {
	
	
	public static void main(String[] args) {
		
		
		
		/*Field field = new Field();
		
		field.setName("ReportType");
		field.setType("string");
		field.setValue("1");
		
		Field field1 = new Field();
		field1.setName("CustomerName");
		field1.setType("string");
		field1.setValue("张三");
		
		List<Field> list = Lists.newArrayList(field, field1);
		Row row = new Row();
		row.setNo("1");
		row.setList(list);
		
		Record record = new Record();
		record.setName("QuestInfo");
		record.setRow(row);
		Body body = new Body();
		body.setRecord(record);
		
		Header header = new Header();
		
		header.setTxClientString("CC");
		header.setTxSeq("CRQ201408251757040000000000031");
		header.setTxDate("20140825");
		header.setTxTime("175704");
		
		Transaction transaction = new Transaction();
		transaction.setHeader(header);
		transaction.setBody(body);
		XStream xStream = new XStream();
		xStream.autodetectAnnotations(true);
		xStream.alias("transaction", Transaction.class);
		xStream.addImplicitCollection(Row.class, "list");
		String reqXml = "<transaction><header><tx__client>CC</tx__client><tx__seq>CRQ201408251757040000000000031</tx__seq><tx__date>20140825</tx__date><tx__time>175704</tx__time></header><body>"+
			    "<record name=\"QuestInfo\">"+
			      "<row no=\"1\">"+
			        "<field name=\"ReportType\" type=\"string\" value=\"1\"/>"+
			        "<field name=\"CustomerName\" type=\"string\" value=\"张三\"/>"+
			      "</row>"+
			    "</record>"+
			  "</body>"+
			"</transaction>";
		//reqXml = xStream.toXML(transaction);
		System.out.println(reqXml);
		Transaction transaction2 = (Transaction) xStream.fromXML(reqXml);
		System.out.println(transaction2);*/
		
		/*String reqXml = "<transaction><header><tx_client>PreApprove</tx_client><tx_seq>STAR201408251757040000000000031</tx_seq>" +
				"<tx_date>20140825</tx_date><tx_time>175704</tx_time></header>"+
	"<body>"+
		"<record name=\"QuestInfo\">"+
			"<row no=\"1\">"+
				"<field name=\"QueryResult\" type=\"string\" value=\"002001010180022\"/>"+
				"<field name=\"QueryResultMsg\" type=\"string\" value=\"交易成功\"/>"+
				"<field name=\"ReportSource\" type=\"string\" value=\"2\"/>"+
				"<field name=\"ReportNo\" type=\"string\" value=\"201408080090001\"/>"+
				"<field name=\"ReportTime\" type=\"string\" value=\"20140808101003\"/>"+
				"<field name=\"CustomerName\" type=\"string\" value=\"金苗\"/>"+
				"<field name=\"CertType\" type=\"string\" value=\"1\"/>"+
				"<field name=\"CertTD\" type=\"string\" value=\"220322198708062256\"/>"+
				"<field name=\"HtmlReport\" type=\"string\" value=\"1408692204751.html\"/>"+
				"<field name=\"JsonReport\" type=\"string\" value=\"1408692204751.txt\"/>"+
			"</row>"+
		"</record>"+
	"</body>"+
"</transaction>";*/
		/*String reqXml = "<transaction><header><tx__client>CC</tx__client><tx__seq>CRQ201408251757040000000000031</tx__seq><tx__date>20140825</tx__date><tx__time>175704</tx__time></header><body>"+
    "<record name=\"QuestInfo\">"+
      "<row no=\"1\">"+
        "<field name=\"ReportType\" type=\"string\" value=\"1\"/>"+
        "<field name=\"CustomerName\" type=\"string\" value=\"张三\"/>"+
      "</row>"+
    "</record>"+
  "</body>"+
"</transaction>";
		XStream xStream = new XStream();
		xStream.autodetectAnnotations(true);
		xStream.addImplicitCollection(Row.class, "list");
		System.out.println(reqXml);
		Transaction transaction = (Transaction)xStream.fromXML(reqXml);
		System.out.println(transaction);*/
		
		
		
	}
}
