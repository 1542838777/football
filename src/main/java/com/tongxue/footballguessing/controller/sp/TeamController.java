package com.tongxue.footballguessing.controller.sp;


import com.tongxue.footballguessing.data.base.TeamDO;
import com.tongxue.footballguessing.data.dto.jsondto.fiveHundred.Msg;
import com.tongxue.footballguessing.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * (Business)表控制层
 *
 * @author 梁青松
 * @since 2021-10-18 15:40:12
 */
@RestController
@RequestMapping("/api/team")
public class TeamController {

	@Autowired
	private TeamRepository teamRepository;

	@GetMapping("/data/queryBycnName")
	public Msg<TeamDO> queryBycnName(
			@RequestParam(required = true) String cnName
	) {
		TeamDO teamDO = teamRepository.queryByCnName(cnName);

		return Msg.of(teamDO);
	}

}
