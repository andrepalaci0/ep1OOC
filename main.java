package ep1OOC;

public class main{
    public static void main(String[] args) {

        Card deck[] = new Card[5]; 
        //new Card("tiger", Color.BLUE, new Position[]{new Position(1, 0), new Position(-2, 0)});
        //new Card("crab", Color.BLUE, new Position[]{new Position(0, -2), new Position(-1, 0), new Position(0, 2)});
        //new Card("dragon", Color.RED, new Position[]{new Position(1, -1), new Position(1, 1), new Position(-1, -2), new Position(-1, 2)});
       
        deck [0] = new Card("goose", Color.BLUE, new Position[]{new Position(-1, -1), new Position(0, -1), new Position(0, 1), new Position(1, 1)});
        deck [1] = new Card("rabbit", Color.BLUE, new Position[]{new Position(1, -1), new Position(-1, 1), new Position(0, 2)});
        deck [2] = new Card("elephant", Color.RED, new Position[]{new Position(-1, -1), new Position(0, -1), new Position(-1, 1), new Position(0, 1)});
        deck [3] = new Card("frog", Color.RED, new Position[]{new Position(-1, -1), new Position(0, -2), new Position(1, 1)});
        deck [4] = new Card("rooster", Color.RED, new Position[]{new Position(0, -1), new Position(0, 1), new Position(1, -1), new Position(-1, 1)});


        GameImpl gameImpl = new GameImpl("Vermelho", "Azul", deck);
        System.out.println(gameImpl.getRedPlayer().getName());
        System.out.println(gameImpl.getBluePlayer().getName());
        //Card cards[] = gameImpl.getBluePlayer().getCards();
        //for (int i = 0; i < cards.length; i++) {
        //    System.out.println(cards[i]);
        //    Position positions[] = cards[i].getPositions();
        //    for (int j = 0; j < positions.length; j++) {
        //        System.out.println(positions[j].getRow());
        //        System.out.println(positions[j].getCol());
        //    }
        //}
        gameImpl.printBoard();
        //gameImpl.printTest();
        System.out.println(gameImpl.checkVictory(Color.NONE));
        //System.out.println(gameImpl.getTableCard().getName());
        System.out.println("TABLE CARD COLOR:"+ gameImpl.getTableCard().getColor());
        System.out.println("TABLE CARD: " + gameImpl.getTableCard().getName());
        Player redPlayer = gameImpl.getRedPlayer();
        Card redCards[] = redPlayer.getCards();
        for (int i = 0; i < redCards.length; i++) {
            System.out.println("RED CARDS: "+ redCards[i].getName());
        }
        Position[] positions = deck[3].getPositions();
        //System.out.println(deck[3].getName());
        Position auxPosition = positions[0];
        Position ogPosition = new Position(4, 2);
        
        gameImpl.makeMove(deck[3], auxPosition, ogPosition);
        gameImpl.printBoard();
        System.out.println("TABLE CARD: " + gameImpl.getTableCard().getName());

        //Position testPosition1 = new Position(3,1);
        //gameImpl.makeMove(deck[3], auxPosition, testPosition1);
        Player bluePlayer = gameImpl.getBluePlayer();
        Card blueCards[] = gameImpl.getBluePlayer().getCards();

    }
}