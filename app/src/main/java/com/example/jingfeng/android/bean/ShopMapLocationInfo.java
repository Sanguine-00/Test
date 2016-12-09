package com.example.jingfeng.android.bean;

import java.io.Serializable;

/**
 * Created by wanggh on 2015/11/21.
 */
public class ShopMapLocationInfo implements Serializable {
	private String floorId;
	private String floorName;
	private String shopNumber;
	private String objectId;

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public void setShopNumber(String shopNumber) {
		this.shopNumber = shopNumber;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getFloorId() {
		return floorId;
	}

	public String getFloorName() {
		return floorName;
	}

	public String getShopNumber() {
		return shopNumber;
	}

	public String getObjectId() {
		return objectId;
	}
}
