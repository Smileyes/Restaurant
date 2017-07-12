package com.Smileyes.entity;

import java.util.Date;

import org.junit.Test;

import com.Smileyes.annotation.TypeName;

/*
 *@author Smileyes
 *实体类：餐桌 
 */
@TypeName(typeName = "tableName")
public class FoodTable {
	private int id;// 餐桌id
	private String tableName;// 餐桌名
	private int tableStatus = 0;// 餐桌状态，0为已预订，1为未预定
	private Date orderTime;// 预定时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getTableStatus() {
		return tableStatus;
	}

	public void setTableStatus(int tableStatue) {
		this.tableStatus = tableStatue;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public FoodTable(int id, String tableName, int tableStatus, Date orderTime) {
		super();
		this.id = id;
		this.tableName = tableName;
		this.tableStatus = tableStatus;
		this.orderTime = orderTime;
	}

	public FoodTable() {
		super();
	}
}
