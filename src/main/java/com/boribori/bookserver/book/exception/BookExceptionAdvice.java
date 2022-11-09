package com.boribori.bookserver.book.exception;

import com.boribori.bookserver.common.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class BookExceptionAdvice {

    @ExceptionHandler(NotFoundBookException.class)
    public Mono<ResponseEntity<Response>> handleNotFoundBookException(){
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(Response.builder()
                .content(null)
                .status(Response.Status.builder()
                        .msg("해당하는 책을 찾을 수 없습니다.").build())
                .build()
        ));
    }
}
