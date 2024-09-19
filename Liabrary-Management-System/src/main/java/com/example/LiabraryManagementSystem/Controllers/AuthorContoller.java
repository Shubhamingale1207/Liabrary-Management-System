package com.example.LiabraryManagementSystem.Controllers;

import com.example.LiabraryManagementSystem.Entities.Author;
import com.example.LiabraryManagementSystem.RequestDtos.AddAuthorRequest;
import com.example.LiabraryManagementSystem.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
public class  AuthorContoller {

    @Autowired
    private AuthorService authorService;
    @PostMapping("/addAuthor")
    public String addAuthor(@RequestBody AddAuthorRequest addAuthorRequest){

        String result= authorService.addAuthor(addAuthorRequest);
        return result;
    }

    @GetMapping("/authors")
    public List<Author> getAuthor(){
        return authorService.getAllAuthors();
    }

}
