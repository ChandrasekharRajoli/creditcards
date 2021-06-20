package com.comparethemarket.creditcards.validator;

import java.util.regex.Pattern;

public enum CardType {
    AMEX("AMEX", "^3[47][0-9]{13}$"),
    DISCOVER("Discover", "^6011[0-9]{12}$"),
    MASTERCARD("MasterCard", "^5[1-5][0-9]{14}$"),
    VISA("VISA", "^4[0-9]{12}(?:[0-9]{3})?$"),
    UNKNOWN("Unknown");

    private String cardType;
    private Pattern pattern;

    CardType(String cardType, String pattern) {
        this.cardType = cardType;
        this.pattern = Pattern.compile(pattern);
    }

    CardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardType() {
        return cardType;
    }

    public Pattern getPattern() {
        return pattern;
    }
}