package com.Smileyes.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/*
 *表单名称注解
 *便于定义BaseDao中的通用名称查询方法
 *仅用于Type中，生命周期为运行时期
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface TypeName {
	// 表单名称
	String typeName();
}
