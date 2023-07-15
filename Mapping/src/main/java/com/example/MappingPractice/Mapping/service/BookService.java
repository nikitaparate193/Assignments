package com.example.MappingPractice.Mapping.service;

import com.example.MappingPractice.Mapping.model.Book;
import com.example.MappingPractice.Mapping.repository.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    IBookRepo bookRepo;

    public void createBook(Book book) {
        bookRepo.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public String updateBookTitle(String bookId, String bookTitle) {
        Optional<Book> myBookOpt = bookRepo.findById(bookId);
        Book mybook = null;
        if(myBookOpt.isPresent()){
            mybook = myBookOpt.get();
        }else{
            return "BookId not found";
        }
        mybook.setBookTitle(bookTitle);
        bookRepo.save(mybook);
        return "Book Title updated";
    }

    public String deleteBook(String bookId) {
        bookRepo.deleteById(bookId);
        return "book deleted";
    }
}
