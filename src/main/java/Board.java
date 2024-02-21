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
        if (cells.containsKey(c)){
            return true;
        }
        return false;
    }
    public Cell getCellAt(Coordinate c) {
        if(!cells.containsKey(c)){
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


    @Override
    public String toString() {
        String aux="    A  B  C  D  E  F  G  H\n";
        int row=1;
        int counter=0;
        for(Coordinate c: cells.keySet()){
            aux+=" " + row +" ";

        }
        aux+="    A  B  C  D  E  F  G  H";
        return aux;
    }
}