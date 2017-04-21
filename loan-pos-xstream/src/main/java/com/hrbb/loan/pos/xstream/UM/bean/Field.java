package com.hrbb.loan.pos.xstream.UM.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("field")
public class Field {
	
	@XStreamAsAttribute
	private String name;
	
	@XStreamAsAttribute
	private String type;
	
	@XStreamAsAttribute
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
