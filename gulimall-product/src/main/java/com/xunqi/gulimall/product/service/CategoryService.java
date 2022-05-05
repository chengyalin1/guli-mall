package com.xunqi.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xunqi.common.utils.PageUtils;
import com.xunqi.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author chengyl
 * @email sunlightcs@gmail.com
 * @date 2022-02-24 17:45:16
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 树形数据
     *
     * @return 数据
     */
    List<CategoryEntity> listWithTree();

    /**
     * 查询当前目录的完整路径
     *
     * @param catelogId 当前目录
     * @return 完整路径
     */
    Long[] findCateLogPath(Long catelogId);
}

