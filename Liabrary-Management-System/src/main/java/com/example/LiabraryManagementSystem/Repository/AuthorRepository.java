package com.example.LiabraryManagementSystem.Repository;

import com.example.LiabraryManagementSystem.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
