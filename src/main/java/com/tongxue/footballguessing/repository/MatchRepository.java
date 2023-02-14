package com.tongxue.footballguessing.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.tongxue.footballguessing.data.base.MatchDO;
import com.tongxue.footballguessing.data.base.TeamDO;
import com.tongxue.footballguessing.data.dto.jsondto.fiveHundred.MatchDTO;
import com.tongxue.footballguessing.persistence.team.TeamMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tongxue.footballguessing.persistence.match.MacthMapper;
import javax.annotation.Resource;
import java.util.List;

@Repository
@Configuration
public class MatchRepository extends  ServiceImpl<MacthMapper,MatchDO> {
	@Value("${ifNotHaveThenInsertWhenQuery}")
	private String ifNotHaveThenInsertWhenQuery;

	/**
	 *
	 * @param matchDTO
	 */
	public MatchDO queryMatch(MatchDTO matchDTO) {
		if (matchDTO ==null) {
			return null;
		}

		return null;
	}
}
