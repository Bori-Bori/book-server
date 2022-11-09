package com.boribori.bookserver.book;

import com.boribori.bookserver.book.dto.request.RequestOfGetBooks;
import com.boribori.bookserver.book.exception.NotFoundBookException;
import com.boribori.bookserver.external.SearchBookUtil;
import com.boribori.bookserver.external.dto.ResponseOfSearchBooks;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final SearchBookUtil searchBookUtil;

    public Mono<ResponseOfSearchBooks> searchBooks(RequestOfGetBooks requestOfGetBooks){
        return searchBookUtil.searchBooks(requestOfGetBooks);

    }

    public Mono<Book> searchAndSaveBookByISBN(String isbn){
        return searchBookUtil.searchBookByISBN(isbn)
                .flatMap(item -> {
                    if(item.getItem() == null){
                        throw new NotFoundBookException();
                    }

                    return bookRepository.existsById(item.getItem().get(0).getIsbn13())
                            .flatMap(isExist -> {
                                if(isExist){
                                    return bookRepository.findById(item.getItem().get(0).getIsbn13());
                                }
                                return bookRepository.save(Book.of(item));
                            });
                });
    }

}
