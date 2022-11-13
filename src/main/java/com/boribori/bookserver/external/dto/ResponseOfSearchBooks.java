package com.boribori.bookserver.external.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown =true)
public class ResponseOfSearchBooks {

    public List<Item> item;
    public int startIndex;
    public int itemsPerPage;
    public int totalResults;

    @Data
    @JsonIgnoreProperties(ignoreUnknown =true)
    public static class Item{
        private String title;
        private String author;
        private String pubDate;
        private String description;
        private String isbn13;
        private int priceStandard;
        private String cover;
        private String categoryName;
        private String publisher;
        private boolean adult;
    }
}
