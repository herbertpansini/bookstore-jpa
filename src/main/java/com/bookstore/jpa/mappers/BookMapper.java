package com.bookstore.jpa.mappers;

import com.bookstore.jpa.dtos.BookDto;
import com.bookstore.jpa.dtos.BookRecordDto;
import com.bookstore.jpa.models.AuthorModel;
import com.bookstore.jpa.models.BookModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(source = "title", target = "title")
    @Mapping(source = "publisherId", target = "publisher.id")
    @Mapping(source = "reviewComment", target = "review.comment")
    BookModel bookRecordDtoToBookModel(BookRecordDto bookRecordDto);

    BookDto bookModelToBookDto(BookModel bookModel);

    @AfterMapping
    default void bookModelTo(BookRecordDto bookRecordDto, @MappingTarget BookModel bookModel) {
        bookRecordDto.getAuthorIds().forEach(authorId -> bookModel.getAuthors().add(AuthorModel.builder().id(authorId).build()));
    }
}