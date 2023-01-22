package com.tongxue.footballguessing.testDemo.dto;

import fr.whimtrip.ext.jwhthtmltopojo.annotation.ReplaceWith;
import fr.whimtrip.ext.jwhthtmltopojo.annotation.Selector;
import fr.whimtrip.ext.jwhthtmltopojo.impl.ReplacerDeserializer;

import java.util.List;

public class Restaurant {

	@Selector( value = "div.restaurant > h1")
	private String name;

	@Selector( value = "div.restaurant > p:nth-child(2)")
	private String description;

	@Selector( value = "div.restaurant > div:nth-child(3) > p > span")
	private String location;

	@Selector(
			value = "div.restaurant > p:nth-child(4)",
			format = "^Restaurant n*([0-9,]+). Ranked ([0-9,]+) out of ([0-9,]+) restaurants$",
			indexForRegexPattern = 1,
			useDeserializer = true,
			deserializer = ReplacerDeserializer.class,
			preConvert = true,
			postConvert = false
	)
	// so that the number becomes a valid number as they are shown in this format : 18,190
	@ReplaceWith(value = ",", with = "")
	private Long id;

	@Selector(
			value = "div.restaurant > p:nth-child(4)",
			format = "^Restaurant n*([0-9,]+). Ranked ([0-9,]+) out of ([0-9,]+) restaurants$",
			// This time, we want the second regex group and not the first one anymore
			indexForRegexPattern = 2,
			useDeserializer = true,
			deserializer = ReplacerDeserializer.class,
			preConvert = true,
			postConvert = false
	)
	// so that the number becomes a valid number as they are shown in this format : 18,190
	@ReplaceWith(value = ",", with = "")
	private Integer rank;

	@Selector(value = ".meal")
	private List<Meal> meals;

	public Restaurant() {
	}

	// getters and setters

}

