package com.tongxue.footballguessing.data.dto.htmldto.fiveHundred;

import fr.whimtrip.ext.jwhthtmltopojo.annotation.Selector;

public class BFBothHtmlDTO {

	@Selector( value = "tr:nth-child(2)")
	private BFBaseHtmlDTO win;
	@Selector( value = "tr:nth-child(3)")
	private BFBaseHtmlDTO draw;
	@Selector( value = "tr:nth-child(4)")
	private BFBaseHtmlDTO lost;

}
