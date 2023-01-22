package com.tongxue.footballguessing.data.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description match
 * @author zhengkai.blog.csdn.net
 * 唯一 fightingDay  主队 客队
 * @date 2023-01-03
 */
@Data
@TableName(value = "match")

public class MatchDO implements Serializable {
	public static  final String  FIGHTING_DAY = "fighting_day";
	public static  final String  HOME_TEAM_ID = "home_team_id";
	public static  final String  AWAY_TEAM_ID = "away_team_id";

	private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	/**
	 * id
	 */
	private Long id;

	private String leagueName;

	/**
	 * fighting_day
	 */
	private Date fightingDay;

	/**
	 * order_queue
	 */
	private Integer orderQueue;

	/**
	 * home_team_id
	 */
	private Long homeTeamId;

	/**
	 * away_team_id
	 */
	private Long awayTeamId;

	/**
	 * day_of_week
	 */
	private String dayOfWeek;

	/**
	 * fivehundred_id
	 */
	private Long fiveHundredId;

	public MatchDO() {}
}