package com.tongxue.footballguessing.config;

import com.dtflys.forest.converter.xml.ForestJaxbConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfig {
	@Bean
	public ForestJaxbConverter forestJaxbConverter(){
		ForestJaxbConverter forestJaxbConverter = new ForestJaxbConverter();
		return forestJaxbConverter;
	}
}
