package com.example.LiabraryManagementSystem.Repository;


import com.example.LiabraryManagementSystem.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,String> {


}
