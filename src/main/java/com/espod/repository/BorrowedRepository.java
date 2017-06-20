package com.espod.repository;

import com.espod.entity.Borrowed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowedRepository extends JpaRepository<Borrowed, String> {
    Borrowed save(Borrowed borrowed);

    List<Borrowed> findByUserID(String userID);
}
