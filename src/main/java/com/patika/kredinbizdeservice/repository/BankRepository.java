package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Bank;

import java.util.ArrayList;
import java.util.List;

public class BankRepository {
    private List<Bank> banks = new ArrayList<>();
    public List<Bank> findAll() {
        return banks;
    }

}
