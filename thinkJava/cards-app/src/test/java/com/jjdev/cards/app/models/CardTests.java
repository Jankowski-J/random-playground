package com.jjdev.cards.app.models;

import com.jjdev.cards.app.models.Card;
import org.junit.Test;

/*
 *
 * @author Jakub Jankowski
 */
public class CardTests {

    @Test
    public void compareTo_aceToKing_aceShouldBeHigher() {
        Card ace = new Card(1, 1);
        Card king = new Card(13, 1);

        int result = ace.compareTo(king);

        junit.framework.TestCase.assertEquals(1, result);
    }

    @Test
    public void compareTo_aceToThree_aceShouldBeHigher() {
        Card ace = new Card(1, 1);
        Card three = new Card(3, 1);

        int result = ace.compareTo(three);

        junit.framework.TestCase.assertEquals(1, result);
    }
}
