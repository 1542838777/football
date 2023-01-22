package com.tongxue.footballguessing.data.base.bf;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tongxue.footballguessing.data.BaseAttributes;
import fr.whimtrip.ext.jwhthtmltopojo.annotation.Selector;

@TableName(value = "sp_bf")
public class BfDO extends BaseAttributes {
	//比赛id
	private  Long matchId;
	//teamId
	private Long teamId;
	
	
	


	
	//必发指数--百分比 当时需要/100
	private  Long betIndex;


	
	//交易量 整数
	private Long tradeAmount;


	
	//比例--百分比 当时需要/100
	private Long percentage;


	
	//赔付
	private Long profit;


	
	//赔率 需要/100
	private Long odds;


	
	//挂牌指数--百分比 当时需要/100
	private Long hangOutIndex;

	
	//欧洲平均赔率
	private Long europeOdds ;

	
	//凯利方差
	private Long kelly;
}
