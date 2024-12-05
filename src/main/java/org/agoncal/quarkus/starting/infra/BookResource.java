package org.agoncal.quarkus.starting.infra;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.agoncal.quarkus.starting.application.repositories.BookRepository;
import org.agoncal.quarkus.starting.domain.entities.Book;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Optional;


@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class BookResource {
    @Inject
    private final BookRepository repository;

    @Inject
    private final Logger logger;


    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAll() {
        logger.info("Getting all books");
        return repository.getAll();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks() {
        return repository.getAll().size();
    }

    @GET
    @Path("{id}")
    public Optional<Book> getBook(@PathParam("id") int id) {
        return repository.findById(id);
    }
}
