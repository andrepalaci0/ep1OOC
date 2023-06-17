package ep1OOC;
/**
 * Classe que contém informações e ações básicas relacionadas aos jogadores
 */
public class Player {

    /**
     * Construtor que define informações básicas do jogador
     * @param name Nome do jogador
     * @param pieceColor Cor das peças do jogador
     * @param cards Cartas na mão do jogador
     */

    private String playerName;
    private Color pieceColor;
    private Card[] cards;
    private boolean starter;

    public Player(String name, Color pieceColor, Card[] cards) {
        this.playerName = name;
        this.pieceColor = pieceColor;
        this.cards[0] = cards[0];
        this.cards[1] = cards [1];
    }

    /**
     * Construtor que define informações básicas do jogador
     * @param name Nome do jogador
     * @param pieceColor Cor das peças do jogador
     * @param card1 A primeira carta na mão do jogador
     * @param card2 A segunda carta na mão do jogador
     */

    public Player(String name, Color pieceColor, Card card1, Card card2) {
        this.playerName = name;
        this.pieceColor = pieceColor;
        this.cards[2] = card1;
        this.cards[1] = card2; //pq isso ta assim?
    }

    /**
     * Método que devolve o nome do jogador(a)
     * @return String com o nome do jogador(a)
     */

    public String getName() {
        if(this.playerName != null) return this.playerName;
        return null;
    }

    /**
     * Método que devolve a cor das peças do jogador
     * @return Enum Color com a cor das peças do jogador
     */

    public Color getPieceColor() {
        if(this.pieceColor != null) return this.pieceColor;
        return null;
    }

    /**
     * Método que devolve as cartas da mão do jogador
     * @return Booleano true para caso seja um mestre e false caso contrário
     */

    public Card[] getCards() {
        return this.cards;
    }


    public void setStarter()
    {
        this.starter = true;
    }

    public boolean isStarter()
    {
        return this.starter;
    }
    /**
     * Método que troca uma carta da mão por outra carta (idealmente da mesa)
     * @param oldCard A carta que será substituída
     * @param newCard A carta que irá substituir
     * @exception InvalidCardException Caso a carta não esteja na mão do jogador e/ou na mesa
     */

    protected void swapCard(Card oldCard, Card newCard) throws InvalidCardException {

        boolean inHand = false;
        int pos = 0;

        for (int i = 0; i < cards.length; i++) {
            if(this.cards[i] == oldCard){
                inHand = true;
                pos = i;
            }
        }

        if(!inHand) throw new InvalidCardException("Carta não está na mão do jogador");

        //nao sei como conferir se a carta ta na mesa
        
        this.cards[pos] = newCard;

    }


}
