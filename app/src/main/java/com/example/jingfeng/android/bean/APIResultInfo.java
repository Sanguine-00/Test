package com.example.jingfeng.android.bean;

import java.io.Serializable;

public class APIResultInfo<T> implements Serializable {
	
	private int httpCode;
	private int errorCode;
	private String message;
	private Boolean display;
	private String schema;
	private String host;
	private String contextPath;
	private T items;
	private T item;
	public int getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getDisplay() {
		return display;
	}
	public void setDisplay(Boolean display) {
		this.display = display;
	}
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getContextPath() {
		return contextPath;
	}
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
	public T getItems() {
		return items;
	}
	public void setItems(T items) {
		this.items = items;
	}
	public T getItem() {
		return item;
	}
	public void setItem(T item) {
		this.item = item;
	}
	public APIHostInfo getApiHostInfo(){
		return new APIHostInfo(schema,host,contextPath);
	}
}
