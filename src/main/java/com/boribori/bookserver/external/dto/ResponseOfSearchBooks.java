package com.boribori.bookserver.external.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown =true)
public class ResponseOfSearchBooks {

    public List<Item> item;
    public int startIndex;
    public int itemsPerPage;

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
