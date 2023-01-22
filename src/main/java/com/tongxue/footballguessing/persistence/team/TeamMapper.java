package com.tongxue.footballguessing.persistence.team;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tongxue.footballguessing.data.base.TeamDO;

/**
 * (BrokenPromise)表Mapper接口
 *
 * @author 梁青松
 * @since 2021-10-27 14:10:00
 */
public interface TeamMapper extends BaseMapper<TeamDO> {
    TeamDO getByName(String teamName);
}