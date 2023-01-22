package com.tongxue.footballguessing.data.base.sp;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tongxue.footballguessing.data.BaseAttributes;
import lombok.Data;

@Data
@TableName(value = "sp_big_small")
public class BigSmallDO  extends BaseAttributes {
	//比赛id
	private  Long matchId;
	//teamId
	private Long teamId;


	//大小交易量 钱
	private  Long bigSmallTradeAmount;


	//大小比例 需要/100
	private Long bigSmallPercentage;


	//大小价位 可能是赔率？ 需要/100
	private Long bigSmallOdds;


	//大小指数
	private Long bigSmallIndex;
}
