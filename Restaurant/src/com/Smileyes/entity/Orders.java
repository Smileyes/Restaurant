package com.Smileyes.entity;

import java.util.Date;

/*
 * @author Smileyes
 * 订单表实体类
 * */
public class Orders {
	private int id;// 订单id
	private Date orderDate;// 订单时间
	private int tableId;// 餐桌id
	private double orderPrice;// 订单总价
	private int orderStatus;// 点单状态

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Orders() {
		super();
	}

	public Orders(int id, Date orderDate, int tableId, double orderPrice) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.tableId = tableId;
		this.orderPrice = orderPrice;
	}
}
