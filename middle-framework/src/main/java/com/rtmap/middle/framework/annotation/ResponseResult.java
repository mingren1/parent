package com.rtmap.middle.framework.annotation;


import com.rtmap.middle.framework.model.Result;

import java.lang.annotation.*;

/**
 * 接口返回结果增强  会通过拦截器拦截后放入标记，在ResponseResultHandler 进行结果处理
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseResult {

    Class<? extends Result>  value() default Result.class;

}