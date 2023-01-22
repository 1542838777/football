package com.tongxue.footballguessing.utils;



import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

/**
 * @author
 */
public class XmlJsonUtils {
	private XmlJsonUtils() {
	}

	/**
	 * xml转json,默认忽略根节点
	 *
	 * @param xml
	 * @return
	 */
	@Deprecated
	public static String xmlToJsonStr(String xml) {
		return xmlToJsonStr(xml, false);
	}

	/**
	 * xml转json
	 *
	 * @param xml
	 * @param forceTopLevelObject 显示(解析)根节点
	 * @return
	 */
	@Deprecated
	public static String xmlToJsonStr(String xml, boolean forceTopLevelObject) {
		XMLSerializer xmlSerializer = new XMLSerializer();
		xmlSerializer.setForceTopLevelObject(forceTopLevelObject);
		return xmlSerializer.read(xml).toString();
	}

	/**
	 * json转xml,默认根节点为o
	 *
	 * @param jsonStr
	 * @return
	 */
	@Deprecated
	public static String jsonToXml(String jsonStr) {
		return jsonToXml(jsonStr, "");
	}

	/**
	 * json转xml
	 *
	 * @param jsonStr
	 * @param rootName 可设置根节点
	 * @return
	 */
	@Deprecated
	public static String jsonToXml(String jsonStr, String rootName) {
		return jsonToXml(jsonStr, rootName, null);
	}

	/**
	 * @param jsonStr
	 * @param rootName
	 * @param elementName
	 * @return
	 */
	@Deprecated
	public static String jsonToXml(String jsonStr, String rootName, String elementName) {
		XMLSerializer xmlSerializer = new XMLSerializer();
		// 关闭类型提示
		xmlSerializer.setTypeHintsEnabled(false);
		// 设置根节点名称
		xmlSerializer.setRootName(rootName);
		xmlSerializer.setElementName(elementName);
		JSON json = getJSON(jsonStr);
		String xmlStr = xmlSerializer.write(json);
		return removeHeaderMessage(xmlStr);
	}

	/**
	 * 移除xml报文头
	 *
	 * @param source
	 * @return
	 */
	@Deprecated
	private static String removeHeaderMessage(String source) {
		return source.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "").replaceAll("\r|\n", "");
	}

	/**
	 * json串转换为json对象
	 *
	 * @param jsonStr
	 * @return
	 */
	@Deprecated
	private static JSON getJSON(String jsonStr) {
		return JSONSerializer.toJSON(jsonStr);
	}

	// 新的xml与json互相转换

	/**
	 * xml转json
	 *
	 * @param xml                 待转换的xml
	 * @param attributeNamePrefix xml属性名前缀
	 * @param textKey             xml文本键名称
	 * @return
	 */
	public static String xmlToJSON(String xml, String attributeNamePrefix, String textKey) {
		XmlConvert xmlConvert = new XmlConvert(attributeNamePrefix, textKey);
		return xmlConvert.xmlToJson(xml);
	}

	/**
	 * xml转json<br/>
	 * 默认xml文本键名称为:#text
	 *
	 * @param xml                 待转换的xml
	 * @param attributeNamePrefix xml属性名前缀
	 * @return
	 */
	public static String xmlToJSON(String xml, String attributeNamePrefix) {
		return xmlToJSON(xml, attributeNamePrefix, "#text");
	}

	/**
	 * xml转json<br/>
	 * 默认xml文本键名称为:#text,xml属性名前缀为'@'
	 *
	 * @param xml 待转换的xml
	 * @return
	 */
	public static String xmlToJSON(String xml) {
		return xmlToJSON(xml, "@");
	}


	/**
	 * json转xml
	 *
	 * @param json                待转换的json串
	 * @param attributeNamePrefix 转换后的xml属性名前缀
	 * @param textKey             转换后的xml文本键名称
	 * @param removeHeader        移除xml头文件
	 * @return
	 */
	public static String jsonToXML(String json, String attributeNamePrefix, String textKey, boolean removeHeader) {
		XmlConvert xmlConvert = new XmlConvert(attributeNamePrefix, textKey, removeHeader);
		return xmlConvert.jsonToXml(json);
	}

	/**
	 * json转xml<br/>
	 * 默认转换后移除xml头文件
	 *
	 * @param json                待转换的json串
	 * @param attributeNamePrefix 转换后的xml属性名前缀
	 * @param textKey             转换后的xml文本键名称
	 * @return
	 */
	public static String jsonToXML(String json, String attributeNamePrefix, String textKey) {
		return jsonToXML(json, attributeNamePrefix, textKey, true);
	}

	/**
	 * json转xml<br/>
	 * 默认转换后移除xml头文件,xml文本键名称为#text
	 *
	 * @param json                待转换的json串
	 * @param attributeNamePrefix 转换后的xml属性名前缀
	 * @return
	 */
	public static String jsonToXML(String json, String attributeNamePrefix) {
		return jsonToXML(json, attributeNamePrefix, "#text", true);
	}

	/**
	 * json转xml<br/>
	 * 默认转换后移除xml头文件,xml文本键名称为#text,属性名前缀为'@'
	 *
	 * @param json 待转换的json串
	 * @return
	 */
	public static String jsonToXML(String json) {
		return jsonToXML(json, "@");
	}


}


