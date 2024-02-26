import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Knight extends Piece {

    public Knight(Board board, Coordinate position, Type type) {
        super(type.getType(), board.getCellAt(position));
    }

    public Set<Coordinate> getNextMovements() {

        Set<Coordinate> posicionesCandidatas = new HashSet<>();

        Coordinate myPosition = getCell().getCoordinate();
        Coordinate c;

        //Up
        c = myPosition.up().up().left();
        if(canAddToNextMovements(c)) posicionesCandidatas.add(c);

        c = myPosition.up().up().right();
        if(canAddToNextMovements(c)) posicionesCandidatas.add(c);

        //Down
        c = myPosition.down().down().left();
        if(canAddToNextMovements(c)) posicionesCandidatas.add(c);

        c = myPosition.down().down().right();
        if(canAddToNextMovements(c)) posicionesCandidatas.add(c);

        //Left
        c = myPosition.left().left().up();
        if(canAddToNextMovements(c)) posicionesCandidatas.add(c);

        c = myPosition.left().left().down();
        if(canAddToNextMovements(c)) posicionesCandidatas.add(c);

        //Right
        c = myPosition.right().right().up();
        if(canAddToNextMovements(c)) posicionesCandidatas.add(c);

        c = myPosition.right().right().down();
        if(canAddToNextMovements(c)) posicionesCandidatas.add(c);


        return posicionesCandidatas;
    }

    public enum Type {
        BLACK(Piece.Type.BLACK_KNIGHT), WHITE(Piece.Type.WHITE_KNIGHT);
        private Piece.Type type;

        Type(Piece.Type type) {
            this.type = type;
        }

        public Piece.Type getType() {
            return type;
        }
    }
}
