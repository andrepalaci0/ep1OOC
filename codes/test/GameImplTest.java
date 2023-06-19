package codes.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Before;

import codes.Card;
import codes.Color;
import codes.GameImpl;
import codes.Piece;
import codes.Position;

public class GameImplTest {

  private GameImpl game;

  @Before

  public void setUp() {
    Card.createCards();
    game = new GameImpl();
  }

  @Test
  public void getSpotColorTest() {
    Color curr = game.getSpotColor(new Position(4, 2));
    assertEquals(Color.RED, curr);
  }

  @Test
  public void getPieceTest() {
    Piece curr = game.getPiece(new Position(0, 0));
    assertEquals(Color.BLUE, curr.getColor());
    assertNotNull(curr);

    curr = game.getPiece(new Position(2, 0));
    assertNull(curr);
  }

  @Test
  public void getTableCard() {
    Card card = game.getTableCard();
    assertNotNull(card);
  }

  @Test
  public void getRedPlayerTest() {
    Color curr = game.getRedPlayer().getPieceColor();
    assertEquals(Color.RED, curr);
  }

  @Test
  public void getBluePlayerTest() {
    Color curr = game.getBluePlayer().getPieceColor();
    assertEquals(Color.BLUE, curr);
  }

  @Test
  public void makeMove() {
    Card deck[] = new Card[5];
    deck[0] = new Card("goose", Color.RED,
        new Position[] { new Position(-1, -1), new Position(0, -1), new Position(0, 1), new Position(1, 1) });
    deck[1] = new Card("rabbit", Color.RED,
        new Position[] { new Position(1, -1), new Position(-1, 1), new Position(0, 2) });
    deck[2] = new Card("elephant", Color.RED,
        new Position[] { new Position(-1, -1), new Position(0, -1), new Position(-1, 1), new Position(0, 1) });
    deck[3] = new Card("frog", Color.RED,
        new Position[] { new Position(-1, -1), new Position(0, -2), new Position(1, 1) });
    deck[4] = new Card("rooster", Color.RED,
        new Position[] { new Position(0, -1), new Position(0, 1), new Position(1, -1), new Position(-1, 1) });

    GameImpl gameImpl = new GameImpl("Vermelho", "Azul", deck);
    Position[] positions = deck[3].getPositions();
    Position auxPosition = positions[0];
    Position ogPosition = new Position(4, 2);

    gameImpl.makeMove(deck[3], auxPosition, ogPosition);
    assertNotNull(gameImpl.getPiece(new Position(3, 1)));
  }

  @Test
  public void checkVictoryTest() {
    boolean actual = game.checkVictory(Color.BLUE);
    assertFalse(actual);
  }

}
