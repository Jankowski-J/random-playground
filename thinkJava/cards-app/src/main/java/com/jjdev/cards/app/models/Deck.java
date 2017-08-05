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
        int lowIndex = low;
        for (int idx = low; idx <= high; idx++) {
            Card c = cards[idx];
            if (c.compareTo(cards[lowIndex]) < 0) {
                lowIndex = idx;
            }
        }
        return lowIndex;
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
        Deck result = new Deck(d1.cards.length + d2.cards.length);

        int choice;
        int i = 0;
        int j = 0;
        for (int k = 0; k < result.cards.length; k++) {
            choice = 1;

            if (i == d1.cards.length) {
                choice = 2;
            } else if (j == d2.cards.length) {
                choice = 1;
            } else if (Card.compareCards(d1.cards[i], d2.cards[j]) == 1) {
                choice = 2;
            }

            if (choice == 1) {
                result.cards[k] = d1.cards[i];
                i++;
            } else {
                result.cards[k] = d2.cards[j];
                j++;
            }
        }
        return result;
    }

    /**
     * Returns a sorted copy of the deck using merge sort.
     */
    public Deck mergeSort() {
        int mid = (cards.length - 1) / 2;

        Deck d1 = subdeck(0, mid);
        Deck d2 = subdeck(mid + 1, cards.length - 1);

        d1.sort();
        d2.sort();

        return merge(d1, d2);
    }

    /**
     * Reorders the cards (in place) using insertion sort.
     */
    public void insertionSort() {
    }

    public int findHighestCard(int i) {
        int index = i;
        for (i = i + 1; i < cards.length; i++) {
            if (Card.compareCards(cards[i], cards[index]) == -1) {
                index = i;
            }
        }
        return index;
    }

    public void sort() {
        for (int i = 0; i < cards.length; i++) {
            int j = findHighestCard(i);
            swapCards(i, j);
        }
    }
}
