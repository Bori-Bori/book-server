package com.boribori.bookserver.external.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseOfSearchBook {

    private List<Item> item;
    private SubInfo subInfo;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Item{
        private SubInfo subInfo;
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

    @Data
    @JsonIgnoreProperties(ignoreUnknown =true)
    public static class SubInfo{
        private int itemPage;
    }

}
