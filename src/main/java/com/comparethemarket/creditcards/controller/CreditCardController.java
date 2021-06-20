package com.comparethemarket.creditcards.controller;

import com.comparethemarket.creditcards.validator.CardValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * CreditCard Controller that validates CreditCard using Luhn algorithm and returns the output
 */
@RestController
public class CreditCardController {

    /**
     * GET operation that validates the Credit Card
     * @param cardNo - Credit Card Number
     * @return - validated credit card info
     */
    @GetMapping("/creditcard/{cardNo}")
    public String validateCreditCard(@PathVariable String cardNo) {
        return CardValidator.validateCreditCard(cardNo);
    }
}