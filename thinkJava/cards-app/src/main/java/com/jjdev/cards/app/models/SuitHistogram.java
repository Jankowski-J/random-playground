package com.jjdev.cards.app.models;

import java.util.HashMap;

/**
 *
 * @author Jakub Jankowski
 */
public class SuitHistogram {
    private HashMap<Integer, Integer> values;
    
    public SuitHistogram() {
        values = new HashMap<>();
        
        values.put(0, 0);
        values.put(1, 0);
        values.put(2, 0);
        values.put(3, 0);
    }
    
    public void incrementSuit(Integer suit) {
        Integer suitCount = values.get(suit);
        values.replace(suit, suitCount + 1);
    }

    public Integer getSuitCount(Integer suit) {
        return values.get(suit);
    }
}
