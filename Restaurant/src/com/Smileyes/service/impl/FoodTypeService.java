package com.Smileyes.service.impl;

import java.util.List;

import com.Smileyes.dao.FoodTypeDao;
import com.Smileyes.entity.FoodType;
import com.Smileyes.service.FoodTypeService_IN;

public class FoodTypeService implements FoodTypeService_IN {
	public static FoodTypeDao foodTypeDao = new FoodTypeDao();

	// 根据id查找
	public FoodType findById(int id) {
		return this.foodTypeDao.findById(id);
	}

	// 根据名称近似查找
	public List<FoodType> findByName(String name) {
		return this.foodTypeDao.findByName(name);
	}

	// 获取表中所有对象
	public List<FoodType> getAll() {
		return foodTypeDao.getAll();
	}

	// 增加
	public void add(FoodType ft) {
		this.foodTypeDao.add(ft);
	}

	// 删除
	public void delete(int id) {
		this.foodTypeDao.delete(id);
	}

	// 修改
	public void update(FoodType ft) {
		this.foodTypeDao.update(ft);
	}
}
