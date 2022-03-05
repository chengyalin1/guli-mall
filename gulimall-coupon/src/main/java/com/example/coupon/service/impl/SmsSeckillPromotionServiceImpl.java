package com.example.coupon.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xunqi.common.utils.PageUtils;
import com.xunqi.common.utils.Query;

import com.example.coupon.dao.SmsSeckillPromotionDao;
import com.example.coupon.entity.SmsSeckillPromotionEntity;
import com.example.coupon.service.SmsSeckillPromotionService;


@Service("smsSeckillPromotionService")
public class SmsSeckillPromotionServiceImpl extends ServiceImpl<SmsSeckillPromotionDao, SmsSeckillPromotionEntity> implements SmsSeckillPromotionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsSeckillPromotionEntity> page = this.page(
                new Query<SmsSeckillPromotionEntity>().getPage(params),
                new QueryWrapper<SmsSeckillPromotionEntity>()
        );

        return new PageUtils(page);
    }

}