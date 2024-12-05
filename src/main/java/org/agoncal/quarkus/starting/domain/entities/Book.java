package org.agoncal.quarkus.starting.domain.entities;

public record Book(
        int id,
        String title,
        String author,
        int yearOfPublication,
        String genre
) {
}
