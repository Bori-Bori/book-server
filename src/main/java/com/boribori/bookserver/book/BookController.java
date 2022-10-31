package com.boribori.bookserver.book;

import com.boribori.bookserver.book.dto.request.RequestOfGetBooks;
import com.boribori.bookserver.external.SearchBookUtil;
import com.boribori.bookserver.external.dto.ResponseOfSearchBooks;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class BookController {

    private final BookService bookService;
    private final SearchBookUtil searchBookUtil;

    @GetMapping("/api/books")
    public void getBookList(RequestOfGetBooks requestOfGetBooks){

    }

    @GetMapping("/api/search/books")
    public Mono<ResponseOfSearchBooks> searchBookList(RequestOfGetBooks requestOfGetBooks){
        return bookService.searchBooks(requestOfGetBooks);
    }

    @GetMapping("/api/search/book")
    public Mono<ResponseEntity> searchBook(@RequestParam String isbn){
        return bookService.searchAndSaveBookByISBN(isbn)
                .flatMap(response -> {
                    return null;
                });
    }

}
