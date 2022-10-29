package com.boribori.bookserver.common;

import lombok.Builder;
import lombok.Data;

@Builder
public class Response<T> {
    private Status status;
    private T content;

    @Data
    public static class Status{
        private String message;
    }
}
