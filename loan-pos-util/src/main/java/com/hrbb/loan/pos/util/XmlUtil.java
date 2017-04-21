package com.hrbb.loan.pos.util;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

/**
 * Dom4j 工具类.
 * 
 * @author xiongshaogang
 * @version $Id: XmlUtil.java, v 0.1 2015年4月27日 下午6:33:47 xiongshaogang Exp $
 */
public class XmlUtil {
	/**
	 * 创建有值的节点
	 * 
	 * @param name
	 * @param value
	 * @return e
	 */
	public static Element createTextElement(String name, String value) {
		Element e = DocumentHelper.createElement(name);
		if (value == null) {
			value = "";
		}
		e.setText(value);
		return e;
	}

	/**
	 * 获取元素中指定节点名的值
	 * 
	 * @param elt
	 * @param nodeName
	 * @return
	 */
	public static String getSingleNodeText(Element elt, String nodeName) {
		try {
			Node node = elt.selectSingleNode(nodeName);
			if (node == null) {
				return null;
			}
			return node.getText().trim();
		} catch (Exception e) {
			return null;
		}
	}
}
