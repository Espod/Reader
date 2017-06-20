package com.espod.repository;

import com.espod.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    List<Book> findByBookName(String bookName);

    List<Book> findByAuthor(String author);

    List<Book> findByBookType(String bookType);

    List<Book> findByPublisher(String publisher);

    Book findByIsbn(String isbn);

    Book save(Book book);
}