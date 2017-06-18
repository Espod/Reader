package com.espod.controller;

import com.espod.entity.Borrowed;
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

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveBorrowed(@RequestBody Borrowed borrowed) {
        borrowedService.saveBorrowed(borrowed);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Borrowed> findByUserID(@RequestParam(value = "userID") String userID) {
        return borrowedService.findByUserID(userID);
    }
}
