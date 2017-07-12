package com.Smileyes.service;

import java.sql.SQLException;
import java.util.List;

import com.Smileyes.entity.FoodTable;

/*
 * 餐桌服务接口
 */
public interface TableService_IN {
	// 添加
	public void add(FoodTable ft);

	// 修改
	public void update(FoodTable ft);

	// 显示列表
	public List<FoodTable> getAll();

	// 删除
	public void delete(int id);

	// 根据名称查找
	public List<FoodTable> findByName(String name);

	// 根据id查找
	public FoodTable findById(int tableId);
}
