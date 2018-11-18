package com.github.bpazy.home.common;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(CommonConfig.class)
public @interface EnableCommon {
}
