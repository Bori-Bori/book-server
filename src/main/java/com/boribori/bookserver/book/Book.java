package com.boribori.bookserver.book;

import com.boribori.bookserver.external.dto.ResponseOfSearchBook;
import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Getter
@ToString
@NoArgsConstructor
@Table("book")
public class Book {

    //ISBN
    @PrimaryKey()
    private String isbn;

    //제목
    private String title;

    //저자
    private String author;

    //책 설명
    private String description;

    //로고
    private String imagePath;

    //소비자 가격
    private int price;

    //출판사
    private String publisher;

    //페이지 수
    private int page;

    //출간일
    private LocalDate pubDate;

    //성인여부
    private boolean adult;

    @Builder(access = AccessLevel.PRIVATE)
    private Book(String isbn, String title, String author, String description,
                 String imagePath, int price, String publisher,
                 int page, LocalDate pubDate, boolean adult){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.description = description;
        this.imagePath = imagePath;
        this.price = price;
        this.publisher = publisher;
        this.page = page;
        this.pubDate = pubDate;
        this.adult = adult;

    }

    public static Book of(ResponseOfSearchBook response){
        return Book.builder()
                .title(response.getItem().get(0).getTitle())
                .author(response.getItem().get(0).getAuthor())
                .description(response.getItem().get(0).getDescription())
                .imagePath(response.getItem().get(0).getCover())
                .isbn(response.getItem().get(0).getIsbn13())
                .page(response.getItem().get(0).getSubInfo().getItemPage())
                .publisher(response.getItem().get(0).getPublisher())
                .price(response.getItem().get(0).getPriceStandard())
                .adult(response.getItem().get(0).isAdult())
                .pubDate(LocalDate.parse(response.getItem().get(0).getPubDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .build();
    }



}
