/**
 * 
 */
package com.hrbb.loan.pos.util.xml;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hrbb.loan.pos.util.DateUtil;

/**
 * <p>Title: Attribute.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年8月17日
 *
 * logs: 1. 
 */
public class Attribute {
	private String name = null;
	private String value = null;
	
	/**
	 * @param name �������
	 */
	public Attribute(String name) {
		super();
		this.name = name;
	}
	/**
	 * @param name �������
	 * @param value ����ֵ
	 */
	public Attribute(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	/**
	 * @return  get�������
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return get����ֵ
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value ��������ֵ
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * ����һ���������͵�����ֵ�����Ϊnull������defaultֵ��
	 * @param defaultValue ȱʡֵ
	 * @return ���Ե�����ֵ
	 */
	public final int getValue(int defaultValue){
		int value = defaultValue;
		if(this.value!=null){
			try{
				value = Integer.parseInt(this.value);
			}catch(Exception ex){
				value = defaultValue;
			}
		}
		return value;
	}
	
	/**
	 * ����һ���������͵�����ֵ�����Ϊnull������defaultֵ��
	 * @param defaultValue ȱʡֵ
	 * @return ���Ե�����ֵ
	 */
	public final double getValue(double defaultValue){
		double value = defaultValue;
		if(this.value!=null){
			try{
				value = Double.parseDouble(this.value);
			}catch(Exception ex){
				value = defaultValue;
			}
		}
		return value;
	}
	
	/**
	 * ����һ��boolean���͵�����ֵ�������ڣ�����defaultֵ���ַ����ͣ����ִ�Сд���ģ�
	 * "true"��"t"��"yes"��"y"�����ַ�"0"����Ϊ��true������ı���Ϊ��false
	 * @param defaultValue ȱʡֵ
	 * @return ���ԵĲ���ֵ
	 */
	public final boolean getValue(boolean defaultValue){
		boolean value = defaultValue;
		if(this.value!=null) value = this.value.toLowerCase().matches("(true|t|yes|y|1)");
		return value;
	}
	
	/**
	 * ����һ���������͵�����ֵ�����Ϊnull������defaultֵ��
	 * �������Զ�ʶ��yyyy/MM/dd��yyyy-MM-dd��yyyyMMdd���ָ�ʽ�����ҿ���ʶ�����ǵ���λ��Ķ̸�ʽ��
	 * �����ʽ����Ҫ��getDateProperty(Date defaultValue��String format)
	 * ����ʽ��ʽת��
	 * @param defaultValue ȱʡֵ
	 * @return ���Ե�����ֵ
	 */
	public final Date getValue(Date defaultValue){
		Date value = defaultValue;
		if(this.value!=null) value = DateUtil.parse2Date(this.value);
		return value;
	}
	
	/**
	 * ����һ���������͵�����ֵ�����Ϊnull������defaultֵ��
	 * @param defaultValue ȱʡֵ
	 * @param format ���ڸ�ʽ
	 * @return ���Ե�����ֵ
	 */
	public final Date getValue(Date defaultValue,String format){
		Date value = defaultValue;
		if(this.value!=null){
			SimpleDateFormat df = new SimpleDateFormat(format);
			try{
				value = df.parse(this.value);
			}catch(Exception ex){
				value = defaultValue;
			}
		}
		return value;
	}
	
	/**
	 * ����һ���ַ����͵�����ֵ�������ڣ�����defaultֵ��
	 * @param defaultValue ȱʡֵ
	 * @return ���Ե��ַ�ֵ
	 */
	public final String getValue(String defaultValue){
		return value==null?defaultValue:value;
	}

	
}
