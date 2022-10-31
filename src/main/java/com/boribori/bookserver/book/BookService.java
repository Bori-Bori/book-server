package com.boribori.bookserver.book;

import com.boribori.bookserver.book.dto.request.RequestOfGetBooks;
import com.boribori.bookserver.external.SearchBookUtil;
import com.boribori.bookserver.external.dto.ResponseOfSearchBook;
import com.boribori.bookserver.external.dto.ResponseOfSearchBooks;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

import static com.boribori.bookserver.external.dto.ResponseOfSearchBooks.*;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final SearchBookUtil searchBookUtil;

    public Mono<ResponseOfSearchBooks> searchBooks(RequestOfGetBooks requestOfGetBooks){
        return searchBookUtil.searchBooks(requestOfGetBooks);

    }

    public Mono<ResponseOfSearchBook> searchAndSaveBookByISBN(String isbn){
        return searchBookUtil.searchBookByISBN(isbn)
                .flatMap(item -> bookRepository.existsById(item.getItem().get(0).getIsbn13())
                         .flatMap(isExist -> {
                             if(isExist){
                                 return null;
                             }
                             Book bookEntity = Book.of(item);
                             bookRepository.save(bookEntity);
                             return Mono.just(item);
                         }));
    }

}
