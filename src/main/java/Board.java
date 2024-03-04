import java.util.*;

public class Board {

    private Map<Coordinate,Cell> cells;

    public Board(){
        cells = new LinkedHashMap<>();

        for (int row=1;row<= 8;row++)
            for(char col='A';col<='H';col++)
                cells.put(new Coordinate(col,row),new Cell(this,new Coordinate(col,row)));

    }
    public boolean contains(Coordinate c) {
        return (cells.containsKey(c));
    }
    public List<Piece> getPiezas(){
        List<Piece> piezas=new ArrayList<>();
        for (Cell c:cells.values()){
            if (!c.isEmpty()){
                piezas.add(c.getPiece());
            }
        }
        return piezas;
    }
    public boolean hayReyes(){
        boolean reyBlancoVivo=false;
        boolean reyNegroVivo=false;
        Piece.Type reyBlanco= Piece.Type.WHITE_KING;
        Piece.Type reyNegro= Piece.Type.BLACK_KING;
        for (Cell c : cells.values()) {
            if (!c.isEmpty()){
                if (c.getPiece().getType() == reyBlanco) {
                    reyBlancoVivo=true;
                }
                if (c.getPiece().getType() == reyNegro) {
                    reyNegroVivo=true;
                }
            }
        }
        if (reyBlancoVivo && reyNegroVivo){
            return true;
        }
        return false;
    }
    public boolean reyBlancoVivo () {
        Piece.Type reyBlanco = Piece.Type.WHITE_KING;
        for (Cell c : cells.values()) {
            if (!c.isEmpty()){
                if (c.getPiece().getType() == reyBlanco) {
                    return true;
                }
            }

        }
        return false;
    }
    public boolean reyNegroVivo () {
        Piece.Type reyNegro = Piece.Type.BLACK_KING;
        for (Cell c : cells.values()) {
            if (!c.isEmpty()){
                if (c.getPiece().getType() == reyNegro) {
                    return true;
                }
            }
        }
        return false;
    }
    public Cell getCellAt(Coordinate c) {
        if(!contains(c)){
            return null;
        }
        else {
            return cells.get(c);
        }
    }

    public void highLight(Collection<Coordinate> coordinates){
        for (Coordinate c : coordinates)
            getCellAt(c).highlight();
    }
    public void removeHighLight(Collection<Coordinate> coordinates){
        for (Coordinate c:cells.keySet()){
            getCellAt(c).removeHighLight();
        }
    }
    public boolean check(){
        List<Piece> blancas=new ArrayList<>();
        List<Piece> negras=new ArrayList<>();
        Piece.Type reyNegro= Piece.Type.BLACK_KING;
        Piece.Type reyBlanco= Piece.Type.WHITE_KING;
        Coordinate reyNeg=null;
        Coordinate reyBlan=null;
        for (Cell c:cells.values()){
            if (!c.isEmpty()){
                if (c.getPiece().getType()==reyNegro){
                    reyNeg=c.getCoordinate();
                }
                if (c.getPiece().getType()==reyBlanco){
                    reyBlan=c.getCoordinate();
                }
                if (c.getPiece().getColor()==Piece.Color.BLACK){
                    negras.add(c.getPiece());
                }
                if (c.getPiece().getColor()==Piece.Color.WHITE){
                    blancas.add(c.getPiece());
                }
            }
        }
        for (Piece p:negras){
            if (p.canMoveTo(reyBlan)){
                return true;
            }
        }
        for (Piece p:blancas){
            if (p.canMoveTo(reyNeg)){
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        String aux="    A  B  C  D  E  F  G  H\n";
        int row=1;
        int counter=0;
        aux+=" " + row +" ";
        for(Coordinate c: cells.keySet()){
            if (counter%8==0 && counter>=8){
                aux+=" "+row;
                row++;
                aux+="\n";
                aux+=" " + row +" ";
            }
            aux+=cells.get(c);
            counter++;
        }
        aux+=" "+row;
        aux+="\n";
        aux+="    A  B  C  D  E  F  G  H";
        return aux;
    }
    public void inicialice(){
        //Blancos
        Pawn p1Blanco=new Pawn(this,new Coordinate('A',7), Pawn.Type.WHITE);
        Pawn p2Blanco=new Pawn(this,new Coordinate('B',7), Pawn.Type.WHITE);
        Pawn p3Blanco=new Pawn(this,new Coordinate('C',7), Pawn.Type.WHITE);
        Pawn p4Blanco=new Pawn(this,new Coordinate('D',7), Pawn.Type.WHITE);
        Pawn p5Blanco=new Pawn(this,new Coordinate('E',7), Pawn.Type.WHITE);
        Pawn p6Blanco=new Pawn(this,new Coordinate('F',7), Pawn.Type.WHITE);
        Pawn p7Blanco=new Pawn(this,new Coordinate('G',7), Pawn.Type.WHITE);
        Pawn p8Blanco=new Pawn(this,new Coordinate('H',7), Pawn.Type.WHITE);
        Rook t1Blanca=new Rook(this,new Coordinate('A',8), Rook.Type.WHITE);
        Rook t2Blanca=new Rook(this,new Coordinate('H',8), Rook.Type.WHITE);
        Knight k1Blanco=new Knight(this,new Coordinate('B',8), Knight.Type.WHITE);
        Knight k2Blanco=new Knight(this,new Coordinate('G',8), Knight.Type.WHITE);
        Bishop b1Blanco=new Bishop(this,new Coordinate('C',8), Bishop.Type.WHITE);
        Bishop b2Blanco=new Bishop(this,new Coordinate('F',8), Bishop.Type.WHITE);
        King reyBlanco=new King(this,new Coordinate('D',8), King.Type.WHITE);
        Queen reinaBlanca=new Queen(this,new Coordinate('E',8), Queen.Type.WHITE);
        //Negros
        Pawn p1Negro=new Pawn(this,new Coordinate('A',2), Pawn.Type.BLACK);
        Pawn p2Negro=new Pawn(this,new Coordinate('B',2), Pawn.Type.BLACK);
        Pawn p3Negro=new Pawn(this,new Coordinate('C',2), Pawn.Type.BLACK);
        Pawn p4Negro=new Pawn(this,new Coordinate('D',2), Pawn.Type.BLACK);
        Pawn p5Negro=new Pawn(this,new Coordinate('E',2), Pawn.Type.BLACK);
        Pawn p6Negro=new Pawn(this,new Coordinate('F',2), Pawn.Type.BLACK);
        Pawn p7Negro=new Pawn(this,new Coordinate('G',2), Pawn.Type.BLACK);
        Pawn p8Negro=new Pawn(this,new Coordinate('H',2), Pawn.Type.BLACK);
        Rook t1Negro=new Rook(this,new Coordinate('A',1), Rook.Type.BLACK);
        Rook t2Negro=new Rook(this,new Coordinate('H',1), Rook.Type.BLACK);
        Knight k1Negro=new Knight(this,new Coordinate('B',1), Knight.Type.BLACK);
        Knight k2Negro=new Knight(this,new Coordinate('G',1), Knight.Type.BLACK);
        Bishop b1Negro=new Bishop(this,new Coordinate('C',1), Bishop.Type.BLACK);
        Bishop b2Negro=new Bishop(this,new Coordinate('F',1), Bishop.Type.BLACK);
        King reyNegro=new King(this,new Coordinate('D',1), King.Type.BLACK);
        Queen reinaNegra=new Queen(this,new Coordinate('E',1), Queen.Type.BLACK);
    }
}