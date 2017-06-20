package com.espod.controller;

import com.alibaba.fastjson.JSONObject;
import com.espod.entity.Book;
import com.espod.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/bookName", method = RequestMethod.GET)
    public Object findByBookName(@RequestParam(value = "bookName") String bookName) {
        List<Book> books = bookService.findByBookName(bookName);
        if(books.size() == 0){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("msg","没有找到这本书");
            return  jsonObject;
        }else {
            return books;
        }
    }

    @RequestMapping(value = "/bookType", method = RequestMethod.GET)
    public Object findByBookType(@RequestParam(value = "bookType") String bookType) {
        List<Book> books = bookService.findByBookType(bookType);
        if(books.size() == 0){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("msg","没有找到这本书");
            return  jsonObject;
        }else {
            return books;
        }
    }

    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public Object findByAuthor(@RequestParam(value = "author") String author) {
        List<Book> books = bookService.findByAuthor(author);
        if(books.size() == 0){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("msg","没有找到这本书");
            return  jsonObject;
        }else {
            return books;
        }
    }

    @RequestMapping(value = "/publisher", method = RequestMethod.GET)
    public Object findByPublisher(@RequestParam(value = "publisher") String publisher) {
        List<Book> books = bookService.findByPublisher(publisher);
        if(books.size() == 0){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("msg","没有找到这本书");
            return  jsonObject;
        }else {
            return books;
        }
    }
}
