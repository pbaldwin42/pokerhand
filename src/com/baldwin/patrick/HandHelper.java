package com.baldwin.patrick;

import java.util.Hashtable;
import java.util.List;

public class HandHelper {
    public static boolean isStraightFlush(List<Card> cards) {
        return (isFlush(cards) && isStraight(cards));
    }
    public static boolean isFourOfAKind(Hashtable<Rank, Integer> rankCount,
                                        List<Card> cards) {
        return (rankCount.get(cards.get(0).getRank()) == 4);
    }
    public static boolean isFullHouse(Hashtable<Rank, Integer> rankCount,
                                      List<Card> cards) {
        return (rankCount.get(cards.get(0).getRank()) == 3 &&
                rankCount.get(cards.get(4).getRank()) == 2);
    }
    public static boolean isFlush(List<Card> cards) {
        Suit flushSuit = cards.get(0).getSuit();
        for (Card card: cards) {
            if (card.getSuit() != flushSuit) {
                return (false);
            }
        }
        return (true);
    }
    public static boolean isStraight(List<Card> cards) {
        boolean isStraight;
        boolean aceIsHigh;

        isStraight = true;
        aceIsHigh = true;
        while (true) {
            for (int i = 0; i < cards.size() - 1; i += 1) {
                if (cardRankDifference(cards.get(i), cards.get(i + 1)) != 1
                        && cardRankDifference(cards.get(i), cards.get(i + 1)) != 12) {
                    isStraight = false;
                    break;
                }
            }
            if (!aceIsHigh && !isStraight) {
                cards.add(0, cards.get(cards.size() - 1));
                cards.remove(cards.size() - 1);
                aceIsHigh = true;
                break;
            } else if (aceIsHigh && !isStraight && cards.get(0).getRank() == Rank.ACE) {
                cards.add(cards.get(0));
                cards.remove(0);
                aceIsHigh = false;
                isStraight = true;
            } else {
                break;
            }
        }
        return (isStraight);
    }
    public static boolean isThreeOfAKind(Hashtable<Rank, Integer> rankCount,
                                         List<Card> cards) {
        return (rankCount.get(cards.get(0).getRank()) == 3);
    }
    public static boolean isTwoPair(Hashtable<Rank, Integer> rankCount,
                                    List<Card> cards) {
        return (rankCount.get(cards.get(0).getRank()) == 2 &&
                rankCount.get(cards.get(2).getRank()) == 2);
    }
    public static boolean isPair(Hashtable<Rank, Integer> rankCount,
                                 List<Card> cards) {
        return (rankCount.get(cards.get(0).getRank()) == 2);
    }
    private static int cardRankDifference(Card card1, Card card2) {
        return (Math.max(card1.getRank().getRankValue(), card2.getRank().getRankValue()) -
                Math.min(card1.getRank().getRankValue(), card2.getRank().getRankValue()));
    }
    public static String determineHandDetails(HandType handType, List<Card> cards) {
        if (handType == HandType.TWOPAIR || handType == HandType.FULLHOUSE) {
            return ("" + cards.get(0).getRank() + "s over " + cards.get(3).getRank() + "s");
        } else if (handType == HandType.FLUSH) {
            return ("" + cards.get(0).getRank() + " high");
        } else if (handType == HandType.STRAIGHT || handType == HandType.STRAIGHTFLUSH) {
            return ("" + cards.get(cards.size() - 1).getRank() + " to " + cards.get(0).getRank());
        } else if (handType == HandType.HIGH) {
            return ("" + cards.get(0).getRank());
        } else {
            return ("" + cards.get(0).getRank() + "s");
        }
    }
}
