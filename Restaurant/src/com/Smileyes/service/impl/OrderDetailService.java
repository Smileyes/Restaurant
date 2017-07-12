package com.Smileyes.service.impl;

import java.util.List;

import com.Smileyes.dao.OrderDetailDao;
import com.Smileyes.entity.OrderDetail;
import com.Smileyes.service.OrderDetailService_IN;

public class OrderDetailService implements OrderDetailService_IN {
	private OrderDetailDao dao = new OrderDetailDao();

	// 查找
	public List<OrderDetail> find(int orderId) {
		return this.dao.find(orderId);
	}

	public List<OrderDetail> findByFoodId(int foodId) {
		return this.dao.finByFoodId(foodId);
	}

	// 删除某个订单的所有订单详情
	public void deleteOrder(int orderId) {
		this.dao.deleteOrder(orderId);
	}
}
