package com.example.LiabraryManagementSystem.RequestDtos;

import com.example.LiabraryManagementSystem.Enums.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AddBookRequest {

    private String name;
    private Genre genre;
    private int noOfPages;
    private int price;
    private Date publshDate;
    private Integer authorId;

}
