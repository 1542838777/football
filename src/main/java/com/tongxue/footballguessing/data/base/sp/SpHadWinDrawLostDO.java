package com.tongxue.footballguessing.data.base.sp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description win_draw_lost
 * @author zhengkai.blog.csdn.net
 * @date 2023-01-03
 */
@Data
@TableName(value = "sp_had_win_draw_lost")

public class SpHadWinDrawLostDO implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	/**
	 * id
	 */
	private Long id;

	/**
	 * match_id
	 */
	private Long matchId;

	/**
	 * win_sp
	 */
	private Integer winSp;

	/**
	 * draw_sp
	 */
	private Integer drawSp;

	/**
	 * lost_sp
	 */
	private Integer lostSp;

	/**
	 * update_date
	 */
	private Date updateDate;

	/**
	 * 1：表示基于上次 涨了
	 */
	private Integer baseOnLastWinSp;

	/**
	 * base_on_last_draw_sp
	 */
	private Integer baseOnLastDrawSp;

	/**
	 * base_on_last_lost_sp
	 */
	private Integer baseOnLastLostSp;

	/**
	 * 初次赔率
	 */
	private int belongFirstSp;

	private  Integer homeHadAwayNum;
	/**
	 * 赔率来源
	 */
	private Long spSourceId;

}