package com.github.bpazy.home.acl;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Slf4j
public class AclInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest r, HttpServletResponse response, Object h) throws Exception {
        if (r.getServletPath().startsWith("/error")) {
            return true;
        }

        if (!(h instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) h;
        if (handlerMethod.getMethod().getDeclaringClass() == BasicErrorController.class) {
            return true;
        }

        if ("true".equals(r.getHeader("innerApi"))) {
            return true;
        }

        Acl acl = handlerMethod.getMethod().getAnnotation(Acl.class);
        if (acl == null) throw new AclException("未配置权限");
        if (acl.login() == Acl.Login.Anon) return true;
        if (acl.login() == Acl.Login.Login && !AclContext.isLogined()) throw new AclException("未登录");

        ArrayList<String> roles = Lists.newArrayList(acl.roles());
        return roles.contains("管理员");
    }
}
