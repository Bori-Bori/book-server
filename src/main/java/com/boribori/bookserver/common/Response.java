package com.boribori.bookserver.common;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Getter
public class Response<T> {
    private Status status;
    private T content;

    @Builder
    @Getter
    public static class Status{
        private String msg;
    }
}
