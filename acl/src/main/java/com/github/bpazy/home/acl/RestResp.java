package com.github.bpazy.home.acl;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestResp {
    private int code;
    private String msg;
    private Object data;

    public static RestResp fail(String msg) {
        return RestResp.builder().code(-1).msg(msg).build();
    }
}
