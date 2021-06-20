package com.comparethemarket.creditcards.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;

public class CardValidator {

    public static final String CARD_FORMATTER = "%s: %s (%s)";

    private static final Logger LOGGER = LoggerFactory.getLogger(CardValidator.class);

    public static void main(String[] args) {
        String s = "5105 1051 0510 5106";

        System.out.println(validateCreditCard(s));
    }

    /**
     * Validates CreditCard using Luhn algorithm and returns the output
     * @param cardNumber
     * @return
     */
    public static String validateCreditCard(final String cardNumber) {
        boolean isValid = false;
        String cardNum = cardNumber.replaceAll("\\s+","");
        CardType cardType = cardType(cardNum);
        if (CardType.UNKNOWN != cardType) {
            isValid = isValidCreditCardByLuhn(cardNum);
        }
        return String.format(CARD_FORMATTER, cardType.getCardType(), cardNumber, isValid ? "valid" : "invalid");
    }

    /**
     * CardType
     * @param cardNumber
     * @return
     */
    private static CardType cardType(final String cardNumber) {
        CardType creditCardType = Arrays.stream(CardType.values())
                .filter(cardType -> !ObjectUtils.isEmpty(cardType.getPattern())
                        && cardType.getPattern().matcher(cardNumber).matches())
                .findFirst().orElse(CardType.UNKNOWN);
        return creditCardType;
    }

    /**
     * Validates CreditCard using Luhn algorithm
     * @param cardNumber
     * @return
     */
    private static boolean isValidCreditCardByLuhn(final String cardNumber) {
        try {
            String[] cardNumberArray = cardNumber.split("");
            int sum = 0;
            for (int i = 0; i < cardNumberArray.length; i++) {
                int digit = Integer.valueOf(cardNumberArray[i]);
                int product;
                if (i % 2 != 0) {
                    product = digit;
                } else {
                    product = digit * 2;
                }
                if (product > 9)
                    product -= 9;
                sum += product;
            }
            return (sum % 10 == 0);
        } catch (Exception exe) {
            LOGGER.error("Failed to validate card", exe);
        }
        return false;
    }
}