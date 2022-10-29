package com.boribori.bookserver.book.dto.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RequestOfGetBooks {

    private String title;
    private int start;
    private int maxResults;

}
