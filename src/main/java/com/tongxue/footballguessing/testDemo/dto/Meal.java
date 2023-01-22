package com.tongxue.footballguessing.testDemo.dto;


import fr.whimtrip.ext.jwhthtmltopojo.annotation.Selector;

public class Meal {

	@Selector(value = "p:nth-child(1)")
	private String name;

	@Selector(
			value = "p:nth-child(2)",
			format = "^([0-9.]+)\5 stars",
			indexForRegexPattern = 1
	)
	private Float stars;

	@Selector(
			value = "p:nth-child(2)",
			// rating-color custom attribute can be used as well
			attr = "rating-color"
	)
	private String ratingColor;

	@Selector(
			value = "p:nth-child(3)"
	)
	private String chefs;

	// getters and setters.
}

