import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ajedrez {
    public static void main(String[] args) {
        String jugadorBlanco,jugadorNegro;
        Scanner sc=new Scanner(System.in);
        System.out.println("Please insert the name of the player who will play with the white pieces.");
        jugadorBlanco= sc.nextLine();
        System.out.println("Please insert the name of the player who will play with the black pieces.");
        jugadorBlanco= sc.nextLine();
        Board board=new Board();
        board.inicialice();
        System.out.println(board);
        while (board.hayReyes()){
            System.out.println("------------------------------------------------"+jugadorBlanco+"'turn--------------------------------------------------------------------------");
            String mov;
        }
    }
}
