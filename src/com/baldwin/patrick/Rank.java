package com.baldwin.patrick;

public enum Rank {
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("Jack", 11),
    QUEEN("Queen", 12),
    KING("King", 13),
    ACE("Ace", 14);

    private String  stringValue;
    private int     rankValue;

    private Rank(String stringValue, int rankValue) {
        this.stringValue = stringValue;
        this.rankValue   = rankValue;
    }

    public int getRankValue() {
        return (this.rankValue);
    }

    @Override
    public String toString() {
        return (this.stringValue);
    }
}
