package com.tongxue.footballguessing.service.doService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tongxue.footballguessing.data.base.sp.SpWinDrawLostDO;
import com.tongxue.footballguessing.persistence.sp.SpSPFMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpSPFService extends ServiceImpl<SpSPFMapper, SpWinDrawLostDO> {

    public List<SpWinDrawLostDO> queryBroken(String customerName) {
        List<SpWinDrawLostDO> brokenPromises = baseMapper.listByCondition(customerName);
        return brokenPromises;
    }

    public List<SpWinDrawLostDO> insert() {
       return null;
    }


}