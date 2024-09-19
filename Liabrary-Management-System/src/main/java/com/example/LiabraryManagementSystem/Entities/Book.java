package com.example.LiabraryManagementSystem.Entities;

import com.example.LiabraryManagementSystem.Enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer bookId;
    @Column(unique = true)
    private String name;
    @Enumerated (value = EnumType.STRING)
    private Genre genre;
    private int noOfPages;
    private int price;

    private Date publshDate;

    private Boolean isAvailable;

    @JoinColumn
    @ManyToOne
    private Author author;

    @OneToMany(mappedBy="book",cascade = CascadeType.ALL)
    public List<Transaction> transactionList=new ArrayList<>();

    public Book(String name, Genre genre, int noOfPages, int price, Date publshDate) {
        this.name = name;
        this.genre = genre;
        this.noOfPages = noOfPages;
        this.price = price;
        this.publshDate = publshDate;
    }
}
