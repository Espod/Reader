package com.espod.controller;

import com.espod.entity.Book;
import com.espod.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books/bookName", method = RequestMethod.GET)
    public List<Book> findByBookName(@RequestParam(value = "bookName") String bookName) {
        return bookService.findByBookName(bookName);
    }

    @RequestMapping(value = "/books/bookType", method = RequestMethod.GET)
    public List<Book> findByBookType(@RequestParam(value = "bookType") String bookType) {
        return bookService.findByBookType(bookType);
    }

    @RequestMapping(value = "/books/author", method = RequestMethod.GET)
    public List<Book> findByAuthor(@RequestParam(value = "author") String author) {
        return bookService.findByAuthor(author);
    }

    @RequestMapping(value = "/books/publisher", method = RequestMethod.GET)
    public List<Book> findByPublisher(@RequestParam(value = "publisher") String publisher) {
        return bookService.findByPublisher(publisher);
    }
}
