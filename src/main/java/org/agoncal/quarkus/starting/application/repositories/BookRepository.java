package org.agoncal.quarkus.starting.application.repositories;

import org.agoncal.quarkus.starting.domain.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    List<Book> getAll();

    Optional<Book> findById(int id);
}
