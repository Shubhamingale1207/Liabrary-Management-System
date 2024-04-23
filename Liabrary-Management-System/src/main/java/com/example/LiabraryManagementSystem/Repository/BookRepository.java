package com.example.LiabraryManagementSystem.Repository;

import com.example.LiabraryManagementSystem.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
