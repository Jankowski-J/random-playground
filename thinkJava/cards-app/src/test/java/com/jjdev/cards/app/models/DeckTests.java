/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jjdev.cards.app.models;

import java.util.Arrays;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author Jakub Jankowski
 */
public class DeckTests {
    private Deck deck;
    
    @Test
    public void shuffle_shouldBeRandomized() {
        deck = new Deck();
        
        deck.shuffle();
        
        Deck controlDeck = new Deck();
        
        TestCase.assertFalse(Arrays.equals(deck.getCards(), controlDeck.getCards()));
    }
    
    //@Test
    public void selectionSortAfterShuffle_shouldBeSorted() {
        deck = new Deck();
        
        deck.shuffle();
        deck.selectionSort();
        
        Deck controlDeck = new Deck();
        controlDeck.selectionSort();
        
        TestCase.assertTrue(Arrays.equals(deck.getCards(), controlDeck.getCards()));
    }
}
