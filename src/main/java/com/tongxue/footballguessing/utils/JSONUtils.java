package com.tongxue.footballguessing.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JSONUtils {
	public static JSON getJSONObject(String jsonString, String key){
		return (JSON) JSON.parseObject(jsonString).get(key);
	}
	public static String getJSONObjectString(String jsonString, String key){
		return getJSONObject(jsonString,key).toString();
	}
}
