package com.github.bpazy.home.acl;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestControllerAdvice
public class AclExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AclException.class)
    public RestResp aclException(HttpServletRequest req, HttpServletResponse res, AclException e) {
        res.setStatus(419);
        log.info("权限异常: {}", e.getMessage());
        return RestResp.fail("权限异常" + e.getMessage());
    }

    @ExceptionHandler({Throwable.class})
    public RestResp handleThrowable(HttpServletRequest req, HttpServletResponse res, Throwable e) {
        log.error("系统异常: {}", Throwables.getStackTraceAsString(e));
        res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return RestResp.fail(StringUtils.isEmpty(e.getMessage()) ? e.getClass().getName() : e.getMessage());
    }
}
