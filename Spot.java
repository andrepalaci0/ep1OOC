
/**
 * Classe contendo ações e informações sobre cada espaço (quadrado) no tabuleiro
 */

public class Spot {

    /**
     * Construtor para espaços com peça e com cor
     * 
     * @param piece Peça que inicia nesse espaço do tabuleiro
     * @param pos   Posição do espaço no tabuleiro
     * @param color Cor do espaço no tabuleiro (Templo)
     */

    private Position pos;
    private Piece piece;
    private Color color;

    public Spot(Piece piece, Position pos, Color color) {
        this.pos = pos;
        this.piece = piece;
        this.color = color;
    }

    /**
     * Construtor para espaços com peça e sem cor
     * 
     * @param piece Peça que inicia nesse espaço do tabuleiro
     * @param pos   Posição do espaço no tabuleiro
     */

    public Spot(Piece piece, Position pos) {
        this.piece = piece;
        this.pos = pos;
    }

    /**
     * Construtor para espaços sem peça e sem cor
     * 
     * @param pos Posição do espaço no tabuleiro
     */

    public Spot(Position pos) {
        this.pos = pos;
    }

    /**
     * Método que devolve a posição (coordenadas) do espaço
     * 
     * @return Objeto Position contendo a posição (coordenadas) do espaço
     */

    public Position getPosition() {
        return this.pos;
    }

    /**
     * Método que devolve a peça contida neste espaço
     * 
     * @return Objeto Piece caso tenha uma peça ou null caso o espaço esteja vazio
     */

    public Piece getPiece() {
        return this.piece;
    }

    /**
     * Método que devolve a cor do espaço
     * 
     * @return Enum Color com a cor do espaço. Caso o espaço não tenha cor, o valor
     *         do enum será NONE
     */

    public Color getColor() {
        return this.color;
    }

    /**
     * Método que ocupa o espaço atual com a peça passada
     * 
     * @param piece A peça para ocupar este espaço
     * @exception IllegalMovementException Caso o espaço já esteja ocupado por uma
     *                                     peça da mesma cor
     */

    protected void occupySpot(Piece piece) throws IllegalMovementException {
        if (this.piece == null) {
            this.piece = piece;
            return;
        }
        if (this.piece.getColor() == piece.getColor()) {
            throw new IllegalMovementException(
                    "Invalid movement: A piece with the same color already occupies this spot");
        } else {
            // acho que tem que fazer alguma coisa aqui pra mostrar que a peça vai ta
            // comendo outra
            if (this.piece != null) {
                this.piece = piece; // COMEU UMA PEÇA
                return;
            }
        }
    }

    /**
     * Método que "libera" o espaço atual, ou seja, deixa-o vazio
     */

    protected void releaseSpot() {
        this.piece = null;

    }

    public static Spot[][] createBoard() {

        Spot[][] board = new Spot[5][5];

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {

                if (i == 0) { // parte de cima do tabuleiro (espaco para as pecas azuis)
                    if (j == 2) {
                        board[i][j] = new Spot(new Piece(Color.BLUE, true), new Position(i, j), Color.BLUE);
                    } else {
                        board[i][j] = new Spot(new Piece(Color.BLUE, false), new Position(i, j), Color.NONE);

                    }

                }else if (i == 4) { // parte de baixo do tabuleiro (espaco para as pecas vermelhas)

                    if (j == 2) {
                        board[i][j] = new Spot(new Piece(Color.RED, true), new Position(i, j), Color.RED);

                    } else {
                        board[i][j] = new Spot(new Piece(Color.RED, false), new Position(i, j), Color.NONE);

                    }

                }else {
                    board[i][j] = new Spot(new Position(i, j));

                }

            }

        }

        return board;

    }

}
