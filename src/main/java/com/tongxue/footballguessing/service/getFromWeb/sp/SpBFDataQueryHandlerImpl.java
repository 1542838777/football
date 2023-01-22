package com.tongxue.footballguessing.service.getFromWeb.sp;

import com.alibaba.fastjson.JSON;
import com.tongxue.footballguessing.HttpClient;
import com.tongxue.footballguessing.data.dto.jsondto.fiveHundred.MatchDTO;
import com.tongxue.footballguessing.service.getFromWeb.GetDataHandler;
import com.tongxue.footballguessing.utils.XmlUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * odds
 */
public class SpBFDataQueryHandlerImpl implements GetDataHandler {
	@Resource
	private HttpClient httpClient;
	public List<MatchDTO> getList(){
		String json_with_xml = httpClient.helloForest();
		return null;
	}

	@Override
	public Object getData() {
		String with_xml_tag = httpClient.helloForest();
		String json = formatXmlToNeedJson(with_xml_tag);
		List<MatchDTO> m = JSON.parseArray(json, MatchDTO.class);
		System.out.println(m);
		return m;
	}

	@Override
	public String formatXmlToNeedJson(String originXMl) {
		String targetJson = XmlUtils.bigJsonToTargetJSONByKey(originXMl,"xml","matches");
		return targetJson;
	}
}
