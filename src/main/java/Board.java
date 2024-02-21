import java.util.Arrays;
import java.util.List;

public class Board {
    private Cell[][] cells;
    public Board(){
        cells = new Cell[8][8];

        for (int row=1;row<= cells.length;row++)
            for(char col='A';col<='H';col++)
                cells[row-1][col-'A']=new Cell(this,new Coordinate(col,row));

    }
    public boolean contains(Coordinate c) {
        if(c.getLetter()<'A' || c.getLetter()>'H') return false;
        if(c.getNumber()<1 || c.getNumber()>8) return false;

        return true;
    }
    public Cell getCellAt(Coordinate c) {
        if(!contains(c)) return null;

        return cells[c.getNumber()-1][c.getLetter()-'A'];
    }
    public void highLight(List<Coordinate> coordinates){
        coordinates.stream().forEach(coordinate -> getCellAt(coordinate).highlight());
    }
    public void highLight(Coordinate[] coordinates){
        highLight(Arrays.asList(coordinates));
    }
    @Override
    public String toString() {
        String aux="    A  B  C  D  E  F  G  H\n";
        int row=1;
        for(Cell[] rowCell : cells){
            aux+=" " + row +" ";
            for(Cell cell : rowCell)
                aux+=cell;
            aux+=" " + row++ + "\n";
        }
        aux+="    A  B  C  D  E  F  G  H";
        return aux;
    }
}