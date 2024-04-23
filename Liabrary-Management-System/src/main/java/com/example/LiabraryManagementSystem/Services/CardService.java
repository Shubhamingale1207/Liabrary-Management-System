package com.example.LiabraryManagementSystem.Services;

import com.example.LiabraryManagementSystem.Entities.LibraryCard;
import com.example.LiabraryManagementSystem.Entities.Student;
import com.example.LiabraryManagementSystem.Enums.CardStatus;
import com.example.LiabraryManagementSystem.Repository.CardRepository;
import com.example.LiabraryManagementSystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private StudentRepository studentRepository;

    public String getFreshCard(){
        LibraryCard newCard= new LibraryCard();
        newCard.setCardStatus(CardStatus.NEW);
        newCard.setNoOfBooksIssued(0);

        LibraryCard savedCard = cardRepository.save(newCard);

        return "new card with card No "+ savedCard.getCardID() + " has been generated";
    }

    public String associateCardAndStudent(Integer studentId, Integer cardId) throws Exception{
        Optional<LibraryCard> optionalLibraryCard=cardRepository.findById(cardId);

        if(optionalLibraryCard.isEmpty()){
            throw new Exception("Invalid cardId is Entered");
        }
        LibraryCard libraryCard= optionalLibraryCard.get();
        Optional<Student> optionalStudent=studentRepository.findById(studentId);

        if(optionalStudent.isEmpty()){
            throw new Exception("No student with the given Id exists in the system");
        }

        Student student=optionalStudent.get();

        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setStudent(student);
        libraryCard.setNoOfBooksIssued(0);

        cardRepository.save(libraryCard);

        return "card with cardId "+cardId+"and student with studentId"+studentId+" are associated";
    }
}
