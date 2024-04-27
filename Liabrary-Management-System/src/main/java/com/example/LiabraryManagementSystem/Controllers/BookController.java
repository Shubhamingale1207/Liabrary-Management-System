package com.example.LiabraryManagementSystem.Controllers;


import com.example.LiabraryManagementSystem.Entities.Book;
import com.example.LiabraryManagementSystem.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;
    @PostMapping("/addABook")
    public String addABook(){
        String result=bookService.addABook();
        return result;
    }
}
