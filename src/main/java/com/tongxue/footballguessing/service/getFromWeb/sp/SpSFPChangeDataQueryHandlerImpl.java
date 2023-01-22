package com.tongxue.footballguessing.service.getFromWeb.sp;

import com.alibaba.fastjson.JSON;
import com.tongxue.footballguessing.HttpClient;
import com.tongxue.footballguessing.data.dto.jsondto.fiveHundred.MatchDTO;
import com.tongxue.footballguessing.service.getFromWeb.GetDataHandler;
import com.tongxue.footballguessing.utils.XmlUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 胜负平 赔率 更新 数据
 * 比赛team 两队
 */
@Component("spSFPDataQueryHandlerImpl")
public class SpSFPChangeDataQueryHandlerImpl implements GetDataHandler {
	@Resource
	private HttpClient httpClient;

	@Override
	public Object getData() {
		String with_xml_tag = httpClient.spSPF();
		String json = formatXmlToNeedJson(with_xml_tag);
		System.out.println(json);
		List<MatchDTO> m = JSON.parseArray(json, MatchDTO.class);
		System.out.println(m);
		return m;
	}

	@Override
	public String formatXmlToNeedJson(String originXMl) {
		String targetJson = XmlUtils.bigJsonToTargetJSONByKey(originXMl,"xml","m");
		return targetJson;
	}

}
