package com.tongxue.footballguessing.data.dto.jsondto.fiveHundred;

import com.alibaba.fastjson.annotation.JSONField;
import com.tongxue.footballguessing.data.dto.jsondto.fiveHundred.sp.SpHadSPFDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
public class MatchDTO implements Serializable {
	/**
	 * fighting_day
	 */
	@JSONField(name = "date")
	private Date fightingDay;
	@JSONField(name = "matchnum")
	private String orderQueue;
	@JSONField(name = "away")
	private String awayTeamName;
	@JSONField(name = "home")
	private String homeTeamName;

	@JSONField(name = "league")
	private String leagueName;


	@JSONField(name = "dayofweek")
	String dayofweek;
	@JSONField(name = "id")
	String fiveHundredId;
	@JSONField(name = "row")
	List<SpHadSPFDTO> row;
}
