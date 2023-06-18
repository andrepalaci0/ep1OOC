package codes;

public class main{
    public static void main (String[] args) {
        GameImpl gameImpl = new GameImpl("Vermelho", "Azul");
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
        gameImpl.printTest();
        System.out.println(gameImpl.checkVictory(Color.NONE));
        System.out.println(gameImpl.getTableCard().getName());
    }
}