package com.atguigu.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xunqi.common.utils.PageUtils;
import com.atguigu.order.entity.OmsOrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author chengyl
 * @email sunlightcs@gmail.com
 * @date 2022-02-25 10:19:59
 */
public interface OmsOrderService extends IService<OmsOrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

