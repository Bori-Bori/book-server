package com.boribori.bookserver.book;

import com.boribori.bookserver.book.dto.request.RequestOfGetBooks;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BookController {


    @GetMapping("/api/books")
    public void getBookList(RequestOfGetBooks requestOfGetBooks){
        System.out.println("dto = " + requestOfGetBooks.getTitle());
    }
}
