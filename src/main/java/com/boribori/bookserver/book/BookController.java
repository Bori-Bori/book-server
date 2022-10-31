package com.boribori.bookserver.book;

import com.boribori.bookserver.book.dto.request.RequestOfGetBooks;
import com.boribori.bookserver.common.Response;
import com.boribori.bookserver.external.SearchBookUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class BookController {

    private final BookService bookService;
    private final SearchBookUtil searchBookUtil;


    @GetMapping("/api/search/books")
    public Mono<ResponseEntity> searchBookList(RequestOfGetBooks requestOfGetBooks){

        return bookService.searchBooks(requestOfGetBooks)
                .map(response -> ResponseEntity.status(HttpStatus.OK)
                        .body(Response.builder()
                                .status(Response.Status.builder()
                                        .msg("성공적으로 조회되었습니다.")
                                        .build())
                                .content(response)
                                .build())).cast(ResponseEntity.class);
    }

    @GetMapping("/api/search/book")
    public Mono<ResponseEntity> searchBook(@RequestParam String isbn){
        return bookService.searchAndSaveBookByISBN(isbn)
                .map(response -> ResponseEntity.status(HttpStatus.OK)
                .body(Response.builder()
                        .status(Response.Status.builder()
                                .msg("성공적으로 조회되었습니다.")
                                .build())
                        .content(response)
                        .build())).cast(ResponseEntity.class);
    }

}
