package com.Smileyes.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
	// 把表单的信息封装到对象
	public static <T> T copyToBean(HttpServletRequest request, Class<T> clazz)
			throws InvocationTargetException {
		T t = null;
		try {
			t = clazz.newInstance();
			BeanUtils.populate(t, request.getParameterMap());
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		return t;

	}

	// 封装相关信息到某个对象
	public static void copyToBean(String key, String value, Object obj) {
		try {
			BeanUtils.setProperty(obj, key, value);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
}
