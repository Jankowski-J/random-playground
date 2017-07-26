package com.jjdev.cards.app.helpers;

import com.jjdev.cards.app.models.Card;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import org.junit.Test;

/**
 *
 * @author Jakub Jankowski
 */
public class CardsHelperTests {

    private CardsHelper sut;

    @Test
    public void isFlush_forFourCardsOfSameSuit_shouldReturnFalse() {
        sut = new CardsHelper();

        Card[] cards = new Card[4];

        cards[0] = new Card(1, 1);
        cards[1] = new Card(2, 1);
        cards[2] = new Card(3, 1);
        cards[3] = new Card(10, 1);

        Boolean isFlush = sut.isFlush(cards);

        assertFalse(isFlush);
    }

    @Test
    public void isFlush_forFiveCardsOfVaryingSuits_shouldReturnFalse() {
        sut = new CardsHelper();

        Card[] cards = new Card[4];

        cards[0] = new Card(1, 1);
        cards[1] = new Card(2, 2);
        cards[2] = new Card(3, 0);
        cards[3] = new Card(10, 1);

        Boolean isFlush = sut.isFlush(cards);

        assertFalse(isFlush);
    }

    @Test
    public void isFlush_forFiveCardsOfSameSuit_shouldReturnTrue() {
        sut = new CardsHelper();

        Card[] cards = new Card[5];

        cards[0] = new Card(1, 1);
        cards[1] = new Card(2, 1);
        cards[2] = new Card(3, 1);
        cards[3] = new Card(10, 1);
        cards[4] = new Card(11, 1);

        Boolean isFlush = sut.isFlush(cards);

        assertTrue(isFlush);
    }

    @Test
    public void isFlush_forFiveCardsOfSameSuitAndOneOther_shouldReturnTrue() {
        sut = new CardsHelper();

        Card[] cards = new Card[6];

        cards[0] = new Card(1, 1);
        cards[1] = new Card(2, 1);
        cards[2] = new Card(3, 1);
        cards[3] = new Card(10, 1);
        cards[4] = new Card(11, 1);
        cards[5] = new Card(11, 2);

        Boolean isFlush = sut.isFlush(cards);

        assertTrue(isFlush);
    }

    @Test
    public void isFlush_forSevenCardsOfSameSuit_shouldReturnTrue() {
        sut = new CardsHelper();

        Card[] cards = new Card[7];

        cards[0] = new Card(1, 1);
        cards[1] = new Card(2, 1);
        cards[2] = new Card(3, 1);
        cards[3] = new Card(10, 1);
        cards[4] = new Card(11, 1);
        cards[5] = new Card(4, 1);
        cards[6] = new Card(8, 1);

        Boolean isFlush = sut.isFlush(cards);

        assertTrue(isFlush);
    }
}
