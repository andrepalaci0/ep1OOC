package codes.test;

import codes.*;
import codes.Card;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CardTest {
    
    private Card card;

    @Before
    public void setUp() {
        Position[] positions = { 
            new Position(1, 0), 
            new Position(0, 1), 
            new Position(-1, 0), 
            new Position(0, -1) 
        };
        card = new Card("RandomCard", Color.BLUE, positions);
    }

    @Test
    public void getNameTest() {
        String expectedName = "RandomCard";
        String currName = card.getName();
        Assert.assertEquals(expectedName, currName);
    }

    @Test
    public void getColorTest() {
        Color expectedColor = Color.BLUE;
        Color currColor = card.getColor();
        Assert.assertEquals(expectedColor, currColor);
    }

    // falta adc getPositions

    @Test
    public void createCardsTest() {
        Card[] cards = Card.createCards();
        Assert.assertEquals(5, cards.length);

        for(Card card : cards) {
            Assert.assertNotNull(card.getName());
            Assert.assertNotNull(card.getColor());
            Assert.assertNotNull(card.getPositions());
        }
    }


}
