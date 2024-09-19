package com.example.LiabraryManagementSystem.Services;

import com.example.LiabraryManagementSystem.Entities.Author;
import com.example.LiabraryManagementSystem.Entities.Book;
import com.example.LiabraryManagementSystem.Enums.Genre;
import com.example.LiabraryManagementSystem.Repository.AuthorRepository;
import com.example.LiabraryManagementSystem.Repository.BookRepository;
import com.example.LiabraryManagementSystem.RequestDtos.AddBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;
    public String addABook(){
        Book newBook=new Book();
        newBook.setName("Scalper");
        newBook.setGenre(Genre.COMIC);
        newBook.setNoOfPages(100);
        Book savedBook=bookRepository.save(newBook);
        return "new book with the name"+savedBook.getName()+" and genre is" +savedBook.getGenre();
    }

    public String addBook(AddBookRequest bookRequest){
        //Logical steps
        //1. Get the author entity from the authorId
        Author author=authorRepository.findById(bookRequest.getAuthorId()).get();

        //2. Create the book entity from bookRequest
        Book newBook=new Book(bookRequest.getName(),bookRequest.getGenre(),bookRequest.getNoOfPages(),
                        bookRequest.getPrice(),bookRequest.getPublshDate());

        author.setNoOfBooksWritten(author.getNoOfBooksWritten()+1);

        //3. Set the foreign key variables/ mapping variables
          //3.1 Adding for the book author entity
            newBook.setAuthor(author); //unidirectional mapping
            //3.2 For the author add the book in the BookList
        author.getBookList().add(newBook); //bidirectional mapping

        //4. save the parent class
        authorRepository.save(author);
        return " Book has been saved to Db";

    }
}
