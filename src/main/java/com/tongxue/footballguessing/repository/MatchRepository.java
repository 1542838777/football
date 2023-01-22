package com.tongxue.footballguessing.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tongxue.footballguessing.data.base.MatchDO;
import com.tongxue.footballguessing.data.base.TeamDO;
import com.tongxue.footballguessing.data.dto.jsondto.fiveHundred.MatchDTO;
import com.tongxue.footballguessing.persistence.team.TeamMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
@Configuration
public class MatchRepository extends ServiceImpl<TeamMapper,TeamDO> {
	@Value("${ifNotHaveThenInsert}")
	private String ifNotHaveThenInsert;

	@Resource
	private TeamMapper teamMapper;
	public TeamDO queryByCnName(String teamCnName) {
		List<TeamDO> list = this.list(new QueryWrapper<TeamDO>().eq(TeamDO.FILED_CN_NAME, teamCnName));
		if (CollectionUtils.isEmpty(list)) {
			if (Boolean.valueOf(ifNotHaveThenInsert)) {
				//写入一个那就
				baseMapper.insert(TeamDO.builder().cnName(teamCnName).build());
				return queryByCnName(teamCnName);
			}
			return null;
		}

		return list.get(0);
	}

	public TeamDO queryByEnName(String teamEnName) {
		List<TeamDO> list = this.list(new QueryWrapper<TeamDO>().eq(TeamDO.FILED_EN_NAME, teamEnName));
		if (CollectionUtils.isEmpty(list)) {
			if (Boolean.valueOf(ifNotHaveThenInsert)) {
				//写入一个那就
				baseMapper.insert(TeamDO.builder().enName(teamEnName).build());
				return queryByCnName(teamEnName);
			}
			return null;
		}

		return list.get(0);
	}

	/**
	 *
	 * @param matchDTO
	 */
	public MatchDO queryMatch(MatchDTO matchDTO) {
		if (matchDTO ==null) {
			return null;
		}
		/*this.list(new QueryWrapper<>()

				.eq(MatchDO.AWAY_TEAM_ID, ))*/
		return null;
	}
}
