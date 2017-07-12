package com.Smileyes.dao;

import java.sql.SQLException;

import com.Smileyes.dao.In.BaseDao;
import com.Smileyes.entity.FoodType;

/*
 * 菜系DAO
 * */
public class FoodTypeDao extends BaseDao<FoodType> {
	
	// 添加
	public void add(FoodType ft) {
		String sql = "insert into FoodType (typeName) values(?)";
		try {
			qr.update(sql, ft.getTypeName());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 修改
	public void update(FoodType ft) {
		String sql = "update FoodType set typeName=? where id=?";
		try {
			qr.update(sql, ft.getTypeName(), ft.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
