package com.tongxue.footballguessing.data.dto.jsondto.fiveHundred;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class simple  implements Serializable {
	private Date date;
	@JSONField(name ="matchNum")
	private String matchNummm;
}
