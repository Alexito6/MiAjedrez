import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Input {
    public static void movePiece(String coordenada,Board board){
        Scanner scanner=new Scanner(System.in);
        coordenada=coordenada.toUpperCase();
        while (!Comprobaciones.coordenadaCorrecta(coordenada)){
            System.out.println("That is not a coordinate, give me a correct coordinate");
            coordenada=scanner.nextLine();
        }
        char letter=coordenada.charAt(0);
        int num=coordenada.charAt(1)-48;
        Coordinate piezaAmover=new Coordinate(letter,num);
        while (board.getCellAt(piezaAmover).isEmpty()){
            System.out.println("There is no piece at that coordinate, try again");
            coordenada=scanner.nextLine();
            letter=coordenada.charAt(0);
            num=coordenada.charAt(1)-48;
            piezaAmover= new Coordinate(letter,num);
        }
        Set<Coordinate> coordenadasPosibles=new HashSet<>(board.getCellAt(piezaAmover).getPiece().getNextMovements());
        board.highLight(coordenadasPosibles);
        Output.mostrarTablero(board);
        String newPos=Input.pedirCoordenada("What coordinate do you want to move this piece?");
        newPos=newPos.toUpperCase();
        while (!Comprobaciones.coordenadaCorrecta(newPos)){
            System.out.println("That is not a coordinate, give me a correct coordinate");
            newPos=scanner.nextLine();
        }
        Coordinate newCoordinate=new Coordinate(newPos.charAt(0),newPos.charAt(1)-48);
        if (board.getCellAt(piezaAmover).getPiece().canMoveTo(newCoordinate)){
            board.getCellAt(piezaAmover).getPiece().moveTo(newCoordinate);
        }
        board.removeHighLight(coordenadasPosibles);
        Output.mostrarTablero(board);
    }
    public static String pedirCoordenada(String peticion){
        Scanner scanner=new Scanner(System.in);
        System.out.println(peticion);
        String coordenada=scanner.nextLine();
        coordenada=coordenada.toUpperCase();
        while (!Comprobaciones.coordenadaCorrecta(coordenada)){
            System.out.println("That is not a coordinate, give me a correct coordinate");
            coordenada=scanner.nextLine();
        }
        return coordenada;
    }
}
