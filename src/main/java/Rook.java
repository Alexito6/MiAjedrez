import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Rook extends Piece {
    public Rook(Board board, Coordinate position, Type type) {
        super(type.getType(), board.getCellAt(position));
    }

    //put your task here
    public Set<Coordinate> getNextMovements(){
        return getNextMovementsAsRook(this);
    }

    //put your task here
    public static Set<Coordinate> getNextMovementsAsRook(Piece piece) {

        Set<Coordinate> posicionesCandidatas = new HashSet<>();
        Coordinate posicion = piece.getCell().getCoordinate();
        Coordinate c;
        Board board = piece.getCell().getBoard();

        // Comprobamos que la ficha este en el tablero
        if (posicion == null)
            return posicionesCandidatas;

        // Arriba
        c = posicion;
        do {
            c = c.up();
            if (piece.canAddToNextMovements(c))
                posicionesCandidatas.add(c);
        } while (board.contains(c) && board.getCellAt(c).getPiece() == null);

        // Derecha
        c = posicion;
        do {
            c = c.right();
            if (piece.canAddToNextMovements(c))
                posicionesCandidatas.add(c);
        } while (board.contains(c) && board.getCellAt(c).getPiece() == null);

        // Izquierda
        c = posicion;
        do {
            c = c.left();
            if (piece.canAddToNextMovements(c))
                posicionesCandidatas.add(c);
        } while (board.contains(c) && board.getCellAt(c).getPiece() == null);

        // Abajo
        c = posicion;
        do {
            c = c.down();
            if (piece.canAddToNextMovements(c))
                posicionesCandidatas.add(c);
        } while (board.contains(c) && board.getCellAt(c).getPiece() == null);

        return posicionesCandidatas;
    }

    public enum Type {
        BLACK(Piece.Type.BLACK_ROOK), WHITE(Piece.Type.WHITE_ROOK);
        private Piece.Type type;

        Type(Piece.Type type) {
            this.type = type;
        }

        public Piece.Type getType() {
            return type;
        }
    }
}