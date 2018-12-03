package com.baldwin.patrick;

import java.util.HashSet;
import java.util.Set;

public class Card {
    private static Set<String> cardsCreated;
    private Rank rank;
    private Suit suit;

    public Card(String cardString) {
        if (cardsCreated == null) {
            cardsCreated = new HashSet<>();
        }
        if (cardString.length() != 2) {
            throw new IllegalArgumentException("\"" + cardString + "\"" +
                " should be only two characters: a value and a rank.");
        }
        storeRank(cardString.charAt(0));
        storeSuite(cardString.charAt(1));
        if (Card.cardsCreated.contains("" + rank + suit)) {
            throw new IllegalArgumentException("\"" + cardString + "\"" +
                    " was entered multiple times. One of the players must be cheating.");
        } else {
            Card.cardsCreated.add(("" + rank + suit));
        }
    }

    private void storeRank(char rankChar) {
        switch (rankChar) {
            case '2':
                rank = Rank.TWO;
                break;
            case '3':
                rank = Rank.THREE;
                break;
            case '4':
                rank = Rank.FOUR;
                break;
            case '5':
                rank = Rank.FIVE;
                break;
            case '6':
                rank = Rank.SIX;
                break;
            case '7':
                rank = Rank.SEVEN;
                break;
            case '8':
                rank = Rank.EIGHT;
                break;
            case '9':
                rank = Rank.NINE;
                break;
            case 'T':
                rank = Rank.TEN;
                break;
            case 'J':
                rank = Rank.JACK;
                break;
            case 'Q':
                rank = Rank.QUEEN;
                break;
            case 'K':
                rank = Rank.KING;
                break;
            case 'A':
                rank = Rank.ACE;
                break;
            default:
                throw new IllegalArgumentException("\"" + rankChar + "\"" +
                        " is not a valid card value. Use 2-9 and T, J, Q, K, A.");
        }
    }

    private void storeSuite(char suitChar) {
        switch (suitChar) {
            case 'S':
                suit = Suit.SPADES;
                break;
            case 'C':
                suit = Suit.CLUBS;
                break;
            case 'H':
                suit = Suit.HEARTS;
                break;
            case 'D':
                suit = Suit.DIAMONDS;
                break;
            default:
                throw new IllegalArgumentException("\"" + suitChar + "\"" +
                        " is not a valid suit. Use S, C, H, D for Spades, Clubs, Hearts " +
                        "and Diamonds respectively");
        }
    }

    @Override
    public String toString() {
        return ((rank.toString() + " of " + suit.toString()));
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}
