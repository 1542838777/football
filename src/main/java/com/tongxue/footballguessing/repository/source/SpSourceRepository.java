package com.tongxue.footballguessing.repository.source;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tongxue.footballguessing.data.base.sp.SpSourceDO;
import com.tongxue.footballguessing.persistence.sp.source.SpSourceMapper;
import org.springframework.stereotype.Service;

@Service
public class SpSourceRepository extends ServiceImpl<SpSourceMapper, SpSourceDO> {


	public Boolean insert(String name) {
		SpSourceDO spSourceDO = new SpSourceDO();
		spSourceDO.setSourceName(name);
		return baseMapper.insert(spSourceDO) == 1;
	}


}