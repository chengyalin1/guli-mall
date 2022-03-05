package com.atguigu.member.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xunqi.common.utils.PageUtils;
import com.xunqi.common.utils.Query;

import com.atguigu.member.dao.UmsIntegrationChangeHistoryDao;
import com.atguigu.member.entity.UmsIntegrationChangeHistoryEntity;
import com.atguigu.member.service.UmsIntegrationChangeHistoryService;


@Service("umsIntegrationChangeHistoryService")
public class UmsIntegrationChangeHistoryServiceImpl extends ServiceImpl<UmsIntegrationChangeHistoryDao, UmsIntegrationChangeHistoryEntity> implements UmsIntegrationChangeHistoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsIntegrationChangeHistoryEntity> page = this.page(
                new Query<UmsIntegrationChangeHistoryEntity>().getPage(params),
                new QueryWrapper<UmsIntegrationChangeHistoryEntity>()
        );

        return new PageUtils(page);
    }

}