package com.xunqi.common.annotation;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.annotation.AliasFor;

/**
 * @author chengyl
 * @since 2022-03-05 09:48:37
 */
@Cacheable
public @interface AddCash  {
    @AliasFor("self")
    String[] self() default {};
}
