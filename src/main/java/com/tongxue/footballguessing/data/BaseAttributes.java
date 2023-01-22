package com.tongxue.footballguessing.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tongxue.footballguessing.exception.AssertUtil;
import lombok.Data;

import java.util.Map;

@Data
public  class BaseAttributes extends BaseObject{
		String attributes;

public void put(String key,Object value)throws Exception{
		AssertUtil.isNotEmpty(key,value);
		if(getAttributes()==null){
		attributes=new String();
		}
		Map parse=(Map)JSONObject.parseObject(attributes,Map.class);
		parse.put(key,value);
		}
		}
