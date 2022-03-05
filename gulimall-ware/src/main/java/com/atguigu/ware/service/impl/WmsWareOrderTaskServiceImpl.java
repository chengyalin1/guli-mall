package com.atguigu.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xunqi.common.utils.PageUtils;

import com.xunqi.common.utils.Query;

import com.atguigu.ware.dao.WmsWareOrderTaskDao;
import com.atguigu.ware.entity.WmsWareOrderTaskEntity;
import com.atguigu.ware.service.WmsWareOrderTaskService;


@Service("wmsWareOrderTaskService")
public class WmsWareOrderTaskServiceImpl extends ServiceImpl<WmsWareOrderTaskDao, WmsWareOrderTaskEntity> implements WmsWareOrderTaskService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WmsWareOrderTaskEntity> page = this.page(
                new Query<WmsWareOrderTaskEntity>().getPage(params),
                new QueryWrapper<WmsWareOrderTaskEntity>()
        );

        return new PageUtils(page);
    }

}