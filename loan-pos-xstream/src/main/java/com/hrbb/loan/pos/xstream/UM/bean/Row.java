package com.hrbb.loan.pos.xstream.UM.bean;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("row")
public class Row {
	
	@XStreamAsAttribute
	private String no;

	private List<Field> list;
	
	
	
	public List<Field> getList() {
		return list;
	}

	public void setList(List<Field> list) {
		this.list = list;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
	
	
}
