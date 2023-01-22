package com.tongxue.footballguessing.service.doService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tongxue.footballguessing.data.base.sp.SpWinDrawLostDO;
import com.tongxue.footballguessing.persistence.sp.SpSPFMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpHadSPFService extends ServiceImpl<SpSPFMapper, SpWinDrawLostDO> {

    public List<SpWinDrawLostDO> queryBroken(String customerName) {
        List<SpWinDrawLostDO> brokenPromises = baseMapper.listByCondition(customerName);
        return brokenPromises;
    }


    public void deleteBrokenById(Long id) {
        baseMapper.deleteById(id);
    }

    @Scheduled(cron = "0 0 2 1 * ?")
    public void deleteBreak(){
        this.remove(new QueryWrapper<SpWinDrawLostDO>().ge("id", 1));
    }

    public SpWinDrawLostDO queryByCustomerId(Long customerId) {
        return this.getOne(new QueryWrapper<SpWinDrawLostDO>().eq("customer_id", customerId), false);
    }
}