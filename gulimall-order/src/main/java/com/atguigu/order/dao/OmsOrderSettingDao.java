package com.atguigu.order.dao;

import com.atguigu.order.entity.OmsOrderSettingEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单配置信息
 * 
 * @author chengyl
 * @email sunlightcs@gmail.com
 * @date 2022-02-25 10:19:59
 */
@Mapper
public interface OmsOrderSettingDao extends BaseMapper<OmsOrderSettingEntity> {
	
}
