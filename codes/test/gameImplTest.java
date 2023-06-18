package codes.test;

import codes.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class gameImplTest {

    private GameImpl game;

    @BeforeEach

    void setUp() {
        Card.createCards();
        game = new GameImpl();
    }

    @Test
    void getSpotColorTest() {
        Color curr =  game.getSpotColor(new Position(4, 2));
        assertEquals(Color.BLUE, curr);
    }

    @Test
    void getPieceTest() {
        Piece curr = game.getPiece(new Position(0, 0));
        assertEquals(Color.BLUE, curr.getColor());
        assertNotNull(curr);

        curr = game.getPiece(new Position(2, 0));
        assertNull(curr);
    }

    // adc tabbleCard

    @Test
    void getRedPlayerTest() {
        Color curr = game.getRedPlayer().getPieceColor();
        assertEquals(Color.RED, curr);
    }

    @Test
    void getBluePlayerTest() {
        Color curr = game.getBluePlayer().getPieceColor();
        assertEquals(Color.BLUE, curr);
    }


    
}
