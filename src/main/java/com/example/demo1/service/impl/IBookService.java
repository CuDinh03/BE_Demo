package com.example.demo1.service.impl;

import com.example.demo1.entity.Book;

import java.util.List;
import java.util.UUID;

public interface IBookService {

    Book create(Book request);
    Book update(Book request, UUID id);

    List<Book> findAll();

    void delete(UUID uuid);

    Book findById(UUID id);
}
