package com.boribori.bookserver.book.dto.request;

import lombok.*;


@Data
@Builder
public class RequestOfGetBooks {

    private String query;

    @Builder.Default
    private int start = 1;

    @Builder.Default
    private int maxResults = 5;
    private String queryType; //Keyword, Title, Author, Publisher

    @Builder.Default
    private String cover = "Big";

    @Builder.Default
    private String output = "js";


}
