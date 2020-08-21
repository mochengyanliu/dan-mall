package com.dan.danauth.aop;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface EagleEye {
    /**
     * 接口描述
     * @return
     */
    String desc() default "";
}
