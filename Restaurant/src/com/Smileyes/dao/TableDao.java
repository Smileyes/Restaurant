package com.Smileyes.dao;

import java.sql.SQLException;
import java.util.Date;

import com.Smileyes.dao.In.BaseDao;
import com.Smileyes.entity.FoodTable;

/*
 * 餐桌DAO
 * */
public class TableDao extends BaseDao<FoodTable> {
	// 添加
	public void add(FoodTable ft) {
		String sql = "insert into foodTable (tableName) values(?)";
		try {
			qr.update(sql, ft.getTableName());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 修改
	public void update(FoodTable ft) {
		String sql = "update foodTable set tableStatus=?,orderTime=? where id=?";
		if (ft.getTableStatus() == 0) {
			ft.setTableStatus(1);
			ft.setOrderTime(new Date());
		} else {
			ft.setTableStatus(0);
			ft.setOrderTime(null);
		}
		try {
			qr.update(sql, ft.getTableStatus(), ft.getOrderTime(), ft.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
