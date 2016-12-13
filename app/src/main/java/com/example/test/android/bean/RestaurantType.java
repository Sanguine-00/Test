package com.example.test.android.bean;

import java.io.Serializable;

/**
 * Created by wanggh on 2015/8/31.
 */
public class RestaurantType implements Serializable {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
