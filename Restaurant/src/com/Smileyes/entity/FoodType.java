package com.Smileyes.entity;

import com.Smileyes.annotation.TypeName;

/*
 * @auhtor Smileyes
 * 菜系实体类
 * */
@TypeName(typeName = "typeName")
public class FoodType {
	private int id;// 菜系id
	private String typeName;// 菜系名称

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public FoodType(int id, String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	}

	public FoodType() {
		super();
	}

}
