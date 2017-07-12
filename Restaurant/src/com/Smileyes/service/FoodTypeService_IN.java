package com.Smileyes.service;

import java.util.List;

import com.Smileyes.entity.FoodType;

/*
 * 菜品服务接口
 * */
public interface FoodTypeService_IN {
	// 根据id查找
	public FoodType findById(int id);

	// 根据名称近似查找
	public List<FoodType> findByName(String name);

	// 获取表中所有对象
	public List<FoodType> getAll();

	// 增加
	public void add(FoodType ft);

	// 删除
	public void delete(int id);

	// 修改
	public void update(FoodType ft);
}
