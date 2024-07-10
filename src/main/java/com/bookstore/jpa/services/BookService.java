package com.bookstore.jpa.services;

import com.bookstore.jpa.dtos.BookDto;
import com.bookstore.jpa.dtos.BookRecordDto;
import com.bookstore.jpa.mappers.BookMapper;
import com.bookstore.jpa.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Transactional(readOnly = true)
    public Page<BookDto> getAllBooks(Pageable pageable) {
        return this.bookRepository.findAll(pageable).map(this.bookMapper::bookModelToBookDto);
    }

    public BookDto saveBook(BookRecordDto bookRecordDto) {
        return this.bookMapper.bookModelToBookDto(this.bookRepository.save(this.bookMapper.bookRecordDtoToBookModel(bookRecordDto)));
    }

    public void deleteBook(UUID id) {
        this.bookRepository.deleteById(id);
    }
}