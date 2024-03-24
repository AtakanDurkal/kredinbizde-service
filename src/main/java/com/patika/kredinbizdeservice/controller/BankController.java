package com.patika.kredinbizdeservice.controller;



import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.BankCreditCardDTO;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/banks")
public class BankController {

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/credit-cards")
    public ResponseEntity<List<BankCreditCardDTO>> getBanksCreditCardsAndCampaigns() {
        List<BankCreditCardDTO> bankCreditCards = bankService.getAllBanksCreditCardsWithCampaigns();
        return new ResponseEntity<>(bankCreditCards, HttpStatus.OK);
    }
}