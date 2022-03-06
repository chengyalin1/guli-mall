package com.xunqi.gulimall.product.controller;


import com.xunqi.common.miniomanager.MinioManager;
import com.xunqi.common.utils.PageUtils;
import com.xunqi.common.utils.R;
import com.xunqi.gulimall.product.entity.CategoryEntity;
import com.xunqi.gulimall.product.manager.CategoryManager;
import com.xunqi.gulimall.product.service.CategoryService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 商品三级分类
 *
 * @author chengyl
 * @email sunlightcs@gmail.com
 * @date 2022-02-24 17:45:16
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {

    private final CategoryService categoryService;

    private final CategoryManager categoryManager;

    private final MinioManager minioManager;

    public CategoryController(CategoryService categoryService,
                              CategoryManager categoryManager, MinioManager minioManager) {
        this.categoryService = categoryService;
        this.categoryManager = categoryManager;
        this.minioManager = minioManager;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = categoryService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 树形数据
     *
     * @return 数据
     */
    @RequestMapping("/list/tree")
    public R tree() {
        List<CategoryEntity> listWithTree = categoryService.listWithTree();
        return R.ok().put("data", listWithTree);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    public R info(@PathVariable("catId") Long catId) {
        CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @CacheEvict(value = "product")
    public R save(@RequestBody CategoryEntity category) {
        categoryService.save(category);

        return R.ok();
    }
    /**
     * 修改
     */
    @RequestMapping("/update/sort")
    @CacheEvict(value = "product")
    public R updateBatch(@RequestBody CategoryEntity[] category) {
        categoryService.updateBatchById(Arrays.asList(category));
//        categoryService.updateById(category);

        return R.ok();
    }
    /**
     * 修改
     */
    @RequestMapping("/update")
    @CacheEvict(value = "product",keyGenerator = "keyGenerator")
    public R update(@RequestBody CategoryEntity category) {
        categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @CacheEvict(value = "product",keyGenerator = "keyGenerator")
    public R delete(@RequestBody Long[] catIds) {
        categoryManager.removeByIds(Arrays.asList(catIds));

        return R.ok();
    }

    /**
     * 测试导入
     */
    @PostMapping("/import")
    public R imports(MultipartFile file) {
        R r = minioManager.uploadFiles(file, null);
        return R.ok().put("", r);
    }
}
