package ep1OOC;

import java.util.Random;

/**
 * Classe que contém informações das cartas
 */

public class Card 
{
    /**
     * Construtor que define os principais atributos de uma cara
     * @param name Nome da carta
     * @param color Cor da carta
     * @param positions Todas as posições relativas de movimento
     */

    private String name;
    private Color color;
    private Position[] positions;

    public Card(String name, Color color, Position[] positions) 
    {
        this.name = name;
        this.color = color;
        this.positions = positions;

    }

    /*
     * ESSE PUBLIC STATIC CARD TA ERRADO, AINDA TEM QUE CONCERTAR 
     */

    public static Card[] cards()
    {
        Position[] tig = {new Position(0, 2), new Position(3, 2)};
        Position[] dra = {new Position(1, 0), new Position(1, 4), new Position(3, 1), new Position(3, 3)};
        Position[] fro = {new Position(1,1), new Position(2, 0), new Position(3, 3)};
        Position[] rab = {new Position(1, 3), new Position(2, 4), new Position(3, 1)};
        Position[] cra = {new Position(2, 0), new Position(1, 2), new Position(2, 4)};
        Position[] ele = {new Position(1,1), new Position(1, 3), new Position(2, 1), new Position(2, 3)};
        Position[] goo = {new Position(1, 1), new Position(2, 1), new Position(2, 1), new Position(2, 3), new Position(3,3)};
        Position[] roo = {new Position(1, 3), new Position(2, 1), new Position(2, 3), new Position(3, 1)};

    }

    Card tiger = new Card("tiger", Color.BLUE, tig);
    Card dragon = new Card("dragon", Color.RED, dra);
    Card frog = new Card("frog", Color.RED, fro);
    Card rabbit = new Card("rabbit", Color.BLUE, rab);
    Card crab = new Card("crab", Color.BLUE, cra);
    Card elephant = new Card("elephant", Color.RED, ele);
    Card goose = new Card("goose", Color.BLUE, goo);
    Card rooster = new Card("roose", Color.RED, roo);

    /**
     * Método que devolve o nome da carta
     * @return String que contém o nome da carta
     */

    public String getName() 
    {
        return this.name;

    }

    /**
     * Método que devolve a cor da carta
     * @return Enum Color que contém a cor da carta
     */

    public Color getColor() 
    {
        return this.color;

    }

    /**
     * Método que devolve todas as possíveis posições relativas de movimento.
     * A posição atual da peça é o ponto de origem (0,0). Uma carta possui as possíveis posições de movimento em relação ao ponto de origem.
     * @return Um array de Position contendo todas as possíveis posições de movimento em relação ao ponto de origem
     */

    public Position[] getPositions() 
    {
        return this.positions;

    }

    /**
     * Método que cria todas as cartas do jogo, embaralha-as e devolve as 5 que serão utilizadas na partida.
     * @return Vetor de cartas com todas as cartas do jogo
     */

    public static Card[] createCards() 
    {
        return null;

    }

}
