package com.boribori.bookserver.book;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

public interface BookRepository extends ReactiveCassandraRepository<Book, String> {
}
