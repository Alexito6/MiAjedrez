import java.util.Set;
import java.util.TreeSet;

public class King extends Piece {
    public King(Board board, Coordinate position, Type type) {
        super(type.getType(), board.getCellAt(position));
    }

    @Override
    public Set<Coordinate> getNextMovements() {

        Coordinate position = getCell().getCoordinate();
        Set<Coordinate> posicionesCandidatas = new TreeSet<>();

        if (canAddToNextMovements(position.up()))
            posicionesCandidatas.add(position);

        if (canAddToNextMovements(position.up().right()))
            posicionesCandidatas.add(position);

        if (canAddToNextMovements(position.right()))
            posicionesCandidatas.add(position);

        if (canAddToNextMovements(position.down().right()))
            posicionesCandidatas.add(position);

        if (canAddToNextMovements(position.down()))
            posicionesCandidatas.add(position);

        if (canAddToNextMovements(position.down().left()))
            posicionesCandidatas.add(position);

        if (canAddToNextMovements(position.left()))
            posicionesCandidatas.add(position);

        if (canAddToNextMovements(position.up().left()))
            posicionesCandidatas.add(position);

        return posicionesCandidatas;
    }

    public enum Type {
        BLACK(Piece.Type.BLACK_KING), WHITE(Piece.Type.WHITE_KING);
        private Piece.Type type;

        Type(Piece.Type type) {
            this.type = type;
        }

        public Piece.Type getType() {
            return type;
        }
    }
}
