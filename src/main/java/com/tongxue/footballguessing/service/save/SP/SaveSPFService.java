package com.tongxue.footballguessing.service.save.SP;

import com.tongxue.footballguessing.data.base.TeamDO;
import com.tongxue.footballguessing.data.dto.jsondto.fiveHundred.MatchDTO;
import com.tongxue.footballguessing.repository.LeagueRepository;
import com.tongxue.footballguessing.repository.MatchRepository;
import com.tongxue.footballguessing.repository.TeamRepository;
import com.tongxue.footballguessing.service.getFromWeb.GetDataHandler;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Service
@Configuration
@Slf4j
public class SaveSPFService {
	@Value("ifNotHaveThenInsertWhenQuery")
	private String ifNotHaveThenInsertWhenQuery;
	@Autowired
	@Qualifier(value = "spSFPChangeDataQueryHandlerImpl")
	private GetDataHandler getDataHandler;

	@Resource
	private TeamRepository teamRepository;
	@Resource
	private MatchRepository matchRepository;
	@Resource
	private LeagueRepository leagueRepository;
	@SneakyThrows
	public Boolean save(){
		List<MatchDTO> matchDTOS = (List<MatchDTO>) getDataHandler.getData();
		log.info("matchDTOS >>>{}",matchDTOS);
		for (MatchDTO matchDTO : matchDTOS) {
			String awayTeamName = matchDTO.getAwayTeamName();
			String homeTeamName = matchDTO.getHomeTeamName();

			TeamDO homeTeamDO  = teamRepository.queryByCnName(homeTeamName);
			TeamDO awayTeamDO  = teamRepository.queryByCnName(awayTeamName);
			//save  langguege
			leagueRepository.queryByCnName(matchDTO.getLeagueName());
			//save match
			//matchRepository.sa()
			matchRepository.queryMatch(matchDTO);
			//
		}
		return null;//todo
	}
}
