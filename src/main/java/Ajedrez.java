import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ajedrez {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String mov;
        Board board=new Board();
        board.inicialice();
        System.out.println(board);
        mov=Input.pedirCoordenada("Tell me the coordinate of the piece you want to move");
        Input.movePiece(mov,board);
    }
}
