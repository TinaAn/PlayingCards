package com.tina;

public class Main {

    public static void main(String[] args) {

        /**
         * This is the test file, test the four API inside the deck.
         * shuffle, displayCards, sorting, dealCards
         *
         * Reference for this project:
         * 1. Introduction to Programming Using Java, Section 5.4 http://math.hws.edu/javanotes/c5/s4.html
         * 2. QuickSort algorithm, http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
         * 3. Cracking the code interview, page 280
         */
        Deck cardDeck = new Deck();

        System.out.println("Display cards:");
        cardDeck.displayCards();

        cardDeck.shuffle();

        System.out.println("new display: ");
        cardDeck.displayCards();

        cardDeck.sorting();
        System.out.println("After sorting: ");
        cardDeck.displayCards();

        System.out.println("Deal cards:");
        cardDeck.dealCards(4,2);

        System.out.println("New Deal:");
        cardDeck.dealCards(4,1);

        cardDeck.shuffle();
        System.out.println("Deal cards after shuffle:");
        cardDeck.dealCards(3,3);

        cardDeck.sorting();
        System.out.println("After sorting:");
        cardDeck.displayCards();

    }
}
