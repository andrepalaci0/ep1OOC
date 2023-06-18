package codes.test;

import codes.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class SpotTest {

  private Spot spot;
  private Piece piece;

  @Before
  public void setUp() {
    Position position = new Position(2, 3);
    piece = new Piece(Color.RED, false);
    spot = new Spot(piece, position);
  }

  @Test
  public void getPositionTest() {
    Position position = spot.getPosition();
    Assert.assertEquals(2, position.getRow());
    Assert.assertEquals(3, position.getCol());
  }

  @Test
  public void getPieceTest() {
    Piece retrievedPiece = spot.getPiece();
    Assert.assertEquals(piece, retrievedPiece);
  }
  
  // falta adc getColor

  // falta adc occupySpot

  // falta adc releaseSpot 

  // falta adc createBoard

  @Test
  public void testGetPieceNotEquals() {
    Piece otherPiece = new Piece(Color.BLUE, false);
    Piece retrievedPiece = spot.getPiece();
    Assert.assertNotEquals(otherPiece, retrievedPiece);
  }

}
