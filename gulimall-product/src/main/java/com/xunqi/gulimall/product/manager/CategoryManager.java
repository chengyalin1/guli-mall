package com.xunqi.gulimall.product.manager;

import java.util.List;

/**
 * @author chengyl
 * @since 2022-02-26 22:02:40
 */
public interface CategoryManager {
    /**
     * 批量删除
     *
     * @param singletonList
     */
    void removeByIds(List<Long> singletonList);
}
