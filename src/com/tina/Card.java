package com.tina;

import java.util.Comparator;

/**
 * Created by tianrui on 2017-01-20.
 * An object of type Card represents a regular playing card from a deck.
 * The card has a suit, which can be spade, heart, club or diamond.
 * Each suit has 13 values: 2, 3, 4, 5, 6, 7, 8, 9, 10, jack(11), queen(12),
 * king(13), ace(1). Note that (for the convenience of sorting) "ace" is
 * considered to be the smallest value.
 *
 *
 */
public class Card implements Comparable<Card>{

    /**
     * number or the face on the card - a number 2 to 10, or 11 for Jack,
     * 12 for Queen, 13 for King, 1 for Ace. Once card is constructed,
     * it cannot be changed.
     */
    private int faceValue;
    /**
     * This is card's suit, should be one of the spade, heart, club or diamond.
     * Once card is constructed, it cannot be changed.
     */
    private Suit suit;

    public Card(int theValue, Suit theSuit){
        if(theValue < 1 || theValue > 13){
            throw new IllegalArgumentException("Illegal playing card value");
        }
        faceValue = theValue;
        suit = theSuit;
    }

    /*
     * Return the suit of the card.
     * @returns the Suit: one of spade, heart, club or diamond.
     */
    public Suit getSuit(){
        return suit;
    }

    /**
     * Return the value of this card.
     * @return the number: one number of 1~13.
     */
    public int getFaceValue(){
        return faceValue;
    }

    /**
     * Return a string that represents the face value of the card.
     * @return a String for a regular card, "A" for Ace, "J" for Jack;
     * "Q" for Queen, "K" for King, "2" for 2.
     */
    public String getValueToString(){
        switch (faceValue){
            case 1: return "A";
            case 2: return "2";
            case 3: return "3";
            case 4: return "4";
            case 5: return "5";
            case 6: return "6";
            case 8: return "8";
            case 9: return "9";
            case 10: return "10";
            case 11: return "J";
            case 12: return "Q";
            default: return "K";
        }
    }

    public String getSuitToString(){
        switch (suit){
            case Club: return "C";
            case Spade: return "S";
            case Heart: return "H";
            default: return "D";
        }
    }

    /**
     * Return a string that represents the value and the suit of the card
     * @return a string, like (4,S) represents Spade, 4.
     */

    public String toString(){
        return "("+ getValueToString() +", " + getSuitToString() + ")";
    }


    @Override
    /**
     * Compare the current card with another card.
     * Use this feature when sorting the deck.
     * First compare the suit, small to large as defined in Suit:
     * Spade(0), Heart(1), Club(2), Diamond(3);
     * If suit is same, compare the number.
     * @returns -1 smaller than current
     *          1 larger than current
     *          0 equals
     */
    public int compareTo(Card otherCard) {
        if(suit != otherCard.suit){
            /**
             * suit.compareTo returns the positive difference between the suits.
             * Spade.compareTo(Diamond) equals to -3.
             */
            if(suit.compareTo(otherCard.suit) > 0){
                return 1;
            }else{
                return -1;
            }
        }else{
            if(faceValue < otherCard.faceValue){
                return -1;
            }else if(faceValue > otherCard.faceValue){
                return 1;
            }else{
                return 0;
            }
        }
    }
}
