package com.boribori.bookserver.book.dto.request;

import lombok.*;


@Data
public class RequestOfGetBooks {

    private String query = "황제";
    private int start = 1;
    private int maxResults = 5;
    private String queryType = "Keyword"; //Keyword, Title, Author, Publisher

    private String cover = "Big";

    private String output = "js";


}
