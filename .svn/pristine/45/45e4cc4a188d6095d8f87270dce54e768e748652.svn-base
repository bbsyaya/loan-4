package com.hrbb.loan.pos.util.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * <p>Title: Document.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年8月17日
 *
 * logs: 1. 
 */
public class Document {
	private org.w3c.dom.Document xmlDoc;
	private File xmlFile;
	private org.w3c.dom.Element domRootNode;
	private Element rootElement;
	private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	final private int MaxBackupFileCount = 5;

	/**
	 * ��ʼ��XmlDocument����
	 * @param fileName �ַ��ļ���
	 */
	public Document(String fileName) throws Exception{
		this(new File(fileName));
	}

	/**
	 * ͨ��File�����ʼ��XmlDocument����
	 * @param file File����
	 */
	public Document(File file) throws Exception{
		this(new FileInputStream(file));
	}

	/**
	 * ͨ��InputStream�����ʼ��XmlDocument����
	 * @param is InputStream����
	 */
	public Document(InputStream is) throws Exception {
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			xmlDoc = builder.parse(is);
			domRootNode = xmlDoc.getDocumentElement();
			rootElement = new Element(domRootNode);
		} catch (SAXParseException spe) {
       		throw spe;
		} catch (SAXException sxe) {
       		throw sxe;
		} catch (ParserConfigurationException pce) {
       		throw pce;
		} catch (IOException ioe) {
       		throw ioe;
		}
	}

	/**
	 * ������ȫ��w3c��Document,����ʹ������w3c Document�Ĵ��?��
	 * @return w3c��Document
	 */
	public org.w3c.dom.Document getDomDocument(){
		return xmlDoc;
	}
	
	/**
	 * ����xml�ĵ�������
	 * @return �ļ���
	 */
	public String getXmlDocName() {
		return xmlFile.getPath();
	}

	/**
	 * ȡ�����ĸ�ڵ㣬��w3c��node
	 */
	public Node getRootNode() {
		return domRootNode;
	}

	/**
	 * ȡ�����ĸ�Ԫ�أ���are��element
	 */
	public Element getRootElement() {
		return rootElement;
	}

	/** ������֡����ԡ�����ֵѰ�ҽڵ� */
	public Node getNode(String NodeName, String AttributeName, String AttributeValue, Node parentNode) throws Exception {

		NodeList nodeList = parentNode.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeName().trim().equalsIgnoreCase(NodeName) && (node.getNodeType() == 1) && (node.getAttributes().getLength() > 0)) {

				if (node.getAttributes().getNamedItem(AttributeName).getNodeValue().trim().equalsIgnoreCase(AttributeValue)) {

					return node;
				}
			}

			if (node.getChildNodes().getLength() > 0) {
				Node result = this.getNode(NodeName, AttributeName, AttributeValue, node);
				if (result != null) {
					return result;
				}

			}
		}
		return null;
	}

	/**
	 * ȡ�ýڵ��ֵ
	 */
	public String getNodeValue(Node currentNode) throws Exception {
		String result = "";
		NodeList nodeList = currentNode.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if ((node.getNodeType() == Node.TEXT_NODE) && (node.getNodeValue().trim().length() > 0)) {
				return node.getNodeValue();
			}
		}
		return result;
	}

	/**
	 * ���ýڵ��ֵ
	 */
	public void setNodeValue(Node currentNode, String newValue) throws Exception {
		NodeList nodeList = currentNode.getChildNodes();

		if (nodeList.getLength() == 0) {
			Node temp = getTextNode(getRootNode()).cloneNode(false);
			temp.setNodeValue(newValue);
			currentNode.appendChild(temp);
		}
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if ((node.getNodeType() == Node.TEXT_NODE)) {
				node.setNodeValue(newValue);
				return;
			}

		}

		return;
	}

	/**
	 * �õ�һ���ı�node
	 */
	public Node getTextNode(Node parentNode) throws Exception {
		NodeList nodeList = parentNode.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);

			if ((node.getNodeType() == Node.TEXT_NODE)) {
				return node;
			}

			if (node.getChildNodes().getLength() > 0) {
				Node result = this.getTextNode(node);
				if (result != null) {
					return result;
				}
			}
		}

		return null;
	}	

	public String printDOMTree(Node node) {
		String result = "";

		int type = node.getNodeType();
		switch (type) {
		// print the document element
		case Node.DOCUMENT_NODE: {
			result = result + "<?xml version='1.0' encoding='ISO8859-1'?>";
			result = result + printDOMTree(((org.w3c.dom.Document)node).getDocumentElement());
			break;
		}

		// print element with attributes
		case Node.ELEMENT_NODE: {
			result = result + ("<");
			result = result + (node.getNodeName());
			NamedNodeMap attrs = node.getAttributes();

			for (int i = 0; i < attrs.getLength(); i++) {
				Node attr = attrs.item(i);
				result = result + " " + attr.getNodeName() + "=\"" + attr.getNodeValue() + "\"";
			}
			result = result + ">";

			NodeList children = node.getChildNodes();
			if (children != null) {
				int len = children.getLength();
				for (int i = 0; i < len; i++)
					result = result + printDOMTree(children.item(i));
			}

			break;
		}

		// handle entity reference nodes
		case Node.ENTITY_REFERENCE_NODE: {
			result = result + "&";
			result = result + node.getNodeName();
			result = result + ";";
			break;
		}

			// print cdata sections
		case Node.CDATA_SECTION_NODE: {
			result = result + "<![CDATA[";
			result = result + node.getNodeValue();
			result = result + "]]>";
			break;
		}

			// print text
		case Node.TEXT_NODE: {
			result = result + (node.getNodeValue());
			break;
		}

			// print processing instruction
		case Node.PROCESSING_INSTRUCTION_NODE: {
			result = result + "<?";
			result = result + node.getNodeName();
			String data = node.getNodeValue();
			{
				result = result + " ";
				result = result + data;
			}
			result = result + "?>";
			break;
		}
		}

		if (type == Node.ELEMENT_NODE) {
			result = result + "";
			result = result + "</";
			result = result + node.getNodeName();
			result = result + '>';
		}
		return result;
	}

	/** ����XML */
	public void backup() throws Exception {
		int res = -1;
		long temp = 0L;
		for (int i = 0; i < MaxBackupFileCount; i++) {
			File f = new File(getXmlDocName() + ".00" + i);
			f.lastModified();
			if (f.lastModified() > temp) {
				temp = f.lastModified();
				res = i;
			}
		}

		res = res + 1;
		if (res > 4) {
			res = 0;
		}
		this.writeToFile(getXmlDocName() + ".00" + res, this.getXmlFileToString().trim());
		return;
	}

	/** ��ȡXML */
	public String getXmlFileToString() throws Exception {

		InputStream temp = new FileInputStream(getXmlDocName());
		InputStreamReader is = new InputStreamReader(temp);
		char data[] = new char[temp.available()];
		is.read(data);
		is.close();
		temp.close();
		return new String(data);
	}

	/** д�ļ� */
	public void writeToFile(String fileName, String source) throws Exception {

		FileWriter fos = new FileWriter(fileName);
		for (int i = 0; i < source.length(); i++) {
			fos.write(source.charAt(i));
		}
		fos.close();
		return;
	}
}