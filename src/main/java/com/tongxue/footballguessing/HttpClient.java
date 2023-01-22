package com.tongxue.footballguessing;

import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Request;

public interface HttpClient {

	@Get(url = "https://trade.500.com/static/public/jczq/newxml/pl/pl_nspf_2.xml")
	String spSPF();
	@Get(url = "https://www.500.com/static/public/jczq/xml/hisdata/2023/0103/odds.xml")
	String sp_odds();
	@Get(url = "biFA")
	String helloForest();

	@Get(url = "https://c.spdex.com/IFrame/IframeViewerQQ.aspx?id=32014740&_=1674002613451")
	String bf();
}
