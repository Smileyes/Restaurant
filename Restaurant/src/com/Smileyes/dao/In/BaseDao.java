package com.Smileyes.dao.In;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Smileyes.annotation.TypeName;
import com.Smileyes.utils.JdbcUtils;

/*
 * @author Smileyes
 * 基本Dao工具
 * 抽象类
 * */
public abstract class BaseDao<T> implements BaseDao_IN<T> {
	public Class clazz;
	public String tableName;
	public QueryRunner qr;

	public BaseDao() {
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) type;
		Type[] types = pt.getActualTypeArguments();
		clazz = (Class) types[0];
		tableName = clazz.getSimpleName();
		qr = JdbcUtils.getQr();
	}

	// 根据id查找
	public T findById(int id) {
		String sql = "select * from " + tableName + " where id = ?";
		try {
			return qr.query(sql, new BeanHandler<T>(clazz), id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 根据名称近似查找
	public List<T> findByName(String name) {
		String typeName = null;
		TypeName type = (TypeName) clazz.getAnnotation(TypeName.class);
		typeName = type.typeName();
		String sql = "select * from  " + tableName + "  where " + typeName + " like ? ";
		try {
			return qr.query(sql, new BeanListHandler<T>(clazz), "%" + name + "%");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 获取表中所有对象
	public List<T> getAll() {
		String sql = "select * from " + tableName;
		try {
			return qr.query(sql, new BeanListHandler<T>(clazz));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 删除
	public void delete(int id) {
		String sql = "delete from " + tableName + " where id = ?";
		try {
			qr.update(sql, id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 增加
	public abstract void add(T t);

	// 修改
	public abstract void update(T t);
}
