package com.Smileyes.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Smileyes.dao.In.BaseDao;
import com.Smileyes.entity.OrderDetail;

/*
 *订单详情DAO
 * */
public class OrderDetailDao extends BaseDao<OrderDetail> {

	// 添加
	public void add(OrderDetail od) {
		String sql = "insert into OrderDetail (orderId,foodId,foodNum,price) values(?,?,?,?)";
		try {
			qr.update(sql, od.getOrderId(), od.getFoodId(), od.getFoodNum(), od.getPrice());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 修改
	public void update(OrderDetail od) {
		String sql = "update OrderDetail set orderId=?,foodId=?,foodNum=?,price=? where id=?";
		try {
			qr.update(sql, od.getOrderId(), od.getFoodId(), od.getFoodNum(), od.getPrice(),
					od.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 查找某个订单的详情
	public List<OrderDetail> find(int id) {
		String sql = "select * from orderDetail where orderId=?";
		try {
			return qr.query(sql, new BeanListHandler<OrderDetail>(OrderDetail.class), id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 查询菜品查找订单信息
	public List<OrderDetail> finByFoodId(int foodId) {
		String sql = "select * from orderDetail where foodId=?";
		try {
			return qr.query(sql, new BeanListHandler<OrderDetail>(OrderDetail.class), foodId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 删除某个订单的所有详情
	public void deleteOrder(int orderId) {
		String sql = "delete from OrderDetail where orderId=?";
		try {
			qr.update(sql, orderId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
