package com.jjdev.cards.app.models;

import com.jjdev.cards.app.models.Card;
import java.util.Arrays;
import java.util.Random;

/**
 * A deck of playing cards (of fixed size).
 */
public class Deck {

    private static Random random = new Random();
    private Card[] cards;

    /**
     * Constructs a standard deck of 52 cards.
     */
    public Deck() {
        this.cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                this.cards[index] = new Card(rank, suit);
                index++;
            }
        }
    }

    /**
     * Constructs a deck of n cards (null).
     */
    public Deck(int n) {
        this.cards = new Card[n];
    }

    /**
     * Gets the internal cards array.
     */
    public Card[] getCards() {
        return this.cards;
    }

    /**
     * Displays each of the cards in the deck.
     */
    public void print() {
        for (int i = 0; i < this.cards.length; i++) {
            System.out.println(this.cards[i]);
        }
    }

    /**
     * Returns a string representation of the deck.
     */
    public String toString() {
        return Arrays.toString(this.cards);
    }

    /**
     * Chooses a random number between low and high, including both.
     */
    public int randomInt(int low, int high) {
        int diff = high - low;
        return random.nextInt(diff + 1) + low;
    }

    /**
     * Swaps the cards at indexes i and j.
     */
    public void swapCards(int i, int j) {
        try {
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        } catch (Exception e) {
            System.out.println("" + i + "|" + j);
        }
    }

    /**
     * Randomly permutes the array of cards.
     */
    public void shuffle() {
        for (int i = 0; i < cards.length; i++) {
            int randomed = randomInt(i, cards.length - 1);
            swapCards(i, randomed);
        }
    }

    /**
     * Finds the index of the lowest card between low and high inclusive.
     */
    public int indexLowest(int low, int high) {
        Card lowCard = new Card(1, 3);
        int lowIndex = -1;

        for (int idx = low; idx <= high; idx++) {
            Card c = cards[idx];
            if (c.compareTo(lowCard) <= 0) {
                lowCard = c;
                lowIndex = idx;
            }
        }
        return lowIndex > 0 ? lowIndex : high;
    }

    /**
     * Sorts the cards (in place) using selection sort.
     */
    public void selectionSort() {
        for (int idx = 0; idx < cards.length; idx++) {
            int lowIdx = indexLowest(idx, cards.length - 1);
            swapCards(idx, lowIdx);
        }
    }

    /**
     * Returns a subset of the cards in the deck.
     */
    public Deck subdeck(int low, int high) {
        Deck sub = new Deck(high - low + 1);
        for (int i = 0; i < sub.cards.length; i++) {
            sub.cards[i] = this.cards[low + i];
        }
        return sub;
    }

    /**
     * Combines two previously sorted subdecks.
     */
    public static Deck merge(Deck d1, Deck d2) {
        return null;
    }

    /**
     * Returns a sorted copy of the deck using merge sort.
     */
    public Deck mergeSort() {
        return this;
    }

    /**
     * Reorders the cards (in place) using insertion sort.
     */
    public void insertionSort() {
    }

}
