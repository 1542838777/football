package com.tongxue.footballguessing.service.save.SP;

import com.tongxue.footballguessing.data.base.TeamDO;
import com.tongxue.footballguessing.data.dto.jsondto.fiveHundred.MatchDTO;
import com.tongxue.footballguessing.repository.MatchRepository;
import com.tongxue.footballguessing.repository.TeamRepository;
import com.tongxue.footballguessing.service.getFromWeb.GetDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Configuration
public class SaveSPFService {
	@Value("ifNotHaveThenInsert")
	private String ifNotHaveThenInsert;
	@Autowired
	@Qualifier(value = "spSFPDataQueryHandlerImpl")
	private GetDataHandler getDataHandler;

	@Resource
	private TeamRepository teamRepository;
	@Resource
	private MatchRepository matchRepository;
	public Boolean save(){
		List<MatchDTO> matchDTOS = (List<MatchDTO>) getDataHandler.getData();
		for (MatchDTO matchDTO : matchDTOS) {
			String awayTeamName = matchDTO.getAwayTeamName();
			String homeTeamName = matchDTO.getHomeTeamName();

			TeamDO homeTeamDO  = teamRepository.queryByEnName(homeTeamName);
			TeamDO awayTeamDO  = teamRepository.queryByEnName(awayTeamName);
			//save match
			matchRepository.queryMatch(matchDTO);
			//
		}
		return null;//todo
	}
}
