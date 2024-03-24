package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.BankCreditCardDTO;
import com.patika.kredinbizdeservice.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Scope(value = "singleton")
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository = new BankRepository();

    public List<BankCreditCardDTO> getAllBanksWithCreditCardsAndCampaigns() {
        List<Bank> banks = bankRepository.findAll();
        return banks.stream().map(BankCreditCardDTO::fromBank).collect(Collectors.toList());
    }
}