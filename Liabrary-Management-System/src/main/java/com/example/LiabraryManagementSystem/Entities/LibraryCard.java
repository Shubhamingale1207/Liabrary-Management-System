package com.example.LiabraryManagementSystem.Entities;

import com.example.LiabraryManagementSystem.Enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name= "Library_Card")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryCard {

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

}
