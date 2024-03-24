package com.patika.kredinbizdeservice.model;



import com.patika.kredinbizdeservice.model.Campaign;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankCreditCardDTO {
    private String bankName;
    private List<CreditCardDTO> creditCards;

    public static BankCreditCardDTO fromBank(Bank bank) {
        List<CreditCardDTO> creditCardDTOList = bank.getCreditCardList().stream()
                .map(creditCard -> new CreditCardDTO(creditCard.getFee(), creditCard.getCampaigns()))
                .collect(Collectors.toList());
        return new BankCreditCardDTO(bank.getName(), creditCardDTOList);
    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class CreditCardDTO {
    private BigDecimal fee;
    private List<Campaign> campaigns;


}