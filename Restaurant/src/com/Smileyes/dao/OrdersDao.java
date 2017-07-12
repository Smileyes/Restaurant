package com.Smileyes.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Smileyes.dao.In.BaseDao;
import com.Smileyes.entity.OrderDetail;
import com.Smileyes.entity.Orders;

/*
 * 订单DAO
 * */
public class OrdersDao extends BaseDao<Orders> {

	// 添加
	public void add(Orders order) {
		String sql = "insert into Orders (orderDate,tableId,OrderPrice) values(?,?,?)";
		try {
			qr.update(sql, order.getOrderDate(), order.getTableId(), order.getOrderPrice());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 修改
	public void update(Orders order) {
		String sql = "update Orders set orderDate=?,tableId=?,orderPrice=? where id=?";
		try {
			qr.update(sql, order.getOrderDate(), order.getTableId(), order.getOrderPrice(),
					order.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 结账
	public void check(int id) {
		String sql = "update Orders set orderStatus=1 where id=?";
		try {
			qr.update(sql, id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 根据餐桌id查找
	public List<Orders> finByTableId(int tableId) {
		String sql = "select * from orders where tableId=?";
		try {
			return qr.query(sql, new BeanListHandler<Orders>(Orders.class), tableId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
