package com.xunqi.gulimall.product.manager.impl;

import cn.hutool.core.collection.CollUtil;
import com.xunqi.gulimall.product.manager.CategoryManager;
import com.xunqi.gulimall.product.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chengyl
 * @since 2022-02-26 22:03:44
 */
@Service
public class CategoryManagerImpl implements CategoryManager {

    private final CategoryService categoryService;

    public CategoryManagerImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void removeByIds(List<Long> ids) {
        if (CollUtil.isEmpty(ids)){
            return;
        }
        // todo

        categoryService.removeByIds(ids);
    }
}
