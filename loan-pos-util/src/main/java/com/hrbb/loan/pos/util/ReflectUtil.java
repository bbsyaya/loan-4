package com.hrbb.loan.pos.util;

import java.lang.reflect.Field;

public class ReflectUtil {
	
	
	public Object getRelectFieldValue(Object obj, String fieldName) throws Exception{
		@SuppressWarnings("rawtypes")
		Class clazz = obj.getClass();
		Field field = clazz.getDeclaredField(fieldName);
		field.setAccessible(true);
		return field.get(obj);
	}
}
