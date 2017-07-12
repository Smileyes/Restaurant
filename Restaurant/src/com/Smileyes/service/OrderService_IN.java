package com.Smileyes.service;

import java.util.List;

import com.Smileyes.entity.OrderDetail;
import com.Smileyes.entity.Orders;

/*
 * 订单服务接口
 * */
public interface OrderService_IN {

	// 修改
	void update(Orders order);

	// 显示所有
	List<Orders> getAll();

	// 删除整条订单
	void delete(int id);

	// 根据id查询某条订单
	Orders findById(int id);

	// 结账
	void check(int id);

	// 根据餐桌id查寻
	List<Orders> findByTableId(int id);

}
