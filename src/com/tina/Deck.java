package com.tina;

/**
 * Created by tianrui on 2017-01-20.
 * An object of type Deck represents a deck of playing cards.
 * The deck is a regular deck consisting 52 regular cards.
 * Includes display, shuffle, sort and deal function.
 */
public class Deck {
    /**
     * An array of 52 regular cards in a regular deck.
     * Each card has suit and value.
     */
    private Card[] deck;

    /**
     * Construct a regular 52-card poker deck. Initially, the cards are
     * in a sorted order. The shuffle method can be called to randomize
     * the order.
     */
    public Deck(){
        deck = new Card[52];
        int cardCt = 0; //The number of Cards have been created so far.

        for(Suit curSuit : Suit.values()){
            for( int value = 1; value <= 13; value++){
                deck[cardCt] = new Card(value,curSuit);
                cardCt++;
            }
        }
    }

    /**
     * Put all used cards back into the deck, and shuffle all the cards together
     * to get a random order.
     */
    public void shuffle(){
        for( int i = deck.length-1; i>0; i--){
            int rand = (int) (Math.random()*(i+1)); //generate a int smaller than i+1
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        //cardsUsed = 0;
    }

    /**
     * A deal function which prints N sets of M cards: The internal set of cards in the
     * deck does not need to be altered. i.e. The deck doesn't 'loose' the cards it deals.
     * Also, two consecutive 'deals' should produce the same result.
     * The deck must be shuffled in order to produce a different 'deal'.
     * @input (sets N, cardsNumber M)
     * No returns, just print N sets of M cards:
     */
    public void dealCards(int setNumber, int cardNumber){
        if(setNumber*cardNumber>deck.length || setNumber<=0 || cardNumber<=0){
            throw new IllegalArgumentException("Required cards number invalid, total should be smaller than 52.");
        }else{
            for(int i = 1; i <= setNumber; i++){
                System.out.print("Set " + i + ": ");
                for(int j = 1; j<= cardNumber; j++){
                    Card curCard = deck[i*j-1];
                    System.out.print(curCard.toString());
                    System.out.print(' ');
                }
                System.out.println();
            }
        }
    }

    /**
     * A display function (to 'standard out') for all cards in their current permutation.
     * A card is identified by it's suit and card number. i.e. 4 of spades could be shown as (4,S).
     * King of hearts as (K,H). The method is implemented in Card.toString function, just use it.
     * No Returns, print out all cards, print the cards in 4 rows 13 columns
     */
    public void displayCards(){
        for(int i = 0; i < deck.length; i++){
            System.out.print(deck[i].toString());
            System.out.print(' ');
            if((i+1)%13 == 0){
                System.out.println();
            }

        }
    }

    /**
     * A sorting function: first ordered by suit, then card number. Suit order will
     * be: Spades, Hearts, Clubs, Diamonds. Card number will according to the face value
     * of the card (1~13).
     * No returns, use quick sort to sort the numbers from low to high.
     * Compare method is defined in Card.
     */
    public void sorting(){
        QuickSortCards sortDeck = new QuickSortCards();
        sortDeck.sort(deck);
    }

}
