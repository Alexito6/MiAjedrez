import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Bishop extends Piece {
    public Bishop(Board board, Coordinate position, Type type) {
        super(type.getType(), board.getCellAt(position));
    }

    public Set<Coordinate> getNextMovements(){
        return getNextMovementsAsBishop(this);
    }

    public static Set<Coordinate> getNextMovementsAsBishop(Piece piece) {

        Set<Coordinate> posicionesCandidatas = new HashSet<>();
        Coordinate posicion = piece.getCell().getCoordinate();
        Coordinate c;
        Board board = piece.getCell().getBoard();

        // Comprobamos que la ficha este en el tablero
        if (posicion == null)
            return posicionesCandidatas;

        // Diagonal superior izq
        c = posicion;
        do {
            c = c.up().left();
            if (piece.canAddToNextMovements(c))
                posicionesCandidatas.add(c);

        } while (board.contains(c) && board.getCellAt(c).getPiece() == null);

        // Diagonal superior der
        c = posicion;
        do {
            c = c.up().right();
            if (piece.canAddToNextMovements(c))
                posicionesCandidatas.add(c);
        } while (board.contains(c) && board.getCellAt(c).getPiece() == null);

        // Diagonal inferior izq
        c = posicion;
        do {
            c = c.down().left();
            if (piece.canAddToNextMovements(c))
                posicionesCandidatas.add(c);
        } while (board.contains(c) && board.getCellAt(c).getPiece() == null);

        // Diagonal inferior der
        c = posicion;
        do {
            c = c.down().right();
            if (piece.canAddToNextMovements(c))
                posicionesCandidatas.add(c);
        } while (board.contains(c) && board.getCellAt(c).getPiece() == null);

        return posicionesCandidatas;
    }

    public enum Type {
        BLACK(Piece.Type.BLACK_BISHOP), WHITE(Piece.Type.WHITE_BISHOP);
        private Piece.Type type;

        Type(Piece.Type type) {
            this.type = type;
        }

        public Piece.Type getType() {
            return type;
        }
    }
}