package com.github.bpazy.home.acl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Acl {
    String[] roles() default {};

    Login login() default Login.Login;

    enum Login {
        /**
         * 需要登录访问
         */
        Login,
        /**
         * 可匿名访问
         */
        Anon,
    }
}
