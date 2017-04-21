package com.hrbb.loan.pos.util;



import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class Dom4jUtil {
	
	//根据text获取document
	public static Document getDocumentFromText(String text) throws Exception{
		
		return DocumentHelper.parseText(text);
	}
	
	//获取根节点
	public static Element getRootElement(Document document){
		return document.getRootElement();
	}
	
	public static Element getElement(Element element, String nodeName){
		return element.element(nodeName);
	}
	
	public static List<Element> getElementList(Element element, String nodesName){
		return element.elements(nodesName);
	}
	
	public static String getNodeText(Element element){
		return element.getText();
	}
}
