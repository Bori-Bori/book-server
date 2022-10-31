package com.boribori.bookserver.external;

import com.boribori.bookserver.book.dto.request.RequestOfGetBooks;
import com.boribori.bookserver.external.dto.ResponseOfSearchBook;
import com.boribori.bookserver.external.dto.ResponseOfSearchBooks;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;


@Component
public class SearchBookUtil {

    private WebClient webClient;

    @PostConstruct
    public void setup(){
        this.webClient = WebClient.builder().baseUrl("http://www.aladin.co.kr").build();
    }

    public Mono<ResponseOfSearchBooks> searchBooks(RequestOfGetBooks requestOfGetBooks){
        ObjectMapper om = new ObjectMapper();
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("QueryType", requestOfGetBooks.getQueryType());
        queryParams.add("Cover", requestOfGetBooks.getCover());
        queryParams.add("start", String.valueOf(requestOfGetBooks.getStart()));
        queryParams.add("maxResults", String.valueOf(requestOfGetBooks.getMaxResults()));
        queryParams.add("query", requestOfGetBooks.getQuery());
        queryParams.add("output", requestOfGetBooks.getOutput());
        queryParams.add("TTBKey", "ttbckdudgh87801747001");

        return webClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/ttb/api/ItemSearch.aspx")
                                .queryParams(queryParams)
                                .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(v -> {
                    try {
                        return Mono.just(om.readValue(v, ResponseOfSearchBooks.class));
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    public Mono<ResponseOfSearchBook> searchBookByISBN(String isbn){
        ObjectMapper om = new ObjectMapper();
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("Version", "20131101");
        queryParams.add("itemIdType", "ISBN13");
        queryParams.add("itemId", isbn);
        queryParams.add("TTBKey", "ttbckdudgh87801747001");
        queryParams.add("output", "js");

        return webClient
                .get()
                .uri(uriBuilder ->
                    uriBuilder.path("/ttb/api/ItemLookUp.aspx")
                            .queryParams(queryParams)
                            .build()
                )
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(v -> v.bodyToMono(String.class))
                .flatMap(v ->{
                    try {
                        return Mono.just(om.readValue(v, ResponseOfSearchBook.class));
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

}
