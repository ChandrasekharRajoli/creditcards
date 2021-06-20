package com.comparethemarket.creditcards.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;

public class CardValidator {

    public static final String CARD_FORMATTER = "%s: %s (%s)";

    private static final Logger LOGGER = LoggerFactory.getLogger(CardValidator.class);

    /**
     * Validates CreditCard using Luhn algorithm and returns the output
     *
     * @param cardNumber
     * @return
     */
    public static String validateCreditCard(final String cardNumber) {
        boolean isValid = false;
        String cardNum = cardNumber.replaceAll("\\s+", "");
        CardType cardType = cardType(cardNum);
        if (CardType.UNKNOWN != cardType) {
            isValid = isValidCreditCardByLuhn(cardNum);
        }
        return String.format(CARD_FORMATTER, cardType.getCardType(), cardNumber, isValid ? "valid" : "invalid");
    }

    /**
     * CardType
     *
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
     *
     * @param cardNumber
     * @return
     */
    private static boolean isValidCreditCardByLuhn(final String cardNumber) {
        try {
            String[] cardNumberArray = cardNumber.split("");
            int sum = 0;
            for (int i = cardNumberArray.length - 1, k = 0; i >= 0; i--, k++) {
                int digit = Integer.valueOf(cardNumberArray[i]);
                if (k % 2 != 0) {
                    digit *= 2;
                }
                if (digit > 9)
                    digit -= 9;
                sum += digit;
            }
            return (sum % 10 == 0);
        } catch (Exception exe) {
            LOGGER.error("Failed to validate card", exe);
        }
        return false;
    }
}