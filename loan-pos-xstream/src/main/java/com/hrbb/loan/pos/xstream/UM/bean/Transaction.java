package com.hrbb.loan.pos.xstream.UM.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("transaction")
public class Transaction {
	
	private Header header;
	
	private Body body;

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}
	
	
}
