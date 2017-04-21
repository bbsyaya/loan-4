package com.hrbb.loan.pos.util.xml;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Attr;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * <p>Title: Element.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年8月17日
 *
 * logs: 1. 
 */
public class Element {
	private org.w3c.dom.Element domElement;

	public Element(org.w3c.dom.Element domElement) {
		this.domElement = domElement;
	}

	public org.w3c.dom.Element getDomElement() {
		return domElement;
	}

	/**
	 * �õ�Ԫ�صĵ��ı�����
	 */
	public String getName() {
		return getDomElement().getTagName();
	}

	/**
	 * �õ�Ԫ�صĵ��ı�����,������ı�Ԫ�أ����Һ����еĵ�һ��
	 */
	public String getTextTrim() {
		Node textNode = getTextNode(getDomElement());
		if (textNode != null) {
			return textNode.getNodeValue().trim();
		}
		return null;
	}

	/**
	 * �õ����Ϊname�ĵ�һ�������ı�����
	 * 
	 * @param name
	 *            ���
	 */
	public String getChildTextTrim(String name) {
		Element e = getChild(name);
		if(e==null)
			return null;
		else
			return e.getTextTrim();
	}

	/**
	 * �õ�һ���ı�node
	 * @parm parentNode ���ڵ�
	 */
	private Node getTextNode(Node parentNode) {
		NodeList nodeList = parentNode.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);

			if ((node.getNodeType() == Node.TEXT_NODE)) {
				return node;
			}
		}
		return null;
	}

	/**
	 * �õ����Ϊname�ĵ�һ������
	 * 
	 * @param name
	 *            ���
	 */
	public Element getChild(String name) {
		Element child = null;
		NodeList nodeList = getDomElement().getChildNodes();
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node n = nodeList.item(i);
			if(n.getNodeType()==Node.ELEMENT_NODE && 
				n.getNodeName().equals(name)){
				child = new Element((org.w3c.dom.Element)n);
				break;
			}
		}
		return child;
	}

	/**
	 * ��ȡXMLԪ�ص��ض����ֵĺ���
	 * 
	 * @param name
	 *            ���
	 */
	public List getNodeList(String name) {
		return getChildren(name);
	}

	/**
	 * ��ȡXMLԪ�ص��ض����ֵĺ���
	 * 
	 * @param name
	 *            ���
	 */
	public List getChildren(String name) {
		ArrayList nodes = new ArrayList();
		NodeList nodeList = getDomElement().getChildNodes();

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node n = nodeList.item(i);
			if(n.getNodeType()==Node.ELEMENT_NODE && 
				n.getNodeName().equals(name))
				nodes.add(new Element((org.w3c.dom.Element)n));
		}
		return nodes;
	}

	/**
	 * ��ȡXMLԪ�ص����к���
	 */
	public List getChildren() {
		ArrayList nodes = new ArrayList();
		NodeList nodeList = getDomElement().getChildNodes();

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node n = nodeList.item(i);
			if(n.getNodeType()==Node.ELEMENT_NODE)
				nodes.add(new Element((org.w3c.dom.Element)n));
		}
		return nodes;
	}

	/**
	 * ��ȡ����ƶ�Ӧ������ֵ
	 * 
	 * @param name
	 *            �������
	 * @return ������Բ����ڣ�����null
	 */
	public String getAttributeValue(String name) {
		return getAttributeValue(name, null);
	}

	/**
	 * ��ȡ����ƶ�Ӧ������ֵ
	 * 
	 * @param name
	 *            �������
	 * @param def
	 *            ����ȱʡֵ
	 * @return ������Բ����ڣ�����ȱʡֵ
	 */
	public String getAttributeValue(String name, String def) {
		String result = getDomElement().getAttribute(name);
		return result.equals("")?def:result;
	}
	
	/**
	 * ��ȡһ�����������
	 * @param name ������
	 * @return ����
	 */
	public Attribute getAttribute(String name){
		Attr  att = getDomElement().getAttributeNode(name);
		return att==null?null:new Attribute(name,att.getValue());
	}

	/**
	 * ��ȡ�ڵ������List���ϣ����϶���Attribute * 
	 * @return Attribute ��List����
	 */
	public List getAttributeList() throws Exception {
		List attributeList = new ArrayList();
		NamedNodeMap attList = getDomElement().getAttributes();
		for (int i = 0; i < attList.getLength(); i++) {
			attributeList.add(
				new Attribute(attList.item(i).getNodeName(),attList.item(i).getNodeValue())
			);
		}
		return attributeList;
	}
}