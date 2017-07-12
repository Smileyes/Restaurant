package com.Smileyes.dao.In;

import java.util.List;

/*
 * 基本Dao接口
 * 规定了Dao需要有的方法 
 */
public interface BaseDao_IN<T> {

	// 根据id查找
	public T findById(int id);

	// 根据名称近似查找
	public List<T> findByName(String name);

	// 获取表中所有对象
	public List<T> getAll();

	// 增加
	public void add(T t);

	// 删除
	public void delete(int id);

	// 修改
	public void update(T t);
}
