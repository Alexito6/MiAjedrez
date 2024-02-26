
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Queen extends Piece{
    public Queen(Board board, Coordinate position, Type type) {
        super(type.getType(), board.getCellAt(position));
    }

    //put your task here
    public Set<Coordinate> getNextMovements(){
        Set<Coordinate> posicionesCandidatas = new HashSet<>();

        for (Coordinate c : Bishop.getNextMovementsAsBishop(this))
            posicionesCandidatas.add(c);

        for (Coordinate c : Rook.getNextMovementsAsRook(this))
            posicionesCandidatas.add(c);

        return posicionesCandidatas;
    }

    public enum Type {
        BLACK(Piece.Type.BLACK_QUEEN), WHITE(Piece.Type.WHITE_QUEEN);
        private Piece.Type type;

        Type(Piece.Type type) {
            this.type = type;
        }

        public Piece.Type getType() {
            return type;
        }
    }
}
