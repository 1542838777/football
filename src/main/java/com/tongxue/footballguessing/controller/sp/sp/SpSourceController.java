package com.tongxue.footballguessing.controller.sp.sp;


import com.tongxue.footballguessing.data.dto.jsondto.fiveHundred.Msg;
import com.tongxue.footballguessing.repository.source.SpSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (Business)表控制层
 *
 * @author 梁青松
 * @since 2021-10-18 15:40:12
 */
@RestController
@RequestMapping("/api/sp/source")
public class SpSourceController {

	@Autowired
	private SpSourceRepository spSourceRepository;




	@GetMapping("/data/insert")
	public Msg<Boolean> insert(
			@RequestParam(required = true) String sourceName
	) {
		Boolean insert = spSourceRepository.insert(sourceName);
		return Msg.of(insert);
	}

}
