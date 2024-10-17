package com.cwlee.springsecurity.controller.response;

public record ResultResponse<T>(
        boolean success,
        String code,
        String message,
        T data
) {
    public static final String CODE_SUCCESS = "success";
    public static final String CODE_FAILED = "FAILED";

    public static <T> ResultResponse<T> ok(T data) {
        return new ResultResponse<>(true, CODE_SUCCESS, null, data);
    }

    public static <T> ResultResponse<T> fail(String message) {
        return new ResultResponse<>(false, CODE_FAILED, message, null);
    }
}
