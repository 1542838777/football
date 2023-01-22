package com.tongxue.footballguessing.data.dto.jsondto.fiveHundred.sp;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public class SpSPFDTO implements Serializable {
	@JSONField(name = "d")
	private Integer baseOnLastDrawSp;
	@JSONField(name = "w")
	private Integer baseOnLastWinSp;
	@JSONField(name = "l")
	private Integer baseOnLastLostSp;
	@JSONField(name ="lost")
	private  Integer lostSp;
	@JSONField(name ="draw")
	private  Integer drawSp;
	@JSONField(name ="win")
	private  Integer winSp;
	@JSONField(name ="updatetime")
	private Date updatetime;

	private Long matchId;


	/**
	 * update_date
	 */
	private Date updateDate;



	/**
	 * 初次赔率
	 */
	private int belongFirstSp;

}
