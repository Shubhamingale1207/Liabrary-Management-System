package com.example.LiabraryManagementSystem.Services;

import com.example.LiabraryManagementSystem.Entities.Book;
import com.example.LiabraryManagementSystem.Enums.Genre;
import com.example.LiabraryManagementSystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public String addABook(){
        Book newBook=new Book();
        newBook.setName("Scalper");
        newBook.setGenre(Genre.COMIC);
        newBook.setNoOfPages(100);
        Book savedBook=bookRepository.save(newBook);
        return "new book with the name"+savedBook.getName()+" and genre is" +savedBook.getGenre();
    }
}
