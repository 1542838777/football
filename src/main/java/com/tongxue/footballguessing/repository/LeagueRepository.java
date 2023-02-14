package com.tongxue.footballguessing.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tongxue.footballguessing.data.base.LeagueDO;
import com.tongxue.footballguessing.data.base.MatchDO;
import com.tongxue.footballguessing.data.base.TeamDO;
import com.tongxue.footballguessing.data.dto.jsondto.fiveHundred.MatchDTO;
import com.tongxue.footballguessing.exception.CommErrorCode;
import com.tongxue.footballguessing.exception.DBException;
import com.tongxue.footballguessing.persistence.league.LeagueMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
@Configuration
public class LeagueRepository extends  ServiceImpl<LeagueMapper, LeagueDO> {
	@Value("${ifNotHaveThenInsertWhenQuery}")
	private String ifNotHaveThenInsertWhenQuery;



	public LeagueDO queryByCnName(String leagueName) throws DBException {
		List<LeagueDO> result = this.list(
				new QueryWrapper<LeagueDO>()
						.eq(LeagueDO.FILED_CN_NAME, leagueName));
		if (!CollectionUtils.isEmpty(result)) {
			if (result.size()>1){
				throw new DBException(CommErrorCode.DB_SHOULD_ONE_BUT_FOUND_MORE.getErrorMsg());
			}
			return  result.get(0);
		}
		if (Boolean.TRUE.equals(ifNotHaveThenInsertWhenQuery)){
			//save
			int insert = baseMapper.insert(LeagueDO.builder().cnName(leagueName).build());
			return queryByCnName(leagueName);
		}
		return null;

	}
}
