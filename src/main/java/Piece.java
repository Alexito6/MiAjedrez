import com.diogonunes.jcolor.Attribute;

import java.util.*;

import static com.diogonunes.jcolor.Ansi.colorize;

public abstract class Piece {

    private Type type;
    private Cell cell;
    public Piece(Type type, Cell cell){
        this.type = type;
        this.cell = cell;
        place();
    }

    protected void place() {
        if(cell!=null)
            cell.setPiece(this);
    }

    protected boolean canAddToNextMovements(Coordinate c) {

        Board board = getCell().getBoard();

        if(!board.contains(c)) return false;

        if(board.getCellAt(c).isEmpty()) return true;

        if(board.getCellAt(c).getPiece().getColor()!=getColor()) return true;

        return false;
    }

    public boolean canMoveTo(Coordinate coordinate){
        boolean encontrado=false;
        List<Coordinate> posicionesCandidatas=new ArrayList<>(getNextMovements());
        int i=0;
        while (!encontrado && i<posicionesCandidatas.size()){
            if(posicionesCandidatas.get(i++).equals(coordinate))
                encontrado=true;
        }
        return encontrado;
    }

    public void remove() {
        if (cell != null){
            cell.setPiece(null);
        }
        cell = null;
    }

    public boolean moveTo(Coordinate coordinate){
        if(cell == null) return false;
        if(!canMoveTo(coordinate)) return false;

        Cell destination = cell.getBoard().getCellAt(coordinate);

        if(!destination.isEmpty())
            destination.getPiece().remove();

        cell.setPiece(null);
        cell = destination;

        place();

        return true;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Type getType() {
        return type;
    }

    public Cell getCell() {
        return cell;
    }

    public Color getColor(){
        return type.getColor();
    }


    @Override
    public String toString(){
        String resultado;

        if(cell==null){
            resultado = colorize(type.getShape(),type.getColor().getAttribute());
        }else{
            resultado = colorize(type.getShape(),type.getColor().getAttribute(),cell.getColor().getAttribute());
        }
        return resultado;
    }

    public abstract Set<Coordinate> getNextMovements();

    public enum Color {

        WHITE(Attribute.BRIGHT_WHITE_TEXT()),
        BLACK(Attribute.TEXT_COLOR(0, 0, 0));

        private Attribute color;

        Color(Attribute color) {
            this.color = color;
        }

        public Attribute getAttribute() {
            return color;
        }

    }

    public enum Type {

        WHITE_KING("♚", Color.WHITE),
        WHITE_QUEEN("♛", Color.WHITE),
        WHITE_ROOK("♜", Color.WHITE),
        WHITE_BISHOP("♝", Color.WHITE),
        WHITE_KNIGHT("♞", Color.WHITE),
        WHITE_PAWN("♟", Color.WHITE),
        BLACK_KING("♚", Color.BLACK),
        BLACK_QUEEN("♛", Color.BLACK),
        BLACK_ROOK("♜", Color.BLACK),
        BLACK_BISHOP("♝", Color.BLACK),
        BLACK_KNIGHT("♞", Color.BLACK),
        BLACK_PAWN("♟", Color.BLACK);

        private final String shape;
        private final Color color;

        Type(String shape, Color color) {
            this.shape = shape;
            this.color = color;
        }

        public String getShape() {
            return shape;
        }
        public Color getColor(){
            return color;
        }
    }

}