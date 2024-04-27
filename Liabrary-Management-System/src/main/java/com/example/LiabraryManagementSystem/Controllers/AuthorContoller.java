package com.example.LiabraryManagementSystem.Controllers;

import com.example.LiabraryManagementSystem.RequestDtos.AddAuthorRequest;
import com.example.LiabraryManagementSystem.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("author")
public class AuthorContoller {

    @Autowired
    private AuthorService authorService;
    @PostMapping("/addAuthor")
    public String addAuthor(@RequestBody AddAuthorRequest addAuthorRequest){

        String result= authorService.addAuthor(addAuthorRequest);
        return result;
    }
}
