package com.bookstore.jpa.services;

import com.bookstore.jpa.dtos.BookDto;
import com.bookstore.jpa.dtos.BookRecordDto;
import com.bookstore.jpa.mappers.BookMapper;
import com.bookstore.jpa.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Transactional(readOnly = true)
    public List<BookDto> getAllBooks() {
        return this.bookRepository.findAll().stream().map(this.bookMapper::bookModelToBookDto).collect(Collectors.toList());
    }

    public BookDto saveBook(BookRecordDto bookRecordDto) {
        return this.bookMapper.bookModelToBookDto(this.bookRepository.save(this.bookMapper.bookRecordDtoToBookModel(bookRecordDto)));
    }

    public void deleteBook(UUID id) {
        this.bookRepository.deleteById(id);
    }
}