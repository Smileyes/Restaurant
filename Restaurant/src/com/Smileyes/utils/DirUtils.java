package com.Smileyes.utils;
/*
 * 用于获取存储文件的绝对路径
 * @author Smileyes
 * */

import java.util.ResourceBundle;

public class DirUtils {
	public static ResourceBundle bundle;
	static {
		bundle = ResourceBundle.getBundle("dir");
	}

	// 获得路径名对应的绝对路径
	public static String getBean(String dirName) {
		return bundle.getString(dirName);
	}
}
