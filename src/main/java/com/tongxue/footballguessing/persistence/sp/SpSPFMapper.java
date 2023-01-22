package com.tongxue.footballguessing.persistence.sp;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tongxue.footballguessing.data.base.sp.SpWinDrawLostDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BrokenPromise)表Mapper接口
 *
 * @author 梁青松
 * @since 2021-10-27 14:10:00
 */
public interface SpSPFMapper extends BaseMapper<SpWinDrawLostDO> {
    List<SpWinDrawLostDO> listByCondition(@Param("customerName") String customerName);
}