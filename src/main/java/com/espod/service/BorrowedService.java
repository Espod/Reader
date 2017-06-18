package com.espod.service;

import com.espod.entity.Borrowed;
import com.espod.repository.BorrowedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowedService {
    @Autowired
    private BorrowedRepository borrowedRepository;

    public void saveBorrowed(Borrowed borrowed){
        borrowedRepository.save(borrowed);
    }

    public List<Borrowed> findByUserID(String userID){
        return borrowedRepository.findByUserID(userID);
    }
}
