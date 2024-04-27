package com.example.LiabraryManagementSystem.Entities;

import com.example.LiabraryManagementSystem.Enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
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

    @JoinColumn
    @ManyToOne
    private Author author;

}
