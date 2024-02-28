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
        jugadorNegro= sc.nextLine();
        Board board=new Board();
        board.inicialice();
        DeletedPieceManagerListImp listaPiezas=new DeletedPieceManagerListImp();
        listaPiezas.getPieceList().addAll(board.getPiezas());
        boolean reyesVivos=true;
        while (reyesVivos){
            System.out.println("------------------------------------------------"+jugadorBlanco+"'turn--------------------------------------------------------------------------");
            System.out.println(board);
            String mov=Input.pedirCoordenada(jugadorBlanco+" tell me the coordinate of the piece you want to move please. Example(G6)");
            Input.movePiece(mov,board);
            if (!board.hayReyes()){
                reyesVivos=false;
            }
            else {
                System.out.println("------------------------------------------------"+jugadorNegro+"'turn--------------------------------------------------------------------------");
                System.out.println(board);
                mov=Input.pedirCoordenada(jugadorNegro+" tell me the coordinate of the piece you want to move please. Example(C3)");
                Input.movePiece(mov,board);
                if (!board.hayReyes()){
                    reyesVivos=false;
                }
            }
        }
        if (!board.reyNegroVivo()){
            System.out.println(jugadorBlanco+" wins");
        }
        if (!board.reyBlancoVivo()){
            System.out.println(jugadorBlanco+" wins");
        }
    }
}
