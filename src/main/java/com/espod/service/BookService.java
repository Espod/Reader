package com.espod.service;

import com.espod.entity.Book;
import com.espod.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findByBookName(String bookName) {
        return bookRepository.findByBookName(bookName);
    }

    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> findByBookType(String bookType) {
        return bookRepository.findByBookType(bookType);
    }

    public List<Book> findByPublisher(String publisher) {
        return bookRepository.findByPublisher(publisher);
    }

    public Book findByIsbn(String isbn){
        return bookRepository.findByIsbn(isbn);
    }

    public void save(Book book){
        bookRepository.save(book);
    }
}
