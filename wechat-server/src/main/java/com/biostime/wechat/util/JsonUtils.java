package com.biostime.wechat.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class JsonUtils {
	private static final ObjectMapper mapper = new ObjectMapper();
	public static String toJson(Object o) {
		try {
			return mapper.writeValueAsString(o);
		} catch (Exception e) {
			throw new IllegalArgumentException("object " + o + " to json string error", e);
		}
	}
	
	public static <T> T fromJson(String json, Class<T> beanClass) {
		try {
			return mapper.readValue(json, beanClass);
		} catch (Exception e) {
			throw new IllegalArgumentException("json " + json + " to object:" + beanClass + " error", e);
		}
	}
}
