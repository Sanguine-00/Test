package com.example.test.jingfeng.util;

import android.util.Log;

import com.example.test.jingfeng.ConfigAPI;
import com.google.gson.Gson;

public class JSONTools {
	
	private final static String TAG = "JSONTools";

	public JSONTools() {

	}

	/**
	 * 将JSON字符串解析成对象
	 * @param jsonString
	 *            要解析的json字符串
	 * @param cls
	 * @return
	 */
	public static <T> T fromJSONString(String jsonString, Class<T> cls) {
		T t = null;
		try {
			Gson gson = new Gson();
			t = gson.fromJson(jsonString, cls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	
	/**
	 * 图片地址拼接
	 * @param imageUrl
	 * @param mSchema
	 * @param mHost
	 * @param mContextPath
	 * @return
	 */
	public static String formatURL(String imageUrl, String mSchema, String mHost, String mContextPath){
		return formatURL(imageUrl, mSchema, mHost, mContextPath, 0);
	}
	/**
	 * 图片地址拼接
	 * @param imageUrl
	 * @param mSchema
	 * @param mHost
	 * @param mContextPath
	 * @param width
	 * @return
	 */
	public static String formatURL(String imageUrl, String mSchema, String mHost, String mContextPath, int width){
		try {
			if(imageUrl==null)
				imageUrl = "";
			if (!imageUrl.contains(mHost) && !imageUrl.contains(mSchema)) {
				if (imageUrl.indexOf("/") == 0) {
					imageUrl = mSchema + "://" + mHost + imageUrl;
				} else if (imageUrl.indexOf("/") != 0) {
					imageUrl = mSchema + "://" + mHost + "/" + mContextPath+ "/" + imageUrl;
				}
			}else if (!imageUrl.contains(mSchema)){
				imageUrl = ConfigAPI.MAIN + imageUrl;
			}
			if(mContextPath.contains("/")){
				imageUrl = imageUrl.replace("/" + mContextPath, mContextPath);
			}
			if(/*imageUrl.contains("/image/") &&*/ width>0){
				//imageUrl = imageUrl.replaceAll("\\?.*","")+"?w="+width;
				if(imageUrl.contains("?")) {
					if(!imageUrl.contains("?w="))
						imageUrl = imageUrl + "&w=" + width;
				}
				else{
					imageUrl = imageUrl+"?w="+width;
				}
			}
			Log.i(TAG, imageUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imageUrl;
	}



}
