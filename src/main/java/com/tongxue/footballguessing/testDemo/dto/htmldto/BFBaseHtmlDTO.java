package com.tongxue.footballguessing.testDemo.dto.htmldto;

import fr.whimtrip.ext.jwhthtmltopojo.annotation.Selector;

public class BFBaseHtmlDTO {
	@Selector( value = " > :nth-child(1)")
	private String teamCnName;

	@Selector( value = " > :nth-child(2)")
	//必发指数--百分比 当时需要/100
	private  String betIndex;


	@Selector( value = " > :nth-child(3)")
	//交易量 整数
	private String tradeAmount;


	@Selector( value = " > :nth-child(4)")
	//比例--百分比 当时需要/100
	private String percentage;


	@Selector( value = " > :nth-child(5)")
	//赔付
	private String profit;


	@Selector( value = " > :nth-child(6)")
	//赔率 需要/100
	private String odds;


	@Selector( value = " > :nth-child(7)")
	//挂牌指数--百分比 当时需要/100
	private String hangOutIndex;

	@Selector( value = " > :nth-child(8)")
	//欧洲平均赔率
	private String europeOdds ;

	@Selector( value = " > :nth-child(9)")
	//凯利方差
	private String kelly;

	@Selector( value = " > :nth-child(10)")
	//大小交易量 钱
	private  String bigSmallTradeAmount;

	@Selector( value = " > :nth-child(11)")
	//大小比例 需要/100
	private String bigSmallPercentage;

	@Selector( value = " > :nth-child(12)")
	//大小价位 可能是赔率？ 需要/100
	private String bigSmallOdds;

	@Selector( value = " > :nth-child(13)")
	//大小指数
	private String bigSmallIndex;
}
