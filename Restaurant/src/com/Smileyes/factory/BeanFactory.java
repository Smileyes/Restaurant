/*
 * 用于新建对象的工厂类
 * @author Smileyes
 * */
package com.Smileyes.factory;

import java.util.ResourceBundle;

public class BeanFactory {
	public static ResourceBundle bundle;
	static {
		bundle = ResourceBundle.getBundle("instance");
	}

	public static <T> T getBean(String className, Class<T> clazz) {
		String path = bundle.getString(className);
		try {
			return (T) Class.forName(path).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
