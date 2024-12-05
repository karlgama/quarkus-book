package org.agoncal.quarkus.starting.infra.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import org.agoncal.quarkus.starting.application.repositories.BookRepository;
import org.agoncal.quarkus.starting.domain.entities.Book;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepositoryImpl implements BookRepository {

    public List<Book> getAll() {
        return  List.of(
                new Book(1, "repo", "teste", 2014, "Terror")
        );
    }

    @Override
    public Optional<Book> findById(int id) {
        return getAll()
                .stream()
                .filter(book -> book.id() == id).findFirst();
    }
}
