package com.tongxue.footballguessing.testDemo.dto.htmldto;

import fr.whimtrip.ext.jwhthtmltopojo.annotation.Selector;

import java.util.List;

public class BFBothHtmlDTO {

	@Selector( value = "tr:nth-child(2)")
	private BFBaseHtmlDTO win;
	@Selector( value = "tr:nth-child(3)")
	private BFBaseHtmlDTO draw;
	@Selector( value = "tr:nth-child(4)")
	private BFBaseHtmlDTO lost;

}
