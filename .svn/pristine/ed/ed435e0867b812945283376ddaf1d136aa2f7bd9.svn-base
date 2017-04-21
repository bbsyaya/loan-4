/*jode*/
/* CreditReportManager - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package com.amarsoft.app.crq.reportnew;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amarsoft.app.crq.report.CreditReport;
import com.amarsoft.app.crq.report.ECRReportData;
import com.amarsoft.app.crq.report.ICRReportData;
import com.amarsoft.app.crq.report.ReportBasicNode;
import com.amarsoft.app.crq.report.ReportChapter;
import com.amarsoft.app.crq.report.ReportData;
import com.amarsoft.app.crq.report.ReportDescribe;
import com.amarsoft.app.crq.report.ReportPart;
import com.amarsoft.app.crq.report.ReportSection;
import com.amarsoft.app.crq.util.ObjectHelper;
import com.amarsoft.are.jbo.BizObjectManager;
import com.amarsoft.are.jbo.JBOException;
import com.amarsoft.are.jbo.JBOFactory;
import com.amarsoft.are.lang.StringX;
import com.amarsoft.are.util.json.JSONDecoder;
import com.amarsoft.are.util.json.JSONElement;
import com.amarsoft.are.util.json.JSONObject;

public class CreditReportManager {
	private static JSONObject getValue(JSONObject jsonReport, String elementName) {
		JSONElement element = (JSONElement) jsonReport.get(elementName);
		return (JSONObject) element.getValue();
	}
	
	private static Logger logger = LoggerFactory.getLogger(CreditReportManager.class);

	public static CreditReport convertJson2CreditReport(String reportJson) throws Exception {
		CreditReport report = null;
		JSONObject jsonReport = JSONDecoder.decode(reportJson);
		if (jsonReport != null) {
			JSONObject jsonReportDescribe = getValue(jsonReport,"ReportDescribe");
			ReportDescribe reportDescribe = ((ReportDescribe) ObjectHelper.fillObjectFromJSONObject(new ReportDescribe(),jsonReportDescribe));
			ReportData reportData = null;
			if ("ICR".equals(reportDescribe.getReportType()))
				reportData = new ICRReportData();
			else
				reportData = new ECRReportData();
			List reportPartList = reportData.getPartList();
			List reportChapterList = null;
			List reportSectionList = null;
			JSONObject jsonReportData = getValue(jsonReport, "ReportData");
			JSONObject jsonReportPartList = getValue(jsonReportData, "PartList");
			ReportPart part = null;
			ReportChapter chapter = null;
			ReportSection section = null;
			JSONObject jsonReportPart = null;
			JSONObject jsonReportChapterList = null;
			JSONObject jsonReportChapter = null;
			JSONObject jsonReportSectionList = null;
			JSONObject jsonReportSectionListMap = null;
			JSONObject jsonReportSection = null;
			java.util.Map sectionListMap = null;
			for (int i = 0; i < reportPartList.size(); i++) {
				part = (ReportPart) reportPartList.get(i);
				/*System.out.println("test add by cjyu1 ============="+part.getLabel());*/
				logger.debug(jsonReportPartList.toString());
				logger.debug(jsonReportPartList.get(i).toString());
				jsonReportPart = (JSONObject) jsonReportPartList.get(i).getValue();
				fillNodeContent(part, jsonReportPart);
				reportChapterList = part.getChapterList();
				jsonReportChapterList = getValue(jsonReportPart, "ChapterList");
				for (int j = 0; reportChapterList != null && j < reportChapterList.size(); j++) {
					chapter = (ReportChapter) reportChapterList.get(j);
					/*System.out.println("test add by cjyu1 ==============="+chapter.getLabel());*/
					jsonReportChapter = (JSONObject) jsonReportChapterList.get(j).getValue();
					fillNodeContent(chapter, jsonReportChapter);
					reportSectionList = chapter.getSectionList();
					if (StringX.isEmpty(chapter.getMainSection())) {
						jsonReportSectionList = getValue(jsonReportChapter, "SectionList");
						for (int k = 0; (reportSectionList != null && k < reportSectionList.size()); k++) {
							section = (ReportSection) reportSectionList.get(k);
							/*System.out.println("test add by cjyu1 ===���-�ɣģ�"+section.getId()+"===�����ƣ�"+section.getLabel());*/
							jsonReportSection = ((JSONObject) jsonReportSectionList.get(k).getValue());
							fillNodeContent(section, jsonReportSection);
						}
					} else {
						sectionListMap = new HashMap();
						chapter.setSectionListMap(sectionListMap);
						jsonReportSectionListMap = getValue(jsonReportChapter, "SectionListMap");
						JSONElement ele = null;
						for (int k = 0; (jsonReportSectionListMap != null && jsonReportSectionListMap.size() > 0 && k < jsonReportSectionListMap.size()); k++) {
							ele = ((JSONElement) jsonReportSectionListMap.get(k));
							jsonReportSectionList = (JSONObject) ele.getValue();
							if (jsonReportSectionList != null) {
								for (int m = 0; (reportSectionList != null && m < reportSectionList.size()); m++) {
									section = ((ReportSection) reportSectionList.get(m));
									/*System.out.println("test add by cjyu1 ===���-�ɣģ�"+section.getId()+"===�����ƣ�"+section.getLabel());*/
									jsonReportSection = (JSONObject) jsonReportSectionList.get(m).getValue();
									fillNodeContent(section, jsonReportSection);
								}
								sectionListMap.put(ele.getName(),
										reportSectionList);
							}
						}
					}
				}
			}
			report = new CreditReport();
			report.setReportDescribe(reportDescribe);
			report.setReportData(reportData);
		}
		return report;
	}

	private static void fillNodeContent(ReportBasicNode node,JSONObject jsonNode) throws JBOException {
		if (!StringX.isEmpty(node.getJboClass())) {
			BizObjectManager bm = JBOFactory.getFactory().getManager(node.getJboClass());
			JSONObject nodeContent = getValue(jsonNode, "Content");
			if (nodeContent != null && !(nodeContent.get(0)==null || nodeContent.get(0).isNull())){
				if(!nodeContent.get(0).isNull()){
					if (!node.isMulti())
						node.addContent(ObjectHelper.fillJBOFromJSONObject(bm.newObject(), ((JSONObject) nodeContent.get(0).getValue())));
					else {
						List listReportNodeContent = nodeContent.getElementTable();
						Iterator i$ = listReportNodeContent.iterator();
						while (i$.hasNext()) {
							JSONElement jsonElementNodeContent = (JSONElement) i$.next();
							node.addContent(ObjectHelper.fillJBOFromJSONObject(bm.newObject(),((JSONObject) jsonElementNodeContent.getValue())));
						}
					}
				}
			}
		}
	}
}

/*****
 * DECOMPILATION REPORT ***** LOCATION:
 * F:\hrbworkspace\CRQClient\lib\amarcrq-reportjson-decode-3.0-beta-b21_g
 * .jar!com.amarsoft.app.crq.report.CreditReportManager TOTAL TIME: 0 ms
 ********************************/
