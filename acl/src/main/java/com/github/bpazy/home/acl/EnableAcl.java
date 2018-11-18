package com.github.bpazy.home.acl;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(AclConfig.class)
public @interface EnableAcl {
}
