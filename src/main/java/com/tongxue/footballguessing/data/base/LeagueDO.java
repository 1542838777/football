package com.tongxue.footballguessing.data.base;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @description league 联赛
 * @author zhengkai.blog.csdn.net
 * @date 2023-01-03
 */
@Data
@TableName(value = "league")
@Builder
public class LeagueDO implements Serializable {
	public static  final String FILED_CN_NAME = "cnName";
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

	/**
	 * order
	 */
	private Integer order;

	public LeagueDO() {}
}