package com.example.LiabraryManagementSystem.Controllers;

import com.example.LiabraryManagementSystem.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("card")
public class CardController {

    @Autowired
    private CardService cardService;
    @PostMapping("/generateACard")
    public String addCard(){
        String result = cardService.getFreshCard();
        return result;
    }

    @PutMapping("/associateCardAndStudent")
    public ResponseEntity associateCardAndStudent(@RequestParam ("studentId") Integer studentId,
                                                  @RequestParam ("cardId") Integer cardId){
        try {
                String result= cardService.associateCardAndStudent(studentId,cardId);
                return new ResponseEntity(result,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
