package com.Smileyes.entity;

import com.Smileyes.annotation.TypeName;

/*
 * @author Smileyes
 * 菜品类
 * */
@TypeName(typeName = "foodName")
public class Food {
	private int id;// 菜品id
	private String foodName;// 菜品名
	private int typeId;// 所属菜系Id
	private double foodPrice;// 菜品单价
	private double vipPrice;// 会员价
	private String foodInfo;// 菜品信息
	private String foodImage;// 菜品图片地址

	public Food() {
		super();
	}

	public double getVipPrice() {
		return vipPrice;
	}

	public void setVipPrice(double vipPrice) {
		this.vipPrice = vipPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public String getFoodInfo() {
		return foodInfo;
	}

	public void setFoodInfo(String foodInfo) {
		this.foodInfo = foodInfo;
	}

	public String getFoodImage() {
		return foodImage;
	}

	public void setFoodImage(String foodImage) {
		this.foodImage = foodImage;
	}

}
