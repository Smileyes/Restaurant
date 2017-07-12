package com.Smileyes.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Smileyes.dao.In.BaseDao;
import com.Smileyes.entity.Food;
import com.Smileyes.entity.FoodType;
import com.Smileyes.servlet.TypeServlet;

/*
 * 菜品Dao
 * */
public class FoodDao extends BaseDao<Food> {

	// 添加
	public void add(Food food) {
		String sql = "insert into Food (foodName,typeId,foodPrice,vipPrice,foodInfo,foodImage) values(?,?,?,?,?,?)";
		try {
			qr.update(sql, food.getFoodName(), food.getTypeId(), food.getFoodPrice(),
					food.getVipPrice(), food.getFoodInfo(), food.getFoodImage());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 修改
	public void update(Food food) {
		try {
			String sql;
			if (food.getFoodImage() == null || "".equals(food.getFoodImage())) {
				sql = "update Food set foodName=?,typeId=?,foodPrice=?,vipPrice=?,foodInfo=? where id=?";
				qr.update(sql, food.getFoodName(), food.getTypeId(), food.getFoodPrice(),
						food.getVipPrice(), food.getFoodInfo(), food.getId());
			} else {
				sql = "update Food set foodName=?,typeId=?,foodPrice=?,vipPrice=?,foodInfo=?,foodImage=? where id=?";
				qr.update(sql, food.getFoodName(), food.getTypeId(), food.getFoodPrice(),
						food.getVipPrice(), food.getFoodInfo(), food.getFoodImage(), food.getId());
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 通过菜系id查找
	public List<Food> findByTypeId(int typeId) {
		String sql = "select * from Food where typeId = ?";
		try {
			return qr.query(sql, new BeanListHandler<Food>(Food.class), typeId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 通过菜系名查找
	public List<Food> findByTypeName(String typeName) {
		List<Food> list = new ArrayList<Food>();
		List<FoodType> typeList = TypeServlet.service.findByName(typeName);
		for (FoodType type : typeList) {
			list.addAll(this.findByTypeId(type.getId()));
		}
		return list;
	}
}
