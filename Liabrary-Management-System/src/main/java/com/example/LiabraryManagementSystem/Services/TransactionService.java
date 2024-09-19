package com.example.LiabraryManagementSystem.Services;

import com.example.LiabraryManagementSystem.Entities.Book;
import com.example.LiabraryManagementSystem.Entities.LibraryCard;
import com.example.LiabraryManagementSystem.Entities.Transaction;
import com.example.LiabraryManagementSystem.Enums.TransactionStatus;
import com.example.LiabraryManagementSystem.Enums.TransactionType;
import com.example.LiabraryManagementSystem.Exceptions.BookNotAvailableException;
import com.example.LiabraryManagementSystem.Exceptions.BookNotFoundException;
import com.example.LiabraryManagementSystem.Exceptions.CardNotFoundException;
import com.example.LiabraryManagementSystem.Exceptions.MaxLimitReachedException;
import com.example.LiabraryManagementSystem.Repository.BookRepository;
import com.example.LiabraryManagementSystem.Repository.CardRepository;
import com.example.LiabraryManagementSystem.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CardRepository cardRepository;

    public String issueBook(Integer cardId, Integer bookId) throws Exception{

        Transaction transaction=new Transaction();
        transaction.setTransactionType(TransactionType.ISSUE);
        transaction.setTransactionStatus(TransactionStatus.ONGOING);

        //GEt the book and card entity from the Db
        Optional<Book> optionalBook= bookRepository.findById(bookId);
        if(optionalBook.isEmpty()){
            throw new BookNotFoundException("BookId is invalid");
        }

        Book book=optionalBook.get();

        Optional<LibraryCard> optionalLibraryCard= cardRepository.findById(cardId);
        if(optionalLibraryCard.isEmpty()){
            throw new CardNotFoundException("cardId is Invalid");
        }

        LibraryCard card=optionalLibraryCard.get();

        //Validate the book and card entity variables
        //Check for book availability
        if(book.getIsAvailable()==Boolean.FALSE){
            transaction.setTransactionStatus(TransactionStatus.FAIL);
            transaction= transactionRepository.save(transaction);
            throw new BookNotAvailableException("Book with the bookId is not available. TransactionId "+transaction.getTransactionId());
        }
        //Check for maximum book issued
        if(card.getNoOfBooksIssued()>=LibraryCard.MAX_NO_OF_ALLOWED_BOOKS){
            transaction.setTransactionStatus(TransactionStatus.FAIL);
            transaction=transactionRepository.save(transaction);
            throw new MaxLimitReachedException("You have reached the max limit of books"+
                    "please return a book in order to new book"+"transaction Id"+transaction.getTransactionId());
        }

        //If you have reached here that means all validations are ok
        transaction.setTransactionStatus((TransactionStatus.success));

        //Update the card and book status
        book.setIsAvailable(Boolean.FALSE);
        card.setNoOfBooksIssued(card.getNoOfBooksIssued()+1);

        //Child class also need to have the attributes of the parent class
        transaction.setBook(book);
        transaction.setLibraryCard(card);

        //save the child table as it will cascade to both of the parents
        transaction=transactionRepository.save(transaction);

        return "the transaction with the id "+transaction.getTransactionId()+"has been saved to the DB";

    }
}
