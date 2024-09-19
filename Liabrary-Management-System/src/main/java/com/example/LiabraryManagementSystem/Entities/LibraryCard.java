package com.example.LiabraryManagementSystem.Entities;

import com.example.LiabraryManagementSystem.Enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name= "Library_Card")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryCard {

    public static final Integer MAX_NO_OF_ALLOWED_BOOKS=3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardID;

    @Enumerated (value = EnumType.STRING)
    private CardStatus cardStatus;

    private int noOfBooksIssued;

    //Library card should have a foreign kay column

    @JoinColumn
    @OneToOne
    private Student student;

    @OneToMany(mappedBy ="libraryCard", cascade = CascadeType.ALL)
    public List<Transaction> transactionList=new ArrayList<>();



}
