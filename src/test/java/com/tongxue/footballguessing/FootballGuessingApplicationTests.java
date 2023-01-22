package com.tongxue.footballguessing;

import com.tongxue.footballguessing.service.getFromWeb.GetDataHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class FootballGuessingApplicationTests {
	@Resource
	private HttpClient httpClient;
	@Autowired
	@Qualifier(value = "spSFPDataQueryHandlerImpl")
	private GetDataHandler getDataHandler;

	@Test
	void contextLoads() {
	/*	String result = httpClient.helloForest();
		System.out.println(111111);
		String s = XmlJsonUtils.xmlToJSON(result,"");
		System.out.println(s);*/
		System.out.println(httpClient.bf());
		//System.out.println(getDataHandler.getData());
	}

}
