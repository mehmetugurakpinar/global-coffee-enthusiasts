package com.globalcoffeeenthusiasts.common.rest;

import lombok.Getter;

@Getter
public class Response<T> {

    private final T data;
    private ErrorResponse errors;

    public static <T> Response<T> ok(T data) {
        return new Response<>(data);
    }

    public Response(T data) {
        this.data = data;
    }

}