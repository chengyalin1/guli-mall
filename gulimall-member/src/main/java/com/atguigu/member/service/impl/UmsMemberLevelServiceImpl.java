package com.atguigu.member.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xunqi.common.utils.PageUtils;
import com.xunqi.common.utils.Query;

import com.atguigu.member.dao.UmsMemberLevelDao;
import com.atguigu.member.entity.UmsMemberLevelEntity;
import com.atguigu.member.service.UmsMemberLevelService;


@Service("umsMemberLevelService")
public class UmsMemberLevelServiceImpl extends ServiceImpl<UmsMemberLevelDao, UmsMemberLevelEntity> implements UmsMemberLevelService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsMemberLevelEntity> page = this.page(
                new Query<UmsMemberLevelEntity>().getPage(params),
                new QueryWrapper<UmsMemberLevelEntity>()
        );

        return new PageUtils(page);
    }

}