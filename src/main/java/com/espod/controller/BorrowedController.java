package com.espod.controller;

import com.alibaba.fastjson.JSONObject;
import com.espod.entity.Book;
import com.espod.entity.Borrowed;
import com.espod.service.BookService;
import com.espod.service.BorrowedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrowed")
public class BorrowedController {
    @Autowired
    private BorrowedService borrowedService;
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object saveBorrowed(@RequestBody Borrowed borrowed) {
        JSONObject jsonObject = new JSONObject();
        Book book = bookService.findByIsbn(borrowed.getIsbn());
        if (book.getNumber() != 0) {
            borrowedService.saveBorrowed(borrowed);
            book.setNumber(book.getNumber() - 1);
            bookService.save(book);
            jsonObject.put("msg", "借阅成功");
        } else {
            jsonObject.put("msg", "这本书已经被借完了");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Borrowed> findByUserID(@RequestParam(value = "userID") String userID) {
        return borrowedService.findByUserID(userID);
    }

    @RequestMapping(value = "/giveBack", method = RequestMethod.GET)
    public Object giveBack(@RequestParam(value = "userID") String userID,
                         @RequestParam(value = "isbn") String isbn) {
        Borrowed borrowed = borrowedService.findByUserIDAndIsbn(userID, isbn);
        JSONObject jsonObject = new JSONObject();
        if(borrowed == null){
            jsonObject.put("msg", "你没有借阅这本书");
        }else {
            Book book = bookService.findByIsbn(borrowed.getIsbn());
            book.setNumber(book.getNumber()+1);
            bookService.save(book);
            borrowedService.deleteBorrowed(borrowed);
            jsonObject.put("msg", "图书归还成功");
        }
        return jsonObject;
    }
}
