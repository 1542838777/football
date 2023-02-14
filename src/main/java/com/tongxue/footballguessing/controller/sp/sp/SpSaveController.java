package com.tongxue.footballguessing.controller.sp.sp;

import com.tongxue.footballguessing.data.dto.jsondto.fiveHundred.Msg;
import com.tongxue.footballguessing.service.save.SP.SaveSPFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sp/save")
public class SpSaveController {
	@Autowired
	private SaveSPFService saveSPFService;
	@GetMapping("/SPF")
	public Msg<Boolean> saveSPF(){
		saveSPFService.save();
		return null;
	}
}
