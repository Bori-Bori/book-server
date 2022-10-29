package com.boribori.bookserver.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table("table")
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
    private Long price;

    //출판사
    private String publisher;

    //페이지 수
    private int page;

    //출간일
    private LocalDateTime pubDate;

    //성인여부
    private boolean adult;


}
