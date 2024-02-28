import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Pawn extends Piece {
    public Pawn(Board board, Coordinate position, Type type) {
        super(type.getType(), board.getCellAt(position));
    }

    @Override
    public boolean moveTo(Coordinate coordinate) {

        boolean moved = super.moveTo(coordinate);

        if (getCell().getCoordinate().getNumber() == 1 || getCell().getCoordinate().getNumber() == 8) {
            Cell cell = getCell();
            remove();
            if (getColor().equals(Color.BLACK))
                new Queen(cell.getBoard(), cell.getCoordinate(), Queen.Type.BLACK);
            else
                new Queen(cell.getBoard(), cell.getCoordinate(), Queen.Type.WHITE);
        }

        return moved;
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        if (getColor() == Color.BLACK)
            return getNextMovementsAsBlack();
        else
            return getNextMovementsAsWhite();
    }

    private Set<Coordinate> getNextMovementsAsWhite() {
        Set<Coordinate> posicionesCandidatas = new HashSet<>();
        Coordinate c;
        Coordinate position = getCell().getCoordinate();
        Board board = getCell().getBoard();

        // posicion delante
        c = position.up();

        if (board.contains(c) && board.getCellAt(c).getPiece() == null)
            posicionesCandidatas.add(c);

        // avanza matando
        c = position.up().left();
        if (board.contains(c)
                && (board.getCellAt(c).getPiece() != null && board.getCellAt(c).getPiece().getColor() != getColor()))
            posicionesCandidatas.add(c);

        c = position.up().right();
        if (board.contains(c)
                && (board.getCellAt(c).getPiece() != null && board.getCellAt(c).getPiece().getColor() != getColor()))
            posicionesCandidatas.add(c);

        // Si esta en la posicion inicial se le permite avanzar 2 posiciones
        if (position.getNumber() == 7) {
            c = position.up();
            if (board.contains(c) && board.getCellAt(c).getPiece() == null) {
                c = c.up();
                if (board.contains(c) && board.getCellAt(c).getPiece() == null) {
                    posicionesCandidatas.add(c);
                }
            }
        }
        return posicionesCandidatas;
    }

    private Set<Coordinate> getNextMovementsAsBlack() {
        Set<Coordinate> posicionesCandidatas = new HashSet<>();
        Coordinate c;
        Coordinate position = getCell().getCoordinate();
        Board board = getCell().getBoard();

        // posicion delante
        c = position.down();

        if (board.contains(c) && board.getCellAt(c).getPiece() == null)
            posicionesCandidatas.add(c);

        // avanza matando
        c = position.down().left();
        if (board.contains(c)
                && (board.getCellAt(c).getPiece() != null && board.getCellAt(c).getPiece().getColor() != getColor()))
            posicionesCandidatas.add(c);

        c = position.down().right();
        if (board.contains(c)
                && (board.getCellAt(c).getPiece() != null && board.getCellAt(c).getPiece().getColor() != getColor()))
            posicionesCandidatas.add(c);

        // Si esta en la posicion inicial se le permite avanzar 2 posiciones
        if (position.getNumber() == 2) {
            c = position.down();
            if (board.contains(c) && board.getCellAt(c).getPiece() == null) {
                c = c.down();
                if (board.contains(c) && board.getCellAt(c).getPiece() == null) {
                    posicionesCandidatas.add(c);
                }
            }
        }
        return posicionesCandidatas;
    }

    public enum Type {
        BLACK(Piece.Type.BLACK_PAWN), WHITE(Piece.Type.WHITE_PAWN);
        private Piece.Type type;

        Type(Piece.Type type) {
            this.type = type;
        }

        public Piece.Type getType() {
            return type;
        }
    }
}
