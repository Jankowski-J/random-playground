package com.jjdev.cards.app.helpers;

import com.jjdev.cards.app.models.Card;
import com.jjdev.cards.app.models.SuitHistogram;

/**
 *
 * @author Jakub Jankowski
 */
public class CardsHelper {

    public SuitHistogram calculateSuitsHistogram(Card[] cards) {
        SuitHistogram histogram = new SuitHistogram();
        
        for(Card card: cards) {
            histogram.incrementSuit(card.getSuit());
        }
        
        return histogram;
    }
    
    public boolean isFlush(Card[] hand) {
        SuitHistogram histogram = calculateSuitsHistogram(hand);
        
        for(int suit = 0; suit < 4; suit++) {
            Integer count = histogram.getSuitCount(suit);
            
            if(count > 4) {
                return true;
            }
        }
        
        return false;
    }
}
