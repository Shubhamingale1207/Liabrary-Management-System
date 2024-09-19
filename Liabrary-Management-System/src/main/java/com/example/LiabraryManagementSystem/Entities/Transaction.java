package com.example.LiabraryManagementSystem.Entities;

import com.example.LiabraryManagementSystem.Enums.TransactionStatus;
import com.example.LiabraryManagementSystem.Enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name ="transaction")
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String transactionId;

    private TransactionStatus transactionStatus;

    @CreatedDate
    private Date createdOn;

    private int fineAmount;

    private TransactionType transactionType;

    @JoinColumn
    @ManyToOne
    private LibraryCard libraryCard;

    @JoinColumn
    @ManyToOne
    private Book book;

}
