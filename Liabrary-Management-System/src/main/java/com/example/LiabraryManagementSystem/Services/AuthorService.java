package com.example.LiabraryManagementSystem.Services;


import com.example.LiabraryManagementSystem.Entities.Author;
import com.example.LiabraryManagementSystem.Repository.AuthorRepository;
import com.example.LiabraryManagementSystem.RequestDtos.AddAuthorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;
    public String addAuthor(AddAuthorRequest addAuthorRequest){

        Author authorEntity= new Author(addAuthorRequest.getAuthorName(),addAuthorRequest.getAuthorAge(), addAuthorRequest.getEmailId());

        Author newAuthor = authorRepository.save(authorEntity);
        return "Author ahs been saved to db with Id "+ newAuthor.getAuthorId();
    }

}
