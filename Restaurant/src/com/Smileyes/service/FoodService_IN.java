package com.Smileyes.service;

import java.util.List;

import com.Smileyes.entity.Food;

/*
 * 食品服务接口
 * */
public interface FoodService_IN {

	void add(Food food);

	void delete(int id);

	Food findById(int id);

	void update(Food food);

	List<Food> findByName(String name);

	List<Food> getAll();

	List<Food> findByTypeId(int id);

}
