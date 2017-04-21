package com.hrbb.loan.pos.util;

import com.thoughtworks.xstream.XStream;

public class XStreamUtil {
	
	
	public static XStream getXStream(){
		
		XStream xStream = new XStream();
		xStream.autodetectAnnotations(true);
		return xStream;
	}
	
	public static XStream addImplicitCollection(XStream xStream, Class clazz, String str){
		xStream.addImplicitCollection(clazz, str);
		return xStream;
	}
}
