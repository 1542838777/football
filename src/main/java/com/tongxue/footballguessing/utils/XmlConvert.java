package com.tongxue.footballguessing.utils;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.dom4j.*;

import java.util.List;
import java.util.Set;

/**
 * @author
 */
public class XmlConvert {
	/**
	 * 属性名前缀
	 */
	private String attributeNamePrefix;
	/**
	 * 文本键名称
	 */
	private String textKey;
	/**
	 * 移除xml头文件，<?xml version="1.0" encoding="UTF-8"?>
	 */
	private boolean removeHeader;

	public XmlConvert() {
		this.setAttributeNamePrefix("@");
		this.setTextKey("#text");
		this.setRemoveHeader(true);
	}

	public XmlConvert(String attributeNamePrefix, String textKey) {
		this(attributeNamePrefix, textKey, true);
	}

	public XmlConvert(String attributeNamePrefix, String textKey, boolean removeHeader) {
		this.attributeNamePrefix = attributeNamePrefix;
		this.textKey = textKey;
		this.removeHeader = removeHeader;
	}

	/**
	 * json转xml<br/>
	 * {"abc":["aa","bb"]},此种格式的json串不支持，无根节点； 格式应该为：{"root":{"abc":["aa","bb"]}}
	 *
	 * @param json
	 * @return
	 */
	public String jsonToXml(String json) {
		JSONObject jsonObject = JSON.parseObject(json);
		Set<String> keySet = jsonObject.keySet();
		if (!keySet.isEmpty() && keySet.size() == 1) {
			// 将第一个节点name，作为根节点
			String rootName = keySet.iterator().next();
			Element rootElement = DocumentHelper.createElement(rootName);
			Element element = processObject(jsonObject.get(rootName), rootElement);
			String xml = DocumentHelper.createDocument(element).asXML();
			if (isRemoveHeader()) {
				xml = removeHeader(xml);
			}
			return xml;
		} else {
			throw new RuntimeException("The json text is not formatted correctly");
		}
	}

	private Element processObject(Object object, Element element) {
		if (object instanceof JSONObject) {
			return processJSONObject((JSONObject) object, element);
		} else if (object instanceof JSONArray) {
			return processJSONArray((JSONArray) object, element, element.getName());
		} else {
			return processText(object.toString(), element);
		}
	}

	private static Element processText(String text, Element element) {
		element.setText(text);
		return element;
	}

	private Element processJSONObject(JSONObject jsonObject, Element element) {
		jsonObject.forEach((key, value) -> {
			if (key.startsWith(getAttributeNamePrefix())) {
				element.addAttribute(key.substring(getPrefixLength()), value.toString());
			} else if (key.equals(getTextKey())) {
				element.setText(value.toString());
			} else {
				processValue(element, key, value);
			}
		});
		return element;
	}

	private void processValue(Element element, String name, Object value) {
		if (value instanceof JSONObject) {
			Element tempElement = processJSONObject((JSONObject) value, DocumentHelper.createElement(name));
			element.add(tempElement);
		} else if (value instanceof JSONArray) {
			JSONArray jsonArray = (JSONArray) value;
			int size = jsonArray.size();
			for (int i = 0; i < size; i++) {
				processValue(element, name, jsonArray.get(i));
			}
		} else {
			Element temp = processText(value.toString(), DocumentHelper.createElement(name));
			element.add(temp);
		}
	}

	private Element processJSONArray(JSONArray jsonArray, Element root, String name) {
		int size = jsonArray.size();
		for (int i = 0; i < size; ++i) {
			processValue(root, name, jsonArray.get(i));
		}
		return root;
	}

	/**
	 * xml转json
	 *
	 * @param xml
	 * @return
	 */
	public String xmlToJson(String xml) {
		try {
			Document document = DocumentHelper.parseText(xml);
			Element rootElement = document.getRootElement();
			JSON json = processObjectElement(rootElement);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put(rootElement.getName(), json);
			return jsonObject.toJSONString();
		} catch (DocumentException e) {
			throw new RuntimeException("The XML text is not formatted correctly", e);
		}
	}

	private JSONObject processObjectElement(Element element) {
		if (element == null) {
			return new JSONObject();
		}
		JSONObject jsonObject = new JSONObject();

		List<Attribute> attributes = element.attributes();
		for (Attribute attribute : attributes) {
			String attributeName = getAttributeNamePrefix() + attribute.getName();
			String attributeValue = attribute.getValue();
			setOrAccumulate(jsonObject, attributeName, attributeValue);
		}

		int nodeCount = element.nodeCount();
		for (int i = 0; i < nodeCount; i++) {
			Node node = element.node(i);
			if (node instanceof Text) {
				Text text = (Text) node;
				setOrAccumulate(jsonObject, getTextKey(), text.getText());
			} else if (node instanceof Element) {
				setValue(jsonObject, (Element) node);
			}
		}

		return jsonObject;
	}

	private void setValue(JSONObject jsonObject, Element element) {
		if (isObject(element)) {
			JSONObject elementJsonObj = processObjectElement(element);
			setOrAccumulate(jsonObject, element.getName(), elementJsonObj);
		} else {
			setOrAccumulate(jsonObject, element.getName(), element.getStringValue());
		}
	}

	private boolean isObject(Element element) {
		int attributeCount = element.attributeCount();
		if (attributeCount > 0) {
			return true;
		}

		int attrs = element.nodeCount();
		if (attrs == 1 && element.node(0) instanceof Text) {
			return false;
		} else {
			return true;
		}
	}

	private void setOrAccumulate(JSONObject jsonObject, String key, Object value) {
		if (jsonObject.containsKey(key)) {
			Object obj = jsonObject.get(key);
			if (obj instanceof JSONArray) {
				// 若为数组直接添加
				((JSONArray) obj).add(value);
			} else {
				// 若为非数组，创建数组（已存在的值obj,待添加的值value）
				JSONArray jsonArray = new JSONArray();
				jsonArray.add(obj);
				jsonArray.add(value);
				jsonObject.put(key, jsonArray);
			}
		} else {
			jsonObject.put(key, value);
		}
	}

	/**
	 * 移除xml报文头
	 *
	 * @param source
	 * @return
	 */
	private String removeHeader(String source) {
		return source.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "")
				.replaceAll("\r|\n", "");
	}


	public String getAttributeNamePrefix() {
		return attributeNamePrefix;
	}

	public void setAttributeNamePrefix(String attributeNamePrefix) {
		this.attributeNamePrefix = attributeNamePrefix;
	}

	public String getTextKey() {
		return textKey;
	}

	public void setTextKey(String textKey) {
		this.textKey = textKey;
	}

	public boolean isRemoveHeader() {
		return removeHeader;
	}

	public void setRemoveHeader(boolean removeHeader) {
		this.removeHeader = removeHeader;
	}

	private int getPrefixLength() {
		return this.attributeNamePrefix.length();
	}

}


