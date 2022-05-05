package com.xunqi.gulimall.product;

import cn.hutool.json.JSONUtil;
import com.xunqi.gulimall.product.dao.AttrGroupDao;
import com.xunqi.gulimall.product.dao.SkuSaleAttrValueDao;
import com.xunqi.gulimall.product.entity.BrandEntity;
import com.xunqi.common.feign.CouponFeignService;
import com.xunqi.gulimall.product.service.BrandService;
import com.xunqi.gulimall.product.service.CategoryService;
import io.micrometer.core.instrument.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallProductApplicationTests {

    @Resource
    private BrandService brandService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @Resource
    private AttrGroupDao attrGroupDao;

    @Resource
    private SkuSaleAttrValueDao skuSaleAttrValueDao;


    @Autowired
    private CouponFeignService couponFeignService;

    @Test
    public void contextLoads() {
        BrandEntity entity = new BrandEntity();
        entity.setBrandId(0L);
        entity.setName("测试");
        entity.setLogo("78ytg8");
        entity.setDescript("测试数据");
        entity.setShowStatus(0);
        entity.setFirstLetter("i");
        entity.setSort(0);
        brandService.save(entity);

        BrandEntity brandEntity = brandService.getById(1);
        System.out.println(brandEntity.toString());


        Long[] id = {123L};
        couponFeignService.delete(id);
    }
    @Test
    public void test() {
        Long[] cateLogPath = categoryService.findCateLogPath(225L);
        System.out.println(cateLogPath.toString());
    }
}
