package com.Smileyes.service.impl;

import java.util.List;

import com.Smileyes.dao.TableDao;
import com.Smileyes.entity.FoodTable;
import com.Smileyes.factory.BeanFactory;
import com.Smileyes.service.TableService_IN;

public class TableService implements TableService_IN {
	public static TableDao tableDao = new TableDao();

	// 添加
	public void add(FoodTable ft) {
		this.tableDao.add(ft);
	}

	// 修改
	public void update(FoodTable ft) {
		this.tableDao.update(ft);

	}

	// 显示列表
	public List<FoodTable> getAll() {
		return this.tableDao.getAll();
	}

	// 删除
	public void delete(int id) {
		this.tableDao.delete(id);
	}

	// 根据名称查找
	public List<FoodTable> findByName(String name) {
		return this.tableDao.findByName(name);
	}

	// 根据id查找
	public FoodTable findById(int tableId) {
		return this.tableDao.findById(tableId);
	}
}
