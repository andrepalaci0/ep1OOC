package codes.test;

import codes.*;
import codes.Color;
import codes.Piece;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PieceTest {

    private Piece bluePiece;
    private Piece redPiece;
    private Piece master;

    @Before
    public void setUp() {
        bluePiece = new Piece(Color.BLUE, false);
        redPiece = new Piece(Color.RED, false);
    }

    @Test
    public void getColorTest() {
        assertEquals(Color.BLUE, bluePiece.getColor());
        assertEquals(Color.RED, redPiece.getColor());
    }

    @Test
    public void isMasterTest() {
        master = new Piece(Color.RED, true);
        // assertAll(()-> assertFalse(redPiece.isMaster()), ()-> assertFalse(bluePiece.isMaster()), ()-> assertTrue(master.isMaster()));
        assertFalse(redPiece.isMaster());
        assertFalse(bluePiece.isMaster());
        assertTrue(master.isMaster());
    }
}
