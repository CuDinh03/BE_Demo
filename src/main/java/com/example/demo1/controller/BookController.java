package com.example.demo1.controller;

import com.example.demo1.entity.Book;
import com.example.demo1.service.impl.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private IBookService service;

    @GetMapping
    public ResponseEntity<List<Book>> getAll(){
        List<Book> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book request){
        Book book1 = service.create(request);
        return ResponseEntity.ok(book1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable UUID id){
        Book book1 = service.findById(id);

        return ResponseEntity.ok(book1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable UUID id, @RequestBody Book request){
        Book book1 = service.update(request,id);
        if (book1 != null){
            return ResponseEntity.ok(book1);

        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.ok().build();

    }
}
