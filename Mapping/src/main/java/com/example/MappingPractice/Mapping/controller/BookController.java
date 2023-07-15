package com.example.MappingPractice.Mapping.controller;

import com.example.MappingPractice.Mapping.model.Book;
import com.example.MappingPractice.Mapping.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("book")
    public void createBook(@Valid @RequestBody Book book){
        bookService.createBook(book);
    }

    @GetMapping("books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PutMapping("book/{bookId}/{bookTitle}")
    public String updateBookTitle(@PathVariable String bookId, @PathVariable String bookTitle){
        return bookService.updateBookTitle(bookId,bookTitle);
    }

    @DeleteMapping("book/{bookId}")
    public String deleteBook(@PathVariable String bookId){
        return bookService.deleteBook(bookId);
    }
}
