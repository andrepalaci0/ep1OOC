package ep1OOC;

public class GameImpl implements Game {

    private Player player1, player2;

    private Card cards[];
    private Spot board[][] = new Spot[5][5];

    /**
     * Método que devolve a cor da posição do tabuleiro. Se possui uma cor,
     * significa que é um templo. Caso contrário, é um espaço normal
     * 
     * @param position Posição do tabuleiro
     * @return O enum Color que representa a cor da posição
     */

    public GameImpl() {
        return;
    }

    /**
     * 
     * @param nomeAzul     Nome do jogador azul
     * @param nomeVermelho Nome do jogador vermelho
     */
    public GameImpl(String nomeAzul, String nomeVermelho) {
        return;
    }

    public GameImpl(String nomeAzul, String nomeVermelho, Card newDeck[]) {
        return;
    }

    public

            Color getSpotColor(Position position) {
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

    Card getTableCard();

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
    void makeMove(Card card, Position cardMove, Position currentPos)
            throws IncorrectTurnOrderException, IllegalMovementException, InvalidCardException, InvalidPieceException {
                moveValidation(cardMove, currentPos);
    }

    private boolean moveValidation(Position cardMove, Position currentPosition)
    {   
        int auxCol = currentPosition.getCol() + cardMove.getCol();
        int auxRow = currentPosition.getRow() + cardMove.getRow();
        if(auxCol > 4 || auxCol < 0) return false;
        if(auxRow > 4 || auxCol < 0) return false;        
        if(board[currentPosition.getRow()][currentPosition.getCol()].getPiece().getColor() == board[auxRow][auxCol].getPiece().getColor()) return false;
        return true;
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

    boolean checkVictory(Color color);

    /**
     * Método que imprime o tabuleiro no seu estado atual
     * OBS: Esse método é opcional não será utilizado na correção, mas serve para
     * acompanhar os resultados parciais do jogo
     */
    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].getPiece().isMaster()) {
                    if (board[i][j].getPiece().getColor() == Color.BLUE)
                        System.out.print("BM ");
                    if (board[i][j].getPiece().getColor() == Color.RED)
                        System.out.print("RM ");

                }
                if (board[i][j].getPiece() != null) {
                    if (board[i][j].getPiece().getColor() == Color.BLUE)
                        System.out.print("BP ");
                    if (board[i][j].getPiece().getColor() == Color.RED)
                        System.out.print("RP ");
                } else {
                    System.out.print("00 ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Método que inicializa o tabuleiro já com as peças
     * 
     * @param board tabuleiro ainda nao inicializado
     * @return tabuleiro inicializado, já com as peças e lugares vazios
     */
    private Spot[][] initializeBoard(Spot board[][]) {
        for (int i = 0; i < board.length; i++) {
            Piece auxPiece;
            boolean isMaster = false;
            for (int j = 0; j < board.length; j++) {
                Position auxPos = new Position(i, j);
                if (i == 0) { // pecas azuis
                    Color auxColor = Color.BLUE;
                    if (j == 2) {
                        isMaster = true;
                        auxPiece = new Piece(auxColor, isMaster);
                        board[i][j] = new Spot(auxPiece, auxPos, auxColor);
                    } else {
                        auxPiece = new Piece(auxColor, isMaster);
                        board[i][j] = new Spot(auxPiece, auxPos);
                    }
                }
                if (i == 4) { // pecas vermelhas
                    Color auxColor = Color.RED;
                    if (j == 2) {
                        isMaster = true;
                        auxPiece = new Piece(auxColor, isMaster);
                        board[i][j] = new Spot(auxPiece, auxPos, auxColor);
                    } else {
                        auxPiece = new Piece(auxColor, isMaster);
                        board[i][j] = new Spot(auxPiece, auxPos);
                    }
                }
                // lugares vazios
                board[i][j] = new Spot(auxPos);
            }
        }
        return board;
    }

    // fim da classe
}