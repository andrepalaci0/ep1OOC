package codes;

import java.util.ArrayList;
import java.util.List;

import java.util.Collections;

/**
 * Classe que contém informações das cartas
 */

public class Card {

    /**
     * Construtor que define os principais atributos de uma carta
     * @param name Nome da carta
     * @param color Cor da carta
     * @param positions Todas as posições relativas de movimento
     */

    private final String name;
    private final Color color;
    private final Position[] positions;

    public Card(String name, Color color, Position[] positions) {

        this.name = name;
        this.color = color;
        this.positions = positions;

    }

    /**
     * Método que devolve o nome da carta
     * @return String que contém o nome da carta
     */

    public String getName() {

        return this.name;

    }

    /**
     * Método que devolve a cor da carta
     * @return Enum Color que contém a cor da carta
     */

    public Color getColor() {

        return this.color;

    }

    /**
     * Método que devolve todas as possíveis posições relativas de movimento.
     * A posição atual da peça é o ponto de origem (0,0). Uma carta possui as possíveis posições de movimento em relação ao ponto de origem.
     * @return Um array de Position contendo todas as possíveis posições de movimento em relação ao ponto de origem
     */

    public Position[] getPositions() {

        return this.positions;

    }

    /**
     * Método que cria todas as cartas do jogo, embaralha-as e devolve as 5 que serão utilizadas na partida.
     * @return Vetor de cartas com todas as cartas do jogo
     */

    public static Card[] createCards() {

        Card[] gameCards = new Card[5];

        List<Card> allCards = new ArrayList<Card>();

        allCards.add(new Card("tiger", Color.BLUE, new Position[]{new Position(1, 0), new Position(-2, 0)}));
        allCards.add(new Card("crab", Color.BLUE, new Position[]{new Position(0, -2), new Position(-1, 0), new Position(0, 2)}));
        allCards.add(new Card("goose", Color.BLUE, new Position[]{new Position(-1, -1), new Position(0, -1), new Position(0, 1), new Position(1, 1)}));
        allCards.add(new Card("rabbit", Color.BLUE, new Position[]{new Position(1, -1), new Position(-1, 1), new Position(0, 2)}));
        allCards.add(new Card("elephant", Color.RED, new Position[]{new Position(-1, -1), new Position(0, -1), new Position(-1, 1), new Position(0, 1)}));
        allCards.add(new Card("frog", Color.RED, new Position[]{new Position(-1, -1), new Position(0, -2), new Position(1, 1)}));
        allCards.add(new Card("rooster", Color.RED, new Position[]{new Position(0, -1), new Position(0, 1), new Position(1, -1), new Position(-1, 1)}));
        allCards.add(new Card("dragon", Color.RED, new Position[]{new Position(1, -1), new Position(1, 1), new Position(-1, -2), new Position(-1, 2)}));

		Collections.shuffle(allCards);

        for (int i = 0; i < 5; i++) {
            
            gameCards[i] = allCards.get(i); allCards.get(i);

        }
        
        return gameCards;

    }

}
