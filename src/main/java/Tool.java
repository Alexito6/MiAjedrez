import java.util.Arrays;

public class Tool {

    public static Coordinate[] add(Coordinate coordinate, Coordinate[] array){

        if(coordinate==null) return array;

        Coordinate[] aux = Arrays.copyOf(array,array.length+1);

        aux[aux.length-1]=coordinate;

        return aux;
    }
}
