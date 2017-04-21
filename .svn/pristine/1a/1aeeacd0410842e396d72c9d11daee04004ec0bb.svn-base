package com.hrbb.test;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.util.List;

import com.amarsoft.app.crq.report.CreditReport;
import com.amarsoft.app.crq.report.ReportChapter;
import com.amarsoft.app.crq.report.ReportPart;
import com.amarsoft.app.crq.report.ReportSection;
import com.amarsoft.app.crq.reportnew.CreditReportManager;
import com.amarsoft.are.jbo.BizObject;
import com.hrbb.loan.pos.util.IOCVUtil;

public class Test {
	/*public static void main(String[] args) {
		int a = 2;
		
		a |= 2;
		System.out.println(String.valueOf(a));
		
		
	}*/
	
	public static void main(String[] args) throws Exception {
		
		/*List<String> list = Files.readLines(new File("D:\\test.txt"), Charsets.UTF_8);
		StringBuffer sb = new StringBuffer();
		for(String str : list){
			sb.append(str);
		}
		System.out.println(sb.toString());*/
		/*String jsonStr="";
		//暂时
		File file=new File("E:/EMAIL/CRQClient/CRQClient/CRQClient/src/demo/testICR.txt");
		
		InputStreamReader reader= new FileReader(file);
		int line=0;
		 StringBuffer sb = new StringBuffer();
		while(( line=reader.read())!=-1){
			sb.append((char) line);
		}
		jsonStr=sb.toString();
		System.out.println(jsonStr);
		CreditReport creditReport=CreditReportManager.convertJson2CreditReport(jsonStr);
		//System.out.println("creditReport"+creditReport.getReportData().getPartByName("Header").getLabel());
		
		
		 *//******************职业信息begin*****************//*
		//id="3" AnnounceInfo
		 ReportPart CreditDetailInfo =creditReport.getReportData().getPartByName("CreditDetail");
		// System.out.println(PersonalInfo);
		 ReportChapter Account = CreditDetailInfo.getChapterByName("Account");
		 if(Account!=null ){
			 List<BizObject> AnnounceInfoList = Account.getContent();
			 if(AnnounceInfoList !=null){

				 for(int i=0;i<AnnounceInfoList.size();i++){
					 Map<String, Object> reqMap = Maps.newHashMap();
					 reqMap.put(CreditInvestigateConstants.reportNo, AnnounceInfoList.get(i).getAttribute(CreditInvestigateConstants.ReportNo));
					 reqMap.put(CreditInvestigateConstants.account, AnnounceInfoList.get(i).getAttribute(CreditInvestigateConstants.Account));
					 reqMap.put(CreditInvestigateConstants.serialNo, AnnounceInfoList.get(i).getAttribute(CreditInvestigateConstants.SerialNo));
					 reqMap.put(CreditInvestigateConstants.content, AnnounceInfoList.get(i).getAttribute(CreditInvestigateConstants.Content));
					 reqMap.put(CreditInvestigateConstants.occurDate, AnnounceInfoList.get(i).getAttribute(CreditInvestigateConstants.GetTime));
					 reqMap.put(CreditInvestigateConstants.type, AnnounceInfoList.get(i).getAttribute(CreditInvestigateConstants.Type));
					 
				 }
 
			 }
		 }*/
		
		String jsonStr="";
		//暂时
		System.out.println(System.getProperty("file.encoding"));
		IOCVUtil.convert("E:/EMAIL/CRQClient/CRQClient/CRQClient/src/demo/testICR.txt",
                "GB2312", "UTF-8", new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.endsWith("txt");
                    }
                });
		File file=new File("E:/EMAIL/CRQClient/CRQClient/CRQClient/src/demo/testICR.txt");
		
		InputStreamReader reader= new FileReader(file);
		int line=0;
		 StringBuffer sb = new StringBuffer();
		while(( line=reader.read())!=-1){
			sb.append((char) line);
		}
		jsonStr=sb.toString();
		//System.out.println(jsonStr);
		CreditReport creditReport=CreditReportManager.convertJson2CreditReport(jsonStr);
		//System.out.println("creditReport"+creditReport.getReportData().getPartByName("Header").getLabel());
		
		
		 /******************AnnounceInfo*****************/
		//id="3" AnnounceInfo
		 ReportPart CreditDetailInfo =creditReport.getReportData().getPartByName("CreditDetail");
		 ReportChapter Account = CreditDetailInfo.getChapterByName("Loan");
		 System.out.println(Account);
		 if(Account!=null){
			 System.out.println(Account);
			 ReportSection AnnounceInfoList = Account.getSectionByName("LoanInfo");
			 List<BizObject> list = AnnounceInfoList.getContent();
			 for(BizObject bizObject : list){
				 System.out.println(bizObject.getAttribute("Class5State"));
			 }
		 }
	}
}
