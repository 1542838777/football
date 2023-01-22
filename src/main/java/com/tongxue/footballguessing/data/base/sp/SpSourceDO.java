package com.tongxue.footballguessing.data.base.sp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhengkai.blog.csdn.net
 * @description win_draw_lost
 * @date 2023-01-03
 */
@Data
@TableName(value = "sp_source")
public class SpSourceDO implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	/**
	 * id
	 */
	private Long id;

	/**
	 * spSource
	 */
	private String sourceName;
}