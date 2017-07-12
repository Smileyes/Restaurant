package com.Smileyes.service.impl;

import java.util.List;

import com.Smileyes.dao.FoodDao;
import com.Smileyes.entity.Food;
import com.Smileyes.service.FoodService_IN;
import com.Smileyes.servlet.TypeServlet;

public class FoodService implements FoodService_IN {
	private static FoodDao dao = new FoodDao();

	// 添加
	public void add(Food food) {
		this.dao.add(food);
	}

	// 删除
	public void delete(int id) {
		this.dao.delete(id);
	}

	// 查找
	public Food findById(int id) {
		return this.dao.findById(id);
	}

	// 修改
	public void update(Food food) {
		this.dao.update(food);

	}

	// 通过菜名或菜系名查找
	public List<Food> findByName(String name) {
		List list1 = this.dao.findByName(name);
		List list2 = this.dao.findByTypeName(name);
		list1.addAll(list2);
		return list1;
	}

	// 获得所有
	public List<Food> getAll() {
		return this.dao.getAll();
	}

	// 通过菜系id查找
	public List<Food> findByTypeId(int id) {
		return this.dao.findByTypeId(id);
	}

}
