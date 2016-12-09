package com.example.jingfeng.android.bean;

import java.io.Serializable;

/**
 * Created by wanggh on 2015/6/10.
 */
public class APIHostInfo implements Serializable {
	private String schema;
	private String host;
	private String contextPath;

	public APIHostInfo() {
	}

	public APIHostInfo(String schema, String host, String contextPath) {
		this.schema = schema;
		this.host = host;
		this.contextPath = contextPath;
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
}
