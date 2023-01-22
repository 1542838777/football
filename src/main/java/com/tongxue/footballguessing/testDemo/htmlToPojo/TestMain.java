package com.tongxue.footballguessing.testDemo.htmlToPojo;

import com.tongxue.footballguessing.testDemo.dto.htmldto.BFBothHtmlDTO;
import com.tongxue.footballguessing.testDemo.dto.Restaurant;
import fr.whimtrip.ext.jwhthtmltopojo.HtmlToPojoEngine;
import fr.whimtrip.ext.jwhthtmltopojo.intrf.HtmlAdapter;

import java.io.IOException;

public class TestMain {
	public static void main(String[] args) throws IOException    {

		//testDemo();
		 testFoot();
	}

	private static void testFoot() {
		HtmlToPojoEngine htmlToPojoEngine = HtmlToPojoEngine.create();

		HtmlAdapter<BFBothHtmlDTO> adapter = htmlToPojoEngine.adapter(BFBothHtmlDTO.class);

		// If they were several restaurants in the same page,
		// you would need to create a parent POJO containing
		// a list of Restaurants as shown with the meals here
		BFBothHtmlDTO bfdto = adapter.fromHtml(getHtmBFDTO());
		System.out.println(bfdto);

	}

	private static String getHtmBFDTO() {
		return "\n" +
				"\n" +
				"<table cellpadding=\"0\" cellspacing=\"0\" class=\"datatable\">\n" +
				"    <tr>\n" +
				"        <th class=\"teamname\">球队队名</th>\n" +
				"        <th>指数</th>\n" +
				"        <th class=\"spec long\">交易量</th>\n" +
				"        <th>比例</th>\n" +
				"        <th>赔付</th>\n" +
				"        <th>赔率</th>\n" +
				"        <th>挂牌指数</th>\n" +
				"        <th>欧洲平均</th>\n" +
				"        <th>凯利方差</th>\n" +
				"        <th class=\"spec long\">大小交易量</th>\n" +
				"        <th>比例</th>\n" +
				"        <th>大小价位</th>\n" +
				"        <th>大小指数</th>\n" +
				"    </tr>\n" +
				"    \n" +
				"    <tr>\n" +
				"        <td class=\"teamname\">斯旺西</td>\n" +
				"        <td>49</td>\n" +
				"        <td class=\"spec long\">1,067,002</td>\n" +
				"        <td>68%</td>\n" +
				"        <td>35</td>\n" +
				"        <td>2.08</td>\n" +
				"        <td>0.29%</td>\n" +
				"        <td>1.95</td>\n" +
				"        <td>18</td>\n" +
				"        <td class=\"spec long\">43,988</td>\n" +
				"        <td>38%</td>\n" +
				"        <td>2.16</td>\n" +
				"        <td>42</td>\n" +
				"    </tr>\n" +
				"    \n" +
				"    <tr>\n" +
				"        <td class=\"teamname\"></td>\n" +
				"        <td>14</td>\n" +
				"        <td class=\"spec long\">165,300</td>\n" +
				"        <td>11%</td>\n" +
				"        <td>-62</td>\n" +
				"        <td>3.55</td>\n" +
				"        <td>1.37%</td>\n" +
				"        <td>3.32</td>\n" +
				"        <td>16</td>\n" +
				"        <td class=\"spec long\"></td>\n" +
				"        <td></td>\n" +
				"        <td></td>\n" +
				"        <td></td>\n" +
				"    </tr>\n" +
				"    \n" +
				"    <tr>\n" +
				"        <td class=\"teamname\">布里斯托城</td>\n" +
				"        <td>37</td>\n" +
				"        <td class=\"spec long\">335,962</td>\n" +
				"        <td>21%</td>\n" +
				"        <td>0</td>\n" +
				"        <td>4.30</td>\n" +
				"        <td>0.51%</td>\n" +
				"        <td>3.81</td>\n" +
				"        <td>80</td>\n" +
				"        <td class=\"spec long\">70,272</td>\n" +
				"        <td>62%</td>\n" +
				"        <td>1.86</td>\n" +
				"        <td>58</td>\n" +
				"    </tr>\n" +
				"    \n" +
				"</table>\n" +
				"<ul class=\"dataline02\">\n" +
				"    <li class=\"cj\">交易量总成交：1,568,264</li>\n" +
				"    <li><a href=\"http://op1.sp1x2.net/Match/View/BetFair/208465726_62683_0_0_32014740\" title=\"标盘\" target=\"_blank\" class=\"noneleft\">标盘</a></li>\n" +
				"    <li><a href=\"http://op1.sp1x2.net/Match/View/BetFair/208465736_47973_0_0_32014740\" title=\"进球\" target=\"_blank\">进球</a></li>\n" +
				"    <li><a href=\"http://op1.sp1x2.net/Match/View/BetFair/208465683_62683_1_208465683_32014740\" title=\"亚盘\" target=\"_blank\">亚盘</a></li>\n" +
				"    <li><a href=\"http://op1.sp1x2.net/Match/View/BetFair/208465735_0_2_0_32014740\" title=\"正确比分\" target=\"_blank\">正确比分</a></li>\n" +
				"    \n" +
				"    <li class=\"dltime\"><p>更新时间：01.18 03:44:06</p></li>\n" +
				"</ul>\n" +
				"<div class=\"clear\"></div>v";
	}

	private static void testDemo() throws IOException {
		HtmlToPojoEngine htmlToPojoEngine = HtmlToPojoEngine.create();

		HtmlAdapter<Restaurant> adapter = htmlToPojoEngine.adapter(Restaurant.class);

		// If they were several restaurants in the same page,
		// you would need to create a parent POJO containing
		// a list of Restaurants as shown with the meals here
		Restaurant restaurant = adapter.fromHtml(getHtmlBody());
	}


	private static String getHtmlBody() throws IOException {
		//byte[] encoded = Files.readAllBytes(Paths.get(MY_HTML_FILE));
		/*return "<html>\n" +
				"    <head>\n" +
				"        <title>A Simple HTML Document</title>\n" +
				"    </head>\n" +
				"    <body>\n" +
				"        <div class=\"restaurant\">\n" +
				"            <h1>A la bonne Franquette</h1>\n" +
				"            <p>French cuisine restaurant for gourmet of fellow french people</p>\n" +
				"            <div class=\"location\">\n" +
				"                <p>in <span>London</span></p>\n" +
				"            </div>\n" +
				"            <p>Restaurant n*18,190. Ranked 113 out of 1,550 restaurants</p>  \n" +
				"            <div class=\"meals\">\n" +
				"                <div class=\"meal\">\n" +
				"                    <p>Veal Cutlet</p>\n" +
				"                    <p rating-color=\"green\">4.5/5 stars</p>\n" +
				"                    <p>Chef Mr. Frenchie</p>\n" +
				"                </div>\n" +
				"                \n" +
				"                <div class=\"meal\">\n" +
				"                    <p>Ratatouille</p>\n" +
				"                    <p rating-color=\"orange\">3.6/5 stars</p>\n" +
				"                    <p>Chef Mr. Frenchie and Mme. French-Cuisine</p>\n" +
				"                </div>\n" +
				"                \n" +
				"            </div> \n" +
				"        </div>    \n" +
				"    </body>\n" +
				"</html>\n";*/
		return


				"        <div class=\"restaurant\">\n" +
				"            <h1>A la bonne Franquette</h1>\n" +
				"            <p>French cuisine restaurant for gourmet of fellow french people</p>\n" +
				"            <div class=\"location\">\n" +
				"                <p>in <span>London</span></p>\n" +
				"            </div>\n" +
				"            <p>Restaurant n*18,190. Ranked 113 out of 1,550 restaurants</p>  \n" +
				"            <div class=\"meals\">\n" +
				"                <div class=\"meal\">\n" +
				"                    <p>Veal Cutlet</p>\n" +
				"                    <p rating-color=\"green\">4.5/5 stars</p>\n" +
				"                    <p>Chef Mr. Frenchie</p>\n" +
				"                </div>\n" +
				"                \n" +
				"                <div class=\"meal\">\n" +
				"                    <p>Ratatouille</p>\n" +
				"                    <p rating-color=\"orange\">3.6/5 stars</p>\n" +
				"                    <p>Chef Mr. Frenchie and Mme. French-Cuisine</p>\n" +
				"                </div>\n" +
				"                \n" +
				"            </div> \n" +
				"        </div>    \n" ;


	}
}
