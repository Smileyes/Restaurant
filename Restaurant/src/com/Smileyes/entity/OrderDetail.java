package com.Smileyes.entity;

import java.sql.SQLException;

import org.apache.commons.dbutils.handlers.BeanListHandler;

/*
 * @author Smileyes
 * 订单详情类
 * */
public class OrderDetail {
	private int id;// 订单详情id
	private int orderId;// 订单id
	private int foodId;// 菜品id
	private int foodNum;// 菜品数量
	private double price;// 购买时的单价

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public OrderDetail() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getFoodNum() {
		return foodNum;
	}

	public void setFoodNum(int foodNum) {
		this.foodNum = foodNum;
	}

}
