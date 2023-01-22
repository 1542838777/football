package com.tongxue.footballguessing.utils;

public class XmlUtils {
	public static String bigJsonToTargetJSONByKey(String xml, String... keys) {
		String bigJSONSTRING = XmlJsonUtils.xmlToJSON(xml, "");
		for (int i = 0; i < keys.length; i++) {
			bigJSONSTRING = JSONUtils.getJSONObjectString(bigJSONSTRING, keys[i]);
		}
		return bigJSONSTRING;
	}




}
