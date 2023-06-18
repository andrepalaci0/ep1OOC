package codes.test;

import codes.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.Assert.assertTrue;

public class PieceTest {

    private Piece bluePiece;
    private Piece redPiece;
    private Piece master;

    @BeforeEach
    void setUp() {
        bluePiece = new Piece(Color.BLUE, false);
        redPiece = new Piece(Color.RED, false);
    }

    @Test
    void getColorTest() {
        assertEquals(Color.BLUE, bluePiece.getColor());
        assertEquals(Color.RED, redPiece.getColor());
    }

    @Test
    void isMasterTest() {
        master = new Piece(Color.RED, true);
        assertAll(()-> assertFalse(redPiece.isMaster()), ()-> assertFalse(bluePiece.isMaster()), ()-> assertTrue(master.isMaster()));
    }

}
