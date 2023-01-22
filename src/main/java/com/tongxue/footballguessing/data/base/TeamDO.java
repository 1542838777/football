package com.tongxue.footballguessing.data.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "team")
@Builder
@AllArgsConstructor
public class TeamDO implements Serializable {
	public static final String FILED_CN_NAME = "cn_name";
	public static final String FILED_EN_NAME = "en_name";
	private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	/**
	 * id
	 */
	private Long id;

	/**
	 * cn_name
	 */
	private String cnName;

	/**
	 * en_name
	 */
	private String enName;

	public TeamDO() {
	}
}