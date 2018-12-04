package com.baldwin.patrick.pokerhand.hand_logic;

public enum HandType {
    HIGH("high card", 1, 1),
    PAIR("pair", 2, 2),
    TWOPAIR("two pair", 3, 4),
    THREEOFAKIND("three of a kind", 4, 3),
    STRAIGHT("straight", 5, 5),
    FLUSH("flush", 6, 5),
    FULLHOUSE("full house", 7, 5),
    FOUROFAKIND("four of a kind", 8, 4),
    STRAIGHTFLUSH("straight flush", 9, 5);

    private String  stringValue;
    private int     strength;
    private int     cardsRequired;

    HandType(String stringValue, int strength, int cardsRequired) {
        this.stringValue   = stringValue.intern();
        this.strength      = strength;
        this.cardsRequired = cardsRequired;
    }

    public int getStrength() {
        return (strength);
    }

    public int getCardsRequired() {
        return (cardsRequired);
    }

    @Override
    public String toString() {
        return (stringValue);
    }
}
