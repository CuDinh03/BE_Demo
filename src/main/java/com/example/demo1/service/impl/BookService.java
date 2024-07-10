package com.example.demo1.service.impl;

import com.example.demo1.entity.Book;
import com.example.demo1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService implements IBookService{

    @Autowired
    private BookRepository repository;
    @Override
    public Book create(Book request) {
        return repository.save(request);
    }

    @Override
    public Book update(Book request, UUID uuid) {
        return repository.save(request);
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(UUID uuid) {
        repository.deleteById(uuid);
    }

    @Override
    public Book findById(UUID id) {
        return repository.findById(id).get();
    }
}
