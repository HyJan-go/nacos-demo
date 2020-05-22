package com.alibaba.nacosuserservice.entity;

import lombok.Data;

/**
 * @program: demo
 * @description: 结果返回类
 * @author: HyJan
 * @create: 2020-05-21 17:09
 **/
@Data
public class Result {

    private Integer code;
    private String msg;
    private Object data;

    private static final Integer SUCCESS_CODE = 200;
    private static final Integer ERROR_CODE = 500;
    private static final String SUCCESS_MSG = "操作成功";
    private static final String ERROR_MSG = "操作失败";

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    private Result(Object data) {
        this.code = SUCCESS_CODE;
        this.msg = SUCCESS_MSG;
        this.data = data;
    }

    public static Result success() {
        return new Result(null);
    }

    public static Result success(Object obj) {
        return new Result(obj);
    }

    public static Result error() {
        return new Result(ERROR_CODE, ERROR_MSG, null);
    }

    public static Result error(Integer code, String msg) {
        return new Result(code, msg);
    }

    public static Result error(String msg) {
        return new Result(ERROR_CODE, msg);
    }
}
