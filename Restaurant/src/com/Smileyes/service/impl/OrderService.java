package com.Smileyes.service.impl;

import java.util.List;

import com.Smileyes.dao.OrdersDao;
import com.Smileyes.entity.OrderDetail;
import com.Smileyes.entity.Orders;
import com.Smileyes.service.OrderService_IN;

/*
 * 订单服务类
 * */
public class OrderService implements OrderService_IN {
	public static OrdersDao dao = new OrdersDao();

	// 修改
	public void update(Orders order) {
		this.dao.update(order);
	}

	// 显示所有
	public List<Orders> getAll() {
		return this.dao.getAll();
	}

	// 删除某个订单
	public void delete(int id) {
		this.dao.delete(id);
	}

	// 查找
	public Orders findById(int id) {
		return this.dao.findById(id);
	}

	// 结账
	public void check(int id) {
		this.dao.check(id);
	}

	// 根据餐桌id查询订单
	public List<Orders> findByTableId(int tableId) {
		return this.dao.finByTableId(tableId);
	}
}
