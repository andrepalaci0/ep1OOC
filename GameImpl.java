package ep1OOC;

public class GameImpl implements Game {

    private Player player1, player2;
    private Card tableCard;
    private Card cards[];
    private Spot board[][];
    private int roundCounter = 0;

    /**
     * Construtor que inicia o jogo as configuracoes basicas do tabuleiro
     */

    public GameImpl() {

        this.cards = Card.createCards();
        this.board = Spot.createBoard();
        this.player1 = new Player("redPlayer", Color.RED, this.cards[1], this.cards[3]);
        this.player2 = new Player("bluePlayer", Color.BLUE, this.cards[0], this.cards[2]);
        this.tableCard = this.cards[4];
        if (this.tableCard.getColor() == Color.RED)
            player1.setStarter();
        else
            player2.setStarter();
        return;
    }

    /**
     * @param nomeAzul     Nome do jogador azul
     * @param nomeVermelho Nome do jogador vermelho
     */

    public GameImpl(String nomeVermelho, String nomeAzul) { // tem que conferir a questão das cartas, p ver qual jogador
                                                            // começa
        this.cards = Card.createCards();
        this.board = Spot.createBoard();
        this.player1 = new Player(nomeVermelho, Color.RED, this.cards[1], this.cards[3]);
        this.player2 = new Player(nomeAzul, Color.BLUE, this.cards[0], this.cards[2]);
        this.tableCard = this.cards[4];
        if (this.tableCard.getColor() == Color.RED)
            player1.setStarter();
        else
            player2.setStarter();

        return;

    }

    public GameImpl(String nomeVermelho, String nomeAzul, Card newDeck[]) throws InvalidCardException {
        if (newDeck.length < 5)
            throw new InvalidCardException("Invalid Card Deck, too small"); // criar uma exception pro deck?
        for (int i = 0; i < newDeck.length; i++) {
            // confere se o deck esta completo
            if (newDeck[i] == null)
                throw new InvalidCardException("Invalid Card Deck: deck has empty spaces");
        }
        this.cards = newDeck;
        this.board = Spot.createBoard();
        this.player1 = new Player(nomeVermelho, Color.RED, this.cards[1], this.cards[3]);
        this.player2 = new Player(nomeAzul, Color.BLUE, this.cards[0], this.cards[2]);
        this.tableCard = this.cards[4];
        if (this.tableCard.getColor() == Color.RED)
            player1.setStarter();
        else
            player2.setStarter();

        return;
    }

    /**
     * Método que devolve a cor da posição do tabuleiro. Se possui uma cor,
     * significa que é um templo. Caso contrário, é um espaço normal
     * 
     * @param position Posição do tabuleiro
     * @return O enum Color que representa a cor da posição
     */

    public Color getSpotColor(Position position) {

        if (position.getCol() == 2) {

            if (position.getRow() == 0)
                return Color.BLUE;
            if (position.getRow() == 4)
                return Color.RED;

        }

        return Color.NONE;

    }

    /**
     * Método que devolve a peça que está na posição do tabuleiro
     * 
     * @param position Posição do tabuleiro
     * @return Um objeto Piece que representa a peça na posição indicada. Se não
     *         tiver peça, devolve null
     */

    public Piece getPiece(Position position) {

        return board[position.getRow()][position.getCol()].getPiece();

    }

    /**
     * Método que devolve a carta que está na mesa, que será substituída após a
     * próxima jogada
     * 
     * @return Um objeto Card que representa a carta na mesa
     */

    public Card getTableCard() {
        return this.tableCard;
    }

    /**
     * Método que devolve as informações sobre o jogador com as peças vermelhas
     * 
     * @return Um objeto Player que representa o jogador vermelho
     */

    public Player getRedPlayer() {
        if (player1.getPieceColor() == Color.RED)
            return player1;
        else
            return player2;
    }

    /**
     * Método que devolve as informações sobre o jogador com as peças azuis
     * 
     * @return Um objeto Player que representa o jogador azul
     */

    public Player getBluePlayer() {
        if (player1.getPieceColor() == Color.BLUE)
            return player1;
        else
            return player2;
    }

    /**
     * Método que move uma peça
     * 
     * @param card       A carta de movimento que será usada
     * @param cardMove   A posição da carta para onde a peça irá se mover
     * @param currentPos A posição da peça que irá se mover
     * @exception IncorrectTurnOrderException Caso não seja a vez de um jogador
     *                                        fazer um movimento
     * @exception IllegalMovementException    Caso uma peça seja movida para fora do
     *                                        tabuleiro ou para uma posição onde já
     *                                        tem uma peça da mesma cor
     * @exception InvalidCardException        Caso uma carta que não está na mão do
     *                                        jogador seja usada
     * @exception InvalidPieceException       Caso uma peça que não está no
     *                                        tabuleiro seja usada
     */

    public void makeMove(Card card, Position cardMove, Position currentPos)
            throws IncorrectTurnOrderException, IllegalMovementException, InvalidCardException, InvalidPieceException {
        /*
         * 
         * 
         * Talvez a lógica da função moveValidation esteja incompleta, necessária
         * revisão. Sim ta incompleto, tem q fazer a validação no comment de baixo
         * 
         * inclusive nem existe mais moveValidation
         */

        if (card == null || cardMove == null || currentPos == null)
            throw new IllegalMovementException("Invalid input");
        if (board[currentPos.getRow()][currentPos.getCol()].getPiece() == null)
            throw new InvalidPieceException("No piece in the current position");

        int auxCol = currentPos.getCol() + cardMove.getCol();
        int auxRow = currentPos.getRow() + cardMove.getRow();
        /*
         * tem que fazer uma validação se o movimento que ele ta pedindo pra realizar
         * é um dos movimentos que a carta permite fazer e, se não for, lançar exception
         */
        /*
         * validacao do movimento logo abaixo (FALTA TESTAR)
         */

        boolean validMove = false;
        Position posAux[] = card.getPositions();

        for (int i = 0; i < posAux.length; i++)
            if (posAux[i] == cardMove)
                validMove = true;

        if (validMove == false)
            throw new IllegalMovementException("The moviment in cardMove doesn't exist in card");

        if (auxCol > 4 || auxCol < 0)
            throw new IllegalMovementException("Col coordinate exceeds board limits");
        if (auxRow > 4 || auxRow < 0)
            throw new IllegalMovementException("Row coordinate exceeds boards limits");
        if (board[currentPos.getRow()][currentPos.getCol()].getPiece() != null && board[auxRow][auxCol]
                .getPiece() != null) {
            if (board[currentPos.getRow()][currentPos.getCol()].getPiece().getColor() == board[auxRow][auxCol]
                    .getPiece().getColor())
                throw new IllegalMovementException("Trying to move into a same team piece");
        }
        boolean isRoundValid = roundValidation(currentPos);
        if (!isRoundValid)
            throw new IncorrectTurnOrderException("Wrong player trying to make a movement");

        Color playerColor = board[currentPos.getRow()][currentPos.getCol()].getPiece().getColor();
        Player player;
        if (playerColor == Color.BLUE)
            player = getBluePlayer();
        else
            player = getRedPlayer();
        int cardIndex = -1;
        for (int i = 0; i < player.getCards().length; i++) {
            if (player.getCards()[i] == card)
                cardIndex = i;
        }
        if (cardIndex == -1)
            throw new InvalidCardException("Player dont have the card selected in his inventory");

        // a jogada de vdd so acontece a partir daqui

        Piece auxPiece = board[currentPos.getRow()][currentPos.getCol()].getPiece();
        board[currentPos.getRow()][currentPos.getCol()].releaseSpot();
        board[auxRow][auxCol].occupySpot(auxPiece);
        player.swapCard(card, this.tableCard);
        this.tableCard = card;

    }

    /**
     * Método que confere se um jogador de uma determinada cor venceu o jogo.
     * Critérios de vitória:
     * — Derrotou a peça de mestre adversária
     * — Posicionou o seu mestre na posição da base adversária
     * 
     * @param color Cor das peças do jogador que confere a condição de vitória
     * @return Um booleano true para caso esteja em condições de vencer e false caso
     *         contrário
     */

    public boolean checkVictory(Color color) {
        if (color == Color.NONE)
            return false;
        Color enemColor; // Definindo a cor do inimigo para fins de comparação
        if (color == Color.BLUE)
            enemColor = Color.RED;
        else
            enemColor = Color.BLUE;
        boolean enemMasterAlive = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) { // tenta encontrar o master inimigo
                if (this.board[i][j].getPiece() != null) {
                    if (this.board[i][j].getPiece().isMaster() && this.board[i][j].getPiece().getColor() == enemColor)
                        enemMasterAlive = true;
                }
            }
        }
        if (!enemMasterAlive) {
            return true; // se não encontrado o master inimigo, aconteceu a vitoria
        }
        if (enemColor == Color.BLUE) { // confere se peças inimigas não estão no templo
            if (this.board[0][2].getPiece() == null)
                return false;
            if (this.board[0][2].getPiece().getColor() == Color.RED && this.board[0][2].getPiece().isMaster())
                return true;
            else
                return false;
        } else if (enemColor == Color.RED) {
            if (this.board[4][2].getPiece() == null)
                return false;
            if (this.board[4][2].getPiece().getColor() == Color.BLUE && this.board[4][2].getPiece().isMaster())
                return true;
        }
        return false;
    }

    /**
     * Funcao que recebe a posição da peça e analisa se a peça que está tentando
     * se mover está tentando no turno certo
     * 
     * @param currentPosition Posição da peça no tabuleiro
     * @return falso caso o turno esteja errado, verdadeiro caso esteja correto
     */
    private boolean roundValidation(Position currentPosition) {
        Player currentPlayer;
        if (board[currentPosition.getRow()][currentPosition.getCol()].getPiece().getColor() == getBluePlayer()
                .getPieceColor())
            currentPlayer = getBluePlayer();
        else
            currentPlayer = getRedPlayer();

        // primeira rodada
        if (this.roundCounter == 0 && currentPlayer.isStarter()) {
            this.roundCounter++;
            return true;
        }
        if (this.roundCounter == 0 && !currentPlayer.isStarter())
            return false; // jogada invalida, jogador errado esta tentando começar

        // demais rodadas
        if (this.roundCounter % 2 == 1 && !currentPlayer.isStarter()) {
            this.roundCounter++;
            return true;
        } else if (this.roundCounter % 2 == 0 && currentPlayer.isStarter()) {
            this.roundCounter++;
            return true;
        }
        return false;
    }

    /**
     * Método que imprime o tabuleiro no seu estado atual
     * OBS: Esse método é opcional não será utilizado na correção, mas serve para
     * acompanhar os resultados parciais do jogo
     */
    public void printTest() {
        System.out.println(getTableCard().getName());
    }

    public void printBoard() {

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board.length; j++) {

                if (board[i][j].getPiece() == null) {
                    System.out.print("00 ");

                } else if (board[i][j].getPiece().isMaster()) {

                    if (board[i][j].getPiece().getColor() == Color.BLUE)
                        System.out.print("BM ");
                    if (board[i][j].getPiece().getColor() == Color.RED)
                        System.out.print("RM ");

                } else if (board[i][j].getPiece() != null) {

                    if (board[i][j].getPiece().getColor() == Color.BLUE)
                        System.out.print("BP ");
                    if (board[i][j].getPiece().getColor() == Color.RED)
                        System.out.print("RP ");

                }

            }
            System.out.println();
        }

    }

    /**
     * Método que inicializa o tabuleiro já com as peças
     * 
     * @param board tabuleiro ainda nao inicializado
     * @return tabuleiro inicializado, já com as peças dos jogadores e lugares
     *         vazios
     */

    // fim da classe
}