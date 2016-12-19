package com.example.test.jingfeng.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wanggh on 2015/8/31.
 */
public class Restaurant implements Serializable {
	private int id;
	private String name;
	private RestaurantType restaurantType;
	private String address;
	private double pointX;
	private String pointY;
	private City city;
	private CityArea cityArea;
	private String openHour;
	private String personConsumption;
	private String icon;
	private String location;
	private boolean supportBookTable;
	private boolean supportLineup;
	private boolean supportDishesOrder;
	private float averageScore;
	private List<ShopMapLocationInfo> restaurantNumbers;
	private String doorImage;

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

	public RestaurantType getRestaurantType() {
		return restaurantType;
	}

	public void setRestaurantType(RestaurantType restaurantType) {
		this.restaurantType = restaurantType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getPointX() {
		return pointX;
	}

	public void setPointX(double pointX) {
		this.pointX = pointX;
	}

	public String getPointY() {
		return pointY;
	}

	public void setPointY(String pointY) {
		this.pointY = pointY;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public CityArea getCityArea() {
		return cityArea;
	}

	public void setCityArea(CityArea cityArea) {
		this.cityArea = cityArea;
	}

	public String getOpenHour() {
		return openHour;
	}

	public void setOpenHour(String openHour) {
		this.openHour = openHour;
	}

	public String getPersonConsumption() {
		return personConsumption;
	}

	public void setPersonConsumption(String personConsumption) {
		this.personConsumption = personConsumption;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isSupportBookTable() {
		return supportBookTable;
	}

	public void setSupportBookTable(boolean supportBookTable) {
		this.supportBookTable = supportBookTable;
	}

	public boolean isSupportLineup() {
		return supportLineup;
	}

	public void setSupportLineup(boolean supportLineup) {
		this.supportLineup = supportLineup;
	}

	public boolean isSupportDishesOrder() {
		return supportDishesOrder;
	}

	public void setSupportDishesOrder(boolean supportDishesOrder) {
		this.supportDishesOrder = supportDishesOrder;
	}

	public float getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(float averageScore) {
		this.averageScore = averageScore;
	}

	public List<ShopMapLocationInfo> getRestaurantNumbers() {
		return restaurantNumbers;
	}

	public void setRestaurantNumbers(List<ShopMapLocationInfo> restaurantNumbers) {
		this.restaurantNumbers = restaurantNumbers;
	}

	public String getDoorImage() {
		return doorImage;
	}

	public void setDoorImage(String doorImage) {
		this.doorImage = doorImage;
	}
}
