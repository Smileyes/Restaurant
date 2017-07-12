package com.Smileyes.service;

import java.util.List;

import com.Smileyes.entity.OrderDetail;

/*
 * 订单详情服务接口
 * */
public interface OrderDetailService_IN {
	// 查找
	public List<OrderDetail> find(int orderId);

	// 查询订单中是否有某样菜品
	public List<OrderDetail> findByFoodId(int foodId);

	// 删除某个订单的所有订单详情
	public void deleteOrder(int orderId);

}
