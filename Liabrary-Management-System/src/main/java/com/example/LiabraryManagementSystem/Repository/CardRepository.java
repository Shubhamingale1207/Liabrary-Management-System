package com.example.LiabraryManagementSystem.Repository;

import com.example.LiabraryManagementSystem.Entities.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<LibraryCard, Integer> {

}
