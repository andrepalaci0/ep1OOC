package codes.test;

import codes.*;
import codes.Player;
import codes.Card;
import codes.Position;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class PlayerTest {

    private Player player;
    private Card[] cards;
    @Before
    public void setUp() {
        Card card1 = new Card("card1", Color.RED, new Position[] { new Position(0, 1) });
        Card card2 = new Card("card2", Color.BLUE, new Position[] { new Position(1,0) });
        cards = new Card[] { card1, card2 };
        player = new Player("player1", Color.RED, cards);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals("player1", player.getName());
    }

    @Test
    public void getPieceColorTest() {
        Assert.assertEquals(Color.RED, player.getPieceColor());
    }

    @Test
    public void getCardsTest() {
        Assert.assertArrayEquals(cards, player.getCards());
    }

}
