package com.bookstore.jpa.dtos;

import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookDto {
    @Id
    UUID id;
    String title;
    PublisherDto publisher;
    Set<AuthorDto> authors = new HashSet<>();
    ReviewDto review;
}