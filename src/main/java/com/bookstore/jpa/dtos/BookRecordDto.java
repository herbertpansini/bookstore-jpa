package com.bookstore.jpa.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class BookRecordDto {
    @NotBlank
    String title;

    @NotNull
    UUID publisherId;

    @NotNull
    Set<UUID> authorIds = new HashSet<>();

    @NotBlank
    String reviewComment;
}